package HibernateDao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Stockreason.
 * 
 * @see HibernateDao.Stockreason
 * @author MyEclipse Persistence Tools
 */

public class StockreasonDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(StockreasonDAO.class);

	// property constants
	public static final String REA_DESC = "reaDesc";

	public void save(Stockreason transientInstance) {
		log.debug("saving Stockreason instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Stockreason persistentInstance) {
		log.debug("deleting Stockreason instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Stockreason findById(java.lang.String id) {
		log.debug("getting Stockreason instance with id: " + id);
		try {
			Stockreason instance = (Stockreason) getSession().get(
					"HibernateDao.Stockreason", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Stockreason instance) {
		log.debug("finding Stockreason instance by example");
		try {
			List results = getSession().createCriteria(
					"HibernateDao.Stockreason").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Stockreason instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Stockreason as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByReaDesc(Object reaDesc) {
		return findByProperty(REA_DESC, reaDesc);
	}

	public List findAll() {
		log.debug("finding all Stockreason instances");
		try {
			String queryString = "from Stockreason";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Stockreason merge(Stockreason detachedInstance) {
		log.debug("merging Stockreason instance");
		try {
			Stockreason result = (Stockreason) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Stockreason instance) {
		log.debug("attaching dirty Stockreason instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Stockreason instance) {
		log.debug("attaching clean Stockreason instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}