package Service;

import Models.Level;
import Models.ParkingRow;
import Models.ParkingSpace;

import java.util.List;

public interface Algorithm {

    ParkingSpace getFreeParkingSpace();
    List getListOfLevels();
    List getListOfRowInFollowingLevel (Level level);
    List getFreeSpaceInFollowingRow (ParkingRow parkingRow);



}
