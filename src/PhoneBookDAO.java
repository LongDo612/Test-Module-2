import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookDAO {
    private static ArrayList<PhoneBook> phoneBooks = new ArrayList<>();

    public void showPhoneBook() {
        for (PhoneBook phoneBook : phoneBooks) {
            System.out.println(phoneBook.toString());
        }
    }

    public void addPhoneBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Enter group: ");
        String group = scanner.next();
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter gender: ");
        String gender = scanner.next();
        System.out.println("Enter address: ");
        String address = scanner.next();
        System.out.println("Enter date of birth: ");
        String dateOfBirth = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        PhoneBook phoneBook = new PhoneBook(phoneNumber, group, name, gender, address, dateOfBirth, email);

        phoneBooks.ensureCapacity(phoneBooks.size());
        phoneBooks.add(phoneBook);
    }

    public void updatePhoneBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to update: ");

        String number = scanner.next();

        if (checkNumberExist(number)) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Nhom cua danh ba:");
            String group = scanner1.next();
            System.out.println("Ho ten:");
            String name = scanner1.next();
            System.out.println("Gioi tinh:");
            String gender = scanner1.next();
            System.out.println("Dia chi");
            String address = scanner1.next();
            System.out.println("Ngay sinh: ");
            String dateOfBirth = scanner1.next();
            System.out.println("Enter email: ");
            String email = scanner.next();
            PhoneBook phoneBook = new PhoneBook(number, group, name, gender, address, dateOfBirth, email);

            int index = getIndex(number);

            phoneBooks.set(index,phoneBook);
        }
    }

    public int getIndex(String number) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getPhoneNumber().equals(number))
                return i;
        }
        return -1;
    }

    public boolean checkNumberExist(String phone) {
        if (getIndex(phone)==-1) {
            return false;
        }
        return true;
    }


    public void deletePhoneBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so dien thoai de xoa: ");
        String number = scanner.next();
        if (checkNumberExist(number)){
            System.out.println("Ban co muon xoa danh ba nay khong?(bam Y de tiep tuc)");
            String confirm = scanner.next();
            if (confirm.equals("Y")){
                int index = getIndex(number);
                phoneBooks.remove(index);
            }
        }
    }

    public boolean validate(String regex) {
        Matcher matcher;
        String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
