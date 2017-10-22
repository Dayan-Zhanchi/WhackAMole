import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int dimension = 2;
        int attempts = dimension*dimension/2;
        WhackAMole game = new WhackAMole(attempts, dimension);
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        // Fill the board with the number dimension has been assigned moles
        for(int i=0;i<dimension;i++){
            int randomPositionX = r.nextInt(dimension);
            int randomPositionY = r.nextInt(dimension);
            while(!game.place(randomPositionX, randomPositionY)){
                randomPositionX = r.nextInt(dimension);
                randomPositionY = r.nextInt(dimension);
            }
        }
        System.out.println("Welcome to the game of Whack a mole!");
        System.out.println("You have a maximum of " + attempts + " attempts to get all the moles");
        System.out.println("Please enter the x coordinate followed by the y coordinate to whack a mole: ");
        while(true){
            if(game.getAttemptsLeft() > 0) {
                System.out.print(">");
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (x == -1 && y == -1) {
                    game.printGrid();
                    break;
                } else if (x == -2 && y == -2) {
                    game.printGridToUser();
                } else {
                    game.whack(x, y);
                    if (game.getMolesLeft() == 0) {
                        System.out.println("You won the game! You have whacked all the moles!");
                        System.out.println("Your score is: over 9000!");
                        break;
                    }
                }
            }
            else{
                System.out.println("You lost the game! You didn't whack all the moles in "+ attempts +" attempts!");
                System.out.println("You managed to whack a total of: " + game.getScore() + "out of " + game.getMolesLeft() + " moles");
                System.out.println("Your score was: " + game.getScore());
                break;
            }
        }
    }
}
