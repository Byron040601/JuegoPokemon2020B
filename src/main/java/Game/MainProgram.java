package Game;

//Byron Huaraca
//Jorge Alaba
//Bernabé Dávila 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainProgram extends Application {

    @Override
    public void start(Stage window) {

        WindowOne windowOne = new WindowOne(window);
        WindowTwo windowTwo = new WindowTwo(window);
        WindowThree windowThree = new WindowThree(window);
        WindowFour windowFour = new WindowFour(window);

        BorderPane layout1 = new BorderPane();
        BorderPane layout4 = new BorderPane();

        layout1.setCenter(windowOne.Pantalla());
        //layout4.setCenter(windowFour.screenFourCl());

        StackPane stackPane = new StackPane();
        ImageView backgroundView = new ImageView();
        Image backgroudImage = new Image("file:fondo.jpg");

        backgroundView.setImage(backgroudImage);

        stackPane.getChildren().add(backgroundView);
        stackPane.getChildren().add(layout1);

        Scene scene = new Scene(stackPane, 550, 500, Color.BLACK);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(MainProgram.class);
    }
}
