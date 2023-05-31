package BSTdictionary;
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