import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class Kelp extends Animal{
    Image image = new Image("kelp.png");
    //Image newImage = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageView img = new ImageView();

    public Kelp(){
        population = new SimpleStringProperty("120000");
        Label label = new Label();
        label.textProperty().bind(population);
        this.getChildren().add(new Label("\nFeet of Kelp"));
        this.getChildren().add(label);

        img.setFitHeight(80);
        img.setFitWidth(60);
        img.setImage(image);
        this.getChildren().add(img);
    }

    public Kelp(int population){this.population.set(Integer.toString(population));}

    public int getPopulation(){
        return Integer.parseInt(population.get());}
    public void setPopulation(int population){this.population.set(Integer.toString(population));}
}
