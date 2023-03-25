import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TxtFileImpl implements TxtFile{
    File output = new File("output.txt");
    File input = new File("input.txt");

    public TxtFileImpl() {
    }

    @Override
    public void saveToTxt(Phonebook phonebook) throws Exception {
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.output))) {
            for (Contact contact : phonebook.getPhonebook()) {
                writer.append(contact.toString()).append("\n").append("\n");
            }
            writer.flush();
            System.out.println("Контакты экспортированы успешно");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }

    @Override
    public void loadFromTxt(Phonebook phonebook) throws Exception {
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
                phonebook.getPhonebook().add(contact);
            }
            System.out.println("Контакты успешно импортированы");
            phonebook.print();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}
