// The falling ball hits a line inclined to the ground and then slides straight down.

import javax.swing.*;
import java.awt.*;

public class BallwithLine extends JPanel {

    // ball dimensions
    int x = 10;
    int y = 10;
    int diameter = 50;
    int r = diameter/2;

    // ball movement
    int dx = 1;
    int dy = 1;

    // center of the ball
    int xs = x + r;
    int ys = y + r;

    // random points for line
    int x1 = 0;
    int y1 = (int) (Math.random()*getPreferredSize().getHeight());
    int x2 = (int) (Math.random()*getPreferredSize().getWidth());
    int y2 = (int) getPreferredSize().getHeight();

    // equation of the tangent of the circle
    // -Ax+By-C = 0 >>>> 1y = Ax + C
    // slope of the straight line
    double A = (-1)*(((double)y2 - (double)y1)/(double)x2);
    double B = 1;
    double C = (-1)*y1;

    int distance; // between ball and line
    double b;  // y = ax + b

    public Dimension getPreferredSize(){
        return new Dimension(1000, 500);
    }

    protected void  paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillOval(x, y ,50 ,50);
        g.setColor(Color.RED);
        g.drawLine(x1, y1, x2, y2);
    }

    public void animation() {

        boolean c = true;

        while (c) {

            distance = (int) ((Math.abs((A*xs)+(B*(ys))+C))/(Math.sqrt(A*A+B*B)));

            if (r < distance){
                dx = 0;
                dy = 1;
                xs += dx;
                ys += dy;
                x = xs - r;
                y = ys - r;
            }

            if (r >= distance && y < getPreferredSize().getHeight()-2*r){
                b = ys +A*xs;
                dx = 1;
                xs += dx;
                ys = (int)((-1)*A*xs + b);
                x = xs - r;
                y = ys - r;
            }

            if (y+2*r >= getPreferredSize().getHeight()){
                dx = 1;
                dy = 0;
                x += dx;
                y += dy;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BallwithLine ball = new BallwithLine();
        window.add(ball);
        window.setVisible(true);
        window.pack();
        ball.animation();
    }
}
