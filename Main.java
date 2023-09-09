
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Persons person = EnterData("Введите данные о человеке ФИО и номер т через пробел: ");
            System.out.println(person);
            try (FileWriter writer = new FileWriter(person.getSecondName() + ".txt", true)) {
                writer.write(person.toString());
                writer.append('\n');
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } catch (EmptyStringException | CountFieldException | TypeDataExceptoin | FormatException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Persons EnterData(String message) throws CountFieldException, TypeDataExceptoin,
            FormatException, EmptyStringException {
        System.out.print(message);
        String[] data = new String[] { "" };
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            data = line.split(" ");
        }

        if (data.length < 4) {
            throw new CountFieldException("меньше");
        }
        if (data.length > 4) {
            throw new CountFieldException("больше");
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < data[i].length(); j++) {
                if (Character.isDigit(data[i].charAt(j))) {
                    throw new TypeDataExceptoin(i);
                }
            }
        }

        long phone;
        try {
            phone = Long.parseLong(data[3]);
        } catch (NumberFormatException e) {
            throw new TypeDataExceptoin(3);
        }

        if (phone < 0 | phone > 999999999999999l) {
            throw new FormatException();
        }

        Persons person = new Persons(data[0], data[1], data[2], phone);

        return person;
    }
}
