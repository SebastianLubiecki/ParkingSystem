package Service.Implementation.ParkingImplementation;


import Connection.Implementation.SessionUtil;
import Models.ParkingSpace;
import Service.Implementation.AlgorithmImplementation.AlgorithmImp;
import Service.Interfaces.Algorithm;
import Service.Interfaces.Parking;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParkingImp implements Parking {
    @Override
    public void releaseParkingSpace(ParkingSpace parkingSpace) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            if (!parkingSpace.isFree()) {
                parkingSpace.setStatus(true);
            } else {
                try {
                    throw new Exception("Sth get wrong and parking space was free before machine gone");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            transaction.commit();
        }
    }

    @Override
    public void takeParkingSpace() {
        ParkingSpace parkingSpace;
        Algorithm algorithm = new AlgorithmImp();
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            parkingSpace = algorithm.getFreeParkingSpace();
            parkingSpace.setStatus(false);
            session.save(parkingSpace);
            transaction.commit();
        }

    }
}
