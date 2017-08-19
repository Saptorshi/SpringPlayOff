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
@Table(name="DATA")
public class Data {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int data_id;
	
	@NotNull
	@Column(name = "USER_ID", nullable = false)
	private int user_id;

	@NotNull
	@Column(name = "PROJECT_COUNT", nullable = false)
	private int project_count;
	
	@NotNull
	@Column(name = "BUG_COUNT", nullable = false)
	private int bug_count;
	
	@NotNull
	@Column(name = "feature_COUNT", nullable = false)
	private int feature_count;
	
	public int getData_id() {
		return data_id;
	}

	public void setData_id(int data_id) {
		this.data_id = data_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProject_count() {
		return project_count;
	}

	public void setProject_count(int project_count) {
		this.project_count = project_count;
	}

	public int getBug_count() {
		return bug_count;
	}

	public void setBug_count(int bug_count) {
		this.bug_count = bug_count;
	}

	public int getFeature_count() {
		return feature_count;
	}

	public void setFeature_count(int feature_count) {
		this.feature_count = feature_count;
	}

	
}
