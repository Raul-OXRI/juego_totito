/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package totitojuegob.totito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import totitojuegob.adapter.Board;
import totitojuegob.adapter.Piece;

/**
 *
 * @author Raul
 */
public class TotitoBoard implements Board<Integer>{
    private static final int NUM_SQUARES = 9;
    private TotitoPiece[] position;
    private TotitoPiece turn;
    
    public TotitoBoard(){
        position = new TotitoPiece[NUM_SQUARES];
        turn = TotitoPiece.X;
        Arrays.fill(position, TotitoPiece.E);
    }
    public TotitoBoard(TotitoPiece[] position, TotitoPiece turn){
        this.position = position;
        this.turn = turn;
    }

    @Override
    public Piece getTurn() {
        return this.turn;
    }

    @Override
    public Board<Integer> move(Integer location) {
        TotitoPiece[] tempPosition = Arrays.copyOf(position, position.length);
        tempPosition[location]=turn;
        return new TotitoBoard(tempPosition,turn.opposite());
    }

    @Override
    public List<Integer> getLegalMove() {
        var legalMoves = new ArrayList<Integer>();
        for(int i = 0; i < position.length; i++){
            if(position[i]==TotitoPiece.E){
                legalMoves.add(i);
            }
        }
        return legalMoves;
    }

    @Override
    public boolean isWin() {
        return checkPosition(0,1,2) || checkPosition(3,4,5) || checkPosition(6,7,8) ||
               checkPosition(0,3,6) || checkPosition(1,4,7) || checkPosition(2,5,8) ||
               checkPosition(0,4,8) || checkPosition(2,4,6);
    }
    private boolean checkPosition(int p0, int p1, int p2){
        return position[p0] == position[p1] && position[p1] == position[p2] && position[p0] != TotitoPiece.E;
    }

    @Override
    public double evaluate(Piece player) {
        if(isWin() && turn == player){
            return -1;
        }else if(isWin() && turn != player){
            return 1;
        }else{
            return 0.0;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                sb.append(position[row*3 + col].toString());
                if(col != 2){
                    sb.append("|");
                }
            }
            sb.append(System.lineSeparator());
            if(row != 2){
                sb.append("-----");
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
