package Service.Implementation.ParkingImplementation;


import Connection.Implementation.SessionUtil;
import Service.Parking;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParkingImp implements Parking {
    @Override
    public void releaseParkingSpace() {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
           // ParkingSpace parkingSpace = session.get(ParkingSpace.class, );  ???
//            if (!parkingSpace.isFree()) {
//                parkingSpace.setStatus(true);
//            } else {
//                try {
//                    throw new Exception("Sth get wrong and parking space was free before machine gone");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            transaction.commit();
        }
    }

    @Override
    public void takeParkingSpace() {
//        ParkingSpace parkingSpace;
//        Algorithm algorithm = new AlgorithmImp();
//        try (Session session = ConnectionUnite.getSession()) {
//            Transaction transaction = session.beginTransaction();
//            parkingSpace = algorithm.getFreeParkingSpace();
//            parkingSpace.setVehicle(vehicle); // możliwe że odwrotnie
//            parkingSpace.setStatus(false);
//            session.save(parkingSpace);
//            transaction.commit();
//        }

    }
}
