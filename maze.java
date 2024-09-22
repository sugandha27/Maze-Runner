import java.util.*;

public class maze {
    private static final int WIDTH = 21;  // Number of columns (must be odd)
    private static final int HEIGHT = 21; // Number of rows (must be odd)
    private static final int[][] maze = new int[HEIGHT][WIDTH];

    // Directions: right, down, left, up (dx and dy arrays represent the column and row changes)
    private static final int[] dx = {2, 0, -2, 0};
    private static final int[] dy = {0, 2, 0, -2};

    public static void main(String[] args) {
        initializeMaze();   // Initialize the maze with all walls
        generateMaze(1, 1); // Start generating from (1, 1) to ensure odd cell positioning
        printMaze();
    }

    private static void initializeMaze() {
        // Initialize all cells as walls (0 represents walls, 1 represents paths)
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                maze[y][x] = 0; // Mark all cells as walls initially
            }
        }
    }

    private static void generateMaze(int x, int y) {
        maze[y][x] = 1; // Mark the current cell as a path
        
        // Randomly shuffle the direction order
        List<Integer> directions = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(directions);
        
        for (int direction : directions) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // Check if the new cell is within the maze bounds and hasn't been visited
            if (isInBounds(nx, ny) && maze[ny][nx] == 0) {
                // Remove the wall between the current cell and the next cell
                maze[y + dy[direction] / 2][x + dx[direction] / 2] = 1;

                generateMaze(nx, ny); // Recursively generate the maze from the next cell
            }
        }
    }

    private static boolean isInBounds(int x, int y) {
        return x > 0 && x < WIDTH && y > 0 && y < HEIGHT;
    }

    private static void printMaze() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(maze[y][x] == 1 ? "  " : "██"); // Display '██' as walls and spaces as paths
            }
            System.out.println();
        }
    }
}
