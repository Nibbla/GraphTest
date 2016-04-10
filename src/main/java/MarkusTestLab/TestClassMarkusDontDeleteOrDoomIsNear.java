package MarkusTestLab;

import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.*;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nibbla on 09.04.2016.
 */
public class TestClassMarkusDontDeleteOrDoomIsNear {


    private static Coord3d[] points2;
    private static Color[] colors2;
    private static Chart savedChart;

    public static void main(String[] args){
        System.out.println("Welcome to Markus' Testlab\n");
        boolean scenario1 = false;
        boolean scenario2 = false;
        boolean scenario3 = false;
        boolean scenario4 = false;
        boolean scenario5 = false;

        boolean scenario6 = false;
        boolean scenario7 = false;
        boolean scenario8 = false;

        System.out.println("Creating and filling different Array Types\n");
        Tile[][][] playfield;
        Tile[] playfield2;
        Type[][][] playfield3;
        Type[] playfield4;
        ArrayList<ArrayList<ArrayList<Type>>> playfield5;

        double startTime;
        double endTime;
        double passedTime;



        if(scenario1) {
                Scenario1();
        }

        if(scenario2) {
                Scenario2();

        }


        if(scenario3) {

                Scenario3();



        }

        if(scenario4) {

            Scenario4();


        }

        if(scenario5) {
            Scenario5();

        }


        System.out.println("");
        System.out.println("Retrieving different Array Types\n");

        if(scenario6) {
            Scenario6();

        }

        if(scenario7) {

                Scenario7();





        }

        if(scenario8) {

                Scenario8();





        }

        //Print out Data
        printOut(Scenario3(),800*400*100);



    }

    private static void printOut(final Type[][][] types, final int n) {
        AbstractAnalysis a = new AbstractAnalysis() {


            public void init() throws Exception {
                int size = n;
                Type[][][] types2 = types;





                int length = 800;
                int width = 400;
                int height = 100;
                int e = length * width * height;
                int i=0;
                ArrayList<Coord3d> points = new ArrayList<Coord3d>();;
                ArrayList<Color> colors = new ArrayList<Color>();
                for (int x = 0; x < length; x++) {
                    for (int y = 0; y < width; y++) {

                        for (int z = 0; z < height; z++) {
                            float a = 1.f;
                            if (types[x][y][z] != Type.Empty) {
                                points.add(new Coord3d(x, y, z));

                                colors.add(new Color(types[x][y][z].g.getRed(), types[x][y][z].g.getGreen(), types[x][y][z].g.getBlue(), a));
                                i++;
                            }
                        }
                    }
                }

                points2 = new Coord3d[points.size()];
                colors2 = new Color[colors.size()];
                points.toArray(points2);
                colors.toArray(colors2);

                Scatter scatter = new Scatter(points2, colors2);
                chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");
                chart.getScene().add(scatter);
                savedChart = chart;

            }
        };
        try {
            AnalysisLauncher.open(a);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Random r = new Random();
        while (true){


            for (int i = 0; i < points2.length; i++) {
                points2[r.nextInt(points2.length)].z +=10;
            }

            try {
           // savedChart.updateProjectionsAndRender();
           // a.getChart().updateProjectionsAndRender();

                Scatter scatter = new Scatter(points2, colors2);
                savedChart.getScene().getGraph().getAll().clear();
                savedChart.getScene().add(scatter);
                Thread.sleep(16);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }


    }


        protected static void remap(Shape shape){
            List<AbstractDrawable> polygons = shape.getDrawables();
            for(AbstractDrawable d: polygons){
                if(d instanceof Polygon){
                    Polygon p = (Polygon) d;
                    for(int i=0; i<p.size(); i++){
                        Point pt = p.get(i);
                        Coord3d c = pt.xyz;
                        c.z = (float) 10f;
                    }
                }
            }
        }


    private static void Scenario8() {
        Tile[][][] playfield;
        double startTime;
        double endTime;
        double passedTime;//
        // Scenario Three

        int n = 100000;
        int length = 800;
        int width = 400;
        int height = 100;
        int e = length * width * height;
        playfield = new Tile[length][width][height];

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                playfield[x][y][0] = new Tile(Type.Grass,x,y,0);
                for (int z = 1; z < height; z++) {
                    playfield[x][y][z] = new Tile(Type.Empty,x,y,z);
                }
            }
        }
        startTime = System.currentTimeMillis();
        Random x = new Random();
        for (int i = 0; i < n; i++) {
            Tile s = playfield[x.nextInt(length)][x.nextInt(width)][x.nextInt(height)];
        }

        endTime = System.currentTimeMillis();
        passedTime = endTime - startTime;

        System.out.format("Version Retrieval of %d random elements from 3dim Array of %d elements in Dimension %d,%d,%d Tiles took %n \t %.3f Milliseconds%n",n, e, length, width, height, passedTime);
    }

    private static void Scenario7() {
        Type[][][] playfield3;
        double startTime;
        double endTime;
        double passedTime;//
        // Scenario Three

        int n = 100000;
        int length = 800;
        int width = 400;
        int height = 100;
        int e = length * width * height;
        playfield3 = new Type[length][width][height];
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                playfield3[x][y][0] = Type.Grass;
                for (int z = 1; z < height; z++) {
                    playfield3[x][y][z] = Type.Empty;
                }
            }
        }
        startTime = System.currentTimeMillis();
        Random x = new Random();
        for (int i = 0; i < n; i++) {
            Type s = playfield3[x.nextInt(length)][x.nextInt(width)][x.nextInt(height)];
        }

        endTime = System.currentTimeMillis();
        passedTime = endTime - startTime;

        System.out.format("Version Retrieval of %d random elements from 3dim Array of %d elements in Dimension %d,%d,%d enums took %n \t %.3f Milliseconds%n",n, e, length, width, height, passedTime);
    }

    private static void Scenario6() {
        Type[] playfield4;
        double startTime;
        double endTime;
        double passedTime;//
        // Scenario Five Retrieving from 1dim enum

        int n = 100000;
        int length = 800;
        int width = 400;
        int height = 100;
        int e = length * width * height;
        playfield4 = new Type[e];
        for (int i = 0; i < e; i++) {
            playfield4[i] = Type.Empty;
        }
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                playfield4[x*y*height] = Type.Grass;
            }
        }
        startTime = System.currentTimeMillis();
        Random x = new Random();
        for (int i = 0; i < n; i++) {
            Type s = playfield4[x.nextInt(length) + width * (x.nextInt(width) + height * x.nextInt(height))];
        }

        endTime = System.currentTimeMillis();
        passedTime = endTime - startTime;

        System.out.format("Version Retrieval of %d random elements from 1dim Array of %d elements in Dimension %d,%d,%d enums took %n \t %.3f Milliseconds%n",n, e, length, width, height, passedTime);
    }

    private static void Scenario5() {
       /* double startTime;
        ArrayList<ArrayList<ArrayList<Type>>> playfield5;
        double endTime;
        double passedTime;//
        // Scenario Five

        startTime = System.currentTimeMillis();

        int length = 800;
        int width = 400;
        int height = 100;
        int e = length * width * height;
        playfield5 = new ArrayList<>(length);
        for (int x = 0; x < length; x++) {
            //playfield5.add(new ArrayList<>(width));
            for (int y = 0; y < width; y++) {
                //playfield5.get(x).add(new ArrayList<>(height));
                playfield5.get(x).get(y).add(Type.Grass);
                for (int z = 1; z < height; z++) {
                    playfield5.get(x).get(y).add(Type.Empty);
                }

            }
        }

        endTime = System.currentTimeMillis();
        passedTime = endTime - startTime;

        System.out.format("Version 3dim ArrayList<Type> for %d elements in Dimension %d,%d,%d enums took %n \t %.3f Milliseconds%n", e, length, width, height, passedTime);
        */
    }

    private static void Scenario4() {
        double startTime;
        Type[] playfield4;
        double endTime;
        double passedTime;//
        // Scenario Four
        startTime = System.currentTimeMillis();

        int length = 800;
        int width = 400;
        int height = 100;
        int e = length * width * height;
        playfield4 = new Type[e];
        for (int i = 0; i < e; i++) {
            playfield4[i] = Type.Empty;
        }
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                playfield4[x + width * (y + height * 0)] = Type.Grass;
            }
        }

        endTime = System.currentTimeMillis();
        passedTime = endTime - startTime;

        System.out.format("Version 1dim Array for %d elements in Dimension %d,%d,%d enums took %n \t %.3f Milliseconds%n", e, length, width, height, passedTime);
    }

    private static Type[][][] Scenario3() {
        double startTime;
        Type[][][] playfield3;
        double endTime;
        double passedTime;//
        // Scenario Three
        startTime = System.currentTimeMillis();

        int length = 800;
        int width = 400;
        int height = 100;
        int e = length * width * height;
        playfield3 = new Type[length][width][height];
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                playfield3[x][y][0] = Type.Grass;
                for (int z = 1; z < height; z++) {
                    playfield3[x][y][z] = Type.Empty;
                }
            }
        }

        endTime = System.currentTimeMillis();
        passedTime = endTime - startTime;

        System.out.format("Version 3nested Array for %d elements in Dimension %d,%d,%d with enums took %n \t %.3f Milliseconds%n", e, length, width, height, passedTime);

        return  playfield3;
    }

    private static void Scenario2() {
        double startTime;
        Tile[] playfield2;
        double endTime;
        double passedTime;//
        // Scenario Two
        startTime = System.currentTimeMillis();

        int length = 800;
        int width = 400;
        int height = 100;
        int e = length * width * height;
        int i = 0;
        playfield2 = new Tile[e];
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                for (int z = 0; z < height; z++) {
                    playfield2[i++] = Tile.newTile(Type.Empty, x, y, z);
                }
            }
        }

        endTime = System.currentTimeMillis();
        passedTime = endTime - startTime;

        System.out.format("Version 1dim Array for %d elements in Dimension %d,%d,%d took %n \t %.3f Milliseconds%n", e, length, width, height, passedTime);
    }

    private static void Scenario1() {
        double startTime;
        Tile[][][] playfield;
        double endTime;
        double passedTime;//
        // Scenario One
        startTime = System.currentTimeMillis();

        int length = 800;
        int width = 400;
        int height = 100;
        int e = length * width * height;
        playfield = new Tile[length][width][height];
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                for (int z = 0; z < height; z++) {
                    playfield[x][y][z] = Tile.newTile(Type.Empty, x, y, z);
                }
            }
        }

        endTime = System.currentTimeMillis();
        passedTime = endTime - startTime;

        System.out.format("Version 3nested Array for %d elements in Dimension %d,%d,%d took %n \t %.3f Milliseconds%n", e, length, width, height, passedTime);
    }
}
