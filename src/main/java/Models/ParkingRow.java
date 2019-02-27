package Models;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parkingrows")
public class ParkingRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "id")
    private Long id;

    private Boolean status;

    @ManyToOne
    @NotNull
    private Level level; // a moze samo level id

    @OneToMany(mappedBy = "parkingRow", targetEntity = ParkingSpace.class)
    private List<ParkingSpace> parkingSpaceList;

    public ParkingRow() {
    }

    public ParkingRow(Long id, Boolean status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

//    public List<ParkingSpace> getParkingSpaceList() {
//        return parkingSpaceList;
//    }
//
//    public Level getLevel() {
//        return level;
//    }
//
//    public void setParkingSpaceList(List<ParkingSpace> parkingSpaceList) {
//        this.parkingSpaceList = parkingSpaceList;
//    }
}
