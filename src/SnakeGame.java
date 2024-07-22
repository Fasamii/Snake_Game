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
            new Color(0xE050B0)
        };

        private boolean running = true;
        private int[] snakeX;
        private int[] snakeY;
        private int snakeLenght = 1;

    SnakeGame(int WIDTH,int HEIGHT, int SIZE){
        this.WIDTH=WIDTH;this.HEIGHT=HEIGHT;this.SIZE=SIZE;
        this.setPreferredSize(new Dimension((this.WIDTH * this.SIZE)+5,(this.HEIGHT * this.SIZE)+32));
        this.setBackground(COLOR[0]);
        snakeX= new int[WIDTH*HEIGHT];
        snakeY= new int[WIDTH*HEIGHT];
        this.snakeX[0] = SIZE;this.snakeY[0] = SIZE;
    }

    private void update(){
        for(int i = snakeX.length - 1;i > 0;i--){
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        //grid
        for(int i = 0;i <= WIDTH;i++){g.setColor(COLOR[1]);g.drawLine(i*SIZE, 0, i*SIZE, HEIGHT*SIZE);}
        for(int i = 0;i <= HEIGHT;i++){g.setColor(COLOR[1]);g.drawLine(0, i*SIZE, WIDTH*SIZE,i*SIZE);}
        //snake
        for(int i = 0;i < snakeLenght;i++){
            if(i == 0){g.setColor(COLOR[1]);}else{g.setColor(COLOR[2]);}    
            g.fillRect(this.snakeX[i]+3,this.snakeY[i]+3,SIZE-5,SIZE-5);
        }
        //food
        g.setColor(COLOR[3]);
        g.fillRect(SIZE*4+10,SIZE*3+10,SIZE-19,SIZE-19);
    }

}