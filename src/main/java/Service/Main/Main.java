package Service.Main;


import Connection.Implementation.SessionUtil;
import Models.Level;
import Models.ParkingRow;
import Models.ParkingSpace;
import Models.VehicleSize;
import Service.Implementation.ParkingImplementation.ParkingImp;
import Service.Interfaces.Parking;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        dateBase();
        Level level = new Level();
        ParkingRow parkingRow = new ParkingRow();
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setStatus(true);
        parkingSpace.setSize(VehicleSize.CAR);
        List<ParkingRow> parkingRows = new ArrayList<>();
        parkingRows.add(parkingRow);
        level.setParkingRowList(parkingRows);
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();


            transaction.commit();

        }
//        Configuration cfg = new Configuration();
//
//        cfg.configure("hibernate.cfg.xml");
//        parking.takeParkingSpace(vehicle);
    }

    public static void dateBase() {
        Parking parking = new ParkingImp();

        Level level1 = new Level();
        Level level2 = new Level();

        ParkingRow parkingRow11 = new ParkingRow();
        ParkingRow parkingRow12 = new ParkingRow();
        ParkingRow parkingRow21 = new ParkingRow();
        ParkingRow parkingRow22 = new ParkingRow();


        ParkingSpace parkingSpace111 = new ParkingSpace();
        parkingSpace111.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace112 = new ParkingSpace();
        parkingSpace112.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace113 = new ParkingSpace();
        parkingSpace113.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace121 = new ParkingSpace();
        parkingSpace121.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace122 = new ParkingSpace();
        parkingSpace122.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace123 = new ParkingSpace();
        parkingSpace123.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace211 = new ParkingSpace();
        parkingSpace211.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace212 = new ParkingSpace();
        parkingSpace212.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace213 = new ParkingSpace();
        parkingSpace213.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace221 = new ParkingSpace();
        parkingSpace221.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace222 = new ParkingSpace();
        parkingSpace222.setSize(VehicleSize.CAR);
        ParkingSpace parkingSpace223 = new ParkingSpace();
        parkingSpace223.setSize(VehicleSize.CAR);

        List<ParkingRow> parkingRowsAtLevel1 = new ArrayList<>();
        parkingRowsAtLevel1.add(parkingRow11);
        parkingRowsAtLevel1.add(parkingRow12);
        level1.setParkingRowList(parkingRowsAtLevel1);

        List<ParkingRow> parkingRowsAtLevel2 = new ArrayList<>();
        parkingRowsAtLevel1.add(parkingRow21);
        parkingRowsAtLevel1.add(parkingRow22);
        level2.setParkingRowList(parkingRowsAtLevel2);

        List<ParkingSpace> parkingSpacesInRow11 = new ArrayList<>();
        parkingSpacesInRow11.add(parkingSpace111);
        parkingSpacesInRow11.add(parkingSpace112);
        parkingSpacesInRow11.add(parkingSpace113);
        parkingRow11.setParkingSpaceList(parkingSpacesInRow11);


        List<ParkingSpace> parkingSpacesInRow12 = new ArrayList<>();
        parkingSpacesInRow12.add(parkingSpace121);
        parkingSpacesInRow12.add(parkingSpace122);
        parkingSpacesInRow12.add(parkingSpace123);
        parkingRow12.setParkingSpaceList(parkingSpacesInRow12);

        List<ParkingSpace> parkingSpacesInRow21 = new ArrayList<>();
        parkingSpacesInRow21.add(parkingSpace211);
        parkingSpacesInRow21.add(parkingSpace212);
        parkingSpacesInRow21.add(parkingSpace213);
        parkingRow21.setParkingSpaceList(parkingSpacesInRow21);

        List<ParkingSpace> parkingSpacesInRow22 = new ArrayList<>();
        parkingSpacesInRow22.add(parkingSpace221);
        parkingSpacesInRow22.add(parkingSpace222);
        parkingSpacesInRow22.add(parkingSpace223);
        parkingRow22.setParkingSpaceList(parkingSpacesInRow22);

        parkingRow11.setLevel(level1);
        level1.setSize(6);
        level2.setSize(6);

        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

//            session.save(level1);
//            session.save(level2);
            session.save(parkingRow11);
//            session.save(parkingRow12);
//            session.save(parkingRow21);
//            session.save(parkingRow22);
//            session.save(parkingSpace111);
//            session.save(parkingSpace112);
//            session.save(parkingSpace113);
//            session.save(parkingSpace121);
//            session.save(parkingSpace122);
//            session.save(parkingSpace123);
//            session.save(parkingSpace211);
//            session.save(parkingSpace212);
//            session.save(parkingSpace213);
//            session.save(parkingSpace221);
//            session.save(parkingSpace222);
        //  session.save(parkingSpace223);

            transaction.commit();
            System.out.println("DateBase Comp");
        }

    }
}
