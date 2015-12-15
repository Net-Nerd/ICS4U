package Tran;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Press 1 for Bouncing Balls <br>
 * Press 2 for Rain <br>
 * Press 3 for Fireflies <br>
 * Press 4 for Smoke <br>
 * Press left click to create new ball objects and right click to induce
 * gravity. <br>
 * Physics simulation imposed on objects in motion. Attempting to account for
 * forces of gravity, momentum, and two dimension collisions.
 * 
 * @version November 2015
 * @author Henry Tran adapted from Sam Scott
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel
		implements Runnable, KeyListener, FocusListener, MouseListener, MouseMotionListener {

	int width = 300;
	int height = 675;

	/**
	 * The number of balls on the screen.
	 */
	int numBalls = 10;
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 50;
	/**
	 * An arraylist of balls. The size can be dynamically changed.
	 */
	ArrayList<Gravity> ball = new ArrayList<Gravity>(numBalls);
	/*
	 * Font types to implement.
	 */
	Font typeA = new Font("Courier", Font.PLAIN, 9);
	Font typeB = new Font("Courier", Font.BOLD, 13);
	Font typeC = new Font("Courier", Font.PLAIN, 11);
	Boolean isFreeG = false;
	String mode = "Bouncing Balls";
	char key = ' ';

	/**
	 * Main program, entry point.
	 */
	public static void main(String[] args) {

		// Set up main window, using Swing's Jframe.
		JFrame frame = new JFrame("Physics Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setResizable(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();
	}

	public GamePanel() {
		// Start the ball bouncing, in its own thread.
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);

		for (int i = 0; i < numBalls; i++) {
			ball.add(new Gravity(width / 2, height / 2 - 100, 0, width, 0, height));
			ball.get(i).setRadius(i + 1);
			ball.get(i).setXSpeed(Math.random() * 16 - 8);
			ball.get(i).setYSpeed(Math.random() * 16);
			ball.get(i).setColor(
					new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
		}

		Thread gameThread = new Thread(this);
		gameThread.start();
		addFocusListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		this.setFocusable(true);
	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		while (true) {
			repaint();
			if (isFreeG == true)
				for (int i = 0; i < ball.size() - 1; i++) {
					ball.get(i).setYSpeed((ball.get(i).getYSpeed() / 1.0198));
					ball.get(i).setXSpeed((ball.get(i).getXSpeed() / 1.0198));
				}
			else {
				for (int i = 0; i < ball.size() - 1; i++) {
					ball.get(i).setYSpeed((ball.get(i).getYSpeed() + ball.get(i).getAcceleration())
							/ ball.get(i).getGravityConstant());
					if (ball.get(i).getY() > height + ball.get(i).getRadius() * 2
							|| ball.get(i).getY() < ball.get(i).getRadius() * 2)
						ball.remove(i);
				}
			}
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.setFont(typeA);
		g.drawString("Adapted from Sam Scott", 6, 20);
		g.drawString("Current mode: " + mode, 6, 62);
		g.drawString("Current key pressed: " + key, 6, 76);
		g.drawString("Free gravity: " + isFreeG, 6, 90);
		g.setFont(typeB);
		g.drawString("Imposed Physics on Objects", 6, 42);
		g.setFont(typeC);
		g.drawString("© Net_Nerd 2015", 190, 668);
		for (int i = 0; i < ball.size() - 1; i++) {
			ball.get(i).draw(g);
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

		key = e.getKeyChar();

		if (e.getKeyChar() == KeyEvent.VK_1)
			mode = "Bouncing Balls";
		else if (e.getKeyChar() == KeyEvent.VK_2)
			mode = "Rain";
		else if (e.getKeyChar() == KeyEvent.VK_3)
			mode = "Fireflies";
		else if (e.getKeyChar() == KeyEvent.VK_4)
			mode = "Smoke";
	}

	public void keyReleased(KeyEvent e) {
		key = ' ';
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mode.equals("Bouncing Balls"))
				for (int i = 0; i < 10; i++) {
					ball.add(new Gravity(e.getX(), e.getY(), 0, width, 0, height));
					ball.get(ball.size() - 1).setRadius(i + 1);
					ball.get(ball.size() - 1).setAcceleration(1.98);
					ball.get(ball.size() - 1).setGravityConstant(1.01898);
					ball.get(ball.size() - 1).setXSpeed(Math.random() * 16 - 8);
					ball.get(ball.size() - 1).setYSpeed(Math.random() * 16 - 8);
					ball.get(ball.size() - 1).setColor(new Color((int) (Math.random() * 256),
							(int) (Math.random() * 256), (int) (Math.random() * 256)));
				}
			else {
				// Do nothing.
			}
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			isFreeG = true;
		}
	}

	public void mouseReleased(MouseEvent e) {
		isFreeG = false;
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void focusGained(FocusEvent e) {

	}

	public void focusLost(FocusEvent e) {

	}

	public void mouseDragged(MouseEvent e) throws NullPointerException {
		if (mode.equals("Rain"))
			for (int i = 0; i < 3; i++) {
				ball.add(new Gravity(e.getX(), e.getY(), 0, width, 0, height));
				ball.get(ball.size() - 1).setRadius(1);
				ball.get(ball.size() - 1).setAcceleration(1.98);
				ball.get(ball.size() - 1).setGravityConstant(1.2598);
				ball.get(ball.size() - 1).setXSpeed(Math.random() * 16 - 8);
				ball.get(ball.size() - 1).setYSpeed(Math.random() * 16);
				ball.get(ball.size() - 1).setColor(Color.BLUE);
			}
		if (mode.equals("Smoke"))
			for (int i = 0; i < 3; i++) {
				ball.add(new Gravity(e.getX(), e.getY(), 0, width, 0, height));
				ball.get(ball.size() - 1).setRadius(1);
				ball.get(ball.size() - 1).setAcceleration(-0.98);
				ball.get(ball.size() - 1).setGravityConstant(1.298);
				ball.get(ball.size() - 1).setXSpeed(Math.random() * 0.1 - 0.05);
				ball.get(ball.size() - 1).setYSpeed(Math.random() * -16);
				ball.get(ball.size() - 1).setColor(Color.GRAY);
			}
	}

	public void mouseMoved(MouseEvent e) {

	}
}
