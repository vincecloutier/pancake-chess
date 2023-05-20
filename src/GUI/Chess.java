package GUI;

import Game.Game;

import javax.swing.*;

public class Chess {

    public void gameLoop() {
        ChessBoardGUI gui = new ChessBoardGUI();
        gui.game = new Game();

        if (gui.game.player1.goesFirst && gui.game.turn % 2 != 0) {
            gui.currPlayer = gui.game.player1;
            gui.currPlayer.isTurn = true;
        } else if (gui.game.player2.goesFirst && gui.game.turn % 2 == 0) {
            gui.currPlayer = gui.game.player1;
            gui.currPlayer.isTurn = true;
        } else {
            gui.currPlayer = gui.game.player2;
            gui.currPlayer.isTurn = true;
        }

        while (!gui.game.player1.isLoser && !gui.game.player2.isLoser) {
            gui.waitForInput();

            if (gui.game.invalid) {
                gui.endTurn = false;
                gui.game.invalid = false;
            } else {
                gui.currPlayer.isTurn = false;
                if (gui.currPlayer == gui.game.player1)
                    gui.currPlayer = gui.game.player2;
                else
                    gui.currPlayer = gui.game.player1;
                gui.endTurn = false;
                gui.game.turn++;
            }
        }

        String[] buttons = new String[]{"Yes", "No"};
        int returnValue = JOptionPane.showOptionDialog(null, "Play a new game?", "CHECKMATE",
                JOptionPane.DEFAULT_OPTION, 0, null, buttons, buttons[0]);
        if (returnValue == 1)
            System.exit(0);
        else {
            gameLoop();
        }
    }
}
