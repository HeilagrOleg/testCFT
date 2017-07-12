package andreev;

import andreev.sort.InsertionSort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.UnsupportedCharsetException;
import java.lang.IllegalArgumentException;
import java.util.*;

public class FileSorting {
    public static void main(String[] args) throws UnsupportedCharsetException {

        ArrayList<String> argumentsList = new ArrayList<>(Arrays.asList(args));
        ArrayList<String> stringsList = new ArrayList<>();
        ArrayList<Integer> integersList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String code;
        int stringCounter = 0;

        if (args.length < 4) {
            System.out.printf("Неверная команда%nНажмите любую клавишу, что бы выйте%n");
            s.nextLine();
            System.exit(0);
        }

        if (args.length > 4) {
            code = args[4];
        } else {
            code = "Windows-1251";
        }

        try {

            Scanner scanner = new Scanner(new FileInputStream(argumentsList.get(0)), code);

            while (scanner.hasNextLine()) {
                String a = scanner.nextLine();
                try {
                    integersList.add(Integer.parseInt(a));
                    stringCounter++;
                } catch (NumberFormatException number
                        ) {
                    stringsList.add(a);
                    stringCounter++;
                }
            }

            if (args[2].equals("i") || args[2].equals("s") || args[2].equals("full")) {
                switch (args[2]) {
                    case "i":
                        if (integersList.size() == 0) {
                            System.out.printf("В файле нет целых чисел%nНажмите любую клавишу, что бы выйте%n");
                            s.nextLine();
                            System.exit(0);
                        } else {
                            InsertionSort.sortByInsertInteger(integersList);
                        }
                        break;
                    case "s":
                        if (stringsList.size() == 0) {
                            System.out.printf("В файле нет строковых нечисловых значений%nНажмите любую клавишу, что бы выйте%n");
                            s.nextLine();
                            System.exit(0);
                        } else {
                            InsertionSort.sortByInsertString(stringsList);
                        }
                        break;
                    case "full":
                        if (stringsList.size() == 0 && integersList.size() == 0) {
                            System.out.printf("Файл не содержит символьных данныхй%nНажмите любую клавишу, что бы выйте%n");
                            s.nextLine();
                            System.exit(0);
                        } else {
                            InsertionSort.sortByInsertString(stringsList);
                            InsertionSort.sortByInsertInteger(integersList);
                        }
                        break;
                }
            } else {
                System.out.printf("Неверная команда%ni - сортировка челых чисел%ns - сортировка нечисловых строк%n" +
                        "full - сортировка всех строк%nНажмите любую клавишу, что бы выйте%n");
                s.nextLine();
                System.exit(0);
            }

            if (args[3].equals("a") || args[3].equals("d")) {
                if (args[3].equals("d")) {
                    Collections.reverse(stringsList);
                    Collections.reverse(integersList);
                }
            } else {
                System.out.printf("Неверная команда%na - сортировка по возрастанию%n" +
                        "d - сортировка по убыванию%nНажмите любую клавишу, что бы выйте%n");
                s.nextLine();
                System.exit(0);
            }

        } catch (FileNotFoundException read) {
            System.out.printf("Не удалось прочесть указанный файл%nНажмите любую клавишу, что бы выйте%n");
            s.nextLine();
            System.exit(0);
        } catch (IllegalArgumentException e) {
            System.out.printf("Неверная кодировка%nНажмите любую клавишу, что бы выйте%n");
            s.nextLine();
            System.exit(0);
        }

        try {
            PrintWriter writer = new PrintWriter(argumentsList.get(1));

            if (args[2].equals("i")) {
                for (Integer e : integersList) {
                    writer.println(e);
                }
                writer.print(System.lineSeparator());
            } else if (args[2].equals("s")) {
                for (String e : stringsList) {
                    if (e.length() > 0) {
                        writer.println(e);
                    }
                }
            } else if (args[2].equals("full")) {
                for (Integer e : integersList) {
                    writer.println(e);
                }

                writer.print(System.lineSeparator());

                for (String e : stringsList) {
                    if (e.length() > 0) {
                        writer.println(e);
                    }
                }
            }

            writer.close();

        }
        catch (FileNotFoundException write) {
            System.out.println("Не удалось записать в указанный файл");
        }

        System.out.printf("Всего обработано строк: %d", stringCounter);


    }
}
