public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    /**
     * Prints the current state of the maze.
     */
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    /**
     * Public wrapper method to start the maze-solving process.
     * It finds the starting 'S' position and begins the recursive search.
     * @return true if a path is found, false otherwise.
     */
    public boolean solve() {
        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
            if (startRow != -1) {
                break;
            }
        }

        if (startRow != -1) {
            return solve(startRow, startCol);
        }

        return false;
    }

    /**
     * The core recursive method to solve the maze.
     * @param row The current row position.
     * @param col The current column position.
     * @return true if this position leads to a solution, false otherwise.
     */
    private boolean solve(int row, int col) {
        // 1. Base cases

        // Out of bounds
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length) {
            return false;
        }

        // Hit a wall or already visited path
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }

        // Found the finish
        if (maze[row][col] == 'F') {
            return true;
        }

        // If it's not start or open space, reject it
        if (maze[row][col] != 'S' && maze[row][col] != ' ') {
            return false;
        }

        // 2. Mark current position as part of the path
        // Keep 'S' unchanged, only mark open spaces
        if (maze[row][col] == ' ') {
            maze[row][col] = '.';
        }

        // Try North, East, South, West
        if (solve(row - 1, col)) { // North
            return true;
        }
        if (solve(row, col + 1)) { // East
            return true;
        }
        if (solve(row + 1, col)) { // South
            return true;
        }
        if (solve(row, col - 1)) { // West
            return true;
        }

        // 3. Backtrack if this is a dead end
        if (maze[row][col] == '.') {
            maze[row][col] = ' ';
        }

        return false;
    }

    public static void main(String[] args) {

        // Maze with a solution
        char[][] mazeToSolve = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver1 = new MazeSolver(mazeToSolve);

        System.out.println("Original Maze 1:");
        solver1.printMaze();

        if (solver1.solve()) {
            System.out.println("Solution Found for Maze 1:");
        } else {
            System.out.println("No Solution Found for Maze 1:");
        }
        solver1.printMaze();

        // Maze without a solution
        char[][] noSolutionMaze = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver2 = new MazeSolver(noSolutionMaze);

        System.out.println("Original Maze 2:");
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("Solution Found for Maze 2:");
        } else {
            System.out.println("No Solution Found for Maze 2:");
        }
        solver2.printMaze();
    }
}
