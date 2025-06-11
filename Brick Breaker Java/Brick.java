import java.awt.*;

public class Brick {
    private int x, y;
    private boolean broken;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        this.broken = false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT);
        g.setColor(Color.black);
        g.drawRect(x, y, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT);
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT);
    }
}
