/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
    package com.mycompany.proyect1;
    import javax.swing.JOptionPane;
    import java.util.Stack;
    /**
     * 
     *
     * @author cachi
     */
    //GARHER ES NUESTRA VARIABLE PARA CONVERTIR
    //"\n" SALTO DE LINEA
    //Joption lo utilizamos para el cuadro de texto emergente

    public class Proyect1 {
        public static void main(String[] args) {
            ArbolExpresion arbol = 
                    new ArbolExpresion();
            ArbolExpresion.ArbolInfijaPostfija GARHER 
                    = arbol.new ArbolInfijaPostfija();

            String EINFIJA = JOptionPane.showInputDialog(
                    "INGRESE LA EXPRESIÓN MATEMATICA: \n\n FAVOR DE DEJAR UN ESPACIO ENTRE CADA OPERADOR Y OPERANDO \n Ejemplo: A + B * C");

            if (!validarCaracteres(EINFIJA)) {
                JOptionPane.showMessageDialog
        (null, "EXPRESION INCORRECTA", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] EPOSTFIJA = GARHER.ArbolInfijaPostfija(EINFIJA);
            StringBuilder postfija = new StringBuilder("EXPRESION EN NOTACION POSTFIJA:\n");
            for (String dato : EPOSTFIJA) {
                postfija.append(dato).append(" ");
            }
            JOptionPane.showMessageDialog(null, postfija.toString());

            NODO raiz = arbol.ArbolPostfija(EPOSTFIJA);

          // RECORRIDOS DE CADA ARBOL
            StringBuilder recorridos = new StringBuilder();
            recorridos.append
            ("RECORRIDO INORDEN:\n");
            arbol.RecorridoIn(raiz, recorridos);
            recorridos.append
            ("\nRECORRIDO PREORDEN:\n");
            arbol.RecorridoPre(raiz, recorridos);
            recorridos.append
            ("\nRECORRIDO POSTORDEN:\n");
            arbol.RecorridoPost(raiz, recorridos);
            JOptionPane.showMessageDialog(null, recorridos.toString());

            int resultado = 
                    arbol.evaluarPostfija(EPOSTFIJA);
            JOptionPane.showMessageDialog
            (null, "RESULTADO: " + resultado);


            System.out.println
            ("ARBOL DE FORMA GRAFIICA:");
            imprimirArbol(raiz, 0);

            System.out.println
            ("\nCOMPORTAMIENTO DE LA PILA:");
            Stack<String> pilaEjemplo = 
                    new Stack<>();
            for (String dato : EPOSTFIJA) {
                pilaEjemplo.push(dato);
                System.out.println("PILA: " + pilaEjemplo);
            }
        }

        private static boolean validarCaracteres(String expresion) {
            for 
                    (char c : expresion.toCharArray()) {
                if 
                        (!(Character.isLetterOrDigit(c) || 

                        c == '+' || 
                        c == '-' || 
                        c == '*' || 
                        c == '/' || 
                        c == '^' || 
                        c == '√' || 
                        c == ' ' || 
                        c == '(' || 
                        c == ')')) {
                    return false;
                }
            }
            return true;
        }

        private static void imprimirArbol(NODO nodo, int nivel) {
            if (nodo == null) return;

            imprimirArbol(nodo.nododerecho, nivel + 1);

            for 
                    (int i = 0; i < nivel; i++) {
                System.out.print
            ("    ");
            }
            System.out.println
            (nodo.dato);

            imprimirArbol
            (nodo.nodoizquierdo, nivel + 1);
        }
    }
