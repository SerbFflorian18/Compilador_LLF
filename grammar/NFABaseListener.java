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

	// Datos del NFA
	String NFA;																			// Tupla entera del NFA
	List<String> states = new LinkedList<>();											// Lista con los estados
	List<String> alphabet = new LinkedList<>();											// Lista con los carácteres del alfabeto
	HashMap<HashMap<String, String>, HashSet<String>> relations = new HashMap<>();		// Hashmap con las transiciones
	String initial;																		// Estado inicial
	List<String> finals = new LinkedList<>();											// Lista con los estados finales

	// NFA completo
	@Override public void enterNfa(NFAParser.NfaContext ctx) { alphabet.add("ε"); NFA = ctx.getText(); }
	@Override public void exitNfa(NFAParser.NfaContext ctx) { }
	public String getNFA() { return NFA; }

	// Estados del primer elemento de la tupla
	@Override public void enterAllstates(NFAParser.AllstatesContext ctx) { 
		for (String state: ctx.states().getText().split(",")) {
			if (!states.contains(state)) states.add(state);
		}
	}
	@Override public void exitAllstates(NFAParser.AllstatesContext ctx) { }
	public List<String> getStates() { return states; }

	// Alfabeto
	@Override public void enterAlphabet(NFAParser.AlphabetContext ctx) {
		String symbol = ctx.CHAR().getText();
		if (!alphabet.contains(symbol)) alphabet.add(symbol); 
	}
	@Override public void exitAlphabet(NFAParser.AlphabetContext ctx) { }
	public List<String> getAlphabet() { return alphabet; }

	// Transiciones
	@Override public void enterTransitions(NFAParser.TransitionsContext ctx) { }
	@Override public void exitTransitions(NFAParser.TransitionsContext ctx) { }

	// Estado inicial
	@Override public void enterInitial(NFAParser.InitialContext ctx) { initial = ctx.getText(); }
	@Override public void exitInitial(NFAParser.InitialContext ctx) { }
	public String getInitial() { return initial; }

	// Estados finales
	@Override public void enterFinals(NFAParser.FinalsContext ctx) { 
		for (String state: ctx.states().getText().split(",")) {
			if (!finals.contains(state)) finals.add(state);
		}
	}
	@Override public void exitFinals(NFAParser.FinalsContext ctx) { }
	public List<String> getFinals() { return finals; }

	// Estados de toda la tupla
	@Override public void enterStates(NFAParser.StatesContext ctx) { }
	@Override public void exitStates(NFAParser.StatesContext ctx) { }

	// Transición
	@Override public void enterTransition(NFAParser.TransitionContext ctx) { 
		// Inicializar clave Hashmap
		HashMap<String, String> rel = new HashMap<>();
		// Guardar símbolo (si no pertenece al alfabeto pasa a ser epsilon)
		String symbol = alphabet.contains(ctx.CHAR().getText()) ? ctx.CHAR().getText() : "ε";
		// Guardar clave como un Hashmap del estado inicial y del símbolo
		rel.put(ctx.STATE().getText(), symbol);
		// Guardar conjunto de estados finales
		HashSet<String> states = new HashSet<>();
		for (String state: ctx.states().getText().split(",")) states.add(state);
		// Si ya existía una transición con esta clave, añadir al conjunto anterior los que ya estaban en el Hashmap
		if (relations.containsKey(rel)) states.addAll(relations.get(rel));
		relations.put(rel, states);
	}
	@Override public void exitTransition(NFAParser.TransitionContext ctx) { }
	public HashMap<HashMap<String, String>, HashSet<String>> getTransitions() { return relations; }


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