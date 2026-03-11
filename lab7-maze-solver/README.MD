
Background
Imagine a maze represented by a 2D grid. Some cells are open paths (' '), some are walls ('#'), one is the start ('S'), and one is the finish ('F'). Your goal is to write a method that recursively explores the maze to find a path from 'S' to 'F'.

The core idea is a recursive method, perhaps called solve(row, col), that returns true if a path is found from the given (row, col) to the finish, and false otherwise.

The Recursive Logic
Base Cases (Stopping Conditions):
If the current cell (row, col) is outside the maze boundaries, it's not a valid path. Return false.
If the current cell is a wall ('#') or has already been visited, it's not a valid path. Return false.
If the current cell is the finish ('F'), you've found a solution! Return true.
Recursive Step:
Mark the current cell as part of the path (e.g., with a '.') to avoid cycles.
Recursively try to solve from the cell to the North, then East, then South, then West. If any of these calls return true, you have found a path, so return true immediately.
If none of the recursive calls find a path, this cell must be a dead end. Backtrack by un-marking the cell (change it back from '.' to ' ') and return false. This is a crucial step!
Your Task
Create a MazeSolver.java class.
Implement the recursive solve() method.
Include a main method that initializes a maze, creates a solver, attempts to solve it, and prints the final maze.
Test your solver on at least two mazes: one with a solution and one without.
