/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MochilaD;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lesli
 */
public class Articulos {
       
     private double valor;
     private int peso;
     
    public Articulos(double valor, int peso) {
     
        this.valor = valor;
        this.peso = peso;
        
     }
     
    public double getValor() {
     
        return valor;
        
    }
     
    public void setValor(double valor) {
     
        this.valor = valor;
        
    }
     
    public int getPeso() {
     
        return peso;
        
    }
     
    public void setPeso(int peso) {
     
        this.peso = peso;
        
    }
    
     @Override
     
    public String toString() {
     
        String aux ="Tamaño: " ;
        aux+=this.peso+ " ********* Beneficio: "+this.valor;
     return aux;
     
    }

    public static ArrayList<Articulos> crearArticulos(int n, int v, int p){

        ArrayList<Articulos> Articulo= new ArrayList<>();
        
        for(int i =0; i<n; i++){
     
            Random rndp = new Random();
            Random rndv = new Random();
            
            Articulos it= new Articulos(rndv.nextInt(v)+1,rndp.nextInt(p)+1);
     Articulo.add(it);
     
        }
     return Articulo;
    }

}
