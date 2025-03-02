import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Popup;

import java.util.Objects;

//import javax.swing.*;

public abstract class Animal extends AnchorPane {
    protected Image image = new Image(this.getClass().getSimpleName().toLowerCase()+".png");
    protected ImageView img = new ImageView();
    protected int birthrate;
    protected int deathrate;
    protected int daysTillBirth;
    protected int daysTillDeath;
    protected boolean extinct;
    protected StringProperty population;
    protected int tempPopulation;

    public int getBirthrate() {
        return birthrate;
    }

    public int getDeathrate() {
        return deathrate;
    }

    public int getDaysTillBirth() {
        return daysTillBirth;
    }

    public int getDaysTillDeath() {
        return daysTillDeath;
    }

    public boolean getExtinct() {
        return extinct;
    }

    public int getPopulation(){
        return Integer.parseInt(population.get());
    }

    public int getTempPopulation(){
        return tempPopulation;
    }

    public void setBirthrate(int newBirthrate) {
        birthrate = newBirthrate;
    }

    public void setDeathrate(int newDeathrate) {
        deathrate = newDeathrate;
    }

    public void setDaysTillBirth(int newDaysTillBirth) {
        daysTillBirth = newDaysTillBirth;
    }

    public void setDaysTillDeath(int newDaysTillDeath) {
        daysTillDeath = newDaysTillDeath;
    }

    public void setExtinct(boolean dead) {
        extinct = dead;
    }

    public void setPopulation(int population){
        this.population.set(Integer.toString(population));
    }

    public void setTempPopulation(int tempPopulation){
        this.tempPopulation = tempPopulation;
    }

    public Animal(String SUnit, String SPopulation){
        this.setMinSize(150,150);
        population = new SimpleStringProperty(SPopulation);
        Label populationLabel = new Label();
        populationLabel.textProperty().bind(population);
        Label unit = new Label(SUnit);

        Popup populationSetter = new Popup();
        TextField newPopulation = new TextField();
        populationSetter.getContent().add(newPopulation);

        Button change = new Button("Change");
        Animal animal = this;//because using "this" in EventHandler below gives EventHandler
        change.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent event) {
                if (!populationSetter.isShowing())
                    populationSetter.show(animal,animal.localToScreen(50,0).getX(),animal.localToScreen(0,20).getY());

                else {
                    populationSetter.hide();
                    if(!Objects.equals(newPopulation.getText(), "")) {
                        population.set(newPopulation.getText());
                    }
                }


            }
        });
        this.setTopAnchor(change,2.0);
        this.setRightAnchor(change,2.0);

        VBox vb = new VBox();
        vb.setPadding(new Insets(0, 10, 10, 10));
        vb.setSpacing(5);
        vb.getChildren().addAll(populationLabel,unit);

        img.setFitHeight(80);
        img.setFitWidth(80);
        img.setImage(image);

        this.getChildren().addAll(vb, img, change);

        this.setTopAnchor(vb, 2.0);
        this.setBottomAnchor(img, 2.0);

        Stop[] gradientColors = new Stop[] { new Stop(0, Color.LIGHTBLUE), new Stop(1, Color.GREEN)};
        LinearGradient backGradient = new LinearGradient(0, 0, 100, 100, false, CycleMethod.REFLECT, gradientColors);
        this.setBackground(new Background(new BackgroundFill(backGradient, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
