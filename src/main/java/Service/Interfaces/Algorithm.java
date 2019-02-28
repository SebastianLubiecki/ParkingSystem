package Service.Interfaces;

import Models.Level;
import Models.ParkingRow;
import Models.ParkingSpace;

import java.util.List;

public interface Algorithm {

    ParkingSpace getFreeParkingSpace();
    List getListOfLevels();
    List getListOfRow( );
    List getParkingSpace ( );
     Level getFirstFreeLevel ();

     ParkingRow getFirstFreeParkingRow (Level level);

     ParkingSpace getFirstFreeParkingSpace (ParkingRow parkingRow);



}
