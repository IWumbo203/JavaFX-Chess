
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Square extends StackPane{
	private Color color;
	private Piece currentPiece;
	
	private int rankNum;
	private int fileNum;
	
	private boolean isFilled;
	
	public Square(Color black, int rankNum, int fileNum, boolean isFilled) {
		this.color = black;
		this.rankNum = rankNum;
		this.fileNum = fileNum;
		this.isFilled = isFilled;
		this.currentPiece = null;
	}
	
	
	public Color getColor() {
		return color;
	}
	public Piece getPiece() {
		return currentPiece;
	}
	public int getRankNum() {
		return rankNum;
	}
	public int getFileNum() {
		return fileNum;
	}
	public boolean isFilled() {
		return isFilled;
	}
	public void setColor(Color c) {
		color = c;
	}
	public void setPiece(Piece p) {
		currentPiece = p;
		if (!super.getChildren().isEmpty()) {
			super.getChildren().remove(0);
		}
		super.getChildren().add(p);
		isFilled = true;
		currentPiece.setPosition(this);
	}
	public void removePiece() {
		super.getChildren().removeAll();
		currentPiece = null;
		isFilled = false;
	}
	public void setRankNum(int r) {
		rankNum = r;
	}
	public void setFileNum(int f) {
		fileNum = f;
	}
	public void setIsFilled(boolean b) {
		isFilled = b;
	}
	public String toString() {
		return "Square";
	}
	
}