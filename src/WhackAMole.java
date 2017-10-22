public class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    public WhackAMole(int numAttempts, int gridDimension){
        attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        // initialize the grid with * as chars to denote that the grid is empty
        for(int i=0;i<moleGrid.length;i++){
            for(int j=0;j<moleGrid[i].length;j++){
                moleGrid[i][j] = '*';
            }
        }
    }

    public int getMolesLeft() {
        return molesLeft;
    }

    public int getScore() {
        return score;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean place(int x, int y){
        boolean success = false;
        if(moleGrid[x][y] == '*'){
            moleGrid[x][y] = 'M';
            // update the number of moles left
            molesLeft++;
            success = true;
        }
        return success;
    }

    public void whack(int x, int y){
        if(molesLeft > 0 || attemptsLeft > 0) {
            if (moleGrid[x][y] == 'M') {
                moleGrid[x][y] = 'W';
                score++;
                molesLeft--;
                attemptsLeft--;
                System.out.println("You sucessfully whacked a mole!" + "\n" +
                        "You have " + molesLeft + " moles left" + "\n" +
                        "Your score is: " + score + "\n" +
                        "You have " + attemptsLeft + " attempts left!" + "\n");
            }
            else{
                attemptsLeft--;
                System.out.println("You did not whack a mole!" + "\n" + "You have " + molesLeft + " moles left!" + "\n" +
                        "You have " + attemptsLeft + " attempts left!");
            }
        }
    }

    public void printGridToUser(){
        for(int i=0;i<moleGrid.length;i++){
            for(int j=0;j<moleGrid[i].length;j++){
                if(moleGrid[i][j] == '*' || moleGrid[i][j] == 'M'){
                    System.out.print("*");
                }
                else if(moleGrid[i][j] == 'W'){
                    System.out.print(moleGrid[i][j]);
                }
                if(j == moleGrid[i].length-1){
                    System.out.println("");
                }
            }
        }
    }

    public void printGrid(){
        for(int i=0;i<moleGrid.length;i++){
            for(int j=0;j<moleGrid[i].length;j++){
                System.out.print(moleGrid[i][j]);
                if(j == moleGrid[i].length-1){
                    System.out.println("");
                }
            }
        }
    }
}
