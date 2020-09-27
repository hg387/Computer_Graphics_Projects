package main.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalGenerator extends CoordinateGenerator {
    @Override
    public List<Double> calculateCoords(Double u, Double v, Double s1, Double s2, Double A, Double B, Double C){
        Double x = ((-1/A)*(this.cosineFunc(v, (2-s1)))*(this.cosineFunc(u, (2-s2))));
        Double y = ((1/B)*(this.cosineFunc(v, (2-s1))*(this.sinFunc(u, (2-s2)))));
        Double z = ((1/C)*(this.sinFunc(v, (2-s1))));
        return Arrays.asList(x, y, z);
    }

}
