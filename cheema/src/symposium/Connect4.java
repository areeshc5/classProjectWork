package symposium;

public class Connect4 {

    public static void main(String[] args) {
        int state = 0;
        boolean useGameGUI = true;//sets if we want the cli or GameGUI.

        if (useGameGUI) {
            GameGUI GameGUI = new GameGUI();
            while (state != -1) {//checks if program is in quitting stage
                switch (state) {
                    case 0://runtime
                        GameGUI.updateBoard();
                        if (GameGUI.getHasWon()) {
                            state = 1;
                        } else if (GameGUI.getHasDraw()) {
                            state = 2;
                        } else if (GameGUI.getNewGame()) {
                            GameGUI = new GameGUI();
                            state = 0;
                        }
                        break;
                    case 1://endgame with winner
                        GameGUI.showWon();
                        if (GameGUI.getQuit()) {
                            state = -1;
                        } else  if (GameGUI.getNewGame()) {
                            GameGUI = new GameGUI();
                            state = 0;
                        }
                        break;
                    case 2://endgame with drawgame
                        GameGUI.showDraw();
                        if (GameGUI.getQuit()) {
                            state = -1;
                        } else if (GameGUI.getNewGame()) {
                            GameGUI = new GameGUI();
                            state = 0;
                        }
                        break;
                }
            }
        } else {
            Cli Cli = new Cli();
            while (state != -1) {//checks if program is in quitting stage
                switch (state) {
                    case 0:
                        Cli.runtime();
                        if (Cli.getHasWon()) {
                            state = 1;
                        } else if (Cli.getHasDraw()) {
                            state = 2;
                        }
                        break;
                    case 1://prints endgame with winner
                        Cli.showWin();
                        if (Cli.getQuit()) {
                            state = -1;
                        } else if (Cli.getNewGame()) {
                            Cli = new Cli();
                            state = 0;
                        }
                        break;
                    case 2://prints end game eith draw game
                        Cli.showDraw();
                        if (Cli.getQuit()) {
                            state = -1;
                        } else if (Cli.getNewGame()) {
                            Cli = new Cli();
                            state = 0;
                        }
                        break;
                }
            }
        }
    }
}