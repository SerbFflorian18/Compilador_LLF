// Generated from /home/milax/Documents/LF/Compilador_LLF/grammar/NFA.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NFAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, STATE=7, CHAR=8, WS=9;
	public static final int
		RULE_nfa = 0, RULE_allstates = 1, RULE_alphabet = 2, RULE_transitions = 3, 
		RULE_initial = 4, RULE_finals = 5, RULE_states = 6, RULE_transition = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"nfa", "allstates", "alphabet", "transitions", "initial", "finals", "states", 
			"transition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'{'", "'}'", "','", "')'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "STATE", "CHAR", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NFA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NFAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NfaContext extends ParserRuleContext {
		public AllstatesContext allstates() {
			return getRuleContext(AllstatesContext.class,0);
		}
		public AlphabetContext alphabet() {
			return getRuleContext(AlphabetContext.class,0);
		}
		public TransitionsContext transitions() {
			return getRuleContext(TransitionsContext.class,0);
		}
		public InitialContext initial() {
			return getRuleContext(InitialContext.class,0);
		}
		public FinalsContext finals() {
			return getRuleContext(FinalsContext.class,0);
		}
		public NfaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nfa; }
	}

	public final NfaContext nfa() throws RecognitionException {
		NfaContext _localctx = new NfaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_nfa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(T__0);
			setState(17);
			match(T__1);
			setState(18);
			allstates();
			setState(19);
			match(T__2);
			setState(20);
			match(T__3);
			setState(21);
			match(T__1);
			setState(22);
			alphabet();
			setState(23);
			match(T__2);
			setState(24);
			match(T__3);
			setState(25);
			match(T__1);
			setState(26);
			transitions(0);
			setState(27);
			match(T__2);
			setState(28);
			match(T__3);
			setState(29);
			initial();
			setState(30);
			match(T__3);
			setState(31);
			match(T__1);
			setState(32);
			finals();
			setState(33);
			match(T__2);
			setState(34);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AllstatesContext extends ParserRuleContext {
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public AllstatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allstates; }
	}

	public final AllstatesContext allstates() throws RecognitionException {
		AllstatesContext _localctx = new AllstatesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_allstates);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			states();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AlphabetContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(NFAParser.CHAR, 0); }
		public AlphabetContext alphabet() {
			return getRuleContext(AlphabetContext.class,0);
		}
		public AlphabetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alphabet; }
	}

	public final AlphabetContext alphabet() throws RecognitionException {
		AlphabetContext _localctx = new AlphabetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_alphabet);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(CHAR);
				setState(39);
				match(T__3);
				setState(40);
				alphabet();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(CHAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TransitionsContext extends ParserRuleContext {
		public TransitionContext transition() {
			return getRuleContext(TransitionContext.class,0);
		}
		public List<TransitionsContext> transitions() {
			return getRuleContexts(TransitionsContext.class);
		}
		public TransitionsContext transitions(int i) {
			return getRuleContext(TransitionsContext.class,i);
		}
		public TransitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitions; }
	}

	public final TransitionsContext transitions() throws RecognitionException {
		return transitions(0);
	}

	private TransitionsContext transitions(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TransitionsContext _localctx = new TransitionsContext(_ctx, _parentState);
		TransitionsContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_transitions, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(45);
			transition();
			}
			_ctx.stop = _input.LT(-1);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TransitionsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_transitions);
					setState(47);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(48);
					match(T__3);
					setState(49);
					transitions(3);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitialContext extends ParserRuleContext {
		public TerminalNode STATE() { return getToken(NFAParser.STATE, 0); }
		public InitialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial; }
	}

	public final InitialContext initial() throws RecognitionException {
		InitialContext _localctx = new InitialContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_initial);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(STATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FinalsContext extends ParserRuleContext {
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public FinalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finals; }
	}

	public final FinalsContext finals() throws RecognitionException {
		FinalsContext _localctx = new FinalsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_finals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			states();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatesContext extends ParserRuleContext {
		public TerminalNode STATE() { return getToken(NFAParser.STATE, 0); }
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_states);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(STATE);
				setState(60);
				match(T__3);
				setState(61);
				states();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(STATE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TransitionContext extends ParserRuleContext {
		public TerminalNode STATE() { return getToken(NFAParser.STATE, 0); }
		public TerminalNode CHAR() { return getToken(NFAParser.CHAR, 0); }
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_transition);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(T__0);
				setState(66);
				match(STATE);
				setState(67);
				match(T__3);
				setState(68);
				match(CHAR);
				setState(69);
				match(T__4);
				setState(70);
				match(T__5);
				setState(71);
				match(T__1);
				setState(72);
				states();
				setState(73);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(T__0);
				setState(76);
				match(STATE);
				setState(77);
				match(T__3);
				setState(78);
				match(CHAR);
				setState(79);
				match(T__4);
				setState(80);
				match(T__5);
				setState(81);
				match(T__1);
				setState(82);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return transitions_sempred((TransitionsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean transitions_sempred(TransitionsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\tV\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002+\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u00033\b\u0003\n\u0003"+
		"\f\u00036\t\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006@\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007T\b\u0007\u0001\u0007\u0000\u0001\u0006\b\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0000\u0000Q\u0000\u0010\u0001\u0000\u0000\u0000\u0002$\u0001"+
		"\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u0006,\u0001\u0000\u0000"+
		"\u0000\b7\u0001\u0000\u0000\u0000\n9\u0001\u0000\u0000\u0000\f?\u0001"+
		"\u0000\u0000\u0000\u000eS\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0001"+
		"\u0000\u0000\u0011\u0012\u0005\u0002\u0000\u0000\u0012\u0013\u0003\u0002"+
		"\u0001\u0000\u0013\u0014\u0005\u0003\u0000\u0000\u0014\u0015\u0005\u0004"+
		"\u0000\u0000\u0015\u0016\u0005\u0002\u0000\u0000\u0016\u0017\u0003\u0004"+
		"\u0002\u0000\u0017\u0018\u0005\u0003\u0000\u0000\u0018\u0019\u0005\u0004"+
		"\u0000\u0000\u0019\u001a\u0005\u0002\u0000\u0000\u001a\u001b\u0003\u0006"+
		"\u0003\u0000\u001b\u001c\u0005\u0003\u0000\u0000\u001c\u001d\u0005\u0004"+
		"\u0000\u0000\u001d\u001e\u0003\b\u0004\u0000\u001e\u001f\u0005\u0004\u0000"+
		"\u0000\u001f \u0005\u0002\u0000\u0000 !\u0003\n\u0005\u0000!\"\u0005\u0003"+
		"\u0000\u0000\"#\u0005\u0005\u0000\u0000#\u0001\u0001\u0000\u0000\u0000"+
		"$%\u0003\f\u0006\u0000%\u0003\u0001\u0000\u0000\u0000&\'\u0005\b\u0000"+
		"\u0000\'(\u0005\u0004\u0000\u0000(+\u0003\u0004\u0002\u0000)+\u0005\b"+
		"\u0000\u0000*&\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000\u0000+\u0005"+
		"\u0001\u0000\u0000\u0000,-\u0006\u0003\uffff\uffff\u0000-.\u0003\u000e"+
		"\u0007\u0000.4\u0001\u0000\u0000\u0000/0\n\u0002\u0000\u000001\u0005\u0004"+
		"\u0000\u000013\u0003\u0006\u0003\u00032/\u0001\u0000\u0000\u000036\u0001"+
		"\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"5\u0007\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0005\u0007"+
		"\u0000\u00008\t\u0001\u0000\u0000\u00009:\u0003\f\u0006\u0000:\u000b\u0001"+
		"\u0000\u0000\u0000;<\u0005\u0007\u0000\u0000<=\u0005\u0004\u0000\u0000"+
		"=@\u0003\f\u0006\u0000>@\u0005\u0007\u0000\u0000?;\u0001\u0000\u0000\u0000"+
		"?>\u0001\u0000\u0000\u0000@\r\u0001\u0000\u0000\u0000AB\u0005\u0001\u0000"+
		"\u0000BC\u0005\u0007\u0000\u0000CD\u0005\u0004\u0000\u0000DE\u0005\b\u0000"+
		"\u0000EF\u0005\u0005\u0000\u0000FG\u0005\u0006\u0000\u0000GH\u0005\u0002"+
		"\u0000\u0000HI\u0003\f\u0006\u0000IJ\u0005\u0003\u0000\u0000JT\u0001\u0000"+
		"\u0000\u0000KL\u0005\u0001\u0000\u0000LM\u0005\u0007\u0000\u0000MN\u0005"+
		"\u0004\u0000\u0000NO\u0005\b\u0000\u0000OP\u0005\u0005\u0000\u0000PQ\u0005"+
		"\u0006\u0000\u0000QR\u0005\u0002\u0000\u0000RT\u0005\u0003\u0000\u0000"+
		"SA\u0001\u0000\u0000\u0000SK\u0001\u0000\u0000\u0000T\u000f\u0001\u0000"+
		"\u0000\u0000\u0004*4?S";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}