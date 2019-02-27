package Service;


import Connection.Implementation.SessionUtil;
import Models.Level;
import Models.ParkingRow;
import Models.ParkingSpace;
import Models.VehicleSize;
import Service.Implementation.ParkingImplementation.ParkingImp;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parking parking = new ParkingImp();

        Level level = new Level();
        ParkingRow parkingRow = new ParkingRow();
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setStatus(true);
        parkingSpace.setSize(VehicleSize.CAR);
        List <ParkingRow> parkingRows = new ArrayList<>();
        parkingRows.add(parkingRow);
//level.setParkingRowList(parkingRows);
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(level);

            transaction.commit();

        }
//        Configuration cfg = new Configuration();
//
//        cfg.configure("hibernate.cfg.xml");
//        parking.takeParkingSpace(vehicle);
    }
}
