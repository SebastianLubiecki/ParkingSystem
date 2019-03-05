package Service.Interfaces;

import Models.Level;

import java.util.List;

public interface LevelsOperation {

    List<Level> getListOfAllLevels();

    Level getFirstFreeLevel();

    void changeStatusOfLevel(Level level);

}
