package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "ai_recommend_rule", schema = "", catalog = "business_tailor_made")
public class AiRecommendRule {
    private int id;
    private String input;
    private String type;
    private String sort;
    private Byte sortLimit;

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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "sort")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "sort_limit")
    public Byte getSortLimit() {
        return sortLimit;
    }

    public void setSortLimit(Byte sortLimit) {
        this.sortLimit = sortLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AiRecommendRule that = (AiRecommendRule) o;

        if (id != that.id) return false;
        if (input != null ? !input.equals(that.input) : that.input != null) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;
        if (sortLimit != null ? !sortLimit.equals(that.sortLimit) : that.sortLimit != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (input != null ? input.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (sortLimit != null ? sortLimit.hashCode() : 0);
        return result;
    }
}
