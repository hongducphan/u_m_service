package com.um.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.um.model.Role;
import com.um.model.User;
import com.um.service.UserService;

@Repository
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private EntityManager em;

	@Override
	public List<User> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);

		Root<User> user = cq.from(User.class);
		CriteriaQuery<User> all = cq.select(user);
		TypedQuery<User> allQuery = em.createQuery(all);

		return allQuery.getResultList();
	}

	@Override
	public String add(String username, String password, String email, int roleId) {
		Role role = em.getReference(Role.class, roleId);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setRole(role);
		em.persist(user);
		return "Saved";
	}

	@Override
	public String addRole(String name) {

		Role role = new Role();
		role.setName(name);
		em.persist(role);

		return "Saved";
	}

	@Override
	public User findByUsername(String username) {
		return em.find(User.class, username);
	}

}
