package Models;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parkingrows")
public class ParkingRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ParkingRowId")
    private Long parkingRowId;
    @Column(name = "isFree")
    private Boolean status;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "parkingLevelId")
    private Level level;

    @OneToMany(mappedBy = "parkingRow", targetEntity = ParkingSpace.class)
    private List<ParkingSpace> parkingSpaceList;

    public ParkingRow() {
    }

    public ParkingRow(Long id, Boolean status) {
        this.parkingRowId = id;
        this.status = status;
    }

    public Long getId() {
        return parkingRowId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<ParkingSpace> getParkingSpaceList() {
        return parkingSpaceList;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void setParkingSpaceList(List<ParkingSpace> parkingSpaceList) {
        this.parkingSpaceList = parkingSpaceList;
    }
}
