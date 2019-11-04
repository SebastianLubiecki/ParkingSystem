package Models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "parkinglevels")
@Proxy(lazy = false)
public class LevelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "parkingLevelId")
    private Long parkingLevelId;

    @Column(name = "size")
    private int size;

    @Column(name = "isFree")
    private boolean status;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<ParkingRowEntity> parkingRowEntityList;

    public LevelEntity() {
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

    public List<ParkingRowEntity> getParkingRowEntityList() {
        return parkingRowEntityList;
    }

    public void setParkingRowEntityList(List<ParkingRowEntity> parkingRowEntityList) {
        this.parkingRowEntityList = parkingRowEntityList;
    }

    @Override
    public String toString() {
        return "LevelEntity{" +
                "parkingLevelId=" + parkingLevelId +
                ", size=" + size +
                ", status=" + status +
                '}';
    }
}
