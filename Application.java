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
    static String NFA = "";
    static List<String> states = new LinkedList<>();
	static List<String> alphabet = new LinkedList<>();
	static HashMap<HashMap<String, String>, Set<String>> relations = new HashMap<>();
	static String initial = "";
	static List<String> finals = new LinkedList<>();

    static String title = "";

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println();

        // Pedir tupla del NFA
        System.out.println("Introduce el NFA, siguiendo el siguiente esquema:");
        System.out.println(PURPLE + "\t({q0, q1...}, {c0, c1...), {(qi, ci) = {qi, qy...}...}, qi, {qi, qy...})" + RESET);
        System.out.println("\tPara las transiciones nulas utiliza este simbolo: " + PURPLE + "ε" + RESET);
        String input = scanner.nextLine();
        CharStream inputStream = CharStreams.fromString(input);
        
        // Inicializar Lexer y Parser
        NFALexer lexer = new NFALexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NFAParser parser = new NFAParser(tokens);

        // Desactivar la impresión de errores
        parser.removeErrorListeners();

        // Construir el árbol de análisis sintáctico
        ParseTree tree = parser.nfa();

        // Verificar si la entrada cumple con la gramática
        System.out.println("\nComprobando léxico del NFA...");
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
        try (FileWriter writer = new FileWriter(title + ".tex")) {
            writer.write(latexCode);
        } catch (IOException e) {}

        // Convertir el .tex en un .pdf (compilar con pdflatex)
        convertLatexToPdf(title + ".tex");
    }

    /**
     * Función para guardar todos los datos del NFA usando las funciones del NFABaseListener
     * @param listener
     */
    public static void obtenerDatosNFA(NFABaseListener listener) {
        // Pedir nombre del NFA, que será el nombre del PDF
        System.out.print("\nIntroduce el nombre del NFA (sin carácteres especiales): ");
        title = scanner.nextLine();
        if (title == null || title == "") title = "NFA";
        else title = title.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

        // Guardar datos en diferentes variables
        NFA = listener.getNFA();
        states = listener.getStates();
        alphabet = listener.getAlphabet();
        relations = listener.getRelations();
        initial = listener.getInitial();
        finals = listener.getFinals();

        // Imprimir datos
        System.out.println("Datos del NFA:");
        System.out.println("\tNombre " + PURPLE + title + RESET);
        System.out.println("\tEstados " + PURPLE + states + RESET);
        System.out.println("\tAlfabeto " + PURPLE + alphabet + RESET);
        System.out.println("\tRelaciones " + PURPLE + relations + RESET);
        System.out.println("\tEstado inicial " + PURPLE + initial + RESET);
        System.out.println("\tEstados finales " + PURPLE + finals + RESET);
    }
    
    /**
     * Función para generar todo el código del fichero .tex que dibujará el NFA
     * @return String
     */
    public static String generateLatexCode() {
        StringBuilder latexCode = new StringBuilder();
        
        // Iniciar documento LaTeX
        latexCode.append("\\documentclass{article}\n");
        latexCode.append("\\usepackage{tikz}\n");
        latexCode.append("\\usetikzlibrary{automata, positioning, arrows}\n");
        latexCode.append("\\DeclareUnicodeCharacter{03B5}{\\ensuremath{\\epsilon}}\n");
        latexCode.append("\\definecolor{urvred}{RGB}{143,42,43}\n");
        latexCode.append("\\tikzset{->, >=stealth, node distance=2.8cm, every state/.style={thick, fill=urvred!30}, initial text=$ $}\n");
        latexCode.append("\\begin{document}\n");
        latexCode.append("\\center \\LARGE \\textbf{" + title + "}\n");
        latexCode.append("\\vspace{0.2cm}\n");
        String NFAaux = "(" + states + ", " + alphabet + ", R, " + initial + ", " + finals + ")";
        NFAaux = NFAaux.replace("[", "\\{").replace("]", "\\}");
        latexCode.append("\\center \\small \\textcolor{urvred}{" + NFAaux + "}\n");
        latexCode.append("\\center \\small Relaciones (R):\n");
        for (HashMap.Entry<HashMap<String, String>, Set<String>> entry : relations.entrySet()) {
            HashMap<String, String> relation = entry.getKey();
            String destinationStates = entry.getValue().toString().replace("[", "\\{").replace("]", "\\}");
            String originState = relation.keySet().iterator().next();
            String symbol = relation.get(originState);
            latexCode.append("\\center \\scriptsize \\textcolor{urvred}{(" + originState + ", " + symbol + ") = " + destinationStates + "}\n");
        }
        latexCode.append("\\vspace{1.5cm}\n");
        latexCode.append("\\begin{figure}[h!]\n");
        latexCode.append("  \\centering\n");
        latexCode.append("  \\begin{tikzpicture}\n");

        // Agregar estados
        String ant = null;
        int i = 0;
        boolean right = true;
        for (String state : states) {
            String pos = "";
            if (i != 0 && i % 2 != 0) {
                if (right) {
                    pos = "right of=" + ant;
                }
                else pos = "left of=" + ant;
                right = !right;
            } else {
                if (i % 4 == 2) pos = "below of=" + ant + ", xshift=1.5cm";
                else if (i % 4 == 0) pos = "below of=" + ant + ", xshift=-1.5cm";
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
        for (HashMap.Entry<HashMap<String, String>, Set<String>> entry : relations.entrySet()) {
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
                ProcessBuilder builder = new ProcessBuilder("pdflatex", latexFile);
                Process process = builder.start();
    
                // Esperar a que el proceso termine
                if (process.waitFor() == 0) {
                    System.out.println(GREEN + "El archivo PDF se ha generado correctamente\n" + RESET);
                } else {
                    System.out.println(RED + "Se ha producido un error al generar el archivo PDF\n" + RESET);
                }
            } catch (IOException e) { 
                System.out.println(RED + "Ha surgido un error en el proceso\n" + RESET);
            } catch (InterruptedException e) {}
        });

        // Iniciar ejecución del Thread
        latexThread.start();
        // Intentar interrumpir la ejecución pasados 5 segundos
        latexThread.join(5000);

        // Si no se ha podido interrumpir significa que se ha quedado pillado en el pdflatex, y por lo tanto, hay algun error en el NFA
        if (latexThread.isAlive()) {
            System.out.println(RED + "El proceso está tardando más de lo esperado o ha habido algun error. Comprueba que no hayan relaciones con estados inexistentes u otros problemas similares\n" + RESET);
            latexThread.interrupt();
        }

        // Eliminar ficheros auxiliares
        ProcessBuilder builder = new ProcessBuilder("bash", "-c", "rm *.aux *.log *.tex");
        try {
            builder.start();
        } catch (IOException e) {
            System.out.println(RED + "Algo ha salido mal al intentar eliminar los ficheros auxiliares (.aux .log .tex)" + RESET);
        }
    }

}