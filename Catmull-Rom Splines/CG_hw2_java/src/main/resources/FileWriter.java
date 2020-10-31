package main.resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {
    private static final String first = "#Inventor V2.0 ascii";
    private static final String second = "Separator {LightModel {model BASE_COLOR} Material {diffuseColor 1.0 1.0 1.0}";

    public static void writeLineSet(Integer size, BufferedWriter writer) throws IOException{
        writer.write("IndexedLineSet {coordIndex [");
        writer.newLine();

        for (int i = 0; i < (size); i++){
            writer.write(i + ", ");
        }

        writer.write("-1 ");
        writer.newLine();
        writer.write("] } }");
        writer.newLine();
    }

    public static void writeSpheres(BufferedWriter writer, ArrayList<List<Double>> coordinates, String radius) throws IOException{
        DecimalFormat df = new DecimalFormat("0");
        df.setMaximumFractionDigits(8);

        for (int i = 0; i <= coordinates.size()-1; i++ ){
            writer.write("Separator {LightModel {model PHONG}Material {\tdiffuseColor 1.0 1.0 1.0}");
            writer.newLine();

            writer.write("Transform {translation");
            writer.newLine();

            String coordinateX = df.format(coordinates.get(i).get(0));
            String coordinateY = df.format(coordinates.get(i).get(1));
            String coordinateZ = df.format(coordinates.get(i).get(2));

            writer.write(coordinateX + " " + coordinateY + " " + coordinateZ);
            writer.newLine();

            writer.write("}Sphere {\tradius " + radius + " }}");
            writer.newLine();
            }
    }

    public static void writeCoordinates(BufferedWriter writer, ArrayList<List<Double>> newCoordinates) throws IOException{
        writer.write("Coordinate3 { \tpoint [");
        writer.newLine();

        for (int i=0; i <= newCoordinates.size()-1; i++){
            DecimalFormat df = new DecimalFormat("0");
            df.setMaximumFractionDigits(8);
            String coordinateX = df.format(newCoordinates.get(i).get(0));
            String coordinateY = df.format(newCoordinates.get(i).get(1));
            String coordinateZ = df.format(newCoordinates.get(i).get(2));

            if (i != newCoordinates.size()-1) { writer.write(coordinateX + " " + coordinateY + " " + coordinateZ + ","); }
            else{writer.write(coordinateX + " " + coordinateY + " " + coordinateZ);}
            writer.newLine();
        }

        writer.write("] }");
        writer.newLine();
    }

    public static void writeFile(String out, ArrayList<List<Double>> newCoordinates, ArrayList<List<Double>> coordinates, String radius) throws Exception{
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(out))){
            writer.write(first);
            writer.newLine();
            writer.newLine();

            writer.write(second);
            writer.newLine();

            writeCoordinates(writer, newCoordinates);
            writeLineSet(newCoordinates.size(), writer);
            writeSpheres(writer, coordinates, radius);
        }
        catch(IOException e){
            System.out.println("Exception Thrown : " + e);
        }
    }
}
