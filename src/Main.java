import javax.swing.JFrame;

public class Main {
public static void main(String[] args){
    
    SnakeGame game = new SnakeGame();
    JFrame f = new JFrame();
    
    f.setName(game.NAME);
    f.setSize(game.SCREEN_WIDTH*game.SCALE,game.SCREEN_HEIGHT*game.SCALE);
    f.setLayout(null);
    f.setLocationRelativeTo(null);
    f.add(game);
    f.setVisible(true);

}
}
