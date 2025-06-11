import java.awt.*;
import java.util.ArrayList;

public class Ball {
    int x = Constants.WIDTH / 2;
    int y = Constants.HEIGHT / 2;
    int dx = 2, dy = 3;

    public void move() {
        x += dx;
        y += dy;

        if (x <= 0 || x >= Constants.WIDTH - Constants.BALL_SIZE) dx *= -1;
        if (y <= 0) dy *= -1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, Constants.BALL_SIZE, Constants.BALL_SIZE);
    }

    public void checkCollision(Paddle paddle, ArrayList<Brick> bricks) {
        if (getBounds().intersects(paddle.getBounds())) dy *= -1;

        for (Brick brick : bricks) {
            if (!brick.isBroken() && getBounds().intersects(brick.getBounds())) {
                brick.setBroken(true);
                dy *= -1;
                break;
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, Constants.BALL_SIZE, Constants.BALL_SIZE);
    }
}
