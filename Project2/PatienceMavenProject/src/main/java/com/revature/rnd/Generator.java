package com.revature.rnd;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.revature.beans.Admin;
import com.revature.beans.Patient;
import com.revature.beans.Review;
import com.revature.beans.SuperBean;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.beans.doctor.DocBackground;
import com.revature.beans.doctor.DocCerts;
import com.revature.beans.doctor.DocDegree;
import com.revature.beans.doctor.DocExperience;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import com.revature.beans.nurse.NurseCerts;
import com.revature.enums.ConditionTypes;
import com.revature.services.AdminService;
import com.revature.services.PatientService;
import com.revature.services.ReviewService;
import com.revature.services.UserPassService;
import com.revature.services.UserService;
import com.revature.services.doctor.DocBackgroundService;
import com.revature.services.doctor.DocCertsService;
import com.revature.services.doctor.DocDegreeService;
import com.revature.services.doctor.DocExperienceService;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseCertsService;
import com.revature.services.nurse.NurseService;

public class Generator {
	// Generated Names
	public static List<String> names = Arrays.asList("Temeka Cornforth", "Modesto Orme", "Augustus Prisbrey",
			"Tiffiny Hemmings", "Argentina Cowher", "Brigida Debruyn", "Herman Begaye", "Tania Crater",
			"Karima Glandon", "Marine Clem", "Fernande Rost", "Charlotte Joyal", "Bobbye Fisk", "Bernetta Ginsburg",
			"Doyle Backhaus", "Zenaida Drake", "Shaquita Gathers", "Exie Becerra", "Rena Kober", "Vanda Falk",
			"Sidney Gonsalves", "Stacee Gerhart", "Duane Alongi", "Shin Mcswain", "Alayna Cambra", "Marci Halpin",
			"Pamelia Sandford", "Belinda Tondreau", "Camellia Massenburg", "Frieda Summerford", "Laurinda Gammill",
			"Luann Auerbach", "Wyatt Fleeman", "Scarlett Charley", "Myles Sharif", "Cherilyn Mcivor", "Janie Choi",
			"Brain Rubino", "Mamie Sjoberg", "Magda Ogara", "Iliana Bynum", "Gina Pletcher", "Nedra Osburn",
			"Britt Modisette", "Rona Koger", "Latarsha Odem", "Ernesto Kowaleski", "Damaris Hock", "Gena Maravilla",
			"Mechelle Monzo");

	private static String usernames[] = { "hazel", "daghda", "sporulating", "trophyless", "hurt", "cellulating",
			"gaspinsula", "mastocarcinomata", "contraception", "graspingly", "idiosyncratic", "aritype", "argantua",
			"estoration", "gape", "onremonstrance", "uranic", "iscomfort", "reromantic", "edwing", "emima",
			"rerational", "andan", "ingfishes", "ynamics", "eteorically", "ed", "econcilement", "utright", "ylphid",
			"hildersburg", "ightclubber", "viduct", "cabrous", "urmi", "opyhold", "seudoindependent", "onzero",
			"lackboard", "cme", "zold", "odeos", "occygius", "anitu", "ackintosh", "eakless", "onnautical", "eptimal",
			"verbrilliant", "anthation" };

	private static String passwords[] = { "hazel", "daghda", "sporulating", "trophyless", "hurt", "cellulating",
			"gaspinsula", "mastocarcinomata", "contraception", "graspingly", "idiosyncratic", "aritype", "argantua",
			"estoration", "gape", "onremonstrance", "uranic", "iscomfort", "reromantic", "edwing", "emima",
			"rerational", "andan", "ingfishes", "ynamics", "eteorically", "ed", "econcilement", "utright", "ylphid",
			"hildersburg", "ightclubber", "viduct", "cabrous", "urmi", "opyhold", "seudoindependent", "onzero",
			"lackboard", "cme", "zold", "odeos", "occygius", "anitu", "ackintosh", "eakless", "onnautical", "eptimal",
			"verbrilliant", "anthation" };

	private static String departments[] = { "A&E", "Anaesthetics", "Cardiology", "Chaplaincy", "Critical Care",
			"Diagnostic Imaging", "Discharge", "Ear nose and throat", "Elderly Services", "Gastroenterology",
			"General Surgery", "Gynaecology", "Haematology", "Maternity", "Microbiology", "Neonatal", "Nephrology",
			"Neurology", "Nutrition and dietetics", "Obstetrics", "Occupational", "Oncology", "Ophthalmology",
			"Orthopaedics", "Pain Management", "Pharmacy", "Physiotherapy", "Radiotherapy", "Renal", "Rheumatology",
			"Sexaul Health", "Urology" };

	private static String[] nurseCertifications = { "A-GNP", "AACRN", "ACCNS-AG", "ACCNS-N", "ACCNS-P", "ACHPN",
			"ACNP-BC", "ACNPC-AG", "ACNS-BC", "ACRN", "ADM-BC", "AE-C", "AFN-B", "AGACNP-BC", "AGCNS-BC", "AGN-BC",
			"AGPCNP-BC", "AHN-BC", "ANP-BC", "ACNPC", "AOCN", "AOCNP", "AOCNS" };

	private static Random random = new Random();

	// Bean Components
	private static Iterator<UserPass> userPassIterator;
	public static void generateUserPass(int quantity) {
		Set<String> users = new HashSet<>();
		List<UserPass> ups = new ArrayList<>();
		do {
			users.add(usernames[random.nextInt(49)]);
		} while (users.size() < quantity * 5);

		users.forEach(username -> ups.add(new UserPass(username, passwords[random.nextInt(49)])));
		ups.forEach(new UserPassService()::saveOrUpdate);
		userPassIterator = ups.iterator();
	}

	public static String[] generateNames(int quantity) {
		return generateString(quantity, (String[]) names.toArray());
	}

	private static List<NurseCerts> generateNurseCerts(int quantity) {
		List<NurseCerts> certs = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			certs.add(new NurseCerts(nurseCertifications[random.nextInt(nurseCertifications.length)]));
		}
		certs.forEach(new NurseCertsService()::saveOrUpdate);
		return certs;
	}

	private static String[] generateDepartments(int quantity) {
		return generateString(quantity, departments);
	}

	private static String[] generateString(int quantity, String[] array) {
		String[] returning = new String[quantity];
		for (int i = 0; i < quantity; i++) {
			returning[i] = array[random.nextInt(array.length - 1)];
		}

		return returning;
	}

	private static String[] generateLocations(int quantity) {
		String[] locations = new String[quantity];
		for (int i = 0; i < quantity; i++) {
			locations[i] = "RM" + random.nextInt(300);
		}

		return locations;
	}

	private static String[] generatePatientStatus(int quantity) {
		String[] statusesPossible = { "Sleeping", "Comatose", "In Surgery", "Eating", "Being Discharged",
				"Surgery Prep", "Paperwork", "On-Boarding" };
		String[] statuses = new String[quantity];

		for (int i = 0; i < quantity; i++) {
			statuses[i] = statusesPossible[random.nextInt(statusesPossible.length)];
		}

		return statuses;
	}

	public static ConditionTypes[] generateCondition(int quantity) {
		ConditionTypes[] conditions = new ConditionTypes[quantity];

		for (int i = 0; i < quantity; i++) {
			conditions[i] = ConditionTypes.values()[random.nextInt(ConditionTypes.values().length)];
		}

		return conditions;
	}

	private static DocBackground[] generateDocBackground(int quantity) {
		List<DocBackground> backgrounds = new ArrayList<>();
		List<DocCerts> certs = generateDocCerts(quantity);
		List<DocDegree> degrees = generateDocDegrees(quantity);
		List<DocExperience> experience = generateDocExperience(quantity);

		for (int i = 0; i < quantity; i++) {
			backgrounds.add(new DocBackground(certs, degrees, experience));
		}
		backgrounds.forEach(new DocBackgroundService()::saveOrUpdate);
		return (DocBackground[]) backgrounds.toArray(new DocBackground[backgrounds.size()]);
	}

	private static List<DocExperience> generateDocExperience(int quantity) {
		List<DocExperience> experience = new ArrayList<>();
		String[][] branches = {
				{ "Immunology", "Anesthesiology", "Cardiology", "Colon", "Rectal", "Critical Care", "Dermatology",
						"Endocrinology", "Emergency Medicine", "Gastroenterology" },
				{ "Beriatric Surgeries", "Breast Augmentations", "Breast Reduction Surgeries", "Thyroid Surgeries",
						"Minimally Invasive Parathyroidectomies", "Laparoscopic Adrenalectomies", "General Surgeries",
						"Gynecological Surgeries", "Endometrial Ablations", "Gynecologic Cancer Surgeries",
						"Interventional Radiologies", "Tubal Ligations" } };
		for (int i = 0; i < quantity; i++) {
			int selected = random.nextInt(1);
			String[] branch = branches[selected];

			if (selected == 0) {
				experience.add(new DocExperience((random.nextInt(30) + 1) + // number of years
						"years in " + branch[random.nextInt(branch.length)]));// Field of Practice
			}
			experience.add(new DocExperience((random.nextInt(300) + 1) + branch[random.nextInt(branch.length)]));
		}

		experience.forEach(new DocExperienceService()::saveOrUpdate);
		return experience;
	}

	private static List<DocDegree> generateDocDegrees(int quantity) {
		String[] degree = { "Doctor of Medicine by research", "Doctor of Philosophy", "Master of Clinical Medicine",
				"Master of Medical Science", "Master of Medicine", "Master of Philosophy", "Master of Surgery",
				"Master of Science in Medicine", "Doctor of Clinical Medicine", "Doctor of Clinical Surgery",
				"Doctor of Medical Science", "Doctor of Surgery" };
		List<DocDegree> degrees = new ArrayList<>();

		for (int i = 0; i < quantity; i++) {
			degrees.add(new DocDegree(degree[random.nextInt(degree.length)]));
		}

		degrees.forEach(new DocDegreeService()::saveOrUpdate);
		return degrees;
	}

	private static List<DocCerts> generateDocCerts(int quantity) {
		String[] cert = { "ACCME", "ACGME", "AHA", "AMA", "AAMC", "CMSS", "ECFMG", "FSMB", "NBME" };
		List<DocCerts> certs = new ArrayList<>();

		for (int i = 0; i < quantity; i++) {
			certs.add(new DocCerts(cert[random.nextInt(cert.length)] + "Board Certified"));
		}

		certs.forEach(new DocCertsService()::saveOrUpdate);
		return certs;
	}

	// End Bean Components

	// Bean Modules
	public static List<Admin> generateAdmins(int quantity) {
		List<Admin> admins = new ArrayList<>();
		String[] str = generateNames(quantity);
		for (int i = 0; i < quantity; i++) {
			UserPass up = userPassIterator.next();
			up.setRole("admin");
			new UserPassService().saveOrUpdate(up);
			admins.add(new Admin(str[i], up));
		}
		
		admins.forEach(new AdminService()::saveOrUpdate);
		return admins;
	}

	public static List<Patient> generatePatients(int quantity) {
		List<Patient> patients = new ArrayList<>();
		String[] name = generateNames(quantity);
		String[] locations = generateLocations(quantity);
		String[] statuses = generatePatientStatus(quantity);
		ConditionTypes[] conditions = generateCondition(quantity);

		for (int i = 0; i < quantity; i++) {
			UserPass up = userPassIterator.next();
			up.setRole("patient");
			new UserPassService().saveOrUpdate(up);
			patients.add(new Patient(up, name[i], locations[i], statuses[i], conditions[i]));
		}

		patients.forEach(new PatientService()::saveOrUpdate);
		return patients;
	}

	private static List<Review> generateReviews(int quantity) {
		String[][][] branches = { { // negative - beginning, middle, and end
				{ "What the hell, ", "My god what is wrong with, ", "Let me tell you, ",
						"I asked for the manager and " },
				{ "this thing just really ", "the doctors here ", "this doctor ", "this nurse ",
						"got hit with a trombone ", "got propositioned by " },
				{ ", seriously...", "really pompous.", "really pompous. Not coming back. EVER.",
						". I just wonder why...", "tacos. And stuff..." } },
				{ // neutral
						{ "I don't really know why ", "No real feelings on ", "You'll never guess what happens when ",
								"Okay, ", "Alright, sooo " },
						{ "just kinda meh ", "that really happened ", "things and stuff ", "I don't know " },
						{ "I don't know...", "meh.", "lots of puss.", "my aching tentacles.", "that kind of thing." } },
				{ // positive
						{ "They really helped me a lot with ", "This cured all of my ", "So many tentacles got ",
								"Centuries of ", "What's up, " },
						{ "my lot in life ", "my shrunken head collection ", "a lot of tentacles ", "... I forgot ",
								"alien baths " },
						{ "along with my wife.", "horsing around.", " a tanning bed.", "so many tentacles" } } };

		String[] reviewsContent = new String[quantity];
		List<Review> reviews = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			String[][] branch = branches[random.nextInt(3)];

			reviewsContent[i] = branch[0][random.nextInt(branch[0].length)]
					+ branch[1][random.nextInt(branch[1].length)] + branch[2][random.nextInt(branch[2].length)];
			System.out.println(reviewsContent[i]);
			String date = (random.nextInt(18) + 2000) + "-" + (random.nextInt(11) + 1) + "-" + (random.nextInt(27) + 1);
			System.out.println(date);
			reviews.add(new Review(random.nextInt(5), reviewsContent[i], Date.valueOf(date)));
			System.out.println(reviews.get(i));
		}
		
		reviews.forEach(new ReviewService()::saveOrUpdate);
		return reviews;
	}

	public static List<UserAccount> generateUsers(int quantity) {
		String[] name = generateNames(quantity);
		List<UserAccount> accounts = new ArrayList<>();
		// omitted lastlogin and profilepics
		// TODO:If I come back to this, include

		for (int i = 0; i < quantity; i++) {
			UserPass up = userPassIterator.next();
			up.setRole("user");
			new UserPassService().saveOrUpdate(up);
			accounts.add(new UserAccount(up, name[i], Date.valueOf(LocalDate.now())));
		}
		
		accounts.forEach(new UserService()::saveOrUpdate);
		return accounts;
	}

	public static List<Nurse> generateNurses(int quantity) {
		List<Nurse> nurses = new ArrayList<>();
		String[] name = generateNames(quantity);
		String[] deps = generateDepartments(quantity);
		// Omitted Profile Pic

		for (int i = 0; i < quantity; i++) {
			UserPass up = userPassIterator.next();
			up.setRole("nurse");
			new UserPassService().saveOrUpdate(up);
			nurses.add(new Nurse(generateNurseCerts(10), generateReviews(10), up, name[i], deps[i]));
		}

		nurses.forEach(new NurseService()::saveOrUpdate);
		return nurses;
	}

	public static List<Doctor> generateDoctors(int quantity) {
		List<Doctor> doctors = new ArrayList<>();
		DocBackground[] backgrounds = generateDocBackground(quantity);
		String[] name = generateNames(quantity);
		String[] departments = generateDepartments(quantity);

		for (int i = 0; i < quantity; i++) {
			UserPass up = userPassIterator.next();
			up.setRole("doctor");
			new UserPassService().saveOrUpdate(up);
			doctors.add(new Doctor(backgrounds[i], generateReviews(10), up, name[i], departments[i]));
		}

		doctors.forEach(new DoctorService()::saveOrUpdate);
		return doctors;
	}
	// End Bean Modules

	public static SuperBean generateAll(int quantity) {
		generateUserPass(quantity);
		SuperBean bean = new SuperBean();
		List<Admin> admins = generateAdmins(quantity);
		List<Patient> patients = generatePatients(quantity);
		List<UserAccount> users = generateUsers(quantity);
		List<Nurse> nurses = generateNurses(quantity);
		List<Doctor> doctors = generateDoctors(quantity);
		List<Integer> nums = new ArrayList<>();

		for (int i = 0; i < quantity; i++) {
			Integer a = random.nextInt(quantity);
			if (!nums.contains(a)) {
				users.get(a).patients = new ArrayList<>();
				nurses.get(a).patients = new ArrayList<>();
				doctors.get(a).patients = new ArrayList<>();
				patients.get(a).users = new ArrayList<>();
				patients.get(a).nurses = new ArrayList<>();
				patients.get(a).doctors = new ArrayList<>();

				users.get(a).patients.add(patients.get(a));
				nurses.get(a).patients.add(patients.get(a));
				doctors.get(a).patients.add(patients.get(a));
				patients.get(a).users.add(users.get(a));
				patients.get(a).nurses.add(nurses.get(a));
				patients.get(a).doctors.add(doctors.get(a));
				
				new UserService().saveOrUpdate(users.get(a));
				new NurseService().saveOrUpdate(nurses.get(a));
				new DoctorService().saveOrUpdate(doctors.get(a));
				new PatientService().saveOrUpdate(patients.get(a));
			}
			nums.add(a);
		}
		bean.setAdmins(admins);
		bean.setPatients(patients);
		bean.setUsers(users);
		bean.setNurses(nurses);
		bean.setDoctors(doctors);

		return bean;
	}
}
