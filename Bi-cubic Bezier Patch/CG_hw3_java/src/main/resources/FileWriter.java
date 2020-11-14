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
    private static final String second = "ShapeHints {\n\tvertexOrdering\tCOUNTERCLOCKWISE\n}";

    public static void writeSpheres(BufferedWriter writer, ArrayList<List<Double>> coordinates, String radius) throws IOException{
        DecimalFormat df = new DecimalFormat("0");
        df.setMaximumFractionDigits(8);

        for (int i = 0; i <= coordinates.size()-1; i++ ){
            writer.write("Separator {\nLightModel {\nmodel PHONG\n}\nMaterial {\n\tdiffuseColor 1.0 1.0 1.0\n}");
            writer.newLine();

            writer.write("Transform {\n\ttranslation");


            String coordinateX = df.format(coordinates.get(i).get(0));
            String coordinateY = df.format(coordinates.get(i).get(1));
            String coordinateZ = df.format(coordinates.get(i).get(2));

            writer.write("\t"+coordinateX + " " + coordinateY + " " + coordinateZ);
            writer.newLine();

            writer.write("}\nSphere {\n\tradius " + radius + "\n}\n}");
            writer.newLine();
            }
    }

    public static void writeCoordinates(BufferedWriter writer, ArrayList<List<List<Double>>> newCoordinates) throws IOException{
        writer.write("Separator{\n\tCoordinate3 { \n\t\tpoint [");
        writer.newLine();

        for (List<List<Double>> newCoordinate: newCoordinates){
            for (List<Double> coords: newCoordinate){
                String cordX = coords.get(0).toString();
                String cordY = coords.get(1).toString();
                String cordZ = coords.get(2).toString();
                writer.write("\t\t\t"+ cordX + " " + cordY + " " + cordZ + ",");
                writer.newLine();
            }
        }

        writer.write("\t\t]\n\t}");
        writer.newLine();
    }

    public static void writeTriangles(BufferedWriter writer, List<List<Integer>> triangleCoordinates) throws IOException{
        writer.write("\tIndexedFaceSet {\n\t\tcoordIndex [");
        writer.newLine();

        for (List<Integer> triangleCoordinate: triangleCoordinates){
            String cordX = triangleCoordinate.get(0).toString();
            String cordY = triangleCoordinate.get(1).toString();
            String cordZ = triangleCoordinate.get(2).toString();
            writer.write("\t\t\t"+ cordX + ", " + cordY + ", " + cordZ + ", " + "-1,");
            writer.newLine();
        }

        writer.write("\t\t]\n\t}\n}");
        writer.newLine();
    }

    public static void writeNormals(BufferedWriter writer,ArrayList<List<List<Double>>> normalCoordinates ) throws IOException{
        writer.write("NormalBinding {\n" + "\tvalue\tPER_VERTEX_INDEXED\n" + "}");
        writer.newLine();
        writer.write("\tNormal {\n" + "\t\tvector [");
        writer.newLine();
        for (List<List<Double>> newCoordinate: normalCoordinates){
            for (List<Double> coords: newCoordinate){
                String cordX = coords.get(0).toString();
                String cordY = coords.get(1).toString();
                String cordZ = coords.get(2).toString();
                writer.write("\t\t\t"+ cordX + " " + cordY + " " + cordZ + ",");
                writer.newLine();
            }
        }

        writer.write("\t\t]\n\t}");
        writer.newLine();
    }


    public static void writeFile(String out, ArrayList<List<List<Double>>> newCoordinates, ArrayList<List<Double>> coordinates,
                                 List<List<Integer>> triangleCoordinates, ArrayList<List<List<Double>>> normalCoordinates,String radius) throws Exception{
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(out))){
            writer.write(first);
            writer.newLine();
            writer.newLine();

            writer.write(second);
            writer.newLine();

            writeCoordinates(writer, newCoordinates);
            writeNormals(writer, normalCoordinates);
            writeTriangles(writer, triangleCoordinates);
            writeSpheres(writer, coordinates, radius);
        }
        catch(IOException e){
            System.out.println("Exception Thrown : " + e);
        }
    }

    public static void writeFile(String out, ArrayList<List<List<Double>>> newCoordinates, ArrayList<List<Double>> coordinates,
                                 List<List<Integer>> triangleCoordinates,String radius) throws Exception{
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(out))){
            writer.write(first);
            writer.newLine();
            writer.newLine();

            writer.write(second);
            writer.newLine();

            writeCoordinates(writer, newCoordinates);
            writeTriangles(writer, triangleCoordinates);
            writeSpheres(writer, coordinates, radius);
        }
        catch(IOException e){
            System.out.println("Exception Thrown : " + e);
        }
    }
}
