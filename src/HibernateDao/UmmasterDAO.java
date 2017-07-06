package HibernateDao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Ummaster.
 * 
 * @see HibernateDao.Ummaster
 * @author MyEclipse Persistence Tools
 */

public class UmmasterDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(UmmasterDAO.class);

	// property constants
	public static final String UM_DESC = "umDesc";

	public void save(Ummaster transientInstance) {
		log.debug("saving Ummaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ummaster persistentInstance) {
		log.debug("deleting Ummaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ummaster findById(java.lang.String id) {
		log.debug("getting Ummaster instance with id: " + id);
		try {
			Ummaster instance = (Ummaster) getSession().get(
					"HibernateDao.Ummaster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ummaster instance) {
		log.debug("finding Ummaster instance by example");
		try {
			List results = getSession().createCriteria("HibernateDao.Ummaster")
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
		log.debug("finding Ummaster instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ummaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUmDesc(Object umDesc) {
		return findByProperty(UM_DESC, umDesc);
	}

	public List findAll() {
		log.debug("finding all Ummaster instances");
		try {
			String queryString = "from Ummaster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ummaster merge(Ummaster detachedInstance) {
		log.debug("merging Ummaster instance");
		try {
			Ummaster result = (Ummaster) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ummaster instance) {
		log.debug("attaching dirty Ummaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ummaster instance) {
		log.debug("attaching clean Ummaster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}