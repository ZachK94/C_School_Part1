// A bouncing ball with three random rectangles.
// The ball is changing color after every hit.


import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel {

    int x = 1;
    int y = 1;
    int dx = 1;
    int dy = 2;
    int diameter = 50;
    //radius
    int r = diameter / 2;
    //length of the rectangle
    int a = 100;

    Color color = Color.RED;

    Rectangle rectangle1 = new Rectangle();
    Rectangle rectangle2 = new Rectangle();
    Rectangle rectangle3 = new Rectangle();

    public void rectangleSize() {
        rectangle1.setRect((int) (Math.random() * (getPreferredSize().getWidth() - a)), (int) (Math.random() * (getPreferredSize().getHeight() - a)), a, a);
        rectangle2.setRect((int) (Math.random() * (getPreferredSize().getWidth() - a)), (int) (Math.random() * (getPreferredSize().getHeight() - a)), a, a);
        if (rectangle1.intersects(rectangle2)) {
            rectangleSize();
        }
        rectangle3.setRect((int) (Math.random() * (getPreferredSize().getWidth() - a)), (int) (Math.random() * (getPreferredSize().getHeight() - a)), a, a);
        if (rectangle3.intersects(rectangle2) || rectangle3.intersects(rectangle1)) {
            rectangleSize();
        }
    }

    //auxiliary variables
    int xp;
    int yp;

    //collision with rectangles
    public boolean collision1() {
        return x <= rectangle1.x + a && x + diameter >= rectangle1.x
                && y <= rectangle1.y + a && y + diameter >= rectangle1.y;
    }

    public boolean collision2() {
        return x <= rectangle2.x + a && x + diameter >= rectangle2.x
                && y <= rectangle2.y + a && y + diameter >= rectangle2.y;
    }

    public boolean collision3() {
        return x <= rectangle3.x + a && x + diameter >= rectangle3.x
                && y <= rectangle3.y + a && y + diameter >= rectangle3.y;
    }

    public void auxiliaryVariables(Rectangle rectangle) {
        xp = Math.abs(x - rectangle.x) - diameter;
        yp = Math.abs(y - rectangle.y) - diameter;
    }

    public Dimension getPreferredSize() {
        return new Dimension(700, 800);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(Color.decode("#F0F8FF"));
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
        g.setColor(Color.decode("#4682B4"));
        g.fillRect(rectangle1.x, rectangle1.y, rectangle1.width, rectangle1.height);
        g.fillRect(rectangle2.x, rectangle2.y, rectangle2.width, rectangle2.height);
        g.fillRect(rectangle3.x, rectangle3.y, rectangle3.width, rectangle3.height);
    }

    public void animation() {
        rectangleSize();
        boolean b = true;

        while (b) {
            //collision with frame
            //left side
            if (x <= 0) {
                dx = -dx;
                x = 0;
                color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            }
            //right side
            if ((x + diameter) >= getWidth()) {
                dx = -dx;
                x = getWidth() - diameter;
                color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            }
            //upper
            if (y <= 0) {
                dy = -dy;
                y = 0;
                color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            }
            //bottom
            if ((y + diameter) >= getHeight()) {
                dy = -dy;
                y = getHeight() - diameter;
                color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            }

            if (collision1()) {
                // center of the ball is between the sides of the rectangle - hit from the top or bottom
                if ((x + r >= rectangle1.x && x + r <= rectangle1.x + a)) {
                    dy = -dy;
                    if (y >= rectangle1.y - diameter && y < rectangle1.y + diameter) {
                        y = rectangle1.y - diameter;
                    } else {
                        y = rectangle1.y + a;
                    }
                }
                // hit form right or left
                else if ((y + r >= rectangle1.y && y + r <= rectangle1.y + a)) {
                    dx = -dx;
                    if (x >= rectangle1.x - diameter && x < rectangle1.x + diameter) {
                        x = rectangle1.x - diameter;
                    } else {
                        x = rectangle1.x + a;
                    }
                }

                // hit the corner
                else {
                    auxiliaryVariables(rectangle1);
                    if (xp > yp) {
                        // hit form right or left
                        dx = -dx;
                        if (x >= rectangle1.x - diameter && x < rectangle1.x + diameter) {
                            x = rectangle1.x - diameter;
                        } else {
                            x = rectangle1.x + a;
                        }
                    }
                    if (xp <= yp) {
                        dy = -dy;
                        if (y >= rectangle1.y - diameter && y < rectangle1.y + diameter) {
                            y = rectangle1.y - diameter;
                        } else {
                            y = rectangle1.y + a;
                        }
                    }

                }
                color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            }

            if (collision2()) {
                if ((x + r >= rectangle2.x && x + r <= rectangle2.x + a)) {
                    dy = -dy;
                    if (y >= rectangle2.y - diameter && y < rectangle2.y + diameter) {
                        y = rectangle2.y - diameter;
                    } else {
                        y = rectangle2.y + a;
                    }
                } else if ((y + r >= rectangle2.y && y + r <= rectangle2.y + a)) {
                    dx = -dx;
                    if (x >= rectangle2.x - diameter && x < rectangle2.x + diameter) {
                        x = rectangle2.x - diameter;
                    } else {
                        x = rectangle2.x + a;
                    }
                } else {
                    auxiliaryVariables(rectangle2);
                    if (xp > yp) {

                        dx = -dx;
                        if (x >= rectangle2.x - diameter && x < rectangle2.x + diameter) {
                            x = rectangle2.x - diameter;
                        } else {
                            x = rectangle2.x + a;
                        }
                    }
                    if (xp <= yp) {
                        dy = -dy;
                        if (y >= rectangle2.y - diameter && y < rectangle2.y + diameter) {
                            y = rectangle2.y - diameter;
                        } else {
                            y = rectangle2.y + a;
                        }
                    }
                }
                color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            }

            if (collision3()) {
                if ((x + r >= rectangle3.x && x + r <= rectangle3.x + a)) {
                    dy = -dy;
                    if (y >= rectangle3.y - diameter && y < rectangle3.y + diameter) {
                        y = rectangle3.y - diameter;
                    } else {
                        y = rectangle3.y + a;
                    }
                } else if ((y + r >= rectangle3.y && y + r <= rectangle3.y + a)) {
                    dx = -dx;
                    if (x >= rectangle3.x - diameter && x < rectangle3.x + diameter) {
                        x = rectangle3.x - diameter;
                    } else {
                        x = rectangle3.x + a;
                    }
                } else {
                    auxiliaryVariables(rectangle3);
                    if (xp > yp) {

                        dx = -dx;
                        if (x >= rectangle3.x - diameter && x < rectangle3.x + diameter) {
                            x = rectangle3.x - diameter;
                        } else {
                            x = rectangle3.x + a;
                        }
                    }
                    if (xp <= yp) {
                        dy = -dy;
                        if (y >= rectangle3.y - diameter && y < rectangle3.y + diameter) {
                            y = rectangle3.y - diameter;
                        } else {
                            y = rectangle3.y + a;
                        }
                    }
                }
                color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            }

            x += dx;
            y += dy;

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }


    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ball ball = new Ball();
        window.add(ball);
        window.setVisible(true);
        window.pack();
        window.setTitle("Ball");

        ball.animation();

    }
}