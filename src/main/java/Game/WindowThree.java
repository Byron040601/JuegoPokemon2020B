package Game;

//Byron Huaraca
//Jorge Alaba
//Bernabé Dávila 
//Karen Hurtado

import Battle.Fire;
import Battle.Air;
import Battle.Earth;
import Battle.Water;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class WindowThree {

    private Stage window;
    private int lif1;
    private int lif2;
    private int stam1;
    private int stam2;
    private int turn;
    private int defense1 = 0;
    private int defense2 = 0;
    private String type1;
    private String type2;
    private String namePlayer1 = "";
    private String namePlayer2 = "";
    private String nameCharacter1;
    private String nameCharacter2;
    private int ratack1;
    private int rfinal1;
    private int rdefense1;
    private int rcure1;
    private int ratack2;
    private int rfinal2;
    private int rdefense2;
    private int rcure2;
    private String atack1;
    private String final1;
    private String def1;
    private String cur1;
    private String atack2;
    private String final2;
    private String def2;
    private String cur2;
    private int vida1;
    private int estamina1;
    private int vida2;
    private int estamina2;
    private ArrayList<String> airMoves;
    private ArrayList<String> fireMoves;
    private ArrayList<String> earthMoves;
    private ArrayList<String> waterMoves;
    private String textMoves;
    private String auxMoves;
    private int victories;
    private String nameImage1;
    private String nameImage2;
//Pantalla en donde se reflejara la batalla 
    public WindowThree(Stage window) {
        this.window = window;
        this.airMoves = new ArrayList<>();
        this.fireMoves = new ArrayList<>();
        this.earthMoves = new ArrayList<>();
        this.waterMoves = new ArrayList<>();
        this.textMoves = "";
        this.nameImage1 = "";
        this.nameImage2 = "";
    }

    public Parent screenThreeCl() {
        //Declarando el valor de los ataques de los diferentes elementos
        Fire fire = new Fire(110, 230);
        Air air = new Air(140, 200);
        Earth earth = new Earth(95, 156);
        Water water = new Water(100, 210);

        //Añadiendo movimientos
        this.airMoves.add("Picotazo");
        this.airMoves.add("Pajaro Osado");
        this.airMoves.add("Danza Pluma");
        this.airMoves.add("Respiro");

        this.fireMoves.add("Ascuas");
        this.fireMoves.add("Anillo Igneo");
        this.fireMoves.add("Amago");
        this.fireMoves.add("Descanso");

        this.earthMoves.add("Bofeton Lodo");
        this.earthMoves.add("Terremoto");
        this.earthMoves.add("Paz Mental");
        this.earthMoves.add("Pulso Cura");

        this.waterMoves.add("Rayo Burbuja");
        this.waterMoves.add("Hidrobomba");
        this.waterMoves.add("Maquinacion");
        this.waterMoves.add("Recuperacion");

        //Asignando que peleadores seran elegidos
        read();
        //Extraccion de las valores que necesitaremos para la pelea
        if (type1.equals("air")) {
            this.vida1 = air.getLife();
            this.estamina1 = air.getStamina();
            this.lif1 = air.getLife();
            this.stam1 = air.getStamina();
            this.ratack1 = air.simpleAttack(estamina1);
            this.rfinal1 = air.finalAttack(estamina1);
            this.rdefense1 = air.defense(estamina1);
            this.rcure1 = air.cure(estamina1);

            this.nameImage1 = "file:Staraptor.jpg";
        }

        if (type1.equals("water")) {
            this.vida1 = water.getLife();
            this.estamina1 = water.getStamina();
            this.lif1 = water.getLife();
            this.stam1 = water.getStamina();
            this.ratack1 = water.simpleAttack(estamina1);
            this.rfinal1 = water.finalAttack(estamina1);
            this.rdefense1 = water.defense(estamina1);
            this.rcure1 = water.cure(estamina1);

            this.nameImage1 = "file:Blastoice.jpg";
        }

        if (type1.equals("fire")) {
            this.vida1 = fire.getLife();
            this.estamina1 = fire.getStamina();
            this.lif1 = fire.getLife();
            this.stam1 = fire.getStamina();
            this.ratack1 = fire.simpleAttack(estamina1);
            this.rfinal1 = fire.finalAttack(estamina1);
            this.rdefense1 = fire.defense(estamina1);
            this.rcure1 = fire.cure(estamina1);

            this.nameImage1 = "file:Charizard.jpg";
        }

        if (type1.equals("earth")) {
            this.vida1 = earth.getLife();
            this.estamina1 = earth.getStamina();
            this.lif1 = earth.getLife();
            this.stam1 = earth.getStamina();
            this.ratack1 = earth.simpleAttack(estamina1);
            this.rfinal1 = earth.finalAttack(estamina1);
            this.rdefense1 = earth.defense(estamina1);
            this.rcure1 = earth.cure(estamina1);

            this.nameImage1 = "file:Garchomp.png";
        }

        if (type2.equals("fire")) {
            this.vida2 = fire.getLife();
            this.estamina2 = fire.getStamina();
            this.lif2 = fire.getLife();
            this.stam2 = fire.getStamina();
            this.ratack2 = fire.simpleAttack(estamina2);
            this.rfinal2 = fire.finalAttack(estamina2);
            this.rcure2 = fire.cure(estamina2);
            this.rdefense2 = fire.defense(estamina2);

            this.nameImage2 = "file:Charizard.jpg";
        }

        if (type2.equals("water")) {
            this.vida2 = water.getLife();
            this.estamina2 = water.getStamina();
            this.lif2 = water.getLife();
            this.stam2 = water.getStamina();
            this.ratack2 = water.simpleAttack(estamina2);
            this.rfinal2 = water.finalAttack(estamina2);
            this.rcure2 = water.cure(estamina2);
            this.rdefense2 = water.defense(estamina2);

            this.nameImage2 = "file:Blastoice.jpg";
        }

        if (type2.equals("air")) {
            this.vida2 = air.getLife();
            this.estamina2 = air.getStamina();
            this.lif2 = air.getLife();
            this.stam2 = air.getStamina();
            this.ratack2 = air.simpleAttack(estamina2);
            this.rfinal2 = air.finalAttack(estamina2);
            this.rcure2 = air.cure(estamina2);
            this.rdefense2 = air.defense(estamina2);

            this.nameImage2 = "file:Staraptor.jpg";
        }

        if (type2.equals("earth")) {
            this.vida2 = earth.getLife();
            this.estamina2 = earth.getStamina();
            this.lif2 = earth.getLife();
            this.stam2 = earth.getStamina();
            this.ratack2 = earth.simpleAttack(estamina2);
            this.rfinal2 = earth.finalAttack(estamina2);
            this.rcure2 = earth.cure(estamina2);
            this.rdefense2 = earth.defense(estamina2);

            this.nameImage2 = "file:Garchomp.png";
        }

        //Asignacion de que jugador empezara primero y 
        this.turn = 1;

        //Eleccion del panel y el fondo de la pantalla
        StackPane stackPane = new StackPane();
        ImageView backgroundView = new ImageView();
        Image backgroudImage = new Image("file:fondo.jpg");

        backgroundView.setImage(backgroudImage);

        stackPane.getChildren().add(backgroundView);

        //Creacion de los botones para los dos jugadores
        Button atack = new Button("Ataque");
        atack.setMaxWidth(100);
        Button finalAtack = new Button("Ataque Final");
        finalAtack.setMaxWidth(100);
        Button defense = new Button("Defensa");
        defense.setMaxWidth(100);
        Button cure = new Button("Curar");
        cure.setMaxWidth(100);

        Button atackTwo = new Button("Ataque");
        atackTwo.setMaxWidth(100);
        Button finalAtackTwo = new Button("Ataque Final");
        finalAtackTwo.setMaxWidth(100);
        Button defenseTwo = new Button("Defensa");
        defenseTwo.setMaxWidth(100);
        Button cureTwo = new Button("Curar");
        cureTwo.setMaxWidth(100);

        //Eleccion de las imagenes que se usaran en la pantalla
        Image image1 = new Image("file:vs.jpg");
        Image image2 = new Image(this.nameImage1);
        Image image3 = new Image(this.nameImage2);
        ImageView imageFile1 = new ImageView(image1);
        ImageView imageFile2 = new ImageView(image2);
        ImageView imageFile3 = new ImageView(image3);

        //Barras de vida y estamina de los jugadores
        TextField life1 = new TextField();
        life1.setFont(Font.font("Monospaced", 12));
        life1.setText(vida1 + "/" + vida1);
        life1.setEditable(false);
        life1.setMaxWidth(80);

        TextField stamina1 = new TextField();
        stamina1.setFont(Font.font("Monospaced", 12));
        stamina1.setText(estamina1 + "/" + estamina1);
        stamina1.setEditable(false);
        stamina1.setMaxWidth(80);

        TextField life2 = new TextField();
        life2.setFont(Font.font("Monospaced", 12));
        life2.setText(vida2 + "/" + vida2);
        life2.setEditable(false);
        life2.setMaxWidth(80);

        TextField stamina2 = new TextField();
        stamina2.setFont(Font.font("Monospaced", 12));
        stamina2.setText(estamina2 + "/" + estamina2);
        stamina2.setEditable(false);
        stamina2.setMaxWidth(80);

        //Creacion de las diferentes etiquetas que tendran la pantalla 
        Label health = new Label("Vida:");
        Label Estamina = new Label("Estamina:");

        health.setFont(Font.font("Monospaced", 12));
        Estamina.setFont(Font.font("Monospaced", 12));

        Label pok1 = new Label(this.nameCharacter1);
        pok1.setFont(Font.font("Monospaced", 12));

        Label pok2 = new Label(this.nameCharacter2);
        pok2.setFont(Font.font("Monospaced", 12));

        GridPane labels = new GridPane();
        GridPane texts = new GridPane();

        //Asignacion del espacio en donde se colocaran las barras de estamina y vida con sus etiquetas
        for (int i = 0; i < 2; i++) {
            Label name = new Label();
            name.setFont(Font.font("Monospaced", 12));

            if (i == 0) {
                name.setText("Vida:");
                texts.addRow(i, life1);
            }
            if (i == 1) {
                name.setText("Estamina:");
                texts.addRow(i, stamina1);
            }

            labels.addRow(i, name);
            labels.setVgap(16);
            texts.setVgap(5);
            texts.setHgap(5);
        }

        GridPane grid1 = new GridPane();
        grid1.addRow(0, labels, texts);

        GridPane labels2 = new GridPane();
        GridPane texts2 = new GridPane();

        for (int i = 0; i < 2; i++) {
            Label name = new Label();
            name.setFont(Font.font("Monospaced", 12));

            if (i == 0) {
                name.setText("Vida:");
                texts2.addRow(i, life2);
            }
            if (i == 1) {
                name.setText("Estamina:");
                texts2.addRow(i, stamina2);
            }

            labels2.addRow(i, name);
            labels2.setVgap(16);
            texts2.setVgap(5);
            texts2.setHgap(5);
        }

        //Colocando los diferentes componenetes en la ventana
        GridPane grid2 = new GridPane();
        grid2.addRow(0, labels2, texts2);

        GridPane g1 = new GridPane();
        g1.addRow(1, imageFile2);
        g1.addRow(2, pok1);
        g1.addRow(3, grid1);
        g1.addRow(4, new Label(this.namePlayer1));
        g1.setVgap(5);
        g1.setHgap(5);

        GridPane g2 = new GridPane();
        g2.addRow(0, grid2);
        g2.addRow(1, pok2);
        g2.addRow(2, imageFile3);
        g2.addRow(3, new Label(this.namePlayer2));
        g2.setVgap(5);
        g2.setHgap(5);

        GridPane panel1 = new GridPane();
        panel1.addRow(0, g1, imageFile1, g2);

        BorderPane b = new BorderPane();

        GridPane button1 = new GridPane();
        button1.addRow(0, atack, finalAtack);
        button1.addRow(1, defense, cure);
        button1.setVgap(5);
        button1.setHgap(5);

        GridPane button2 = new GridPane();
        button2.addRow(0, atackTwo, finalAtackTwo);
        button2.addRow(1, defenseTwo, cureTwo);
        button2.setVgap(5);
        button2.setHgap(5);

        b.setLeft(button1);
        b.setRight(button2);
        b.setPadding(new Insets(10, 10, 10, 10));

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefSize(200, 100);

        GridPane panel2 = new GridPane();
        panel2.addRow(0, panel1);
        panel2.addRow(1, b);
        panel2.addRow(2, textArea);

        BorderPane layout = new BorderPane();

        layout.setCenter(panel2);

        layout.setPadding(new Insets(10, 10, 10, 10));

        //Habilitando al jugador numero 1.
        validate(atackTwo, finalAtackTwo, defenseTwo,
                cureTwo, atack, finalAtack, defense, cure);

        //Funcionamiento de los botones, ataque, ataque final, defensa y curacion del jugador 1
        atack.setOnAction((ActionEvent e) -> {
            if (type1.equals("air")) {
                this.atack1 = air.atack(estamina2, this.lif2, this.stam2, this.stam1, this.defense2);
                this.auxMoves = this.airMoves.get(0);
            }
            if (type1.equals("water")) {
                this.atack1 = water.atack(estamina2, this.lif2, this.stam2, this.stam1, this.defense2);
                this.auxMoves = this.waterMoves.get(0);
            }
            if (type1.equals("fire")) {
                this.atack1 = fire.atack(estamina2, this.lif2, this.stam2, this.stam1, this.defense2);
                this.auxMoves = this.fireMoves.get(0);
            }
            if (type1.equals("earth")) {
                this.atack1 = earth.atack(estamina2, this.lif2, this.stam2, this.stam1, this.defense2);
                this.auxMoves = this.earthMoves.get(0);
            }
            if ((this.stam1 != 0) && (this.stam1 >= ratack1)) {
                String[] parts = atack1.split(",");
                int es = Integer.parseInt(parts[0]);
                int l = Integer.parseInt(parts[1]);
                int es1 = Integer.parseInt(parts[2]);
                int def = Integer.parseInt(parts[3]);
                this.stam2 = es;
                this.lif2 = l;
                this.stam1 = es1;
                this.defense2 = def;
                if (this.lif2 < 0) {
                    this.lif2 = 0;
                }
                life1.setText(this.lif1 + "/" + vida1);
                stamina1.setText(this.stam1 + "/" + estamina1);
                life2.setText(l + "/" + vida2);
                stamina2.setText(this.stam2 + "/" + estamina2);
                this.turn = 2;
                validate(atackTwo, finalAtackTwo, defenseTwo,
                        cureTwo, atack, finalAtack, defense, cure);
                this.textMoves = this.textMoves + "Jugador " + (this.turn - 1) + ": Uso " + this.auxMoves + ".\n";
                textArea.setText(this.textMoves);
            }
            if (this.lif2 == 0) {
                JOptionPane.showMessageDialog(null, "Gana el jugador " + (this.turn - 1));

                readVictories(this.victories);
                this.victories += 1;

                WindowFour w4 = new WindowFour(window);

                BorderPane B4 = new BorderPane();
                B4.setCenter(w4.screenFourCl());

                Scene scene = new Scene(B4, 500, 550);
                this.window.setScene(scene);
            }
        });

        finalAtack.setOnAction((ActionEvent e) -> {
            if (type1.equals("air")) {
                this.final1 = air.atackF(estamina2, this.lif2, this.stam2, this.stam1, this.defense2);
                this.auxMoves = this.airMoves.get(1);
            }
            if (type1.equals("water")) {
                this.final1 = water.atackF(estamina2, this.lif2, this.stam2, this.stam1, this.defense2);
                this.auxMoves = this.waterMoves.get(1);
            }
            if (type1.equals("fire")) {
                this.final1 = fire.atackF(estamina2, this.lif2, this.stam2, this.stam1, this.defense2);
                this.auxMoves = this.fireMoves.get(1);
            }
            if (type1.equals("earth")) {
                this.final1 = earth.atackF(estamina2, this.lif2, this.stam2, this.stam1, this.defense2);
                this.auxMoves = this.earthMoves.get(1);
            }
            if ((this.stam1 != 0) && (this.stam1 >= rfinal1)) {
                String[] parts = final1.split(",");
                int es = Integer.parseInt(parts[0]);
                int l = Integer.parseInt(parts[1]);
                int es1 = Integer.parseInt(parts[2]);
                int def = Integer.parseInt(parts[3]);
                this.stam2 = es;
                this.lif2 = l;
                this.stam1 = es1;
                this.defense2 = def;
                if (this.lif2 < 0) {
                    this.lif2 = 0;
                }
                life1.setText(this.lif1 + "/" + vida1);
                stamina1.setText(this.stam1 + "/" + estamina1);
                life2.setText(l + "/" + vida2);
                stamina2.setText(this.stam2 + "/" + estamina2);
                this.turn = 2;
                validate(atackTwo, finalAtackTwo, defenseTwo,
                        cureTwo, atack, finalAtack, defense, cure);
                this.textMoves = this.textMoves + "Jugador " + (this.turn - 1) + ": Uso " + this.auxMoves + ".\n";
                textArea.setText(this.textMoves);

            }
            if (this.lif2 == 0) {
                JOptionPane.showMessageDialog(null, "Gana el jugador " + (this.turn - 1));

                readVictories(this.victories);
                this.victories += 1;

                WindowFour w4 = new WindowFour(window);

                BorderPane B4 = new BorderPane();
                B4.setCenter(w4.screenFourCl());

                Scene scene = new Scene(B4, 500, 550);
                this.window.setScene(scene);
            }

        });

        defense.setOnAction((ActionEvent e) -> {
            if (type1.equals("air")) {
                this.def1 = air.Defense(estamina2, this.stam1, this.stam2);
                this.auxMoves = this.airMoves.get(2);
            }
            if (type1.equals("water")) {
                this.def1 = water.Defense(estamina2, this.stam1, this.stam2);
                this.auxMoves = this.waterMoves.get(2);
            }
            if (type1.equals("fire")) {
                this.def1 = fire.Defense(estamina2, this.stam1, this.stam2);
                this.auxMoves = this.fireMoves.get(2);
            }
            if (type1.equals("earth")) {
                this.def1 = earth.Defense(estamina2, this.stam1, this.stam2);
                this.auxMoves = this.earthMoves.get(2);
            }
            if ((this.stam1 != 0) && (this.stam1 >= rdefense1)) {
                this.defense1 = 3;
                String[] parts = def1.split(",");
                int es = Integer.parseInt(parts[0]);
                int es1 = Integer.parseInt(parts[1]);
                this.stam2 = es;
                this.stam1 = es1;
                stamina1.setText(this.stam1 + "/" + estamina1);
                stamina2.setText(this.stam2 + "/" + estamina2);
                this.turn = 2;
                validate(atackTwo, finalAtackTwo, defenseTwo,
                        cureTwo, atack, finalAtack, defense, cure);
                this.textMoves = this.textMoves + "Jugador " + (this.turn - 1) + ": Uso " + this.auxMoves + ".\n";
                textArea.setText(this.textMoves);
            }
        });

        cure.setOnAction((ActionEvent e) -> {
            if (type1.equals("air")) {
                this.cur1 = air.cures(estamina2, this.stam1, this.stam2, this.lif1, this.defense2);
                this.auxMoves = this.airMoves.get(3);
            }
            if (type1.equals("water")) {
                this.cur1 = water.cures(estamina2, this.stam1, this.stam2, this.lif1, this.defense2);
                this.auxMoves = this.waterMoves.get(3);
            }
            if (type1.equals("fire")) {
                this.cur1 = fire.cures(estamina2, this.stam1, this.stam2, this.lif1, this.defense2);
                this.auxMoves = this.fireMoves.get(3);
            }
            if (type1.equals("earth")) {
                this.cur1 = earth.cures(estamina2, this.stam1, this.stam2, this.lif1, this.defense2);
                this.auxMoves = this.earthMoves.get(3);
            }
            if ((this.stam1 != 0) && (this.stam1 > rcure1)) {
                String[] parts = cur1.split(",");
                int es = Integer.parseInt(parts[0]);
                int es1 = Integer.parseInt(parts[1]);
                int l = Integer.parseInt(parts[2]);
                int def = Integer.parseInt(parts[3]);
                this.stam2 = es;
                this.lif1 = l;
                this.stam1 = es1;
                this.defense2 = def;
                life1.setText(this.lif1 + "/" + vida1);
                stamina1.setText(this.stam1 + "/" + estamina1);
                stamina2.setText(this.stam2 + "/" + estamina2);
                this.turn = 2;
                validate(atackTwo, finalAtackTwo, defenseTwo,
                        cureTwo, atack, finalAtack, defense, cure);
                this.textMoves = this.textMoves + "Jugador " + (this.turn - 1) + ": Uso " + this.auxMoves + ".\n";
                textArea.setText(this.textMoves);
            }

        });

        //Funcionamiento de los botones, ataque, ataque final, defensa y curacion del jugador 2
        atackTwo.setOnAction((ActionEvent e) -> {
            if (type2.equals("fire")) {
                this.atack2 = fire.atack(estamina1, this.lif1, this.stam1, this.stam2, this.defense1);
                this.auxMoves = this.fireMoves.get(0);
            }
            if (type2.equals("water")) {
                this.atack2 = water.atack(estamina1, this.lif1, this.stam1, this.stam2, this.defense1);
                this.auxMoves = this.waterMoves.get(0);
            }
            if (type2.equals("air")) {
                this.atack2 = air.atack(estamina1, this.lif1, this.stam1, this.stam2, this.defense1);
                this.auxMoves = this.airMoves.get(0);
            }
            if (type2.equals("earth")) {
                this.atack2 = earth.atack(estamina1, this.lif1, this.stam1, this.stam2, this.defense1);
                this.auxMoves = this.earthMoves.get(0);
            }
            if ((this.stam2 != 0) && (this.stam2 >= ratack2)) {
                String[] parts = atack2.split(",");
                int es = Integer.parseInt(parts[0]);
                int l = Integer.parseInt(parts[1]);
                int es1 = Integer.parseInt(parts[2]);
                int def = Integer.parseInt(parts[3]);
                this.stam1 = es;
                this.lif1 = l;
                this.stam2 = es1;
                this.defense1 = def;
                if (this.lif1 < 0) {
                    this.lif1 = 0;
                }
                life2.setText(this.lif2 + "/" + vida2);
                stamina2.setText(this.stam2 + "/" + estamina2);
                life1.setText(l + "/" + vida1);
                stamina1.setText(this.stam1 + "/" + estamina1);
                this.turn = 1;
                validate(atackTwo, finalAtackTwo, defenseTwo,
                        cureTwo, atack, finalAtack, defense, cure);
                this.textMoves = this.textMoves + "Jugador " + (this.turn + 1) + ": Uso " + this.auxMoves + ".\n";
                textArea.setText(this.textMoves);
            }
            if (this.lif1 == 0) {
                JOptionPane.showMessageDialog(null, "Gana el jugador " + (this.turn + 1));

                WindowFour w4 = new WindowFour(window);

                BorderPane B4 = new BorderPane();
                B4.setCenter(w4.screenFourCl());

                Scene scene = new Scene(B4, 500, 550);
                this.window.setScene(scene);
            }
        });
        finalAtackTwo.setOnAction((ActionEvent e) -> {
            if (type2.equals("fire")) {
                this.final2 = fire.atackF(estamina1, this.lif1, this.stam1, this.stam2, this.defense1);
                this.auxMoves = this.fireMoves.get(1);
            }
            if (type2.equals("water")) {
                this.final2 = water.atackF(estamina1, this.lif1, this.stam1, this.stam2, this.defense1);
                this.auxMoves = this.waterMoves.get(1);
            }
            if (type2.equals("air")) {
                this.final2 = air.atackF(estamina1, this.lif1, this.stam1, this.stam2, this.defense1);
                this.auxMoves = this.airMoves.get(1);
            }
            if (type2.equals("earth")) {
                this.final2 = earth.atackF(estamina1, this.lif1, this.stam1, this.stam2, this.defense1);
                this.auxMoves = this.earthMoves.get(1);
            }
            if ((this.stam2 != 0) && (this.stam2 >= rfinal2)) {
                String[] parts = final2.split(",");
                int es = Integer.parseInt(parts[0]);
                int l = Integer.parseInt(parts[1]);
                int es1 = Integer.parseInt(parts[2]);
                int def = Integer.parseInt(parts[3]);
                this.stam1 = es;
                this.lif1 = l;
                this.stam2 = es1;
                this.defense1 = def;
                if (this.lif1 < 0) {
                    this.lif1 = 0;
                }
                life2.setText(this.lif2 + "/" + vida2);
                stamina2.setText(this.stam2 + "/" + estamina2);
                life1.setText(this.lif1 + "/" + vida1);
                stamina1.setText(this.stam1 + "/" + estamina1);
                this.turn = 1;
                validate(atackTwo, finalAtackTwo, defenseTwo,
                        cureTwo, atack, finalAtack, defense, cure);
                this.textMoves = this.textMoves + "Jugador " + (this.turn + 1) + ": Uso " + this.auxMoves + ".\n";
                textArea.setText(this.textMoves);
            }
            if (this.lif1 == 0) {
                JOptionPane.showMessageDialog(null, "Gana el jugador " + (this.turn + 1));

                WindowFour w4 = new WindowFour(window);

                BorderPane B4 = new BorderPane();
                B4.setCenter(w4.screenFourCl());

                Scene scene = new Scene(B4, 500, 550);
                this.window.setScene(scene);
            }
        });
        defenseTwo.setOnAction((ActionEvent e) -> {
            if (type2.equals("fire")) {
                this.def2 = fire.Defense(estamina1, this.stam2, this.stam1);
                this.auxMoves = this.fireMoves.get(2);
            }
            if (type2.equals("water")) {
                this.def2 = water.Defense(estamina1, this.stam2, this.stam1);
                this.auxMoves = this.waterMoves.get(2);
            }
            if (type2.equals("air")) {
                this.def2 = air.Defense(estamina1, this.stam2, this.stam1);
                this.auxMoves = this.airMoves.get(2);
            }
            if (type2.equals("earth")) {
                this.def2 = earth.Defense(estamina1, this.stam2, this.stam1);
                this.auxMoves = this.earthMoves.get(2);
            }
            if ((this.stam2 != 0) && (this.stam2 >= rdefense2)) {
                this.defense2 = 3;
                String[] parts = def2.split(",");
                int es = Integer.parseInt(parts[0]);
                int es1 = Integer.parseInt(parts[1]);
                this.stam2 = es1;
                this.stam1 = es;
                stamina2.setText(this.stam2 + "/" + estamina2);
                stamina1.setText(this.stam1 + "/" + estamina1);
                this.turn = 1;
                validate(atackTwo, finalAtackTwo, defenseTwo,
                        cureTwo, atack, finalAtack, defense, cure);
                this.textMoves = this.textMoves + "Jugador " + (this.turn + 1) + ": Uso " + this.auxMoves + ".\n";
                textArea.setText(this.textMoves);
            }
        });
        cureTwo.setOnAction((ActionEvent e) -> {
            if (type2.equals("fire")) {
                this.cur2 = fire.cures(estamina1, this.stam2, this.stam1, this.lif2, this.defense1);
                this.auxMoves = this.fireMoves.get(3);
            }

            if (type2.equals("water")) {
                this.cur2 = water.cures(estamina1, this.stam2, this.stam1, this.lif2, this.defense1);
                this.auxMoves = this.waterMoves.get(3);
            }

            if (type2.equals("air")) {
                this.cur2 = air.cures(estamina1, this.stam2, this.stam1, this.lif2, this.defense1);
                this.auxMoves = this.airMoves.get(3);
            }

            if (type2.equals("earth")) {
                this.cur2 = earth.cures(estamina1, this.stam2, this.stam1, this.lif2, this.defense1);
                this.auxMoves = this.earthMoves.get(3);
            }

            if ((this.stam2 != 0) && (this.stam2 >= this.rcure2)) {
                String[] parts = cur2.split(",");
                int es = Integer.parseInt(parts[0]);
                int es1 = Integer.parseInt(parts[1]);
                int l = Integer.parseInt(parts[2]);
                int def = Integer.parseInt(parts[3]);
                this.stam1 = es;
                this.lif2 = l;
                this.stam2 = es1;
                this.defense1 = def;
                life2.setText(this.lif2 + "/" + vida2);
                stamina2.setText(this.stam2 + "/" + estamina2);
                stamina1.setText(this.stam1 + "/" + estamina1);
                this.turn = 1;
                validate(atackTwo, finalAtackTwo, defenseTwo,
                        cureTwo, atack, finalAtack, defense, cure);
                this.textMoves = this.textMoves + "Jugador " + (this.turn + 1) + ": Uso " + this.auxMoves + ".\n";
                textArea.setText(this.textMoves);
            }
        });

        stackPane.getChildren().add(layout);
        //retorno del panel que se visualizara en la pantalla 3
        return stackPane;
    }

    //Asignando los turnos
    public void validate(Button a2, Button f2, Button d2, Button c2, Button a1, Button f1, Button d1, Button c1) {
        if (this.turn == 1) {
            a1.setDisable(false);
            f1.setDisable(false);
            d1.setDisable(false);
            c1.setDisable(false);
            a2.setDisable(true);
            f2.setDisable(true);
            d2.setDisable(true);
            c2.setDisable(true);
        }
        if (this.turn == 2) {
            a1.setDisable(true);
            f1.setDisable(true);
            d1.setDisable(true);
            c1.setDisable(true);
            a2.setDisable(false);
            f2.setDisable(false);
            d2.setDisable(false);
            c2.setDisable(false);
        }
    }

    public void read() {
        try (Scanner scanner = new Scanner(Paths.get("validation.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("  ")) {
                    break;
                }
                String[] parts = line.split(",");
                String namePlayer1 = parts[0];
                String character1 = parts[1];
                String type1 = parts[2];

                String namePlayer2 = parts[3];
                String character2 = parts[4];
                String type2 = parts[5];
                this.namePlayer1 = namePlayer1;
                this.namePlayer2 = namePlayer2;
                this.nameCharacter1 = character1;
                this.nameCharacter2 = character2;
                this.type1 = type1;
                this.type2 = type2;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readVictories(int victo) {
        try (Scanner scanner = new Scanner(Paths.get("data.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(" ")) {
                    break;
                }
                String[] parts = line.split(",");
                int victories = Integer.parseInt(parts[5]);
                victo = victories;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void write(Person p) {
        try {
            FileWriter fstream = new FileWriter("data.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("\n");
            out.write(p.getId() + "," + p.getName()
                    + "," + p.getLastName() + ","
                    + p.getIdentification() + ","
                    + p.getUser() + "," + p.getVictories());
            out.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
