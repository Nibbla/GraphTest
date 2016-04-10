package game;

import MarkusTestLab.*;
import game.Interfaces.BoardView;
import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nibbla on 16.03.16.
 */
public class ThreeDScatterPanel extends  AbstractAnalysis implements BoardView  {

    private Course course;
    private ArrayList<Player> players;
    private Chart savedChart;
    private Player currentPlayer;

    public ThreeDScatterPanel(Course c, ArrayList<Player> pp) {
        this.setCourse(c);
        this.setPlayers(pp);
        if (pp!=null && pp.size() > 0 )this.setCurrentPlayer(pp.get(0));

    }






    public void stop() {

    }
    @Override
    public void setPlayers(ArrayList<Player> p) {
        this.players = p;
    }

    @Override
    public void setCurrentPlayer(Player p) {
        this.currentPlayer = p;
    }

    @Override
    public void setCourse(Course c) {
        this.course = c;
    }

    @Override
    public int getFirstXClick() {
        return 0;
    }

    @Override
    public void setFirstXClick(int firstXClick) {

    }

    @Override
    public int getFirstYClick() {
        return 0;
    }

    @Override
    public void setFirstYClick(int firstYClick) {

    }

    public void update() {
        if (course == null) return;
        if (savedChart == null) return;

        ArrayList<Scatter> scatter = new ArrayList<>();

        scatter.add(new Scatter(course.getPointsForScatter(), course.getColorsForScatter()));


        savedChart.getScene().getGraph().getAll().clear();
        for (Scatter s : scatter){
            savedChart.getScene().add(s);
        }


    }
    @Override
    public void init() throws Exception {



        Scatter scatter = new Scatter(course.getPointsForScatter(), course.getColorsForScatter());
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");
        chart.getScene().add(scatter);

        savedChart = chart;

    }


}
