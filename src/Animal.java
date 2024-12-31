import javax.swing.*;

public abstract class Animal extends JPanel{
    protected boolean extinct;
    protected int population;
    public abstract int getPopulation();
    public abstract void setPopulation(int population);
}
