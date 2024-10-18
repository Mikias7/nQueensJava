import java.util.ArrayList;

public class EightQueens {
    
//print board
    public static ArrayList<ArrayList<Integer>> printBoard(){
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();

        //fill arraylist with 0
        for (int i = 0; i < 8; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 8; j++){
                row.add(0);
            }
            board.add(row);
        }

        //place the first queen in the first pos
        board.get(0).set(0, 1);
        
        //print board
        for (int i = 0; i < board.size();i++){
            System.out.println(board.get(i));
        }

        return board;
    }
//solve
    public static boolean solve(ArrayList<ArrayList<Integer>> board){
        //check if queen is palced on that position
        int[] find = checkEmptySpace(board);

        if (find != null){
            return true;
        }else{
            int row = find[0];
            int col = find[1];
        

        for (int i = 0;i < board.size(); i++){
            boolean val = checkValid(board,col, row);
            if (val){
                // place a queen 
                System.out.println("here");
                board.get(row).set(col, 1);

                if (solve(board)){
                    return true;
                }
            
                return false;
            }
        }
    }

        return false;
    }

//check valid space 
    public static boolean checkValid(ArrayList<ArrayList<Integer>> board, int column, int row){
        ArrayList<Integer> newRow = board.get(column);
        //check row
        if (newRow.contains(1)){
            return false;
        }
        //check column
        for (int i = 0; i < board.size(); i++){
            ArrayList<Integer> newColumn = board.get(i);
            if (newColumn.get(column) == 1){
                return false;
            }
        }

        //check diagonal 
        //check diagonal from top right corner to bottom left
        for (int i = 0; i < board.size(); i++){
            ArrayList<Integer> newColumn1 = board.get(i);
            if (newColumn1.get(i) == 1){
                return false;
            }
        }
        //check diagonal from top left to bottom right
        for (int i = board.size(); i < 0; i--){
            ArrayList<Integer> newColumn2 = board.get(i);
            if (newColumn2.get(i) == 1){
                return false;
            }
        }

        return true;
    }

//check empty space
    public static int[] checkEmptySpace(ArrayList<ArrayList<Integer>> board){
        for (int i = 0; i < board.size(); i++){
            for (int j = 1; j < board.size() - 1; j++){
                if (board.get(i).get(j + 1) == 0){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        printBoard();
        System.out.println(" ");
        solve(printBoard());
        System.out.println(" ");
        printBoard();
    }
}
