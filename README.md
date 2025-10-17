# Accounting Ledger Application

## Applicatioin Description: 
This application helps you track deposits, and payments. The application also allows you to search 
transactions by deposits, payments, vendors, month to date, previous month, year to date, and previous year

## Features:
* Add deposits
* Make payment
* Display transactions using pre-defined reports
    * Month to Date
    * Previous Month
    * Year to Date
    * Previous Year
    * Search by Vendor
  
The code I'm probably most proud of is the method that runs the Reports menu. I was able to get this menu running
without encountering any issues pretty quickly. 

``` java
public static void runReports() {
boolean running = true;
        while (running) {
            displayReports();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "1":
                    displayMonthToDate();
                    break;
                case "2":
                    displayPreviousMonth();
                    break;
                case"3":
                    displayYearToDate();
                    break;
                case"4":
                    displayPreviousYear();
                    break;
                case"5":
                    displayByVendor();
                    break;
                case"0":
                    System.out.println("Returining to Ledger Screen...");
                    runLedger();
                case "H":
                    System.out.println("Exiting to Home Screen...");
                    running = false;
                    runMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // blank line for spacing
        }
    }
    public static void displayReports() {
        System.out.println("""
                ============== Reports ==============
                (1) Display by Month to Date
                (2) Display Previous Month
                (3) Display Year to Date
                (4) Display Previous Year
                (5) Display by Vendor
                (0) Return to Ledger
                (H) Exit to Home Screen""");
    }
```
### Images: 
* This image shows some formatting I did to display the transactions in a more readable format. I found
the code to get it formatted pretty interesting. 
![img.png](img.png)
 * This shows the Main menu
![img_1.png](img_1.png)
 * This shows the Ledger menu
![img_2.png](img_2.png)
* This shows the Reports menu
![img_3.png](img_3.png)