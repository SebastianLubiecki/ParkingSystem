package Models;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parkingrows")
@Proxy(lazy = false)
public class ParkingRowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "ParkingRowId")
    private Long parkingRowId;
    @Column(name = "isFree", columnDefinition = "Boolean default true")
    private Boolean status;

    @ManyToOne
    private LevelEntity levelEntity;

    @OneToMany(mappedBy = "parkingRow", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<ParkingSpaceEntity> parkingSpaceEntityList;

    public ParkingRowEntity() {
    }

    public ParkingRowEntity(Long id, Boolean status) {
        this.parkingRowId = id;
        this.status = status;
    }

    public LevelEntity getLevelEntity() {
        return levelEntity;
    }

    public void setLevelEntity(LevelEntity levelEntity) {
        this.levelEntity = levelEntity;
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

    public List<ParkingSpaceEntity> getParkingSpaceEntityList() {
        return parkingSpaceEntityList;
    }

    public void setParkingSpaceEntityList(List<ParkingSpaceEntity> parkingSpaceEntityList) {
        this.parkingSpaceEntityList = parkingSpaceEntityList;
    }

    @Override
    public String toString() {
        return "ParkingRowEntity{" +
                "parkingRowId=" + parkingRowId +
                ", status=" + status +
                ", levelEntity=" + levelEntity +
                '}';
    }
}
