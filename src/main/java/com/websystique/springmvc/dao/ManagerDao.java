package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Team;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.Data;
import com.websystique.springmvc.model.Role;
import com.websystique.springmvc.model.Report;
import com.websystique.springmvc.model.User_Access_Map;
import com.websystique.springmvc.wrapper.UserWrapper;

public interface ManagerDao {
	
	List<User> findUser();

	UserWrapper findUserByUserName(String username);

	List<Team> getListOfTeams(int userID, int ReportID, int teamID);

	List<Role> getListOfRoles(int userID, int reportID);

	List<User> getListOfUsers(int userID, int reportID);

	List<Data> getDataOfEachUser(int userID, int reportID, int teamID);

	List<Report> getListOfReports(int userID, int reportID);

	List<User_Access_Map> getListOfUAM(int userID, int reportID);

	List<User> getListOfUserGivenTeam(int userID, int reportID, int teamID);
	
}
