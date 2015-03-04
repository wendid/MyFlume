package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "ai_recommend_tree", schema = "", catalog = "business_tailor_made")
public class AiRecommendTree {
    private int id;
    private String nameCn;
    private String nameEn;
    private Integer aiRecommendTreeId;
    private Byte level;
    private String hasChildren;
    private Timestamp cTime;

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

    @Basic
    @Column(name = "ai_recommend_tree_id", nullable = true, insertable = true, updatable = true)
    public Integer getAiRecommendTreeId() {
        return aiRecommendTreeId;
    }

    public void setAiRecommendTreeId(Integer aiRecommendTreeId) {
        this.aiRecommendTreeId = aiRecommendTreeId;
    }

    @Basic
    @Column(name = "level", nullable = true, insertable = true, updatable = true)
    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    @Basic
    @Column(name = "has_children", nullable = true, insertable = true, updatable = true, length = 5)
    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }

    @Basic
    @Column(name = "c_time", nullable = false, insertable = true, updatable = true)
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

        AiRecommendTree that = (AiRecommendTree) o;

        if (id != that.id) return false;
        if (aiRecommendTreeId != null ? !aiRecommendTreeId.equals(that.aiRecommendTreeId) : that.aiRecommendTreeId != null)
            return false;
        if (cTime != null ? !cTime.equals(that.cTime) : that.cTime != null) return false;
        if (hasChildren != null ? !hasChildren.equals(that.hasChildren) : that.hasChildren != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (nameCn != null ? !nameCn.equals(that.nameCn) : that.nameCn != null) return false;
        if (nameEn != null ? !nameEn.equals(that.nameEn) : that.nameEn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameCn != null ? nameCn.hashCode() : 0);
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
        result = 31 * result + (aiRecommendTreeId != null ? aiRecommendTreeId.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (hasChildren != null ? hasChildren.hashCode() : 0);
        result = 31 * result + (cTime != null ? cTime.hashCode() : 0);
        return result;
    }
}
