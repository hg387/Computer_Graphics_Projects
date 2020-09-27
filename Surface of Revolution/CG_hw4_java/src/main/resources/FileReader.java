package main.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {
    ArrayList<List<Double>> coordinates = new ArrayList<>();

    public  ArrayList<List<List<Double>>> fileReader(String fileName) throws IOException{
        ArrayList<List<Double>> coordinates = new ArrayList<>();
        ArrayList<List<List<Double>>> matrix = new ArrayList<>();

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))){
            String inValue;
            while ((inValue = reader.readLine()) != null){
                String[] array = inValue.split(" ");
                Double[] coordinate = Arrays.stream(array).map(Double::valueOf).toArray(Double[]::new);
                coordinates.add(Arrays.asList(coordinate));
            }
        }
        catch(IOException e){
            System.out.println("Exception Thrown : "  + e);
        }

        for (int i=0; i< coordinates.size(); i+=4){
            matrix.add(Arrays.asList(coordinates.get(i), coordinates.get(i+1), coordinates.get(i+2), coordinates.get(i+3)));
        }
        this.coordinates = coordinates;
        return matrix;
    }

    public ArrayList<List<Double>> getCoordinates() {
        return coordinates;
    }
}
