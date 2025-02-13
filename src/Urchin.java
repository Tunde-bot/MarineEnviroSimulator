import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class Urchin extends Animal{
    Image image = new Image("urchin.png");
    //Image newImage = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageView img = new ImageView();

    public Urchin(){
        population = new SimpleStringProperty("435600");
        Label label = new Label();
        label.textProperty().bind(population);
        this.getChildren().add(new Label("\nUrchin"));
        this.getChildren().add(label);

        img.setFitHeight(80);
        img.setFitWidth(60);
        img.setImage(image);
        this.getChildren().add(img);
    }

    public Urchin(int population){this.population.set(Integer.toString(population));}

    public int getPopulation(){
        return Integer.parseInt(population.get());}
    public void setPopulation(int population){this.population.set(Integer.toString(population));}
}
