package dk.eplusi.dev.enrollments.model.eplusi;

import dk.eplusi.dev.enrollments.common.Const;
import dk.eplusi.dev.enrollments.model.code.EnrollStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_ENROLLMENTS)
@Table(name = Const.TABLE_NAME_ENROLLMENTS, catalog = Const.CATALOG_NAME_EPLUSI)
public class Enrollments {

    @Id
    @Column(name = "enroll_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enroll_id;
    @ManyToOne(targetEntity = Youth.class)
    @JoinColumn(name = "youth_id")
    private Youth youth;
    @ManyToOne(targetEntity = EnrollStatus.class)
    @JoinColumn(name = "enroll_status_code")
    private EnrollStatus enrollStatus;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "enroll_desc")
    private String enrollDesc;

    public Enrollments() {
    }

    public Integer getEnroll_id() {
        return enroll_id;
    }

    public void setEnroll_id(Integer enroll_id) {
        this.enroll_id = enroll_id;
    }

    public Youth getYouth() {
        return youth;
    }

    public void setYouth(Youth youth) {
        this.youth = youth;
    }

    public EnrollStatus getEnrollStatus() {
        return enrollStatus;
    }

    public void setEnrollStatus(EnrollStatus enrollStatus) {
        this.enrollStatus = enrollStatus;
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

    public String getEnrollDesc() {
        return enrollDesc;
    }

    public void setEnrollDesc(String enrollDesc) {
        this.enrollDesc = enrollDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enrollments youth = (Enrollments) o;

        return getEnroll_id().equals(youth.getEnroll_id());
    }

    @Override
    public int hashCode() {
        return getEnroll_id().hashCode();
    }
}
