//import java.awt.*;
//import javax.swing.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.util.function.UnaryOperator;

public class Main extends Application{
    static String ecosystem = "OceanicLocation";
    static Animal fish = new Fish();
    static Animal shark = new Shark();
    static Button run = new Button("Run");
    static TextField days = new TextField();
    int screenHeight = 1000;
    int screenWidth = 1000;

    @Override
    public void start(Stage stage){
        GridPane layout = new GridPane(3,3);
        layout.setPadding(new Insets(screenHeight/10,screenWidth/10,screenHeight/10,screenWidth/10));

        layout.add(fish,0,2);
        layout.add(shark,0,1);
        layout.add(run,0,3);
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) {
                return change;
            }
            return null;
        };

        days.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, integerFilter));
        layout.add(days,0,4);
        run.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent event) {
                runDays(Integer.parseInt(days.getText()));
            }
        });


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
           fish.setPopulation(fish.getPopulation()-(shark.getPopulation()*10));
           day++;
           if(day%10 == 0){
               shark.setPopulation(shark.getPopulation()-1);
           }
        }
        System.out.println(fish.getPopulation()+"\n"+shark.getPopulation());
    }


}