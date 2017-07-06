package HibernateDao;

/**
 * OuttableId entity. @author MyEclipse Persistence Tools
 */

public class OuttableId implements java.io.Serializable {

	// Fields

	private Integer warehouseWarrantOut;
	private Integer itemId;

	// Constructors

	/** default constructor */
	public OuttableId() {
	}

	/** full constructor */
	public OuttableId(Integer warehouseWarrantOut, Integer itemId) {
		this.warehouseWarrantOut = warehouseWarrantOut;
		this.itemId = itemId;
	}

	// Property accessors

	public Integer getWarehouseWarrantOut() {
		return this.warehouseWarrantOut;
	}

	public void setWarehouseWarrantOut(Integer warehouseWarrantOut) {
		this.warehouseWarrantOut = warehouseWarrantOut;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OuttableId))
			return false;
		OuttableId castOther = (OuttableId) other;

		return ((this.getWarehouseWarrantOut() == castOther
				.getWarehouseWarrantOut()) || (this.getWarehouseWarrantOut() != null
				&& castOther.getWarehouseWarrantOut() != null && this
				.getWarehouseWarrantOut().equals(
						castOther.getWarehouseWarrantOut())))
				&& ((this.getItemId() == castOther.getItemId()) || (this
						.getItemId() != null && castOther.getItemId() != null && this
						.getItemId().equals(castOther.getItemId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getWarehouseWarrantOut() == null ? 0 : this
						.getWarehouseWarrantOut().hashCode());
		result = 37 * result
				+ (getItemId() == null ? 0 : this.getItemId().hashCode());
		return result;
	}

}