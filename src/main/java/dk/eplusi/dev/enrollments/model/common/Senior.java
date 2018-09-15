package dk.eplusi.dev.enrollments.model.common;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_SENIOR)
@Table(name = Const.TABLE_NAME_SENIOR, catalog = Const.CATALOG_NAME_COMMON)
public class Senior {

    @Id
    @Column(name = "christian_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer christianId;

    public Senior() {
    }

    public Integer getChristianId() {
        return christianId;
    }

    public void setChristianId(Integer christianId) {
        this.christianId = christianId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Senior that = (Senior) o;

        return getChristianId() != null ? getChristianId().equals(that.getChristianId()) : that.getChristianId() == null;
    }

    @Override
    public int hashCode() {
        return getChristianId() != null ? getChristianId().hashCode() : 0;
    }
}
