package Service.Interfaces;

import Models.Level;
import Models.ParkingRow;

import java.util.List;

public interface RowsOperation {

    List<ParkingRow> getListOfAllRows();

    List<ParkingRow> getListOfRowInFollowingLevel(Level level);

    ParkingRow getFirstFreeRowInFollowingLevel(Level level);

    void changeStatusOfTheRow(ParkingRow parkingRow);
}
