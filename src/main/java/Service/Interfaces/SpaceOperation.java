package Service.Interfaces;

import Models.ParkingRowEntity;
import Models.ParkingSpaceEntity;

import java.util.List;

public interface SpaceOperation {

    List<ParkingSpaceEntity> getListOfAllSPaces();

    List<ParkingSpaceEntity> getListOfSpacesInFollowingRow(ParkingRowEntity parkingRowEntity);

    ParkingSpaceEntity getFirstFreeSpaceInFollowingRow(ParkingRowEntity parkingRowEntity);

    void changeStatusOfTheSpace(ParkingSpaceEntity parkingSpaceEntity);

}
