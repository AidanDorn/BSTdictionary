//Aidan Dorn
//CS145
//May 24, 2023
package BSTdictionary;
import java.util.*;
class Node {
    int key;
    String firstName, lastName, address, city, state, zip, email, phoneNumber;
    Node left, right;
    public Node(int key, String firstName, String lastName, String address, String city, String state, String zip,
    String email, String phoneNumber) {
        this.key=key;
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.email=email;
        this.phoneNumber=phoneNumber;
        left=right=null;
    }
}
class Dictionary {
    Node root;
    Dictionary() {
        root=null;
    }
    void add(int key, String firstName, String lastName, String address, String city, String state, String zip,
    String email, String phoneNumber) {
        root=addEntry(root, key, firstName, lastName, address, city, state, zip, email, phoneNumber);
        System.out.println("Record added successfully.");
    }
    Node addEntry(Node root, int key, String firstName, String lastName, String address, String city, String state,
                String zip, String email, String phoneNumber) {
        if (root == null) {
            root=new Node(key, firstName, lastName, address, city, state, zip, email, phoneNumber);
            return root;
        }
        if (key < root.key)
            root.left=addEntry(root.left, key, firstName, lastName, address, city, state, zip, email, phoneNumber);
        else if (key > root.key)
            root.right=addEntry(root.right, key, firstName, lastName, address, city, state, zip, email, phoneNumber);
        return root;
    }
    void delete(int key) {
        if (root == null) {
            System.out.println("Dictionary is empty. No record to delete.");
            return;
        }
        root=deleteEntry(root, key);
    }
    Node deleteEntry(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left=deleteEntry(root.left, key);
        else if (key > root.key)
            root.right=deleteEntry(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            Node minValueNode=findMinValueNode(root.right);
            root.key=minValueNode.key;
            root.firstName=minValueNode.firstName;
            root.lastName=minValueNode.lastName;
            root.address=minValueNode.address;
            root.city=minValueNode.city;
            root.state=minValueNode.state;
            root.zip=minValueNode.zip;
            root.email=minValueNode.email;
            root.phoneNumber=minValueNode.phoneNumber;
            root.right=deleteEntry(root.right, minValueNode.key);
        }
        return root;
    }
    Node searchEntry(Node root, int key) {
      if (root == null || root.key == key)
          return root;
      if (key < root.key)
          return searchEntry(root.left, key);
      return searchEntry(root.right, key);
    }
    Node findMinValueNode(Node root) {
        while (root.left != null)
            root=root.left;
        return root;
    }
    void modify(int key, String field, String newValue) {
        Node node=searchEntry(root, key);
        if (node != null) {
            switch (field) {
                case "first name"->node.firstName=newValue;
                case "last name"->node.lastName=newValue;
                case "address"->node.address=newValue;
                case "city"->node.city=newValue;
                case "state"->node.state=newValue;
                case "zip"->node.zip=newValue;
                case "email"->node.email=newValue;
                case "phone number"->node.phoneNumber=newValue;
                default->System.out.println("Invalid field.");
            }
            System.out.println("Record modified successfully.");
        } else {
            System.out.println("Record with key "+key+" not found.");
        }
    }
    void lookup(String order) {
        switch (order) {
            case "1"->{
                System.out.println("Pre-order traversal:");
                preOrder(root);
            }
            case "2"->{
                System.out.println("In-order traversal:");
                inOrder(root);
            }
            case "3"->{
                System.out.println("Post-order traversal:");
                postOrder(root);
            }
            default->System.out.println("Invalid order.");
        }
    }
    void preOrder(Node root) {
        if (root != null) {
            System.out.println("Key: "+root.key);
            printRecordDetails(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println("Key: "+root.key);
            printRecordDetails(root);
            inOrder(root.right);
        }
    }
    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println("Key: "+root.key);
            printRecordDetails(root);
        }
    }
    void printRecordDetails(Node node) {
        System.out.println("First Name: "+node.firstName+"\nLast Name: "+node.lastName);
        System.out.println("Address: "+node.address);
        System.out.println("City: "+node.city);
        System.out.println("State: "+node.state);
        System.out.println("Zip: "+node.zip);
        System.out.println("Email: "+node.email);
        System.out.println("Phone Number: "+node.phoneNumber+"\n");
    }
}
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
                                                                                  
        """);
}