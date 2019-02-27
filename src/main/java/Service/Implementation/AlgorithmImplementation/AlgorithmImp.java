package Service.Implementation.AlgorithmImplementation;


import Connection.Implementation.SessionUtil;
import Models.Level;
import Models.ParkingRow;
import Models.ParkingSpace;
import Service.Algorithm;
import org.hibernate.query.Query;

import java.util.List;


public class AlgorithmImp implements Algorithm {

    @Override
    public ParkingSpace getFreeParkingSpace() {
        List<ParkingSpace> parkingFreeSpace = null;
        int k = 0;
        List<Level> levelList = getListOfLevels();
        for (Level level : levelList) {
            List<ParkingRow> parkingRows = getListOfRowInFollowingLevel(level);
            for (ParkingRow parkingRow : parkingRows) {
                parkingFreeSpace = getFreeSpaceInFollowingRow(parkingRow);
                while (!parkingFreeSpace.get(k).isFree()) {
                    k++;
                }
            }
        }
        return parkingFreeSpace.get(k);
    }

    @Override
    public List getListOfLevels() {
        String hql = "FROM Level AS L";
        Query query = SessionUtil.getSession().createQuery(hql);
        return (List<Level>) query.getResultList();
    }

    @Override
    public List getListOfRowInFollowingLevel(Level level) {
        String hql = "From ParkingRow where level.id =" + level.getId();
        Query query = SessionUtil.getSession().createQuery(hql);
        return (List<ParkingRow>) query.getResultList();
    }

    @Override
    public List getFreeSpaceInFollowingRow(ParkingRow parkingRow) {
        String hql = "From ParkingSpace where ParkingRow.id = " + parkingRow.getId();
        Query query = SessionUtil.getSession().createQuery(hql);
        return (List<ParkingSpace>) query.getResultList();
    }


}
