package main.resources;

import java.util.ArrayList;
import java.util.List;

public class CatmullRomSplinesGenerator {

    public static ArrayList<List<Double>> generator(ArrayList<List<List<Double>>> bezierCurvesList, Double u) throws Exception{
        ArrayList<List<Double>> finalCoordinates = new ArrayList<>();
        try {
            for (int i = 0; i < bezierCurvesList.size(); i++) {
                ArrayList<List<Double>> coordinates = new ArrayList<>(bezierCurvesList.get(i));
                ArrayList<List<Double>> newCoordinates = CoordinateGenerator.duCoordinates(coordinates, u);

                finalCoordinates.addAll(newCoordinates.subList(1, newCoordinates.size() - 1));
                //finalCoordinates.addAll(newCoordinates);
            }
        }
        catch(IndexOutOfBoundsException e){System.out.println("Exception Thrown : " +  e);}

        finalCoordinates.add(0, bezierCurvesList.get(0).get(0));
        //finalCoordinates.add(bezierCurvesList.get(bezierCurvesList.size()-1).get(3));

        return finalCoordinates;
    }
}
