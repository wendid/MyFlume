package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "ai_recommend_object1_object2", schema = "", catalog = "business_tailor_made")
public class AiRecommendObject1Object2 {
    private int id;
    private Integer aiRecommendObjectId1;
    private Integer aiRecommendObjectId2;
    private Integer aiRecommendRuleId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ai_recommend_object_id1", nullable = true, insertable = true, updatable = true)
    public Integer getAiRecommendObjectId1() {
        return aiRecommendObjectId1;
    }

    public void setAiRecommendObjectId1(Integer aiRecommendObjectId1) {
        this.aiRecommendObjectId1 = aiRecommendObjectId1;
    }

    @Basic
    @Column(name = "ai_recommend_object_id2", nullable = true, insertable = true, updatable = true)
    public Integer getAiRecommendObjectId2() {
        return aiRecommendObjectId2;
    }

    public void setAiRecommendObjectId2(Integer aiRecommendObjectId2) {
        this.aiRecommendObjectId2 = aiRecommendObjectId2;
    }

    @Basic
    @Column(name = "ai_recommend_rule_id", nullable = true, insertable = true, updatable = true)
    public Integer getAiRecommendRuleId() {
        return aiRecommendRuleId;
    }

    public void setAiRecommendRuleId(Integer aiRecommendRuleId) {
        this.aiRecommendRuleId = aiRecommendRuleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AiRecommendObject1Object2 that = (AiRecommendObject1Object2) o;

        if (id != that.id) return false;
        if (aiRecommendObjectId1 != null ? !aiRecommendObjectId1.equals(that.aiRecommendObjectId1) : that.aiRecommendObjectId1 != null)
            return false;
        if (aiRecommendObjectId2 != null ? !aiRecommendObjectId2.equals(that.aiRecommendObjectId2) : that.aiRecommendObjectId2 != null)
            return false;
        if (aiRecommendRuleId != null ? !aiRecommendRuleId.equals(that.aiRecommendRuleId) : that.aiRecommendRuleId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (aiRecommendObjectId1 != null ? aiRecommendObjectId1.hashCode() : 0);
        result = 31 * result + (aiRecommendObjectId2 != null ? aiRecommendObjectId2.hashCode() : 0);
        result = 31 * result + (aiRecommendRuleId != null ? aiRecommendRuleId.hashCode() : 0);
        return result;
    }
}
