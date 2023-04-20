import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        this.contacts.remove(contact);
    }

    public Contact searchContact(String name) {
        for (Contact contact: this.contacts) {
            if (contact.name.equals(name)) {
                return contact;
            }
        }
        return null;
    }










//    public static void main(String[] args) {
//
//    }
}
