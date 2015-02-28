package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "ai_recommend_object", schema = "", catalog = "business_tailor_made")
public class AiRecommendObject {
    private int id;
    private String nameCn;
    private String nameEn;
    private Integer parentId;
    private Integer aiRecommendProjectId;
    private Byte levelNum;
    private String hasChildren;
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
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "ai_recommend_project_id")
    public Integer getAiRecommendProjectId() {
        return aiRecommendProjectId;
    }

    public void setAiRecommendProjectId(Integer aiRecommendProjectId) {
        this.aiRecommendProjectId = aiRecommendProjectId;
    }

    @Basic
    @Column(name = "level_num")
    public Byte getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(Byte levelNum) {
        this.levelNum = levelNum;
    }

    @Basic
    @Column(name = "has_children")
    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
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

        AiRecommendObject that = (AiRecommendObject) o;

        if (id != that.id) return false;
        if (aiRecommendProjectId != null ? !aiRecommendProjectId.equals(that.aiRecommendProjectId) : that.aiRecommendProjectId != null)
            return false;
        if (cTime != null ? !cTime.equals(that.cTime) : that.cTime != null) return false;
        if (hasChildren != null ? !hasChildren.equals(that.hasChildren) : that.hasChildren != null) return false;
        if (levelNum != null ? !levelNum.equals(that.levelNum) : that.levelNum != null) return false;
        if (nameCn != null ? !nameCn.equals(that.nameCn) : that.nameCn != null) return false;
        if (nameEn != null ? !nameEn.equals(that.nameEn) : that.nameEn != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameCn != null ? nameCn.hashCode() : 0);
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (aiRecommendProjectId != null ? aiRecommendProjectId.hashCode() : 0);
        result = 31 * result + (levelNum != null ? levelNum.hashCode() : 0);
        result = 31 * result + (hasChildren != null ? hasChildren.hashCode() : 0);
        result = 31 * result + (cTime != null ? cTime.hashCode() : 0);
        return result;
    }
}
