import java.awt.*;
import javax.swing.*;


public class Main{
    static String ecosystem = "OceanicLocation";
    static Animal fish = new Fish();
    static Animal shark = new Shark();

    public static void main(String[] args){
        JFrame frame = new JFrame(ecosystem);
        GridLayout layout = new GridLayout();
        frame.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 1000);
        frame.add(fish);
        frame.add(shark);



        frame.setVisible(true);
    }

    private void runDays(int days) {
        int day = 0;
        while (day < days) {
           fish.setPopulation(fish.getPopulation()-(shark.getPopulation()*10));
           day++;
        }
    }
}