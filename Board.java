public class Board {
    private int width;
    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render() {
        char symbol;

        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                if (y == 0 || y == height) {
                    symbol = '-';
                } else if ( x == 0 || x == width) {
                    symbol = '|';
                } else {
                    symbol = ' ';
                }
            }
        }
    }
    
}