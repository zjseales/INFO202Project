package domain;

import java.util.Objects;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * @author Mark George
 */
public class Customer {

	private Integer customerId;
        @NotNull(message = "Username is required")
        @NotBlank(message = "Username is required")
	private String username;
        @NotNull(message = "First name is required")
        @NotBlank(message = "First name is required")
	private String firstName;
        @NotNull(message = "Surname is required")
        @NotBlank(message = "Surname is required")
	private String surname;
        @NotNull(message = "Password is required")
        @NotBlank(message = "Password is required")
	private String password;
	private String emailAddress;
	private String shippingAddress;

	public Customer() {
	}

	public Customer(String firstName, String surname, String username, String password, String shippingAddress, String emailAddress) {
		this.username = username;
		this.firstName = firstName;
		this.surname = surname;
                this.password = password;
		this.shippingAddress = shippingAddress;
		this.emailAddress = emailAddress;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer personId) {
		this.customerId = personId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Customer{" + "customerId=" + customerId + ", username=" + username + ", firstName=" + firstName + ", surname=" + surname + ", password=" + password + ", emailAddress=" + emailAddress + ", shippingAddress=" + shippingAddress + '}';
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + Objects.hashCode(this.username);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Customer other = (Customer) obj;
		return Objects.equals(this.username, other.username);
	}
	
	

}
