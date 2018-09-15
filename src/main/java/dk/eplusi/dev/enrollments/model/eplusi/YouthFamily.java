package dk.eplusi.dev.enrollments.model.eplusi;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_YOUTH_FAMILY)
@Table(name = Const.TABLE_NAME_YOUTH_FAMILY, catalog = Const.CATALOG_NAME_EPLUSI)
public class YouthFamily {

    @Id
    @Column(name = "youth_fam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer youthFamId;
    @ManyToOne(targetEntity = Youth.class)
    @JoinColumn(name = "youth_id")
    private Youth youth;
    @Column(name = "person_name")
    private String personName;
    @Column(name = "rel_type")
    private String relType;
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "update_time")
//    private Date updateTime;
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", insertable = false)
    private Date createTime;
    public YouthFamily() {
    }

    public Integer getYouthFamId() {
        return youthFamId;
    }

    public void setYouthFamId(Integer youthFamId) {
        this.youthFamId = youthFamId;
    }

    public Youth getYouth() {
        return youth;
    }

    public void setYouth(Youth youth) {
        this.youth = youth;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType;
    }

//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }

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

        YouthFamily youthOrg = (YouthFamily) o;

        return getYouthFamId().equals(youthOrg.getYouthFamId());
    }

    @Override
    public int hashCode() {
        return getYouthFamId().hashCode();
    }
}
