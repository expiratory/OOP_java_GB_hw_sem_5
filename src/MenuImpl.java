import java.util.Scanner;

public class MenuImpl implements Menu, Printable {
    private String menuImpl = "Введите число, соответствующее выбранному Вами пункту:\n" +
            "1. Создать контакт\n" +
            "2. Удалить контакт\n" +
            "3. Изменить контакт\n" +
            "4. Показать все контакты\n" +
            "5. Экспорт контактов\n" +
            "6. Импорт контактов\n" +
            "7. Найти контакт\n";
    public MenuImpl() {
    }
    @Override
    public void print() {
        System.out.println(menuImpl);
    }

    @Override
    public void userChoiseInMenu(Phonebook phonebook) throws Exception {
            Scanner in = new Scanner(System.in);
            TxtFileImpl txtFileImpl = new TxtFileImpl();
            FindContactImpl findContactImpl = new FindContactImpl();
            ChangeContactImpl changeContactImpl = new ChangeContactImpl();
            DeleteContactImpl deleteContactImpl = new DeleteContactImpl();
            CreateContactImpl createContactImpl = new CreateContactImpl();
            try {
                int choise = in.nextInt();
                switch (choise) {
                    case 1:
                        createContactImpl.createContact(phonebook);
                        break;
                    case 2:
                        deleteContactImpl.deleteContact(phonebook);
                        break;
                    case 3:
                        changeContactImpl.changeContact(phonebook);
                        break;
                    case 4:
                        phonebook.print();
                        break;
                    case 5:
                        txtFileImpl.saveToTxt(phonebook);
                        break;
                    case 6:
                        txtFileImpl.loadFromTxt(phonebook);
                        break;
                    case 7:
                        findContactImpl.findContact(phonebook);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Что-то пошло не так");
            }
            in.close();
    }
}
