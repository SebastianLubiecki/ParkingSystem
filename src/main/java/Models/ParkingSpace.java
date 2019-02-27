package Models;

import javax.persistence.*;

@Entity
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,  name = "ParkingSpaceId")
    private Long parkingSpaceId;
    private VehicleSize size;
    @Column(name = "isFree")
    private boolean status;

    @ManyToOne
    private ParkingRow parkingRow;



    public ParkingSpace() {
    }

    public Long getId() {
        return parkingSpaceId;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void setSize(VehicleSize size) {
        this.size = size;
    }

    public boolean isFree() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ParkingRow getParkingRow() {
        return parkingRow;
    }

    public void setParkingRow(ParkingRow parkingRow) {
        this.parkingRow = parkingRow;
    }


}
