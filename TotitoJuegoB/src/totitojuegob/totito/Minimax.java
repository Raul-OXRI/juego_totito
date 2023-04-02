/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package totitojuegob.totito;

import totitojuegob.adapter.Board;
import totitojuegob.adapter.Piece;

/**
 *
 * @author Raul
 */
public class Minimax {
    public static<Move> double minimax(Board<Move>board,boolean maximizing, Piece originaPlayer,int maxdepth){
        if(board.isWin() || board.isDraw() || maxdepth == 0){
            return board.evaluate(originaPlayer);
        }
        if(maximizing){
            double v = Double.NEGATIVE_INFINITY;
            for(Move move : board.getLegalMove()){
                double result = minimax(board.move(move), false, originaPlayer, maxdepth -1);
                v = Math.max(v,result);
            }
            return v;
        }else{
            double v = Double.POSITIVE_INFINITY;
            for(Move move : board.getLegalMove()){
                double result = minimax(board.move(move), true, originaPlayer, maxdepth -1);
                v = Math.min(v,result);
            }
            return v;
        }
    }
    public static <Move> Move findBestMove(Board<Move> board,int maxdepth){
        double bestValue = Double.NEGATIVE_INFINITY;
        Move bestMove = null;
        for(Move move : board.getLegalMove()){
            double result = minimax(board.move(move),false,board.getTurn(),maxdepth);
            if(result > bestValue){
                bestValue = result;
                bestMove = move;
            }
        }
        return bestMove;
    }
}
