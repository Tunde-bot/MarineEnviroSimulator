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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.util.function.UnaryOperator;

public class Main extends Application{
    static Animal kelp = new Kelp();
    static Animal otter = new Otter();
    static Animal urchin = new Urchin();
    static Button run = new Button("Run");
    static TextField days = new TextField();
    int screenHeight = 1000;
    int screenWidth = 1000;
    final int YEARDAYS =365;
    private int day = 0;
    
    @Override
    public void start(Stage stage){
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(screenHeight/10,screenWidth/10,screenHeight/10,screenWidth/10));


        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) {
                return change;
            }
            return null;
        };

        days.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, integerFilter));

        layout.add(days,0,4,2,1);
        layout.add(run,0,5);
        layout.add(kelp,0,1);
        layout.add(otter, 0,2);
        layout.add(urchin, 0,3);

        run.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent event) {
                runDays(Integer.parseInt(days.getText()));
            }
        });


        Scene scene = new Scene(layout, 1000,1000);

        Stop[] gradientColors = new Stop[] { new Stop(0, Color.LIGHTBLUE), new Stop(1, Color.LIGHTGREEN)};
        LinearGradient backGradient = new LinearGradient(500, 0, 500, 1000, false, CycleMethod.REFLECT, gradientColors);
        layout.setBackground(new Background(new BackgroundFill(backGradient, CornerRadii.EMPTY, Insets.EMPTY)));

        stage.setTitle("Marine Environment");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){launch(args);}

    private void runDays(int days) {
        int otterDeathRate;
        int daysTillOtterDeath;
        int otterBirthRate;
        int daysTillOtterBirth;
        int kelpBirthRate ;
        int kelpDeathRate;
        int newOtterPopulation;
        int newKelpPopulation;
        int newUrchinPopulation;
        daysTillOtterDeath = (YEARDAYS*16)/(otter.getPopulation());
        daysTillOtterBirth = (16*2*YEARDAYS)/(otter.getPopulation());
        int destination = day+days;
        while (day < destination) {
           otterDeathRate = (otter.getPopulation())/(YEARDAYS*16);
           otterBirthRate = (otter.getPopulation()*14)/(16*2*YEARDAYS);

           kelpBirthRate = (2*kelp.getPopulation()*50)/YEARDAYS;
           kelpDeathRate = (kelp.getPopulation())/365;

           newOtterPopulation = otter.getPopulation()+otterBirthRate-otterDeathRate;
           if(((otterBirthRate==0)&&(daysTillOtterBirth==0))){
                newOtterPopulation = otter.getPopulation()+1;
                daysTillOtterBirth = (YEARDAYS*16)/(otter.getPopulation());}
           if((otterDeathRate==0)&&(daysTillOtterDeath==0)){
                newOtterPopulation = otter.getPopulation()-1;
                daysTillOtterDeath = (YEARDAYS*16)/(otter.getPopulation());}

           newUrchinPopulation = urchin.getPopulation()-(otter.getPopulation()*50);

           newKelpPopulation = kelp.getPopulation()+kelpBirthRate-kelpDeathRate-(urchin.getPopulation()/16);

           kelp.setPopulation(newKelpPopulation);
           urchin.setPopulation(newUrchinPopulation);
           otter.setPopulation(newOtterPopulation);
            day++;
            daysTillOtterDeath--;
            daysTillOtterBirth--;
        }

    }
}