import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class Fish extends Animal{
    Image image = new Image("fish.png");
    //Image newImage = image.getScaledInstance(80, 90, Image.SCALE_DEFAULT);
    ImageView img = new ImageView();
    public Fish(){
        population = new SimpleStringProperty("100");
        Text text = new Text("Fish\nPopulation: "+ population);
        text.textProperty().bind(population);
        this.getChildren().add(new Text("\nFish"));
        this.getChildren().add(text);

        img.setFitHeight(80);
        img.setFitWidth(60);
        img.setImage(image);
        this.getChildren().add(img);
    }

    public Fish(int population){this.population.set(Integer.toString(population));
        Label label = new Label("Fish");
    }

    public int getPopulation(){return Integer.parseInt(population.get());}
    public void setPopulation(int population) {this.population.set(Integer.toString(population));}
}
