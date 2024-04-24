import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Application {

    public static void main(String[] args) {

        // Input con la tupla del NFA
        String input = "( { q0, q1 }, { 0, 1 }, { ( q0, 0 ) = { q0, q1 }, ( q1, 1 ) = { q2 } }, q0, { q2 } )";
        CharStream inputStream = CharStreams.fromString(input);

        //
        NFALexer lexer = new NFALexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NFAParser parser = new NFAParser(tokens);

        ParseTree tree = parser.init();

        NFABaseListener listener = new NFABaseListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        System.out.println("FINAL");
    }

}