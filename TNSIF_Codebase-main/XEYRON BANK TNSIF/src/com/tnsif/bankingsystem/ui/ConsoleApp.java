package com.tnsif.bankingsystem.ui;

import com.tnsif.bankingsystem.admin.AdminService;
import com.tnsif.bankingsystem.admin.AdminServiceImpl;
import com.tnsif.bankingsystem.customer.CustomerService;
import com.tnsif.bankingsystem.customer.CustomerServiceImpl;
import com.tnsif.bankingsystem.model.Account;
import com.tnsif.bankingsystem.model.Beneficiary;
import com.tnsif.bankingsystem.model.Customer;
import com.tnsif.bankingsystem.model.Transaction;
import com.tnsif.bankingsystem.transaction.TransactionService;
import com.tnsif.bankingsystem.transaction.TransactionServiceImpl;
import com.tnsif.bankingsystem.util.DatabaseManager;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        DatabaseManager.initialize();

        Scanner sc = new Scanner(System.in);
        AdminService adminService = new AdminServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl();

        while (true) {
            System.out.println("\n----------------------------");
            System.out.println(" WELCOME TO XEYRON BANK TNSIF ");
            System.out.println("----------------------------");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Registration");
            System.out.println("3. Customer Login");
            System.out.println("4. Exit");
            System.out.println("----------------------------");
            int mainChoice = safeNextInt(sc, "Enter choice: ");

            switch (mainChoice) {
                case 1:
                    System.out.print("Enter Admin Username: ");
                    String adminUser = sc.nextLine();
                    System.out.print("Enter Admin Password: ");
                    String adminPass = sc.nextLine();
                    if (adminUser.equals("admin") && adminPass.equals("admin123")) {
                        adminDashboard(sc, adminService);
                    } else {
                        System.out.println("Invalid admin credentials.");
                    }
                    break;

                case 2:
                    int cid = safeNextInt(sc, "Customer ID: ");
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Create Password: ");
                    String pass = sc.nextLine();
                    boolean reg = customerService.registerCustomer(cid, name, address, contact, pass);
                    System.out.println(reg
                            ? "Registration submitted. Please wait for admin verification."
                            : "Registration failed. Customer ID already exist.");
                    break;

                case 3:
                    int loginId = safeNextInt(sc, "Customer ID: ");
                    System.out.print("Password: ");
                    String loginPass = sc.nextLine();
                    if (!customerService.isCustomerVerified(loginId)) {
                        System.out.println("Account not verified by admin.");
                        break;
                    }
                    boolean auth = customerService.authenticateCustomer(loginId, loginPass);
                    if (auth) {
                        customerDashboard(sc, loginId, customerService, transactionService);
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using XEYRON BANK TNSIF. Goodbye!");
                    DatabaseManager.close();
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void adminDashboard(Scanner sc, AdminService adminService) {
        while (true) {
            System.out.println("\n-------- ADMIN DASHBOARD | XEYRON BANK TNSIF --------");
            System.out.println("1. View All Customers");
            System.out.println("2. Verify Customers");
            System.out.println("3. View Customer Details");
            System.out.println("4. Logout");
            System.out.println("------------------------------------------------------");
            int choice = safeNextInt(sc, "Enter choice: ");

            switch (choice) {
                case 1:
                    List<Customer> customers = adminService.getAllCustomers();
                    if (customers.isEmpty()) {
                        System.out.println("No customers found.");
                    } else {
                        customers.forEach(System.out::println);
                    }
                    break;

                case 2:
                    List<Customer> unverified = adminService.getAllCustomers();
                    unverified.stream()
                            .filter(c -> !c.isVerified())
                            .forEach(System.out::println);
                    int vid = safeNextInt(sc, "Enter Customer ID to Verify: ");
                    boolean verified = adminService.verifyCustomer(vid);
                    System.out.println(verified
                            ? "Customer verified."
                            : "Failed (Reasons) - \nCustomer ID doesn't Exist \nCustomer Already Verified \nInvalid Customer ID");
                    break;

                case 3:
                    List<Customer> customerList = adminService.getAllCustomers();
                    if (customerList.isEmpty()) {
                        System.out.println("No registered customers available.");
                        break;
                    }
                    System.out.println("\nAvailable Customers:");
                    for (Customer customer : customerList) {
                        System.out.println("ID: " + customer.getCustomerId() + " | Name: " + customer.getName());
                    }

                    int custId = safeNextInt(sc, "Enter Customer ID to View Details: ");
                    Customer c = adminService.getCustomerById(custId);
                    if (c == null) {
                        System.out.println("Customer not found.");
                        break;
                    }

                    System.out.println("\n--- Customer Details ---");
                    System.out.println(c);

                    System.out.println("\n--- Accounts ---");
                    List<Account> accs = adminService.getAccountsByCustomer(custId);
                    if (accs.isEmpty()) {
                        System.out.println("No accounts found.");
                    } else {
                        accs.forEach(System.out::println);
                    }

                    System.out.println("\n--- Beneficiaries ---");
                    List<Beneficiary> bens = adminService.getBeneficiariesByCustomer(custId);
                    if (bens.isEmpty()) {
                        System.out.println("No beneficiaries found.");
                    } else {
                        bens.forEach(System.out::println);
                    }

                    System.out.println("\n--- Transactions ---");
                    System.out.println("Select Transaction Type to View: 1. Deposit  2. Withdrawal");
                    int tType = safeNextInt(sc, "Choice: ");
                    String txType = switch (tType) {
                        case 1 -> "Deposit";
                        case 2 -> "Withdrawal";
                        default -> {
                            System.out.println("Invalid transaction type.");
                            yield null;
                        }
                    };
                    if (txType != null) {
                        List<Transaction> txs = adminService.getTransactionsByCustomerAndType(custId, txType);
                        if (txs.isEmpty()) {
                            System.out.println("No transactions of type " + txType + " found.");
                        } else {
                            txs.forEach(System.out::println);
                        }
                    }
                    break;


                case 4:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }



    private static void customerDashboard(Scanner sc, int customerId,
                                          CustomerService customerService,
                                          TransactionService transactionService) {
        while (true) {
            System.out.println("\n-------- CUSTOMER DASHBOARD | XEYRON BANK TNSIF --------");
            System.out.println("1. Create Account");
            System.out.println("2. View My Accounts");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. View My Beneficiaries");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Transfer");
            System.out.println("8. View Transactions");
            System.out.println("9. Logout");
            System.out.println("---------------------------------------------------------");
            int choice = safeNextInt(sc, "Enter choice: ");

            switch (choice) {
                case 1:
                    int aid = safeNextInt(sc, "Account ID: ");
                    System.out.print("Type (Saving/Current): ");
                    String type = sc.nextLine();
                    double bal = safeNextDouble(sc, "Initial Balance: ");
                    boolean created = customerService.createAccount(
                            new Account(aid, customerId, type, bal)
                    );
                    System.out.println(created ? "Account created." : "Account ID already exists.");
                    break;

                case 2:
                    List<Account> accounts = customerService.getAccountsByCustomer(customerId);
                    accounts.forEach(System.out::println);
                    break;

                case 3:
                    int bid = safeNextInt(sc, "Beneficiary ID: ");
                    System.out.print("Name: ");
                    String bname = sc.nextLine();
                    int bacc = safeNextInt(sc, "Account Number: ");
                    System.out.print("Bank Details: ");
                    String bbank = sc.nextLine();
                    boolean badded = customerService.addBeneficiary(
                            new Beneficiary(bid, customerId, bname, bacc, bbank)
                    );
                    System.out.println(badded ? "Beneficiary added." : "Error adding beneficiary.");
                    break;

                case 4:
                    List<Beneficiary> benes = customerService.getBeneficiariesByCustomer(customerId);
                    benes.forEach(System.out::println);
                    break;

                case 5:
                    int depAid = safeNextInt(sc, "Account ID: ");
                    double depAmt = safeNextDouble(sc, "Amount: ");
                    boolean dep = transactionService.deposit(depAid, customerId, depAmt);
                    System.out.println(dep ? "Deposit successful." : "Deposit failed.");
                    break;

                case 6:
                    int widAid = safeNextInt(sc, "Account ID: ");
                    double widAmt = safeNextDouble(sc, "Amount: ");
                    boolean wid = transactionService.withdraw(widAid, customerId, widAmt);
                    System.out.println(wid ? "Withdrawal successful." : "Withdrawal failed.");
                    break;

                case 7:
                    int fromAid = safeNextInt(sc, "From Account ID: ");
                    int toAid = safeNextInt(sc, "To Account ID: ");
                    double transAmt = safeNextDouble(sc, "Amount: ");
                    boolean trans = transactionService.transfer(fromAid, customerId, toAid, transAmt);
                    System.out.println(trans ? "Transfer successful." : "Transfer failed.");
                    break;

                case 8:
                    int txAid = safeNextInt(sc, "Account ID: ");
                    // Validate ownership
                    List<Account> customerAccountsTx = customerService.getAccountsByCustomer(customerId);
                    boolean ownsTxAccount = customerAccountsTx.stream()
                        .anyMatch(a -> a.getAccountId() == txAid);
                    if (!ownsTxAccount) {
                        System.out.println("You can only view transactions of your own accounts.");
                        break;
                    }
                    List<Transaction> txs = customerService.getTransactionsByAccount(txAid);
                    if (txs.isEmpty()) {
                        System.out.println("No transactions found for this account.");
                    } else {
                        txs.forEach(System.out::println);
                    }
                    break;


                case 9:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Safe int input
    private static int safeNextInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                sc.nextLine();
            }
        }
    }

    // Safe double input
    private static double safeNextDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                double val = sc.nextDouble();
                sc.nextLine();
                return val;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                sc.nextLine();
            }
        }
    }
}
