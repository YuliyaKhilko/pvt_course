package core;

import java.util.Arrays;
import java.util.List;

public class Task12 {

	public static void main(String[] args) {
		Button cancelButton = new Button("Cancel", "Cancel changes");
		
		Page page = new Page (1, "Home page");
		page.addButton(new Button("Save", "Save changes"));
		page.addButton(cancelButton);
		page.addButton(new Button("Edit", "Edit changes"));
		page.removeButton(cancelButton);
		page.replaceButton(0, new Button("Reload", "Reload page"));
		page.printButtons();
		
		Field name = new Field(1, "Name");
		Field gender = new Field(1, "Gender");
		page.addField(new Field(2, "Surname"));
		page.addField(new Field(3, "age"));
		page.removeField(name);
		page.replaceField(1, gender);
		page.printFileds();
		
		Label good = new Label("Good");
		page.addLabel(new Label("Bad"));
		page.addLabel(new Label("Normal"));
		page.addLabel(good);
		page.removeLabel(good);
		page.printLabels();
		
		
		List<String> countries = Arrays.asList("Belarus", "Russia", "Ukraine");
		Dropdown countriesDropdown = new Dropdown(countries, true, "countries");
		page.addDropdown(countriesDropdown);
		List<String> animals = Arrays.asList("cat", "dog", "rat");
		Dropdown animalsDropdown = new Dropdown(animals, false, "anilmals");
		page.addDropdown(animalsDropdown);
		page.removeDropdown(countriesDropdown);
		page.printDropdowns();
		
	}

}
