package Game;

//Byron Huaraca
//Jorge Alaba
//Bernabé Dávila 

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class WindowTwo {

    private Stage window;
    private Stage warning;
    private Person p;
    private ArrayList<Person> list;
    private int numId;
    private ArrayList<String> listIds;

    public WindowTwo(Stage window) {
        this.window = window;
        this.list = new ArrayList<>();
        this.listIds = new ArrayList<>();
    }

    public Parent getScreen() {
        BorderPane layout = new BorderPane();

        read(this.list);

        for (Person a : this.list) {
            this.numId = a.getId();
            this.listIds.add(a.getIdentification());
        }

        ObservableList<Person> data
                = FXCollections.observableArrayList(
                        this.list
                );

        ObservableList<String> Ids
                = FXCollections.observableArrayList(
                        this.listIds
                );

        ComboBox c1 = new ComboBox(Ids);
        c1.setMaxWidth(300);

        TableView table = new TableView();
        table.setEditable(true);

        TableColumn oneCol = new TableColumn("id:");
        oneCol.setMaxWidth(36);
        oneCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("id"));

        TableColumn twoCol = new TableColumn("Nombre:");
        twoCol.setMaxWidth(68);
        twoCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("name"));

        TableColumn threeCol = new TableColumn("Apellido:");
        threeCol.setMaxWidth(77);
        threeCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));

        TableColumn fourCol = new TableColumn("Cedula:");
        fourCol.setMaxWidth(66);
        fourCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("identification"));

        TableColumn fiveCol = new TableColumn("Usuario:");
        fiveCol.setMaxWidth(71);
        fiveCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("user"));

        TableColumn sixCol = new TableColumn("Victorias:");
        sixCol.setMaxWidth(70);
        sixCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("victories"));

        table.setItems(data);
        table.getColumns().addAll(oneCol, twoCol, threeCol, fourCol, fiveCol, sixCol);

        GridPane labels = new GridPane();
        GridPane texts = new GridPane();

        TextField textName = new TextField();
        textName.setFont(Font.font("Monospaced", 12));
        textName.setPromptText("Nombre");
        textName.setMaxWidth(200);

        TextField textLast = new TextField();
        textLast.setFont(Font.font("Monospaced", 12));
        textLast.setPromptText("Apellido");
        textLast.setMaxWidth(200);

        TextField textIden = new TextField();
        textIden.setFont(Font.font("Monospaced", 12));
        textIden.setPromptText("Cedula");
        textIden.setMaxWidth(200);

        TextField textUser = new TextField();
        textUser.setFont(Font.font("Monospaced", 12));
        textUser.setPromptText("Usuario");
        textUser.setMaxWidth(200);

        for (int i = 0; i < 4; i++) {
            Label l1 = new Label();
            l1.setFont(Font.font("Monospaced", 12));
            l1.setMaxWidth(100);

            if (i == 0) {
                l1.setText("Nombre:");
                texts.addRow(i, textName);
            }
            if (i == 1) {
                l1.setText("Apellido:");
                texts.addRow(i, textLast);
            }
            if (i == 2) {
                l1.setText("Cedula:");
                texts.addRow(i, textIden);
            }
            if (i == 3) {
                l1.setText("Usuario:");
                texts.addRow(i, textUser);
            }
            labels.addRow(i, l1);
            labels.setVgap(14);
            texts.setVgap(5);
            texts.setHgap(5);
        }

        GridPane g1 = new GridPane();
        g1.addRow(1, labels, texts);
        g1.setVgap(5);
        g1.setHgap(5);

        GridPane g2 = new GridPane();
        g2.addColumn(0, c1, g1);
        g2.setVgap(5);
        g2.setHgap(5);

        Button create = new Button();
        create.setFont(Font.font("Monospaced", 15));
        create.setText("Crear");

        GridPane g3 = new GridPane();
        g3.addColumn(19, create);
        g3.setVgap(5);
        g3.setHgap(5);

        GridPane g4 = new GridPane();
        g4.addRow(0, g2, g3);
        g4.setVgap(5);
        g4.setHgap(5);

        GridPane g5 = new GridPane();

        Button player = new Button();
        player.setFont(Font.font("Monospaced", 15));
        player.setText("Ir a seleccionar\nPersonajes");

        g5.addColumn(2, player);
        g5.setAlignment(Pos.CENTER);
        g5.setVgap(5);
        g5.setHgap(5);

        GridPane g6 = new GridPane();
        g6.addColumn(0, g4, table, g5);
        g6.setAlignment(Pos.CENTER);
        g6.setVgap(5);
        g6.setHgap(5);

        create.setOnAction((ActionEvent e) -> {
            read(this.list);

            for (Person a : this.list) {
                this.numId = a.getId();
                this.listIds.add(a.getIdentification());
            }

            boolean search = serched(this.listIds, textIden.getText());

            if (search == true) {
                this.numId++;
                data.add(new Person(this.numId,
                        textName.getText(),
                        textLast.getText(),
                        textIden.getText(),
                        textUser.getText(),
                        0));
                write(new Person(this.numId, textName.getText(), textLast.getText(),
                        textIden.getText(), textUser.getText(), 0));

            }

            textName.clear();
            textLast.clear();
            textIden.clear();
            textUser.clear();

            if (search == true) {
                JOptionPane.showMessageDialog(null, "Usuario Ingresado con exito");
            } else {
                JOptionPane.showMessageDialog(null, " Este usuario ya existe");
            }

        });

        player.setOnAction((value) -> {
            WindowOne w1 = new WindowOne(window);

            BorderPane B1 = new BorderPane();
            B1.setCenter(w1.Pantalla());

            Scene scene = new Scene(B1, 550, 500);
            this.window.setScene(scene);
        });

        layout.setCenter(g6);

        layout.setPadding(new Insets(30, 30, 30, 30));

        return layout;
    }
//Lectura en archivo data.txt
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

    public void write(Person p) {
        try {
            FileWriter fstream = new FileWriter("data.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            read(this.list);
            if (this.list.get(0).getId() == 1) {
                out.write("\n");
                out.write(p.getId() + "," + p.getName()
                        + "," + p.getLastName() + ","
                        + p.getIdentification() + ","
                        + p.getUser() + "," + p.getVictories());
                out.close();
            } else {

                out.write(p.getId() + "," + p.getName()
                        + "," + p.getLastName() + ","
                        + p.getIdentification() + ","
                        + p.getUser() + "," + p.getVictories());
                out.close();
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public boolean serched(ArrayList list, String Ids) {
        for (int i = 0; i < list.size(); i++) {
            if (Ids.equals(list.get(i))) {
                return false;

            }
        }
        return true;
    }
}
