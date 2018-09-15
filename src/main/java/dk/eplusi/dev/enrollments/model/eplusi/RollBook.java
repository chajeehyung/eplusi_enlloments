package dk.eplusi.dev.enrollments.model.eplusi;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_ROLL_BOOK)
@Table(name = Const.TABLE_NAME_ROLL_BOOK, catalog = Const.CATALOG_NAME_EPLUSI)
public class RollBook {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Youth.class)
    @JoinColumn(name = "youth_id")
    private Youth youth;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "att_date")
    private Date attDate;
    @Column(name = "worship_att")
    private Integer worshipAtt;
    @Column(name = "cell_att")
    private Integer cellAtt;
    @Column(name = "att_desc")
    private String attDesc;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", insertable = false)
    private Date createTime;

    public RollBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Youth getYouth() {
        return youth;
    }

    public void setYouth(Youth youth) {
        this.youth = youth;
    }

    public Date getAttDate() {
        return attDate;
    }

    public void setAttDate(Date attDate) {
        this.attDate = attDate;
    }

    public Integer getWorshipAtt() {
        return worshipAtt;
    }

    public void setWorshipAtt(Integer worshipAtt) {
        this.worshipAtt = worshipAtt;
    }

    public Integer getCellAtt() {
        return cellAtt;
    }

    public void setCellAtt(Integer cellAtt) {
        this.cellAtt = cellAtt;
    }

    public String getAttDesc() {
        return attDesc;
    }

    public void setAttDesc(String attDesc) {
        this.attDesc = attDesc;
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

        RollBook youth = (RollBook) o;

        return getId().equals(youth.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
