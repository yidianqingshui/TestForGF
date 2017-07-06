package HibernateDao;

/**
 * IntableId entity. @author MyEclipse Persistence Tools
 */

public class IntableId implements java.io.Serializable {

	// Fields

	private Integer warehouseWarrant;
	private Integer itemId;

	// Constructors

	/** default constructor */
	public IntableId() {
	}

	/** full constructor */
	public IntableId(Integer warehouseWarrant, Integer itemId) {
		this.warehouseWarrant = warehouseWarrant;
		this.itemId = itemId;
	}

	// Property accessors

	public Integer getWarehouseWarrant() {
		return this.warehouseWarrant;
	}

	public void setWarehouseWarrant(Integer warehouseWarrant) {
		this.warehouseWarrant = warehouseWarrant;
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
		if (!(other instanceof IntableId))
			return false;
		IntableId castOther = (IntableId) other;

		return ((this.getWarehouseWarrant() == castOther.getWarehouseWarrant()) || (this
				.getWarehouseWarrant() != null
				&& castOther.getWarehouseWarrant() != null && this
				.getWarehouseWarrant().equals(castOther.getWarehouseWarrant())))
				&& ((this.getItemId() == castOther.getItemId()) || (this
						.getItemId() != null && castOther.getItemId() != null && this
						.getItemId().equals(castOther.getItemId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getWarehouseWarrant() == null ? 0 : this
						.getWarehouseWarrant().hashCode());
		result = 37 * result
				+ (getItemId() == null ? 0 : this.getItemId().hashCode());
		return result;
	}

}