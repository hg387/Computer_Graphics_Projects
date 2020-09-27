package main.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleCoordinates {

    public static List<List<Integer>> generate(ArrayList<List<List<Double>>> newCoordinates){
        List<List<Integer>> triangleCoordinates = new ArrayList<>();
        Integer rowsSize = newCoordinates.size();
        Integer columnSize = newCoordinates.get(0).size();

        for (Integer i=0; i<= newCoordinates.size()-1; i++){
            if (i != newCoordinates.size()-1) {
                for (Integer j = 0; j < newCoordinates.get(0).size(); j++) {
                    triangleCoordinates.add(Arrays.asList((columnSize * i) + j + 1, (columnSize * i) + j + 1 + columnSize, (columnSize * i) + j + 1 + 1));
                    triangleCoordinates.add(Arrays.asList((columnSize * i) + j + 1 + 1, (columnSize * i) + j + 1 + columnSize, (columnSize * i) + j + 1 + columnSize + 1));
                }
            }else {
                triangleCoordinates.remove(triangleCoordinates.size()-1);
                triangleCoordinates.remove(triangleCoordinates.size()-1);

                List<Integer> tmp = triangleCoordinates.get(triangleCoordinates.size()-1);

                triangleCoordinates.add(Arrays.asList(tmp.get(0)+1-newCoordinates.get(0).size(), tmp.get(1)+1, tmp.get(2)+1-newCoordinates.get(0).size()));
                triangleCoordinates.add(Arrays.asList(tmp.get(2)-newCoordinates.get(0).size(), tmp.get(1)+1,tmp.get(0)+1-newCoordinates.get(0).size()));

            }
        }

        int count = 0;
        for (int i=0; i<newCoordinates.get(0).size()-1; i++){
            triangleCoordinates.add(count,Arrays.asList(i+1,i+2,0));
            count++;
        }

        triangleCoordinates.add(count,Arrays.asList(newCoordinates.get(0).size(),1,0));
        count++;

        int max = (newCoordinates.size() * newCoordinates.get(0).size())+1;
        int tmp = max - newCoordinates.get(0).size();
        for (int i=0; i<newCoordinates.get(0).size()-1; i++){
            triangleCoordinates.add(count,Arrays.asList(max,tmp+1,tmp));
            count++;
            tmp++;
        }

        triangleCoordinates.add(count,Arrays.asList(max,(max-newCoordinates.get(0).size()),max-1));

        return triangleCoordinates;
    }
}
