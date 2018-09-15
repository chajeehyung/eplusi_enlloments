package dk.eplusi.dev.enrollments.model.eplusi;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_PRAYER_NOTE)
@Table(name = Const.TABLE_NAME_PRAYER_NOTE, catalog = Const.CATALOG_NAME_EPLUSI)
public class PrayerNote {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Youth.class)
    @JoinColumn(name = "youth_id")
    private Youth youth;
    @Column(name = "prayer_date")
    @Temporal(TemporalType.DATE)
    private Date prayerDate;
    @Column(name = "prayer_note")
    private String prayerNote;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", insertable = false)
    private Date createTime;

    public PrayerNote() {
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

    public Date getPrayerDate() {
        return prayerDate;
    }

    public void setPrayerDate(Date prayerDate) {
        this.prayerDate = prayerDate;
    }

    public String getPrayerNote() {
        return prayerNote;
    }

    public void setPrayerNote(String prayerNote) {
        this.prayerNote = prayerNote;
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

        PrayerNote youth = (PrayerNote) o;

        return getId().equals(youth.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
