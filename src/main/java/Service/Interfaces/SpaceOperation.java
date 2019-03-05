package Service.Interfaces;

import Models.ParkingRow;
import Models.ParkingSpace;

import java.util.List;

public interface SpaceOperation {

    List<ParkingSpace> getListOfAllSPaces();

    List<ParkingSpace> getListOfSpacesInFollowingRow(ParkingRow parkingRow);

    ParkingSpace getFirstFreeSpaceInFollowingRow(ParkingRow parkingRow);

    void changeStatusOfTheSpace(ParkingSpace parkingSpace);

}
