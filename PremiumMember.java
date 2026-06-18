
/**
 * Attributes of PremiumMember is created.
 * Constructor is made to initialize the PremiumMember attributes, calls the superclass constructor to initialize the common attributes.
 * Getters method is created to retrieve private attributes.
 * payDueAmount() method is created with return type as String to pay the due amount which accepts paidAmount as a parameter and update paid
 * amount accordingly.
 *calculateDiscount() method is created which calculates the discount amount once the payment is completed.
 *markAttendance() method is created to increase the attendance by 1 and loyaltyPoints by 10.
 *revertPremiumMember() method is made which calls the superclass method resetMember() to reset premium members details.
 *display() method is made to display all the details of the premium member.
 * @author (Eshaan Raj Raghubanhshi)
 * @version (06/03/2025)
 */
public class PremiumMember extends GymMember
{
    // Attributes specified to PremiumMember
    private final double premiumCharge; // Fixed charge for premium membership
    private String personalTrainer; // Name of assigned personal trainer
    private boolean isFullPayment; // True if the full payment is completed
    private double paidAmount; // Amount paid by the member
    private double discountAmount; // Discount received (if full payment is done)
    
    /*
     * Constructor to initialize PremiumMember attributes.
     * Calls the superclass constructor to initialize common attributes.
     */
     public PremiumMember(int id, String name, String location, String phone, 
                         String email, String gender, String DOB, 
                         String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000; // Premium charge is fixed at 50,000
        this.personalTrainer = personalTrainer; // Assign personal trainer
        this.isFullPayment = false; // Initially, payment is not completed
        this.paidAmount = 0; // No amount is paid initially
        this.discountAmount = 0; // No discount is applied initially
    }
    
        // Getter methods for retrieving private attributes
    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }
    
     /**
     * Method to process the due amount payment.
     * It accepts a payment amount and updates the paidAmount accordingly.
     */
    public String payDueAmount(double amount){ // receives paidAmount as parameter
        // If full payment is already done, return message
        if (this.isFullPayment == true) {
            return "Payment is already completed. No due amount left.";
        }
        
        // Check if the new total paid amount exceeds the premium charge
        if (this.paidAmount + amount > this.premiumCharge) {
            return "Payment exceeds the required amount. Please pay the exact or remaining amount.";
        }
        
        // Update paid amount
        this.paidAmount += amount;
        
        // Calculate remaining amount
        double remainingAmount = premiumCharge - this.paidAmount;
        
        // Update full payment status
        if (this.paidAmount == this.premiumCharge) {
            this.isFullPayment = true;
        }

        return "Payment successful! Remaining Amount: " + remainingAmount;
    }
    
     /**
     * Method to calculate discount based on payment status.
     * If full payment is completed, a 10% discount is applied.
     */
     //public void calculateDiscount() {
    public String calculateDiscount() {
        if (isFullPayment) {
            discountAmount = 0.1 * premiumCharge; // 10% discount applied
            //System.out.println("Discount applied successfully! Discount Amount: " + discountAmount);
            return "Discount applied successfully! Discount Amount: " + discountAmount;
        } else {
            //System.out.println("No discount available. Complete full payment to receive a discount.");
            return "No discount available. Complete full payment to receive a discount.";
        }
    }
    
    @Override
    public void markAttendance(){
    if (activeStatus) { // Ensure member is active
            attendance++; // Increment attendance count
            loyaltyPoints += 10; // Increase loyalty points by 5
        } else {
            System.out.println("Attendance cannot be marked. Membership is inactive.");
        }
    }
    
    /*
     * Method to reset premium member details.
     * Calls the superclass resetMember() method and resets additional attributes.
     */
    public void revertPremiumMember() {
        super.resetMember(); // Reset common attributes, calls from superclass 
        this.personalTrainer = ""; // Remove assigned trainer
        this.isFullPayment = false; // Reset payment status
        this.paidAmount = 0; // Reset paid amount, set to 0
        this.discountAmount = 0; // Reset discount amount, set to 0
    }
    
    /*
     * Method to display the details of PremiumMember.
     * Calls the superclass display method and adds premium-specific details.
     */
     @Override
    public void display() {
        super.display(); // Call superclass display method
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment Status: " + (isFullPayment ? "Completed" : "Pending"));
        System.out.println("Remaining Amount: " + (premiumCharge - paidAmount));

        // Display discount amount only if full payment is completed
        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
}
