package Models;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "parkingSpace")
@Proxy(lazy = false)
public class ParkingSpaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "ParkingSpaceId")
    private Long parkingSpaceId;

    @Column(name = "isFree")
    private boolean status;

    @ManyToOne
    private ParkingRowEntity parkingRowEntity;

    public ParkingRowEntity getParkingRowEntity() {
        return parkingRowEntity;
    }

    public void setParkingRowEntity(ParkingRowEntity parkingRowEntity) {
        this.parkingRowEntity = parkingRowEntity;
    }


    public ParkingSpaceEntity() {
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
        return "ParkingSpaceEntity{" +
                "parkingSpaceId=" + parkingSpaceId +
                ", status=" + status +
                ", parkingRowEntity=" + parkingRowEntity +
                '}';
    }
}
