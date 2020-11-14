package main.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleCoordinates {
    public static List<List<Integer>> generate(ArrayList<List<List<Double>>> newCoordinates){
        List<List<Integer>> triangleCoordinates = new ArrayList<>();
        Integer rowsSize = newCoordinates.size();
        Integer columnSize = newCoordinates.get(0).size();

        for (Integer i=0; i< newCoordinates.size()-1; i++){
            for (Integer j=0; j< newCoordinates.get(0).size()-1;j++){
                triangleCoordinates.add(Arrays.asList((columnSize*i)+j,(columnSize*i)+j+columnSize, (columnSize*i)+j+1));
                triangleCoordinates.add(Arrays.asList((columnSize*i)+j+1,(columnSize*i)+j+columnSize, (columnSize*i)+j+columnSize+1));
            }
        }

        return triangleCoordinates;
    }
}
