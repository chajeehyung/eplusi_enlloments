package dk.eplusi.dev.enrollments.model.code;

import dk.eplusi.dev.enrollments.common.Const;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gyummy on 2018-03-06.
 *
 */
@Entity(name = Const.TABLE_NAME_BIZ_TYPE_KEYWORD)
@Table(name = Const.TABLE_NAME_BIZ_TYPE_KEYWORD, catalog = Const.CATALOG_NAME_CODE)
public class BizTypeKeyword {

    @Id
    @Column(name = "biz_kw_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bizKwCode;
    @Column(name = "biz_kw_name")
    private String bizKwName;
    @ManyToOne(targetEntity = BizType.class)
    @JoinColumn(name = "biz_type_code")
    private BizType bizType;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "create_time", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public BizTypeKeyword() {
    }

    public Integer getBizKwCode() {
        return bizKwCode;
    }

    public void setBizKwCode(Integer bizKwCode) {
        this.bizKwCode = bizKwCode;
    }

    public String getBizKwName() {
        return bizKwName;
    }

    public void setBizKwName(String bizKwName) {
        this.bizKwName = bizKwName;
    }

    public BizType getBizType() {
        return bizType;
    }

    public void setBizType(BizType bizType) {
        this.bizType = bizType;
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

        BizTypeKeyword bizType = (BizTypeKeyword) o;

        return getBizKwCode() != null ? getBizKwCode().equals(bizType.getBizKwCode()) : bizType.getBizKwCode() == null;
    }

    @Override
    public int hashCode() {
        return getBizKwCode() != null ? getBizKwCode().hashCode() : 0;
    }
}
