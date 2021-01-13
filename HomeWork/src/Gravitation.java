// Ball with gravity effect.

import javax.swing.*;
import java.awt.*;

public class Gravitation extends JPanel {

    // ball dimensions
    int x = 10;
    int y = 10;
    int r = 20;
    int diameter = 2*r;

    // ball movement
    double vX = 4;
    double vY = 1;
    double dt = 0.2; //time
    double g = 9.81; //gravity
    double xFT = 0.98; //friction

    // ball weight
    double weight = 0.2;
    double energyLoss = 1-weight;

    public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.decode("#4682B4"));
        g.fillOval(x, y, diameter, diameter);
    }

    public void move(){

        boolean b = true;

        while (b){

            // collision with frame (right or left), change of direction
            if (x > getPreferredSize().getWidth() - diameter){
                x = (int)getPreferredSize().getWidth() - diameter;
                vX = -vX;
            }
            else if (x < 0){
                x = 0;
                vX = -vX;
            }
            else {
                x += vX;
            }

            // friction effect
            if (y == getPreferredSize().getHeight() - diameter){
                vX *= xFT;
                // if speed of the ball is low ---> stop the ball
                if (Math.abs(vX) < 0.9){
                    vX = 0;
                    vY = 0;
                }
            }

            // collision with frame (bottom), change of direction, energy loss
            if (y > getPreferredSize().getHeight() - diameter){
                y = (int) getPreferredSize().getHeight() - diameter;
                vY *= energyLoss;
                vY = -vY;
            }
            // gravity effect
            else {
                vY += g * dt;
                y += vY * dt + 0.5 * g * dt * dt;
            }

            if (weight > 1 && y >= getPreferredSize().getHeight() - diameter){
                y = (int) getPreferredSize().getHeight() - diameter;
                b = false;
            }

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Gravitation ball = new Gravitation();
        window.add(ball);
        window.setTitle("Gravity");
        window.setVisible(true);
        window.pack();
        ball.move();
    }
}
