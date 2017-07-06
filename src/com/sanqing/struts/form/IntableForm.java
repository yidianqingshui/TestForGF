package com.sanqing.struts.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class IntableForm extends ActionForm{
	
	private Integer itemId;
	private String vendId;
	private String itemDesc;
	private String wareId;
	private String locaId;
	private String poEmpId;
	private Integer number;
	private String indate;
	private String prodCode;
	private long salePic;

	private Integer warehouseWarrant;
	public Integer getWarehouseWarrant() {
		return warehouseWarrant;
	}
	public void setWarehouseWarrant(Integer warehouseWarrant) {
		this.warehouseWarrant = warehouseWarrant;
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
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public long getSalePic() {
		return salePic;
	}
	public void setSalePic(long salePic) {
		this.salePic = salePic;
	}
	
	
}
