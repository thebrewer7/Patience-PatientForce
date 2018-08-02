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
import com.revature.enums.ConditionTypes;

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
		List<Patient> patients = new ArrayList<>();
		UserPass[] ups = generateUserPass(quantity);
		String[] name = generateNames(quantity);
		String[] locations = generateLocations(quantity);
		String[] statuses = generatePatientStatus(quantity);
		ConditionTypes[] conditions = generateCondition(quantity);
		
		for(int i = 0; i < quantity; i++) {
			patients.add(new Patient(
						ups[i],
						name[i],
						locations[i],
						statuses[i],
						conditions[i]
					));
		}
		
		return patients;
	}

	private static List<Review> generateReviews(int quantity) {
		String[][][] branches = {
				{//negative - beginning, middle, and end
					{"What the hell, ", "My god what is wrong with, ", "Let me tell you, ", "I asked for the manager and "},
					{"this thing just really ", "the doctors here ", "this doctor ", "this nurse ", "got hit with a trombone ", "got propositioned by "},
					{", seriously...","really pompous.", "really pompous. Not coming back. EVER.", ". I just wonder why...", "tacos. And stuff..."}
				},
				{//neutral
					{"I don't really know why ", "No real feelings on ", "You'll never guess what happens when ", "Okay, ", "Alright, sooo "},
					{"just kinda meh ", "that really happened ", "things and stuff ", "I don't know "},
					{"I don't know...", "meh.", "lots of puss.", "my aching tentacles.", "that kind of thing."}
				},
				{//positive
					{"They really helped me a lot with ", "This cured all of my ", "So many tentacles got ", "Centuries of ", "What's up, "},
					{"my lot in life ", "my shrunken head collection ", "a lot of tentacles ", "... I forgot ", "alien baths "},
					{"along with my wife.", "horsing around.", " a tanning bed.", "so many tentacles"}
				}
		};
		
		String[] reviewsContent = new String[quantity];
		List<Review> reviews = new ArrayList<>();
		for(int i = 0; i < quantity; i++) {
			String[][] branch = branches[random.nextInt(3)];
			
			reviewsContent[i] = branch[0][random.nextInt(branch[0].length)] +
						 branch[1][random.nextInt(branch[1].length)] +
						 branch[2][random.nextInt(branch[2].length)];
			System.out.println(reviewsContent[i]);
			String date = (random.nextInt(18) + 2000) + "-" + (random.nextInt(12))+ "-" + (random.nextInt(28));
			System.out.println(date);
			reviews.add(new Review(
						random.nextInt(5),
						reviewsContent[i],
						Date.valueOf(date)
					));
			System.out.println(reviews.get(i));
		}
		return reviews;
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
			nurses.add(new Nurse(generateNurseCerts(10), generateReviews(10), ups[i], name[i], deps[i]));
		}

		return nurses;
	}
	// End Bean Modules

}
