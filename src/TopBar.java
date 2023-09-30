import com.sun.javafx.css.FontFace.FontFaceSrcType;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TopBar extends HBox{
	private Label name;
	private Label scoreLabel;
	private Label checkmate;
	private HBox pieces;
	private VBox container;
	private HBox innerContainer;
	private int score;
	private Color colorOfPlayer;
	
	
	public TopBar(String labelName, Color colorOfPlayer) {
		name = new Label(labelName);
		name.setFont(Font.font("Lucida Sans Unicode", FontPosture.ITALIC, 20));
		scoreLabel = new Label("0");
		scoreLabel.setFont(Font.font("Lucida Sans Unicode", FontPosture.ITALIC, 20));
		checkmate = new Label();
		checkmate.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, 40));
		pieces = new HBox();
		score = 0;
		this.colorOfPlayer = colorOfPlayer;
		this.container = new VBox();
		this.innerContainer = new HBox();
		container.getChildren().add(name);
		innerContainer.getChildren().add(scoreLabel);
		innerContainer.getChildren().add(pieces);
		innerContainer.getChildren().add(checkmate);
		container.getChildren().add(innerContainer);
		//super.getChildren().add(container);
	}
	
	
	
	public void update(String pieceType, Color color) {
		String input;
		//Determines color of player and appropriate image to display
		if (colorOfPlayer.equals(Color.WHITE)) {
			input = "black";
		} else {
			input = "white";
		}
		//TAKEN KNIGHT
		if (pieceType.equals("Knight") && colorOfPlayer.equals(color)) {
			pieces.getChildren().add(new ImageView("PNGs/" + input + "_knight.png"));
			score+=3;
			scoreLabel.setText("" + score);
		} else if (pieceType.equals("Knight")) {
			//pieces.getChildren().add(new ImageView("PNGs/" + input + "_knight.png"));
			score-=3;
			scoreLabel.setText("" + score);
		}
		//TAKEN BISHOP
		if (pieceType.equals("Bishop") && colorOfPlayer.equals(color)) {
			pieces.getChildren().add(new ImageView("PNGs/" + input + "_bishop.png"));
			score+=3;
			scoreLabel.setText("" + score);
		} else if (pieceType.equals("Bishop")) {
			//pieces.getChildren().add(new ImageView("PNGs/" + input + "_bishop.png"));
			score-=3;
			scoreLabel.setText("" + score);
		}
		//TAKEN ROOK
		if (pieceType.equals("Rook") && colorOfPlayer.equals(color)) {
			pieces.getChildren().add(new ImageView("PNGs/" + input + "_rook.png"));
			score+=5;
			scoreLabel.setText("" + score);
		} else if (pieceType.equals("Rook")) {
			//pieces.getChildren().add(new ImageView("PNGs/" + input + "_rook.png"));
			score-=5;
			scoreLabel.setText("" + score);
		}
		//TAKEN PAWN
		if (pieceType.equals("Pawn") && colorOfPlayer.equals(color)) {
			pieces.getChildren().add(new ImageView("PNGs/" + input + "_pawn.png"));
			score+=1;
			scoreLabel.setText("" + score);
		} else if (pieceType.equals("Pawn")) {
			//pieces.getChildren().add(new ImageView("PNGs/" + input + "_pawn.png"));
			score-=1;
			scoreLabel.setText("" + score);
		}
		//TAKEN QUEEN
		if (pieceType.equals("Queen") && colorOfPlayer.equals(color)) {
			pieces.getChildren().add(new ImageView("PNGs/" + input + "_queen.png"));
			score+=9;
			scoreLabel.setText("" + score);
		} else if (pieceType.equals("Queen")) {
			//pieces.getChildren().add(new ImageView("PNGs/" + input + "_queen.png"));
			score-=9;
			scoreLabel.setText("" + score);
		}
	}
	
	public void determineCheckmate() {
		checkmate.setText("CHECKMATE");
	}
	
	public VBox getContainer() {
		return container;
	}
}