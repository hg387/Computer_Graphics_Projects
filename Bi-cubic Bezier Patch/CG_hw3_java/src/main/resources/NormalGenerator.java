package main.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalGenerator {
    public List<Double> calculateCoefficient(Double binomial, Integer degree, int i, Double u) throws Exception {
        Double first = ((Math.pow(binomial, degree - i)) * (Math.pow(u, i-1)) * i);
        if (first.isNaN()){first = 0.0;}
        Double second = ((Math.pow(binomial, degree-i-1))*(Math.pow(u, i))*(degree-i));
        if (second.isNaN()){second = 0.0;}
        Double x =  (Factorial.calculateCombination(degree, i))* (first - second);
        Double y = Factorial.calculateCombination(degree, i) * (first - second);
        Double z = Factorial.calculateCombination(degree, i) * (first - second);
        return Arrays.asList(x, y, z);
    }

    public List<Double> crossProduct(List<Double> first, List<Double> second){
        Double x1 = first.get(0);
        Double y1 = first.get(1);
        Double z1 = first.get(2);

        Double x2 = second.get(0);
        Double y2 = second.get(1);
        Double z2 = second.get(2);

        Double newX = (z2*y1) - (z1*y2);
        Double newY = (z1*x2) - (z2*x1);
        Double newZ = (x1*y2) - (x2*y1);
        return Arrays.asList(newX, newY, newZ);
    }

    public List<Double> calculateCoords1(ArrayList<List<List<Double>>> coordinates, Double u, Double v) throws Exception{
        Integer degree = coordinates.get(0).size() - 1;
        Double x = 0.0;
        Double y = 0.0;
        Double z = 0.0;

        for (int i = 0; i <= degree; i++){
            List<Double> firstCoefficient = calculate(1-u, degree, i,u);
            for (int j=0; j <= degree; j++) {
                List<Double> secondCoefficient = calculateCoefficient(1-v, degree, j,v);
                List<Double> coordinate = coordinates.get(i).get(j);
                x += firstCoefficient.get(0) * secondCoefficient.get(0) * coordinate.get(0);
                y += firstCoefficient.get(1) * secondCoefficient.get(1) * coordinate.get(1);
                z += firstCoefficient.get(2) * secondCoefficient.get(2) * coordinate.get(2);
            }
        }
        return Arrays.asList(x, y, z);
    }

    public List<Double> calculateCoords2(ArrayList<List<List<Double>>> coordinates, Double u, Double v) throws Exception{
        Integer degree = coordinates.get(0).size() - 1;
        Double x = 0.0;
        Double y = 0.0;
        Double z = 0.0;

        for (int i = 0; i <= degree; i++){
            List<Double> firstCoefficient = calculateCoefficient(1-u, degree, i,u);
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

    public ArrayList<List<List<Double>>> calculateNormal(ArrayList<List<List<Double>>> coordinates, ArrayList<List<List<Double>>> uvs) throws Exception{
        ArrayList<List<List<Double>>> newCoordinates = new ArrayList<>();

        for (int i=0; i< uvs.size();i++){
            List<List<Double>> counter = new ArrayList<>();
            for (int j=0; j< uvs.get(0).size(); j++){
                Double u = uvs.get(i).get(j).get(0);
                Double v = uvs.get(i).get(j).get(1);
                List<Double> coords1 = calculateCoords1(coordinates, u,v);
                List<Double> coords2 = calculateCoords2(coordinates, u, v);
                List<Double> coords = crossProduct(coords2, coords1);
                counter.add(coords);
            }
            newCoordinates.add(counter);
        }

        return newCoordinates;
    }

}
