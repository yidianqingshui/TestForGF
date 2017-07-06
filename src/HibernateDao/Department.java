package HibernateDao;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private String departmengtId;
	private String departmentName;

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(String departmengtId, String departmentName) {
		this.departmengtId = departmengtId;
		this.departmentName = departmentName;
	}

	// Property accessors

	public String getDepartmengtId() {
		return this.departmengtId;
	}

	public void setDepartmengtId(String departmengtId) {
		this.departmengtId = departmengtId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}