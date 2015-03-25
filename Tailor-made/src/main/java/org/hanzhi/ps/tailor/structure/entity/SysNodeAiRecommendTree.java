package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "sys_node_ai_recommend_tree", schema = "", catalog = "business_tailor_made")
public class SysNodeAiRecommendTree {
    private int id;
    private Integer sysNodeId;
    private Integer aiRecommendTreeId;

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
    @Column(name = "sys_node_id", nullable = true, insertable = true, updatable = true)
    public Integer getSysNodeId() {
        return sysNodeId;
    }

    public void setSysNodeId(Integer sysNodeId) {
        this.sysNodeId = sysNodeId;
    }

    @Basic
    @Column(name = "ai_recommend_tree_id", nullable = true, insertable = true, updatable = true)
    public Integer getAiRecommendTreeId() {
        return aiRecommendTreeId;
    }

    public void setAiRecommendTreeId(Integer aiRecommendTreeId) {
        this.aiRecommendTreeId = aiRecommendTreeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysNodeAiRecommendTree that = (SysNodeAiRecommendTree) o;

        if (id != that.id) return false;
        if (aiRecommendTreeId != null ? !aiRecommendTreeId.equals(that.aiRecommendTreeId) : that.aiRecommendTreeId != null)
            return false;
        if (sysNodeId != null ? !sysNodeId.equals(that.sysNodeId) : that.sysNodeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sysNodeId != null ? sysNodeId.hashCode() : 0);
        result = 31 * result + (aiRecommendTreeId != null ? aiRecommendTreeId.hashCode() : 0);
        return result;
    }
}
