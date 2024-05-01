import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.util.*;

public class Application {

    // Códigos de escape ANSI para cambiar el color del texto en la terminal
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    // Datos del NFA
    static String name = "";
    static String NFA = "";
    static List<String> states = new LinkedList<>();
	static List<String> alphabet = new LinkedList<>();
	static HashMap<HashMap<String, String>, HashSet<String>> relations = new HashMap<>();
	static String initial = "";
	static List<String> finals = new LinkedList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println();

        // Imprimir requerimientos y pedir tupla del NFA
        System.out.println("Bienvenido/a a la gramática NFA!");
        System.out.println(PURPLE + "Requerimientos:" + RESET);
        System.out.println("   1. El nombre de los estados (STATE) debe tener mínimo dos carácteres para diferenciarse de los elementos (CHAR) del alfabeto");
        System.out.println("   2. Si en las transiciones o estados inicial y finales hay algun estado no especificado en el primer conjunto de estados, la gramática \n" + //
        "      lo aceptará pero dará errores después al compilar con LaTex");
        System.out.println("   3. Si en las transiciones se usa un carácter no especificado en el alfabeto, este se convertirá en una epsilon (ε)");
        System.out.println("   4. Para las transiciones nulas utiliza este simbolo: " + PURPLE + "ε" + RESET);
        System.out.print("   5. Introduce el NFA, siguiendo el siguiente esquema:");
        System.out.println(PURPLE + " ({q0, q1...}, {c0, c1...), {(qi, ci) = {qi, qy...}...}, qi, {qi, qy...})" + RESET);
        System.out.print("\nNFA: " + CYAN);
        CharStream inputStream = CharStreams.fromString(scanner.nextLine());
        
        // Inicializar Lexer y Parser
        NFALexer lexer = new NFALexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NFAParser parser = new NFAParser(tokens);

        // Desactivar la impresión de errores
        parser.removeErrorListeners();

        // Construir el árbol de análisis sintáctico
        ParseTree tree = parser.nfa();

        // Verificar si la entrada cumple con la gramática
        System.out.println(RESET + "\nComprobando léxico del NFA...");
        Thread.sleep(1000);
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println(RED + "Error: La entrada no cumple con la gramática de un NFA\n" + RESET);
            return;
        } else System.out.println(GREEN + "Entrada correcta!" + RESET);

        // Crear un listener para procesar el árbol
        NFABaseListener listener = new NFABaseListener();

        // Caminar por el árbol con el listener para ir obteniendo los datos del NFA
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
        obtenerDatosNFA(listener);

        // Generar código LaTex a partir de los datos del NFA y crear fichero .tex
        String latexCode = generateLatexCode();
        try (FileWriter writer = new FileWriter(name + ".tex")) {
            writer.write(latexCode);
        } catch (IOException e) {}

        // Convertir el .tex en un .pdf (compilar con pdflatex)
        convertLatexToPdf(name + ".tex");
    }

    /**
     * Función para guardar todos los datos del NFA usando las funciones del NFABaseListener
     * @param listener
     */
    public static void obtenerDatosNFA(NFABaseListener listener) {
        // Pedir nombre del NFA
        System.out.print("\nIntroduce el nombre del NFA (sin carácteres especiales): ");
        name = scanner.nextLine();
        if (name == null || name == "") name = "NFA";
        else name = name.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

        // Guardar datos en diferentes variables
        NFA = listener.getNFA();
        states = listener.getStates();
        alphabet = listener.getAlphabet();
        relations = listener.getTransitions();
        initial = listener.getInitial();
        finals = listener.getFinals();

        // Imprimir datos
        System.out.println("Datos del NFA:");
        System.out.println("   Nombre " + PURPLE + name + RESET);
        System.out.println("   Estados " + PURPLE + states + RESET);
        System.out.println("   Alfabeto " + PURPLE + alphabet + RESET);
        System.out.println("   Relaciones " + PURPLE + relations + RESET);
        System.out.println("   Estado inicial " + PURPLE + initial + RESET);
        System.out.println("   Estados finales " + PURPLE + finals + RESET);
    }
    
    /**
     * Función para generar el código LaTex del fichero .tex, que dibujará el NFA
     * @return String
     */
    public static String generateLatexCode() {
        StringBuilder latexCode = new StringBuilder();
        
        // Iniciar documento LaTeX con toda la información del NFA
        latexCode.append("\\documentclass{article}\n");
        latexCode.append("\\usepackage{tikz}\n");
        latexCode.append("\\usetikzlibrary{automata, positioning, arrows}\n");
        latexCode.append("\\DeclareUnicodeCharacter{03B5}{\\ensuremath{\\epsilon}}\n");
        latexCode.append("\\tikzset{->, >=stealth, node distance=2.2cm, every state/.style={thick, fill=gray!20}, initial text=$ $}\n");
        latexCode.append("\\begin{document}\n");
        latexCode.append("\\center \\LARGE \\textbf{" + name + "}\n");
        latexCode.append("\\vspace{0.2cm}\n");
        String NFAaux = "(" + states + ", " + alphabet + ", \\textit{R}, " + initial + ", " + finals + ")";
        NFAaux = NFAaux.replace("[", "\\{").replace("]", "\\}");
        latexCode.append("\\center \\normalsize " + NFAaux + "\n");
        latexCode.append("\\vspace{0.3cm}\n");
        latexCode.append("\\center \\normalsize Relaciones \\textit{R}:\n");
        latexCode.append("\\begin{table}[h]\n");
        latexCode.append("\\centering\n");
        latexCode.append("\\small\n");
        latexCode.append("\\setlength{\\tabcolsep}{15pt}\n");
        latexCode.append("\\renewcommand{\\arraystretch}{1.5}\n");
        latexCode.append("\\begin{tabular}{ccc}\n");
        int i = 0;
        for (HashMap.Entry<HashMap<String, String>, HashSet<String>> entry : relations.entrySet()) {
            HashMap<String, String> relation = entry.getKey();
            String destinationStates = entry.getValue().toString().replace("[", "\\{").replace("]", "\\}");
            String originState = relation.keySet().iterator().next();
            String symbol = relation.get(originState);
            switch (i) {
                case 0:
                    latexCode.append("(" + originState + ", " + symbol + ") = " + destinationStates);
                    break;
                case 1:
                    latexCode.append(" & (" + originState + ", " + symbol + ") = " + destinationStates);
                    break;
                case 2:
                    latexCode.append(" & (" + originState + ", " + symbol + ") = " + destinationStates + " \\\\ \n");
                default: break;
            }
            i = (i+1) % 3;
        }
        latexCode.append("\\end{tabular}\n");
        latexCode.append("\\end{table}\n");
        latexCode.append("\\vspace{1cm}\n");
        latexCode.append("\\begin{figure}[h!]\n");
        latexCode.append("  \\centering\n");
        latexCode.append("  \\begin{tikzpicture}\n");

        // Agregar estados (de forma que coincidan las menores lineas posibles)
        // La idea es que tenga siempre la misma forma de serpiente, en la que se van añadiendo los estados por orden de aparición en el primer elemento de la tupla
        // Por ejemplo, con los estados {q1, q2, q3, q4, q5} la estructura seria:
        //                   q1----------q2-----|
        //                                      |
        //                   |-----q4----------q3
        //                   |
        //                  q5          
        i = 0;
        String ant = null;
        boolean right = true;
        for (String state : states) {
            String pos = "";
            if (i != 0 && i % 2 != 0) {
                if (right) pos = "right=2.5cm of " + ant;
                else pos = "left=2.5cm of " + ant;
                right = !right;
            } else {
                if (i % 4 == 2) pos = "below of=" + ant + ", xshift=1.8cm";
                else if (i % 4 == 0) pos = "below of=" + ant + ", xshift=-1.8cm";
            }
            latexCode.append("      \\node[state");
            if (initial.equals(state)) latexCode.append(",initial");
            if (finals.contains(state)) latexCode.append(",accepting");
            if (ant != null) latexCode.append("," + pos);
            latexCode.append("] (" + state + ") {" + state + "};\n");
            ant = state;
            i++;
        }

        // Agregar relaciones
        latexCode.append("      \\draw");
        for (HashMap.Entry<HashMap<String, String>, HashSet<String>> entry : relations.entrySet()) {
            HashMap<String, String> relation = entry.getKey();
            Set<String> destinationStates = entry.getValue();
            String originState = relation.keySet().iterator().next();
            String symbol = relation.get(originState);
            i = states.indexOf(originState);
            for (String destinationState : destinationStates) {
                String edge = "";
                if (originState.equals(destinationState)) {
                    if (i >= 2 && i % 2 == 0) edge = "loop right";
                    else if (i >= 2 && i % 2 != 0) edge = "loop left";
                    else edge = "loop above";
                } else {
                    edge = "bend left, above";
                }
                latexCode.append("\n             (" + originState + ") edge[" + edge + "] node{" + symbol + "} (" + destinationState + ")");
            }
        }
        latexCode.append(";\n");

        // Finalizar documento LaTeX
        latexCode.append("  \\end{tikzpicture}\n");
        latexCode.append("\\end{figure}\n");
        latexCode.append("\\end{document}");

        return latexCode.toString();
    }

    /**
     * Función para obtener el PDF a partir del fichero .tex
     * @param latexFile
     * @throws InterruptedException
     */
    public static void convertLatexToPdf(String latexFile) throws InterruptedException {
        System.out.println("\nGenerando archivo PDF...");
        Thread.sleep(1000);

        // Crear Thread para la ejecución del pdflatex
        Thread latexThread = new Thread(() -> {
            try {
                // Ejecutar pdflatex para convertir el archivo .tex en .pdf
                ProcessBuilder builder = new ProcessBuilder();
                if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                    // Si es Windows
                    builder.command("cmd.exe", "/c", "pdflatex", latexFile);
                } else {
                    // Si es Linux / Unix / MacOS
                    builder.command("pdflatex", latexFile);
                }
                Process process = builder.start();
    
                // Esperar a que el proceso termine
                if (process.waitFor() == 0) {
                    System.out.println(GREEN + "El archivo PDF se ha generado correctamente\n" + RESET);
                } else {
                    System.out.println(RED + "Se ha producido un error al generar el archivo PDF\n" + RESET);
                }
            } catch (IOException e) { 
                System.out.println(RED + "Se ha producido un error en el proceso\n" + RESET);
            } catch (InterruptedException e) {}
        });

        // Iniciar ejecución del Thread
        latexThread.start();
        // Intentar interrumpir la ejecución pasados 5 segundos
        latexThread.join(5000);

        // Si no se ha podido interrumpir significa que se ha quedado esperando en el pdflatex, y por lo tanto, hay algun error en el NFA
        if (latexThread.isAlive()) {
            System.out.println(RED + "El proceso está tardando más de lo esperado o ha habido algun error. Comprueba que no hayan relaciones con estados inexistentes u otros problemas similares\n" + RESET);
            latexThread.interrupt();
        }

        // Eliminar ficheros auxiliares
        ProcessBuilder builder = null;
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            // Si es Windows
            builder = new ProcessBuilder("cmd.exe", "/c", "del *" + name + ".aux *" + name + ".log *" + name + ".tex");
        } else {
            // Si es Linux / Unix / MacOS
            builder = new ProcessBuilder("bash", "-c", "rm *" + name + ".aux *" + name + ".log *" + name + ".tex");
        }
        try {
            builder.start();
        } catch (IOException e) {
            System.out.println(RED + "Algo ha salido mal al intentar eliminar los ficheros auxiliares (.aux .log .tex)" + RESET);
        }

        // Abrir pdf automáticamente
        System.out.println("Abriendo PDF...");
        Thread.sleep(1000);
        builder = null;
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            // Si es Windows
            builder = new ProcessBuilder("cmd.exe", "/c", "start", name + ".pdf");
        } else {
            // Si es Linux / Unix / MacOS
            builder = new ProcessBuilder("xdg-open", name + ".pdf");
        }
        try {
            builder.start();
        } catch (IOException e) {
            System.out.println(RED + "Algo ha salido mal al intentar abrir el archivo PDF" + RESET);
        }
    }

}