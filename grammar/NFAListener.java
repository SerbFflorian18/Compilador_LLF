// Generated from NFA.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NFAParser}.
 */
public interface NFAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NFAParser#nfa}.
	 * @param ctx the parse tree
	 */
	void enterNfa(NFAParser.NfaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#nfa}.
	 * @param ctx the parse tree
	 */
	void exitNfa(NFAParser.NfaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAParser#allstates}.
	 * @param ctx the parse tree
	 */
	void enterAllstates(NFAParser.AllstatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#allstates}.
	 * @param ctx the parse tree
	 */
	void exitAllstates(NFAParser.AllstatesContext ctx);
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
	 * Enter a parse tree produced by {@link NFAParser#transitions}.
	 * @param ctx the parse tree
	 */
	void enterTransitions(NFAParser.TransitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#transitions}.
	 * @param ctx the parse tree
	 */
	void exitTransitions(NFAParser.TransitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAParser#initial}.
	 * @param ctx the parse tree
	 */
	void enterInitial(NFAParser.InitialContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#initial}.
	 * @param ctx the parse tree
	 */
	void exitInitial(NFAParser.InitialContext ctx);
	/**
	 * Enter a parse tree produced by {@link NFAParser#finals}.
	 * @param ctx the parse tree
	 */
	void enterFinals(NFAParser.FinalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#finals}.
	 * @param ctx the parse tree
	 */
	void exitFinals(NFAParser.FinalsContext ctx);
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
	 * Enter a parse tree produced by {@link NFAParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(NFAParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NFAParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(NFAParser.TransitionContext ctx);
}