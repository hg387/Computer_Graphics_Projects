package main.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2andP3Generator {
    public static  ArrayList<List<Double>> generator (ArrayList<List<Double>> tangents, ArrayList<List<Double>> coordinates){
        ArrayList<List<Double>> P2AndP3List = new ArrayList<>();
        try {
            for (int i = 0; i < coordinates.size() - 1; i++) {
                List<Double> P1 = coordinates.get(i);
                List<Double> P4 = coordinates.get(i + 1);

                List<Double> t1 = tangents.get(i);
                List<Double> t2 = tangents.get(i + 1);

                Double P2X = P1.get(0) + (t1.get(0) / 3.0);
                Double P2Y = P1.get(1) + (t1.get(1) / 3.0);
                Double P2Z = P1.get(2) + (t1.get(2) / 3.0);
                List<Double> P2 = Arrays.asList(P2X, P2Y, P2Z);

                Double P3X = P4.get(0) - (t2.get(0) / 3.0);
                Double P3Y = P4.get(1) - (t2.get(1) / 3.0);
                Double P3Z = P4.get(2) - (t2.get(2) / 3.0);
                List<Double> P3 = Arrays.asList(P3X, P3Y, P3Z);

                P2AndP3List.add(P2);
                P2AndP3List.add(P3);
            }
        }
        catch(IndexOutOfBoundsException e){System.out.println("Exception Thrown : " +  e);}

        return P2AndP3List;
    }

    public static ArrayList<List<List<Double>>> alignment(ArrayList<List<Double>> P2AndP3List, ArrayList<List<Double>> coordinates){
        ArrayList<List<List<Double>>> bezierCurvesList = new ArrayList<>();
        try {
            for (int i = 0; i < coordinates.size() - 1; i++) {
                List<Double> P1 = coordinates.get(i);
                List<Double> P4 = coordinates.get(i + 1);

                List<Double> P2 = P2AndP3List.get(2 * i);
                List<Double> P3 = P2AndP3List.get((2 * i) + 1);

                bezierCurvesList.add(Arrays.asList(P1, P2, P3, P4));
            }
        }
        catch (IndexOutOfBoundsException e){System.out.println("Exception Thrown : " +  e);}

        return bezierCurvesList;
    }
}
