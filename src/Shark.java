import javax.swing.*;
import java.awt.*;

public class Shark extends Animal{
    Image image = Toolkit.getDefaultToolkit().getImage("shark.png");
    Image newImage = image.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(newImage, 375, 50, this);
    }

    public Shark(){this.population = 10;
        JLabel label = new JLabel("Shark");
        add(label);
    }

    public Shark(int population){this.population = population;
        JLabel label = new JLabel("Shark");
        add(label);
    }

    public int getPopulation(){return population;}
    public void setPopulation(int population){this.population = population;}
}
