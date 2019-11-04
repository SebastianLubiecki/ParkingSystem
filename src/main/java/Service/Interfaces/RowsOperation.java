package Service.Interfaces;

import Models.LevelEntity;
import Models.ParkingRowEntity;

import java.util.List;

public interface RowsOperation {

    List<ParkingRowEntity> getListOfAllRows();

    List<ParkingRowEntity> getListOfRowInFollowingLevel(LevelEntity levelEntity);

    ParkingRowEntity getFirstFreeRowInFollowingLevel(LevelEntity levelEntity);

    void changeStatusOfTheRow(ParkingRowEntity parkingRowEntity);
}
