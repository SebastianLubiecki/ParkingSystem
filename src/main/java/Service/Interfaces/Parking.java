package Service.Interfaces;

import Models.ParkingSpace;

public interface Parking {

    void releaseParkingSpace(ParkingSpace parkingSpace);

    void takeParkingSpace();

}
