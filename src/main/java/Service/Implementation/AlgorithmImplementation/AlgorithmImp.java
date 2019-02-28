package Service.Implementation.AlgorithmImplementation;


import Connection.Implementation.SessionUtil;
import Models.Level;
import Models.ParkingRow;
import Models.ParkingSpace;
import Service.Interfaces.Algorithm;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class AlgorithmImp implements Algorithm {

    @Override
    public ParkingSpace getFreeParkingSpace() {// method to change to few smaller method

//        //Search for free row in founded level
//        int RowIndex = 0;
//        List<ParkingRow> parkingRowList = getListOfRowInFollowingLevel(levelList.get(levelIndex));
//        while (parkingRowList.get(RowIndex).getStatus() && RowIndex<parkingRowList.size()) {
//            System.out.println(parkingRowList.get(RowIndex).getStatus());
//            RowIndex++;
//        }
//        //Search for free parking space
//        int SpaceIndex = 0;
//        List<ParkingSpace> parkingSpaces = getListOfSPacesInFollowingRow(parkingRowList.get(RowIndex));
//        while (parkingSpaces.get(SpaceIndex).isFree()) {
//            System.out.println(parkingFreeSpace.get(SpaceIndex).isFree());
//            SpaceIndex++;
//
//        }
//        System.out.println("Number of free space" + parkingFreeSpace.get(SpaceIndex));
//        return parkingFreeSpace.get(SpaceIndex);

        return null;
    }

    @Override
    public List getListOfLevels() {
        try (Session session = SessionUtil.getSession()) {
            String hql = "FROM Level AS L";
            Query<Level> query = session.createQuery(hql, Level.class);
            return query.getResultList();
        }
    }

    @Override
    public List getListOfRow() {
        try (Session session = SessionUtil.getSession()) {
            String hql = "From ParkingRow";
            Query<ParkingRow> query = session.createQuery(hql, ParkingRow.class);
            return query.getResultList();
        }
    }

    @Override
    public List getParkingSpace() {
        try (Session session = SessionUtil.getSession()) {
            String hql = "From ParkingSpace";
            Query<ParkingSpace> query = session.createQuery(hql, ParkingSpace.class);
            return query.getResultList();
        }
    }


    @Override
    public Level getFirstFreeLevel() {
        List<Level> levelList = getListOfLevels();
        int levelIndex = 0;
        while (levelList.get(levelIndex).equals(true)) {
            System.out.println(levelList.get(levelIndex));
            levelIndex++;
        }
        return levelList.get(levelIndex);
    }

    @Override
    public ParkingRow getFirstFreeParkingRow(Level level) {
        List<ParkingRow> parkingListOfAllRow = getListOfRow();

        int rowIndex = 0;
        while (parkingListOfAllRow.get(rowIndex).equals(true)) {
            System.out.println(parkingListOfAllRow.get(rowIndex));
            rowIndex++;
        }
        return parkingListOfAllRow.get(rowIndex);
    }

    @Override
    public ParkingSpace getFirstFreeParkingSpace(ParkingRow parkingRow) {
        List<ParkingSpace> listOfAllParkingSpace = getParkingSpace();

        int spaceIndex = 0;
        while (listOfAllParkingSpace.get(spaceIndex).isFree()) {
            System.out.println(listOfAllParkingSpace.get(spaceIndex));
            spaceIndex++;
        }
        return listOfAllParkingSpace.get(spaceIndex);
    }


    public static void main(String[] args) {
        Algorithm algorithm = new AlgorithmImp();

    }
}
