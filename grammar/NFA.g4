/** 
 * Gramática para el lenguaje de especificación de un NFA 
 * Este lenguaje hace referencia a la tupla de 5 elementos que define un NFA:
 *          NFA = (Q,Σ,T,q0,F)
 * Donde:
 *  - Q  -> Conjunto finito de estados
 *  - Σ  -> Conjunto finito de carácteres (Alfabeto)
 *  - T  -> Conjunto finito de las transiciones entre estados
 *  - q0 -> Estado inicial
 *  - F  -> Conjunto finito de estados de aceptación o finales
 *
 * Requerimientos:
 *  - El nombre de los estados (STATE) debe tener mínimo dos carácteres para diferenciarse de los elementos (CHAR) del alfabeto
 *  - Si en las transiciones o estados inicial y finales hay algun estado no especificado en el primer conjunto de estados, la gramática 
 *    lo aceptará pero dará errores después al compilar con LaTex
 *  - Si en las transiciones se usa un carácter no especificado en el alfabeto, este se convertirá en una epsilon (ε)
 *  - La tupla del NFA tiene que ser de la siguiente forma para ser aceptada (sin importar espacios):
 *            ({q0, q1...}, {c0, c1...), {(qi, ci) = {qi, qy...}...}, qi, {qi, qy...})
 */
grammar NFA;

nfa : '(' '{' allstates '}' ',' '{' alphabet '}' ',' '{' transitions '}' ',' initial ',' '{' finals '}' ')';

allstates : states ;

alphabet : CHAR ',' alphabet
         | CHAR
         ;

transitions : transitions ',' transitions
            | transition
            ;

initial : STATE;

finals : states;

states : STATE ',' states
       | STATE
       ;

transition : '(' STATE ',' CHAR ')' '=' '{' states '}'
           | '(' STATE ',' CHAR ')' '=' '{' '}'
           ;


STATE : [a-zA-Z0-9][a-zA-Z0-9]+;
CHAR : [a-zA-Z0-9ε];

WS : [ \t\r\n]+ -> skip;