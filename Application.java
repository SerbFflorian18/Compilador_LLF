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

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println();

        // Input con la tupla del NFA
        System.out.println("Introduce el NFA. Tiene que ser de la forma:");
        System.out.println("\t({q0, q1...}, {c0, c1...), {(qi, ci) = {qi, qy...}...}, qi, {qi, qy...})");
        String input = scanner.nextLine();
        CharStream inputStream = CharStreams.fromString(input);
        
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

        String latexCode = generateLatexCode();

        try (FileWriter writer = new FileWriter("nfa.tex")) {
            writer.write(latexCode);
        } catch (IOException e) {}

        convertLatexToPdf("nfa.tex");
    }

    public static void obtenerDatosNFA(NFABaseListener listener) {
        // Guardar datos en diferentes variables
        NFA = listener.getNFA();
        states = listener.getStates();
        alphabet = listener.getAlphabet();
        relations = listener.getRelations();
        initial = listener.getInitial();
        finals = listener.getFinals();
        // Imprimir datos
        System.out.println("\nDatos del NFA:");
        System.out.println(NFA);
        System.out.println("\tEstados " + PURPLE + states + RESET);
        System.out.println("\tAlfabeto " + PURPLE + alphabet + RESET);
        System.out.println("\tRelaciones " + PURPLE + relations + RESET);
        System.out.println("\tEstado inicial " + PURPLE + initial + RESET);
        System.out.println("\tEstados finales " + PURPLE + finals + RESET);
    }
    
    public static String generateLatexCode() {
        StringBuilder latexCode = new StringBuilder();
        
        // Iniciar documento LaTeX
        latexCode.append("\\documentclass{article}\n");
        latexCode.append("\\usepackage{tikz}\n");
        latexCode.append("\\usetikzlibrary{automata, positioning, arrows}\n");
        latexCode.append("\\tikzset{->, >=stealth, node distance=3cm, every state/.style={thick, fill=gray!20}, initial text=$ $}\n");
        latexCode.append("\\begin{document}\n");
        latexCode.append("\\begin{center}\n");
        latexCode.append("\\LARGE \\textbf{NFA}\n");
        latexCode.append("\\end{center}\n");
        latexCode.append("\\begin{center}\n");
        latexCode.append("\\small \\textit{" + NFA.replace("{", "\\{").replace("}", "\\}") + "}\n");
        latexCode.append("\\end{center}\n");
        latexCode.append("\\vspace{1.5cm}\n");
        latexCode.append("\\begin{figure}[h!]\n");
        latexCode.append("  \\centering\n");
        latexCode.append("  \\begin{tikzpicture}\n");

        // Agregar estados
        String ant = null;
        for (String state : states) {
            latexCode.append("      \\node[state");
            if (initial.equals(state)) {
                latexCode.append(",initial");
            }
            if (finals.contains(state)) {
                latexCode.append(",accepting");
            }
            if (ant != null) {
                latexCode.append(",right of=" + ant);
            }
            latexCode.append("] (" + state + ") {" + state + "};\n");
            ant = state;
        }

        // Agregar transiciones
        latexCode.append("      \\draw  ");
        for (HashMap.Entry<HashMap<String, String>, Set<String>> entry : relations.entrySet()) {
            HashMap<String, String> relation = entry.getKey();
            Set<String> destinationStates = entry.getValue();
            String originState = relation.keySet().iterator().next();
            String symbol = relation.get(originState);
            for (String destinationState : destinationStates) {
                String edge = "";
                if (originState.equals(destinationState)) edge = "loop above";
                else edge = "bend left, above";
                latexCode.append("             (" + originState + ") edge[" + edge + "] node{" + symbol + "} (" + destinationState + ")\n");
            }
        }
        latexCode.append(";");

        // Finalizar documento LaTeX
        latexCode.append("  \\end{tikzpicture}\n");
        latexCode.append("\\end{figure}\n");
        latexCode.append("\\end{document}");

        return latexCode.toString();
    }

    public static void convertLatexToPdf(String latexFile) throws InterruptedException {
        System.out.println("\nGenerando archivo PDF...");
        Thread.sleep(1000);
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

            // Eliminar ficheros auxiliares
            builder = new ProcessBuilder("bash", "-c", "rm *.aux *.log");
            builder.start();
        } catch (IOException | InterruptedException e) {
            System.out.println(RED + "Ha surgido un error en el proceso\n" + RESET);
        }
    }

}