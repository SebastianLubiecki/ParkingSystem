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
        //declaration
        List<Level> levelList = getListOfLevels();
        List<ParkingSpace> parkingFreeSpace = null;



        //Search for free level
        int levelIndex = 0;
        while (levelList.get(levelIndex).equals(true)) {
            System.out.println(levelList.get(levelIndex));
            levelIndex++;
        }

        //Search for free row in founded level
        int RowIndex = 0;
        List<ParkingRow> parkingRowList = getListOfRowInFollowingLevel(levelList.get(levelIndex));
        while (parkingRowList.get(RowIndex).equals(true)) {
            System.out.println(parkingRowList.get(RowIndex).getStatus());
            RowIndex++;
        }
        //Search for free parking space
        int SpaceIndex = 0;
        List<ParkingSpace> parkingSpaces = getFreeSpaceInFollowingRow(parkingRowList.get(RowIndex));
        while (parkingSpaces.get(SpaceIndex).equals(true)) {
            System.out.println(parkingFreeSpace.get(SpaceIndex).isFree());
            SpaceIndex++;

        }
        System.out.println("Number of free space" + parkingFreeSpace.get(SpaceIndex));
        return parkingFreeSpace.get(SpaceIndex);
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
    public List getListOfRowInFollowingLevel(Level level) {
        try (Session session = SessionUtil.getSession()) {
            String hql = "From ParkingRow AS PR where PR.level =:"+level.getId();
            System.out.println("HQL in row:"+hql);
            Query<ParkingRow> query = session.createQuery(hql, ParkingRow.class);
         //   query.setParameter("status", level);
            return query.getResultList();

        }
    }

    @Override
    public List getFreeSpaceInFollowingRow(ParkingRow parkingRow) {
        try (Session session = SessionUtil.getSession()) {
            String hql = "From ParkingSpace where ParkingRow.ParkingRowId = :ParkingRowId " + parkingRow.getId();

            Query<ParkingSpace> query = session.createQuery(hql, ParkingSpace.class);
            query.setParameter("ParkingRowId", parkingRow.getId());
            return query.getResultList();
        }
    }

    public static void main(String[] args) {
        Algorithm algorithm = new AlgorithmImp();
        Level level = new Level();
        level.setParkingLevelId(2L);
        List list = algorithm.getListOfRowInFollowingLevel(level);

        for (Object o : list) {
            System.out.println(o);
        }
    }
}
