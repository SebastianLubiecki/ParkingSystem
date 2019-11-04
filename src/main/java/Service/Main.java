package Service;


import Connection.Implementation.SessionUtil;
import Models.LevelEntity;
import Models.ParkingRowEntity;
import Models.ParkingSpaceEntity;
import Service.Implementation.LevelImplementation;
import Service.Implementation.ParkingRowImpl;
import Service.Implementation.ParkingSpaceImpl;
import Service.Interfaces.LevelsOperation;
import Service.Interfaces.RowsOperation;
import Service.Interfaces.SpaceOperation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        dateBase();

        LevelsOperation levelsOperation = new LevelImplementation();
        RowsOperation rowsOperation = new ParkingRowImpl();
        SpaceOperation spaceOperation = new ParkingSpaceImpl();
        LevelEntity levelEntity = levelsOperation.getFirstFreeLevel();
        List<ParkingRowEntity> parkingRowEntities = rowsOperation.getListOfRowInFollowingLevel(levelEntity); //levelEntity.getParkingRowEntityList();

        System.out.println("Parking list size " + levelEntity.getParkingRowEntityList().size());
        for (int i = 0; i < parkingRowEntities.size(); i++) {
            System.out.println("number " + i + " of rows, equals: " + parkingRowEntities.get(i));
        }
        ParkingRowEntity parkingRowEntity = rowsOperation.getFirstFreeRowInFollowingLevel(levelEntity);
        System.out.println("Fist free parking row is " + parkingRowEntity);

        List<ParkingSpaceEntity> parkingSpaceEntityList = parkingRowEntity.getParkingSpaceEntityList();
        for (int i = 0; i < parkingSpaceEntityList.size(); i++) {
            System.out.println("Number" + i + " of parking row, is space: " + parkingSpaceEntityList.get(i));
        }

        System.out.println();
        ParkingSpaceEntity parkingSpaceEntity = spaceOperation.getFirstFreeSpaceInFollowingRow(parkingRowEntity);
        System.out.println("First free space is " + parkingSpaceEntity);


    }


    //Simulating database for h2
    private static void dateBase() {


        LevelEntity levelEntity1 = new LevelEntity();
        LevelEntity levelEntity2 = new LevelEntity();

        ParkingRowEntity parkingRowEntity11 = new ParkingRowEntity();
        parkingRowEntity11.setLevelEntity(levelEntity1);
        parkingRowEntity11.setStatus(false);
        ParkingRowEntity parkingRowEntity12 = new ParkingRowEntity();
        parkingRowEntity12.setLevelEntity(levelEntity1);
        parkingRowEntity12.setStatus(true);
        ParkingRowEntity parkingRowEntity21 = new ParkingRowEntity();
        parkingRowEntity21.setLevelEntity(levelEntity2);
        parkingRowEntity21.setStatus(true);
        ParkingRowEntity parkingRowEntity22 = new ParkingRowEntity();
        parkingRowEntity22.setLevelEntity(levelEntity2);
        parkingRowEntity22.setStatus(true);

        ParkingSpaceEntity parkingSpaceEntity111 = new ParkingSpaceEntity();
        parkingSpaceEntity111.setStatus(false);
        parkingSpaceEntity111.setParkingRowEntity(parkingRowEntity11);
        ParkingSpaceEntity parkingSpaceEntity112 = new ParkingSpaceEntity();
        parkingSpaceEntity112.setStatus(false);
        parkingSpaceEntity112.setParkingRowEntity(parkingRowEntity11);
        ParkingSpaceEntity parkingSpaceEntity113 = new ParkingSpaceEntity();
        parkingSpaceEntity113.setParkingRowEntity(parkingRowEntity11);
        ParkingSpaceEntity parkingSpaceEntity121 = new ParkingSpaceEntity();
        parkingSpaceEntity121.setParkingRowEntity(parkingRowEntity12);
        parkingSpaceEntity121.setStatus(false);
        ParkingSpaceEntity parkingSpaceEntity122 = new ParkingSpaceEntity();
        parkingSpaceEntity122.setStatus(true);
        parkingSpaceEntity122.setParkingRowEntity(parkingRowEntity12);
        ParkingSpaceEntity parkingSpaceEntity123 = new ParkingSpaceEntity();
        parkingSpaceEntity123.setParkingRowEntity(parkingRowEntity12);
        ParkingSpaceEntity parkingSpaceEntity211 = new ParkingSpaceEntity();
        parkingSpaceEntity211.setParkingRowEntity(parkingRowEntity21);
        ParkingSpaceEntity parkingSpaceEntity212 = new ParkingSpaceEntity();
        parkingSpaceEntity212.setParkingRowEntity(parkingRowEntity21);
        ParkingSpaceEntity parkingSpaceEntity213 = new ParkingSpaceEntity();
        parkingSpaceEntity213.setParkingRowEntity(parkingRowEntity21);
        ParkingSpaceEntity parkingSpaceEntity221 = new ParkingSpaceEntity();
        parkingSpaceEntity221.setParkingRowEntity(parkingRowEntity22);
        ParkingSpaceEntity parkingSpaceEntity222 = new ParkingSpaceEntity();
        parkingSpaceEntity222.setParkingRowEntity(parkingRowEntity22);
        ParkingSpaceEntity parkingSpaceEntity223 = new ParkingSpaceEntity();
        parkingSpaceEntity223.setParkingRowEntity(parkingRowEntity22);

        List<ParkingRowEntity> parkingRowsAtLevel1Entity = new ArrayList<>();
        parkingRowsAtLevel1Entity.add(parkingRowEntity11);
        parkingRowsAtLevel1Entity.add(parkingRowEntity12);
        levelEntity1.setParkingRowEntityList(parkingRowsAtLevel1Entity);

        List<ParkingRowEntity> parkingRowsAtLevel2Entity = new ArrayList<>();
        parkingRowsAtLevel2Entity.add(parkingRowEntity21);
        parkingRowsAtLevel2Entity.add(parkingRowEntity22);
        levelEntity2.setParkingRowEntityList(parkingRowsAtLevel2Entity);

        List<ParkingSpaceEntity> parkingSpacesInRow11Entity = new ArrayList<>();
        parkingSpacesInRow11Entity.add(parkingSpaceEntity111);
        parkingSpacesInRow11Entity.add(parkingSpaceEntity112);
        parkingSpacesInRow11Entity.add(parkingSpaceEntity113);
        parkingRowEntity11.setParkingSpaceEntityList(parkingSpacesInRow11Entity);


        List<ParkingSpaceEntity> parkingSpacesInRow12Entity = new ArrayList<>();
        parkingSpacesInRow12Entity.add(parkingSpaceEntity121);
        parkingSpacesInRow12Entity.add(parkingSpaceEntity122);
        parkingSpacesInRow12Entity.add(parkingSpaceEntity123);
        parkingRowEntity12.setParkingSpaceEntityList(parkingSpacesInRow12Entity);

        List<ParkingSpaceEntity> parkingSpacesInRow21Entity = new ArrayList<>();
        parkingSpacesInRow21Entity.add(parkingSpaceEntity211);
        parkingSpacesInRow21Entity.add(parkingSpaceEntity212);
        parkingSpacesInRow21Entity.add(parkingSpaceEntity213);
        parkingRowEntity21.setParkingSpaceEntityList(parkingSpacesInRow21Entity);

        List<ParkingSpaceEntity> parkingSpacesInRow22Entity = new ArrayList<>();
        parkingSpacesInRow22Entity.add(parkingSpaceEntity221);
        parkingSpacesInRow22Entity.add(parkingSpaceEntity222);
        parkingSpacesInRow22Entity.add(parkingSpaceEntity223);
        parkingRowEntity22.setParkingSpaceEntityList(parkingSpacesInRow22Entity);


        levelEntity1.setSize(parkingRowsAtLevel1Entity.size());
        levelEntity1.setStatus(true);
        levelEntity2.setSize(parkingRowsAtLevel2Entity.size());
        levelEntity2.setStatus(true);


        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(levelEntity1);
            session.save(levelEntity2);


            session.save(parkingRowEntity11);
            session.save(parkingRowEntity12);
            session.save(parkingRowEntity21);
            session.save(parkingRowEntity22);
            session.save(parkingSpaceEntity111);
            session.save(parkingSpaceEntity112);
            session.save(parkingSpaceEntity113);
            session.save(parkingSpaceEntity121);
            session.save(parkingSpaceEntity122);
            session.save(parkingSpaceEntity123);
            session.save(parkingSpaceEntity211);
            session.save(parkingSpaceEntity212);
            session.save(parkingSpaceEntity213);
            session.save(parkingSpaceEntity221);
            session.save(parkingSpaceEntity222);
            session.save(parkingSpaceEntity223);

            transaction.commit();
            System.out.println("DateBase Comp");
        }

    }
}
