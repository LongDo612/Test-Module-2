import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("---- Chuong trinh quan li danh ba ----");
        System.out.println("Chon chuc nang theo so (de tiep tuc):");
        System.out.println("1. Xem danh sach");
        System.out.println("2. Them moi");
        System.out.println("3. Cap nhat");
        System.out.println("4. Xoa");
        System.out.println("5. Tim kiem");
        System.out.println("6. Doc tu file");
        System.out.println("7. Ghi vao file");
        System.out.println("8. Thoat");
        System.out.println("Chon chuc nang: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        PhoneBookDAO phoneBookDAO = new PhoneBookDAO();
        switch (choice){
            case 1:
                phoneBookDAO.showPhoneBook();
                menu();
                break;
            case 2:
                phoneBookDAO.addPhoneBook();
                menu();
                break;
            case 3:
                phoneBookDAO.updatePhoneBook();
                menu();
                break;
            case 4:
                phoneBookDAO.deletePhoneBook();
                menu();
                break;
//            case 5:
//
//                phoneBookDAO.getIndex()
            case 8:
                break;
        }
    }
}
