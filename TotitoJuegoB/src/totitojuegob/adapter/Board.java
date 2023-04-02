/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package totitojuegob.adapter;

import java.util.List;

/**
 *
 * @author Raul
 */
public interface Board<Move>{
    Piece getTurn();
    Board<Move> move(Move location);
    List<Move> getLegalMove();
    boolean isWin();
    default boolean isDraw(){
        return !isWin() && getLegalMove().isEmpty();
    }
    double evaluate(Piece player);
}
