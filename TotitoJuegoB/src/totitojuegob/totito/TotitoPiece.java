/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package totitojuegob.totito;

import totitojuegob.adapter.Piece;

/**
 *
 * @author Raul
 */
public enum TotitoPiece implements Piece{
    X,O,E;
    
    @Override
    public String toString(){
        switch(this){
            case X:
                return "X";
            case O:
                return "O";
            default:
                return " ";
        }
    }
    
    @Override
    public TotitoPiece opposite() {
        switch(this){
            case X: 
                return O;
            case O: 
                return X;
            default: 
                return E;
        }
    }
    
}
