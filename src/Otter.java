import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class Otter extends Animal{
    Image image = new Image("otter.png");
    //Image newImage = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageView img = new ImageView();

    public Otter(){
        population = new SimpleStringProperty("12");
        Label label = new Label();
        label.textProperty().bind(population);
        this.getChildren().add(new Label("\nOtter"));
        this.getChildren().add(label);

        img.setFitHeight(80);
        img.setFitWidth(60);
        img.setImage(image);
        this.getChildren().add(img);
    }

    public Otter(int population){this.population.set(Integer.toString(population));}

    public int getPopulation(){
        return Integer.parseInt(population.get());}
    public void setPopulation(int population){this.population.set(Integer.toString(population));}
}
