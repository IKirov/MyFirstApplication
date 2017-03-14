package com.ittalents.myfirstaplication.model;


import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import com.ittalents.myfirstaplication.model.RegularUser;
import com.ittalents.myfirstaplication.model.RegularUser.Category;
import com.ittalents.myfirstaplication.model.RegularUser.Notice;
import com.ittalents.myfirstaplication.model.RegularUser.SortNotice;
import com.ittalents.myfirstaplication.model.RegularUser.StateGood;
import com.ittalents.myfirstaplication.model.RegularUser.Type;

public class OLX {

	public static TreeSet<RegularUser> regularUsers;
	// mail -> password -> user
	// HashMap<String, TreeSet<RegularUser>> regularUsers;

	public static TreeSet<RegularUser> loggedRegularUsers;

	public static TreeMap<RegularUser.Category, ArrayList<RegularUser.Notice>> ads;

	public static TreeMap<RegularUser.Category, TreeSet<RegularUser.Notice>> archivedAds;

	private static OLX instance;

	private OLX() {
		super();

		this.regularUsers = new TreeSet<RegularUser>();
		this.loggedRegularUsers = new TreeSet<RegularUser>();
		this.ads = new TreeMap<RegularUser.Category, ArrayList<RegularUser.Notice>>();
		this.archivedAds = new TreeMap<RegularUser.Category, TreeSet<RegularUser.Notice>>();
	}

	void regUser(RegularUser user) {
		this.regularUsers.add(user);
	}

	public void logInUser(String mail, String password) {
		for (RegularUser regularUser : regularUsers) {
			if (regularUser.getMail().equals(mail)) {
				User user = (User) regularUser;
				if (user.getPassword().equals(password)) {
					// System.out.println("Wolcome " + regularUser.getName());
					this.loggedRegularUsers.add(regularUser);
					return;
				}
			}
		}
		System.out.println("Your mail or your password aren't correct! Pease, try again!");
	}

	public void logOutUser(RegularUser user) {
		for (RegularUser regularUser : loggedRegularUsers) {
			if (regularUser.equals(user)) {
				this.loggedRegularUsers.remove(regularUser);
			}
		}
	}

	public static OLX getInstance() {
		if (instance == null) {
			instance = new OLX();
		}
		return instance;
	}





}