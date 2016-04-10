package game;

import java.awt.*;
import java.awt.Color;

import org.jzy3d.colors.*;

/**
 * Created by nibbla on 14.03.16.
 */
public enum Type {
    Empty(Color.GREEN,0.1),
    Water(Color.BLUE,1.0),
    Sand(Color.YELLOW,0.8),
    Hole(Color.WHITE,0.9),
    Grass(Color.GREEN,0.3),
    Start(Color.RED,0.0),
    OBJECT(Color.gray, Config.WALL_ENERGY_LOSS),
    Ball(Color.BLUE,1),;


    private final org.jzy3d.colors.Color jzy3dC;
    Color g;
    double friction;
    Type(Color g, double v) {
        this.g = g;
        this.friction = v;
        this.jzy3dC = new org.jzy3d.colors.Color(g.getRed(),g.getGreen(),g.getBlue(),1f);
    }

    public double getFriction(){
        return friction;
    }
    public Color getColor(){
        return g;
    }
    public org.jzy3d.colors.Color getColorJzy3dC(){
        return jzy3dC;
    }
}
