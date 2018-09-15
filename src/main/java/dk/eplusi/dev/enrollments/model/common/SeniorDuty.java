package dk.eplusi.dev.enrollments.model.common;

import dk.eplusi.dev.enrollments.common.Const;
import dk.eplusi.dev.enrollments.model.code.RoleType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_SENIOR_DUTY)
@Table(name = Const.TABLE_NAME_SENIOR_DUTY, catalog = Const.CATALOG_NAME_COMMON)
public class SeniorDuty {

    @Id
    @Column(name = "christia_charge_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer christianChargeId;
    @ManyToOne(targetEntity = Organization.class)
    @JoinColumn(name = "org_code")
    private Organization organization;
    @Column(name = "charge_id")
    private Integer chargeId;
    @ManyToOne(targetEntity = RoleType.class)
    @JoinColumn(name = "role_code")
    private RoleType roleType;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public SeniorDuty() {
    }

    public Integer getChristianChargeId() {
        return christianChargeId;
    }

    public void setChristianChargeId(Integer christianChargeId) {
        this.christianChargeId = christianChargeId;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
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

        SeniorDuty that = (SeniorDuty) o;

        return getChristianChargeId() != null ? getChristianChargeId().equals(that.getChristianChargeId()) : that.getChristianChargeId() == null;
    }

    @Override
    public int hashCode() {
        return getChristianChargeId() != null ? getChristianChargeId().hashCode() : 0;
    }
}
