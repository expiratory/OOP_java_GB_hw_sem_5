import java.util.ArrayList;

public class Phonebook implements Printable{

    private ArrayList<Contact> phonebook = new ArrayList<>();

    public ArrayList<Contact> getPhonebook() {
        return phonebook;
    }

    public void setPhonebook(ArrayList<Contact> phonebook) {
        this.phonebook = phonebook;
    }

    public Phonebook() {
    }
    @Override
    public void print() {
        System.out.println("Список контактов: ");
        int count = 1;
        for (Contact contact: this.phonebook) {
            System.out.println(count + " " + contact.toString());
            count++;
        }
    }
}