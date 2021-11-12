package tictactoecli;

import tictactoecli.communications.TicTacToe;

public class App {
    public static void main(String[] args) throws Exception {

        TicTacToe game=new TicTacToe();
        game.play();
    }
}
