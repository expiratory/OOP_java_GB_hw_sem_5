import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Phonebook phonebook = new Phonebook();
        Contact con1 = new Contact("Ivan", "Ivanov", "123");
        Contact con2 = new Contact("Petr", "Petrov", "456");
        Contact con3 = new Contact("Sergei", "Sergeev", "789");
        Contact con4 = new Contact("Ivan", "Ivanov", "123");
        phonebook.addContact(con1);
        phonebook.addContact(con2);
        phonebook.addContact(con3);
        phonebook.addContact(con4);
        Menu menu = new Menu();
        menu.print();
        userChoiseInMenu(phonebook);
    }
    public static void userChoiseInMenu(Phonebook phonebook) throws Exception {
        Scanner in = new Scanner(System.in);
        try {
            int choise = in.nextInt();
            switch (choise) {
                case 1:
                    phonebook.createContact();
                    break;
                case 2:
                    phonebook.deleteContact();
                    break;
                case 3:
                    phonebook.changeContact();
                    break;
                case 4:
                    phonebook.showAllContacts();
                    break;
                case 5:
                    phonebook.exportContacts();
                    break;
                case 6:
                    phonebook.importContacts();
                    break;
                case 7:
                    phonebook.findContact();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
        in.close();
    }
}