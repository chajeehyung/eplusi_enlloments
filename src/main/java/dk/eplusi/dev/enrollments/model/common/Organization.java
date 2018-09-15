package dk.eplusi.dev.enrollments.model.common;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_ORGANIZATION)
@Table(name = Const.TABLE_NAME_ORGANIZATION, catalog = Const.CATALOG_NAME_COMMON)
public class Organization {

    @Id
    @Column(name = "org_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orgCode;
    @Column(name = "parent_code")
    private Integer parentCode;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "applied_year")
    private Integer appliedYear;

    public Organization() {
    }

    public Integer getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(Integer orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getParentCode() {
        return parentCode;
    }

    public void setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getAppliedYear() {
        return appliedYear;
    }

    public void setAppliedYear(Integer appliedYear) {
        this.appliedYear = appliedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        return getOrgCode() != null ? getOrgCode().equals(that.getOrgCode()) : that.getOrgCode() == null;
    }

    @Override
    public int hashCode() {
        return getOrgCode() != null ? getOrgCode().hashCode() : 0;
    }
}
