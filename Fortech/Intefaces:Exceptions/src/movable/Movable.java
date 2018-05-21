package movable;

import MoveExceptions.*;

public interface Movable {
	
	static int PLAIN_X_MAX=1000;
	static int PLAIN_X_MIN=-1000;
	static int PLAIN_Y_MAX=1000;
	static int PLAIN_Y_MIN=-1000;
	
	/**
	 * Moves the form up in the plain. The implementation should take care of
	 * how much will this movement be.
	 * @throws MoveUpOutOfPlainException 
	 * @throws InvalidSpeedException 
	 */
	void moveUp() throws MoveUpOutOfPlainException, InvalidSpeedException;

	/**
	 * Moves the form down in the plain. The implementation should take care of
	 * how much will this movement be.
	 * @throws MoveDownOutOfPlainException 
	 * @throws InvalidSpeedException 
	 */
	void moveDown() throws MoveDownOutOfPlainException, InvalidSpeedException;

	/**
	 * Moves the form left in the plain. The implementation should take care of
	 * how much will this movement be.
	 * @throws MoveLeftOutOfPlainException 
	 * @throws InvalidSpeedException 
	 */
	void moveLeft() throws MoveLeftOutOfPlainException, InvalidSpeedException;

	/**
	 * Moves the form right in the plain. The implementation should take care of
	 * how much will this movement be.
	 * @throws MoveRightOutOfPlainException 
	 * @throws InvalidSpeedException 
	 */
	void moveRight() throws MoveRightOutOfPlainException, InvalidSpeedException;

	/**
	 * Moves the form up in the plain with the specified number of points.
	 * 
	 * @param howMuch
	 *            the number of points to move up in the plain
	 * @throws MoveUpOutOfPlainException 
	 * @throws InvalidSpeedException 
	 */
	void moveUp(int howMuch) throws MoveUpOutOfPlainException, InvalidSpeedException;

	/**
	 * Moves the form down in the plain with the specified number of points.
	 * 
	 * @param howMuch
	 *            the number of points to move down in the plain
	 * @throws InvalidSpeedException 
	 * @throws MoveDownOutOfPlainException 
	 */
	void moveDown(int howMuch) throws MoveDownOutOfPlainException, InvalidSpeedException;

	/**
	 * Moves the form left in the plain with the specified number of points.
	 * 
	 * @param howMuch
	 *            the number of points to move left in the plain
	 * @throws InvalidSpeedException 
	 * @throws MoveLeftOutOfPlainException 
	 */
	void moveLeft(int howMuch) throws InvalidSpeedException, MoveLeftOutOfPlainException;

	/**
	 * Moves the form right in the plain with the specified number of points.
	 * 
	 * @param howMuch
	 *            the number of points to move right in the plain
	 * @throws InvalidSpeedException 
	 * @throws MoveRightOutOfPlainException 
	 */
	void moveRight(int howMuch) throws InvalidSpeedException, MoveRightOutOfPlainException;
}