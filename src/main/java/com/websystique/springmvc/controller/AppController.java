package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Data;
import com.websystique.springmvc.model.Report;
import com.websystique.springmvc.model.Role;
import com.websystique.springmvc.model.Team;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.User_Access_Map;
import com.websystique.springmvc.service.ManagerService;
import com.websystique.springmvc.wrapper.UserWrapper;

@Controller
@RequestMapping("/")
public class AppController {
	@Autowired
	private ManagerService svc;
	
	private String username; // to get the username from the search User Text Field
	private int userID; // to get the hidden form UserID
	private int reportID; // to get the hidden form ReportID
	private int teamID; // to get the hidden form TeamID
	private UserWrapper userWrap;
	private ModelMap model;
	
	

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String findUser(ModelMap model){
		
		@SuppressWarnings("unchecked")
		List<User>  users = (List<User>) getSvc().findUser();
		model.addAttribute("users", users);
		
		return "allemployees";
		
	}
	
	
	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String findUserByUserName(){ // how to get the values from the form @BindingResult result!
		
		userWrap = getSvc().findUserByUserName(getUsername());
		model.addAttribute("uw", userWrap);
		
		
		return "home";
		
	}
	
	@RequestMapping(value = { "/r1" }, method = RequestMethod.GET)
	public String listOfTeams(){
		
		List<Team> tm = getSvc().getListOfTeams(getUserID(), getReportID(), getTeamID());
		model.addAttribute("tm", tm);
		
		return "home";
	}
	
	@RequestMapping(value = { "/r2" }, method = RequestMethod.GET)
	public String listOfRoles(){
		
		List<Role> rl = getSvc().getListOfRoles(getUserID(), getReportID());
		
		return null;
		
	}
	
	@RequestMapping(value = { "/r3" }, method = RequestMethod.GET)
	public String listOfUsers(){
		
		List<User> us = getSvc().getListOfUsers(getUserID(), getReportID());
		
		return null;
	}
	
	@RequestMapping(value = { "/r4" }, method = RequestMethod.GET)
	public String dataOfEachUser(){
		
		List<Data> dt = getSvc().getDataOfEachUser(getUserID(), getReportID(), getTeamID());
		
		return null;
	}
	
	@RequestMapping(value = { "/r5" }, method = RequestMethod.GET)
	public String listOfReports(){
		
		List<Report> rt = getSvc().getListOfReports(getUserID(), getReportID());
		
		return null;
		
	}
	
	@RequestMapping(value = { "/r6" }, method = RequestMethod.GET)
	public String listOfUAM(){
		
		List<User_Access_Map> uam = getSvc().getListOfUAM(getUserID(), getReportID());
		
		return null;
		
	}
	
	@RequestMapping(value = { "/r7" }, method = RequestMethod.GET)
	public String listOfUserGivenTeam(){
		
		List<User> us = getSvc().getListOfUserGivenTeam(getUserID(), getReportID(), getTeamID());
		
		return null;
		
	}
	
	/* Getters and Setters */
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getReportID() {
		return reportID;
	}


	public void setReportID(int reportID) {
		this.reportID = reportID;
	}


	public int getTeamID() {
		return teamID;
	}


	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}


	public ManagerService getSvc() {
		return svc;
	}

	public void setSvc(ManagerService svc) {
		this.svc = svc;
	}
	

}
