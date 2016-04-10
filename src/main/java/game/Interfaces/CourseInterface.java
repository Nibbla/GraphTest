package game.Interfaces;

import game.*;

/**
 * Created by Nibbla on 10.04.2016.
 */
public interface CourseInterface {


    void setTile(int x, int y, int z, Type t);

    Type[][][] getPlayfield();

    void saveCourse();

    String getName();

    int[] getDimension();

    int getLength();

    int getWidth();

    int getHeight();

    Tile getStartTile();

    void addRectangle(int x1, int y1, int width, int height, Type type);

    void addSquircle(int a, int b, int r, int n, int z, Type t);

    Hole getHole();

    void setName(String name);

    void removeLastObject();
}
