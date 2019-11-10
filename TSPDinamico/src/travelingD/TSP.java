/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package travelingD;

/**
 *
 * @author lesli
 */

import java.util.*;

public class TSP {

    int dis = 1000;
    int[][] distancias;
    char[] nodos;
    
    
    
    TSP(String ciudades) {
        
        nodos = ciudades.toCharArray();
        distancias = new int[nodos.length][nodos.length];
    }

    public void agregarRuta(char inicio, char fin, int distancia) {
        
        int n1 = posicionNodo(inicio);
        int n2 = posicionNodo(fin);
        distancias[n1][n2] = distancia;
        distancias[n2][n1] = distancia;
    }

    private int posicionNodo(char nodo) {
        for (int i = 0; i < nodos.length; i++) {
            if (nodos[i] == nodo) {
                return i;
            }
        }
        return -1;
    }

    public void rutaCorta(char inicio, char fin) {
        
        int p1 = posicionNodo(inicio);
        int p2 = posicionNodo(fin);
       
        Stack<Integer> resultado = new Stack<Integer>();
        resultado.push(p1);
        recorrerRutas(p1, p2, resultado);
    }

    private void recorrerRutas(int nodoI, int nodoF, Stack<Integer> resultado) {
        int aux = 0;
        
        if (nodoI == nodoF) {

            if (resultado.size() == 10&&evaluar(resultado)<=1000) {

                for (int x : resultado) {
                    aux++;
                    System.out.print(nodos[x] + " ");
                }
                int val= evaluar(resultado);
                if ( val< dis) {
                    dis = val;
                }
                System.out.print(": " + evaluar(resultado) + " ");
                System.out.println();
            }

            return;

        }

        List<Integer> lista = new Vector<Integer>();
        for (int i = 0; i < distancias.length; i++) {
            if (distancias[nodoI][i] != 0 && !resultado.contains(i)) {
                lista.add(i);
            }
        }

        for (int nodo : lista) {
            
            resultado.push(nodo);
            recorrerRutas(nodo, nodoF, resultado);
            resultado.pop();
        }
        

    }

    public void rutaMasCorta() {
    }

    public int evaluar(Stack<Integer> resultado) {
        int res = 0;
        int[] r = new int[resultado.size()];
        int i = 0;
        for (int x : resultado) {
            r[i++] = x;
        }
        for (i = 1; i < r.length; i++) {
            res += distancias[r[i]][r[i - 1]];
        }
        return res + 39;
    }

    public static void main(String[] args) {
        
        TSP g = new TSP("abcdefghij");
        
        g.agregarRuta('a', 'b', 13);
        g.agregarRuta('a', 'c', 33);
        g.agregarRuta('a', 'd', 28);
        g.agregarRuta('a', 'e', 37);
        g.agregarRuta('a', 'f', 7);
        g.agregarRuta('a', 'g', 32);
        g.agregarRuta('a', 'h', 40);
        g.agregarRuta('a', 'i', 80);
        g.agregarRuta('a', 'j', 26);

        g.agregarRuta('b', 'a', 13);
        g.agregarRuta('b', 'c', 39);
        g.agregarRuta('b', 'd', 83);
        g.agregarRuta('b', 'e', 50);
        g.agregarRuta('b', 'f', 68);
        g.agregarRuta('b', 'g', 16);
        g.agregarRuta('b', 'h', 98);
        g.agregarRuta('b', 'i', 81);
        g.agregarRuta('b', 'j', 55);

        g.agregarRuta('c', 'a', 33);
        g.agregarRuta('c', 'b', 39);
        g.agregarRuta('c', 'd', 80);
        g.agregarRuta('c', 'e', 88);
        g.agregarRuta('c', 'f', 49);
        g.agregarRuta('c', 'g', 53);
        g.agregarRuta('c', 'h', 75);
        g.agregarRuta('c', 'i', 63);
        g.agregarRuta('c', 'j', 55);

        g.agregarRuta('d', 'a', 28);
        g.agregarRuta('d', 'b', 83);
        g.agregarRuta('d', 'c', 80);
        g.agregarRuta('d', 'e', 94);
        g.agregarRuta('d', 'f', 4);
        g.agregarRuta('d', 'g', 20);
        g.agregarRuta('d', 'h', 6);
        g.agregarRuta('d', 'i', 59);
        g.agregarRuta('d', 'j', 76);

        g.agregarRuta('e', 'a', 37);
        g.agregarRuta('e', 'b', 50);
        g.agregarRuta('e', 'c', 88);
        g.agregarRuta('e', 'd', 94);
        g.agregarRuta('e', 'f', 81);
        g.agregarRuta('e', 'g', 87);
        g.agregarRuta('e', 'h', 85);
        g.agregarRuta('e', 'i', 4);
        g.agregarRuta('e', 'j', 19);

        g.agregarRuta('f', 'a', 7);
        g.agregarRuta('f', 'b', 68);
        g.agregarRuta('f', 'c', 49);
        g.agregarRuta('f', 'd', 4);
        g.agregarRuta('f', 'e', 81);
        g.agregarRuta('f', 'g', 96);
        g.agregarRuta('f', 'h', 53);
        g.agregarRuta('f', 'i', 40);
        g.agregarRuta('f', 'j', 37);

        g.agregarRuta('g', 'a', 32);
        g.agregarRuta('g', 'b', 16);
        g.agregarRuta('g', 'c', 53);
        g.agregarRuta('g', 'd', 20);
        g.agregarRuta('g', 'e', 87);
        g.agregarRuta('g', 'f', 96);
        g.agregarRuta('g', 'h', 80);
        g.agregarRuta('g', 'i', 57);
        g.agregarRuta('g', 'j', 68);

        g.agregarRuta('h', 'a', 40);
        g.agregarRuta('h', 'b', 98);
        g.agregarRuta('h', 'c', 75);
        g.agregarRuta('h', 'd', 6);
        g.agregarRuta('h', 'e', 85);
        g.agregarRuta('h', 'f', 53);
        g.agregarRuta('h', 'g', 80);
        g.agregarRuta('h', 'i', 65);
        g.agregarRuta('h', 'j', 41);

        g.agregarRuta('i', 'a', 80);
        g.agregarRuta('i', 'b', 81);
        g.agregarRuta('i', 'c', 63);
        g.agregarRuta('i', 'd', 59);
        g.agregarRuta('i', 'e', 4);
        g.agregarRuta('i', 'f', 40);
        g.agregarRuta('i', 'g', 57);
        g.agregarRuta('i', 'h', 65);
        g.agregarRuta('i', 'j', 97);

        g.agregarRuta('j', 'a', 26);
        g.agregarRuta('j', 'b', 55);
        g.agregarRuta('j', 'c', 55);
        g.agregarRuta('j', 'd', 76);
        g.agregarRuta('j', 'e', 19);
        g.agregarRuta('j', 'f', 37);
        g.agregarRuta('j', 'g', 68);
        g.agregarRuta('j', 'h', 41);
        g.agregarRuta('j', 'i', 97);

        char inicio = 'a';
        char fin = 'b';
        
        g.rutaCorta(inicio, fin);
        
        System.out.println("Distancia recorrida más corta: " + g.dis);
    }
}
