package HibernateDao;

import java.util.Date;

import HibernateDao.Department;
import HibernateDao.OuttableId;

/**
 * Outtable entity. @author MyEclipse Persistence Tools
 */

public class Outtable implements java.io.Serializable {

	// Fields

/*	private Integer warehouseWarrantOut;
	private Itemgeneral itemId;*/
	private OuttableId id;
	private Vendermaster VendermasterByvendid;
	private String itemDesc;
	private Warehouse warehouseBywareid;
	private Location locationBylocationid;
	private Employee employeeByPoEmpId;
	private Integer number;
	private long salePic;
	private Date outdate;
	private Department department;
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	

	public Vendermaster getVendermasterByvendid() {
		return VendermasterByvendid;
	}

	public void setVendermasterByvendid(Vendermaster vendermasterByvendid) {
		VendermasterByvendid = vendermasterByvendid;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Warehouse getWarehouseBywareid() {
		return warehouseBywareid;
	}

	public void setWarehouseBywareid(Warehouse warehouseBywareid) {
		this.warehouseBywareid = warehouseBywareid;
	}

	public Location getLocationBylocationid() {
		return locationBylocationid;
	}

	public void setLocationBylocationid(Location locationBylocationid) {
		this.locationBylocationid = locationBylocationid;
	}

	public Employee getEmployeeByPoEmpId() {
		return employeeByPoEmpId;
	}

	public void setEmployeeByPoEmpId(Employee employeeByPoEmpId) {
		this.employeeByPoEmpId = employeeByPoEmpId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public long getSalePic() {
		return salePic;
	}

	public void setSalePic(long salePic) {
		this.salePic = salePic;
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}

	
	// Constructors

		/** default constructor */
		public Outtable() {
		}

		/** minimal constructor */
		public Outtable(OuttableId id) {
			this.id = id;
		}

	/** full constructor */
	public Outtable(OuttableId id, Vendermaster VendermasterByvendid,
			String itemDesc, Warehouse warehouseBywareid, Location locationBylocationid, Employee employeeByPoEmpId,
			Integer number, long salePic, Date outdate) {
		this.id = id;
		this.VendermasterByvendid = VendermasterByvendid;
		this.itemDesc = itemDesc;
		this.warehouseBywareid = warehouseBywareid;
		this.locationBylocationid = locationBylocationid;
		this.employeeByPoEmpId = employeeByPoEmpId;
		this.number = number;
		this.salePic = salePic;
		this.outdate = outdate;
	}

	public OuttableId getId() {
		return id;
	}

	public void setId(OuttableId id) {
		this.id = id;
	}

	// Property accessors


}