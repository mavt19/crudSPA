package pe.com.vera.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.PreDestroy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;



@Entity
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastName;
//	@JsonFormat(pattern="dd/MM/yyyy")
//	@JsonDeserialize(using=LocalDateDeserializer.class)
//	@JsonSerialize(using=LocalDateSerializer.class)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthdate;
	
	@PrePersist
	public void createdAt() {
		this.birthdate=LocalDate.now();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public Person(Long id, String name, String lastName, LocalDate birthdate) {
		
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthdate=" + birthdate + "]";
	}
	
}
