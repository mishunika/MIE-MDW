package contact;

import java.util.ArrayList;

public class ContactDB {
	private ArrayList<Contact> contacts;
	
	public ContactDB() {
		contacts = new ArrayList<Contact>();
	}

	public void addContact(Contact contact) {
		for(Contact c : contacts) {
			if(c.getName().equals(contact.getName()) && c.getMail().equals(contact.getMail())) {
				return;
			}
		}
		
		contacts.add(contact);
	}
	
	public Contact getContact(String name, String mail) {
		for(Contact c : contacts) {
			if(c.getName().equals(name) && c.getMail().equals(mail)) {
				return c;
			}
		}
		
		return null;
	}
	
	public void removeContact(String name, String mail) {
		for(Contact c : contacts) {
			if(c.getName().equals(name) && c.getMail().equals(mail)) {
				contacts.remove(c);
				return;
			}
		}
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
}
