public class Card {
    private int x;
    private int y;
    private boolean turned = false;
    private boolean cleared = false;
    private String symbol;

    public Card(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isTurned() {
        return turned;
    }

    public void turnCardUp() {
            turned = true;       
    }

    public void turnCardDown() {
        turned = false;       
}

    public boolean isCleared() {
        return cleared;
    }

    public void clear() {
        cleared = true;
    }
}
