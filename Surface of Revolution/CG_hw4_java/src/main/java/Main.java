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

        for (Double i = ((Math.PI/2)-dv); i > ((-1*Math.PI)/2); i-=dv ){
            List<List<Double>> tmp = new ArrayList<>();
            for (Double j= (Math.PI); j>=(-1*Math.PI); j-=du){
                tmp.add(Arrays.asList(j,i));
            }
            uv.add(tmp);
        }

        return uv;
    }

    public static void main(String[] args) {
        String s1_val = args[0];
        String s2_val = args[1];
        String Aval = args[2];
        String Bval = args[3];
        String Cval = args[4];
        String u_num = args[5];
        String v_num = args[6];
        String shading = args[7];
        String fileName = args[8];

        try {

            Double du = (2 * Math.PI)/(Double.parseDouble(u_num));
            Double dv = (Math.PI)/(Double.parseDouble(v_num));

            Double s1 = Double.parseDouble(s1_val);
            Double s2 = Double.parseDouble(s2_val);
            Double A  = Double.parseDouble(Aval);
            Double B = Double.parseDouble(Bval);
            Double C = Double.parseDouble(Cval);

            ArrayList<List<List<Double>>> uvs = uvGenerator(du, dv);
            ArrayList<List<List<Double>>> newCoordinates = new CoordinateGenerator().controlPoints(uvs, s1, s2, A, B, C);
            List<List<Integer>> triangleCoordinates = TriangleCoordinates.generate(newCoordinates);

            newCoordinates.get(0).add(0, Arrays.asList(0.0, 0.0, 1.0));
            newCoordinates.get(newCoordinates.size()-1).add(Arrays.asList(0.0, 0.0, -1.0));

            if (shading.equalsIgnoreCase("S")){
                ArrayList<List<List<Double>>> normalCoordinates = new NormalGenerator().controlPoints(uvs, s1, s2, A, B, C);
                normalCoordinates.get(0).add(0, Arrays.asList(0.0, 0.0, 1.0));
                normalCoordinates.get(normalCoordinates.size()-1).add(Arrays.asList(0.0, 0.0, -1.0));

                FileWriter.writeFile(fileName, newCoordinates, triangleCoordinates, normalCoordinates);
            }
            else{
                FileWriter.writeFile(fileName, newCoordinates, triangleCoordinates);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
