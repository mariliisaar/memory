public class Card {
    private int x;
    private int y;
    private boolean turned;
    private boolean cleared;
    private String symbol;

    public Card(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.symbol = s;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isTurned() {
        return turned;
    }

    public boolean isCleared() {
        return cleared;
    }
}
