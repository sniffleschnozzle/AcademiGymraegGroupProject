/**
 * Author: Sophie Jolley
 * Date: 24.03.22
 * Edit: 09.04.22 (Added student,sysAdmin,instructor,active & getters&setters)
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

	private static final long serialVersionUID = 8655325354608032151L;

	@Id
	@Size(min=1, max=16, message="You must enter a username under 16 characters.")
	private String username;
	
	@Size(min=1, message="You must enter a password.")
	private String password;
	
	@Column(nullable=false)
	private boolean student=false, sysAdmin=false, instructor=false, active=true;
	
	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if(isStudent())
			authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
		
		if (isSysAdmin())
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		if (isInstructor())
			authorities.add(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isStudent() {
		return student;
	}

	public void setStudent(boolean student) {
		this.student = student;
	}

	public boolean isSysAdmin() {
		return sysAdmin;
	}

	public void setSysAdmin(boolean sysAdmin) {
		this.sysAdmin = sysAdmin;
	}

	public boolean isInstructor() {
		return instructor;
	}

	public void setInstructor(boolean instructor) {
		this.instructor = instructor;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
