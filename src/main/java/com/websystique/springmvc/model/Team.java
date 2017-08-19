package com.websystique.springmvc.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="TEAM")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int team_id;

	@Size(min=3, max=50)
	@Column(name = "TEAM_NAME", nullable = false)
	private String team_name;
	
	@Size(min=3, max=50)
	@Column(name = "TEAM_DESCRIPTION", nullable = true)
	private String team_description;

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_description() {
		return team_description;
	}

	public void setTeam_description(String team_description) {
		this.team_description = team_description;
	}

	
}

/*
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", joiningDate="
				+ joiningDate + ", salary=" + salary + ", ssn=" + ssn + "]";
	}
	
*/