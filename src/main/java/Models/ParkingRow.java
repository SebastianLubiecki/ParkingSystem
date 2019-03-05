package Models;


import com.sun.istack.internal.NotNull;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parkingrows")
@Proxy(lazy = false)
public class ParkingRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ParkingRowId")
    private Long parkingRowId;
    @Column(name = "isFree", columnDefinition = "Boolean default true")
       private Boolean status;

    @ManyToOne
    private Level level;

    @OneToMany(mappedBy = "parkingRow", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<ParkingSpace> parkingSpaceList;

    public ParkingRow() {
    }

    public ParkingRow(Long id, Boolean status) {
        this.parkingRowId = id;
        this.status = status;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
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

    public void setParkingSpaceList(List<ParkingSpace> parkingSpaceList) {
        this.parkingSpaceList = parkingSpaceList;
    }

    @Override
    public String toString() {
        return "ParkingRow{" +
                "parkingRowId=" + parkingRowId +
                ", status=" + status +
                ", level=" + level +
                '}';
    }
}
