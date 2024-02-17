
import java.util.LinkedList;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Board extends GridPane {
	private LinkedList<Piece> blackPieces;
	private LinkedList<Piece> whitePieces;
	private Square[][] squareArray;
	private Piece currentPiece;
	private Color currentPlayer;
	private boolean game;
	private boolean restart;
	private LinkedList<Square> list;
	private TopBar topBar;
	private TopBar bottomBar;
	private SideBar sideBar;

	
	
	
	public Board() {
		this.squareArray = new Square[8][8];
		for (int r = 0; r < squareArray.length; r++) {
			for (int c = 0; c < squareArray[0].length; c++) {
				if ((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1)) {
					squareArray[r][c] = new Square(Color.AQUA, r, c, false);
					squareArray[r][c].setPrefHeight(100);
					squareArray[r][c].setPrefWidth(100);
					squareArray[r][c].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
					squareArray[r][c].setBackground(new Background(new BackgroundFill(squareArray[r][c].getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
					squareArray[r][c].setOnMousePressed(new MouseHandler());
				} else {
					squareArray[r][c] = new Square(Color.HONEYDEW, r, c, false);
					squareArray[r][c].setPrefHeight(100);
					squareArray[r][c].setPrefWidth(100);
					squareArray[r][c].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
					squareArray[r][c].setBackground(new Background(new BackgroundFill(squareArray[r][c].getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
					squareArray[r][c].setOnMousePressed(new MouseHandler());
				}
			}
		}
		game = true;
		restart = false;
		currentPlayer = Color.WHITE;
		createBoardGUI();
		initializePieces();
		topBar = new TopBar("Black Player", Color.BLACK);
		bottomBar = new TopBar("White Player", Color.WHITE);
		sideBar = new SideBar(this);
		}
		
	
	
	public void constructor() {
		this.squareArray = new Square[8][8];
		for (int r = 0; r < squareArray.length; r++) {
			for (int c = 0; c < squareArray[0].length; c++) {
				if ((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1)) {
					squareArray[r][c] = new Square(Color.AQUA, r, c, false);
					squareArray[r][c].setPrefHeight(100);
					squareArray[r][c].setPrefWidth(100);
					squareArray[r][c].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
					squareArray[r][c].setBackground(new Background(new BackgroundFill(squareArray[r][c].getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
					squareArray[r][c].setOnMousePressed(new MouseHandler());
				} else {
					squareArray[r][c] = new Square(Color.HONEYDEW, r, c, false);
					squareArray[r][c].setPrefHeight(100);
					squareArray[r][c].setPrefWidth(100);
					squareArray[r][c].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
					squareArray[r][c].setBackground(new Background(new BackgroundFill(squareArray[r][c].getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
					squareArray[r][c].setOnMousePressed(new MouseHandler());
				}
			}
		}
		game = true;
		restart = false;
		currentPlayer = Color.WHITE;
		createBoardGUI();
		initializePieces();
		topBar = new TopBar("Black Player", Color.BLACK);
		bottomBar = new TopBar("White Player", Color.WHITE);
		sideBar = new SideBar(this);
		}
	public void destructor() {
		for(int r = 0; r < squareArray.length; r++) {
			for (int c = 0; c < squareArray[0].length; c++) {
				squareArray[r][c].removePiece();
				squareArray[r][c] = null;
			}
		}
		game = false;
		currentPlayer = null;
		super.getChildren().removeAll();
		topBar = null;
		bottomBar = null;
		sideBar = null;
		}
		
	private void initializePieces() {
		for (int r = 0; r < 8; r++) {
			squareArray[1][r].setPiece(new Pawn(squareArray[1][r], Color.BLACK, "PNGs/black_pawn.png"));
			squareArray[6][r].setPiece(new Pawn(squareArray[6][r], Color.WHITE, "PNGs/white_pawn.png"));
		}
			squareArray[0][0].setPiece(new Rook(squareArray[0][0], Color.BLACK, "PNGs/black_rook.png"));
			squareArray[0][7].setPiece(new Rook(squareArray[0][7], Color.BLACK, "PNGs/black_rook.png"));
			squareArray[7][0].setPiece(new Rook(squareArray[7][0], Color.WHITE, "PNGs/white_rook.png"));
			squareArray[7][7].setPiece(new Rook(squareArray[7][7], Color.WHITE, "PNGs/white_rook.png"));
			
			squareArray[0][1].setPiece(new Knight(squareArray[0][1], Color.BLACK, "PNGs/black_knight.png"));
			squareArray[0][6].setPiece(new Knight(squareArray[0][6], Color.BLACK, "PNGs/black_knight.png"));
			squareArray[7][1].setPiece(new Knight(squareArray[7][1], Color.WHITE, "PNGs/white_knight.png"));
			squareArray[7][6].setPiece(new Knight(squareArray[7][6], Color.WHITE, "PNGs/white_knight.png"));
			
			squareArray[0][2].setPiece(new Bishop(squareArray[0][2], Color.BLACK, "PNGs/black_bishop.png"));
			squareArray[0][5].setPiece(new Bishop(squareArray[0][5], Color.BLACK, "PNGs/black_bishop.png"));
			squareArray[7][2].setPiece(new Bishop(squareArray[7][2], Color.WHITE, "PNGs/white_bishop.png"));
			squareArray[7][5].setPiece(new Bishop(squareArray[7][5], Color.WHITE, "PNGs/white_bishop.png"));
			
			squareArray[0][3].setPiece(new Queen(squareArray[0][3], Color.BLACK, "PNGs/black_queen.png"));
			squareArray[7][3].setPiece(new Queen(squareArray[7][3], Color.WHITE, "PNGs/white_queen.png"));
			
			squareArray[0][4].setPiece(new King(squareArray[0][4], Color.BLACK, "PNGs/black_king.png"));
			squareArray[7][4].setPiece(new King(squareArray[7][4], Color.WHITE, "PNGs/white_king.png"));
		

			//adding pieces to separate linkedlists
			/*
			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < 8; c++) {
					blackPieces.add(squareArray[r][c].getPiece());
					whitePieces.add(squareArray[7-r][c].getPiece());
				}
			}
			*/
			
			
	}
	
	private void createBoardGUI() {
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				super.add(squareArray[r][c], c, r);
			}
		}
	}
	public void updateBoardGUI(Square sq) {
		Square tempSquare = (Square) getNodeFromGridPane(this, sq.getFileNum(), sq.getRankNum());
		tempSquare.removePiece();
		super.getChildren().remove(tempSquare);
		super.add(tempSquare, tempSquare.getFileNum(), tempSquare.getRankNum());
		if (tempSquare.getPiece() == null)
			System.out.println("Successfully removed");
		else
			System.out.println("Failed");
		
	}
	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
	    for (Node node : gridPane.getChildren()) {
	        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
	            return node;
	        }
	    }
	    return null;
	}
	
	private class MouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			if (game) {
			DropShadow drop_shadow = new DropShadow(20, Color.BLACK);
			
			Square selectedSquare = (Square) event.getSource();
			//selects piece
			if (selectedSquare.isFilled() && currentPiece == null) {
			if (selectedSquare.getPiece().getColor().equals(currentPlayer)) {
				setCurrentPiece(selectedSquare.getPiece());//selects currentPiece
				currentPiece.setEffect(drop_shadow);
				showLegalMoves();
			}
			}
			
			if (selectedSquare.isFilled() && currentPiece != null && selectedSquare.getPiece().getColor().equals(currentPlayer)) {
				currentPiece.setEffect(null);
				unshowLegalMoves();
				setCurrentPiece(selectedSquare.getPiece());//swicthes from selected to currentPiece
				currentPiece.setEffect(drop_shadow);
				showLegalMoves();
			}
			//moves piece
			if (!selectedSquare.isFilled() && currentPiece != null) {
				if (defineLegalMove(squareArray,selectedSquare)) {
				movePiece(currentPiece, selectedSquare, currentPiece.getPosition());
				updateMoveBoolean(currentPiece);
				}
					
					currentPiece.setEffect(null);

					setCurrentPiece(null);
					unshowLegalMoves();
					
					if (isCheckmate()) {
						topBar.determineCheckmate();
						bottomBar.determineCheckmate();
						//find way to disable handler for pieces
					}
			}
			//takes piece
			if (selectedSquare.isFilled() && !selectedSquare.getPiece().getColor().equals(currentPlayer) && currentPiece != null) {
				if (defineLegalMove(squareArray,selectedSquare)) {
				takePiece(selectedSquare.getPiece(), currentPiece, selectedSquare, currentPiece.getPosition());
				updateMoveBoolean(currentPiece);
				}
				currentPiece.setEffect(null);
				setCurrentPiece(null);
				unshowLegalMoves();
				
				
				if (isCheckmate()) {
					topBar.determineCheckmate();
					bottomBar.determineCheckmate();
					//find way to disable handler for pieces
					
				}
			}
			
			//decides whether game is over or not
			
			}
		}
	}
	
	
//NOT USED -- DEPRECATED HANDLER
	/*
	private class PieceHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent event) {
			System.out.println("PIECE HANDLER");
			Piece selectedPiece = (Piece) event.getSource();
			DropShadow drop_shadow = new DropShadow(20, Color.BLACK);
			if (currentPiece != null) {//implementation when trying to take piece of other color
				if (!currentPiece.getColor().equals(selectedPiece.getColor()) && defineLegalMove(squareArray, selectedPiece.getPosition())) {
					
					Square oldSquare = currentPiece.getPosition();
					currentPiece.setImage(null);
					oldSquare.removePiece();
					selectedPiece.getPosition().setPiece(currentPiece);
					
					if (currentPlayer.equals(Color.WHITE)) 
						currentPlayer = Color.BLACK;
					else
						currentPlayer = Color.WHITE;
						
					takePiece(selectedPiece, currentPiece, selectedPiece.getPosition(), currentPiece.getPosition());
					unshowLegalMoves();
					updateBoardGUI(currentPiece.getPosition());
					return;
				}
				currentPiece.setEffect(null);
				currentPiece = null;
				return;
			}
			
			if (selectedPiece.getColor().equals(currentPlayer)) {
				setCurrentPiece(selectedPiece);//swicthes from selected to currentPiece
				currentPiece.setEffect(drop_shadow);
				showLegalMoves();
				}
			//list = currentPiece.getLegalMoves(squareArray);
			//System.out.println(list.toString());
			//showLegalMoves();
		}
	}
*/
	/*
	public boolean defineLegalMove(Square[][] squareArr, Piece piece, Square newSquare, Square oldSquare) {
		if (newSquare.isFilled()) return false;
		//oldSquare.removePiece();
		//newSquare.setPiece(piece);
		
		if (currentPlayer.equals(Color.WHITE)) {
			if (isWhiteCheck(squareArray, currentPlayer)) {
				System.out.println("Move not valid - Check detected");
				//newSquare.removePiece();
				//oldSquare.setPiece(piece);
				return false;
			}
			if (isBlackCheck(squareArray, currentPlayer)) {System.out.println("Black in check");}
		} else {//if color is black
			if (isBlackCheck(squareArray, currentPlayer)) {
				System.out.println("Move not valid - Check detected");
				//newSquare.removePiece();
				//oldSquare.setPiece(piece);
				return false;
			}
			if (isWhiteCheck(squareArray, currentPlayer)) {System.out.println("White in check");}
		}
		//newSquare.removePiece();
		//oldSquare.setPiece(piece);
		
		list = currentPiece.getLegalMoves(squareArray, currentPlayer);
		for (int i = 0; i < list.size(); i++) {
			if (newSquare.equals(list.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean defineLegalTake(Square[][] squareArr, Piece takenPiece, Piece replacementPiece, Square takeSquare, Square oldSquare) {//doesnt work
		if (!takeSquare.isFilled()) return false;
		takeSquare.removePiece();
		oldSquare.removePiece();
		takeSquare.setPiece(replacementPiece);
		if (currentPlayer.equals(Color.WHITE)) {
			if (isWhiteCheck(squareArray, currentPlayer)) {
				System.out.println("Move not valid - Check detected");
				takeSquare.removePiece();
				oldSquare.removePiece();
				takeSquare.setPiece(takenPiece);
				oldSquare.setPiece(replacementPiece);
				return false;
			}
		} else {
			if (isBlackCheck(squareArray, currentPlayer)) {
				System.out.println("Move not valid - Check detected");
				takeSquare.removePiece();
				oldSquare.removePiece();
				takeSquare.setPiece(takenPiece);
				oldSquare.setPiece(replacementPiece);
				return false;
			}
		}
		takeSquare.removePiece();
		oldSquare.removePiece();
		takeSquare.setPiece(takenPiece);
		oldSquare.setPiece(replacementPiece);
		
		
		list = currentPiece.getLegalMoves(squareArray, currentPlayer);
		for (int i = 0; i < list.size(); i++) {
			if (takeSquare.equals(list.get(i))) {
				return true;
			}
		}
		return false;
	}
	*/
	
	public boolean isCheckmate() {
		LinkedList<Square> allMoves = new LinkedList<Square>();
		
		/*
		LinkedList<Square> listOfCheckers;
		LinkedList<Square> listOfMoves;
		if (isWhiteCheck(squareArray) && compileValidSquares(squareArray, currentPlayer, findKing(squareArray, Color.WHITE).getPiece()).size() == 0) {
			listOfCheckers = findCheckers(squareArray, Color.WHITE);
			for (int i = 0; i < listOfCheckers.size(); i++) {
				listOfMoves = listOfCheckers.get(i).getPiece().getLegalMoves(squareArray, Color.BLACK);
				for (int e= 0; e < listOfMoves.size(); e++) {
					for (int r = 0; r < squareArray.length; r++) {
						for (int c = 0; c < squareArray[0].length; c++) {
							if (squareArray[r][c].isFilled() && squareArray[r][c].getPiece().getLegalMoves(squareArray, Color.BLACK).contains(listOfMoves.get(e))) {
								return false;
							}
						}
					}
				}
			}
		}
		*/
		
		if (currentPlayer.equals(Color.WHITE) && isWhiteCheck(squareArray)) {
			for (int r = 0; r < squareArray.length; r++) {
				for (int c = 0; c < squareArray[0].length; c++) {
					if (squareArray[r][c].isFilled() && squareArray[r][c].getPiece().getColor().equals(currentPlayer))
						allMoves.addAll(validateLegalMoves(squareArray, squareArray[r][c].getPiece()));
				}
			}
		} else if (currentPlayer.equals(Color.BLACK) && isBlackCheck(squareArray)){
			for (int r = 0; r < squareArray.length; r++) {
				for (int c = 0; c < squareArray[0].length; c++) {
					if (squareArray[r][c].isFilled() && squareArray[r][c].getPiece().getColor().equals(currentPlayer))
						allMoves.addAll(validateLegalMoves(squareArray, squareArray[r][c].getPiece()));
				}
			}
		}
		
		if ((isBlackCheck(squareArray) || isWhiteCheck(squareArray)) && allMoves.size() == 0) {
			allMoves.clear();
			game = false;
			return true;
		} else {
			allMoves.clear();
			game = true;
			return false;
		}
	}
	
	public boolean defineLegalMove(Square[][] squareArr, Square tempSquare) {
		
		list = currentPiece.getLegalMoves(squareArray, currentPlayer);
		for (int i = 0; i < list.size(); i++) {
			if (tempSquare.equals(list.get(i))) {
				return true;
			}
		}
		return false;
		
	}
	
	public Square findKing(Square[][] squareArr, Color color) {
		if (color.equals(Color.WHITE)) {
			for (int r = 0; r < squareArr.length; r++) {
				for (int c = 0; c < squareArr[0].length; c++) {
					//checks is square has piece, then if that piece identifies as a king and it is the opposite color to the player
					if(squareArr[r][c].getPiece() != null && squareArr[r][c].getPiece().getPieceType().equals("King") && squareArr[r][c].getPiece().getColor().equals(Color.WHITE)) {
						return squareArr[r][c];
						//System.out.println("White King Found: X: " + kingSquare.getRankNum() + " Y: " + kingSquare.getFileNum());
						//System.out.println("King has been found - White");
					}
				}
			}
		} else if (color.equals(Color.BLACK)){
			for (int r = 0; r < squareArr.length; r++) {
				for (int c = 0; c < squareArr[0].length; c++) {
					//checks is square has piece, then if that piece identifies as a king and it is the opposite color to the player
					if(squareArr[r][c].getPiece() != null && squareArr[r][c].getPiece().getPieceType().equals("King") && squareArr[r][c].getPiece().getColor().equals(Color.BLACK)) {
						return squareArr[r][c];
						//System.out.println("White King Found: X: " + kingSquare.getRankNum() + " Y: " + kingSquare.getFileNum());
						//System.out.println("King has been found - White");
					}
				}
			}
		}
		return null;
	}
	
	public LinkedList<Square> findCheckers(Square[][] squareArr, Color color) {
		Square kingSquare = findKing(squareArr, color);
		LinkedList<Square> returnList = new LinkedList<Square>();
		
		for (int r = 0; r < squareArr.length; r++) {
			for (int c = 0; c < squareArr[0].length; c++) {
				if (squareArr[r][c].getPiece() != null && squareArr[r][c].getPiece().getLegalMoves(squareArr, color).contains(kingSquare)) {
					returnList.add(squareArr[r][c]);
				}
			}
		}
		return returnList;
	}
	
	
	public boolean isInCheck(Square[][] squareArr, Color player) {
		Square kingSquare = null;
	
		for (int r = 0; r < squareArr.length; r++) {
			for (int c = 0; c < squareArr[0].length; c++) {
				//checks is square has piece, then if that piece identifies as a king and it is the opposite color to the player
				if(squareArr[r][c].getPiece() != null && squareArr[r][c].getPiece().getPieceType().equals("King") && !squareArr[r][c].getPiece().getColor().equals(player)) {
					kingSquare = squareArr[r][c];
				}
			}
		}
		
		for (int r = 0; r < squareArr.length; r++) {
			for (int c = 0; c < squareArr[0].length; c++) {
				if (squareArr[r][c].getPiece() != null && squareArr[r][c].getPiece().getLegalMoves(squareArr, player).contains(kingSquare)) {
					//System.out.println(squareArr[r][c].getPiece().getPieceType());
					//System.out.println(squareArr[r][c].getPiece().getColor().toString());
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isWhiteCheck(Square[][] squareArr) {
		Square kingSquare = findKing(squareArr, Color.WHITE);
		/*
		LinkedList<Square> temp = compileValidSquares(squareArr, Color.WHITE, kingSquare.getPiece());
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i).getRankNum() + " " + temp.get(i).getFileNum() + " ;; ");
		}
		System.out.println("\n");
		*/
		for (int r = 0; r < squareArr.length; r++) {
			for (int c = 0; c < squareArr[0].length; c++) {
				if (squareArr[r][c].getPiece() != null && squareArr[r][c].getPiece().getLegalMoves(squareArr, Color.BLACK).contains(kingSquare) && squareArr[r][c].getPiece().getColor().equals(Color.BLACK)) {
					//System.out.println(squareArr[r][c].getPiece().getPieceType());
					//System.out.println(squareArr[r][c].getPiece().getColor().toString());
					return true;
				}
			}
		}
		return false;
	}
	public boolean isBlackCheck(Square[][] squareArr) {//checks if the black king is in check
		Square kingSquare = findKing(squareArr, Color.BLACK);

		for (int r = 0; r < squareArr.length; r++) {
			for (int c = 0; c < squareArr[0].length; c++) {
				if (squareArr[r][c].getPiece() != null && squareArr[r][c].getPiece().getLegalMoves(squareArr, Color.WHITE).contains(kingSquare) && squareArr[r][c].getPiece().getColor().equals(Color.WHITE)) {// && squareArr[r][c].getPiece().getColor().equals(Color.WHITE)
					//System.out.println(squareArr[r][c].getPiece().getPieceType());
					//System.out.println(squareArr[r][c].getPiece().getColor().toString());
					return true;
				}
			}
		}
		return false;
	}
	
	public LinkedList<Square> compileValidSquares(Square[][] squareArr, Color player, Piece piece) {
		LinkedList<Square> possibleMoves = piece.getLegalMoves(squareArray, player);
		LinkedList<Square> allEnemyMoves = new LinkedList<Square>();
		
		//should add all enemy moves into a single linkedlist to be compared and filtered later
		for (int r = 0; r < squareArr.length; r++) {
			for (int c = 0; c < squareArr[0].length; c++) {
				if (squareArr[r][c].isFilled() && !squareArr[r][c].getPiece().getColor().equals(player)) {
					allEnemyMoves.addAll(squareArr[r][c].getPiece().getLegalMoves(squareArr, player));
				}
			}
		}
		//filter out impossibleMoves due to checks
		for(int i = 0; i < possibleMoves.size(); i++) {
			if (allEnemyMoves.contains(possibleMoves.get(i)))
				possibleMoves.remove(i);
		}
		return possibleMoves;
	}
	
	public LinkedList<Square> validateLegalMoves(Square[][] squareArr, Piece piece) {
		LinkedList<Square> potentialMoves = piece.getLegalMoves(squareArr, piece.getColor());
		Square potentialSquare;
		LinkedList<Square> finalMoves = new LinkedList<Square>();
			for (int r = 0; r < squareArr.length; r++) {
				for (int c = 0; c < squareArr[0].length; c++) {
				}
			}
			
			for (int i = 0; i < potentialMoves.size(); i++) {
				potentialSquare = potentialMoves.get(i);
				if (potentialSquare.isFilled()) {
					if(shouldTakePiece(potentialSquare.getPiece(), piece, potentialSquare, piece.getPosition())) {
						finalMoves.add(potentialSquare);
					}
				} else {
					if (shouldMovePiece(piece, potentialSquare, piece.getPosition())) {
						finalMoves.add(potentialSquare);
					}
				}
			}
		return finalMoves;
	}
	
	public LinkedList<Square> compileAllValidEnemyMoves(Color enemyColor) {
		LinkedList<Square> list = new LinkedList<Square>();
		for(int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (squareArray[r][c].isFilled() && squareArray[r][c].getColor().equals(enemyColor)) {
					list.addAll(validateLegalMoves(squareArray, squareArray[r][c].getPiece()));
				}
			}
		}
		return list;
	}
	
	public boolean validateLeftCastle() {//TEST TO SEE IF IT WORKS
		
		
		LinkedList<Square> list;
		if (currentPlayer.equals(Color.WHITE)) {
			if (squareArray[7][0].isFilled() && !squareArray[7][0].getPiece().getMoveBoolean() && squareArray[7][4].isFilled() && !squareArray[7][4].getPiece().getMoveBoolean()) {
				list = compileAllValidEnemyMoves(Color.BLACK);
				for (int c = 1; c <= 3; c++) {
					if (squareArray[7][c].isFilled() || list.contains(squareArray[7][c]))
						return false;
				}
				for (int c = 5; c < 7; c++) {
					if (squareArray[7][c].isFilled() || list.contains(squareArray[7][c]))
						return false;
				}
				return true;
			} 
		} else {
			if (squareArray[0][0].isFilled() && !squareArray[0][0].getPiece().getMoveBoolean() && squareArray[0][4].isFilled() && !squareArray[0][4].getPiece().getMoveBoolean()) {
				list = compileAllValidEnemyMoves(Color.WHITE);
				for (int c = 1; c <= 3; c++) {
					if (squareArray[0][c].isFilled() || list.contains(squareArray[0][c]))
						return false;
				}
				for (int c = 5; c < 7; c++) {
					if (squareArray[0][c].isFilled() || list.contains(squareArray[0][c]))
						return false;
				}	
			return true;
		}
		}	
		return false;
	}
	
	public void updateMoveBoolean(Piece piece) {
		if (piece.getPieceType().equals("King") || piece.getPieceType().equals("Rook") || piece.getPieceType().equals("Pawn")) {
			piece.setMoveBoolean(true);
		}
	}
	
	
	
	public void takePiece(Piece takenPiece, Piece replacementPiece, Square takeSquare, Square oldSquare) {
		takeSquare.removePiece();
		oldSquare.removePiece();
		takeSquare.setPiece(replacementPiece);
		
		if (currentPlayer.equals(Color.WHITE)) {
			if (isWhiteCheck(squareArray)) {
				System.out.println("Move not valid - Check detected");
				takeSquare.removePiece();
				oldSquare.removePiece();
				takeSquare.setPiece(takenPiece);
				oldSquare.setPiece(replacementPiece);
				return;
			}
			if (isBlackCheck(squareArray)) {
				System.out.println("Created Check");
			}	
		} else if (currentPlayer.equals(Color.BLACK)) {
			if (isBlackCheck(squareArray)) {
				System.out.println("Move not valid - Check detected");
				takeSquare.removePiece();
				oldSquare.removePiece();
				takeSquare.setPiece(takenPiece);
				oldSquare.setPiece(replacementPiece);
				return;
			}
			if (isWhiteCheck(squareArray)) {
				System.out.println("Created Check");
			}	
		}
		
		takenPiece.setImage(null);
		if (currentPlayer.equals(Color.WHITE)) {
			topBar.update(takenPiece.getPieceType(), Color.WHITE);
			bottomBar.update(takenPiece.getPieceType(), Color.WHITE);
		} else if (currentPlayer.equals(Color.BLACK)) {
			bottomBar.update(takenPiece.getPieceType(), Color.BLACK);
			topBar.update(takenPiece.getPieceType(), Color.BLACK);
		}
		takeSquare.removePiece();
		oldSquare.removePiece();
		takeSquare.setPiece(replacementPiece);
		
		if (currentPlayer.equals(Color.WHITE)) 
			currentPlayer = Color.BLACK;
		else
			currentPlayer = Color.WHITE;
		
	}
	
	public boolean shouldTakePiece(Piece takenPiece, Piece replacementPiece, Square takeSquare, Square oldSquare) {
		takeSquare.removePiece();
		oldSquare.removePiece();
		takeSquare.setPiece(replacementPiece);
		
		if (currentPlayer.equals(Color.WHITE)) {//move not valid
			if (isWhiteCheck(squareArray)) {
				takeSquare.removePiece();
				oldSquare.removePiece();
				takeSquare.setPiece(takenPiece);
				oldSquare.setPiece(replacementPiece);
				return false;
			}
			if (isBlackCheck(squareArray)) {//creates a check
			}	
		} else if (currentPlayer.equals(Color.BLACK)) {//move not valid
			if (isBlackCheck(squareArray)) {
				takeSquare.removePiece();
				oldSquare.removePiece();
				takeSquare.setPiece(takenPiece);
				oldSquare.setPiece(replacementPiece);
				return false;
			}
			if (isWhiteCheck(squareArray)) {//creates a check
			}	
		}
		takeSquare.removePiece();
		oldSquare.removePiece();
		takeSquare.setPiece(takenPiece);
		oldSquare.setPiece(replacementPiece);
		return true;
	}
		
	public void movePiece(Piece piece, Square newSquare, Square oldSquare) {
		oldSquare.removePiece();
		newSquare.setPiece(piece);
		
		if (currentPlayer.equals(Color.WHITE)) {
			if (isWhiteCheck(squareArray)) {
				System.out.println("Move not valid - Check detected");
				newSquare.removePiece();
				oldSquare.setPiece(piece);
				return;
			}
			if (isBlackCheck(squareArray)) {
				System.out.println("Created Check");
			}	
		} else if (currentPlayer.equals(Color.BLACK)) {
			if (isBlackCheck(squareArray)) {
				System.out.println("Move not valid - Check detected");
				newSquare.removePiece();
				oldSquare.setPiece(piece);
				return;
			}
			if (isWhiteCheck(squareArray)) {
				System.out.println("Created Check");
			}	
		}
		
	
		
		if (currentPlayer.equals(Color.WHITE)) 
			currentPlayer = Color.BLACK;
		else
			currentPlayer = Color.WHITE;

	}
	
	public boolean shouldMovePiece(Piece piece, Square newSquare, Square oldSquare) {
		oldSquare.removePiece();
		newSquare.setPiece(piece);
		
		if (currentPlayer.equals(Color.WHITE)) {//move not valid
			if (isWhiteCheck(squareArray)) {
				newSquare.removePiece();
				oldSquare.setPiece(piece);
				return false;
			}
			if (isBlackCheck(squareArray)) {//creates check
			}	
		} else if (currentPlayer.equals(Color.BLACK)) {//move not valid
			if (isBlackCheck(squareArray)) {
				newSquare.removePiece();
				oldSquare.setPiece(piece);
				return false;
			}
			if (isWhiteCheck(squareArray)) {//created check
			}	
		}
		oldSquare.setPiece(piece);
		newSquare.removePiece();
		return true;
	}
	/*
	public void selectPiece(Piece piece) {
		DropShadow drop_shadow = new DropShadow(20, Color.BLACK);
		int file = piece.getPosition().getFileNum();
		int rank = piece.getPosition().getRankNum();
		squareArray[file][rank].getPiece().setEffect(drop_shadow);
		//squareArray[file][rank].getChildren().get(0).getLegalMoves(this);
	}
		*/
	public void showLegalMoves() {
		if (currentPiece == null) {
			//System.out.println("NO SELECTED PIECE");
			return;
		}
		//list = currentPiece.getLegalMoves(squareArray, currentPlayer);
			list = validateLegalMoves(squareArray, currentPiece);
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						if (list.contains(squareArray[r][c])) {
							squareArray[r][c].setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
						}
					}
				}
				list.clear();
		}
	public void unshowLegalMoves() {
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				squareArray[r][c].setBackground(new Background(new BackgroundFill(squareArray[r][c].getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
	}
	public Square[][] getSquareArray() {
		return squareArray;
	}
	public LinkedList<Piece> getWhitePieces() {
		return whitePieces;
	}
	public LinkedList<Piece> getBlackPieces() {
		return blackPieces;
	}
	public Boolean getValidGame() {
		return game;
	}
	public Color getTurn() {
		return currentPlayer;
	}
	public Piece setCurrentPiece(Piece p) {
		unshowLegalMoves();
		return currentPiece = p;
	}
	public TopBar getTopBar() {
		return topBar;
	}
	public TopBar getBottomBar() {
		return bottomBar;
	}
	public boolean getGame() {
		return game;
	}
	public void setGame(boolean g) {
		game = g;
	}
	public boolean getRestart() {
		return restart;
	}
	public void setRestart(boolean re) {
		restart = re;
	}
	public SideBar getSideBar() {
		return sideBar;
	}
}

