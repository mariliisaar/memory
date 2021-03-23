import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static int playerCount = 0;
    public static int cardsTurned = 0;
    public static boolean playersChosen = false;
    public static boolean finishedGame = false;
    public static boolean finishedTurn = false;
    public static ArrayList<Player> players = new ArrayList<>();
    public static void main(String[] args){
        String input = "";
        Scanner scanner = new Scanner(System.in);
        Board gameBoard = new Board(4,4);
        System.out.println("Mängida saavad kuni neli mängijat. ");
        while(!playersChosen && playerCount <4){
            String playerName = "";
            System.out.println("Sisestage mängija nimi:");
            playerName = scanner.nextLine();
            createPlayer(playerName);
        }
        /*for(Player p:players){
            System.out.println(p.getName());
        }*/
        gameBoard.activePlayer(players.get(0));
        gameBoard.render();
        while(!finishedGame){
            for(Player p:players){
                System.out.println("Mängib " + p.getName());
                finishedTurn = false;
                cardsTurned = 0;
                gameBoard.activePlayer(p);
                while(!finishedTurn){
                    input = scanner.nextLine().toLowerCase();
                    playerTurn(input, p, gameBoard);
                    gameBoard.render();
                }
            }
        }
        scanner.close();
    }

    public static void createPlayer(String playerName){
        playerCount++;
        if(playerCount == 1 &&(playerName==null || playerName.equals(""))){
            System.out.println("Vähemalt üks mängija peab olema nimetatud.");
            playerCount--;
        }else if(playerName == null || playerName.equals("")){
            playersChosen=true;
        }else{
            Player player = new Player(playerName,0,0);
            players.add(player);
        }
    }

    public static void playerTurn(String input, Player player, Board gameBoard){
        if (input.equals("")){
            player.move(gameBoard.getWidth(), gameBoard.getHeight());
        } else if (input.equals("a")){
            player.setDirection(Direction.LEFT, gameBoard);
        } else if (input.equals("d")){
            player.setDirection(Direction.RIGHT, gameBoard);
        } else if (input.equals("w")){
            player.setDirection(Direction.UP, gameBoard);
        } else if (input.equals("s")){
            player.setDirection(Direction.DOWN, gameBoard);
        } else if (input.equals(" ")){
            cardsTurned++;
        }else if (input.equals("quit")){
            finishedGame = true;
            finishedTurn = true;
        }
        if(cardsTurned==2){
            finishedTurn = true;
        }
    }
}