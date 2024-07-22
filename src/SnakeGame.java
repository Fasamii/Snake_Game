import java.util.Random;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JLabel implements ActionListener {
    
    final String NAME = "Snake Game";
    final int SCREEN_WIDTH = 15;
    final int SCREEN_HEIGHT = 10;
    final int SCALE = 40;
    private final int DELAY = 100;
    private final int FOODS_TO_SPAWN = 5;
    private final Color[] COLOR = {
        new Color(0x301045),
        new Color(0x00B050),
        new Color(0x008040),
        new Color(0xA01080)
    };

    private boolean running = true;
    private int[] snakeX = new int[SCREEN_HEIGHT*SCREEN_WIDTH];
    private int[] snakeY = new int[SCREEN_HEIGHT*SCREEN_WIDTH];
    private int[] appleX = new int[FOODS_TO_SPAWN];
    private int[] appleY = new int[FOODS_TO_SPAWN];
    private int snake_lenght = 1;
    private char last_char = ' ';
    private int foods_spawned = 0;

    private final Random rand = new Random();
    private Timer timer;

    SnakeGame(){
        this.setName(NAME);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setLayout(null);
        this.setBackground(COLOR[0]);
        this.addKeyListener(new KeyAdapt());
        this.setVisible(true);
    }

// util methods
    
    private void prepare(){
        snakeX[0] = SCALE;
        snakeY[0] = SCALE;
        foods_spawned = 0;
        last_char = ' ';
        snake_lenght = 1;
        running = true;
        //timer = new Timer(DELAY,this);
    }

// actual game

    private void update(){

    }

// =-= Graphics =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
   
    public void paint(Graphics g){
        
    }

    private void draw(Graphics g){

    } 

// =-= Action =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class KeyAdapt extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
}