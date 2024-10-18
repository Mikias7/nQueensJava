import java.util.ArrayList;

public class EightQueens2 {
    
//initialize board
    public static ArrayList<ArrayList<Integer>> initBoard(ArrayList<ArrayList<Integer>> board){
        
        //fill arraylist with 0
        for (int i = 0; i < 8; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 8; j++){
                row.add(0);
            }
            board.add(row);
        }

        //place the first queen in the first pos
        //row , col format: get(row).set(col,1)
        //board.get(0).set(0, 1);
        
        return board;
    }

//print board
    public static void printBoard(ArrayList<ArrayList<Integer>> board){
         //print board
         for (int i = 0; i < board.size();i++){
            System.out.println(board.get(i));
        }
    }


//solve
    public static boolean solve(ArrayList<ArrayList<Integer>> board){

        
        for (int i = 0; i < board.size(); i++){
            for (int j = 0; j < board.size(); j++){
                
                boolean validPosition = checkValid(board, i, j);
                //place queen 
                if (validPosition){
                    //System.out.println("here");
                    board.get(i).set(j,1);
                    System.out.println(" ");
                    printBoard(board);

                    if (solve(board)){
                        return true;
                    }
                    //check if queen is present in each row
                    if(checkQueens(board)){
                        board.get(i).set(j,0);
                    }
                }
            }
        }
        
    
        return false;
    }

//check valid position 
public static boolean checkValid(ArrayList<ArrayList<Integer>> board, int row, int column) {
    //check if the row is valid (no 1s)
    if (board.get(row).contains(1)) {
        return false;
    }

    //check if the column is valid (no 1s)
    for (int i = 0; i < board.size(); i++) {
        if (board.get(i).get(column) == 1) {
            return false;
        }
    }

    //check the diagonal (down-right)
    for (int i = row, j = column; i < board.size() && j < board.get(0).size(); i++, j++) {
        if (board.get(i).get(j) == 1) {
            return false;
        }
    }

    //check the diagonal (up-left)
    for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
        if (board.get(i).get(j) == 1) {
            return false;
        }
    }

    //check the diagonal (down-left)
    for (int i = row, j = column; i < board.size() && j >= 0; i++, j--) {
        if (board.get(i).get(j) == 1) {
            return false;
        }
    }

    //check the diagonal (up-right)
    for (int i = row, j = column; i >= 0 && j < board.get(0).size(); i--, j++) {
        if (board.get(i).get(j) == 1) {
            return false;
        }
    }

    //if no checks failed, it's valid
    return true;
}


//check queen in each column 
    public static boolean checkQueens(ArrayList<ArrayList<Integer>> board){
        int counter = 0;
        for (int i = 0; i < board.size(); i++){
            if (board.get(i).contains(1)){
                counter++;
            }
        }
        if (counter == 8){
            return false;
        }else{
            return true;
        }
        
    }

    public static void main(String[] args) {
       ArrayList<ArrayList<Integer>> newBoard = new ArrayList<>();
       ArrayList<ArrayList<Integer>> board = initBoard(newBoard);
       solve(board);

    }
}
