package model;

import java.time.LocalDate;

public class Expert {
	int experto_id, specialization_id, role_id;
	String username, name, surname, password, email, companyName, phoneNumber, phoneExtension;
	LocalDate registerDate, updatedTime;

	public Expert(int experto_id,int role_id, int specialization_id, String username, String name, String surname, String password, String email,
			String companyName, String phoneNumber, String phoneExtension, LocalDate registerDate, LocalDate updatedTime) {

		this.experto_id = experto_id;
		this.role_id = role_id;
		this.specialization_id = specialization_id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.phoneExtension = phoneExtension;
		this.registerDate = registerDate;
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "Expert [experto_id=" + experto_id + ", role_id=" + role_id + ", specialization_id=" + specialization_id + ", username=" 
				+ username + ", name=" + name + ", surname=" + surname+ ", password=" + password + ", email=" + email 
				+ ", companyName=" + companyName + ", phoneNumber=" + phoneNumber + ", phoneExtension=" + phoneExtension 
				+ ", registerDate=" + registerDate.getYear() + "/" + registerDate.getMonthValue()
				+ "/" + registerDate.getDayOfMonth() + ", updatedTime=" + updatedTime +"]";
	}

	public int getExperto_id() {
		return experto_id;
	}

	public int getSpecialization_id() {
		return specialization_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPhoneExtension() {
		return phoneExtension;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public LocalDate getUpdatedTime() {
		return updatedTime;
	}

	

}