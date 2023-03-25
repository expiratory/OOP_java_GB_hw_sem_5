import java.util.Scanner;

public class FindContactImpl implements FindContact{
    public FindContactImpl() {
    }

    @Override
    public void findContact(Phonebook phonebook) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Введите цифру соответствующую Вашему выбору:\n" +
                "1. Найти по имени\n" +
                "2. Найти по фамилии\n" +
                "3. Найти по номеру телефона\n");
        int choise = in.nextInt();
        try {
            Scanner in1 = new Scanner(System.in);
            switch (choise) {
                case 1:
                    System.out.println("Введите имя: ");
                    String name = in1.nextLine();
                    for (Contact contact : phonebook.getPhonebook()) {
                        if (contact.getName().equals(name)) {
                            contact.print();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите фамилию: ");
                    String surname = in1.nextLine();
                    for (Contact contact : phonebook.getPhonebook()) {
                        if (contact.getSurname().equals(surname)) {
                            contact.print();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Введите номер телефона: ");
                    String phoneNumber = in1.nextLine();
                    for (Contact contact : phonebook.getPhonebook()) {
                        if (contact.getPhoneNumber().equals(phoneNumber)) {
                            contact.print();
                        }
                    }
                    break;
            }
            in.close();
            in1.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}
