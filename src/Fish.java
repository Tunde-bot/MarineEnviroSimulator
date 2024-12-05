import javax.swing.*;
import java.awt.*;

public class Fish extends Animal{
    Image image = Toolkit.getDefaultToolkit().getImage("fish.png");
    Image newImage = image.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(newImage, 375, 100, this);
    }

    public Fish(){
        this.population = 10000;
        JLabel label = new JLabel("Fish");
        add(label);


    }

    public Fish(int population){this.population = population;
        JLabel label = new JLabel("Fish");
        add(label);
    }

    public int getPopulation(){return population;}
    public void setPopulation(int population) {this.population = population;}
}
