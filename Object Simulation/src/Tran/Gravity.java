package Tran;

import java.awt.*;

/**
 * This class implements a subclass of MovingObject.
 * 
 * @version November 2015
 * @author Henry Tran adapted from Sam Scott
 * 
 */
public class Gravity extends MovingObject {
	/**
	 * The radius of the ball.
	 */
	private int radius;
	/**
	 * Static variable which carries and implements the radius.
	 */
	private static int r;
	/*
	 * The color of the ball.
	 */
	protected Color newColor;
	public double gravityConstant = 1.0198, initialAcc = 1.98;
	String mode = "Bouncing Balls";
	char key = ' ';

	/**
	 * Calls the superclass constructor, plus sets radius, and flash parameters.
	 * 
	 * @param x The x location.
	 * @param y The y location.
	 * @param left The left edge.
	 * @param right The right edge.
	 * @param top The top edge.
	 * @param bottom The bottom edge.
	 */
	public Gravity(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left + r, right - r, top + r, bottom - r);
		// Numbers above must match the radius.
		r = 10;
		radius = r;
	}
	
	public void setRadius(int x) {
		r = x;
		this.radius = r;
	}
	public int getRadius() {
		return this.radius;
	}
	public void setKey(char x) {
		key = x;
	}
	public void setMode(String x) {
		mode = x;
	}
	public char getKey() {
		return key;
	}
	public String getMode() {
		return mode;
	}
	public void setGravityConstant(double x) {
		gravityConstant = x;
	}
	public double getGravityConstant() {
		return gravityConstant;
	}
	public void setAcceleration(double x) {
		initialAcc = x;
	}
	public double getAcceleration() {
		return initialAcc;
	}
	/**
	 * Draws the ball.
	 * 
	 * @param g The graphics context.
	 */
	public void draw(Graphics g) {

		int drawX = (int) getX() - radius;
		int drawY = (int) getY() - radius;

		if (mode.equals("Bouncing Balls")) {
			g.setColor(color);
			g.drawOval(drawX, drawY, radius * 2, radius * 2);
		}
	}
}
