import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChessProgram extends Application {
	
    public static final int WINSIZE_X = 950, WINSIZE_Y = 950;
    private final String WINTITLE = "Chess";

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane rootPane = new BorderPane();
		Board board = new Board();
		rootPane.setTop(board.getTopBar().getContainer());
		rootPane.setCenter(board);
		rootPane.setBottom(board.getBottomBar().getContainer());
		rootPane.setRight(board.getSideBar().getContainer());
		
        rootPane.setPrefSize(WINSIZE_X, WINSIZE_Y);
        Scene scene = new Scene(rootPane, WINSIZE_X, WINSIZE_Y);
        stage.setTitle(WINTITLE);
        stage.setScene(scene);
        stage.show();
	}
	
    public static void main(String[] args)
    {
        launch(args);
    }



}
