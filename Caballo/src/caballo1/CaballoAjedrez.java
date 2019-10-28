/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caballo1;

/**
 *
 * @author Alumno
 */
public class CaballoAjedrez {

    public static boolean tablero[][]=new boolean[8][8];
    public static int [][] recorrido=new int[8][8];
    public static long tam=0;
    public static void nodos(int n,int h,int v){
       
        if(n==64){
    
            System.out.println("\n");
        
            for(int i=0;i<recorrido.length;i++){
                for(int j=0;j<recorrido.length;j++)
                    System.out.print(recorrido[i][j]+" ");
                System.out.println(" ");
            }
        }
        tam++;
        int mov[][]={{2,1},{1,2},{-2,1},{-1,2},{2,-1},{1,-2},{-2,-1},{-1,-2}};
        for(int [] m:mov){
            int sh=h+m[0];
            int sv=v+m[1];
            if(sh>=0 && sv>=0)
                if(sh<8 && sv<8)
                    if(!tablero[sh][sv]){
                        recorrido[sh][sv]=n+1;
                        tablero[sh][sv]=true;
                        nodos(n+1,sh,sv);
                        tablero[sh][sv]=false;
                        recorrido[sh][sv]=0;
                     }
        }         
    }
    public static void main(String [] args){
        tablero[0][1]=true;
        recorrido[0][1]=1;
        nodos(1,0,1);
    }
    
}

