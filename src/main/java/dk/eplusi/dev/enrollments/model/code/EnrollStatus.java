package dk.eplusi.dev.enrollments.model.code;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_ENROLL_STATUS)
@Table(name = Const.TABLE_NAME_ENROLL_STATUS, catalog = Const.CATALOG_NAME_CODE)
public class EnrollStatus {

    @Id
    @Column(name = "enroll_status_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollStatusCode;
    @Column(name = "enroll_status")
    private String enrollStatus;
    @Column(name = "enroll_desc")
    private String enrollDesc;

    public EnrollStatus() {
    }

    public Integer getEnrollStatusCode() {
        return enrollStatusCode;
    }

    public void setEnrollStatusCode(Integer enrollStatusCode) {
        this.enrollStatusCode = enrollStatusCode;
    }

    public String getEnrollStatus() {
        return enrollStatus;
    }

    public void setEnrollStatus(String enrollStatus) {
        this.enrollStatus = enrollStatus;
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

        EnrollStatus bizType = (EnrollStatus) o;

        return getEnrollStatusCode() != null ? getEnrollStatusCode().equals(bizType.getEnrollStatusCode()) : bizType.getEnrollStatusCode() == null;
    }

    @Override
    public int hashCode() {
        return getEnrollStatusCode() != null ? getEnrollStatusCode().hashCode() : 0;
    }
}
