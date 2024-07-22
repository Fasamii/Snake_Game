import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.print.attribute.standard.Sides;
import javax.swing.JPanel;

public class SnakeGame extends JPanel {
    
        private int WIDTH;
        private int HEIGHT;
        private int SIZE;
        private final Color[] COLOR = {
            new Color(0x301045),
            new Color(0x00B050),
            new Color(0x008040),
            new Color(0xA01080)
        };

        private boolean running = true;
        private int[] snakeX;
        private int[] snakeY;

    SnakeGame(int WIDTH,int HEIGHT, int SIZE){
        this.WIDTH=WIDTH;this.HEIGHT=HEIGHT;this.SIZE=SIZE;
        this.setPreferredSize(new Dimension(this.WIDTH * this.SIZE,this.HEIGHT * this.SIZE));
        this.setBackground(COLOR[0]);
        snakeX= new int[WIDTH*HEIGHT];
        snakeY= new int[WIDTH*HEIGHT];
        this.snakeX[0] = SIZE;this.snakeY[0] = SIZE;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(COLOR[1]);
        g.fillRect(this.snakeX[0],this.snakeY[0],SIZE,SIZE);
    }

}