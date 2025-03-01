import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

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

    public Animal(String SUnit, String SPopulation){
        this.setMinSize(100,100);
        population = new SimpleStringProperty(SPopulation);
        Label populationLabel = new Label();
        populationLabel.textProperty().bind(population);
        Label unit = new Label(SUnit);
        VBox vb = new VBox();
        vb.setPadding(new Insets(0, 10, 10, 10));
        vb.setSpacing(5);
        vb.getChildren().addAll(populationLabel,unit);

        img.setFitHeight(60);
        img.setFitWidth(60);
        img.setImage(image);

        this.getChildren().addAll(vb, img);

        this.setTopAnchor(vb, 2.0);
        this.setBottomAnchor(img, 2.0);

        Stop[] gradientColors = new Stop[] { new Stop(0, Color.LIGHTBLUE), new Stop(1, Color.GREEN)};
        LinearGradient backGradient = new LinearGradient(0, 0, 100, 100, false, CycleMethod.REFLECT, gradientColors);
        this.setBackground(new Background(new BackgroundFill(backGradient, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
