package Game;

//Byron Huaraca
//Jorge Alaba
//Bernabé Dávila
//Karen Hurtado 

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class WindowOne {
//Esta es la primera pantalla que sera desplegada
    private Stage window;
    private ArrayList<Person> list;
    private ArrayList<Person> list2;
    private ArrayList<String> listMonsters;
    private ArrayList<String> typeMonsters;
    private String nameJ1 = "";
    private String nameP1 = "";
    private String nameP2 = "";
    private String type1 = "";
    private String type2 = "";
    private int indice;
    private int indice1;

    public WindowOne(Stage window) {
        this.window = window;
        this.list = new ArrayList<>();
        this.list2 = new ArrayList<>();
        this.listMonsters = new ArrayList<>();
        this.typeMonsters = new ArrayList<>();

    }

    public Parent Pantalla() {

        Button RegisJugador = new Button("Registrar\nJugador");
        Button jugador1 = new Button("Seleccionar\nJugador 1");
        Button jugador2 = new Button("Seleccionar\nJugador 2");
        Button inicio = new Button("Empezar");
        Button puntajes = new Button("Puntajes");

        jugador2.setDisable(true);

        inicio.setDisable(true);

        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);

        Label poo = new Label("POO");
        Label battlepro = new Label("BATTLE PRO");

        poo.setFont(Font.font("Monospaced", 35));
        battlepro.setFont(Font.font("Monospaced", 35));

        center.getChildren().add(poo);
        center.getChildren().add(battlepro);

        read(this.list);
        read(this.list2);

        readMonsters(this.listMonsters, this.typeMonsters);

        ArrayList<String> names = new ArrayList<>();

        for (Person a : this.list) {
            names.add(a.getName() + " " + a.getLastName());
        }

        ObservableList<String> names1
                = FXCollections.observableArrayList(
                        names
                );
        ChoiceBox<String> comboBoxList1 = new ChoiceBox<>(names1);

        ObservableList<String> names2
                = FXCollections.observableArrayList(
                        names
                );
        ChoiceBox<String> comboBoxList2 = new ChoiceBox<>(names2);

        BorderPane imageCenter = new BorderPane();

        Image image1 = new Image("file:Charizard.jpg");
        Image image2 = new Image("file:Garchomp.png");
        Image image3 = new Image("file:Staraptor.jpg");
        Image image4 = new Image("file:Blastoice.jpg");
        ImageView imageFile1 = new ImageView(image1);
        ImageView imageFile2 = new ImageView(image2);
        ImageView imageFile3 = new ImageView(image3);
        ImageView imageFile4 = new ImageView(image4);

        ArrayList<ImageView> images = new ArrayList<>();
        images.add(imageFile1);
        images.add(imageFile2);
        images.add(imageFile3);
        images.add(imageFile4);

        ChoiceBox<String> choices1 = new ChoiceBox<>();
        for (int i = 0; i < this.listMonsters.size(); i++) {
            choices1.getItems().add(this.listMonsters.get(i));
        }
        choices1.setMaxWidth(100);

        choices1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object oldSelected, Object newSelected) {
                imageCenter.setCenter(images.get((int) newSelected));

            }
        });

        center.getChildren().add(choices1);

        ChoiceBox<String> choices2 = new ChoiceBox<>();
        for (int i = 0; i < this.listMonsters.size(); i++) {
            choices2.getItems().add(this.listMonsters.get(i));
        }

        choices2.setMaxWidth(100);

        choices2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object oldSelected, Object newSelected) {
                imageCenter.setCenter(images.get((int) newSelected));
            }

        });

        center.getChildren().add(choices2);

        BorderPane layout = new BorderPane();

        VBox left = new VBox();
        VBox right = new VBox();

        Label l1 = new Label("Jugador 1");
        l1.setFont(Font.font("Monospaced", 25));
        Label l2 = new Label("Jugador 2");
        l2.setFont(Font.font("Monospaced", 25));

        left.getChildren().addAll(l1,
                new Label(""),
                comboBoxList1,
                new Label(""),
                choices1,
                new Label(),
                jugador1);

        center.getChildren().addAll(new Label(),
                imageCenter,
                new Label(),
                inicio,
                new Label(),
                RegisJugador,
                new Label(),
                puntajes);

        right.getChildren().addAll(l2,
                new Label(""),
                comboBoxList2,
                new Label(""),
                choices2,
                new Label(""),
                jugador2);

        RegisJugador.setOnAction((value) -> {
            WindowTwo w2 = new WindowTwo(window);

            BorderPane B2 = new BorderPane();

            B2.setCenter(w2.getScreen());
            Scene scene = new Scene(B2, 450, 350);
            this.window.setScene(scene);
        });

        inicio.setOnAction((value) -> {
            WindowThree w3 = new WindowThree(window);

            BorderPane B3 = new BorderPane();

            B3.setCenter(w3.screenThreeCl());

            Scene scene = new Scene(B3, 650, 550);
            this.window.setScene(scene);
        });

        puntajes.setOnAction((value) -> {
            WindowFour w4 = new WindowFour(window);

            BorderPane B4 = new BorderPane();

            B4.setCenter(w4.screenFourCl());
            Scene scene = new Scene(B4, 500, 450);
            this.window.setScene(scene);
        });

        layout.setLeft(left);
        layout.setCenter(center);
        layout.setRight(right);

        comboBoxList2.setDisable(true);
        choices2.setDisable(true);

        jugador1.setOnAction((ActionEvent e) -> {
            this.nameJ1 = comboBoxList1.getValue().toString();
            this.nameP1 = choices1.getValue();
            if (this.nameP1.equals("Charizard")) {
                this.type1 = "fire";
            }
            if (this.nameP1.equals("Garchomp")) {
                this.type1 = "earth";
            }
            if (this.nameP1.equals("Staraptor")) {
                this.type1 = "air";
            }
            if (this.nameP1.equals("Blastoise")) {
                this.type1 = "water";
            }
            comboBoxList1.setDisable(true);
            choices1.setDisable(true);
            jugador1.setDisable(true);
            comboBoxList2.setDisable(false);
            choices2.setDisable(false);
            jugador2.setDisable(false);
        });

        jugador2.setOnAction((ActionEvent e) -> {
            String nameJ2 = comboBoxList2.getValue().toString();
            this.nameP2 = choices2.getValue();

            if (this.nameP2.equals("Charizard")) {
                this.type2 = "fire";
            }
            if (this.nameP2.equals("Garchomp")) {
                this.type2 = "earth";
            }
            if (this.nameP2.equals("Staraptor")) {
                this.type2 = "air";
            }
            if (this.nameP2.equals("Blastoise")) {
                this.type2 = "water";
            }
            comboBoxList2.setDisable(true);
            choices2.setDisable(true);
            jugador2.setDisable(true);

            write(this.nameJ1, this.nameP1, this.type1, nameJ2, nameP2, type2);
            inicio.setDisable(false);
        });

        layout.setPadding(new Insets(20, 20, 20, 20));

        return layout;
    }

    public void read(ArrayList list) {
        try (Scanner scanner = new Scanner(Paths.get("data.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(" ")) {
                    break;
                }
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[5]);
                list.add(new Person(id, parts[1], parts[2], parts[3], parts[4], v));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

<<<<<<< Updated upstream
// Escritura 
=======
    //Esta funcion realiza la escritura de todos los datos de la batalla en un archivo de texto
>>>>>>> Stashed changes
    public void write(String nameJ1, String nameP1, String type1, String nameJ2, String nameP2, String type2) {
        try {
            FileWriter fstream = new FileWriter("validation.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(nameJ1 + "," + nameP1
                    + "," + type1 + ","
                    + nameJ2 + "," + nameP2
                    + "," + type2);
            out.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

//Lectura de ArrayList

    public void readMonsters(ArrayList list, ArrayList list1) {
        try (Scanner scanner = new Scanner(Paths.get("monsters.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(" ")) {
                    break;
                }
                String[] parts = line.split(",");
                String monsters = parts[0];
                String type = parts[1];
                list.add(monsters);
                list1.add(type);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
