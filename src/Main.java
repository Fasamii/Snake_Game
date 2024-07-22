import javax.swing.JFrame;

public class Main{

    private static int SCREEN_WIDTH = 15;
    private static int SCREEN_HEIGHT = 10;
    private static int SIZE = 50; // min 10

    static JFrame f = new JFrame();

    public static void main(String[] args) throws Exception{
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize((SCREEN_WIDTH * SIZE)+5,(SCREEN_HEIGHT * SIZE)+32);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        
        f.add(new SnakeGame(SCREEN_WIDTH, SCREEN_HEIGHT, SIZE));

        f.setVisible(true);
    }
}