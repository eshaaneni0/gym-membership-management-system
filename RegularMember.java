 /**
 * Attributes of class RegularMember is created.
 * Constructor is made for regular class which calls the superclass constructor.
 * Getters method is made to retrieve private attributes.
 * markAttendance() is made which overrides the method in GymMember to increase the attendance.
 * getPlanPrice() method is made with return type as double to retrieve the price of the provided plan.
 * upgradePlan() method is made with return type as String to upgrade the plan if eligible.
 *revertRegularMember() method is made which accepts removalReason as a parameter and calls a super class method resetMember().
 *display() method is made to display the details of RegularMember which has the same signature as the display method in the parent class.
 * @author (Eshaan Raj Raghubanshi)
 * @version (06/03/2025)
 */

public class RegularMember extends GymMember 
{
   
// markAttendacne() method over riding
//public void markAttendance()
//{}
    
    
private final int attendanceLimit = 30;
private boolean isEligibleForUpgrade;
private String removalReason, referralSource, plan;
private double price;

// Constructor for regular class, calls superclass constructor
public RegularMember (int id, String name, String location, String phone,
String email, String gender, String DOB, String membershipStartDate,
String referralSource)
{
super(id, name, location, phone, email, gender, DOB, membershipStartDate);
this.referralSource = referralSource;
this.isEligibleForUpgrade = false; // initially not eligible for upgrade
this.plan = "Basic"; // default plan is basic
this.price = 6500; // default price
this.removalReason = ""; // no removal reason initially
}

//Getter methods to retrieve private attributes
public int getAttendanceLimit()
{
return attendanceLimit;
}

public boolean isEligibleForUpgrade() //get is avoided as it violates Java naming conventions and reduces readability
{
return isEligibleForUpgrade;
}

public String getRemovalReason()
{
return removalReason;
}

public String getReferralSource()
{
return referralSource;
}

public String getPlan()
{
return plan;
}

public double getPrice()
{
return price;
}

public int getAttendance()
{
return attendance; 
}


/*
 Method to mark attendance, incrementing attendance and 
 checking for upgrade
 */
@Override
public void markAttendance()
{
 if (!activeStatus) { //if the member is inactive, it prints error before attempting to increment attendance.
        System.out.println("Cannot mark attendance. Membership is inactive.");
        return; // Stop further execution
    }
    
    attendance++; // increase the attendance by 1
    loyaltyPoints += 5; // increase the loyalty points by 5
    if (attendance >= attendanceLimit) {
        isEligibleForUpgrade = true; // allows upgrade once the limit is reached 
    }
}


// Method to get the price of a specified plan
public double getPlanPrice (String plan)
{
switch (plan.toLowerCase())
{
case "basic":
    return 6500;
    case "standard":
        return 12500;
        case "deluxe":
            return 18500;
            default:
                return -1; // returns -1 f the plan is invalid
            
}
}


//Method to upgrade plan if eligible
public String upgradePlan(String newPlan)
{
if (!isEligibleForUpgrade){
return "Upgrade not allowed. Attendance limit is not reached.";
}
if (this.plan.equalsIgnoreCase(newPlan)){ //checks if the user is already on the selected plan.
return "You are already on the selected plan.";
}
double newPrice = getPlanPrice (newPlan); /*
calls helper method getPlanPrice (newPlan) to retrieve the price of the new plan.
  */
if (newPrice == -1){ // checks if the plan is invalid. 
return "Invalid plan selected.";
}
this.plan = newPlan; // updates the user's plan to the new plan (newPlan)
this.price = newPrice; // updates the price based on the new plan (newPrice)
this.isEligibleForUpgrade = false; // Reset after upgrade to avoid unintended multiple upgrades(if set true)
return "Plan successfuly upgraded to "+ newPlan;
}

/*
 Method to revert a regularMember, 
 resetting values and setting removal reasons
 */
public void revertRegularMember (String removalReason)
{
resetMember(); // calls superclass method to reset member details
this.isEligibleForUpgrade = false;
this.plan = "basic"; //reset to default plan
this.price = 6500; // reset to default price
this.removalReason = removalReason;
this.attendance = 0; //reset attendace 
}

/*
 Method to display details of RegularMember, 
 including specific attributes
 */
@Override
public void display()
{
super.display(); //calls superclass display method
System.out.println("Plan: " + plan);
System.out.println("Price: " + price);
System.out.println("Attendance: " + attendance);
if (!removalReason.isEmpty()){ // checks if the removalReason string is not empty.
System.out.println("Removal Reason: "+ removalReason);
}
}
}

