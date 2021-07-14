import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResearchScene {

    static Stage wn = new Stage();
    private Finder f = new Finder();

    public void researchWindow() {
        BorderPane bp = new BorderPane();
        GridPane layout = new GridPane();

        layout.setPadding(new Insets(20, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(10);

        // Sets up a VBox and the left side menu bar
        VBox leftMenu = new VBox(10);
        leftMenu.setPadding(new Insets(20, 10, 10, 10));

        Button closeWin = new Button("Close Window");
        closeWin.setId("open-close-buttons");
        closeWin.setMinWidth(125);
        closeWin.setOnAction(e -> closeProgram());
        leftMenu.getChildren().add(closeWin);

        /*        ###############################################################         */


        // So right here is where we will use my AtomFinder methods with buttons and text fields
        // The initial text field looking for the atomic symbol
        TextField atomicSymbolInput = new TextField();
        atomicSymbolInput.setPromptText("Atomic Symbol");
        GridPane.setConstraints(atomicSymbolInput, 1, 0);
        // Result Field - Results will be put on the screen as a label
        Label symbolResult = new Label("");
        symbolResult.setId("blue-bold-label");
        symbolResult.setStyle("-fx-font-size: 10pt");
        GridPane.setConstraints(symbolResult,1, 1);
        // We need a button to get information from this field, later on I may change this to an automatic
        // detection for input to make the program run a bit smoother
        Button getAtomicSymbol = new Button("Get Info");
        getAtomicSymbol.setMinWidth(50);
        getAtomicSymbol.setOnAction(e -> {
            symbolResult.setText(isSymbol(atomicSymbolInput, atomicSymbolInput.getText()));
        });
        GridPane.setConstraints(getAtomicSymbol, 2, 0);

        /*        ###############################################################         */

        // Now I will be adding another Button, Label, and TextField for searching via Atomic Number
        TextField atomicNumberInput = new TextField();
        atomicNumberInput.setPromptText("Atomic Number");
        GridPane.setConstraints(atomicNumberInput, 1, 2);
        // A Second result field for the Atomic Number search results
        Label numResult = new Label("");
        numResult.setId("blue-bold-label");
        numResult.setStyle("-fx-font-size: 10pt");
        GridPane.setConstraints(numResult, 1, 3);
        // Finally a Button to get information from the atomicNumberInput TextField
        Button getAtomicNumber = new Button("Get Info");
        GridPane.setConstraints(getAtomicNumber, 2, 2);
        getAtomicNumber.setMinWidth(50);
        getAtomicNumber.setOnAction(e -> {
            numResult.setText(isAtomicNumber(atomicNumberInput, atomicNumberInput.getText()));
        });


        layout.getChildren().addAll(atomicSymbolInput, getAtomicSymbol, symbolResult, atomicNumberInput, numResult, getAtomicNumber);

        bp.setLeft(leftMenu);
        bp.setCenter(layout);


        wn.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Scene research = new Scene(bp, 700, 600);
        research.getStylesheets().add("Style.css");
        wn.setScene(research);
        wn.setTitle("Chemistry Calculator - Research Window");
        wn.show();

    }

    private static void closeProgram() {
        boolean answer = AlertBox.display("Please Confirm", "Are you sure you wish to exit?");
        if (answer)
            wn.close();
    }

    //Validate Atomic Number
    private String isAtomicNumber(TextField input, String message){
        try{
            int number = Integer.parseInt(input.getText());
            return f.getElementNumber(number);
        }catch(NumberFormatException e){
            return "Error: " + message + " is not a number, or is not less than 118";
        }
    }

    private String isSymbol(TextField tf, String message) {
        if(f.isElement(message)){
            return (f.getElementName(message));
        }
        return "Please enter a valid Atomic Symbol";
    }

}
