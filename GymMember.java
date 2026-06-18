 /**
 * attributes of class GymMember is created,
 * constructor is made which initializes the member attributes,
 * getters method for each attribute is created,
 * abstract class markAttendance() is created to mark the attendance
 * activateMembership() and deactivateMembership() methods are made to activate and deactivate the 
 * activeStatus of the member,
 * resetMember() method is made to reset the activeStatus, attendance and loyaltyPoints to false, 0, and
 * 0.0 respectively of the member,
 * at last display() method is made to display all the member details individually.
 * @author (Eshaan Raj Raghubanshi)
 * @version (27/2/2025)
 */
abstract class GymMember
{
    // Attributes of the abstract class GymMember, instance variables 
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    // Constructor initializes member attributes
    public GymMember (int id, String name, String location, String phone,
    String email, String gender, String DOB, String membershipStartDate)
    {
    this.id = id;
    this.name = name;
    this.location = location;
    this.phone = phone;
    this.email = email; 
    this.gender = gender; 
    this.DOB = DOB;
    this.membershipStartDate = membershipStartDate;
    this.attendance = 0; // Attendance is initialized to zero
    this.loyaltyPoints = 0; // loyalty points in initialized to zero
    this.activeStatus = false; // active status is set to false by default, it is inactive
    }
    
    //getters methods for each attribute
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public int getAttendance() {
        return attendance;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }
    
    
    // Abstract method to be implemented in subclass
    public abstract void markAttendance();
    
    // Method to activate membership
    public void activateMembership() 
    /*
    return type void because it hasn't asked to return any value
    */
   
    {
    if (this.activeStatus == false)
    {
    this.activeStatus = true;
    System.out.println("The membership of member " + this.id + " is successfully activated.");
    }
    else {
    System.out.println("The membership of member " + this.id + " is already activated.");
    }
    }
    
    
    // Method to deactivate memebership if it is already active
    public void deactivateMembership()
    {
    if (this.activeStatus == true)
    {
    this.activeStatus = false;
    System.out.println("The membership of member " + this.id + " is successfully deactivated.");
    }
    else{
    System.out.println("The membership of member " + this.id + " is already deactivated.");
    }
    }
    
    // Resets member to default
    public void resetMember()
    {
        activeStatus = false;
        attendance = 0;
        loyaltyPoints = 0.0;
        System.out.println("Member details of the member " + this.id +
        "is successfully reset. Membership is now inactive.");
    }
    
    
   /**
    * Method to display member details
    * Method to display member details individually
    */
    public void display() {
    System.out.println("ID: " + this.id);
    System.out.println("Name: " + this.name);
    System.out.println("Location: " + this.location);
    System.out.println("Phone: " + this.phone);
    System.out.println("Email: " + this.email);
    System.out.println("Gender: " + this.gender);
    System.out.println("DOB: " + DOB);
    System.out.println("Membership Start Date: " + this.membershipStartDate);
    System.out.println("Attendance: " + this.attendance);
    System.out.println("Loyalty Points: " + this.loyaltyPoints);
    System.out.println("Active Status: " + (this.activeStatus ? "Active" : "Inactive"));
    } 
}
