package org.hanzhi.ps.tailor.structure.controller;

import org.apache.poi.ss.formula.functions.T;
import org.hanzhi.ps.tailor.structure.entity.SysBusinessDb;
import org.hanzhi.ps.tailor.structure.service.BaseServiceI;
import org.hanzhi.ps.tailor.structure.service.BusinessDBServiceI;
import org.hanzhi.ps.tailor.structure.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/businessdb")
public class BusinessDBController extends BaseController<SysBusinessDb> {

    private final static Logger logger = LoggerFactory.getLogger(BusinessDBController.class);


    @Autowired
    private BaseServiceI<SysBusinessDb> businessDBService;
//    protected BaseServiceI<T> businessDBService;// 业务逻辑



    //展示所有业务库页面，并且可以进行管理，crud
//    @RequestMapping(value = "/showdb", method = RequestMethod.GET)

//    public @ResponseBody String showDB(@PathVariable String foo) {   //这种方式也可以，但只可以String
//    @RequestMapping(value = "/showdb/{id}", method = RequestMethod.GET)
//    public @ResponseBody Long showDB(@PathVariable("id") Long id) {
    @RequestMapping(value = "/showdb", method = RequestMethod.GET)
    public @ResponseBody List<SysBusinessDb> showDB(@RequestParam(value="foo") int foo) {

        List<SysBusinessDb> list = businessDBService.find(0,10);
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("message", foo);
//        mv.setViewName("user/users");
        return list;
    }

    //增加业务库
    @RequestMapping(value = "/adddb", method = RequestMethod.GET)
    public @ResponseBody List<SysBusinessDb> addDB() {
        SysBusinessDb sb = new SysBusinessDb();
        sb.setNameCn("haha");
        sb.setcTime(Timestamp.valueOf("2014-03-04 11:12:13"));
        sb.setNameEn("11");
        sb.setRemark("dfdfdf");
        sb.setTypeId(1);
        Serializable s = businessDBService.save(sb);
//        List<SysBusinessDb> list = businessDBService.find(0,10);
        return null;
    }

    //点击单个业务库展开，并显示其下的节点
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public String findNodesById() {

        return "user/main";
    }
}


