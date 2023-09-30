import java.util.LinkedList;

import javafx.scene.paint.Color;

public class Rook extends Piece {
	
	public Rook(Square position, Color color, String image) {
		super(position, color, image);
		drawPiece();
	}

	@Override
	public String getPieceType() {
		// TODO Auto-generated method stub
		return "Rook";
	}

	@Override
	public LinkedList<Square> getLegalMoves(Square[][] squareArray, Color currentPlayer) {
		LinkedList<Square> legalMoves = new LinkedList<Square>();
		//Square[][] squareArray = board.getSquareArray();
		
		int x = this.getPosition().getRankNum();
        int y = this.getPosition().getFileNum();
		
        for (int i = x+1; i < 8; i++) {
        	if (squareArray[i][y].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, i, y)) {legalMoves.add(squareArray[i][y]); break;}
        	else if (squareArray[i][y].isFilled()) break;
        	legalMoves.add(squareArray[i][y]);
        }
        for (int i = x-1; i >= 0; i--) {
        	if (squareArray[i][y].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, i, y)) {legalMoves.add(squareArray[i][y]); break;}
        	else if (squareArray[i][y].isFilled()) break;
        	legalMoves.add(squareArray[i][y]);
        }
        for (int j = y+1; j < 8; j++) {
        	if (squareArray[x][j].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, x, j)) {legalMoves.add(squareArray[x][j]); break;}
        	else if (squareArray[x][j].isFilled()) break;
        	legalMoves.add(squareArray[x][j]);
        }
        for (int j = y-1; j >= 0; j--) {
        	if (squareArray[x][j].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, x, j)) {legalMoves.add(squareArray[x][j]); break;}
        	else if (squareArray[x][j].isFilled()) break;
        	legalMoves.add(squareArray[x][j]);
        }
		return legalMoves;
	}
	
}