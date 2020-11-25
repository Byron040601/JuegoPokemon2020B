package Game;

//Byron Huaraca
//Jorge Alaba
//Bernabé Dávila 

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WindowFour implements ReadInterface {

    private Stage window;
    private ListView<String> listNick;
    private ObservableList<String> itemsOne;
    private ListView<Integer> listVic;
    private ObservableList<Integer> itemsTwo;
    private ListView<String> listPoints;
    private ObservableList<String> itemsThree;

    public WindowFour(Stage window) {
        this.window = window;
        this.listNick = new ListView<String>();
        this.itemsOne = FXCollections.observableArrayList();
        this.listVic = new ListView<Integer>();
        this.itemsTwo = FXCollections.observableArrayList();
        this.listPoints = new ListView<String>();
        this.itemsThree = FXCollections.observableArrayList();
    }

    public Parent screenFourCl() {

        Button selectCharacter = new Button("Seleccion de personajes");
        Button getOutGame = new Button("Salir");

        Label title1 = new Label("POO");
        Label title2 = new Label("BATTLE PRO");

        HBox table = new HBox();

        read();
        readTwo();

        for (int i = 0; i < itemsOne.size(); i++) {
            this.itemsThree.add(".....................................................");
        }
        listNick.setItems(itemsOne);
        listVic.setItems(itemsTwo);
        listPoints.setItems(itemsThree);

        //Collections.sort(itemsTwo);
        //Collections.sort(itemsOne);
        title1.setFont(Font.font("Agency FB", FontPosture.ITALIC, 30));
        title2.setFont(Font.font("Agency FB", FontPosture.ITALIC, 30));

        table.getChildren().addAll(
                listNick,
                listPoints,
                listVic
        );

        BorderPane layout = new BorderPane();
        VBox center = new VBox();

        center.setAlignment(Pos.CENTER);
        center.getChildren().addAll(title1,
                title2,
                new Label(""),
                table,
                new Label(""),
                selectCharacter,
                new Label(""),
                getOutGame,
                new Label(""));

        selectCharacter.setOnAction((value) -> {
            File fichero = new File("validation.txt");
            fichero.delete();

            WindowOne w1 = new WindowOne(window);

            BorderPane B1 = new BorderPane();
            B1.setCenter(w1.Pantalla());

            Scene scene = new Scene(B1, 550, 500);
            this.window.setScene(scene);
        });

        getOutGame.setOnAction((value) -> {
            File fichero = new File("validation.txt");
            fichero.delete();
            System.exit(0);
        });

        layout.setCenter(center);
        layout.setPadding(new Insets(10, 10, 10, 10));

        return layout;

    }

    @Override
    public ObservableList read() {
        try (Scanner scanner = new Scanner(Paths.get("data.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(" ")) {
                    break;
                }
                String[] parts = line.split(",");
                String user = parts[4];
                this.itemsOne.add(user);

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return this.itemsOne;
    }

    @Override
    public ObservableList readTwo() {
        try (Scanner scanner = new Scanner(Paths.get("data.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(" ")) {
                    break;
                }
                String[] parts = line.split(",");
                int victories = Integer.parseInt(parts[5]);
                this.itemsTwo.add(victories);

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return this.itemsTwo;
    }
}
