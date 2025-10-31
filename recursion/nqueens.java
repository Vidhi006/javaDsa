import java.util.*;
public class nqueens {
    public static void main(String[]args) {
        int n = 9;
        char[][] board = new char[n][n];
        for(char[]a : board){
            Arrays.fill(a,'.');
        } 
        //List<List<String>> res = new ArrayList<>();
        solve(board , n ,0 );
    }
    public static void solve(char[][]board , int n , int row ){
       // if(row>n) return;
        if(row == n){
            for(char[]temp :board){
                System.out.print(Arrays.toString(temp));
            }
            System.out.println();
            return;
        }
        for(int i =0 ; i<n;i++){
             if(issafe(board , row , i , n)==true){
                board[row][i] ='Q';
                solve(board ,n, row+1 );
                board[row][i] = '.';
            }
        }
    }
    public static boolean issafe(char[][]board , int row , int col , int n ){
        //for row
        for(int a = 0 ; a<n ; a++){
            if(board[row][a]== 'Q') return false;

        }
        //for column
        for(int a = 0 ; a<n ;a++){
            if(board[a][col] == 'Q') return false;
        }

        //for Left Diagonal
        int temp_row = row;
        int temp_col = col;
        while(temp_row>= 0 && temp_col>=0){
            if(board[temp_row][temp_col] == 'Q')return false;
            temp_row--;
            temp_col--;
        }

        //for right diagonal
        int r = row;
        int c = col;
        while(r>=0 && c<n){
            if(board[r][c] == 'Q')return false;
            r--;
            c++;
        }

        return true;
    }
}
