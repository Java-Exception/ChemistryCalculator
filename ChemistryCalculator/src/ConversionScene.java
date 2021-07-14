import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConversionScene {

    static Stage wn = new Stage();
    private Finder f = new Finder();

    public Scene conversionScene() {
        BorderPane bp = new BorderPane();
        GridPane layout = new GridPane();
        AtomFinder af = new AtomFinder();

        layout.setPadding(new Insets(20, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(10);

        // Sets up a VBox and the left side menu bar
        VBox leftMenu = new VBox(10);
        leftMenu.setPadding(new Insets(20, 10, 10, 10));

        Button goBack = new Button("Back");
        goBack.setId("open-close-buttons");
        goBack.setMinWidth(125);
        goBack.setOnAction(e -> CalcWindowSetup.Display());
        leftMenu.getChildren().add(goBack);

        /*        ###############################################################         */


        // So right here is where we will use my AtomFinder methods with buttons and text fields
        // The initial text field looking for the atomic symbol
        TextField atomicSymbolInput = new TextField();
        atomicSymbolInput.setPromptText("Atomic Symbol");
        GridPane.setConstraints(atomicSymbolInput, 1, 0);

        // Here we will make a second text field for the moles of X element
        TextField asUnitInput = new TextField();
        asUnitInput.setPromptText("Unit");
        GridPane.setConstraints(asUnitInput, 2, 0);

        // Result Field - Results will be put on the screen as a label
        Label symbolResult = new Label("");
        symbolResult.setId("blue-bold-label");
        symbolResult.setStyle("-fx-font-size: 10pt");
        GridPane.setConstraints(symbolResult,1, 1);

        // We need a button to get information from this field (atomicSymbolInput), later on I may change this to an automatic
        // detection for input to make the program run a bit smoother
        Button getAtomicSymbol = new Button("Set Data");
        getAtomicSymbol.setMinWidth(50);
        getAtomicSymbol.setOnAction(e -> {
            symbolResult.setText(asUnitInput.getText() + " g/m/a" + " of " + isSymbol(atomicSymbolInput.getText()));
        });
        GridPane.setConstraints(getAtomicSymbol, 3, 0);



        /*        ###############################################################         */

        // Now I will be adding another Button, Label, and TextField for searching via Atomic Number
        TextField GMorA = new TextField();
        GMorA.setPromptText("___to___");
        GridPane.setConstraints(GMorA, 1, 4);

        // A Second result field for the Atomic Number search results
        Label gmaLabel = new Label("Enter in the format: gramstomoles, etc");
        gmaLabel.setId("blue-bold-label");
        gmaLabel.setStyle("-fx-font-size: 10pt");
        GridPane.setConstraints(gmaLabel, 1, 3);

        // Another text field to tell the user if the input was invalid
        Label isValidInput = new Label("");
        isValidInput.setId("blue-bold-label");
        isValidInput.setStyle("-fx-font-size: 10pt");
        GridPane.setConstraints(isValidInput, 1, 5);

        // to tell us what the result of our calculation will be
        Label result = new Label("");
        result.setId("blue-bold-label");
        result.setStyle("-fx-font-size: 10pt");
        GridPane.setConstraints(result, 2, 5);

        // Finally a Button to get information from the atomicNumberInput TextField
        Button getAtomicNumber = new Button("Calculate");
        GridPane.setConstraints(getAtomicNumber, 2, 4);
        getAtomicNumber.setMinWidth(50);
        getAtomicNumber.setOnAction(e -> {
            if (conversionType(GMorA.getText()).equals("Invalid Input.") ) {
                isValidInput.setText("Please enter a valid Input");
            } else if (!conversionType(GMorA.getText()).equals("Invalid Input.")) {
                isValidInput.setText(GMorA.getText());
                result.setText(Double.toString(af.gramsMolesAtoms(GMorA.getText(), atomicSymbolInput.getText(), isNumber(asUnitInput))));
            }

        });


        layout.getChildren().addAll(atomicSymbolInput, asUnitInput, getAtomicSymbol, symbolResult, GMorA, gmaLabel, getAtomicNumber, isValidInput, result);

        bp.setLeft(leftMenu);
        bp.setCenter(layout);


        wn.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Scene conversion = new Scene(bp, 700, 600);
        conversion.getStylesheets().add("Style.css");
        return conversion;

    }


    private static void closeProgram() {
        boolean answer = AlertBox.display("Please Confirm", "Are you sure you wish to exit?");
        if (answer)
            CalcWindowSetup.Display();
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

    private String conversionType(String gma) {
        gma = gma.toLowerCase().replaceAll(" ", "");
        if (gma.equals("gramstomoles") || gma.equals("gramstoatoms") || gma.equals("molestograms") || gma.equals("molestoatoms") || gma.equals("atomstograms") || gma.equals("atomstomoles"))
            return gma;
        else
            return "Invalid Input.";

    }

    private String isSymbol(String message) {
        if(f.isElement(message)){
            return (f.elementName(message));
        }
        return "Please enter a valid Atomic Symbol";
    }


    //Validate Atomic Number
    private double isNumber(TextField input){
        try{
            return Double.parseDouble(input.getText());
        }catch(NumberFormatException e){
            return -1;
        }
    }




// gma.gramsToMoles(grams, f.getAtomicMass(f.getAtomicNumber(atom)))
// gma.gramsToAtoms(grams, f.getAtomicMass(f.getAtomicNumber(atom)))

// gma.molesToGrams(moles, f.getAtomicMass(f.getAtomicNumber(atom)))
// gma.molesToAtoms(moles, f.getAtomicMass(f.getAtomicNumber(atom)))

// gma.atomsToGrams(atoms, f.getAtomicMass(f.getAtomicNumber(atom)))
// gma.atomsToMoles(atoms, f.getAtomicMass(f.getAtomicNumber(atom)))


}
