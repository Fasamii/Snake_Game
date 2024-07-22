import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.Random;

public class SnakeGame extends JPanel{
    
        private int WIDTH;
        private int HEIGHT;
        private int SIZE;
        private int DELAY = 230;
        private int FOODS = 5;
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
        private int foods_in_game = 0;
        private int[] foodX = new int[FOODS];
        private int[] foodY = new int[FOODS];
        private int x;
        private int y;

        Random rand = new Random();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            if(running){
                update();
                foodGen();
            }}};

    SnakeGame(int WIDTH,int HEIGHT, int SIZE){
        this.WIDTH=WIDTH;this.HEIGHT=HEIGHT;this.SIZE=SIZE;
        this.setPreferredSize(new Dimension((this.WIDTH * this.SIZE)+5,(this.HEIGHT * this.SIZE)+32));
        this.setBackground(COLOR[0]);
        Main.f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w':if(lastChar != 's'){lastChar = 'w';}break;
                    case 's':if(lastChar != 'w'){lastChar = 's';}break;
                    case 'a':if(lastChar != 'd'){lastChar = 'a';}break;
                    case 'd':if(lastChar != 'a'){lastChar = 'd';}break;
                    default:break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e){}});
        snakeX= new int[WIDTH*HEIGHT];
        snakeY= new int[WIDTH*HEIGHT];
        this.snakeX[0] = SIZE;this.snakeY[0] = SIZE;
        timer.scheduleAtFixedRate(task, 0, DELAY);
    }

    private void update(){
        for(int i = snakeLenght - 1;i > 0;i--){
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

    private void foodGen(){
        while(this.foods_in_game < this.FOODS){
            do{
                x = rand.nextInt(WIDTH);
                y = rand.nextInt(HEIGHT);
            }while(isntAv(x,y));
            foodX[foods_in_game] = x;
            foodY[foods_in_game] = y;
            foods_in_game++;
        }
    }

    private boolean isntAv(int x,int y){
        for(int i = 0;i < foods_in_game;i++){
            if(x == foodX[i] && y == foodY[i]){
                return true;
            }
        }
        return false;
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
        for(int i = 0;i < foods_in_game;i++){
            g.setColor(COLOR[3]);
            g.fillRect(foodX[i]*SIZE+4,foodY[i]*SIZE+4,SIZE-7,SIZE-7);
        }
    }
}