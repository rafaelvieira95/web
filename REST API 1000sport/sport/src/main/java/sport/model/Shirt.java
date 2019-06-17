package sport.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shirt")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shirt{
	
	public Shirt(int id,int idUser,String title, String brand, String club, String season,String version, String occasion, boolean gk,double price){
		
		super();
		this.id = id;
		this.idUser = idUser; 
		this.title = title;
		this.brand = brand;
		this.club = club;
		this.season = season;
		this.version = version;
		this.occasion = occasion;
		this.gk = gk;
		this.price = price;
		
	}
	
	public Shirt(){
		
	}
	
	private int id,idUser;
	private String title,brand,season,club,occasion,version;
	private boolean gk;
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
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getOccasion() {
		return occasion;
	}
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public boolean isGk() {
		return gk;
	}
	public void setGk(boolean gk) {
		this.gk = gk;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Shirt [id=" + id + ", idUser=" + idUser + ", title=" + title + ", brand=" + brand + ", season=" + season
				+ ", club=" + club + ", occasion=" + occasion + ", version=" + version + ", gk=" + gk + ", price="
				+ price + "]";
	}
	
}
