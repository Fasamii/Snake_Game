import javax.swing.JFrame;

public class Main{

    private static int SCREEN_WIDTH = 20;
    private static int SCREEN_HEIGHT = 15;
    private static int SIZE = 50; // min 10

    static JFrame f = new JFrame();

    public static void main(String[] args) throws Exception{
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize((SCREEN_WIDTH * SIZE)+5,(SCREEN_HEIGHT * SIZE)+32);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        
        SnakeGame game = new SnakeGame(SCREEN_WIDTH, SCREEN_HEIGHT, SIZE);

        f.add(game);
        f.setVisible(true);
    }
}