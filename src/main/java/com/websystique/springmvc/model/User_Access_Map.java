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
@Table(name="USER_ACCESS_MAP")
public class User_Access_Map {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uam_id;
	
	@NotNull
	@Column(name = "REPORT_ID", nullable = false)
	private int report_id;

	@NotNull
	@Column(name = "USER_ID", nullable = false)
	private int user_id;

	public int getUam_id() {
		return uam_id;
	}

	public void setUam_id(int uam_id) {
		this.uam_id = uam_id;
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
