// Generated from /home/milax/Documents/LF/Compilador_LLF/grammar/NFA.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NFAParser}.
 */
public interface NFAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NFAParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(NFAParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(NFAParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAParser#states}.
	 * @param ctx the parse tree
	 */
	void enterStates(NFAParser.StatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#states}.
	 * @param ctx the parse tree
	 */
	void exitStates(NFAParser.StatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAParser#alphabet}.
	 * @param ctx the parse tree
	 */
	void enterAlphabet(NFAParser.AlphabetContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#alphabet}.
	 * @param ctx the parse tree
	 */
	void exitAlphabet(NFAParser.AlphabetContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAParser#relations}.
	 * @param ctx the parse tree
	 */
	void enterRelations(NFAParser.RelationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#relations}.
	 * @param ctx the parse tree
	 */
	void exitRelations(NFAParser.RelationsContext ctx);
}