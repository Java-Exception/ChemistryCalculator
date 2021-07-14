import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
//        AtomFinder f = new AtomFinder();
//        f.findThings();
    }

    @Override
    public void start(Stage primaryStage) {
        CalcWindowSetup.Display();
    }

}
