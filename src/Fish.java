import javax.swing.*;
import java.awt.*;

public class Fish extends Animal{
    Image image = Toolkit.getDefaultToolkit().getImage("fish.png");
    Image newImage = image.getScaledInstance(80, 90, Image.SCALE_DEFAULT);

    public Fish(){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel picLabel = new JLabel(new ImageIcon(newImage));
        gbc.gridx = 0;
        gbc.gridy = 2;
        layout.setConstraints(picLabel, gbc);
        add(picLabel);

        this.population = 10000;
        JLabel label = new JLabel("Fish\nPopulation: " + getPopulation());
        gbc.gridx = 0;
        gbc.gridy = 0;
        layout.setConstraints(label, gbc);
        add(label);

    }

    public Fish(int population){this.population = population;
        JLabel label = new JLabel("Fish");
        add(label);
    }

    public int getPopulation(){return population;}
    public void setPopulation(int population) {this.population = population;}
}
