package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "sys_node", schema = "", catalog = "business_tailor_made")
public class SysNode {
    private int id;
    private String nameCn;
    private String nameEn;
    private String type;
    private String remark;
    private Timestamp cTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_cn")
    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    @Basic
    @Column(name = "name_en")
    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "c_time")
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

        SysNode sysNode = (SysNode) o;

        if (id != sysNode.id) return false;
        if (cTime != null ? !cTime.equals(sysNode.cTime) : sysNode.cTime != null) return false;
        if (nameCn != null ? !nameCn.equals(sysNode.nameCn) : sysNode.nameCn != null) return false;
        if (nameEn != null ? !nameEn.equals(sysNode.nameEn) : sysNode.nameEn != null) return false;
        if (remark != null ? !remark.equals(sysNode.remark) : sysNode.remark != null) return false;
        if (type != null ? !type.equals(sysNode.type) : sysNode.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameCn != null ? nameCn.hashCode() : 0);
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (cTime != null ? cTime.hashCode() : 0);
        return result;
    }
}
