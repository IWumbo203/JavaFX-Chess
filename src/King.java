import java.util.LinkedList;

import javafx.scene.paint.Color;

public class King extends Piece {
	public King(Square position, Color color, String image) {
		super(position, color, image);
		drawPiece();
	}

	@Override
	public String getPieceType() {
		// TODO Auto-generated method stub
		return "King";
	}

	@Override
	public LinkedList<Square> getLegalMoves(Square[][] squareArray, Color currentPlayer) {
		LinkedList<Square> legalMoves = new LinkedList<Square>();
		//Square[][] squareArray = board.getSquareArray();
		
		int x = this.getPosition().getRankNum();
        int y = this.getPosition().getFileNum();
        
        
        
        for (int i = -1; i <= 1; i++) {
        	for (int j = -1; j <= 1; j++) {
        		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j)) {
        				if (squareArray[x+i][y+j].isFilled() && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+j))
        					legalMoves.add(squareArray[x+i][y+j]);
        				else if (!squareArray[x+i][y+j].isFilled()) {
        	        	legalMoves.add(squareArray[x+i][y+j]);
        			}
        		}
        	}
        }
		return legalMoves;
	}
	
}