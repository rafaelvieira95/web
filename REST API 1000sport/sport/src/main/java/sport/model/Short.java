package sport.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "short")
@XmlAccessorType(XmlAccessType.FIELD)
public class Short {

	
	public Short(int id,int idUser, String title,String brand,String model, String chooseGender, String chooseSize,double price) {
		
		this.id = id;
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
	
	private int id, idUser;
	private String title,brand,model,chooseGender,chooseSize;
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
