public class Sudoku_Solver
{
    int grid_size = 9;  // Size of the Sudoku grid

    // Check if a number is present in the specified row
    int IsNumberInRow(int board[][], int number, int row)
    {
        for(int i = 0; i < grid_size; i++)
        {
            if(board[row][i] == number)  // If the number is found in the row, return 0 (false)
            {
                return 0;
            }
        }
        return 1;  // If the number is not found in the row, return 1 (true)
    }

    // Check if a number is present in the specified column
    int IsNumberInColumn(int board[][], int number, int column)
    {
        for(int i = 0; i < grid_size; i++)
        {
            if(board[i][column] == number)  // If the number is found in the column, return 0 (false)
            {
                return 0;
            }
        }
        return 1;  // If the number is not found in the column, return 1 (true)
    }

    // Check if a number is present in the 3x3 subgrid
    int IsNumberInBox(int board[][], int number, int row, int column)
    {
        int box_row = (row / 3) * 3;  // Calculate the starting row of the 3x3 subgrid
        int box_column = (column / 3) * 3;  // Calculate the starting column of the 3x3 subgrid
        for(int i = box_row; i < box_row + 3; i++)
        {
            for(int j = box_column; j < box_column + 3; j++)
            {
                if(board[i][j] == number)  // If the number is found in the 3x3 subgrid, return 0 (false)
                {
                    return 0;
                }
            }
        }
        return 1;  // If the number is not found in the 3x3 subgrid, return 1 (true)
    }

    // Solve the Sudoku board using backtracking
    int SolveBoard(int board[][])
    {
        for(int row = 0; row < grid_size; row++)
        {
            for(int column = 0; column < grid_size; column++)
            {
                if(board[row][column] == 0)  // Find an empty cell
                {
                    for(int number = 1; number <= 9; number++)
                    {
                        // Check if the number can be placed in the cell
                        if(IsNumberInRow(board,number,row) == 1 && IsNumberInColumn(board,number,column) == 1 && IsNumberInBox(board,number,row,column) == 1)
                        {
                            board[row][column] = number;  // Place the number in the cell
                            if(SolveBoard(board) == 1)  // Recursively attempt to solve the board with the current number placed
                            {
                                return 1;  // If the board is solved, return 1 (true)
                            }
                            else
                            {
                                board[row][column] = 0;  // If placing the current number doesn't lead to a solution, reset the cell to 0 (backtrack)
                            }
                        }
                    }
                    return 0;  // If no number from 1 to 9 can be placed in the cell, return 0 (false) to trigger backtracking
                }
            }
        }
        return 1;  // If all cells are filled and valid, return 1 (true) indicating the board is solved
    }

    // Display the solved Sudoku board
    void DisplaySolvedBoard(int board[][])
    {
        int row = 0,column = 0,temp = 0,flag = 0;
        // Check if the board is solvable
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
        if(flag == 1)  // If the board cannot be solved, print a message
            System.out.println("\n\n\n\nTHIS SUDOKU PUZZLE CANNOT BE SOLVED");
        else  // If the board is solved, display the solved board
        {
            System.out.println("\n\n\n\nSOLVED SUDOKU PUZZLE\n--------------------\n");
            row = 0;
            for(int i = 0; i <= 12; i++)
            {
                column = 0;
                temp = 0;
                for(int j = 0; j <= 12; j++)
                {
                    // Display the board with grid lines
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

    // Main method to execute Sudoku_Solver
    public static void main(String args[])
    {
        System.out.println("\nUNSOLVED SUDOKU PUZZLE\n----------------------\n");
        int row = 0, column = 0, temp = 0;
        // Define the unsolved Sudoku board
        int board[][] = {{8,0,0,0,0,0,0,0,0},
                {0,0,3,6,0,0,0,0,0},
                {0,7,0,0,9,0,2,0,0},
                {0,5,0,0,0,7,0,0,0},
                {0,0,0,0,4,5,7,0,0},
                {0,0,0,1,0,0,0,3,0},
                {0,0,1,0,0,0,0,6,8},
                {0,0,8,5,0,0,0,1,0},
                {0,9,0,0,0,0,4,0,0}};
        // Display the unsolved Sudoku board
        for(int i = 0; i <= 12; i++)
        {
            column = 0;
            temp = 0;
            for(int j = 0; j <= 12; j++)
            {
                // Display the board with grid lines
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
        // Create an instance of Sudoku_Solver and display the solved board
        Sudoku_Solver ob = new Sudoku_Solver();
        ob.DisplaySolvedBoard(board);
    }
}
