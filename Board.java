public class Board {
    private int width;
    private int height;
    private Player player;    
    private String colour;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void activePlayer(Player p) {
        this.player = p;
    }

    public void render() {
        String symbol = "▯ ";

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                colour = ANSI_RESET;
                if (player != null && player.getX() == x && player.getY() == y) {
                    colour = ANSI_GREEN;
                }
                System.out.print(colour + symbol + ANSI_RESET);
            }
            System.out.println();
        }
    }    
}