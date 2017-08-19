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
@Table(name="REPORT")
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int report_id;
	
	@NotNull
	@Column(name = "SQL_STRING", nullable = false)
	private String sql_string;

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public String getSql_string() {
		return sql_string;
	}

	public void setSql_string(String sql_string) {
		this.sql_string = sql_string;
	}

}
