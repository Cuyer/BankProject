import controller.BankController;
import entity.BankStaff;
import entity.Customer;

public class Main {
    public static void main(String[] args) {
        BankController bankController = new BankController();

        Customer customer1 = new Customer("Jan", "Warszawa, Zielona 32a", "7122332423423423423432");
        Customer customer2 = new Customer("Paweł", "Łódź, Biała 3", "442554654654654654654654");
        Customer customer3 = new Customer("Przemysław", "Gdańsk, Krzywa 5", "32432432423423423432432");
        Customer customer4 = new Customer("Krzysztof", "Gdynia, Poprzeczna 9", "324234231566664656565");
        Customer customer5 = new Customer("Artur", "Katowice, Okrągła 2", "87887878787878787878787");

        BankStaff bankStaff = new BankStaff("Adrian", "Łódź, Warszawska 39", "2233");

        //Operacje wykonywane przez klientów

        //Dodanie kont do bazy danych
        bankController.openAccount(customer1);
        bankController.openAccount(customer2);
        bankController.openAccount(customer3);
        bankController.openAccount(customer4);
        bankController.getAccounts().forEach(customer -> System.out.println(customer.getName()));

        //Zamknięcie konta
        bankController.closeAccount(customer2);
        bankController.closeAccount(customer4);
        System.out.println();
        bankController.getAccounts().forEach(customer -> System.out.println(customer.getName()));

        //Depozyt środków
        System.out.println();
        System.out.println(bankController.checkBalance(customer1));
        bankController.deposit(customer1, 1000);
        System.out.println(bankController.checkBalance(customer1));


        //Wypłacenie środków
        System.out.println();
        bankController.withdraw(customer1, 500);
        System.out.println(bankController.checkBalance(customer1));


        //Udzielenie kredytu
        System.out.println();
        bankController.applyLoan(customer1, 10000, 15.34, 180);
        customer1.getLoanInfo();
        System.out.println(bankController.checkBalance(customer1));


        //Transfer środków
        System.out.println();
        System.out.println(bankController.checkBalance(customer1));
        System.out.println(bankController.checkBalance(customer3));
        bankController.transfer(customer1, 2000, customer3);
        System.out.println(bankController.checkBalance(customer1));
        System.out.println(bankController.checkBalance(customer3));


        // Operacje przeprowadzane przez pracownika
        bankStaff.openAccount(customer5);
        System.out.println();
        bankController.getAccounts().forEach(customer -> System.out.println(customer.getName()));

        // Sprawdzanie środków przez pracownika
        bankStaff.deposit(3000, customer1);
        System.out.println();
        System.out.println(bankStaff.checkBalance(customer5));
    }
}