import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;



public class Fish extends Animal{
    Image image = new Image("fish.png");
    //Image newImage = image.getScaledInstance(80, 90, Image.SCALE_DEFAULT);
    ImageView img = new ImageView();

    public Fish(){
        GridPane layout = new GridPane();
        Label label = new Label("Fish");
        this.getChildren().add(label);

        img.setFitHeight(180);
        img.setFitWidth(160);
        img.setImage(image);
        this.getChildren().add(img);
        /**
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
         **/

    }

    public Fish(int population){this.population = population;
        Label label = new Label("Fish");
    }

    public int getPopulation(){return population;}
    public void setPopulation(int population) {this.population = population;}
}
