package HibernateDao;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

/**
 * Data access object (DAO) for domain model class Itemgeneral.
 * 
 * @see HibernateDao.Itemgeneral
 * @author MyEclipse Persistence Tools
 */

public class ItemgeneralDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ItemgeneralDAO.class);

	// property constants
	public static final String ITEM_DESC = "itemDesc";
//取消颜色字段,税收,全价
	//public static final String COLOR = "color";

	//public static final String TAX_RATE = "taxRate";

	public static final String SALE_PIC = "salePic";

	//public static final String WHOL_PIC = "wholPic";

	public static final String STATUS = "status"; 
	
	public static final String WAREID = "wareId"; 
	
	public static final String LOCAID = "locaId"; 
	
	public static final String VEND_ID = "vendId"; 
	
	public static final String NUMBER ="number";
	

	public void save(Itemgeneral transientInstance) {
		log.debug("saving Itemgeneral instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}finally{
			//closeSession();
		}
	}

	public void delete(Itemgeneral persistentInstance) {
		log.debug("deleting Itemgeneral instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Itemgeneral findById(java.lang.String id) {
		log.debug("getting Itemgeneral instance with id: " + id);
		try {
			Itemgeneral instance = (Itemgeneral) getSession().get(
					"HibernateDao.Itemgeneral", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Itemgeneral instance) {
		log.debug("finding Itemgeneral instance by example");
		try {
			List results = getSession().createCriteria(
					"HibernateDao.Itemgeneral").add(Example.create(instance))
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
		log.debug("finding Itemgeneral instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Itemgeneral as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
//只用了findbyProperty的功能
	public List findByItemDesc(Object itemDesc) {
		return findByProperty(ITEM_DESC, itemDesc);
	}

	/*public List findByColor(Object color) {
		return findByProperty(COLOR, color);
	}

	public List findByTaxRate(Object taxRate) {
		return findByProperty(TAX_RATE, taxRate);
	}*/

	public List findBySalePic(Object salePic) {
		return findByProperty(SALE_PIC, salePic);
	}

	/*public List findByWholPic(Object wholPic) {
		return findByProperty(WHOL_PIC, wholPic);
	}*/

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findBywareId(Object wareId) {
		return findByProperty(WAREID, wareId);
	}
	
	public List findBylocaId(Object locaId) {
		return findByProperty(LOCAID, locaId);
	}
	
	public List findByvendid(Object vendId) {
	return findByProperty(VEND_ID, vendId);
	}
	
	public List findBynumber(Object number) {
		return findByProperty(VEND_ID, number);
		}
	

	public List findAll() {
		log.debug("finding all Itemgeneral instances");
		try {
			String queryString = "from Itemgeneral";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Itemgeneral merge(Itemgeneral detachedInstance) {
		log.debug("merging Itemgeneral instance");
		try {
			Itemgeneral result = (Itemgeneral) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Itemgeneral instance) {
		log.debug("attaching dirty Itemgeneral instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemgeneral instance) {
		log.debug("attaching clean Itemgeneral instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}