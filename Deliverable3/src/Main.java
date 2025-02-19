import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseHelper dbHelper = new DatabaseHelper();

        while (true) {
            // Prompt the user to enter an SQL command
            System.out.println("Please enter the SQL command to execute (or type 'exit' to quit): ");
            String sqlCommand = scanner.nextLine();

            // If the user types 'exit', break the loop and stop the program
            if (sqlCommand.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program...");
                break;
            }

            // Otherwise, execute the SQL command
            dbHelper.executeSqlCommand(sqlCommand);
        }

        scanner.close();  // Close the scanner
    }
}


