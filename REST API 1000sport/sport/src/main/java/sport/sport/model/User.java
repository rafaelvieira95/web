package sport.sport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	public User() {
	   
	}	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="namefantasy",nullable = false)
	private String nameFantasy;
	
	@Column(name="societyreason",nullable = false)
	private String societyReason;
	
	@Column(name="cnpj",nullable = false)
	private String cnpj;

	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="surname",nullable = false)
	private String surname;
	
	@Column(name="cpf",nullable = false)
	private String cpf;

	@Column(name="city",nullable = false)
	private String city;
	
	@Column(name="state",nullable = false)
	private String state;
	
	@Column(name="street",nullable = false)
	private String street;
	@Column(name="neighborhood",nullable = false)
	
	private String neighborhood;
	@Column(name="cep",nullable = false)
	private String cep;
	
	@Column(name="number",nullable = false) 
	private Integer number;
	
	@Column(name="nameuser",nullable = false)
	private String nameUser;
	
	@Column(name="email",nullable = false)
	private String email;
	
	@Column(name="password",nullable = false)
	private String password;
   
	public User(int id,String email,String password) {
		
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	public User(UserBuilder user) {

		this.id = user.id;
		this.nameFantasy = user.nameFantasy;
		this.societyReason = user.societyReason;
		this.cnpj = user.cnpj;

		this.name = user.name;
		this.surname = user.surname;
		this.cpf = user.cpf;

		this.city = user.city;
		this.state = user.state;
		this.street = user.street;
		this.neighborhood = user.neighborhood;
		this.cep = user.cep;
		this.number = user.number;

		this.nameUser = user.nameUser;
		this.email = user.email;
		this.password = user.password;

	}
	
	public String getNameFantasy() {
		return nameFantasy;
	}

	public void setNameFantasy(String nameFantasy) {
		this.nameFantasy = nameFantasy;
	}

	public String getSocietyReason() {
		return societyReason;
	}

	public void setSocietyReason(String societyReason) {
		this.societyReason = societyReason;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}




	public static class UserBuilder{

		private String nameFantasy, societyReason, cnpj;

		private String name, surname, cpf;

		private String city, state, street, neighborhood, cep;
		private Integer id, number;

		private String nameUser, email, password;


		public UserBuilder id(int id) {
			this.id = id;
			return this;
		}
	     
		public UserBuilder nameFantasy(String nameFantasy) {
			this.nameFantasy = nameFantasy;
			return this;
		}
		
		public UserBuilder societyReason(String societyReason) {
			this.societyReason = societyReason;
			return this;
		}
		
		
		public UserBuilder cnpj(String cnpj) {
			this.cnpj = cnpj;
			return this;
		}
		
		public UserBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public UserBuilder surname (String surname) {
			this.surname = surname;
			return this;
		}
		
		
		public UserBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}
		
		public UserBuilder city(String city) {
			this.city = city;
			return this;
		}
		
		public UserBuilder state(String state) {
			this.state = state;
			return this;
		}
		
		public UserBuilder street(String street) {
			this.street = street;
			return this;
		}
		
		public UserBuilder neighborhood(String neighborhood) {
			this.neighborhood = neighborhood;
			return this;
		}
		
		public UserBuilder cep(String cep) {
			this.cep = cep;
			return this;
		}
		
		public UserBuilder number(int number) {
			this.number = number;
			return this;
		}
		

		public UserBuilder nameUser(String nameUser) {
			this.nameUser = nameUser;
			return this;
		}
		
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public User builder() {
			return new User(this);
		}
		
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", nameFantasy=" + nameFantasy + ", societyReason=" + societyReason + ", cnpj=" + cnpj
				+ ", name=" + name + ", surname=" + surname + ", cpf=" + cpf + ", city=" + city + ", state=" + state
				+ ", street=" + street + ", neighborhood=" + neighborhood + ", cep=" + cep + ", number=" + number
				+ ", nameUser=" + nameUser + ", email=" + email + ", password=" + password + "]";
	}




}
