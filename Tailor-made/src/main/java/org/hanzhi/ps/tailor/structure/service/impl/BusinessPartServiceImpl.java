package org.hanzhi.ps.tailor.structure.service.impl;

import org.hanzhi.ps.tailor.structure.entity.SysBusinessPart;
import org.hanzhi.ps.tailor.structure.service.BusinessPartServiceI;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hanzhi on 15-4-10.
 */
@Service
public class BusinessPartServiceImpl extends BaseServiceImpl<SysBusinessPart> implements BusinessPartServiceI  {

    @Override
    public List<SysBusinessPart> findByDBId(int db_id, int pageNo, int pageSize) {
        return find(" from SysBusinessPart where db_id='"+db_id+"' order by id desc ", pageNo, pageSize);
    }

    @Override
    public Long count(int db_id) {
        return count("select count(*) from SysBusinessPart where db_id='"+db_id+"' ");
    }

}
