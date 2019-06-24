package sport.sport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="short")
public class Short {

	
	public Short(Integer idUser, String title,String brand,String model, String chooseGender, String chooseSize,double price) {
	
		this.idUser = idUser;
		this.title = title;
		this.brand = brand;
		this.model = model;
		this.chooseGender = chooseGender;
		this.chooseSize = chooseSize;
		this.price = price;
		
	}
	
	public Short() {
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
	@Column(name="choosegender", nullable = false)
	private String chooseGender;
	@Column(name="choosesize", nullable = false)
	private String chooseSize;
	@Column(name="price", nullable = false)
	private double price;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
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

	public String getChooseGender() {
		return chooseGender;
	}

	public void setChooseGender(String chooseGender) {
		this.chooseGender = chooseGender;
	}

	public String getChooseSize() {
		return chooseSize;
	}

	public void setChooseSize(String chooseSize) {
		this.chooseSize = chooseSize;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Short [id=" + id + ", idUser=" + idUser + ", title=" + title + ", brand=" + brand + ", model=" + model
				+ ", chooseGender=" + chooseGender + ", chooseSize=" + chooseSize + ", price=" + price + "]";
	}
	
}
