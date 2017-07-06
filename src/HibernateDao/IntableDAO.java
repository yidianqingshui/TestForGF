package HibernateDao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Intable entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see HibernateDao.Intable
 * @author MyEclipse Persistence Tools
 */
public class IntableDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(IntableDAO.class);
	// property constants
	public static final String ITEM_ID = "itemId";
	public static final String VEND_ID = "vendId";
	public static final String ITEM_DESC = "itemDesc";
	public static final String WARE_ID = "wareId";
	public static final String LOCA_ID = "locaId";
	public static final String PO_EMP_ID = "poEmpId";
	public static final String NUMBER = "number";
	public static final String PROD_CODE = "prodCode";
	public static final String SALE_PIC = "salePic";

	public void save(Intable transientInstance) {
		log.debug("saving Intable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Intable persistentInstance) {
		log.debug("deleting Intable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Intable findById(HibernateDao.IntableId intableId) {
		log.debug("getting Intable instance with id: " + intableId);
		try {
			Intable instance = (Intable) getSession().get(
					"HibernateDao.Intable", intableId);
			System.out.println("fingByid:"+instance.getNumber());
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Intable instance) {
		log.debug("finding Intable instance by example");
		try {
			List results = getSession().createCriteria("HibernateDao.Intable")
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
		log.debug("finding Intable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Intable as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByItemId(Object itemId) {
		return findByProperty(ITEM_ID, itemId);
	}

	public List findByVendId(Object vendId) {
		return findByProperty(VEND_ID, vendId);
	}

	public List findByItemDesc(Object itemDesc) {
		return findByProperty(ITEM_DESC, itemDesc);
	}

	public List findByWareId(Object wareId) {
		return findByProperty(WARE_ID, wareId);
	}

	public List findByLocaId(Object locaId) {
		return findByProperty(LOCA_ID, locaId);
	}

	public List findByPoEmpId(Object poEmpId) {
		return findByProperty(PO_EMP_ID, poEmpId);
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findByProdCode(Object prodCode) {
		return findByProperty(PROD_CODE, prodCode);
	}

	public List findBySalePic(Object salePic) {
		return findByProperty(SALE_PIC, salePic);
	}

	public List findAll() {
		log.debug("finding all Intable instances");
		try {
			String queryString = "from Intable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Intable merge(Intable detachedInstance) {
		log.debug("merging Intable instance");
		try {
			Intable result = (Intable) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Intable instance) {
		log.debug("attaching dirty Intable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Intable instance) {
		log.debug("attaching clean Intable instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}