import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phonebook implements Printable, TxtFile{

    private ArrayList<Contact> phonebook = new ArrayList<>();
    File output = new File("output.txt");
    File input = new File("input.txt");
    public Phonebook() {
    }
    public void addContact(Contact contact) {
        this.phonebook.add(contact);
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
    public void createContact() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите фамилию: ");
        String surname = in.nextLine();
        System.out.println("Введите номер телефона: ");
        String phoneNumber = in.nextLine();
        Contact contact = new Contact(name, surname, phoneNumber);
        this.phonebook.add(contact);
        this.showAllContacts();
        in.close();
    }
    public void deleteContact() throws Exception {
        this.showAllContacts();
        System.out.println("Введите номер строки с контактом, который Вы хотите удалить: ");
        Scanner in = new Scanner(System.in);
        try {
            int number = in.nextInt() - 1;
            this.phonebook.remove(number);
            this.showAllContacts();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
        in.close();
    }
    public void changeContact() {
        this.showAllContacts();
        System.out.println("Введите номер строки с контактом, который Вы хотите изменить: ");
        Scanner in = new Scanner(System.in);
        try {
            int number = in.nextInt() - 1;
            Contact changeableContact = this.phonebook.get(number);
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
                        this.phonebook.remove(number);
                        this.phonebook.add(number, changeableContact);
                        break;
                    case 2:
                        System.out.println("Введите новою фамилию: ");
                        String surname = in2.nextLine();
                        changeableContact.setSurname(surname);
                        this.phonebook.remove(number);
                        this.phonebook.add(number, changeableContact);
                        break;
                    case 3:
                        System.out.println("Введите новый номер телефона: ");
                        String phoneNumber = in2.nextLine();
                        changeableContact.setPhoneNumber(phoneNumber);
                        this.phonebook.remove(number);
                        this.phonebook.add(number, changeableContact);
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
                        this.phonebook.remove(number);
                        this.phonebook.add(number, changeableContact);
                        break;
                }
                in.close();
                in1.close();
                in2.close();
                this.showAllContacts();
            } catch (Exception e) {
                System.out.println("Что-то пошло не так");
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
    public void showAllContacts() {
        this.print();
    }
    public void exportContacts() throws Exception {
        this.saveToTxt();
    }
    public void importContacts() throws Exception {
        this.loadFromTxt();
    }
    public void findContact() throws Exception {
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
                    for (Contact contact : this.phonebook) {
                        if (contact.getName().equals(name)) {
                            contact.print();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите фамилию: ");
                    String surname = in1.nextLine();
                    for (Contact contact : this.phonebook) {
                        if (contact.getSurname().equals(surname)) {
                            contact.print();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Введите номер телефона: ");
                    String phoneNumber = in1.nextLine();
                    for (Contact contact : this.phonebook) {
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

    @Override
    public void saveToTxt() throws Exception {
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.output))) {
            for (Contact contact : this.phonebook) {
                writer.append(contact.toString()).append("\n").append("\n");
            }
            writer.flush();
            System.out.println("Контакты экспортированы успешно");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }

    @Override
    public void loadFromTxt() throws Exception {
        try {
            List<String> fileArray = Files.readAllLines(this.input.toPath());
            List<String> newFileArray = new ArrayList<>();
            for (String string : fileArray) {
                if (!string.equals("")) {
                    newFileArray.add(string);
                }
            }
            for (String string : newFileArray) {
                String[] words = string.split(" ");
                Contact contact = new Contact(words[0], words[1], words[2]);
                this.phonebook.add(contact);
            }
            System.out.println("Контакты успешно импортированы");
            this.print();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}