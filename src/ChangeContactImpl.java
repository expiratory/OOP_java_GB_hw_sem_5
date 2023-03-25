import java.util.Scanner;

public class ChangeContactImpl implements ChangeContact{
    public ChangeContactImpl() {
    }

    @Override
    public void changeContact(Phonebook phonebook) throws Exception {
        phonebook.print();
        System.out.println("Введите номер строки с контактом, который Вы хотите изменить: ");
        Scanner in = new Scanner(System.in);
        try {
            int number = in.nextInt() - 1;
            Contact changeableContact = phonebook.getPhonebook().get(number);
            System.out.println("Введите цифру соответствующую Вашему выбору:\n" +
                    "1. Изменить имя\n" +
                    "2. Изменить фамилию\n" +
                    "3. Изменить номер телефона\n" +
                    "4. Изменить контакт полностью\n");
            Scanner in1 = new Scanner(System.in);
            int choise = in1.nextInt();
            try {
                Scanner in2 = new Scanner(System.in);
                switch (choise) {
                    case 1:
                        System.out.println("Введите новое имя: ");
                        String name = in2.nextLine();
                        changeableContact.setName(name);
                        phonebook.getPhonebook().remove(number);
                        phonebook.getPhonebook().add(number, changeableContact);
                        break;
                    case 2:
                        System.out.println("Введите новою фамилию: ");
                        String surname = in2.nextLine();
                        changeableContact.setSurname(surname);
                        phonebook.getPhonebook().remove(number);
                        phonebook.getPhonebook().add(number, changeableContact);
                        break;
                    case 3:
                        System.out.println("Введите новый номер телефона: ");
                        String phoneNumber = in2.nextLine();
                        changeableContact.setPhoneNumber(phoneNumber);
                        phonebook.getPhonebook().remove(number);
                        phonebook.getPhonebook().add(number, changeableContact);
                        break;
                    case 4:
                        System.out.println("Введите новое имя: ");
                        String newName = in2.nextLine();
                        System.out.println("Введите новую фамилию: ");
                        String newSurname = in2.nextLine();
                        System.out.println("Введите новый номер телефона: ");
                        String newPhoneNumber = in2.nextLine();
                        changeableContact.setName(newName);
                        changeableContact.setSurname(newSurname);
                        changeableContact.setPhoneNumber(newPhoneNumber);
                        phonebook.getPhonebook().remove(number);
                        phonebook.getPhonebook().add(number, changeableContact);
                        break;
                }
                in.close();
                in1.close();
                in2.close();
                phonebook.print();
            } catch (Exception e) {
                System.out.println("Что-то пошло не так");
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}
