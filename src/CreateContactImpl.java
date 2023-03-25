import java.util.Scanner;

public class CreateContactImpl implements CreateContact{
    public CreateContactImpl() {
    }

    @Override
    public void createContact(Phonebook phonebook) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите фамилию: ");
        String surname = in.nextLine();
        System.out.println("Введите номер телефона: ");
        String phoneNumber = in.nextLine();
        Contact contact = new Contact(name, surname, phoneNumber);
        phonebook.getPhonebook().add(contact);
        phonebook.print();
        in.close();
    }
}
