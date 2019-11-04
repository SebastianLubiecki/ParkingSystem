package Service.Interfaces;

import Models.LevelEntity;

import java.util.List;

public interface LevelsOperation {

    List<LevelEntity> getListOfAllLevels();

    LevelEntity getFirstFreeLevel();

    void changeStatusOfLevel(LevelEntity levelEntity);

}
