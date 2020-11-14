package main.resources;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoordinateGenerator {

    public List<Double> calculateCoords(ArrayList<List<List<Double>>> coordinates, Double u, Double v) throws Exception{
        Integer degree = coordinates.get(0).size() - 1;
        Double x = 0.0;
        Double y = 0.0;
        Double z = 0.0;

        for (int i = 0; i <= degree; i++){
            List<Double> firstCoefficient = calculate(1-u, degree, i,u);
            for (int j=0; j <= degree; j++) {
                List<Double> secondCoefficient = calculate(1-v, degree, j,v);
                List<Double> coordinate = coordinates.get(i).get(j);
                x += firstCoefficient.get(0) * secondCoefficient.get(0) * coordinate.get(0);
                y += firstCoefficient.get(1) * secondCoefficient.get(1) * coordinate.get(1);
                z += firstCoefficient.get(2) * secondCoefficient.get(2) * coordinate.get(2);
            }
        }
        return Arrays.asList(x, y, z);
    }

    public List<Double> calculate(Double binomial, Integer degree, int i, Double u) throws Exception {
        Double x =  Factorial.calculateCombination(degree, i) * (Math.pow(binomial, degree - i)) * (Math.pow(u, i));
        Double y = Factorial.calculateCombination(degree, i) * (Math.pow(binomial, degree - i)) * (Math.pow(u, i));
        Double z = Factorial.calculateCombination(degree, i)* (Math.pow(binomial, degree - i)) * (Math.pow(u, i));
        return Arrays.asList(x, y, z);
    }

    public  ArrayList<List<List<Double>>> controlPoints(ArrayList<List<List<Double>>> coordinates, ArrayList<List<List<Double>>> uvs) throws Exception{
        ArrayList<List<List<Double>>> newCoordinates = new ArrayList<>();

        for (int i=0; i< uvs.size();i++){
            List<List<Double>> counter = new ArrayList<>();
            for (int j=0; j< uvs.get(0).size(); j++){
                Double u = uvs.get(i).get(j).get(0);
                Double v = uvs.get(i).get(j).get(1);
                List<Double> coords = calculateCoords(coordinates, u,v);
                counter.add(coords);
            }
            newCoordinates.add(counter);
        }

        return newCoordinates;
    }
}
