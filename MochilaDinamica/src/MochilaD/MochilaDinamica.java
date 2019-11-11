/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MochilaD;

import java.util.ArrayList;
/**
 *
 * @author lesli
 */
    public class MochilaDinamica {
        
     private ArrayList<Articulos> art;
     private ArrayList<Articulos> itemsSolucion;
    
     private double[][] mayorBen;
     private int W;
     private int mayBeneficio;
     
     public MochilaDinamica(ArrayList<Articulos> art, int _W) {

        this.art = art;
        this.W = _W;
        matrizDeBeneficios();
        
     }
     
     private void matrizDeBeneficios() {

        this.mayorBen = new double[this.art.size()+1][this.W+1];

        for (int x=0;x <= this.art.size();x++){
        
            this.mayorBen[x][0] = 0;
        }
        for (int x=0;x <= this.W;x++){
        
            this.mayorBen[0][x] = 0;
        }
        
     }

     public void buscarSolucion(){

     for (int i=1;i <= this.art.size();i++)
     
         for(int w=0; w<= this.W;w++){

             if (this.art.get(i-1).getPeso()<= w){

                 if ((this.art.get(i-1).getValor()+ this.mayorBen[i-1][w-this.art.get(i-1).getPeso()]) > this.mayorBen[i-1][w]){

                     this.mayorBen[i][w] = this.art.get(i-1).getValor()+ this.mayorBen[i-1][w-this.art.get(i-1).getPeso()];

                  } else {

                     this.mayorBen[i][w] = this.mayorBen[i-1][w];

                    }

             } else {
     
                 this.mayorBen[i][w] = this.mayorBen[i-1][w];
     
                 System.out.print(this.mayorBen[i][w]+".");
                 
               }
     
             System.out.println();
     }
     
        this.mayBeneficio = (int)this.mayorBen[art.size()][W];
        this.itemsSolucion = new ArrayList<>();

        int i = this.art.size();
        int j = this.W;
        
        while (i > 0 && j > 0){
        
            double val = this.mayorBen[i][j];
        
            if( val != this.mayorBen[i-1][j]){
        
                this.itemsSolucion.add(this.art.get(i-1));
        // imprimir el articulo
        
        String aux =this.art.get(i-1).toString();
        System.out.println(aux);
            
            i--;
            j = j - this.art.get(i).getPeso();
            
            } else {
            
                i--;
              }

        }

     }
public static void mochila(){
     
        MochilaDinamica mochila1 = new MochilaDinamica(Articulos.crearArticulos(1000, 100, 100) ,500);
        mochila1.buscarSolucion();

    }

     public static void main(String args[]){

     MochilaDinamica.mochila();
     
     }
}
