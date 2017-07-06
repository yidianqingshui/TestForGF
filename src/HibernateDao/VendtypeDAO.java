package HibernateDao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Vendtype.
 * 
 * @see HibernateDao.Vendtype
 * @author MyEclipse Persistence Tools
 */

public class VendtypeDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(VendtypeDAO.class);

	// property constants
	public static final String VENDTYPE_DESC = "vendtypeDesc";

	public void save(Vendtype transientInstance) {
		log.debug("saving Vendtype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vendtype persistentInstance) {
		log.debug("deleting Vendtype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vendtype findById(java.lang.String id) {
		log.debug("getting Vendtype instance with id: " + id);
		try {
			Vendtype instance = (Vendtype) getSession().get(
					"HibernateDao.Vendtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vendtype instance) {
		log.debug("finding Vendtype instance by example");
		try {
			List results = getSession().createCriteria("HibernateDao.Vendtype")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Vendtype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Vendtype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVendtypeDesc(Object vendtypeDesc) {
		return findByProperty(VENDTYPE_DESC, vendtypeDesc);
	}

	public List findAll() {
		log.debug("finding all Vendtype instances");
		try {
			String queryString = "from Vendtype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vendtype merge(Vendtype detachedInstance) {
		log.debug("merging Vendtype instance");
		try {
			Vendtype result = (Vendtype) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vendtype instance) {
		log.debug("attaching dirty Vendtype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vendtype instance) {
		log.debug("attaching clean Vendtype instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}