import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Paddle paddle;
    private Ball ball;
    private ArrayList<Brick> bricks;
    private boolean isGameOver = false;

    public GamePanel() {
        this.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(this);
        initGame();
        timer = new Timer(10, this);
        timer.start();
    }

    private void initGame() {
        paddle = new Paddle();
        ball = new Ball();
        bricks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                bricks.add(new Brick(60 + j * 75, 50 + i * 30));
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
        ball.draw(g);
        for (Brick brick : bricks) {
            if (!brick.isBroken()) brick.draw(g);
        }
        if (isGameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over!", 300, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            paddle.move();
            ball.move();
            ball.checkCollision(paddle, bricks);
            if (ball.y > Constants.HEIGHT) isGameOver = true;
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        paddle.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        paddle.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}