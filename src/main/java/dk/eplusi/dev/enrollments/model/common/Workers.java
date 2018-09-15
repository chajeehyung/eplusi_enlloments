package dk.eplusi.dev.enrollments.model.common;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_WORKERS)
@Table(name = Const.TABLE_NAME_WORKERS, catalog = Const.CATALOG_NAME_COMMON)
public class Workers {

    @Id
    @Column(name = "worker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workerId;

    public Workers() {
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workers that = (Workers) o;

        return getWorkerId() != null ? getWorkerId().equals(that.getWorkerId()) : that.getWorkerId() == null;
    }

    @Override
    public int hashCode() {
        return getWorkerId() != null ? getWorkerId().hashCode() : 0;
    }
}
