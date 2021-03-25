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
    public static int cardsTurned = 0;
    public static CardTest firstCard;
    public static CardTest secondCard;
    public static boolean finishedGame = false;
    public static boolean finishedTurn = false;
    public static int pairsFound = 0;
    public static ArrayList<PlayerTest> players = new ArrayList<>();
    private int width;
    private boolean cleared = false;

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

    public String playerTurn(String input){ //This cycles our turns, managing movement, activation and scoring points.       
        if (input.equals("")){ //If an empty line is entered, the player moves in their previous or default direction.
            //player.move(gameBoard.getWidth(), gameBoard.getHeight());
            return "Player moves to their original location";
        } else if (input.equals("a")){ //Using the common WASD setup, we allow the player to move with the keys present.
            return "LEFT";
        } else if (input.equals("d")){
            return "RIGHT";
        } else if (input.equals("w")){
            return "UP";
        } else if (input.equals("s")){
            return "DOWN";            //This ends the movement section.
        }else{
            return input;
        }
    }

    public boolean isCleared() {
        return cleared;
    }
    // Check if card has been cleare
    public boolean isCardCleared(int x, int y) {
        return cards.get(width * y + x).isCleared();
    }

/*
    private String[] addSymbols(String board) {
        String[] symbols = new String[]{"֍","☼","◊","⌂","♫","§","¤","Ѫ"};
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
    */

    // Mark the card as having been cleared
    public int clearCard(int x, int y, int width) {
        int i = width * y + x;
        return i;
    } 







    

}
