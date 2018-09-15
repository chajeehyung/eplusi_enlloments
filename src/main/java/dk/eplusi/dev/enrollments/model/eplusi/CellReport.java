package dk.eplusi.dev.enrollments.model.eplusi;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_CELL_REPORT)
@Table(name = Const.TABLE_NAME_CELL_REPORT, catalog = Const.CATALOG_NAME_EPLUSI)
public class CellReport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Youth.class)
    @JoinColumn(name = "cell_leader_id")
    private Youth cellLeader;
    @Column(name = "cell_summary")
    private String cellSummary;
    @Column(name = "cell_special")
    private String cellSpecial;
    @Column(name = "to_minister")
    private String toMinister;
    @Column(name = "to_leader")
    private String toLeader;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", insertable = false)
    private Date createTime;

    public CellReport() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Youth getCellLeader() {
        return cellLeader;
    }

    public void setCellLeader(Youth cellLeader) {
        this.cellLeader = cellLeader;
    }

    public String getCellSummary() {
        return cellSummary;
    }

    public void setCellSummary(String cellSummary) {
        this.cellSummary = cellSummary;
    }

    public String getCellSpecial() {
        return cellSpecial;
    }

    public void setCellSpecial(String cellSpecial) {
        this.cellSpecial = cellSpecial;
    }

    public String getToMinister() {
        return toMinister;
    }

    public void setToMinister(String toMinister) {
        this.toMinister = toMinister;
    }

    public String getToLeader() {
        return toLeader;
    }

    public void setToLeader(String toLeader) {
        this.toLeader = toLeader;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CellReport youth = (CellReport) o;

        return getId().equals(youth.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
