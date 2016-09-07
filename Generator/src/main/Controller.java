package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import actions.Actions;
import actions.RoleInfo;
import generation.Generator;
import generation.RoleStorage;
import validator.MainValidator;

public class Controller {


	public static void main(String[] args) {

		// new Display(); // Display the screen
		// WHILE GUI IS WORKED ON
		ArrayList<String> roles = new ArrayList();
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		RoleStorage storage = new RoleStorage();
		MainValidator val = new MainValidator(storage, roles);
		Generator gen = new Generator(storage, roles, val);
		val.validate();
		if (val.getInfractions().size() != 0) {
			for (String inf: val.getInfractions()) {
				System.out.println(inf);
			}
		} else {
			ArrayList<String> result = gen.Generate();
			RoleInfo.populate(); // Generate investigative results
			Actions test = new Actions();
			test.generate(result);
		}

	}

}
