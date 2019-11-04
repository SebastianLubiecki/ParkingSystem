package Service.Implementation;

import Connection.Implementation.SessionUtil;
import Models.LevelEntity;
import Models.ParkingRowEntity;
import Service.Interfaces.RowsOperation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingRowImpl implements RowsOperation {
    @Override
    public List<ParkingRowEntity> getListOfAllRows() {
        try (Session session = SessionUtil.getSession()) {
            String hql = "FROM ParkingRowEntity as PR";
            Query<ParkingRowEntity> query = session.createQuery(hql, ParkingRowEntity.class);
            return query.getResultList();
        }
    }

    @Override
    public List<ParkingRowEntity> getListOfRowInFollowingLevel(LevelEntity levelEntity) {
        RowsOperation rowsOperation = new ParkingRowImpl();
        List<ParkingRowEntity> parkingRowEntityList = rowsOperation.getListOfAllRows();
        List<ParkingRowEntity> parkingRowsInFollowingLevelEntity = parkingRowEntityList.stream()
                .filter(parkingRow -> parkingRow.getLevelEntity().getId().equals(levelEntity.getId()))
                .collect(Collectors.toList());
        return parkingRowsInFollowingLevelEntity;
    }

    @Override
    public ParkingRowEntity getFirstFreeRowInFollowingLevel(LevelEntity levelEntity) {
        RowsOperation rowsOperation = new ParkingRowImpl();
        List<ParkingRowEntity> parkingRowsInFollowingLevelEntity = rowsOperation.getListOfRowInFollowingLevel(levelEntity);

        int indexOfLevel = parkingRowsInFollowingLevelEntity.size() + 1;
        for (int i = 0; i < parkingRowsInFollowingLevelEntity.size(); i++) {
            if (parkingRowsInFollowingLevelEntity.get(i).getStatus()) {
                indexOfLevel = i;
            }
        }
        if (indexOfLevel > parkingRowsInFollowingLevelEntity.size()) {
            System.out.println("There is no free row in this levelEntity, you got mistake in your implementation of levelEntity status.");
            // rzuc wyjatkiem ale paczkiem nie wiem... Wymysl cos chOpie!
        }
        return parkingRowsInFollowingLevelEntity.get(indexOfLevel);
    }

    @Override
    public void changeStatusOfTheRow(ParkingRowEntity parkingRowEntity) {

        if (parkingRowEntity.getStatus()) {
            parkingRowEntity.setStatus(false);
        }
        if (!parkingRowEntity.getStatus()) {
            parkingRowEntity.setStatus(true);
        }
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(parkingRowEntity);
            transaction.commit();
        }
    }
}
