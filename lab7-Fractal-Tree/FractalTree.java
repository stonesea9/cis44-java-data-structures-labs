import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    private final int MAX_DEPTH = 9; // 控制树的复杂程度

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 从窗口底部中间开始画树
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;

        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /**
     * 递归绘制分形树
     * @param g Graphics绘图对象
     * @param x1 起点x
     * @param y1 起点y
     * @param angle 当前分支角度
     * @param depth 当前递归深度
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {

        // Base Case：递归停止条件
        if (depth == 0) {
            return;
        }

        // 当前树枝长度（深度越小越短）
        int length = depth * 10;

        // 把角度转换为弧度
        double radians = Math.toRadians(angle);

        // 计算终点
        int x2 = x1 + (int)(length * Math.cos(radians));
        int y2 = y1 + (int)(length * Math.sin(radians));

        // 画当前树枝
        g.drawLine(x1, y1, x2, y2);

        // 递归画左分支
        drawTree(g, x2, y2, angle - 20, depth - 1);

        // 递归画右分支
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
