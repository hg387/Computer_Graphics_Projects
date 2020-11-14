package main.java;

import main.resources.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static ArrayList<List<List<Double>>>  uvGenerator(Double du, Double dv){
        ArrayList<List<List<Double>>> uv = new ArrayList<>();
        int counter = 0;

        for (Double i=0.0; i<=1.0; i+=du ){
            List<List<Double>> tmp = new ArrayList<>();
            for (Double j=0.0; j<=1.0; j+=dv){
                tmp.add(Arrays.asList(i,j));
            }
            uv.add(tmp);
        }

        return uv;
    }

    public static void main(String[] args) {
	    String fileName = args[0];
	    String n1 = args[1];
        String n2 = args[2];
        String shading = args[3];
	    String r = args[4];
        String out = args[5];

        try {
            FileReader fileReader = new FileReader();
            ArrayList<List<List<Double>>> coordinates = fileReader.fileReader(fileName);
            ArrayList<List<Double>> coordinatesList = fileReader.getCoordinates();

            Double du = 1/(Double.parseDouble(n1)-1);
            Double dv = 1/(Double.parseDouble(n2)-1);

            ArrayList<List<List<Double>>> uvs = uvGenerator(du, dv);
            ArrayList<List<List<Double>>> newCoordinates = new CoordinateGenerator().controlPoints(coordinates, uvs);
            List<List<Integer>> triangleCoordinates = TriangleCoordinates.generate(newCoordinates);

            if (shading.equalsIgnoreCase("S")){
                ArrayList<List<List<Double>>> normalCoordinates = new NormalGenerator().calculateNormal(coordinates, uvs);
                FileWriter.writeFile(out, newCoordinates, coordinatesList, triangleCoordinates, normalCoordinates, r);
            }
            else{
                FileWriter.writeFile(out, newCoordinates, coordinatesList, triangleCoordinates, r);
            }
        }
        catch (IOException e){
            System.out.println("Exception Thrown : " +  e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
