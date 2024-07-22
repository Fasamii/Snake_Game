import javax.swing.JFrame;

public class Main{

    private static int SCREEN_WIDTH = 15;
    private static int SCREEN_HEIGHT = 10;
    private static int SIZE = 40;

    public static void main(String[] args) throws Exception{
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(SCREEN_WIDTH * SIZE,SCREEN_HEIGHT * SIZE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        
        SnakeGame game = new SnakeGame(SCREEN_WIDTH, SCREEN_HEIGHT, SIZE);

        f.add(game);
        f.setVisible(true);
    }
}