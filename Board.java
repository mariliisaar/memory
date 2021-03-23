import java.util.ArrayList;

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
                counter++;

                System.out.print(colour + symbol + ANSI_RESET);
            }
            System.out.println();
        }
    }

    private void createCards(int w, int h) { 
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                Card card = new Card(x, y, Symbol.getSymbol(1));
                cards.add(card);
            }
        }
    }
    
    public void clearCard(int x, int y) {
        int i = width * y + x;
        cards.get(i).clear();
    }
}