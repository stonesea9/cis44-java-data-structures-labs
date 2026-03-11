
Fractals are complex patterns that are self-similar across different scales. In this lab, you will use binary recursion to draw a fractal tree using Java's Swing or AWT graphics libraries.

Background
A fractal tree is drawn by starting with a trunk and then branching off into smaller and smaller branches. You will create a recursive method, for example drawTree(Graphics g, int x1, int y1, double angle, int depth), which draws a branch and then calls itself twice to draw two new sub-branches.

The Recursive Logic
Base Case (Stopping Condition):
The recursion stops when a certain depth is reached (e.g., when depth == 0). This prevents the branches from becoming infinitely small.
Recursive Step:
Calculate the end point (x2, y2) of the current branch based on its start point, angle, and length (which should decrease with depth).
Draw a line from the start point to the end point.
Make two recursive calls from the end of the current branch: one for a left sub-branch (e.g., angle - 20) and one for a right sub-branch (e.g., angle + 20), both with a decremented depth (depth - 1).
Your Task
Create a FractalTree.java class that extends JPanel.
Override the paintComponent(Graphics g) method to start the recursion.
Implement the recursive drawTree method.
Create a main method to set up a JFrame to display your panel.
