import java.awt.*;
import java.util.Scanner;
import java.util.Random;
import javax.swing.*;


public class Main{
    ;


    Scanner input = new Scanner(System.in);
    static String ecosystem = "OceanicLocation";
    static Fish fish = new Fish();
    static Shark shark = new Shark();

    public static void main(String[] args){
        JFrame frame = new JFrame(ecosystem);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 1000);


        frame.add(fish);
        frame.add(shark);


        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout. PAGE_AXIS));
        frame.setVisible(true);
        //runDays(input.nextInt());
    }

    private void runDays(int days) {
        int day = 0;
        while (day < days) {
           fish.setPopulation(fish.getPopulation()-(shark.getPopulation()*10));
        }
    }
}