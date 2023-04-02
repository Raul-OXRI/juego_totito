/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package totitojuegob;

import java.util.Scanner;
import totitojuegob.totito.Minimax;
import totitojuegob.totito.TotitoBoard;

/**
 *
 * @author Raul
 */
public class TotitoJuegoB {

    /**
     * @param args the command line arguments
     */
    
    private TotitoBoard board = new TotitoBoard();
    private Scanner scanner = new Scanner(System.in);
    public Integer getPlayerMove(){
        Integer move = -1;
        while(!board.getLegalMove().contains(move)){
            System.out.println("Ingrese la casilla del totito");
            Integer moveInput = scanner.nextInt();
            move = moveInput;
        }
        return move;
    }
    public void playTotito(){
        while(true){
            Integer humanMove = getPlayerMove();
            board = (TotitoBoard) board.move(humanMove);
            if(board.isWin()){
                System.out.println("Los humanos aun dominan");
                break;
            }else if(board.isDraw()){
                System.out.println("Maquina y hombre tienen la misma capacidad");
                break;
            }
            Integer computerMove = Minimax.findBestMove(board, 9);
            System.out.println("La computadora ha decidido " + computerMove);
            board = (TotitoBoard) board.move(computerMove);
            System.out.println(board);
            if(board.isWin()){
                System.out.println("La revelion de las maquina ha comenzado");
                break;
            }else if(board.isDraw()){
                System.out.println("Maquina y hombre tienen la misma capacidad");
                break;
            }
        }
    }
    public static void main(String[] args) {
        TotitoJuegoB app = new TotitoJuegoB();
        app.playTotito();
    }
    
}
