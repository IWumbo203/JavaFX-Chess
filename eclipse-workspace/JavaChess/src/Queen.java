import java.util.LinkedList;

import javafx.scene.paint.Color;

public class Queen extends Piece{

	public Queen(Square position, Color color, String image) {
		super(position, color, image);
		drawPiece();
	}

	@Override
	public String getPieceType() {
		// TODO Auto-generated method stub
		return "Queen";
	}

	@Override
	public LinkedList<Square> getLegalMoves(Square[][] squareArray, Color currentPlayer) {
		LinkedList<Square> legalMoves = new LinkedList<Square>();
		//Square[][] squareArray = board.getSquareArray();
		
		int x = this.getPosition().getRankNum();
        int y = this.getPosition().getFileNum();
        
        //HORIZONTAL AND VERTICAL MOVEMENTS
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
        //DIAGONAL MOVEMENTS
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
