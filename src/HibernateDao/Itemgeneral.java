package HibernateDao;

import java.util.HashSet;
import java.util.Set;

public class Itemgeneral implements java.io.Serializable {
	
	

	@Override
	public String toString() {
		return "Itemgeneral [number=" + number + "]";
	}

	private String itemId;

	private Employee employeeBySaleEmpId;

	private Employee employeeByPoEmpId;

	private Ummaster ummaster;

	private Classcode classcode;
	
	private Warehouse warehouseBywareid;
	
	private Location locationBylocationid;
	
	private Vendermaster VendermasterByvendid;
	
	public int getMaxstroage() {
		return maxstroage;
	}

	public void setMaxstroage(int maxstroage) {
		this.maxstroage = maxstroage;
	}

	private int maxstroage;
	
	public int getSafestroage() {
		return safestroage;
	}

	public void setSafestroage(int safestroage) {
		this.safestroage = safestroage;
	}

	private int safestroage;
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	private Integer number;
	

	

	private String itemDesc;
//取消颜色字段,税收,全价
	//private String color;

	//private Long taxRate;

	private Long salePic;

	//private Long wholPic;

	private String status;

	private Set physicsdatas = new HashSet(0);

	private Set warehouseItems = new HashSet(0);

	private Set iusses = new HashSet(0);

	private Set eceipts = new HashSet(0);

	private Set inventorytags = new HashSet(0);
	
	//private Set VendermasterByvendId = new HashSet(0);

	// Constructors

	//public Set getVendermasterByvendId() {
		//return VendermasterByvendId;
	//}

	//public void setVendermasterByvendId(Set vendermasterByvendId) {
		//VendermasterByvendId = vendermasterByvendId;
	//}

	/** default constructor */
	public Itemgeneral() {
	}

	/** minimal constructor */
	public Itemgeneral(String itemId, Ummaster ummaster, Classcode classcode,
		 Long salePic,  String status,Warehouse warehouseBywareid,Location locationBylocationid
		,Integer number,int maxstroage,Vendermaster VendermasterByvendid,Integer warehouse_warrant,int safestroage) {
		this.itemId = itemId;
		this.ummaster = ummaster;
		this.classcode = classcode;
		//this.taxRate = taxRate;
		this.salePic = salePic;
		//this.wholPic = wholPic;
		this.status = status;
		this.warehouseBywareid=warehouseBywareid;
		this.locationBylocationid=locationBylocationid;
		this.VendermasterByvendid=VendermasterByvendid;
		this.number=number;
		this.safestroage=safestroage;
		this.maxstroage=maxstroage;
	}

	/** full constructor */
	public Itemgeneral(String itemId, Employee employeeBySaleEmpId,
			Employee employeeByPoEmpId, Ummaster ummaster, Classcode classcode,
			String itemDesc,  Long salePic,Warehouse warehouseBywareid,Location locationBylocationid,
			 String status, Set physicsdatas, Set warehouseItems,
			Set iusses, int maxstroage,Set eceipts, Set inventorytags,Set VendermasterByvendId,Integer number,Vendermaster VendermasterByvendid
			,Integer warehouse_warrant,int safestroage) {
		this.itemId = itemId;
		this.employeeBySaleEmpId = employeeBySaleEmpId;
		this.employeeByPoEmpId = employeeByPoEmpId;
		this.ummaster = ummaster;
		this.classcode = classcode;
		this.itemDesc = itemDesc;
		//this.color = color;
		//this.taxRate = taxRate;
		this.salePic = salePic;
		//this.wholPic = wholPic;
		this.status = status;
		this.physicsdatas = physicsdatas;
		this.warehouseItems = warehouseItems;
		this.iusses = iusses;
		this.eceipts = eceipts;
		this.inventorytags = inventorytags;
		this.warehouseBywareid =warehouseBywareid;
		this.locationBylocationid=locationBylocationid;
		this.VendermasterByvendid=VendermasterByvendid;
		//this.VendermasterByvendId=VendermasterByvendId;
		this.number=number;
		this.safestroage=safestroage;
		this.maxstroage=maxstroage;
	}

	// Property accessors

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Employee getEmployeeBySaleEmpId() {
		return this.employeeBySaleEmpId;
	}

	public void setEmployeeBySaleEmpId(Employee employeeBySaleEmpId) {
		this.employeeBySaleEmpId = employeeBySaleEmpId;
	}

	public Employee getEmployeeByPoEmpId() {
		return this.employeeByPoEmpId;
	}

	public void setEmployeeByPoEmpId(Employee employeeByPoEmpId) {
		this.employeeByPoEmpId = employeeByPoEmpId;
	}

	public Ummaster getUmmaster() {
		return this.ummaster;
	}

	public void setUmmaster(Ummaster ummaster) {
		this.ummaster = ummaster;
	}

	public Classcode getClasscode() {
		return this.classcode;
	}

	public void setClasscode(Classcode classcode) {
		this.classcode = classcode;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	/*public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(Long taxRate) {
		this.taxRate = taxRate;
	}*/

	public Long getSalePic() {
		return this.salePic;
	}

	public void setSalePic(Long salePic) {
		this.salePic = salePic;
	}

	/*public Long getWholPic() {
		return this.wholPic;
	}

	public void setWholPic(Long wholPic) {
		this.wholPic = wholPic;
	}*/

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getPhysicsdatas() {
		return this.physicsdatas;
	}

	public void setPhysicsdatas(Set physicsdatas) {
		this.physicsdatas = physicsdatas;
	}

	public Set getWarehouseItems() {
		return this.warehouseItems;
	}

	public void setWarehouseItems(Set warehouseItems) {
		this.warehouseItems = warehouseItems;
	}

	public Set getIusses() {
		return this.iusses;
	}

	public void setIusses(Set iusses) {
		this.iusses = iusses;
	}

	public Set getEceipts() {
		return this.eceipts;
	}

	public void setEceipts(Set eceipts) {
		this.eceipts = eceipts;
	}

	public Set getInventorytags() {
		return this.inventorytags;
	}

	public void setInventorytags(Set inventorytags) {
		this.inventorytags = inventorytags;
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
	
	public Vendermaster getVendermasterByvendid() {
		return VendermasterByvendid;
	}

	public void setVendermasterByvendid(Vendermaster vendermasterByvendid) {
		VendermasterByvendid = vendermasterByvendid;
	}
}