public class Menu implements Printable {
    private String menu = "Введите число, соответствующее выбранному Вами пункту:\n" +
            "1. Создать контакт\n" +
            "2. Удалить контакт\n" +
            "3. Изменить контакт\n" +
            "4. Показать все контакты\n" +
            "5. Экспорт контактов\n" +
            "6. Импорт контактов\n" +
            "7. Найти контакт\n";
    public Menu() {
    }
    @Override
    public void print() {
        System.out.println(menu);
    }
}
