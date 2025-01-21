import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;



public class Shark extends Animal{
    Image image = new Image("shark.png");
    //Image newImage = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageView img = new ImageView();

    public Shark(){
        GridPane layout = new GridPane();
        Label label = new Label("Shark");
        this.getChildren().add(label);

        img.setFitHeight(180);
        img.setFitWidth(160);
        img.setImage(image);
        this.getChildren().add(img);

        /**
        this.population = 10;
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel picLabel = new JLabel(new ImageIcon(newImage));
        gbc.gridx = 0;
        gbc.gridy = 2;
        layout.setConstraints(picLabel, gbc);
        add(picLabel);

        this.population = 10;
        JLabel label = new JLabel("Shark\nPopulation: " + getPopulation());
        gbc.gridx = 0;
        gbc.gridy = 0;
        layout.setConstraints(label, gbc);
        add(label);
         **/
    }

    public Shark(int population){this.population = population;
        //JLabel label = new JLabel("Shark");
        //add(label);
    }

    public int getPopulation(){return population;}
    public void setPopulation(int population){this.population = population;}
}
