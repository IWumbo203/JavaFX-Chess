import java.util.LinkedList;

import javafx.scene.paint.Color;

public class Pawn extends Piece {

	private boolean isMoved;
	
	public Pawn(Square position, Color color, String image) {
		super(position, color, image);
		drawPiece();
		isMoved = false;
	}

	@Override
	public String getPieceType() {
		// TODO Auto-generated method stub
		return "Pawn";
	}
	
	@Override
	public LinkedList<Square> getLegalMoves(Square[][] squareArray, Color currentPlayer) {
		if (this.getColor().equals(Color.BLACK) && this.getPosition().getRankNum() != 1) {//determines if the pawn is moved or not when determining legal moves
			isMoved = true;
		}
		if (this.getColor().equals(Color.WHITE) && this.getPosition().getRankNum() != 6) {
			isMoved = true;
		}
		if (this.getColor().equals(Color.BLACK) && this.getPosition().getRankNum() == 1) {//determines if the pawn is moved or not when determining legal moves
			isMoved = false;
		}
		if (this.getColor().equals(Color.WHITE) && this.getPosition().getRankNum() == 6) {
			isMoved = false;
		}
		LinkedList<Square> legalMoves = new LinkedList<Square>();
		//Square[][] squareArray = board.getSquareArray();
		//switched these values because the ranks serve as the y axis in terms on a 2d array
		int y = this.getPosition().getRankNum();
        int x = this.getPosition().getFileNum();
        //System.out.println("X = " + x + " Y = " + y);
		
            if (this.getColor().equals(Color.BLACK)) {
            	if (!isMoved) {
                if (!squareArray[y+2][x].isFilled() && !squareArray[y+1][x].isFilled()) {
                    legalMoves.add(squareArray[y+2][x]);
                }
            }
            	if (y+1 < 8) {
            		if (!squareArray[y+1][x].isFilled()) {
                        legalMoves.add(squareArray[y+1][x]);
                    }
            }
            	if (y+1 < 8 && x+1 < 8) {
            		if (squareArray[y+1][x+1].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, y+1, x+1)) {
                        legalMoves.add(squareArray[y+1][x+1]);
                    }
            }
            	if (y+1 < 8 && x-1 >= 0) {
            		if (squareArray[y+1][x-1].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, y+1, x-1)) {
                        legalMoves.add(squareArray[y+1][x-1]);
                    }
            }
        } else {
            	if (!isMoved) {
                if (!squareArray[y-2][x].isFilled() && !squareArray[y-1][x].isFilled()) {
                    legalMoves.add(squareArray[y-2][x]);
                }
            }
            	if (y-1 >= 0) {
            		if (!squareArray[y-1][x].isFilled()) {
                        legalMoves.add(squareArray[y-1][x]);
                    }
            }
            	if (y-1 >= 0 && x+1 < 8) {
            		if (squareArray[y-1][x+1].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, y-1, x+1)) {
                        legalMoves.add(squareArray[y-1][x+1]);
                    }
            		
            }
            	if (y-1 >= 0 && x-1 >= 0) {
            		if (squareArray[y-1][x-1].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, y-1, x-1)) {
                        legalMoves.add(squareArray[y-1][x-1]);
                    }
            }
        }
		return legalMoves;
	}
	public String toString() {
		return "Pawn";
	}

}
