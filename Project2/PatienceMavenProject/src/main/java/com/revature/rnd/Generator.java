package com.revature.rnd;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.revature.beans.Admin;
import com.revature.beans.Patient;
import com.revature.beans.Review;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.beans.nurse.Nurse;
import com.revature.beans.nurse.NurseCerts;

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
	public static UserPass[] generateUserPass(int quantity) {
		List<UserPass> ups = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			ups.add(new UserPass(usernames[random.nextInt(49)], passwords[random.nextInt(49)]));
		}
		return (UserPass[]) ups.toArray(new UserPass[ups.size()]);
	}

	public static String[] generateNames(int quantity) {
		return generateString(quantity, (String[]) names.toArray());
	}

	private static List<NurseCerts> generateNurseCerts(int quantity) {
		List<NurseCerts> certs = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			certs.add(new NurseCerts(nurseCertifications[random.nextInt(nurseCertifications.length)]));
		}
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
	// End Bean Components

	// Bean Modules
	public static List<Admin> generateAdmins(int quantity) {
		List<Admin> admins = new ArrayList<>();
		String[] str = generateNames(quantity);
		UserPass[] ups = generateUserPass(quantity);
		for (int i = 0; i < quantity; i++) {
			admins.add(new Admin(str[i], ups[i]));
		}
		return admins;
	}

	public static List<Patient> generatePatients(int quantity) {
		return null;
	}

	private static List<Review> generateReviews(int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<UserAccount> generateUsers(int quantity) {
		UserPass[] ups = generateUserPass(quantity);
		String[] name = generateNames(quantity);
		List<UserAccount> accounts = new ArrayList<>();
		// omitted lastlogin and profilepics
		// TODO:If I come back to this, include

		for (int i = 0; i < quantity; i++) {
			accounts.add(new UserAccount(ups[i], name[i], Date.valueOf(LocalDate.now())));
		}

		return accounts;
	}

	public static List<Nurse> generateNurses(int quantity) {
		List<Nurse> nurses = new ArrayList<>();
		UserPass[] ups = generateUserPass(quantity);
		String[] name = generateNames(quantity);
		String[] deps = generateDepartments(quantity);
		// Omitted Profile Pic

		for (int i = 0; i < quantity; i++) {
			nurses.add(new Nurse(
					generateNurseCerts(10), 
					generateReviews(10), 
					ups[i], 
					name[i], 
					deps[i]));
		}

		return nurses;
	}
	// End Bean Modules

}
