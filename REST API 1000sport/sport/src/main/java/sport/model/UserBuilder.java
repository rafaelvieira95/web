package sport.model;

import sport.model.User;

public class UserBuilder {

	protected String nameFantasy, societyReason, cnpj;

	protected String name, surname, cpf;

	protected String city, state, street, neighborhood, cep;
	protected int id, number;

	protected String nameUser, email, password;


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
