public class Main {
    public static void main(String[] args) throws Exception {
        Phonebook phonebook = new Phonebook();
        Contact con1 = new Contact("Ivan", "Ivanov", "123");
        Contact con2 = new Contact("Petr", "Petrov", "456");
        Contact con3 = new Contact("Sergei", "Sergeev", "789");
        Contact con4 = new Contact("Ivan", "Ivanov", "123");
        phonebook.getPhonebook().add(con1);
        phonebook.getPhonebook().add(con2);
        phonebook.getPhonebook().add(con3);
        phonebook.getPhonebook().add(con4);

        MenuImpl menuImpl = new MenuImpl();
        menuImpl.print();
        menuImpl.userChoiseInMenu(phonebook);
    }
}