package com.app.model;

public class Author {
	private String lastName;
	private String foreName;
	private String initials;
	
	public Author(String lastName, String foreName, String initials) {
		super();
		this.lastName = lastName;
		this.foreName = foreName;
		this.initials = initials;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return lastName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.lastName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return foreName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.foreName = lastName;
	}

	/**
	 * @return the initials
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * @param initials the initials to set
	 */
	public void setInitials(String initials) {
		this.initials = initials;
	}
	
	public String getFullName() {
		return foreName + ", " + lastName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((initials == null) ? 0 : initials.hashCode());
		result = prime * result
				+ ((foreName == null) ? 0 : foreName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (initials == null) {
			if (other.initials != null)
				return false;
		} else if (!initials.equals(other.initials))
			return false;
		if (foreName == null) {
			if (other.foreName != null)
				return false;
		} else if (!foreName.equals(other.foreName))
			return false;
		return true;
	}
}
