

import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SideBar extends HBox {
	private VBox container;
	private Button startButton;
	private Button pauseButton;
	//private boolean startButtonState;
	private boolean pauseButtonState;
	private Board board;

	
	public SideBar(Board board) {
		this.container = new VBox();
		this.startButton = new Button();
		this.startButton.setText("Start New Game");
		this.startButton.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white;");
		this.startButton.setPrefSize(150, USE_COMPUTED_SIZE);
		//startButtonState = false;
		this.startButton.setOnMousePressed(event -> StartButtonHandler());
		
		this.pauseButton = new Button();
		this.pauseButton.setText("Pause Game");
		this.pauseButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
		this.pauseButton.setPrefSize(150, USE_COMPUTED_SIZE);
		pauseButtonState = false;
		this.pauseButton.setOnMousePressed(event -> PauseButtonHandler());
		
		this.container.getChildren().add(startButton);
		this.container.getChildren().add(pauseButton);
		
		this.board = board;
	}
	
	
private void StartButtonHandler()  {
	/*
	//	startButtonState = !startButtonState;
		System.out.println("Start button clicked");
		
			this.startButton.setStyle("-fx-background-color: #40E0D0; -fx-text-fill: white;");
			this.startButton.setText("Restarting");
			board.destructor();
			board.setRestart(true);
			try        
			{
			    Thread.sleep(3000);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			    System.out.println("bruhhh");
			}
			board.constructor();
			board.setRestart(false);
			startButton.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white;");
			startButton.setText("Start New Game");
			System.out.println("Restart Done");
		*/
	System.out.println("Start button clicked");

    // Change button appearance
    startButton.setStyle("-fx-background-color: #40E0D0; -fx-text-fill: white;");
    startButton.setText("Restarting");
    
    board.destructor();
    board.setRestart(true);

    // Run a background task after a delay
    Task<Void> restartTask = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            Thread.sleep(3000);
            return null;
        }
    };

    restartTask.setOnSucceeded(event -> {
        // This code runs on the JavaFX application thread
        board.constructor();
        board.setRestart(false);
        
        // Change button appearance back
        startButton.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white;");
        startButton.setText("Start New Game");
        
        System.out.println("Restart Done");
    });

    // Start the background task
    new Thread(restartTask).start();
	}

private void PauseButtonHandler() {
	pauseButtonState = !pauseButtonState;
	if (pauseButtonState == true) {
		pauseButton.setStyle("-fx-background-color: #3CB371; -fx-text-fill: white;");
		pauseButton.setText("Unpause Game");
		board.setGame(false);
	} else {
		pauseButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
		pauseButton.setText("Pause Game");
		board.setGame(true);
	}
	
}
/*
public boolean getStartButtonState() {
	return startButtonState;
}
public void setStartButtonState(boolean state) {
	startButtonState = state;
}
*/
public boolean getPauseButtonState() {
	return pauseButtonState;
}
public void setPauseButtonState(boolean state) {
	pauseButtonState = state;
}
public Button getStartButton() {
	return startButton;
}
public VBox getContainer() {
	return container;
}
}