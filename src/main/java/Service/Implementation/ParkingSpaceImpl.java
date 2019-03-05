package Service.Implementation;

import Connection.Implementation.SessionUtil;
import Models.ParkingRow;
import Models.ParkingSpace;
import Service.Interfaces.SpaceOperation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingSpaceImpl implements SpaceOperation {


    @Override
    public List<ParkingSpace> getListOfAllSPaces() {
        try (Session session = SessionUtil.getSession()) {
            String HQL = "FROM ParkingSpace as PS";
            Query<ParkingSpace> query = session.createQuery(HQL, ParkingSpace.class);
            return query.getResultList();
        }
    }

    @Override
    public List<ParkingSpace> getListOfSpacesInFollowingRow(ParkingRow parkingRow) { // mozna zrobic zapytanie ktore wyszuka tylko te space w bazie danych ktore maja row rowny temu z parametru
        SpaceOperation spaceOperation = new ParkingSpaceImpl();
        List<ParkingSpace> listOfAllParkingSpace = spaceOperation.getListOfAllSPaces();
        List<ParkingSpace> parkingSpaceListInFollowingRow = listOfAllParkingSpace.stream()
                .filter(parkingSpace -> parkingSpace.getParkingRow().getId().equals(parkingRow.getId()))
                .collect(Collectors.toList());

        return parkingSpaceListInFollowingRow;
    }

    @Override
    public ParkingSpace getFirstFreeSpaceInFollowingRow(ParkingRow parkingRow) {
        SpaceOperation spaceOperation = new ParkingSpaceImpl();
        List<ParkingSpace> spaceListInFollowingRow = spaceOperation.getListOfSpacesInFollowingRow(parkingRow);
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
    public void changeStatusOfTheSpace(ParkingSpace parkingSpace) {
        try (Session session = SessionUtil.getSession()) {
            if (parkingSpace.isFree()) {
                parkingSpace.setStatus(false);
            }
            if (!parkingSpace.isFree()) {
                parkingSpace.setStatus(true);
            }
            Transaction transaction = session.beginTransaction();
            session.save(parkingSpace);
            transaction.commit();
        }
    }
}
