# Visualizador de Diagramas NFA (Nondeterministic Finite Automaton)

Este proyecto es un software diseñado para visualizar diagramas de estados a partir de especificaciones de autómatas no deterministas.
El objetivo principal es proporcionar un software que permita a los usuarios definir y representar visualmente estos autómatas.

Tiene las siguientes características:
    - Gramática: Incluye una gramática que reconoce el lenguaje de todas las posibles tuplas de NFAs. Teniendo en cuenta que las tuplas siguen esta estructura:
                    NFA = (Q,Σ,T,q0,F)
                 Donde:
                    - Q  -> Conjunto finito de estados
                    - Σ  -> Conjunto finito de carácteres (Alfabeto)
                    - T  -> Conjunto finito de las transiciones entre estados
                    - q0 -> Estado inicial
                    - F  -> Conjunto finito de estados de aceptación o finales
                 Requerimientos:
                    - El nombre de los estados (STATE) debe tener mínimo dos carácteres para diferenciarse de los elementos (CHAR) del alfabeto.
                    - Si en las transiciones o estados inicial y finales hay algun estado no especificado en el primer conjunto de estados, la gramática 
                      lo aceptará pero dará errores después al compilar con LaTex.
                    - Si en las transiciones se usa un carácter no especificado en el alfabeto, este se convertirá en una epsilon (ε).
    - Traducción a LaTex: En base a las tuplas especificadas por los usuarios, el software traduce automáticamente estos datos en código LaTex capaz de 
                 visualizar los diagramas de estados correspondientes.
    - Generación de diagramas: Utilizando LaTex y la librería TikZ, el software genera diagramas de estados para representar de la forma más clara posible los
                 autómatas definidos por los usuarios.

Lenguajes usados:
    - Software -> Java
    - Gramática -> ANTLR4
    - Diagrama -> LaTex (librería TikZ)

## Contribución

...

## Instalación

Para instalar y ejecutar el software en tu entorno local Linux, sigue estos pasos:

1. Descargar y descomprimir la carpeta del proyecto
2. Abrir proyecto con Visual Studio Code
3. Instalar extensión 'Extension Pack for Java'
4. Instalación ANTLR4
    4.1. Instalar Java y JDK (versión 11 o superior)
    4.2. Instalar ANTLR con 'curl -O https://www.antlr.org/download/antlr-4.13.1-complete.jar'
    4.3. Guardar el .jar en /usr/local/lib (si se guarda en otro directorio hay que modificar el 'settings.json')
5. Instalar paquete TeX Live (apt-get install texlive texlive-latex-extra)
6. Ejecutar el software según las instrucciones proporcionadas en la sección de Uso

## Uso

1. Abrir carpeta del proyecto con Visual Studio Code
2. Abrir Application.java
3. Ejecutar desde el botón de la esquina superior derecha
4. Se ejecutará el software y lo primero que pedirá es introducir una tupla NFA. Por ejemplo:
        ({q0,q1,q2},{0,1},{(q0,0)={q0,q1},(q1,1)={q2},(q1,?)={q1}},q0,{q2})
5. Una vez introducida, el software comprobará que forme parte del lenguaje mediante las clases generadas por la gramática
6. Si la tupla es aceptada por la gramática, pedirá introducir un nombre que será para el PDF (si no se introduce nada, será NFA)
7. Hecho esto, el software hará todo el proceso para generar el PDF con el diagrama y lo abrirá automáticamente

## Equipo

Florian Alexandru Serb Petrusel (florianalexandru.serb@estudiants.urv.cat)
Adrià San Juan Domínguez (adria.sanjuan@estudiants.urv.cat)
Guillem Rodríguez Mitjana (guillem.rodriguez@estudiants.urv.cat)
