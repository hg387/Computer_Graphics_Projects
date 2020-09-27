package main.resources;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CoordinateGenerator {
    public Double sgn(Double w){
        if (w > 0){return 1.0;}
        else if (w == 0){return 0.0;}
        else if (w < 0){return -1.0;}

        return null;
    }

    public Double cosineFunc(Double w, Double m){
        Double cosValue = Math.cos(w);
        Double c = Math.pow((Math.abs(cosValue)), m);
        return ((this.sgn(cosValue))*c);
    }

    public Double sinFunc(Double w, Double m){
        Double sinValue = Math.sin(w);
        Double c = Math.pow((Math.abs(sinValue)), m);
        return ((this.sgn(sinValue))*c);
    }

    public List<Double> calculateCoords(Double u, Double v, Double s1, Double s2, Double A, Double B, Double C){
        Double x = ((-1*A)*(this.cosineFunc(v, s1))*(this.cosineFunc(u, s2)));
        Double y = (B*(this.cosineFunc(v, s1))*(this.sinFunc(u, s2)));
        Double z = (C*(this.sinFunc(v, s1)));
        return Arrays.asList(x, y, z);
    }


    public  ArrayList<List<List<Double>>> controlPoints(ArrayList<List<List<Double>>> uvs, Double s1, Double s2, Double A, Double B, Double C) throws Exception{
        ArrayList<List<List<Double>>> newCoordinates = new ArrayList<>();

        for (int i=0; i< uvs.size();i++){
            List<List<Double>> counter = new ArrayList<>();
            for (int j=0; j< uvs.get(0).size(); j++){
                Double u = uvs.get(i).get(j).get(0);
                Double v = uvs.get(i).get(j).get(1);
                List<Double> coords = this.calculateCoords(u, v, s1, s2, A, B, C);
                counter.add(coords);
            }
            newCoordinates.add(counter);
        }

        return newCoordinates;
    }
}
