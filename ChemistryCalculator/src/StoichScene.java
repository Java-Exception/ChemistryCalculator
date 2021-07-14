import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.ArrayList;

public class StoichScene {


    static Stage wn = new Stage();
    private Finder f = new Finder();
    ConversionScene cs = new ConversionScene();

    public Scene stoichiometryScene() {
        // Going to use nested layouts
        BorderPane bp = new BorderPane();
        GridPane layout = new GridPane();
        AtomFinder af = new AtomFinder();


        layout.setPadding(new Insets(20, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(10);

        // Sets up a VBox and the left side menu bar
        VBox leftMenu = new VBox(10);
        leftMenu.setPadding(new Insets(20, 10, 10, 10));

        // Setting up the exit button for the stoich scene
        Button goBack = new Button("Back");
        goBack.setId("open-close-buttons");
        goBack.setMinWidth(125);
        goBack.setOnAction(e -> CalcWindowSetup.Display());

        Button conversionButton = new Button("GMA Conversions");
        conversionButton.setMinWidth(125);
        conversionButton.setOnAction(e -> CalcWindowSetup.Display());

        TextField compoundInput = new TextField();
        compoundInput.setPromptText("Unit");
        GridPane.setConstraints(compoundInput, 2, 0);





        leftMenu.getChildren().addAll(goBack, conversionButton, compoundInput);




        bp.setLeft(leftMenu);
        bp.setCenter(layout);


        wn.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Scene stoich = new Scene(bp, 700, 600);
        stoich.getStylesheets().add("Style.css");
        return stoich;

    }

    private static void closeProgram() {
        boolean answer = AlertBox.display("Please Confirm", "Are you sure you wish to exit?");
        if (answer)
            CalcWindowSetup.Display();
    }

    private ArrayList<String> tokenizeCompound(String compound) {
        Scanner reacScanner = new Scanner(System.in);
        ArrayList<String> compoundTokenized = new ArrayList<String>();
        String rxn = reacScanner.nextLine().replaceAll(" ", "");

        StringTokenizer reaction = new StringTokenizer(rxn, "+");
        while (reaction.hasMoreTokens()) {
            compoundTokenized.add(reaction.nextToken());
        }

        return compoundTokenized;

    }
}
