
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public abstract class Piece extends ImageView {
	private Square position;
	private Color color;
	private String image;
	private FileInputStream img;
	
	public Piece(Square position, Color color, String image) {
		this.position = position;
		this.color = color;
		this.image = image;
		/*
		try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource("/PNGs/black_bishop.png"));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
          */
	}
	public Piece() {
		this.position = null;
		this.color = null;
		this.image = null;
	}
	
	public abstract String getPieceType();
	public abstract LinkedList<Square> getLegalMoves(Square[][] squareArray, Color currentPlayer);
	
	public boolean isValidIndex(Square[][] array, int index) {
		return index >= 0 && index < array.length;
	}
	public boolean defineLegalTake(Square[][] squareArray, Color currentPlayer, int currX, int currY, int takeX, int takeY) {
		try {
		if (squareArray[takeX][takeY].getPiece().getColor().equals(currentPlayer))
			return false;
		if (!squareArray[takeX][takeY].getPiece().getColor().equals(currentPlayer))// && !squareArray[takeX][takeY].getPiece().getColor().equals(squareArray[currX][currY].getPiece().getColor())
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	public Square getPosition() {
		return position;
	}
	public void setPosition(Square pos) {
		position = pos;
	}
	public Color getColor() {
		return color;
	}
	public void drawPiece() {
		Image pieceImage;
		
			pieceImage = new Image(image);
			super.setImage(pieceImage);
	
	}
	public void changeImage(String img) {
		image = img;
	}
	public String toString() {
		return "Piece";
	}
}
