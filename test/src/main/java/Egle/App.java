package Egle;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Hello world!
 *
 */
public class App {
    private static ArrayList<CardTest> cards = new ArrayList<>();
    public static int playerCount = 0;
    public static boolean playersChosen = false;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public  String createPlayer(String playerName){ //The method createPlayer creates a player.
        playerCount++;
        if(playerCount == 1 &&(playerName==null || playerName.equals(""))){ //Making sure we get at least one player for the game.
            System.out.println("Vähemalt üks mängija peab olema nimetatud.");
            playerCount--;
            return "no name";
        }else if(playerName == null || playerName.equals("")){ //If no additional names are added, we allow to continue on with less than maximum amount of players.
            playersChosen=true;
            return "no name";
        }else{ //If none of the exceptions are met, we shall make a player!           
            return playerName;
        }
    }

    // Fisher–Yates shuffle ( https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array )
    public String[] shuffleArray(String[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    public String pair(){
        if(cardsTurned==2){ //Once both cards have been selected, we shall compare the two to see if they have the same symbol and upon a match, the player scores and the cards are cleared.
            if (firstCard.getSymbol().equals(secondCard.getSymbol())){
                player.setScore(player.getScore() + 1);
                gameBoard.clearCard(firstCard.getX(), firstCard.getY());
                gameBoard.clearCard(secondCard.getX(), secondCard.getY());
                pairsFound++;
            }
            finishedTurn = true;
            gameBoard.resetCards(); //This switches cards that have been flipped but not cleared back over, so the table will show clear cards.
            System.out.println(player.getName()+": "+player.getScore() +" punkti"); //At the end of a players turn, we show their score.
            if(pairsFound == 8){ //Once all 8 pairs are found, the game is finished!
                finishedGame = true;
            }
        }
    }



    private void addSymbols(int board) {
        String[] symbols = new String[board];
        int counter = 0;
        for (int i = 0; i < symbols.length; i += 2) {
            symbols[i] = SymbolTest.getSymbol(counter);
            symbols[i + 1] = SymbolTest.getSymbol(counter);
            counter++;
        }
        // Randomise the location of the symbols
        shuffleArray(symbols);
        for(int i = 0; i < cards.size(); i++) {
            cards.get(i).setSymbol(symbols[i]);
        }
    }





    

}
