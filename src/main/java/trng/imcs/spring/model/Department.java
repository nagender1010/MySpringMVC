package trng.imcs.spring.model;

import java.io.Serializable;

public class Department implements Serializable{

	/**
	 * @author Nagender
	 */
	private static final long serialVersionUID = -1108664496960894731L;
	private int id;
	private String name;

	public Department() {
		super();
	}

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
