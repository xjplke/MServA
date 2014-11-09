package me.itsoho.mserva.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ModelA implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1995309234322607234L;
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
