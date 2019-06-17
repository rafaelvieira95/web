package sport.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ball")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ball {

	
	public Ball(int id,int idUser,String title,String brand,String model,String year,boolean field,double price) {
		
		super();
		this.id = id;
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
	
	private int id, idUser;
	private String title,brand,model,year;
	private boolean field;
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
