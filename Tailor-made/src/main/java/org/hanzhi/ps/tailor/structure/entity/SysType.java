package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "sys_type", schema = "", catalog = "business_tailor_made")
public class SysType {
    private int id;
    private String nameCn;
    private String nameEn;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysType sysType = (SysType) o;

        if (id != sysType.id) return false;
        if (nameCn != null ? !nameCn.equals(sysType.nameCn) : sysType.nameCn != null) return false;
        if (nameEn != null ? !nameEn.equals(sysType.nameEn) : sysType.nameEn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameCn != null ? nameCn.hashCode() : 0);
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
        return result;
    }
}
