package main.resources;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoordinateGenerator {

    public static List<Double> calculateCoords(ArrayList<List<Double>> coordinates, Double u) throws Exception{
        Integer degree = coordinates.size() - 1;
        Double x = 0.0;
        Double y = 0.0;
        Double z = 0.0;

        for (int i = 0; i <= degree; i++){
            Double oldX = coordinates.get(i).get(0);
            Double oldY = coordinates.get(i).get(1);
            Double oldZ = coordinates.get(i).get(2);

            Double binomial = 1 - u;

            x += oldX * (Factorial.calculateCombination(degree, i)) * (Math.pow(binomial,degree - i)) * (Math.pow(u, i)) ;
            y += oldY * (Factorial.calculateCombination(degree, i)) * (Math.pow(binomial,degree - i)) * (Math.pow(u, i)) ;
            z += oldZ * (Factorial.calculateCombination(degree, i)) * (Math.pow(binomial,degree - i)) * (Math.pow(u, i)) ;
        }
        return Arrays.asList(x, y, z);
    }

    public static ArrayList<List<Double>> duCoordinates(ArrayList<List<Double>> coordinates, Double u) throws Exception{
        ArrayList<List<Double>> newCoordinates = new ArrayList<>();
        ArrayList<Double> du = new ArrayList<>();
        Double counter = 0.0;

        while (counter <= 1.0000000000000100){
            newCoordinates.add(calculateCoords(coordinates, counter));
            du.add(counter);
            counter += u;
        }

        return newCoordinates;
    }
}
