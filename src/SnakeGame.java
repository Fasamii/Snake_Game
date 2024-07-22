import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
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
        this.setPreferredSize(new Dimension((this.WIDTH * this.SIZE)+5,(this.HEIGHT * this.SIZE)+32));
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
        for(int i = 0;i <= WIDTH;i++){
            g.setColor(COLOR[1]);
            g.drawLine(i*SIZE, 0, i*SIZE, HEIGHT*SIZE);
        }
        for(int i = 0;i <= HEIGHT;i++){
            g.setColor(COLOR[1]);
            g.drawLine(0, i*SIZE, WIDTH*SIZE,i*SIZE);
        }
        g.setColor(COLOR[1]);
        g.fillRect(this.snakeX[0]+3,this.snakeY[0]+3,SIZE-5,SIZE-5);
    }

}