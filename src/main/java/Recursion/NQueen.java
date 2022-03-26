package Recursion;

public class NQueen {
    public static void main(String[] args) {
        // Max size of chess board
        int board[][] = new int[20][20];
        // input
        int n=20;
        boolean isSolved = solveNQueen(n,board,0);
        System.out.println(isSolved);
    }

    /**
     * This method will recursively solve N Queen problem for ever row and take size of board , board and i(row no) as arg
     * @param n
     * @param board
     * @param i
     * @return
     */
    static boolean solveNQueen(int n,int board[][],int i)
    {
        // base case
        // Stop when last row is reached
        if(i == n)
        {
           printBoard(n,board);
           return true;
        }
        // recursion
        // try placing queen at every row
        for(int j=0;j<n;j++)
        {
            // for each row and colum combination check if it can be placed or not
            if(canPlace(board,n,i,j))
            {
                // put the queen at position
                board[i][j] = 1;
                // recursively solve n queen for new row
                boolean success = solveNQueen(n,board,i+1);
                // if success then propagate success back
                if(success)
                {
                    return true;
                }
                // backtrack if not a success by resetting current i and j
                board[i][j] = 0;
            }
        }
        // reaching at this point means queen cannot be placed at this level so propagate back
        return false;
    }

    /**
     * This method takes board , board size , row and column as arg and check if there is any queen at colum leve or left diagonal or right diagonal
     * Reason for not checking below and left is , we are moving from top to bottom
     * @param board
     * @param n
     * @param i
     * @param j
     * @return
     */
    private static boolean canPlace(int[][] board, int n, int i, int j) {
        // check top/column
        for(int k = 0; k<i;k++)
        {
            if(board[k][j]==1)
                return false;
        }
         // check diagonal left and diagonal right
        int x = i;
        int y = j;
        while (x>=0 && y >=0)
        {
            if(board[x][y]==1)
                return false;
            // checking left diagonal
            x--;y--;
        }
         x = i;
         y = j;
         while (x>=0 && y<n)
         {
             if(board[x][y]==1)
                 return false;
         // y will increase for right diagonal
         x--;y++;
         }
        return true;
    }

    /**
     * This method will print board
     * @param n
     * @param board
     */
    public static void printBoard(int n,int board[][])
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(board[i][j]+"  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
