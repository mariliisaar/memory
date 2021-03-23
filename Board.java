import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int width;
    private int height;
    private Player player;    
    private String colour;
    private static ArrayList<Card> cards = new ArrayList<>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        createCards(width, height);
    }

    public void activePlayer(Player p) {
        this.player = p;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void render() {
        String symbol = "▯ ";
        int counter = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                colour = ANSI_RESET;
                if (player != null && player.getX() == x && player.getY() == y) {
                    colour = ANSI_GREEN;
                }

                if (cards.get(counter).isCleared()) {
                    symbol = cards.get(counter).getSymbol() + " ";
                } else {
                    symbol = "▯ ";
                }
                // symbol = cards.get(counter).getSymbol() + " ";
                counter++;

                System.out.print(colour + symbol + ANSI_RESET);
            }
            System.out.println();
        }
    }

    private void createCards(int w, int h) { 
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                Card card = new Card(x, y);
                cards.add(card);
            }
        }
        addSymbols(w * h);
    }

    private void addSymbols(int board) {
        String[] symbols = new String[board];
        int counter = 0;
        for (int i = 0; i < symbols.length; i += 2) {
            symbols[i] = Symbol.getSymbol(counter);
            symbols[i + 1] = Symbol.getSymbol(counter);
            counter++;
        }
        shuffleArray(symbols);
        for(int i = 0; i < cards.size(); i++) {
            cards.get(i).setSymbol(symbols[i]);
        }
    }

    // Implementing Fisher–Yates shuffle ( https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array )
    static String[] shuffleArray(String[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
    
    public void clearCard(int x, int y) {
        int i = width * y + x;
        cards.get(i).clear();
    }
}