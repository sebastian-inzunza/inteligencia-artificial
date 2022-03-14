/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle.pkg8;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author david
 */
public class Puzzle8 {

    public static void main(String[] args) {
        // TODO code application logic here
       int [][] inicio = {{1,2,3},{4,5,6},{7,0,8}};
       int [][] solucion = {{1,2,3},{4,5,6},{7,8,0}};  
       
       Nodo inicial = new Nodo(inicio);
       buscarSolucion(inicial, solucion);
       
    }
    
    public static void buscarSolucion(Nodo inicial, int[][] solucion){
        ArrayList<Nodo> arbol = new ArrayList<Nodo>();
        arbol.add(inicial);
        
        while(arbol.size()!=0){
            Nodo revisar = arbol.remove(0);
            imprimirEstados(revisar.getEstado());
            int [] posicion = ubicarPosicionCero(revisar.getEstado());
            
            if(Arrays.deepEquals(revisar.getEstado(), solucion)){
                System.out.println("*** SOLUCION ***");
                imprimirEstados(revisar.getEstado());
                break;
            }
            
            //Mueve el cero arriba
            if(posicion[0]!= 0){
                Nodo hijo = new Nodo(clonar(revisar.getEstado()));
                int arriba = hijo.getEstado()[ posicion[0] - 1][posicion[1] ]; //Obtenemos el dato de una posicion arriba
                hijo.getEstado()[ posicion[0]] [posicion[1] ] = arriba; // ingresamos el dato una Pocision abajo
                hijo.getEstado()[ posicion[0]-1] [posicion[1] ] = 0;
                arbol.add(hijo);
            }
            //Mueve el cero abajo
            if(posicion[0]!= 2){
                Nodo hijo = new Nodo(clonar (revisar.getEstado()));
                int abajo = hijo.getEstado()[ posicion[0] + 1][ posicion[1] ]; //Obtenemos el dato de una posicion arriba
                hijo.getEstado()[ posicion[0]] [posicion[1] ] = abajo; // ingresamos el dato una Pocision abajo
                hijo.getEstado()[ posicion[0]+1] [posicion[1] ] = 0;
                arbol.add(hijo);
            }
            
            if(posicion[1]!= 0){
                Nodo hijo = new Nodo(clonar(revisar.getEstado()));
                int izquierda = hijo.getEstado()[ posicion[0]][posicion[1] - 1 ]; //Obtenemos el dato de una posicion arriba
                hijo.getEstado()[ posicion[0]] [posicion[1] ] = izquierda; // ingresamos el dato una Pocision abajo
                hijo.getEstado()[ posicion[0]] [posicion[1] - 1] = 0;
                arbol.add(hijo);
            }
            //Mueve el cero abajo
            if(posicion[1]!= 2){
                Nodo hijo = new Nodo(clonar(revisar.getEstado()));
                int derecha = hijo.getEstado()[ posicion[0] ][ posicion[1] + 1]; //Obtenemos el dato de una posicion arriba
                hijo.getEstado()[ posicion[0]] [posicion[1] ] = derecha; // ingresamos el dato una Pocision abajo
                hijo.getEstado()[ posicion[0] ] [posicion[1] + 1] = 0;
                arbol.add(hijo);
            }
           
        }
    }
    
    public static void imprimirEstados(int [][] estado){
        for(int i=0; i<estado.length; i++){
            for(int j=0; j<estado.length; j++){
                System.out.printf("["+estado[i][j]+"]");
            }
            System.out.println("");
        } 
    }

    private static int[] ubicarPosicionCero(int[][] estado){
        
        int [] posicion = new int[2];
        
        for(int i=0; i<estado.length; i++){
            for(int j=0; j<estado.length; j++){
                if(estado[i][j] == 0){
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        System.out.println("Posicion del cero " + posicion[0] + " " + posicion[1] );
        return posicion;
    }

    private static int[][] clonar(int[][] estado) {
        
        int [][] clon = new int[estado.length][estado.length];
        
        for(int i=0; i<estado.length; i++){
            for(int j=0; j<estado.length; j++){
                clon[i][j] = estado[i][j];
            }
        }
        
        return clon;
    }
}
