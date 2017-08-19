package com.websystique.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.websystique.springmvc.model.Team;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.Data;
import com.websystique.springmvc.model.Role;
import com.websystique.springmvc.model.Report;
import com.websystique.springmvc.model.User_Access_Map;
import com.websystique.springmvc.wrapper.UserWrapper;


@Repository("managerDao")
public class ManagerDaoImpl extends AbstractDao<Integer, User> implements ManagerDao {
	
	@PersistenceUnit
	private EntityManager em;

	public List<User> findUser() {
		
		@SuppressWarnings("unchecked")
		List<User> li =  em.createQuery("Select * from user").getResultList();
		
		return li;
	}

	public UserWrapper findUserByUserName(String username) {
		
		UserWrapper uw = (UserWrapper) em.createQuery("Select a.user_id, a.user_name, b.role_id, b.role_name, c.team_id, c.team_name"
													+ " from user a"
												    + "left join role b on a.role_id = b.role_id"
												    + "left join team c on a.team_id = c.team_id"
												    + "where a.user_name  = ?1").setParameter(1, username).getSingleResult();
		
		/*
		 * Query q =  (Query) em.createNativeQuery("Select * from user a"
		  + "left join role b on a.role_id = b.role_id"
		  + "left join team c on a.team_id = c.team_id"
		  + "where a.user_name  = ?1");
			q.setParameter(1, username);
		*/
		
		
		/*
		 * Do I need to set the values to the WrapperClass(UserWrapper) and then return the Wrapper Class
		 * */
		
		
		
		return uw;
	}
	
	public boolean checkUAM(int uid, int rid){
		
		User_Access_Map uam = (User_Access_Map) em.createQuery("Select * form user_access_map "
															 + " where user_id = ?1 and report_id = ?2 ")
																.setParameter(1, uid)
																.setParameter(2, rid)
																.getSingleResult();
		
		if(uam != null)
			return true;
		else
			return false;
		
	}

	@SuppressWarnings("unchecked")
	public List<Team> getListOfTeams(int userID, int reportID, int teamID) {
		
		//check for the record in UAM
		boolean check = checkUAM(userID, reportID);
		List<Team> tm;
		
		if(check){
			tm = em.createQuery("Select * from team").getResultList();
			
		}else{
			tm = em.createQuery("SELECT DISTINCT a.team_id, a.team_name, "
								+ "IF( a.team_id = ?1, a.team_description , NULL ) AS team_description "
								+ "	FROM team a "
								+ "	LEFT JOIN user b ON a.team_id = b.team_id")
								.setParameter(1, teamID).getResultList();
		}
		
		return tm;
	}

	@SuppressWarnings("unchecked")
	public List<Role> getListOfRoles(int userID, int reportID) {
		
		boolean check = checkUAM(userID, reportID);
		List<Role> rl;
		
		if(check){
			rl = em.createQuery("Select * from role").getResultList();
			
		}else{
			rl = em.createQuery("Select a.role_id, a.role_name  from role a").getResultList();
		}
		
		return rl;
	}

	@SuppressWarnings("unchecked")
	public List<User> getListOfUsers(int userID, int reportID) {
		
		boolean check = checkUAM(userID, reportID);
		List<User> us; // use of wrapper class here
		
		if(check){
			us = em.createQuery("Select * from user").getResultList();
			
		}else{
			us = em.createQuery("Select a.user_id, a.user_name, a.team_id, b.team_name "
								 + " from user a "
								 + " left join team b ON a.team_id = b.team_id").getResultList();
		}

			
		return us;
	}

	@SuppressWarnings("unchecked")
	public List<Data> getDataOfEachUser(int userID, int reportID, int teamID) {
		
		boolean check = checkUAM(userID, reportID);
		List<Data> dt;
		
		if(check){
			dt = em.createQuery("Select * from data").getResultList();
			
		}else{
			dt = em.createQuery("SELECT a.data_id, a.user_id, b.user_name, a.project_count, "
										+ " IF( b.team_id = ?1, a.bug_count, NULL ) AS bug_count,  "
										+ " IF( b.team_id = ?2, a.feature_count, NULL ) AS feature_count,  " 
										+ " c.team_id, c.team_name,  "
										+ " IF( b.team_id = ?3, c.team_description, NULL ) AS team_description "
										+ " FROM data a  "
										+ " LEFT JOIN user b ON a.user_id = b.user_id "
										+ " LEFT JOIN team c ON b.team_id = c.team_id")
										.setParameter(1, teamID)
										.setParameter(2, teamID)
										.setParameter(3, teamID)
										.getResultList();
		}
		
		return dt;
	}

	@SuppressWarnings("unchecked")
	public List<Report> getListOfReports(int userID, int reportID) {
		
		boolean check = checkUAM(userID, reportID);
		List<Report> rt;
		
		if(check){
			rt = em.createQuery("Select * from report").getResultList();
			
		}else{
			rt = null;
		}
		
		
		return rt;
	}

	@SuppressWarnings("unchecked")
	public List<User_Access_Map> getListOfUAM(int userID, int reportID) {
		
		boolean check = checkUAM(userID, reportID);
		List<User_Access_Map> uam;
		
		if(check){
			uam = em.createQuery("Select * from user_access_map").getResultList();
			
		}else{
			uam = null;
		}
		
		return uam;
	}

	@SuppressWarnings("unchecked")
	public List<User> getListOfUserGivenTeam(int userID, int reportID, int teamID) {
		
		boolean check = checkUAM(userID, reportID);
		List<User> us; // use of wrapper class here
		
		if(check){
			us = em.createQuery("Select * from user a "
										 + "left join team b on a.team_id = b.team_id "
										 + "left join role c on a.role_id = c.role_id "
										 + "where a.team_id = ?1")
										.setParameter(1,  teamID)
										.getResultList();
			
		}else{
			us = em.createQuery("Select a.user_id, a.user_name, a.team_id, b.team_name "
										 + "from user a  "
										 + "left join team b on a.team_id = b.team_id "
										 + "where a.team_id = ?1")
										.setParameter(1, teamID)
										.getResultList();
		}
		
		return us;
	}

}
