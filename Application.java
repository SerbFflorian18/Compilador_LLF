import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        // Input con la tupla del NFA
        String input = "( { q0, q1 }, { 0, 1 }, { ( q0, 0 )  = { q0, q1 }, ( q1, 1 ) = { q2 } }, q0, { q2 } )";
        CharStream inputStream = CharStreams.fromString(input);
        NFALexer lexer = new NFALexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NFAParser parser = new NFAParser(tokens);

        // Desactivar la impresión de errores
        parser.removeErrorListeners();

        // Construir el árbol de análisis sintáctico
        ParseTree tree = parser.init();

        // Verificar si la entrada cumple con la gramática
        System.out.println("Comprobando léxico del NFA...");
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Error: La entrada no cumple con la gramática");
            return;
        }

        // Crear un listener para procesar el árbol
        NFABaseListener listener = new NFABaseListener();

        // Caminar por el árbol con el listener para ir obteniendo los datos del NFA
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        List<String> states = listener.getStates();
        System.out.println(states);

        System.out.println(listener.getNFA());

        System.out.println("FINAL");
    }

}