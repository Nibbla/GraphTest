package game.Interfaces;

import game.*;

import java.util.ArrayList;

/**
 * Created by Nibbla on 10.04.2016.
 */
public interface BoardView {
    void setPlayers(ArrayList<Player> p);

    void setCurrentPlayer(Player p);

    void setCourse(Course c);

    int getFirstXClick();

    void setFirstXClick(int firstXClick);

    int getFirstYClick();

    void setFirstYClick(int firstYClick);
}
