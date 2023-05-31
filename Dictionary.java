package BSTdictionary;

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