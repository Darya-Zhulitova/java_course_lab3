import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        service();
    }

    public static void service() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        if (surname.isBlank()) {
            System.out.println("Incorrect surname");
            System.exit(0);
        }
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        if (surname.isBlank()) {
            System.out.println("Incorrect name");
            System.exit(0);
        }
        System.out.print("Введите отчество: ");
        String patronymic = scanner.nextLine();
        if (patronymic.isBlank()) {
            System.out.println("Incorrect patronymic");
            System.exit(0);
        }
        System.out.print("Введите дату рождения: ");
        String birthDate = scanner.nextLine();
        if (birthDate.isBlank()) {
            System.out.println("Incorrect date");
            System.exit(0);
        }

        String gender;
        if (patronymic.endsWith("ич")) {
            gender = "Мужской пол";
        } else if (patronymic.endsWith("на")) {
            gender = "Женский пол";
        } else {
            gender = "Пол не определен";
        }

        Calendar birth = Calendar.getInstance();
        try {
            StringTokenizer tokenizer = new StringTokenizer(birthDate, ".");
            String token = tokenizer.nextToken();
            int year = Integer.parseInt(token);
            token = tokenizer.nextToken();
            int month = Integer.parseInt(token);
            token = tokenizer.nextToken();
            int day = Integer.parseInt(token);
            if (tokenizer.hasMoreTokens()) {
                System.out.println("Incorrect date");
                System.exit(0);
            }
            birth.set(Calendar.YEAR, year);
            birth.set(Calendar.MONTH, month - 1);
            birth.set(Calendar.DAY_OF_MONTH, day);
        } catch (Exception ex) {
            System.out.println("Incorrect date");
            System.exit(0);
        }
        Calendar now = Calendar.getInstance();
        if (birth.after(now)) {
            System.out.println("Incorrect date");
            System.exit(0);
        }
        int age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (now.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
            age--;
        } else if (now.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
            if (now.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)) {
                age--;
            }
        }

        System.out.println("Фамилия, инициалы: " + surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".");
        System.out.println(gender);
        System.out.println("Возраст: " + age);
    }
}
