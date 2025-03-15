/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package com.mycompany.proyect1;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;
    /**
     *
     * @author cachi, GarHer1399
     */

    public class ArbolExpresion {
        public NODO ArbolPostfija(String[] expresionPostfija) {
        Stack<NODO> pila = new Stack<>();

        for (String Dato1 : expresionPostfija) {
            if (!Operador(Dato1)) {
                pila.push(new NODO(Dato1));
            } else {
                NODO nodo = new NODO(Dato1);
                nodo.nododerecho = pila.pop();
                nodo.nodoizquierdo = pila.pop();
                pila.push(nodo);
            }
        }

        return pila.pop();
    }
      private boolean Operador(String Dato1){
                    return 
                            "+".equals(Dato1) || 
                            "-".equals(Dato1) || 
                            "*".equals(Dato1) || 
                            "/".equals(Dato1) || 
                            "^".equals(Dato1) || 
                            "√".equals(Dato1);
        }
              private int Presedencia(String operador) {
                switch (operador) {
                    case "^": 
                    case "√": 
                        return 3;
                    case "*": 
                    case "/": 
                        return 2;
                    case "+": 
                    case "-": 
                        return 1;

                    default: return -1;
                }
              }
    public class ArbolInfijaPostfija {
            public String[] ArbolInfijaPostfija(String expresion) {
            List<String> salida = new ArrayList<>();
            Stack<String> pila = new Stack<>();

            String[] Datos = expresion.split(" ");

            for (String Dato1 : Datos) {
                if (Dato1.matches("[a-zA-Z0-9]+")) {
                    salida.add(Dato1);
                } else if (Operador(Dato1)) {
                    while (!pila.isEmpty() && Presedencia(pila.peek()) >= Presedencia(Dato1)) {
                        salida.add(pila.pop());
                    }
                    pila.push(Dato1);
                } else if ("(".equals(Dato1)) {
                    pila.push(Dato1);
                } else if (")".equals(Dato1)) {
                    while (!pila.isEmpty() && !"(".equals(pila.peek())) {
                        salida.add(pila.pop());
                    }
                    pila.pop();
                }
            }

            while (!pila.isEmpty()) {
                salida.add(pila.pop());
            }

            return salida.toArray(new String[0]);
        }

            private boolean Operador(String Dato1){
                    return 
                            "+".equals(Dato1) || 
                            "-".equals(Dato1) || 
                            "*".equals(Dato1) || 
                            "/".equals(Dato1) || 
                            "^".equals(Dato1) || 
                            "√".equals(Dato1);
        }
              private int Presedencia(String operador) {
                switch (operador) {
                    case "^": 
                    case "√": 
                        return 3;
                    case "*": 
                    case "/": 
                        return 2;
                    case "+": 
                    case "-": 
                        return 1;

                    default: return -1;
                }
              }
    }      
    public int evaluarPostfija(String[] expresionPostfija) {
            Stack<Integer> pila = new Stack<>();
            for (String dato : expresionPostfija) {
                if (!Operador(dato)) {
                    pila.push(Integer.parseInt(dato));
                } else {
                    int b = pila.pop();
                    int a = pila.pop();
                    switch (dato) {
                        case "+": pila.push(a + b); break;
                        case "-": pila.push(a - b); break;
                        case "*": pila.push(a * b); break;
                        case "/": pila.push(a / b); break;
                        case "^": pila.push((int) Math.pow(a, b)); break;
                    }
                }
            }
            return pila.pop();
        }



    public void RecorridoIn(NODO nodo, StringBuilder sb) {
    if (nodo != null) {
        RecorridoIn(nodo.nodoizquierdo, sb);
        sb.append(nodo.dato).append(" ");
        RecorridoIn(nodo.nododerecho, sb);
    }
}

public void RecorridoPre(NODO nodo, StringBuilder sb) {
    if (nodo != null) {
        sb.append(nodo.dato).append(" ");
        RecorridoPre(nodo.nodoizquierdo, sb);
        RecorridoPre(nodo.nododerecho, sb);
    }
}

public void RecorridoPost(NODO nodo, StringBuilder sb) {
    if (nodo != null) {
        RecorridoPost(nodo.nodoizquierdo, sb);
        RecorridoPost(nodo.nododerecho, sb);
        sb.append(nodo.dato).append(" ");
    }
}
    } 

        
