package HibernateDao;

import java.util.Date;

import HibernateDao.IntableId;

/**
 * Intable entity. @author MyEclipse Persistence Tools
 */

public class Intable implements java.io.Serializable {

	// Fields

	/*private Integer warehouseWarrant;//入库单号
	private Itemgeneral itemId;//料号
*/	
	
	private IntableId id;
	private Vendermaster VendermasterByvendid;//供应商
	private String itemDesc;//料品
	private Warehouse warehouseBywareid;//仓库
	private Location locationBylocationid;//仓位
	private Employee employeeByPoEmpId;//经办人
	private Integer number;//数量
	private Date indate;//入库时间
	private	Classcode classcode;//类别
	private long salePic;//单价
	
	
	public Vendermaster getVendermasterByvendid() {
		return VendermasterByvendid;
	}

	public void setVendermasterByvendid(Vendermaster vendermasterByvendid) {
		VendermasterByvendid = vendermasterByvendid;
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


	public Classcode getClasscode() {
		return classcode;
	}

	public void setClasscode(Classcode classcode) {
		this.classcode = classcode;
	}



	// Constructors

		/** default constructor */
		public Intable() {
		}

		/** minimal constructor */
		public Intable(IntableId id) {
			this.id = id;
		}

	/** full constructor */
	public Intable(IntableId id, Vendermaster VendermasterByvendid,
			String itemDesc,  Warehouse warehouseBywareid, Location locationBylocationid, Employee employeeByPoEmpId,
			Integer number, Date indate, Classcode classcode, long salePic) {
		this.id = id;
		this.VendermasterByvendid=VendermasterByvendid;
		this.itemDesc = itemDesc;
		this.warehouseBywareid = warehouseBywareid;
		this.locationBylocationid = locationBylocationid;
		this.employeeByPoEmpId = employeeByPoEmpId;
		this.number = number;
		this.indate = indate;
		this.classcode = classcode;
		this.salePic = salePic;
	}

	// Property accessors

	public IntableId getId() {
		return id;
	}

	public void setId(IntableId id) {
		this.id = id;
	}
	

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getIndate() {
		return this.indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}



	public long getSalePic() {
		return this.salePic;
	}

	public void setSalePic(long salePic) {
		this.salePic = salePic;
	}

}