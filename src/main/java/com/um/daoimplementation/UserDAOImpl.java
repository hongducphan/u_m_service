package com.um.daoimplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.um.dao.UserDAO;
import com.um.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	EntityManager em;

	@Override
	public String testDaoPattern() {
		return "DAO Pattern";
	}

	@Override
	public List<User> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		
		Root<User> user = cq.from(User.class);
		CriteriaQuery<User> all = cq.select(user);
		TypedQuery<User> allQuery = em.createQuery(all);
		return allQuery.getResultList();
		
	}

}
