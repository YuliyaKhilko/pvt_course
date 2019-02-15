package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Page {

	ArrayList<Button> buttons = new ArrayList<Button>();
	LinkedList<Field> fields = new LinkedList<Field>();
	HashSet<Label> labels = new HashSet<Label>();
	HashMap<String, Dropdown> dropdowns = new HashMap<String, Dropdown>();
	float id;
	String title;
	
	
	public Page(float id, String title) {
		this.id = id;
		this.title = title;
	}


	public void addButton(Button button) {
		buttons.add(button);
	}
	
	public void removeButton(Button button) {
		buttons.remove(button);
	}
	
	public void replaceButton(int index, Button button) {
		buttons.set(index, button);
	}
	
	public void printButtons() {
		buttons.stream().forEach(button -> System.out.println(button));
	}
	
	public void addLabel(Label label) {
		labels.add(label);
	}
	
	public void removeLabel(Label label) {
		labels.remove(label);
	}
	
	public void printLabels() {
		labels.stream().forEach(label -> System.out.println(label));
	}

	public void addField(Field field) {
		fields.add(field);
	}
	
	public void removeField(Field field) {
		fields.remove(field);
	}
	
	public void replaceField(int index, Field field) {
		fields.set(index, field);
	}
	
	public void printFileds() {
		fields.stream().forEach(field -> System.out.println(field));
	}
	
	public void addDropdown(Dropdown dropdown) {
		dropdowns.put(dropdown.name, dropdown);
	}
	
	public void removeDropdown(Dropdown dropdown) {
		dropdowns.remove(dropdown.name);
	}
	
	public void replaceDropdown(Dropdown dropdown) {
		dropdowns.replace(dropdown.name, dropdown);
	}
	
	public void printDropdowns() {
		dropdowns.values().stream().forEach(dropdown -> System.out.println(dropdown));
	}
}
