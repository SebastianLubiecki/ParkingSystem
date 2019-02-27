package Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parkinglevels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false, name = "parkingLevelId")
    private Long parkingLevelId;
    private int size;
    @Column(name = "isFree")
    private boolean status;

  @OneToMany(mappedBy = "level", targetEntity = ParkingRow.class)
  @JoinColumn(name = "parkingLevelId", insertable = false, updatable = false)
    private List<ParkingRow> parkingRowList;

    public Level() {
    }

    public Long getId() {
        return parkingLevelId;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   public List<ParkingRow> getParkingRowList() {
        return parkingRowList;
    }

    public void setParkingRowList(List<ParkingRow> parkingRowList) {
        this.parkingRowList = parkingRowList;
    }
}
