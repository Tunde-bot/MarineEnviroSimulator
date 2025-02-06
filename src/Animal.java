import javafx.beans.property.StringProperty;
import javafx.scene.layout.Pane;

//import javax.swing.*;

public abstract class Animal extends Pane {
    protected boolean extinct;
    protected StringProperty population;
    public abstract int getPopulation();
    public abstract void setPopulation(int population);
}
