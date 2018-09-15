package dk.eplusi.dev.enrollments.model.common;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_WORKER_DUTY)
@Table(name = Const.TABLE_NAME_WORKER_DUTY, catalog = Const.CATALOG_NAME_COMMON)
public class WorkerDuty {

    @Id
    @Column(name = "worker_charge_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workerChargeId;
    @ManyToOne(targetEntity = Workers.class)
    @JoinColumn(name = "worker_id")
    private Workers workers;
    @ManyToOne(targetEntity = Organization.class)
    @JoinColumn(name = "org_code")
    private Organization organization;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public WorkerDuty() {
    }

    public Integer getWorkerChargeId() {
        return workerChargeId;
    }

    public void setWorkerChargeId(Integer workerChargeId) {
        this.workerChargeId = workerChargeId;
    }

    public Workers getWorkers() {
        return workers;
    }

    public void setWorkers(Workers workers) {
        this.workers = workers;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkerDuty that = (WorkerDuty) o;

        return getWorkerChargeId() != null ? getWorkerChargeId().equals(that.getWorkerChargeId()) : that.getWorkerChargeId() == null;
    }

    @Override
    public int hashCode() {
        return getWorkerChargeId() != null ? getWorkerChargeId().hashCode() : 0;
    }
}
