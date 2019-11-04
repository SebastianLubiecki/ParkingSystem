package Service.Implementation;

import Connection.Implementation.SessionUtil;
import Models.ParkingRowEntity;
import Models.ParkingSpaceEntity;
import Service.Interfaces.SpaceOperation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingSpaceImpl implements SpaceOperation {


    @Override
    public List<ParkingSpaceEntity> getListOfAllSPaces() {
        try (Session session = SessionUtil.getSession()) {
            String HQL = "FROM ParkingSpaceEntity as PS";
            Query<ParkingSpaceEntity> query = session.createQuery(HQL, ParkingSpaceEntity.class);
            return query.getResultList();
        }
    }

    @Override
    public List<ParkingSpaceEntity> getListOfSpacesInFollowingRow(ParkingRowEntity parkingRowEntity) { // mozna zrobic zapytanie ktore wyszuka tylko te space w bazie danych ktore maja row rowny temu z parametru
        SpaceOperation spaceOperation = new ParkingSpaceImpl();
        List<ParkingSpaceEntity> listOfAllParkingSpaceEntity = spaceOperation.getListOfAllSPaces();
        List<ParkingSpaceEntity> parkingSpaceEntityListInFollowingRow = listOfAllParkingSpaceEntity.stream()
                .filter(parkingSpaceEntity -> parkingSpaceEntity.getParkingRowEntity().getId().equals(parkingRowEntity.getId()))
                .collect(Collectors.toList());

        return parkingSpaceEntityListInFollowingRow;
    }

    @Override
    public ParkingSpaceEntity getFirstFreeSpaceInFollowingRow(ParkingRowEntity parkingRowEntity) {
        SpaceOperation spaceOperation = new ParkingSpaceImpl();
        List<ParkingSpaceEntity> spaceListInFollowingRow = spaceOperation.getListOfSpacesInFollowingRow(parkingRowEntity);
        int index = spaceListInFollowingRow.size() + 1;
        for (int i = 0; i < spaceListInFollowingRow.size(); i++) {
            if (spaceListInFollowingRow.get(i).isFree()) {
                index = i;
                break;
            }
        }
        if (index > spaceListInFollowingRow.size()) {
            System.out.println("Sth go wrong. Wrong implementation of Rows... And you want to be programmer of Java? Lol...");
        }
        return spaceListInFollowingRow.get(index);
    }

    @Override
    public void changeStatusOfTheSpace(ParkingSpaceEntity parkingSpaceEntity) {
        try (Session session = SessionUtil.getSession()) {
            if (parkingSpaceEntity.isFree()) {
                parkingSpaceEntity.setStatus(false);
            }
            if (!parkingSpaceEntity.isFree()) {
                parkingSpaceEntity.setStatus(true);
            }
            Transaction transaction = session.beginTransaction();
            session.save(parkingSpaceEntity);
            transaction.commit();
        }
    }
}
