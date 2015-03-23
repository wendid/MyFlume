package org.hanzhi.ps.tailor.structure.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.hanzhi.ps.tailor.structure.model.easyui.Grid;
import org.hanzhi.ps.tailor.structure.model.easyui.Json;
import org.hanzhi.ps.tailor.structure.service.BaseServiceI;
import org.hanzhi.ps.tailor.util.BeanUtils;
import org.hanzhi.ps.tailor.util.FastjsonFilter;
import org.hanzhi.ps.tailor.util.HqlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hanzhi on 15-3-6.
 */
public class BaseController<T> {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected int pageNo = 1;// 当前页
    protected int pageSize = 25;// 每页显示记录数
    protected String sort;// 排序字段
    protected String order = "asc";// asc/desc
    protected String q;// easyui的combo和其子类过滤时使用

    protected String id;// 主键
    protected String ids;// 主键集合，逗号分割
    protected T data;// 数据模型(与前台表单name相同，name="data.xxx")

    protected BaseServiceI<T> service;// 业务逻辑

    protected String entity;
    protected String name;
    protected String value;

    public void setService(BaseServiceI<T> service) {
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 将对象转换成JSON字符串，并响应回前台
     *
     * @param object
     * @param includesProperties
     *            需要转换的属性
     * @param excludesProperties
     *            不需要转换的属性
     */
    public void writeJsonByFilter(Object object, String[] includesProperties, String[] excludesProperties) {
        try {
            FastjsonFilter filter = new FastjsonFilter();// excludes优先于includes
            if (excludesProperties != null && excludesProperties.length > 0) {
                filter.getExcludes().addAll(Arrays.<String> asList(excludesProperties));
            }
            if (includesProperties != null && includesProperties.length > 0) {
                filter.getIncludes().addAll(Arrays.<String> asList(includesProperties));
            }
            logger.info("对象转JSON：要排除的属性[" + excludesProperties + "]要包含的属性[" + includesProperties + "]");
            String json;
            String User_Agent = getRequest().getHeader("User-Agent");
            if (StringUtils.indexOfIgnoreCase(User_Agent, "MSIE 6") > -1) {
                // 使用SerializerFeature.BrowserCompatible特性会把所有的中文都会序列化为\\uXXXX这种格式，字节数会多一些，但是能兼容IE6
                json = JSON.toJSONString(object, filter, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.BrowserCompatible);
            } else {
                // 使用SerializerFeature.WriteDateUseDateFormat特性来序列化日期格式的类型为yyyy-MM-dd hh24:mi:ss
                // 使用SerializerFeature.DisableCircularReferenceDetect特性关闭引用检测和生成
                json = JSON.toJSONString(object, filter, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);
            }
            logger.info("转换后的JSON字符串：" + json);
            getResponse().setContentType("text/html;charset=utf-8");
            getResponse().getWriter().write(json);
            getResponse().getWriter().flush();
            getResponse().getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将对象转换成JSON字符串，并响应回前台
     *
     * @param object
     * @throws IOException
     */
    public void writeJson(Object object) {
        writeJsonByFilter(object, null, null);
    }

    /**
     * 将对象转换成JSON字符串，并响应回前台
     *
     * @param object
     * @param includesProperties
     *            需要转换的属性
     */
    public void writeJsonByIncludesProperties(Object object, String[] includesProperties) {
        writeJsonByFilter(object, includesProperties, null);
    }

    /**
     * 将对象转换成JSON字符串，并响应回前台
     *
     * @param object
     * @param excludesProperties
     *            不需要转换的属性
     */
    public void writeJsonByExcludesProperties(Object object, String[] excludesProperties) {
        writeJsonByFilter(object, null, excludesProperties);
    }

    /**
     * 获得request
     * 因为是struts2，所以注释掉
     * @return
     */
    public HttpServletRequest getRequest() {
        return  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        return ServletActionContext.getRequest();
    }

    /**
     * 获得response
     * 因为是struts2，所以注释掉
     * @return
     */
    public HttpServletResponse getResponse() {
        return  ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
//        return ServletActionContext.getResponse();
    }

    /**
     * 获得session
     * 因为是struts2，所以注释掉
     * @return
     */
    public HttpSession getSession() {
//        return ServletActionContext.getRequest().getSession();
        return getRequest().getSession();
    }

    /**
     * 获得一个对象
     */
    public void getById() {
        if (!StringUtils.isBlank(id)) {
            Json j = new Json();
            j.setSuccess(true);
            j.setData(service.getById(id));
            writeJson(j);
        } else {
            Json j = new Json();
            j.setSuccess(false);
            j.setMsg("主键不可为空！");
            writeJson(j);
        }
    }

    /**
     * 查找一批对象
     */
    public void find() {
        HqlFilter hqlFilter = new HqlFilter(getRequest());
        writeJson(service.findByFilter(hqlFilter, pageNo, pageSize));
    }

    /**
     * 查找所有对象
     */
    public void findAll() {
        HqlFilter hqlFilter = new HqlFilter(getRequest());
        writeJson(service.findByFilter(hqlFilter));
    }

    /**
     * 查找分页后的grid
     */
    public void grid() {
        Grid grid = new Grid();
        HqlFilter hqlFilter = new HqlFilter(getRequest());
        grid.setTotal(service.countByFilter(hqlFilter));
        grid.setRows(service.findByFilter(hqlFilter, pageNo, pageSize));
        writeJson(grid);
    }

    /**
     * 查找grid所有数据，不分页
     */
    public void gridAll() {
        Grid grid = new Grid();
        HqlFilter hqlFilter = new HqlFilter(getRequest());
        List<T> l = service.findByFilter(hqlFilter);
        grid.setTotal((long) l.size());
        grid.setRows(l);
        writeJson(grid);
    }

    /**
     * 获得treeGrid，treeGrid由于提供了pid的扩展，所以不分页
     */
    public void treeGrid() {
        HqlFilter hqlFilter = new HqlFilter(getRequest());
        writeJson(service.findByFilter(hqlFilter));
    }

    /**
     * 保存一个对象
     */
    public void save() {
        Json json = new Json();
        if (data != null) {
            service.save(data);
            json.setSuccess(true);
            json.setMsg("新建成功！");
        }
        writeJson(json);
    }

    /**
     * 更新一个对象
     */
    public void update() {
        Json json = new Json();
        String reflectId = null;
        try {
            if (data != null) {
                reflectId = (String) FieldUtils.readField(data, "id", true);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (!StringUtils.isBlank(reflectId)) {
            T t = service.getById(reflectId);
            BeanUtils.copyNotNullProperties(data, t, new String[]{"createdatetime"});
            service.update(t);
            json.setSuccess(true);
            json.setMsg("更新成功！");
        }
        writeJson(json);
    }

    /**
     * 删除一个对象
     */
    public void delete() {
        Json json = new Json();
        if (!StringUtils.isBlank(id)) {
            T t = service.getById(id);
            service.delete(t);
            json.setSuccess(true);
            json.setMsg("删除成功！");
        }
        writeJson(json);
    }
    public void checkIsUnique(){
        Json json = new Json();
        logger.info(entity+" " + name+" "+value);
        json.setSuccess(true);
        if(value.equals("admin"))
            json.setUnique(false);
        writeJson(json);
    }
}
