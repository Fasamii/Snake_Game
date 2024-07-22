import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.JPanel;

public class SnakeGame extends JPanel implements KeyListener{
    
        private int WIDTH;
        private int HEIGHT;
        private int SIZE;
        private int DELAY = 230;
        private final Color[] COLOR = {
            new Color(0x301045),
            new Color(0x00B050),
            new Color(0x308040),
            new Color(0xFF60C0)
        };

        private boolean running = true;
        private char lastChar = 'd';
        private int[] snakeX;
        private int[] snakeY;
        private int snakeLenght = 3;

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                update();
            }
        };

    SnakeGame(int WIDTH,int HEIGHT, int SIZE){
        this.WIDTH=WIDTH;this.HEIGHT=HEIGHT;this.SIZE=SIZE;
        this.setPreferredSize(new Dimension((this.WIDTH * this.SIZE)+5,(this.HEIGHT * this.SIZE)+32));
        this.setBackground(COLOR[0]);
        addKeyListener(this);
        snakeX= new int[WIDTH*HEIGHT];
        snakeY= new int[WIDTH*HEIGHT];
        this.snakeX[0] = SIZE;this.snakeY[0] = SIZE;
        timer.scheduleAtFixedRate(task, 0, DELAY);
    }

    private void update(){
        for(int i = snakeX.length - 1;i > 0;i--){
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
        }
        switch (this.lastChar) {
            case 'w':snakeY[0] = snakeY[0] - SIZE;break;
            case 's':snakeY[0] = snakeY[0] + SIZE;break;
            case 'a':snakeX[0] = snakeX[0] - SIZE;break;
            case 'd':snakeX[0] = snakeX[0] + SIZE;break;
            default:break;
        }
        Main.f.repaint();
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
        g.fillRect(SIZE*4+4,SIZE*3+4,SIZE-7,SIZE-7);
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("pressed");
        lastChar = e.getKeyChar();
    }

    @Override
    public void keyReleased(KeyEvent e) {
     
    }
}