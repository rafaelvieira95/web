package sport.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	public User() {
	   
	}	
	
	public String nameFantasy, societyReason, cnpj;

	public String name, surname, cpf;

	public String city, state, street, neighborhood, cep;
	public int id, number;

	public String nameUser, email, password;
   
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
	
	public int getId() {
		return id;
	}
	
	public String getNameFantasy() {
		return nameFantasy;
	}


	public String getSocietyReason() {
		return societyReason;
	}



	public String getCnpj() {
		return cnpj;
	}



	public String getName() {
		return name;
	}



	public String getSurname() {
		return surname;
	}



	public String getCpf() {
		return cpf;
	}



	public String getCity() {
		return city;
	}



	public String getState() {
		return state;
	}



	public String getStreet() {
		return street;
	}



	public String getNeighborhood() {
		return neighborhood;
	}



	public String getCep() {
		return cep;
	}



	public int getNumber() {
		return number;
	}



	public String getNameUser() {
		return nameUser;
	}



	public String getEmail() {
		return email;
	}



	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nameFantasy=" + nameFantasy + ", societyReason=" + societyReason + ", cnpj=" + cnpj
				+ ", name=" + name + ", surname=" + surname + ", cpf=" + cpf + ", city=" + city + ", state=" + state
				+ ", street=" + street + ", neighborhood=" + neighborhood + ", cep=" + cep + ", number=" + number
				+ ", nameUser=" + nameUser + ", email=" + email + ", password=" + password + "]";
	}




}
