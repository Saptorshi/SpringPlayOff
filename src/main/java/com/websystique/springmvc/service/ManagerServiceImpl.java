package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.websystique.springmvc.dao.ManagerDao;
import com.websystique.springmvc.model.Data;
import com.websystique.springmvc.model.Role;
import com.websystique.springmvc.model.Team;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.User_Access_Map;
import com.websystique.springmvc.wrapper.UserWrapper;
import com.websystique.springmvc.model.Report;


@Service("managerService")
@Transactional
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao dao;
	
	public List<User> findUser() {
		
		return dao.findUser();
	}

	public UserWrapper findUserByUserName(String username) {
		
		UserWrapper uw = dao.findUserByUserName(username);
		
		return uw;
		
	}

	public List<Team> getListOfTeams(int userID, int reportID, int teamID) {
		
		return dao.getListOfTeams(userID, reportID, teamID);
		
	}

	public List<Role> getListOfRoles(int userID, int reportID) {
		
		return dao.getListOfRoles(userID, reportID);
		
	}

	public List<User> getListOfUsers(int userID, int reportID) {
		
		return dao.getListOfUsers(userID, reportID);
	}

	public List<Data> getDataOfEachUser(int userID, int reportID, int teamID) {
		
		return dao.getDataOfEachUser(userID, reportID, teamID);
	}

	public List<Report> getListOfReports(int userID, int reportID) {
		
		return dao.getListOfReports(userID, reportID);
		
	}

	public List<User_Access_Map> getListOfUAM(int userID, int reportID) {
		
		return dao.getListOfUAM(userID, reportID);
		
	}

	public List<User> getListOfUserGivenTeam(int userID, int reportID, int teamID) {
		
		return dao.getListOfUserGivenTeam(userID, reportID, teamID);
		
	}
	

}
