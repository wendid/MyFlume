package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by hanzhi on 15-4-10.
 */
@Entity
@Table(name = "sys_business_parts", schema = "", catalog = "business_tailor_made")
public class SysBusinessPart implements Serializable {
    private int id;
    private String nameCn;
    private String nameEn;
//    private Integer dbId;
    private String remark;
    private Timestamp cTime;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "db_id")
    public SysBusinessDb getSysBusinessDb() {
        return sysBusinessDb;
    }

    public void setSysBusinessDb(SysBusinessDb sysBusinessDb) {
        this.sysBusinessDb = sysBusinessDb;
    }

    private SysBusinessDb sysBusinessDb;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_cn", nullable = true, insertable = true, updatable = true, length = 60)
    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    @Basic
    @Column(name = "name_en", nullable = true, insertable = true, updatable = true, length = 60)
    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

//    @Basic
//    @Column(name = "db_id", nullable = true, insertable = true, updatable = true)
//    public Integer getDbId() {
//        return dbId;
//    }
//
//    public void setDbId(Integer dbId) {
//        this.dbId = dbId;
//    }

    @Basic
    @Column(name = "remark", insertable = true, updatable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "c_time",  insertable = true, updatable = true)
    public Timestamp getcTime() {
        return cTime;
    }

    public void setcTime(Timestamp cTime) {
        this.cTime = cTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysBusinessPart that = (SysBusinessPart) o;

        if (id != that.id) return false;
        if (cTime != null ? !cTime.equals(that.cTime) : that.cTime != null) return false;
//        if (dbId != null ? !dbId.equals(that.dbId) : that.dbId != null) return false;
        if (nameCn != null ? !nameCn.equals(that.nameCn) : that.nameCn != null) return false;
        if (nameEn != null ? !nameEn.equals(that.nameEn) : that.nameEn != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameCn != null ? nameCn.hashCode() : 0);
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
//        result = 31 * result + (dbId != null ? dbId.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (cTime != null ? cTime.hashCode() : 0);
        return result;
    }
}
