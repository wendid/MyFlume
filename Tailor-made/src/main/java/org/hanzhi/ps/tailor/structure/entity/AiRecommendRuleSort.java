package org.hanzhi.ps.tailor.structure.entity;

import javax.persistence.*;

/**
 * Created by hanzhi on 15-2-28.
 */
@Entity
@Table(name = "ai_recommend_rule_sort", schema = "", catalog = "business_tailor_made")
public class AiRecommendRuleSort {
    private int id;
    private String sort;
    private String sortInfo;

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
    @Column(name = "sort", nullable = true, insertable = true, updatable = true, length = 6)
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "sort_info", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSortInfo() {
        return sortInfo;
    }

    public void setSortInfo(String sortInfo) {
        this.sortInfo = sortInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AiRecommendRuleSort that = (AiRecommendRuleSort) o;

        if (id != that.id) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;
        if (sortInfo != null ? !sortInfo.equals(that.sortInfo) : that.sortInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (sortInfo != null ? sortInfo.hashCode() : 0);
        return result;
    }
}
