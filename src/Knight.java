
import java.util.LinkedList;
import javafx.scene.paint.Color;

public class Knight extends Piece {
	
	public Knight(Square position, Color color, String image) {
		super(position, color, image);
		drawPiece();
	}
	
	public LinkedList<Square> getLegalMoves(Square[][] squareArray, Color currentPlayer) {
		LinkedList<Square> legalMoves = new LinkedList<Square>();
		//Square[][] squareArray = board.getSquareArray();
		
		int x = this.getPosition().getRankNum();
        int y = this.getPosition().getFileNum();
        
        int i = 2; int j = 1;
      //checks if takeable piece is available
		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+j))
				legalMoves.add(squareArray[x+i][y+j]);
		//checks if valid move (not taken by own piece)
		else if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].isFilled())
				legalMoves.add(squareArray[x+i][y+j]);
		
		i = 2; j = -1;
		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+j))
				legalMoves.add(squareArray[x+i][y+j]);
		else if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].isFilled())
				legalMoves.add(squareArray[x+i][y+j]);
			
		i = 1; j = 2;
		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+j))
				legalMoves.add(squareArray[x+i][y+j]);
		else if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].isFilled())
				legalMoves.add(squareArray[x+i][y+j]);
		
		i = 1; j = -2;
		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+j))
				legalMoves.add(squareArray[x+i][y+j]);
		else if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].isFilled())
				legalMoves.add(squareArray[x+i][y+j]);
        
		i = -2; j = 1;
		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+j))
				legalMoves.add(squareArray[x+i][y+j]);
		else if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].isFilled())
				legalMoves.add(squareArray[x+i][y+j]);
		
		i = -2; j = -1;
		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+j))
				legalMoves.add(squareArray[x+i][y+j]);
		else if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].isFilled())
				legalMoves.add(squareArray[x+i][y+j]);
		
		i = -1; j = 2;
		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+j))
				legalMoves.add(squareArray[x+i][y+j]);
		else if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].isFilled())
				legalMoves.add(squareArray[x+i][y+j]);
		
		i = -1; j = -2;
		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && defineLegalTake(squareArray, currentPlayer, x, y, x+i, y+j))
				legalMoves.add(squareArray[x+i][y+j]);
		else if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].isFilled())
				legalMoves.add(squareArray[x+i][y+j]);
        /*
        for (int i = -2; i <= 2; i++) {
        	for (int j = -2; j <= 2; j++) {
        		if (!(x+i == 0 || y+j == 0) || !(x+i == 1 && y+j == 1) || !(x+i == 2 && y+j == 2)) {
        		//checks if takeable piece is available
        		if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].getColor().equals(currentPlayer))
        				legalMoves.add(squareArray[x+i][y+j]);
        		//checks if valid move (not taken by own piece)
        		else if (isValidIndex(squareArray, x+i) && isValidIndex(squareArray, y+j) && !squareArray[x+i][y+j].isFilled())
        				legalMoves.add(squareArray[x+i][y+j]);
        	}
        }
        }
        */
		return legalMoves;
	}

	@Override
	public String getPieceType() {
		// TODO Auto-generated method stub
		return "Knight";
	}

}