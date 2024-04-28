// Generated from NFA.g4 by ANTLR 4.13.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

/**
 * This class provides an empty implementation of {@link NFAListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
@SuppressWarnings("CheckReturnValue")
public class NFABaseListener implements NFAListener {

	String NFA;
	List<String> states = new LinkedList<>();
	List<String> alphabet = new LinkedList<>();
	HashMap<HashMap<String, String>, Set<String>> relations = new HashMap<>();
	String initial;
	List<String> finals = new LinkedList<>();

	// NFA complet
	@Override public void enterNfa(NFAParser.NfaContext ctx) { NFA = ctx.getText(); }
	@Override public void exitNfa(NFAParser.NfaContext ctx) { }
	public String getNFA() { return NFA; }

	// Estats
	@Override public void enterAllstates(NFAParser.AllstatesContext ctx) { 
		for (String state: ctx.states().getText().split(",")) {
			if (!states.contains(state)) states.add(state);
		}
	}
	@Override public void exitAllstates(NFAParser.AllstatesContext ctx) { }
	public List<String> getStates() { return states; }

	// Alfabet
	@Override public void enterAlphabet(NFAParser.AlphabetContext ctx) {
		String symbol = ctx.CHAR().getText();
		if (!alphabet.contains(symbol)) alphabet.add(symbol); 
	}
	@Override public void exitAlphabet(NFAParser.AlphabetContext ctx) { }
	public List<String> getAlphabet() { return alphabet; }

	@Override public void enterRelations(NFAParser.RelationsContext ctx) { }
	@Override public void exitRelations(NFAParser.RelationsContext ctx) { }

	// Estat inicial
	@Override public void enterInitial(NFAParser.InitialContext ctx) { initial = ctx.getText(); }
	@Override public void exitInitial(NFAParser.InitialContext ctx) { }
	public String getInitial() { return initial; }

	// Estats finals
	@Override public void enterFinals(NFAParser.FinalsContext ctx) { 
		for (String state: ctx.states().getText().split(",")) {
			if (!finals.contains(state)) finals.add(state);
		}
	}
	@Override public void exitFinals(NFAParser.FinalsContext ctx) { }
	public List<String> getFinals() { return finals; }

	@Override public void enterStates(NFAParser.StatesContext ctx) { }
	@Override public void exitStates(NFAParser.StatesContext ctx) { }

	// Relació
	@Override public void enterRelation(NFAParser.RelationContext ctx) { 
		HashMap<String, String> rel = new HashMap<>();
		rel.put(ctx.STATE().getText(), ctx.CHAR().getText());
		relations.put(rel, Set.of(ctx.states().getText().split(",")));
	}
	@Override public void exitRelation(NFAParser.RelationContext ctx) { }
	public HashMap<HashMap<String, String>, Set<String>> getRelations() { return relations; }


	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}