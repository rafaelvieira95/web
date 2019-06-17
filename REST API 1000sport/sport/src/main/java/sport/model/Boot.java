package sport.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "boot")
@XmlAccessorType(XmlAccessType.FIELD)
public class Boot {

	
	public Boot(int id,int idUser, String title,String brand,String model,String bootsGender,
			    int bootSize,String version,boolean field,double price) {
		
		super();
		this.id = id;
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
	
	private int id, idUser,bootSize;
	private String title,brand,model,version,bootsGender;
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
