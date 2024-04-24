grammar NFA;

init : '(' '{' states '}' ',' '{' alphabet '}' ',' '{' transition '}' ',' STATE ',' '{' states '}' ')';

states 
    : STATE ',' states
    | STATE
    ;

alphabet 
    : CHAR ',' alphabet
    | CHAR
    ;

transition 
    : transition ',' transition
    | '(' STATE ',' CHAR ')' '=' states
    | '(' STATE ',' CHAR ')' '=' '{' '}'
    ; 

STATE : ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9])*;
CHAR : [a-z] | [A-Z] | [0-9];

WS : [ \t\r\n]+ -> skip;