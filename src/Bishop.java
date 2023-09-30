import java.util.LinkedList;

import javafx.scene.paint.Color;

public class Bishop extends Piece {

	public Bishop(Square position, Color color, String image) {
		super(position, color, image);
		drawPiece();
	}

	@Override
	public String getPieceType() {
		// TODO Auto-generated method stub
		return "Bishop";
	}

	@Override
	public LinkedList<Square> getLegalMoves(Square[][] squareArray, Color currentPlayer) {
		LinkedList<Square> legalMoves = new LinkedList<Square>();
		//Square[][] squareArray = b.getSquareArray();
		
		int x = this.getPosition().getRankNum();
        int y = this.getPosition().getFileNum();
        //System.out.println("X = " + x + " Y = " + y);
        //these are the current coordinates of the piece, legal moves are found by obtainng possible moves branched off of the the original place
        /*
        //diagonal
        /*
        for (int i = x+1, j = y+1; i < 8 && j < 8; i++, j++) {
        	if (squareArray[i][j].isFilled()) break;
        	legalMoves.add(squareArray[i][j]);
        }
        for (int i = x-1, j = y+1; i >= 0 && j < 8; i--, j++) {
        	if (squareArray[i][j].isFilled()) break;
        	legalMoves.add(squareArray[i][j]);
        }
        for (int i = x+1, j = y-1; i < 8 && j >= 0; i++, j--) {
        	if (squareArray[i][j].isFilled()) break;
        	legalMoves.add(squareArray[i][j]);
        }
        for (int i = x-1, j = y-1; i >= 0 && j >=0; i--, j--) {
        	if (squareArray[i][j].isFilled()) break;
        	legalMoves.add(squareArray[i][j]);
        }
        */
        //!squareArray[x+i][y+i].getColor().equals(currentPlayer)
        for (int i = 1; x + i < 8 && y + i < 8; i++) {
        	if (squareArray[x+i][y+i].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+i)) {legalMoves.add(squareArray[x+i][y+i]); break;}
        	else if (squareArray[x+i][y+i].isFilled()) break;
        	legalMoves.add(squareArray[x+i][y+i]);
        }
        for (int i = 1; x-i >= 0 && y+i < 8; i++) {
        	if (squareArray[x-i][y+i].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, x-i, y+i)) {legalMoves.add(squareArray[x-i][y+i]); break;}
        	else if (squareArray[x-i][y+i].isFilled()) break;
        	legalMoves.add(squareArray[x-i][y+i]);
        }
        for (int i = 1; x+i < 8 && y-i >= 0; i++) {
        	if (squareArray[x+i][y-i].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y-i)) {legalMoves.add(squareArray[x+i][y-i]); break;}
        	else if (squareArray[x+i][y-i].isFilled()) break;
        	legalMoves.add(squareArray[x+i][y-i]);
        }
        for (int i = 1; x-i >= 0 && y-i >=0; i++) {
        	if (squareArray[x-i][y-i].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, x-i, y-i)) {legalMoves.add(squareArray[x-i][y-i]); break;}
        	else if (squareArray[x-i][y-i].isFilled()) break;
        	legalMoves.add(squareArray[x-i][y-i]);
        }
        return legalMoves;
	}
	}