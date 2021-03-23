import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static int playerCount = 0;
    public static int cardsTurned = 0;
    public static int pairsFound = 0;
    public static Card firstCard;
    public static Card secondCard;
    public static boolean playersChosen = false;
    public static boolean finishedGame = false;
    public static boolean finishedTurn = false;
    public static ArrayList<Player> players = new ArrayList<>();
    public static void main(String[] args){
        String input = "";
        Scanner scanner = new Scanner(System.in);
        Board gameBoard = new Board(4,4);
        System.out.println("Mängida saavad kuni neli mängijat. ");
        while(!playersChosen && playerCount <4){ //Let's see who is playing.
            String playerName = "";
            System.out.println("Sisestage mängija nimi:");
            playerName = scanner.nextLine();
            createPlayer(playerName);
        }
        gameBoard.activePlayer(players.get(0)); //Sets the first players position to immediately highlight a tile.
        gameBoard.render(); //Time to render the board for the first time.
        while(!finishedGame){ //Let's begin the game!
            for(Player p:players){ //Every player gets their turn!
                if(!finishedGame){ //...assuming the game has not finished.
                    System.out.println("Mängib " + p.getName());
                    finishedTurn = false;
                    cardsTurned = 0;
                    firstCard = null;
                    secondCard = null;
                    gameBoard.activePlayer(p);
                    while(!finishedTurn){ //And they get to play when it is their turn.
                        input = scanner.nextLine().toLowerCase();
                        playerTurn(input, p, gameBoard);
                        gameBoard.render();
                    }
                }
            }
        }
        String winner = "";
        int highScore = 0;
        for(Player p:players){ //Time to see who won!
            if(p.getScore() > highScore){
                highScore = p.getScore();
                winner = p.getName();
            } else if(p.getScore() == highScore && highScore != 0){ //Is there a tie?
                winner = winner+" ja "+p.getName();
            } 
        }
        if(highScore>0){ //If the game was not quit before any pairs were found, we will declare a winner.
            System.out.println("Mängu võitis "+ winner +" "+ highScore + " punktiga.");
        }
        scanner.close();
    }

    public static void createPlayer(String playerName){ //The method createPlayer creates a player.
        playerCount++;
        if(playerCount == 1 &&(playerName==null || playerName.equals(""))){ //Making sure we get at least one player for the game.
            System.out.println("Vähemalt üks mängija peab olema nimetatud.");
            playerCount--;
        }else if(playerName == null || playerName.equals("")){ //If no additional names are added, we allow to continue on with less than maximum amount of players.
            playersChosen=true;
        }else{ //If none of the exceptions are met, we shall make a player!
            Player player = new Player(playerName,0,0);
            players.add(player);
        }
    }

    public static void playerTurn(String input, Player player, Board gameBoard){ //This cycles our turns, managing movement, activation and scoring points.
        if (input.equals("")){ //If an empty line is entered, the player moves in their previous or default direction.
            player.move(gameBoard.getWidth(), gameBoard.getHeight());
        } else if (input.equals("a")){ //Using the common WASD setup, we allow the player to move with the keys present.
            player.setDirection(Direction.LEFT, gameBoard);
        } else if (input.equals("d")){
            player.setDirection(Direction.RIGHT, gameBoard);
        } else if (input.equals("w")){
            player.setDirection(Direction.UP, gameBoard);
        } else if (input.equals("s")){
            player.setDirection(Direction.DOWN, gameBoard); //This ends the movement section.
        } else if (input.equals(" ") && (firstCard == null || player.getX() != firstCard.getX() || player.getY() != firstCard.getY()) && !gameBoard.isCardCleared(player.getX(), player.getY())){ //If the player activates the card below them and it is not already cleared or the same card that they have already activated this turn, we shall activate the card the player has chosen.
            cardsTurned++; //This marks the flipping of a card.
            if(cardsTurned==1){  //Upon a card, the card's information gets stored within our temporary Card object for ease of access.
                firstCard = gameBoard.getCard(player.getX(), player.getY());
            } else {
                secondCard = gameBoard.getCard(player.getX(), player.getY());
                gameBoard.render(); //To ensure that the players actually see the second card flipped, we will render the board here as well.
            }
        } else if (input.equals(" ") && gameBoard.isCardCleared(player.getX(), player.getY())){ //In case the player tries to choose a card that has already been cleared, we tell them to try a card that has not been cleared yet.
            System.out.println("Valitud kaart on juba leitud. Valige muu kaart.");
        }else if (input.equals("quit")){ //If the player enters quit, the game ends with the scores still attached to the players, so if someone technically has a lead, they can just grab the win and run.
            finishedGame = true;
            finishedTurn = true;
        }
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
}