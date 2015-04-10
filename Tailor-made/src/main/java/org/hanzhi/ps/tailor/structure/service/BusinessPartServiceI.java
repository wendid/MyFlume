package org.hanzhi.ps.tailor.structure.service;

import org.apache.poi.ss.formula.functions.T;
import org.hanzhi.ps.tailor.structure.entity.SysBusinessPart;

import java.util.List;

/**
 * Created by hanzhi on 15-4-10.
 */
public interface BusinessPartServiceI extends BaseServiceI<SysBusinessPart> {
    public List<SysBusinessPart> findByDBId(int db_id,int pageNo,int pageSize);
    public Long count(int db_id);
}
