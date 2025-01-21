//import java.awt.*;
//import javax.swing.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
    static String ecosystem = "OceanicLocation";
    static Animal fish = new Fish();
    static Animal shark = new Shark();
    int screenHeight = 1000;
    int screenWidth = 1000;

    @Override
    public void start(Stage stage){
        GridPane layout = new GridPane(3,3);
        layout.add(fish,0,2);
        layout.add(shark,0,1);
        layout.setPadding(new Insets(screenHeight/10,screenWidth/10,screenHeight/10,screenWidth/10));

        Scene scene = new Scene(layout, 1000,1000);

        stage.setTitle("Marine Environment");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
        /**JFrame frame = new JFrame(ecosystem);
        GridLayout layout = new GridLayout();
        frame.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 1000);
        frame.add(fish);
        frame.add(shark);

        frame.setVisible(true);
         **/
    }

    private void runDays(int days) {
        int day = 0;
        while (day < days) {
           //fish.setPopulation(fish.getPopulation()-(shark.getPopulation()*10));
           day++;
        }
    }


}