package Models;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "parkingSpace")
@Proxy(lazy = false)
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ParkingSpaceId")
    private Long parkingSpaceId;

    @Column(name = "isFree")
    private boolean status;

    @ManyToOne
    private ParkingRow parkingRow;

    public ParkingRow getParkingRow() {
        return parkingRow;
    }

    public void setParkingRow(ParkingRow parkingRow) {
        this.parkingRow = parkingRow;
    }


    public ParkingSpace() {
    }

    public Long getId() {
        return parkingSpaceId;
    }

    public boolean isFree() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "parkingSpaceId=" + parkingSpaceId +
                ", status=" + status +
                ", parkingRow=" + parkingRow +
                '}';
    }
}
