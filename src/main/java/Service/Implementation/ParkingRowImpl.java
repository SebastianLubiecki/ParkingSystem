package Service.Implementation;

import Connection.Implementation.SessionUtil;
import Models.Level;
import Models.ParkingRow;
import Service.Interfaces.RowsOperation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingRowImpl implements RowsOperation {
    @Override
    public List<ParkingRow> getListOfAllRows() {
        try (Session session = SessionUtil.getSession()) {
            String hql = "FROM ParkingRow as PR";
            Query<ParkingRow> query = session.createQuery(hql, ParkingRow.class);
            return query.getResultList();
        }
    }

    @Override
    public List<ParkingRow> getListOfRowInFollowingLevel(Level level) {
        RowsOperation rowsOperation = new ParkingRowImpl();
        List<ParkingRow> parkingRowList = rowsOperation.getListOfAllRows();
        List<ParkingRow> parkingRowsInFollowingLevel = parkingRowList.stream()
                .filter(parkingRow -> parkingRow.getLevel().getId().equals(level.getId()))
                .collect(Collectors.toList());
        return parkingRowsInFollowingLevel;
    }

    @Override
    public ParkingRow getFirstFreeRowInFollowingLevel(Level level) {
        RowsOperation rowsOperation = new ParkingRowImpl();
        List<ParkingRow> parkingRowsInFollowingLevel = rowsOperation.getListOfRowInFollowingLevel(level);

        int indexOfLevel = parkingRowsInFollowingLevel.size() + 1;
        for (int i = 0; i < parkingRowsInFollowingLevel.size(); i++) {
            if (parkingRowsInFollowingLevel.get(i).getStatus()) {
                indexOfLevel = i;
            }
        }
        if (indexOfLevel > parkingRowsInFollowingLevel.size()) {
            System.out.println("There is no free row in this level, you got mistake in your implementation of level status.");
            // rzuc wyjatkiem ale paczkiem nie wiem... Wymysl cos chOpie!
        }
        return parkingRowsInFollowingLevel.get(indexOfLevel);
    }

    @Override
    public void changeStatusOfTheRow(ParkingRow parkingRow) {

        if (parkingRow.getStatus()) {
            parkingRow.setStatus(false);
        }
        if (!parkingRow.getStatus()) {
            parkingRow.setStatus(true);
        }
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(parkingRow);
            transaction.commit();
        }
    }
}
