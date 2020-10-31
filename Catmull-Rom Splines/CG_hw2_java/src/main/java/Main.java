package main.java;

import main.resources.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    String fileName = args[0];
	    String n = args[1];
	    String r = args[2];
	    String t = args[3];
        String out = args[4];

        try {
            ArrayList<List<Double>> allCoordinates = FileReader.fileReader(fileName);
            ArrayList<List<Double>> tangents = new ArrayList<>(allCoordinates.subList(0,2));
            ArrayList<List<Double>> coordinates = new ArrayList<>(allCoordinates.subList(2,allCoordinates.size()));

            Double u = 1/Double.parseDouble(n);
            Double tension = Double.parseDouble(t);
            TangentGenerator.Generator(tangents, coordinates, tension);

            /*
                testing remaining
            */
            ArrayList<List<Double>> P2AndP3List = P2andP3Generator.generator(tangents, coordinates);
            ArrayList<List<List<Double>>> bezierCurvesList = P2andP3Generator.alignment(P2AndP3List, coordinates);
            ArrayList<List<Double>> newCoordinates = CatmullRomSplinesGenerator.generator(bezierCurvesList, u);
            FileWriter.writeFile(out, newCoordinates, coordinates, r);
        }
        catch (IOException e){
            System.out.println("Exception Thrown : " +  e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
