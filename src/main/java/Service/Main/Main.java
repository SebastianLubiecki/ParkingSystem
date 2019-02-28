package Service.Main;


import Connection.Implementation.SessionUtil;
import Models.Level;
import Models.ParkingRow;
import Models.ParkingSpace;
import Models.VehicleSize;
import Service.Implementation.AlgorithmImplementation.AlgorithmImp;
import Service.Implementation.ParkingImplementation.ParkingImp;
import Service.Interfaces.Algorithm;
import Service.Interfaces.Parking;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

      //  dateBase();

        Algorithm algorithm = new AlgorithmImp();
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            //  List list=  algorithm.getListOfLevels();
            algorithm.getFreeParkingSpace();
            transaction.commit();

         }
    }

    public static void dateBase() {
        Parking parking = new ParkingImp();

        Level level1 = new Level();
        Level level2 = new Level();

        ParkingRow parkingRow11 = new ParkingRow();
        parkingRow11.setLevel(level1);
        parkingRow11.setStatus(true);
        ParkingRow parkingRow12 = new ParkingRow();
        parkingRow12.setLevel(level1);
        parkingRow12.setStatus(true);
        ParkingRow parkingRow21 = new ParkingRow();
        parkingRow21.setLevel(level2);
        parkingRow21.setStatus(true);
        ParkingRow parkingRow22 = new ParkingRow();
        parkingRow22.setLevel(level2);
        parkingRow22.setStatus(true);

        ParkingSpace parkingSpace111 = new ParkingSpace();
        parkingSpace111.setSize(VehicleSize.CAR);
        parkingSpace111.setParkingRow(parkingRow11);
        ParkingSpace parkingSpace112 = new ParkingSpace();
        parkingSpace112.setSize(VehicleSize.CAR);
        parkingSpace112.setParkingRow(parkingRow11);
        ParkingSpace parkingSpace113 = new ParkingSpace();
        parkingSpace113.setSize(VehicleSize.CAR);
        parkingSpace113.setParkingRow(parkingRow11);
        ParkingSpace parkingSpace121 = new ParkingSpace();
        parkingSpace121.setSize(VehicleSize.CAR);
        parkingSpace121.setParkingRow(parkingRow12);
        ParkingSpace parkingSpace122 = new ParkingSpace();
        parkingSpace122.setSize(VehicleSize.CAR);
        parkingSpace122.setParkingRow(parkingRow12);
        ParkingSpace parkingSpace123 = new ParkingSpace();
        parkingSpace123.setSize(VehicleSize.CAR);
        parkingSpace123.setParkingRow(parkingRow12);
        ParkingSpace parkingSpace211 = new ParkingSpace();
        parkingSpace211.setSize(VehicleSize.CAR);
        parkingSpace211.setParkingRow(parkingRow21);
        ParkingSpace parkingSpace212 = new ParkingSpace();
        parkingSpace212.setSize(VehicleSize.CAR);
        parkingSpace212.setParkingRow(parkingRow21);
        ParkingSpace parkingSpace213 = new ParkingSpace();
        parkingSpace213.setSize(VehicleSize.CAR);
        parkingSpace213.setParkingRow(parkingRow21);
        ParkingSpace parkingSpace221 = new ParkingSpace();
        parkingSpace221.setSize(VehicleSize.CAR);
        parkingSpace221.setParkingRow(parkingRow22);
        ParkingSpace parkingSpace222 = new ParkingSpace();
        parkingSpace222.setSize(VehicleSize.CAR);
        parkingSpace222.setParkingRow(parkingRow22);
        ParkingSpace parkingSpace223 = new ParkingSpace();
        parkingSpace223.setSize(VehicleSize.CAR);
        parkingSpace223.setParkingRow(parkingRow22);

        List<ParkingRow> parkingRowsAtLevel1 = new ArrayList<>();
        parkingRowsAtLevel1.add(parkingRow11);
        parkingRowsAtLevel1.add(parkingRow12);
        level1.setParkingRowList(parkingRowsAtLevel1);

        List<ParkingRow> parkingRowsAtLevel2 = new ArrayList<>();
        parkingRowsAtLevel2.add(parkingRow21);
        parkingRowsAtLevel2.add(parkingRow22);
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


        level1.setSize(parkingRowsAtLevel1.size());
        level1.setStatus(true);
        level2.setSize(parkingRowsAtLevel2.size());
        level2.setStatus(true);


        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(level1);
            session.save(level2);
            System.out.println(parkingRow11.getStatus());

            session.save(parkingRow11);
            session.save(parkingRow12);
            session.save(parkingRow21);
            session.save(parkingRow22);
            session.save(parkingSpace111);
            session.save(parkingSpace112);
            session.save(parkingSpace113);
            session.save(parkingSpace121);
            session.save(parkingSpace122);
            session.save(parkingSpace123);
            session.save(parkingSpace211);
            session.save(parkingSpace212);
            session.save(parkingSpace213);
            session.save(parkingSpace221);
            session.save(parkingSpace222);
            session.save(parkingSpace223);

            transaction.commit();
            System.out.println("DateBase Comp");
        }

    }
}
