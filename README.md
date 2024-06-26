Sudoku Solver
-------------

Overview
--------
This project is a Java implementation of a Sudoku solver using backtracking. The program reads an unsolved Sudoku puzzle, attempts to solve it, and displays the solved puzzle. If the puzzle cannot be solved, it informs the user.

Features
--------
- Sudoku Validation: Checks whether a number can be placed in a specific row, column, and 3x3 subgrid.
- Backtracking Algorithm: Uses a backtracking algorithm to recursively try possible solutions and backtrack when a solution is not valid.
- Puzzle Display: Displays both the initial unsolved Sudoku puzzle and the solved puzzle in a formatted manner.

Requirements
------------
- Java Development Kit (JDK)

How to Use
----------
- Ensure you have the Java Development Kit (JDK) installed.
- Copy the provided code into a Java file, e.g., Sudoku_Solver.java.
- Compile the Java file using:

  javac Sudoku_Solver.java
- Run the compiled Java program:

  java Sudoku_Solver
- The program will display the initial unsolved Sudoku puzzle and attempt to solve it.
- If the puzzle is solvable, the solved puzzle will be displayed. If not, a message will indicate that the puzzle cannot be solved.

How It Works
------------
- Validation Methods:
  - IsNumberInRow: Checks if a number is present in the specified row.
  - IsNumberInColumn: Checks if a number is present in the specified column.
  - IsNumberInBox: Checks if a number is present in the 3x3 subgrid.

- Solving Method:
  - SolveBoard: Uses a recursive backtracking algorithm to solve the puzzle.

- Display Method:
  - DisplaySolvedBoard: Displays the solved Sudoku board or an unsolvable message if no solution exists.

- Main Method:
  - Initializes the board, displays the unsolved puzzle, and calls the solver to display the result.

Notes
-----
- The sample unsolved Sudoku puzzle is hardcoded in the main method.
- The program uses standard output to display the puzzle.
- The backtracking algorithm ensures that the solution, if it exists, is found efficiently.
