package sport.sport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boot")
public class Boot {

	
	public Boot(Integer idUser, String title,String brand,String model,String bootsGender,
			    int bootSize,String version,boolean field,double price) {
		
		super();
		this.idUser = idUser;
		this.title = title;
		this.brand = brand;
		this.model = model;
		this.version = version;
		this.bootsGender = bootsGender;
		this.bootSize = bootSize;
		this.field = field;
		this.price = price;
	
	}
	
	public Boot() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="id_user",nullable = false)
	private Integer idUser;
	
	@Column(name="bootsize",nullable = false)
	private int bootSize;
	@Column(name="title",nullable = false)
	private String title;
	@Column(name="brand",nullable = false)
	private String brand;
	@Column(name="model",nullable = false)
	private String model;
	@Column(name="version",nullable = false)
	private String version;
	@Column(name="bootsgender",nullable = false)
	private String bootsGender;
	@Column(name="field",nullable = false)
	private boolean field;
	@Column(name="price",nullable = false)
	private double price;
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getBootSize() {
		return bootSize;
	}

	public void setBootSize(int bootSize) {
		this.bootSize = bootSize;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBootsGender() {
		return bootsGender;
	}

	public void setBootsGender(String bootsGender) {
		this.bootsGender = bootsGender;
	}

	public boolean isField() {
		return field;
	}

	public void setField(boolean field) {
		this.field = field;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Boot [id=" + id + ", idUser=" + idUser + ", title=" + title + ", brand=" + brand + ", model=" + model
				+ ", version=" + version + ", bootSize=" + bootSize + ", bootsGender=" + bootsGender + ", price="
				+ price + ", field=" + field + "]";
	}
	
}
