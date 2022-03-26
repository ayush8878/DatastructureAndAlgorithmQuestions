package Recursion;

public class Sudoku {
    // issue with logic not working
    public static void main(String[] args) {
        // here n is no from 0 to 9
        int n=9;
        int mat[][] =
        {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        if(!solveSudoku(mat,0,0,n))
        {
            System.out.println("No solution exists!");
        }
    }

    private static boolean solveSudoku(int[][] mat, int i, int j, int n) {
        // base case
        if(i == n)
        {
            // print sudoku
            printMatrix(mat);
            return true;
        }

        //rec cases

        // reached row boundary, time to move at the start of next row
        if(j == n)
        {
            return solveSudoku(mat,i+1,0,n);
        }

        // skipping prefilled cells and only processing empty cells
        if(mat[i][j]!=0)
        {
            return solveSudoku(mat,i,j+1,n);
        }

        // cell to be filled
        // try out all possibilities
        for(int no = 1;no <= n ; no++)
        {
            // weather it is safe to place the number or not
            if(isSafe(mat,i,j,no,n))
            {
                mat[i][j] = no;
                boolean solveSubProblem = solveSudoku(mat,i,j+1,n);
                if(solveSubProblem == true )
                {
                    return true;
                }
            }
        }

        // if no option works
        mat[i][j] = 0;
        return false;
    }

    private static boolean isSafe(int[][] mat, int i, int j, int no, int n) {
        // check for row and col
        for(int k=0;k<n;k++)
        {
            if(mat[k][j] == no || mat[i][k] == no)
            {
                return false;
            }
        }
        // check for subgrid

        int sx = (i/3)*3;
        int sy = (j/3)*3;

        for(int x=sx;x < sx+3;x++)
        {
            for (int y = 0; y < sy + 3; y++) {
             if(mat[x][y] == no)
             {
                 return false;
             }
            }
        }
        return true;
    }

    /**
     * This method will print board
     * @param
     * @param board
     */
    public static void printMatrix(int board[][])
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]+"  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
