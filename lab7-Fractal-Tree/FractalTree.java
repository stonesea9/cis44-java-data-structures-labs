import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    private final int MAX_DEPTH = 9; // 控制树的复杂程度

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

         // Start the recursion from the bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;

        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

   /**
     * Recursively draws a fractal tree.
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The angle of the branch in degrees.
     * @param depth The current recursion depth.
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {

        // Base Case
        if (depth == 0) {
            return;
        }
        // Calculate the length of the current branch (it should get smaller with depth).
        // Calculate the end point (x2, y2) of the branch using trigonometry.
        // Remember to convert the angle to radians: Math.toRadians(angle)
       // Draw the line for the current branch.
        int length = depth * 10;
        double radians = Math.toRadians(angle);

        
        int x2 = x1 + (int)(length * Math.cos(radians));
        int y2 = y1 + (int)(length * Math.sin(radians));
        g.drawLine(x1, y1, x2, y2);

         // Make two recursive calls for the left and right sub-branches.
        // - Branch left by subtracting from the angle (e.g., angle - 20).
        // - Branch right by adding to the angle (e.g., angle + 30).
        // - Decrease the depth for both calls (depth - 1).
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Recursive Fractal Tree");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);

        frame.add(new FractalTree());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
