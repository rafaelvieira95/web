package sport.sport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ball")
public class Ball {

	public Ball(Integer idUser,String title,String brand,String model,String year,boolean field,double price) {
		
		super();
		this.idUser = idUser;
		this.title = title;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
		this.field = field;
		
	}
	
	public Ball() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="id_user", nullable = false)
	private Integer idUser;
	@Column(name="title", nullable = false)
	private String title;
	@Column(name="brand", nullable = false)
	private String brand;
	@Column(name="model", nullable = false)
	private String model;
	@Column(name="year", nullable = false)
	private String year;
	@Column(name="field", nullable = false)
	private boolean field;
	@Column(name="price", nullable = false)
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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
		return "Ball [id=" + id + ", idUser=" + idUser + ", title=" + title + ", brand=" + brand + ", model=" + model
				+ ", year=" + year + ", price=" + price + ", field=" + field + "]";
	}
	
}
