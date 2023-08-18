import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SideBar extends HBox {
	private VBox container;
	private Button startButton;
	private Button pauseButton;
	private boolean startButtonState;
	private boolean pauseButtonState;
	
	public SideBar() {
		this.container = new VBox();
		this.startButton = new Button();
		this.startButton.setText("Start New Game");
		this.startButton.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white;");
		this.startButton.setPrefSize(150, USE_COMPUTED_SIZE);
		startButtonState = false;
		this.startButton.setOnAction(event -> StartButtonHandler());
		
		this.pauseButton = new Button();
		this.pauseButton.setText("Pause Game");
		this.pauseButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
		this.pauseButton.setPrefSize(150, USE_COMPUTED_SIZE);
		pauseButtonState = false;
		this.pauseButton.setOnAction(event -> PauseButtonHandler());
		
		this.container.getChildren().add(startButton);
		this.container.getChildren().add(pauseButton);
	}
	
	
private void StartButtonHandler() {
		startButtonState = !startButtonState;
		/*
		if (startButtonState == true) {
			startButton.setStyle("-fx-background-color: #40E0D0; -fx-text-fill: white;");
		} else {
			startButton.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white;");
		}
		*/
		
	}

private void PauseButtonHandler() {
	pauseButtonState = !pauseButtonState;
	if (pauseButtonState == true) {
		pauseButton.setStyle("-fx-background-color: #3CB371; -fx-text-fill: white;");
	} else {
		pauseButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
	}
	
}
public boolean getStartButtonState() {
	return startButtonState;
}
public void setStartButtonState(boolean state) {
	startButtonState = state;
}
public boolean getPauseButtonState() {
	return pauseButtonState;
}
public void setPauseButtonState(boolean state) {
	pauseButtonState = state;
}
public VBox getContainer() {
	return container;
}
}
