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
 * Outtable entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see HibernateDao.Outtable
 * @author MyEclipse Persistence Tools
 */
public class OuttableDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(OuttableDAO.class);
	// property constants
	public static final String ITEM_ID = "itemId";
	public static final String VEND_ID = "vendId";
	public static final String ITEM_DESC = "itemDesc";
	public static final String WARE_ID = "wareId";
	public static final String LOCA_ID = "locaId";
	public static final String PO_EMP_ID = "poEmpId";
	public static final String NUMBER = "number";
	public static final String SALE_PIC = "salePic";
	public static final String DEPARTMENT = "department";

	public void save(Outtable transientInstance) {
		log.debug("saving Outtable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Outtable persistentInstance) {
		log.debug("deleting Outtable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Outtable findById(OuttableId outtableId) {
		log.debug("getting Outtable instance with id: " + outtableId);
		try {
			Outtable instance = (Outtable) getSession().get(
					"HibernateDao.Outtable", outtableId);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Outtable instance) {
		log.debug("finding Outtable instance by example");
		try {
			List results = getSession().createCriteria("HibernateDao.Outtable")
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
		log.debug("finding Outtable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Outtable as model where model."
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

	public List findBySalePic(Object salePic) {
		return findByProperty(SALE_PIC, salePic);
	}
	
	public List findByDepartmnet(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	public List findAll() {
		log.debug("finding all Outtable instances");
		try {
			String queryString = "from Outtable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Outtable merge(Outtable detachedInstance) {
		log.debug("merging Outtable instance");
		try {
			Outtable result = (Outtable) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Outtable instance) {
		log.debug("attaching dirty Outtable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Outtable instance) {
		log.debug("attaching clean Outtable instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}