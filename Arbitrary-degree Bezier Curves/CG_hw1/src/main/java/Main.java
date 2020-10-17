package main.java;

import main.resources.CoordinateGenerator;
import main.resources.Factorial;
import main.resources.FileReader;
import main.resources.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    String fileName = args[0];
	    String n = args[1];
	    String r = args[2];
        String out = args[3];

        try {
            ArrayList<List<Double>> coordinates = FileReader.fileReader(fileName);
            Double u = 1/Double.parseDouble(n);
            ArrayList<List<Double>> newCoordinates = CoordinateGenerator.duCoordinates(coordinates,u);
            FileWriter.writeFile(out, newCoordinates, coordinates, r);
        }
        catch (IOException e){
            System.out.println("Exception Thrown : " +  e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
