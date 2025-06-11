import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    int x = Constants.WIDTH / 2 - Constants.PADDLE_WIDTH / 2;
    int y = Constants.HEIGHT - 50;
    int dx = 0;

    public void move() {
        x += dx;
        if (x < 0) x = 0;
        if (x > Constants.WIDTH - Constants.PADDLE_WIDTH) x = Constants.WIDTH - Constants.PADDLE_WIDTH;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) dx = -5;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) dx = 5;
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) dx = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
    }
}