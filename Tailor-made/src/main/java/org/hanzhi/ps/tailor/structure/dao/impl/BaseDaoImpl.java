package org.hanzhi.ps.tailor.structure.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hanzhi.ps.tailor.structure.dao.BaseDaoI;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BaseDaoImpl<T> implements BaseDaoI<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session = null;
	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
//		return sessionFactory.openSession();
		return sessionFactory.getCurrentSession();
	}

	public Serializable save(T o) {
		if (o != null) {
			this.session = getCurrentSession();
			try {
//			return getCurrentSession().save(o);
			session.save(o);
//			session.flush();
			flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				session.clear();
				session.close();
				return  null;
			}
		}
		return null;
	}

	private void dispose()
	{
		this.session.clear();
		this.session.close();
	}

	private void flush()
	{
		this.session.flush();
	}

	public T getById(Class<T> c, Serializable id) {
		return (T) getCurrentSession().get(c, id);
	}

	public T getByHql(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	public T getByHql(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	public void delete(T o) {
		if (o != null) {
//			getCurrentSession().delete(o);
			try {
//			return getCurrentSession().save(o);
			this.session.delete(o);
//			session.flush();
				flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				dispose();
			}
		}
	}

	public void update(T o) {
		if (o != null) {
//			getCurrentSession().update(o);
			try {
//			return getCurrentSession().save(o);
				this.session.update(o);
//			session.flush();
				flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				dispose();
			}
		}
	}

	public void saveOrUpdate(T o) {
		if (o != null) {
//			getCurrentSession().saveOrUpdate(o);
			try {
//			return getCurrentSession().save(o);
				this.session.saveOrUpdate(o);
//			session.flush();
				flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				dispose();
			}
		}
	}

	public List<T> find(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return q.list();
	}

	public List<T> find(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	public List<T> find(String hql, Map<String, Object> params, int pageNo, int pageSize) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}

	public List<T> find(String hql, int pageNo, int pageSize) {
		Query q = getCurrentSession().createQuery(hql);
		return q.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}

	public Long count(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}

	public Long count(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	public int executeHql(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	public int executeHql(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	public List<Map> findBySql(String sql) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	public List<Map> findBySql(String sql, int pageNo, int pageSize) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return q.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	public List<Map> findBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	public List<Map> findBySql(String sql, Map<String, Object> params, int pageNo, int pageSize) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	public int executeSql(String sql) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	public BigInteger countBySql(String sql) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return (BigInteger) q.uniqueResult();
	}

	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (BigInteger) q.uniqueResult();
	}

}
