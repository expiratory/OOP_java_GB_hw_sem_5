import java.util.Scanner;

public class DeleteContactImpl implements DeleteContact{
    public DeleteContactImpl() {
    }

    @Override
    public void deleteContact(Phonebook phonebook) throws Exception {
        phonebook.print();
        System.out.println("Введите номер строки с контактом, который Вы хотите удалить: ");
        Scanner in = new Scanner(System.in);
        try {
            int number = in.nextInt() - 1;
            phonebook.getPhonebook().remove(number);
            phonebook.print();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
        in.close();
    }
}
