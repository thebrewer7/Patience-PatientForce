package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.GenericBean;
import com.revature.beans.User;
import com.revature.beans.Patient;
import com.revature.dao.GenericDaoImpl;
import static com.revature.util.ConversionUtil.*;

public class UserService {
	private GenericDaoImpl<GenericBean> gdi = new GenericDaoImpl<>(GenericBean.class);

	public List<User> getAllUsers() {
		List<GenericBean> beans = getBeans();
		List<User> users = new ArrayList<>();

		beans.forEach(b -> users.add(beanToUser(b)));

		return users;
	}

	public User getUserById(Integer id) {
		List<GenericBean> beans = getBeans();
		for (GenericBean b : beans) {
			if (check(b, "id", id)) {
				return beanToUser(b);
			}
		}

		return new User();
	}

	public List<User> getUsersByName(String name) {
		List<GenericBean> beans = getBeans();
		List<User> users = new ArrayList<>();
		for (GenericBean b : beans) {
			if (check(b, "name", name)) {
				users.add(beanToUser(b));
			}
		}

		return users;
	}

	public List<User> getUsersByPatient(Integer patientId) {
		List<User> users = getAllUsers();
		List<User> returning = new ArrayList<>();

		for (User user : users) {
			if (user.getPatients().isEmpty()) {
				return null;
			} else {
				for (Patient p : user.getPatients()) {
					if (p.getId().equals(patientId)) {
						returning.add(user);
					}
				}
			}
		}

		return returning;
	}

	public Boolean insertNewUser(User user) {
		List<GenericBean> beans = getBeans();
		beans.add(userToBean(user));
		return gdi.saveOrUpdate(beans);
	}
	
	public Boolean updateUser(User user) {
		List<GenericBean> beans = getBeans();
		for(GenericBean b : beans) {
			if(check(b, "id", user.getId())) {
				b = userToBean(user);
			}
		}
		return gdi.saveOrUpdate(beans);
	}

	private List<GenericBean> getBeans() {
		return gdi.get("type", "user");
	}

	// End of Data Access Methods

	private Boolean check(GenericBean b, String key, Object expectedValue) {
		return b.getItem(key).equals(expectedValue);
	}

	private GenericBean userToBean(User user) {
		return new GenericBean(
				"user", 
				toStrArray(
						"id", "name", "role", "profilePicture", "lastLogin", "patients"),
				toObjArray(
						user.getId(), user.getName(), user.getRole(), 
						user.getProfilePicture(), user.getLastLogin(),
						user.getPatients())
				);
	}
	
//	@SuppressWarnings("unchecked")
//	private User beanToUser(GenericBean b) {
//		if(b.getItem("patients") != null && b.getItem("profilePicture") != null) {
//			return (new User(
//					b.getItem("name").toString(),
//					b.getItem("role").toString(),
//					toDt(b.getItem("lastLogin")),
//					(List<Patient>)b.getItem("patients"),
//					(Byte[])b.getItem("profilePicture")
//					));
//		}else if(b.getItem("profilePicture") != null) {
//			return (new User(
//					toInt(b.getItem("id")),
//					b.getItem("name").toString(),
//					b.getItem("role").toString(),
//					toDt(b.getItem("lastLogin")),
//					(List<Patient>)b.getItem("patients")
//					));
//		}else if(b.getItem("Patients") != null) {
//			return (new User(
//					toInt(b.getItem("id")),
//					b.getItem("name").toString(),
//					b.getItem("role").toString(),
//					toDt(b.getItem("lastLogin"))
//					));
//		}else {
//			return new User();
//		}
//	}
}
