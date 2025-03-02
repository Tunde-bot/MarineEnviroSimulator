import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import java.util.function.UnaryOperator;

public class Main extends Application{
    static Animal kelp = new Kelp();
    static Animal otter = new Otter();
    static Animal urchin = new Urchin();
    static Animal[] animals = {kelp,otter,urchin};
    static Button run = new Button("Run");
    static TextField days = new TextField();
    static Label title = new Label("Kelp Forest");
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

        title.setFont(Font.font ("Verdana", 50));
        title.setTextFill(Color.GREEN);
        layout.add(title,0,0,2,1);
        layout.add(new Text("Days passed:"),0,2);
        layout.add(days,0,3,3,1);
        layout.add(run,0,4);
        layout.add(kelp,0,1);
        layout.add(otter, 1,1);
        layout.add(urchin, 2,1);

        run.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent event) {
                runDays(Integer.parseInt(days.getText()));
            }
        });


        Scene scene = new Scene(layout);

        Stop[] gradientColors = new Stop[] { new Stop(0, Color.LIGHTBLUE), new Stop(1, Color.LIGHTGREEN)};
        LinearGradient backGradient = new LinearGradient(500, 0, 500, 1000, false, CycleMethod.REFLECT, gradientColors);
        layout.setBackground(new Background(new BackgroundFill(backGradient, CornerRadii.EMPTY, Insets.EMPTY)));

        stage.setTitle("Marine Environment");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){launch(args);}

    private void runDays(int days) {
        int destination = day+days;
        while (day < destination) {
           otter.setDeathrate((otter.getPopulation())/(YEARDAYS*16));
           otter.setBirthrate((otter.getPopulation()*14)/(16*2*YEARDAYS));

           kelp.setDeathrate((kelp.getPopulation())/YEARDAYS);
           kelp.setBirthrate((2*kelp.getPopulation())/(YEARDAYS));

           otter.setTempPopulation(otter.getPopulation()+otter.getBirthrate()-otter.getDeathrate());
           if((otter.getDeathrate()==0)&&(otter.getDaysTillDeath()==0)){
               System.out.println("Otter death on day "+ day);
               otter.setTempPopulation(otter.getPopulation()-1);
               otter.setDaysTillDeath((YEARDAYS*16)/(otter.getPopulation()));
           }

           if(((otter.getBirthrate()==0)&&(otter.getDaysTillBirth()==0))){
               System.out.println("Otter born on day "+ day);
               otter.setTempPopulation(otter.getPopulation()+1);
               otter.setDaysTillBirth((YEARDAYS*16*2)/(otter.getPopulation()*14));
           }

           urchin.setTempPopulation(((20*urchin.getPopulation())/YEARDAYS)+urchin.getPopulation()-(otter.getPopulation()*50));
           kelp.setTempPopulation(kelp.getPopulation()+kelp.getBirthrate()-kelp.getDeathrate()-(urchin.getPopulation()/16));

           for(int x =0;x<animals.length;x++) {
               if (!animals[x].getExtinct()) {
                   animals[x].setPopulation(animals[x].getTempPopulation());
               }

               if((animals[x].getPopulation()<0)&&(!animals[x].getExtinct())){
                   animals[x].setExtinct(true);
                   System.out.println(animals[x]+"went extinct on day "+ day);
               }
           }
            day++;
            otter.setDaysTillDeath(otter.getDaysTillDeath()-1);
            otter.setDaysTillBirth(otter.getDaysTillBirth()-1);
        }

    }
}