package com.sanqing.struts.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class outtableForm extends ActionForm{
	
	private Integer itemId;
	private String vendId;
	private String itemDesc;
	private String wareId;
	private String locaId;
	private String poEmpId;
	private Integer number;
	private String outdate;
	private long salePic;
	private Integer warehouseWarrantOut;
	private String department;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public Integer getWarehouseWarrantOut() {
		return warehouseWarrantOut;
	}
	public void setWarehouseWarrantOut(Integer warehouseWarrantOut) {
		this.warehouseWarrantOut = warehouseWarrantOut;
	}
	public Integer warehouseWarrantOut() {
		return warehouseWarrantOut;
	}
	public void setwarehouseWarrantOut(Integer warehouseWarrantOut) {
		this.warehouseWarrantOut = warehouseWarrantOut;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getVendId() {
		return vendId;
	}
	public void setVendId(String vendId) {
		this.vendId = vendId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getWareId() {
		return wareId;
	}
	public void setWareId(String wareId) {
		this.wareId = wareId;
	}
	public String getLocaId() {
		return locaId;
	}
	public void setLocaId(String locaId) {
		this.locaId = locaId;
	}
	public String getPoEmpId() {
		return poEmpId;
	}
	public void setPoEmpId(String poEmpId) {
		this.poEmpId = poEmpId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getoutdate() {
		return outdate;
	}
	public void setoutdate(String outdate) {
		this.outdate = outdate;
	}
	public long getSalePic() {
		return salePic;
	}
	public void setSalePic(long salePic) {
		this.salePic = salePic;
	}
	
	
}
