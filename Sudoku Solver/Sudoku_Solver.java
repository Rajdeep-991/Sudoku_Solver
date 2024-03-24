public class Sudoku_Solver
{
    int grid_size = 9;
    int IsNumberInRow(int board[][], int number, int row)
    {
        for(int i = 0; i < grid_size; i++)
        {
            if(board[row][i] == number)
            {
                return 0;
            }
        }
        return 1;
    }
    int IsNumberInColumn(int board[][], int number, int column)
    {
        for(int i = 0; i < grid_size; i++)
        {
            if(board[i][column] == number)
            {
                return 0;
            }
        }
        return 1;
    }
    int IsNumberInBox(int board[][], int number, int row, int column)
    {
        int box_row = (row / 3) * 3;
        int box_column = (column / 3) * 3;
        for(int i = box_row; i < box_row + 3; i++)
        {
            for(int j = box_column; j < box_column + 3; j++)
            {
                if(board[i][j] == number)
                {
                    return 0;
                }
            }
        }
        return 1;
    }
    int SolveBoard(int board[][])
    {
        for(int row = 0; row < grid_size; row++)
        {
            for(int column = 0; column < grid_size; column++)
            {
                if(board[row][column] == 0)
                {
                    for(int number = 1; number <= 9; number++)
                    {
                        if(IsNumberInRow(board,number,row) == 1 && IsNumberInColumn(board,number,column) == 1 && IsNumberInBox(board,number,row,column) == 1)
                        {
                            board[row][column] = number;
                            if(SolveBoard(board) == 1)
                            {
                                return 1;
                            }
                            else
                            {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return 0;
                }
            }
        }
        return 1;
    }
    void DisplaySolvedBoard(int board[][])
    {
        int row = 0,column = 0,temp = 0,flag = 0;
        for(int i = 0; i <= 12; i++)
        {
            column = 0;
            temp = 0;
            for(int j = 0; j <= 12; j++)
            {
                if(SolveBoard(board) == 1)
                {
                    column++;
                    temp = 1;
                }
                else
                {
                    flag = 1;
                    break;
                }
            }
            if(temp == 1)
                row++;
            if(flag == 1)
                break;
        }
        if(flag == 1)
            System.out.println("\n\n\n\nTHIS SUDOKU PUZZLE CANNOT BE SOLVED");
        else
        {
            System.out.println("\n\n\n\nSOLVED SUDOKU PUZZLE\n--------------------\n");
            row = 0;
            for(int i = 0; i <= 12; i++)
            {
                column = 0;
                temp = 0;
                for(int j = 0; j <= 12; j++)
                {
                    if((i == 0 && j == 0) || (i == 0 && j == 12) || (i == 12 && j == 0) || (i == 12 && j == 12))
                        System.out.print("+ ");
                    else if(i == 0 || i == 12)
                        System.out.print("- ");
                    else if(j == 0 || j == 12)
                        System.out.print("| ");
                    else if(j == 4 || j == 8)
                        System.out.print("| ");
                    else if(i == 4 || i == 8)
                        System.out.print("- ");
                    else
                    {
                        if(SolveBoard(board) == 1)
                        {
                            System.out.print(board[row][column] + " ");
                            column++;
                            temp = 1;
                        }
                    }
                }
                if(temp == 1)
                    row++;
                System.out.println();
            }
        }
    }
    public static void main(String args[])
    {
        System.out.println("\nUNSOLVED SUDOKU PUZZLE\n----------------------\n");
        int row = 0, column = 0, temp = 0;
        int board[][] = {{8,0,0,0,0,0,0,0,0},
                {0,0,3,6,0,0,0,0,0},
                {0,7,0,0,9,0,2,0,0},
                {0,5,0,0,0,7,0,0,0},
                {0,0,0,0,4,5,7,0,0},
                {0,0,0,1,0,0,0,3,0},
                {0,0,1,0,0,0,0,6,8},
                {0,0,8,5,0,0,0,1,0},
                {0,9,0,0,0,0,4,0,0}};
        for(int i = 0; i <= 12; i++)
        {
            column = 0;
            temp = 0;
            for(int j = 0; j <= 12; j++)
            {
                if((i == 0 && j == 0) || (i == 0 && j == 12) || (i == 12 && j == 0) || (i == 12 && j == 12))
                    System.out.print("+ ");
                else if(i == 0 || i == 12)
                    System.out.print("- ");
                else if(j == 0 || j == 12)
                    System.out.print("| ");
                else if(j == 4 || j == 8)
                    System.out.print("| ");
                else if(i == 4 || i == 8)
                    System.out.print("- ");
                else
                {
                    System.out.print(board[row][column] + " ");
                    column++;
                    temp = 1;
                }
            }
            if(temp == 1)
                row++;
            System.out.println();
        }
        Sudoku_Solver ob = new Sudoku_Solver();
        ob.DisplaySolvedBoard(board);
    }
}