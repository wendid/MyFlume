package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "ai_recommend_rule_input", schema = "", catalog = "business_tailor_made")
public class AiRecommendRuleInput {
    private int id;
    private String input;
    private String inputInfo;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "input")
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Basic
    @Column(name = "input_info")
    public String getInputInfo() {
        return inputInfo;
    }

    public void setInputInfo(String inputInfo) {
        this.inputInfo = inputInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AiRecommendRuleInput that = (AiRecommendRuleInput) o;

        if (id != that.id) return false;
        if (input != null ? !input.equals(that.input) : that.input != null) return false;
        if (inputInfo != null ? !inputInfo.equals(that.inputInfo) : that.inputInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (input != null ? input.hashCode() : 0);
        result = 31 * result + (inputInfo != null ? inputInfo.hashCode() : 0);
        return result;
    }
}
