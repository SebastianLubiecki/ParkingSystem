package Models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.lang.annotation.Documented;
import java.util.List;

@Entity
@Table(name = "parkinglevels")
@Proxy(lazy = false)
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "parkingLevelId")
    private Long parkingLevelId;

    @Column(name = "size")
    private int size;

    @Column(name = "isFree")
    private boolean status;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<ParkingRow> parkingRowList;

    public Level() {
    }

    public Long getId() {
        return parkingLevelId;
    }

    public void setParkingLevelId(Long parkingLevelId) {
        this.parkingLevelId = parkingLevelId;
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

    @Override
    public String toString() {
        return "Level{" +
                "parkingLevelId=" + parkingLevelId +
                ", size=" + size +
                ", status=" + status +
                '}';
    }
}
