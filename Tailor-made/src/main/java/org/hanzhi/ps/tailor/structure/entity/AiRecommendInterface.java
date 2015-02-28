package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "ai_recommend_interface", schema = "", catalog = "business_tailor_made")
public class AiRecommendInterface {
    private int id;
    private String info;
    private int aiRecommendRuleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "ai_recommend_rule_id")
    public int getAiRecommendRuleId() {
        return aiRecommendRuleId;
    }

    public void setAiRecommendRuleId(int aiRecommendRuleId) {
        this.aiRecommendRuleId = aiRecommendRuleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AiRecommendInterface that = (AiRecommendInterface) o;

        if (aiRecommendRuleId != that.aiRecommendRuleId) return false;
        if (id != that.id) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + aiRecommendRuleId;
        return result;
    }
}
