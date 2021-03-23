public class Player implements MovableObject {
    private int x;
    private int y;
    private String name;
    private int score;

    private Direction direction;

    public Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = Direction.RIGHT;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDirection(Direction d, Board b) {
        this.direction = d;
        move(b.getWidth(), b.getHeight());
    }

    public void move(int w, int h) {
        switch(this.direction) {
            case UP:
                if (this.y > 0) {
                    this.y--;
                } else {
                    this.y = h - 1;
                }
                break;
            case RIGHT:
                if (this.x < w - 1) {
                    this.x++;
                } else {
                    this.x = 0;
                }
                break;
            case DOWN:
                if (this.y < h - 1) {
                    this.y++;
                } else {
                    this.y = 0;
                }
                break;
            case LEFT:
                if (this.x > 0) {
                    this.x--;
                } else {
                    this.x = w - 1;
                }
                break;
            default:
                break;
        }
    }
}
