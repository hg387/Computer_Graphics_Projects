package main.resources;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TangentGenerator {
    public static void Generator(ArrayList<List<Double>> tangents, ArrayList<List<Double>> coordinates, Double tension){
        if (tangents.size() != coordinates.size()) {
            for (int i = 0; i < coordinates.size()-2; i++) {
                List<Double> P0 = coordinates.get(i);
                List<Double> P2 = coordinates.get(i + 2);

                Double tangentP1X = ((1-tension)*(P2.get(0) - P0.get(0))) / 2.0;
                Double tangentP1Y = ((1-tension)*(P2.get(1) - P0.get(1))) / 2.0;
                Double tangentP1Z = ((1-tension)*(P2.get(2) - P0.get(2))) / 2.0;

                tangents.add(i + 1, Arrays.asList(tangentP1X, tangentP1Y, tangentP1Z));
            }
        }

        // Tension adjustment for initial points
        List<Double> T0 = tangents.get(0);
        List<Double> TLast = tangents.get(tangents.size()-1);

        Double tangentP1X = ((1-tension)*(T0.get(0)));
        Double tangentP1Y = ((1-tension)*(T0.get(1)));
        Double tangentP1Z = ((1-tension)*(T0.get(2)));
        tangents.set(0, Arrays.asList(tangentP1X, tangentP1Y, tangentP1Z));

        tangentP1X = ((1-tension)*(TLast.get(0)));
        tangentP1Y = ((1-tension)*(TLast.get(1)));
        tangentP1Z = ((1-tension)*(TLast.get(2)));
        tangents.set(tangents.size()-1, Arrays.asList(tangentP1X, tangentP1Y, tangentP1Z));

    }

    @Deprecated
    public static void GeneratorV2(ArrayList<List<Double>> tangents, ArrayList<List<Double>> coordinates, Double tension){
        int i =0;
        while (tangents.size() != coordinates.size()) {
                List<Double> P0 = coordinates.get(i);
                List<Double> P2 = coordinates.get(i + 2);

                Double tangentP1X = ((1-tension)*(P2.get(0) - P0.get(0))) / 2.0;
                Double tangentP1Y = ((1-tension)*(P2.get(1) - P0.get(1))) / 2.0;
                Double tangentP1Z = ((1-tension)*(P2.get(2) - P0.get(2))) / 2.0;

                tangents.add(i + 1, Arrays.asList(tangentP1X, tangentP1Y, tangentP1Z));
                i++;
        }
    }
}
