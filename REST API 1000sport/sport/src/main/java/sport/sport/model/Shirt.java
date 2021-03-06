package sport.sport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shirt")
public class Shirt{
	
	public Shirt(Integer idUser,String title, String brand, String club, String season,String version, String occasion, boolean gk,double price){
		
		super();
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
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="id_user",nullable = false)
	private Integer idUser;
	
	@Column(name="title",nullable = false)
	private String title;
	@Column(name="brand",nullable = false)
	private String brand;
	@Column(name="season",nullable = false)
	private String season;
	@Column(name="club",nullable = false)
	private String club;
	@Column(name="occasion",nullable = false)
	private String occasion;
	@Column(name="version",nullable = false)
	private String version;
	@Column(name="gk",nullable = false)
	private boolean gk;
	@Column(name="price",nullable = false)
	private double price;
	
	public Integer getId() {
		return id;
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
