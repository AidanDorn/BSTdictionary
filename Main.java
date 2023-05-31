//Aidan Dorn
//CS145
//May 24, 2023
package BSTdictionary;
import java.util.*;
class Main {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        Dictionary dictionary=new Dictionary();
        boolean active=true;
        System.out.println(ascii);
        System.out.println("Welcome to the Binary Search Tree Dictionary!\n");
        do{
            System.out.println("\nMenu:\n(1) Add a record\n(2) Delete a record\n(3) Modify a record\n(4) Lookup records\n(5) List number of records\n(6) Exit\nEnter your choice:");
            int choice=scanner.nextInt();
            switch (choice) {
                case 1->{
                    System.out.print("Enter primary key: ");
                    int key=scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    String firstName=getInput("Enter first name: ");
                    String lastName=getInput("Enter last name: ");
                    String address=getInput("Enter address: ");
                    String city=getInput("Enter city: ");
                    String state=getInput("Enter state: ");
                    String zip=getInput("Enter zip: ");
                    String email=getInput("Enter email: ");
                    String phoneNumber=getInput("Enter phone number: ");
                    dictionary.add(key, firstName, lastName, address, city, state, zip, email, phoneNumber);
                }
                case 2->{
                    System.out.print("Enter the key of the record to delete: ");
                    int deleteKey=scanner.nextInt();
                    dictionary.delete(deleteKey);
                }
                case 3->{
                    System.out.print("Enter the key of the record to modify: ");
                    int modifyKey=scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter the field to modify: ");
                    String field=scanner.nextLine();
                    System.out.print("Enter the new value: ");
                    String newValue=scanner.nextLine();
                    dictionary.modify(modifyKey, field, newValue);
                }
                case 4->{
                    System.out.println("Select the order for lookup\n (1) pre-order\n (2) in-order\n (3) post-order\n");
                    String order=scanner.next();
                    dictionary.lookup(order);
                }
                case 5->System.out.println("Number of records: "+getNumberOfRecords(dictionary.root));
                case 6->active=false;
                default->System.out.println("Invalid choice.");
            }
        }while(active==true);
        System.out.println("Program terminated.");
        scanner.close();
    }
    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public static int getNumberOfRecords(Node root) {
        if (root == null)
            return 0;
        return 1+getNumberOfRecords(root.left)+getNumberOfRecords(root.right);
    }
public static String ascii=("""

BBBBBBBBBBBBBBBBB      SSSSSSSSSSSSSSS TTTTTTTTTTTTTTTTTTTTTTT                                                                                                 
B::::::::::::::::B   SS:::::::::::::::ST:::::::::::::::::::::T                                                                                                 
B::::::BBBBBB:::::B S:::::SSSSSS::::::ST:::::::::::::::::::::T                                                                                                 
BB:::::B     B:::::BS:::::S     SSSSSSST:::::TT:::::::TT:::::T                                                                                                 
  B::::B     B:::::BS:::::S            TTTTTT  T:::::T  TTTTTT                                                                                                 
  B::::B     B:::::BS:::::S                    T:::::T                                                                                                         
  B::::BBBBBB:::::B  S::::SSSS                 T:::::T                                                                                                         
  B:::::::::::::BB    SS::::::SSSSS            T:::::T                                                                                                         
  B::::BBBBBB:::::B     SSS::::::::SS          T:::::T                                                                                                         
  B::::B     B:::::B       SSSSSS::::S         T:::::T                                                                                                         
  B::::B     B:::::B            S:::::S        T:::::T                                                                                                         
  B::::B     B:::::B            S:::::S        T:::::T                                                                                                         
BB:::::BBBBBB::::::BSSSSSSS     S:::::S      TT:::::::TT                                                                                                       
B:::::::::::::::::B S::::::SSSSSS:::::S      T:::::::::T                                                                                                       
B::::::::::::::::B  S:::::::::::::::SS       T:::::::::T                                                                                                       
BBBBBBBBBBBBBBBBB    SSSSSSSSSSSSSSS         TTTTTTTTTTT                                                                                                       
                                                    
By Aidan Dorn 
◞( ､ᐛ)､＿/ 
        """);
}