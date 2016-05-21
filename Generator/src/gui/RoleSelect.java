package gui;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * RoleSelect - Class that is in charge of displaying the various pop-up
 * menus that allow the user to select the desired role/role category
 */
public class RoleSelect {

    private ArrayList<String> Town;
    private ArrayList<String> Mafia;
    private ArrayList<String> Neutral;
    private ArrayList<String> Random;
    private Panel origin;
    private Panel townPanel;
    private Panel mafiaPanel;
    private Panel neutralPanel;
    private Panel randomPanel;
    private Panel currentPanel = null;
    private int initx = 500;
    private int inity = 245;
    private int length = 200;
    private int height = 22;

    public RoleSelect(Panel target) {

        origin = target;
        townPanel = new Panel();
        mafiaPanel = new Panel();
        neutralPanel = new Panel();
        randomPanel = new Panel();
        Town = new ArrayList<>(Arrays.asList("Investigator", "Lookout", "Sheriff", "Spy",
                "Jailor", "Vampire Hunter", "Veteran", "Vigilante", "Bodyguard", "Doctor",
                "Escort", "Medium", "Mayor", "Retributionist", "Transporter"));
        Mafia = new ArrayList<>(Arrays.asList("Godfather", "Mafioso", "Disguisor", "Forger",
                "Framer", "Janitor", "Blackmailer", "Consort", "Consigliere"));
        Neutral = new ArrayList<>(Arrays.asList("Amnesiac", "Survivor", "Vampire", "Jester",
                "Executioner", "Witch", "Arsonist", "Serial Killer", "Werewolf"));
        Random = new ArrayList<>(Arrays.asList("Random Town", "Town Investigative", "Town Protective",
                "Town Killing", "Town Support", "Random Mafia", "Mafia Support", "Mafia Deception",
                "Random Neutral", "Neutral Benign", "Neutral Evil", "Neutral Killing", "Any"));
        configPanel(Town, townPanel);
        configPanel(Mafia, mafiaPanel);
        configPanel(Neutral, neutralPanel);
        configPanel(Random, randomPanel);
        origin.add(townPanel);
        origin.add(mafiaPanel);
        origin.add(neutralPanel);
        origin.add(randomPanel);

    }

    private void configPanel(ArrayList<String> roles, Panel destination) {

        Button roleButton;
        for (int i = 0; i < roles.size(); i++) {
            roleButton = new Button(roles.get(i));
            roleButton.addActionListener(new ButtonHandler());
            roleButton.setActionCommand(roles.get(i));
            roleButton.setBounds(initx, inity + i*height, length, height);
            destination.add(roleButton);
        }
        destination.setVisible(false);
        destination.setLayout(null);
        destination.setBounds(initx, inity, 200, height*roles.size());

    }

    public void showNewPanel(String name) {

        if (currentPanel != null) {
            currentPanel.setVisible(false);
        }
        switch (name) {
            case "Town":
                currentPanel = townPanel;
                break;
            case "Mafia":
                currentPanel = mafiaPanel;
                break;
            case "Neutral":
                currentPanel = neutralPanel;
                break;
            case "Random":
                currentPanel = randomPanel;
                break;
        }
        currentPanel.setVisible(true);

    }

}