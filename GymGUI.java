 
/**
 * array list is created to store objects of both RegularMember and PremiumMember objects
 * the gui for first section, regular member and premium member is also made.
 * @author (Eshaan Raj Raghubanshi)
 * @version (16/05/2025)
 */
    
/**
 * Import statements for the Gym Membership Management System
 * Organized by package and functionality for better maintainability
 */


import java.awt.BorderLayout;       // For border-based layout management
import java.awt.Color;              // For color manipulation
import java.awt.FlowLayout;         // For flow-based layout management
import java.awt.Font;               // For font styling and manipulation
import java.awt.Insets;             // For container insets and padding
import java.awt.event.ActionEvent;  // For action event handling
import java.awt.event.ActionListener; // For action listener interface


import java.io.BufferedReader;      // For efficient text reading
import java.io.ByteArrayOutputStream; // For byte array output operations
import java.io.File;               // For file system operations
import java.io.FileNotFoundException; // For file not found exceptions
import java.io.FileReader;         // For reading character files
import java.io.FileWriter;         // For writing character files
import java.io.IOException;        // For IO exception handling
import java.io.PrintStream;        // For printing to output streams


import java.util.ArrayList;         // For dynamic array implementation


import javax.swing.ButtonGroup;     // For grouping radio buttons
import javax.swing.JButton;         // For button component
import javax.swing.JComboBox;       // For dropdown combo boxes
import javax.swing.JFrame;          // For main application window
import javax.swing.JLabel;          // For text labels
import javax.swing.JOptionPane;     // For dialog boxes and alerts
import javax.swing.JPanel;          // For container panels
import javax.swing.JRadioButton;    // For radio button components
import javax.swing.JScrollPane;     // For scrollable containers
import javax.swing.JTextArea;       // For multi-line text display
import javax.swing.JTextField;      // For single-line text input
import javax.swing.ScrollPaneConstants; // For scroll pane constants

public class GymGUI implements ActionListener
{
//ArrayList <GymMember> arr = new ArrayList<GymMember>();


ArrayList <GymMember> arr = new ArrayList<GymMember>();

// Declare private fields for first section
private JFrame firstframe;
private JPanel firstpanel;
private JLabel firsttitleLabel;
private Color firstcc;
private JButton firstregularbutton;
private JButton firstpremiumbutton;

//FOR REGULAR MEMBER
 // Declare GUI components with "regmem" prefix to indicate Regular Member
private JFrame regmemFrame;
private JPanel regmemPanel;
private Color regmemBackgroundColor;

// Labels for the UI
private JLabel regmemTitleLabel, regmemSubHeadingLabel, regmemAddMemberLabel, regmemMemberIdLabel,
               regmemNameLabel, regmemLocationLabel, regmemPhoneLabel, regmemEmailLabel, regmemGenderLabel,
               regmemDobLabel, regmemStartDateLabel, regmemReferralLabel, regmemMembershipActionsLabel,
               regmemMemberIdActionLabel, regmemAttendanceLabel, regmemMemberIdMgmtLabel, regmemSelectPlanLabel,
               regmemSystemActionsLabel;

// TextFields for user input
private JTextField regmemMemberIdField, regmemNameField, regmemLocationField, regmemPhoneField,
                   regmemEmailField, regmemDobField, regmemStartDateField, regmemReferralField,
                   regmemMemberActionField, regmemMemberMgmtField;

// Radio buttons for gender selection
private JRadioButton regmemMaleRadio, regmemFemaleRadio, regmemOtherRadio;
private ButtonGroup regmemGenderGroup;

// Combo box for selecting membership plan
private JComboBox<String> regmemPlanCombo;

// Buttons for various actions
private JButton regmemAddMemberBtn, regmemActivateBtn, regmemDeactivateBtn, regmemRevertBtn,
                regmemMarkAttendanceBtn, regmemUpgradeBtn, regmemDisplayBtn, regmemClearBtn,
                regmemSaveBtn, regmemReadBtn;
                
private JComboBox<String> regdobYearCombo;
private JComboBox<String> regdobMonthCombo;
private JComboBox<String> regdobDayCombo;

private JComboBox<String> regstartYearCombo;
private JComboBox<String> regstartMonthCombo;
private JComboBox<String> regstartDayCombo;

// For both regular and premium member panels
private JButton regmemBackButton;  // Back button for regular member panel
private JButton premmemBackButton; // Back button for premium member panel

    
//FOR PREMIUMMEMBERS
// Declare private fields
private JFrame premmemframe;
private JPanel premmempanel;
private JLabel premmemtitleLabel, premmemmemberTypeLabel;
private JLabel premmemmemberIdLabel, premmemnameLabel, premmemlocationLabel, premmemphoneLabel, premmememailLabel, premmemgenderLabel,
               premmemdobLabel, premmemstartDateLabel, premmemtrainerLabel;
private JTextField premmemmemberIdField, premmemnameField, premmemlocationField, premmemphoneField, premmememailField,
                   premmemdobField, premmemstartDateField, premmemtrainerField;
private JRadioButton premmemmaleRadio, premmemfemaleRadio, premmemotherRadio;
private ButtonGroup premmemgenderGroup;
private JButton premmemaddButton;

private JLabel premmemmembershipSectionLabel, premmemmembershipIdLabel;
private JTextField premmemmembershipIdField;
private JButton premmemactivateButton, premmemdeactivateButton, premmemrevertButton, premmemmarkAttendanceButton;

private JLabel premmemfinancialSectionLabel, premmemfinancialIdLabel, premmemfinancialIdLabel2, premmemamountLabel;
private JTextField premmemfinancialIdField, premmemfinancialIdField2, premmemamountField;
private JButton premmemcalculateDiscountButton, premmempayAmountButton;

private JLabel premmemsystemSectionLabel;
private JButton premmemdisplayButton, premmemclearButton, premmemsaveButton, premmemreadButton;

//added
private Color premmemcc;

private JComboBox<String> premdobYearCombo;
private JComboBox<String> premdobMonthCombo;
private JComboBox<String> premdobDayCombo;

private JComboBox<String> premstartYearCombo;
private JComboBox<String> premstartMonthCombo;
private JComboBox<String> premstartDayCombo;




// For the display frame
private JFrame displayFrame;
private JTextArea displayTextArea;
private JScrollPane scrollPane;


// File path constants
private static final String FILE_PATH = "C:/Users/Acer/OneDrive/Uni/Programming/24046384 Eshaan Raj Raghubanshi/24046384 Eshaan Raj Raghubanshi/MemberDetails.txt";
private JFrame fileDisplayFrame;
private JTextArea fileDisplayArea;


/**
 * Main constructor - Initializes the GUI and shows the first screen.
 */
public GymGUI() 
    {
       firstsection();
       
    }

   /**
 * This method handles ALL button clicks in the program.
 * It's like the brain of the GUI that decides what happens
 * when you click any button. It checks which button was clicked
 * and then does the appropriate action.
 * 
 * It handles:
 * - Switching between screens (regular/premium)
 * - Adding new members
 * - Member management (activate/deactivate)
 * - Attendance marking
 * - File operations (save/load)
 */
public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();

    // === Switching Between Forms ===
    if (source == firstregularbutton) {
        regularmember(); // Load regular member form
    } else if (source == firstpremiumbutton) {
        premiummember(); // Load premium member form
    }

    // === Logic for "Add Regular Member" button ===
    if (source == regmemAddMemberBtn) {
    // Extract Regular Member form values
    String regIdStr = regmemMemberIdField.getText();
    String regName = regmemNameField.getText();
    String regLocation = regmemLocationField.getText();
    String regPhone = regmemPhoneField.getText();
    String regEmail = regmemEmailField.getText();
    String regReferral = regmemReferralField.getText();
    String regGender = regmemMaleRadio.isSelected() ? "Male" :
                       regmemFemaleRadio.isSelected() ? "Female" :
                       regmemOtherRadio.isSelected() ? "Other" : "";

    // Extract DOB and Start Date from combo boxes
    String regDob = regdobYearCombo.getSelectedItem() + "/" +
                    regdobMonthCombo.getSelectedItem() + "/" +
                    regdobDayCombo.getSelectedItem();

    String regStartDate = regstartYearCombo.getSelectedItem() + "/" +
                          regstartMonthCombo.getSelectedItem() + "/" +
                          regstartDayCombo.getSelectedItem();

    // Step 1: Check for empty fields
    if (regIdStr.equals("") || regName.equals("") || regLocation.equals("") || regPhone.equals("") ||
        regEmail.equals("") || regGender.equals("") || regReferral.equals("")) {

        JOptionPane.showMessageDialog(regmemPanel, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(regIdStr);

        // Step 2: Check for duplicate ID
        for (GymMember member : arr) {
            if (member.getId() == id) {
                JOptionPane.showMessageDialog(regmemPanel, "Member ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Step 3: Create and add RegularMember
        RegularMember reg = new RegularMember(id, regName, regLocation, regPhone, regEmail, regGender, regDob, regStartDate, regReferral);
        arr.add(reg);

        JOptionPane.showMessageDialog(regmemPanel, "Regular member added successfully!");

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(regmemPanel, "Invalid input for Member ID. It should be a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    // === Logic for "Add Premium Member" button ===
if (source == premmemaddButton) {
    // Extract Premium Member form values only if this button was clicked
    String premIdStr = premmemmemberIdField.getText().trim();  // Added trim()
    String premName = premmemnameField.getText().trim();
    String premLocation = premmemlocationField.getText().trim();
    String premPhone = premmemphoneField.getText().trim();
    String premEmail = premmememailField.getText().trim();
    String premTrainer = premmemtrainerField.getText().trim();
    String premGender = premmemmaleRadio.isSelected() ? "Male" :
                       premmemfemaleRadio.isSelected() ? "Female" :
                       premmemotherRadio.isSelected() ? "Other" : "";

    // Extract DOB from combo boxes
    String premDob = premdobYearCombo.getSelectedItem().toString() + "/" +
                    premdobMonthCombo.getSelectedItem().toString() + "/" +
                    premdobDayCombo.getSelectedItem().toString();

    // Extract Start Date from combo boxes
    String premStartDate = premstartYearCombo.getSelectedItem().toString() + "/" +
                          premstartMonthCombo.getSelectedItem().toString() + "/" +
                          premstartDayCombo.getSelectedItem().toString();

    // Step 1: Check for empty fields
    if (premIdStr.isEmpty() || premName.isEmpty() || premLocation.isEmpty() || premPhone.isEmpty() ||
        premEmail.isEmpty() || premGender.isEmpty() || premTrainer.isEmpty()) {

        JOptionPane.showMessageDialog(premmempanel, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(premIdStr);

        // Step 2: Check for duplicate ID
        for (GymMember member : arr) {
            if (member.getId() == id) {
                JOptionPane.showMessageDialog(premmempanel, "Member ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Step 3: Create and add PremiumMember
        PremiumMember premium = new PremiumMember(id, premName, premLocation, premPhone, premEmail, 
                                                premGender, premDob, premStartDate, premTrainer);
        arr.add(premium);

        JOptionPane.showMessageDialog(premmempanel, "Premium member added successfully!");

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(premmempanel, "Invalid input for Member ID. It should be a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    //Object source = e.getSource();

// === Regular Member: Mark Attendance ===
if (source == regmemMarkAttendanceBtn) {
    String idStr = regmemMemberMgmtField.getText().trim();

    // Check for empty input
    if (idStr.isEmpty()) {
        JOptionPane.showMessageDialog(regmemPanel, 
            "Please enter the Member ID.", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof RegularMember && member.getId() == id) {
                found = true;
                
                // Check if member is active (using isActiveStatus())
                if (!member.isActiveStatus()) {
                    JOptionPane.showMessageDialog(regmemPanel,
                        "Cannot mark attendance. Member ID " + id + " is INACTIVE.\n" +
                        "Please activate the membership first.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                } 
                else {
                    member.markAttendance();
                    String message = "Attendance marked for Regular Member ID: " + id;
                    
                    // Check upgrade eligibility (cast to RegularMember)
                    if (((RegularMember)member).isEligibleForUpgrade()) {
                        message += "\nThis member is now eligible for upgrade!";
                    }
                    
                    JOptionPane.showMessageDialog(regmemPanel, message);
                }
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(regmemPanel, 
                "Regular Member with ID " + id + " not found.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(regmemPanel, 
            "Invalid Member ID. Please enter a numeric value.", 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// === Regular Member: Upgrade Plan ===
if (source == regmemUpgradeBtn) {
    String idStr = regmemMemberMgmtField.getText();
    String selectedPlan = (String) regmemPlanCombo.getSelectedItem();

    if (idStr.equals("")) {
        JOptionPane.showMessageDialog(regmemPanel, "Please enter the Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof RegularMember && member.getId() == id) {
                ((RegularMember) member).upgradePlan(selectedPlan);
                JOptionPane.showMessageDialog(regmemPanel, "Plan upgraded to " + selectedPlan + " for Regular Member ID: " + id);
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(regmemPanel, "Regular Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(regmemPanel, "Invalid Member ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// === Premium Member: Mark Attendance ===
if (source == premmemmarkAttendanceButton) {
    String idStr = premmemmembershipIdField.getText().trim(); // Trim whitespace

    // Check for empty input
    if (idStr.isEmpty()) {
        JOptionPane.showMessageDialog(premmempanel, 
            "Please enter the Member ID.", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof PremiumMember && member.getId() == id) {
                found = true;
                
                // Check if member is active using isActiveStatus()
                if (!member.isActiveStatus()) {
                    JOptionPane.showMessageDialog(premmempanel,
                        "Cannot mark attendance. Premium Member ID " + id + " is INACTIVE.\n" +
                        "Please activate the membership first.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                } 
                else {
                    member.markAttendance();
                    JOptionPane.showMessageDialog(premmempanel, 
                        "Attendance marked for Premium Member ID: " + id +
                        "\n+10 Loyalty Points added.",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(premmempanel, 
                "Premium Member with ID " + id + " not found.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(premmempanel, 
            "Invalid Member ID. Please enter a numeric value.", 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// === Premium Member: Activate Member ===
if (source == premmemactivateButton) {
    String idStr = premmemmembershipIdField.getText();

    if (idStr.equals("")) {
        JOptionPane.showMessageDialog(premmempanel, "Please enter the Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof PremiumMember && member.getId() == id) {
                ((GymMember) member).activateMembership();
                JOptionPane.showMessageDialog(premmempanel, "Premium Member ID " + id + " activated.");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(premmempanel, "Premium Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(premmempanel, "Invalid Member ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// === Premium Member: Deactivate Member ===
if (source == premmemdeactivateButton) {
    String idStr = premmemmembershipIdField.getText();

    if (idStr.equals("")) {
        JOptionPane.showMessageDialog(premmempanel, "Please enter the Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof PremiumMember && member.getId() == id) {
                ((GymMember) member).deactivateMembership();
                JOptionPane.showMessageDialog(premmempanel, "Premium Member ID " + id + " deactivated.");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(premmempanel, "Premium Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(premmempanel, "Invalid Member ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// === Premium Member: Revert Member ===
if (source == premmemrevertButton) {
    String idStr = premmemmembershipIdField.getText();

    if (idStr.equals("")) {
        JOptionPane.showMessageDialog(premmempanel, "Please enter the Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof PremiumMember && member.getId() == id) {
                ((PremiumMember) member).resetMember();
                JOptionPane.showMessageDialog(premmempanel, "Premium Member ID " + id + " reverted to previous state.");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(premmempanel, "Premium Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(premmempanel, "Invalid Member ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// === Regular Member: Activate Member ===
if (source == regmemActivateBtn) {
    String idStr = regmemMemberActionField.getText();

    if (idStr.equals("")) {
        JOptionPane.showMessageDialog(regmemPanel, "Please enter the Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof RegularMember && member.getId() == id) {
                ((GymMember) member).activateMembership();
                JOptionPane.showMessageDialog(regmemPanel, "Regular Member ID " + id + " activated.");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(regmemPanel, "Regular Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(regmemPanel, "Invalid Member ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// === Regular Member: Deactivate Member ===
if (source == regmemDeactivateBtn) {
    String idStr = regmemMemberActionField.getText();

    if (idStr.equals("")) {
        JOptionPane.showMessageDialog(regmemPanel, "Please enter the Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof RegularMember && member.getId() == id) {
                ((GymMember) member).deactivateMembership();
                JOptionPane.showMessageDialog(regmemPanel, "Regular Member ID " + id + " deactivated.");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(regmemPanel, "Regular Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(regmemPanel, "Invalid Member ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// === Regular Member: Revert Member ===
if (source == regmemRevertBtn) {
    String idStr = regmemMemberActionField.getText();

    if (idStr.equals("")) {
        JOptionPane.showMessageDialog(regmemPanel, "Please enter the Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof RegularMember && member.getId() == id) {
                ((RegularMember) member).resetMember();
                JOptionPane.showMessageDialog(regmemPanel, "Regular Member ID " + id + " reverted to previous state.");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(regmemPanel, "Regular Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(regmemPanel, "Invalid Member ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// === Regular Member: Clear Button ===
if (source == regmemClearBtn) {
    // Clear all text fields
    regmemMemberIdField.setText("");
    regmemNameField.setText("");
    regmemLocationField.setText("");
    regmemPhoneField.setText("");
    regmemEmailField.setText("");
    regmemReferralField.setText("");
    regmemMemberActionField.setText("");
    regmemMemberMgmtField.setText("");
    
    // Reset date combo boxes to default values
    regdobYearCombo.setSelectedIndex(0);  // Reset to first year in list
    regdobMonthCombo.setSelectedIndex(0); // Reset to January
    regdobDayCombo.setSelectedIndex(0);   // Reset to 1st day
    
    regstartYearCombo.setSelectedIndex(0); 
    regstartMonthCombo.setSelectedIndex(0);
    regstartDayCombo.setSelectedIndex(0);
    
    // Clear gender selection
    regmemGenderGroup.clearSelection();
    
    // Reset plan selection to default
    regmemPlanCombo.setSelectedIndex(0);
    
    JOptionPane.showMessageDialog(regmemPanel, 
        "All fields have been cleared.", 
        "Clear Successful", 
        JOptionPane.INFORMATION_MESSAGE);
}

// === Premium Member: Clear Button ===
if (source == premmemclearButton) {
    // Clear all text fields
    premmemmemberIdField.setText("");
    premmemnameField.setText("");
    premmemlocationField.setText("");
    premmemphoneField.setText("");
    premmememailField.setText("");
    premmemtrainerField.setText("");
    premmemmembershipIdField.setText("");
    premmemfinancialIdField.setText("");
    premmemfinancialIdField2.setText("");
    premmemamountField.setText("");
    
    // Reset date combo boxes to default values
    premdobYearCombo.setSelectedIndex(0);  // Reset to first year in list
    premdobMonthCombo.setSelectedIndex(0); // Reset to January
    premdobDayCombo.setSelectedIndex(0);   // Reset to 1st day
    
    premstartYearCombo.setSelectedIndex(0);
    premstartMonthCombo.setSelectedIndex(0);
    premstartDayCombo.setSelectedIndex(0);
    
    // Clear gender selection
    premmemgenderGroup.clearSelection();
    
    JOptionPane.showMessageDialog(premmempanel, 
        "All fields have been cleared.", 
        "Clear Successful", 
        JOptionPane.INFORMATION_MESSAGE);
}



//PREMIUM MEMBER CALCULATE DISCOUNT
if (source == premmemcalculateDiscountButton) {
    String idStr = premmemfinancialIdField.getText().trim();

    if (idStr.equals("")) {
        JOptionPane.showMessageDialog(premmempanel, "Please enter the Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof PremiumMember && member.getId() == id) {
                String message = ((PremiumMember) member).calculateDiscount();
                JOptionPane.showMessageDialog(premmempanel, message);
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(premmempanel, "Premium Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(premmempanel, "Invalid Member ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
//pay due amt prem mem
if (source == premmempayAmountButton) {
    String idStr = premmemfinancialIdField2.getText().trim();
    String amountStr = premmemamountField.getText().trim();

    if (idStr.equals("") || amountStr.equals("")) {
        JOptionPane.showMessageDialog(premmempanel, "Please enter both Member ID and Amount.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int id = Integer.parseInt(idStr);
        int amount = Integer.parseInt(amountStr);
        boolean found = false;

        for (GymMember member : arr) {
            if (member instanceof PremiumMember && member.getId() == id) {
                String message = ((PremiumMember) member).payDueAmount(amount);
                JOptionPane.showMessageDialog(premmempanel, message);
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(premmempanel, "Premium Member with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(premmempanel, "Invalid input. Please enter valid numbers for ID and Amount.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



// === Regular Member: Display Member Details ===



    // === Back Button Actions ===
    if (source == regmemBackButton) {
        regmemFrame.dispose(); // Close regular member panel
        firstframe.setVisible(true); // Show main page
    }
    if (source == premmemBackButton) {
        premmemframe.dispose(); // Close premium member panel
        firstframe.setVisible(true); // Show main page
    }

    
    
    // === Save to File (Works for both regular and premium) ===
if (source == regmemSaveBtn || source == premmemsaveButton) {
    try {
        // Create a FileWriter to write to "MemberDetails.txt"
        FileWriter writer = new FileWriter("MemberDetails.txt");
        
        // Write header line with column names
        writer.write("ID,Name,Location,Phone,Email,StartDate,Plan,Price,Attendance,LoyaltyPoints,ActiveStatus,FullPayment,Discount,PaidAmount\n");
        
        // Loop through all members in the ArrayList
        for (GymMember member : arr) {
            if (member instanceof RegularMember) {
                RegularMember reg = (RegularMember) member;
                // Write RegularMember data in CSV format
                writer.write(String.format("%d,%s,%s,%s,%s,%s,%s,%.2f,%d,%.2f,%s,%s,%.2f,%.2f\n",
                    reg.getId(), reg.getName(), reg.getLocation(), reg.getPhone(), 
                    reg.getEmail(), reg.getMembershipStartDate(), reg.getPlan(), 
                    reg.getPrice(), reg.getAttendance(), reg.getLoyaltyPoints(),
                    reg.isActiveStatus() ? "Active" : "Inactive", "No", 0.0, 0.0));
            } else if (member instanceof PremiumMember) {
                PremiumMember prem = (PremiumMember) member;
                // Write PremiumMember data in CSV format
                writer.write(String.format("%d,%s,%s,%s,%s,%s,%s,%.2f,%d,%.2f,%s,%s,%.2f,%.2f\n",
                    prem.getId(), prem.getName(), prem.getLocation(), prem.getPhone(),
                    prem.getEmail(), prem.getMembershipStartDate(), "Premium",
                    prem.getPremiumCharge(), prem.getAttendance(), prem.getLoyaltyPoints(),
                    prem.isActiveStatus() ? "Active" : "Inactive",
                    prem.isFullPayment() ? "Yes" : "No",
                    prem.getDiscountAmount(), prem.getPaidAmount()));
            }
        }
        
        // Close the file writer
        writer.close();
        
        // Show success message
        JOptionPane.showMessageDialog(regmemPanel, 
            "Member details saved to MemberDetails.txt", 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
            
    } catch (IOException ex) {
        // Show error message if something goes wrong
        JOptionPane.showMessageDialog(regmemPanel, 
            "Error saving file: " + ex.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}

// === Read from File (Works for both regular and premium) ===
if (source == regmemReadBtn || source == premmemreadButton) {
    try {
        // Create a FileReader to read "MemberDetails.txt"
        FileReader reader = new FileReader("MemberDetails.txt");
        
        // StringBuilder to store file content
        StringBuilder content = new StringBuilder();
        int character;
        
        // Read file character by character
        while ((character = reader.read()) != -1) {
            content.append((char)character);
        }
        
        // Close the file reader
        reader.close();
        
        // Show file content in dialog box
        JOptionPane.showMessageDialog(regmemPanel, 
            content.toString(), 
            "File Content", 
            JOptionPane.INFORMATION_MESSAGE);
            
    } catch (FileNotFoundException ex) {
        // Show error if file doesn't exist
        JOptionPane.showMessageDialog(regmemPanel, 
            "File not found. Save data first.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
        // Show error if reading fails
        JOptionPane.showMessageDialog(regmemPanel, 
            "Error reading file: " + ex.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}




// === Display All Members ===
if (source == regmemDisplayBtn || source == premmemdisplayButton) {
    boolean showRegular = (source == regmemDisplayBtn);
    String title = showRegular ? "Regular Members" : "Premium Members";
    
    // Initialize frame if first time
    if (displayFrame == null) {
        initDisplayFrame();
    }
    
    // Capture all member details
    StringBuilder allDetails = new StringBuilder();
    int count = 0;
    
    for (GymMember member : arr) {
        if ((showRegular && member instanceof RegularMember) || 
            (!showRegular && member instanceof PremiumMember)) {
            
            count++;
            // Redirect console output to capture display()
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream oldOut = System.out;
            System.setOut(ps);
            
            member.display();  // This writes to our stream
            
            System.out.flush();
            System.setOut(oldOut);
            
            allDetails.append(baos.toString())
                      .append("\n----------------------------------------\n");
        }
    }
    
    // Set the display text
    if (count > 0) {
        displayTextArea.setText(allDetails.toString());
        displayTextArea.setCaretPosition(0);  // Scroll to top
    } else {
        displayTextArea.setText("No " + (showRegular ? "regular" : "premium") + " members found!");
    }
    
    // Configure and show frame
    displayFrame.setTitle(title);
    displayFrame.setVisible(true);
}
      

// === Save to File ===
if (source == regmemSaveBtn || source == premmemsaveButton) {
    try {
        // Create the directory structure if it doesn't exist
        File directory = new File(FILE_PATH).getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }
        
        // Create or overwrite the file
        FileWriter writer = new FileWriter(FILE_PATH);
        
        // Write header line
        writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n",
            "ID", "Name", "Location", "Phone", "Email", 
            "Membership Start Date", "Plan", "Price", 
            "Attendance", "Loyalty Points", "Active Status",
            "Full Payment", "Discount Amount", "Net Amount Paid"));
        
        // Write each member's data
        for (GymMember member : arr) {
            if (member instanceof RegularMember) {
                RegularMember reg = (RegularMember) member;
                writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15s %-15s\n",
                    reg.getId(), reg.getName(), reg.getLocation(), reg.getPhone(), reg.getEmail(),
                    reg.getMembershipStartDate(), reg.getPlan(), reg.getPrice(), reg.getAttendance(),
                    reg.getLoyaltyPoints(), reg.isActiveStatus() ? "true" : "false",
                    "Nil", "Nil", "Nil"));
            } else if (member instanceof PremiumMember) {
                PremiumMember prem = (PremiumMember) member;
                writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15.2f %-15.2f\n",
                    prem.getId(), prem.getName(), prem.getLocation(), prem.getPhone(), prem.getEmail(),
                    prem.getMembershipStartDate(), "Premium", prem.getPremiumCharge(), prem.getAttendance(),
                    prem.getLoyaltyPoints(), prem.isActiveStatus() ? "true" : "false",
                    prem.isFullPayment() ? "true" : "false", prem.getDiscountAmount(), prem.getPaidAmount()));
            }
        }
        
        writer.close();
        
        JOptionPane.showMessageDialog(regmemPanel, 
            "Member details saved to:\n" + FILE_PATH, 
            "Success", JOptionPane.INFORMATION_MESSAGE);
            
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(regmemPanel, 
            "Error saving to file:\n" + ex.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}



// === Read from File ===

if (source == regmemReadBtn || source == premmemreadButton) {
    try {
        // Initialize display frame if first time
        if (fileDisplayFrame == null) {
            initFileDisplayFrame();
        }
        
        // Clear previous content
        fileDisplayArea.setText("Loading member data...\n\n");
        
        // Read file line by line
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String header = reader.readLine(); // Read and skip header line
        String line;
        
        // Format as a table
        fileDisplayArea.setText("=== MEMBER DETAILS ===\n\n");
        fileDisplayArea.append(header + "\n"); // Add header
        
        while ((line = reader.readLine()) != null) {
            fileDisplayArea.append(line + "\n");
        }
        reader.close();
        
        // Auto-scroll to top and show frame
        fileDisplayArea.setCaretPosition(0);
        fileDisplayFrame.setVisible(true);
        
    } catch (FileNotFoundException ex) {
        fileDisplayArea.setText("Error: File not found\nPlease save data first");
        fileDisplayFrame.setVisible(true);
    } catch (IOException ex) {
        fileDisplayArea.setText("Error reading file\n" + ex.getMessage());
        fileDisplayFrame.setVisible(true);
    }
}
}


/**
 * Helper method to set up the file display window.
 * helper method to initialize the file display frame
 * This creates a pop-up window that shows member details from the file.
 * It includes:
 * - A scrollable text area to display the file contents
 * - Monospaced font for proper alignment of data
 * - A close button to hide the window when done
 * 
 * - this exists to:
 * - Makes file content viewing neat and organized
 * - Prevents having to recreate the window each time
 * - Gives users a proper way to view saved data
  The window starts hidden and only shows when needed.
 */
private void initFileDisplayFrame() {
    fileDisplayFrame = new JFrame("Member Details");
    fileDisplayFrame.setSize(1000, 600);
    
    fileDisplayArea = new JTextArea();
    fileDisplayArea.setEditable(false);
    fileDisplayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
    
    JScrollPane scrollPane = new JScrollPane(fileDisplayArea);
    fileDisplayFrame.add(scrollPane);
    
    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(e -> fileDisplayFrame.setVisible(false));
    fileDisplayFrame.add(closeButton, BorderLayout.SOUTH);
}


/**
 * Creates and displays the main selection screen of the application.
 * 
 * This is the first screen users see when they start the program.
 * It contains:
 * - A title heading
 * - Two main buttons (Regular Member and Premium Member)
 * - Basic styling and layout
 * 
 * Features:
 * - Fixed window size (not resizable)
 * - Light gray background color
 * - Large, clearly visible buttons
 * - Simple navigation to other sections
 * 
 * - This is called automatically when the program starts.
 */
 public void firstsection() {
    // Create JFrame
    firstframe = new JFrame("GYM MEMBERSHIP MANAGEMENT SYSTEM");
    firstframe.setBounds(200, 30, 800, 750);
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    firstframe.setResizable(false);

    // Create JPanel
    firstpanel = new JPanel();
    firstpanel.setBounds(0, 0, 800, 750);  // Match frame size
    firstpanel.setLayout(null);
    firstcc = new Color(230, 230, 230);
    firstpanel.setBackground(firstcc);

    // Title label
    firsttitleLabel = new JLabel("GYM MEMBERSHIP MANAGEMENT SYSTEM");
    firsttitleLabel.setBounds(95, 100, 700, 50);  // Adjusted position
    firsttitleLabel.setFont(new Font("Arial", Font.BOLD, 28));
    firstpanel.add(firsttitleLabel);

    // Regular Button - now larger and centered
    firstregularbutton = new JButton("Regular Member");
    firstregularbutton.setBounds(250, 230, 300, 60);  // Increased size
    firstregularbutton.setFont(new Font("Arial", Font.BOLD, 18));  // Larger font
    firstregularbutton.addActionListener(this);
    firstpanel.add(firstregularbutton);

    // Premium Button - now larger and centered
    firstpremiumbutton = new JButton("Premium Member");
    firstpremiumbutton.setBounds(250, 350, 300, 60);  // Increased size
    firstpremiumbutton.setFont(new Font("Arial", Font.BOLD, 18));  // Larger font
    firstpremiumbutton.addActionListener(this);
    firstpanel.add(firstpremiumbutton);

    // Add panel to frame and set visible
    firstframe.add(firstpanel);
    firstframe.setVisible(true);
}


/**
 * Creates and displays the Regular Member management screen.
 * 
 * This complex form handles all regular member operations including:
 * - Adding new regular members with full details
 * - Managing membership status (activate/deactivate)
 * - Attendance tracking
 * - Membership plan upgrades
 * - System operations (save/load data)
 * 
 * Layout Features:
 * - Organized in clear sections with labels
 * - Input fields for all member details
 * - Date selection using dropdowns
 * - Radio buttons for gender selection
 * - Action buttons grouped by functionality
 * 
 * this uses absolute positioning (null layout) for precise control.
 */
public void regularmember() {
    // Frame initialization
    regmemFrame = new JFrame("GYM MEMBERSHIP MANAGEMENT SYSTEM");
    regmemFrame.setBounds(100, 50, 900, 700);
    regmemFrame.setLayout(null);
    regmemFrame.setResizable(false);

    // Panel configuration
    regmemPanel = new JPanel();
    regmemPanel.setBounds(0, 0, 900, 700);
    regmemPanel.setLayout(null);
    regmemBackgroundColor = new Color(230, 230, 230);
    regmemPanel.setBackground(regmemBackgroundColor);

    // Main title label
    regmemTitleLabel = new JLabel("GYM MEMBERSHIP MANAGEMENT SYSTEM");
    regmemTitleLabel.setBounds(250, 10, 500, 30);
    regmemTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
    regmemPanel.add(regmemTitleLabel);

    // Subheading for Regular Member
    regmemSubHeadingLabel = new JLabel("Regular Member");
    regmemSubHeadingLabel.setBounds(370, 40, 200, 25);
    regmemSubHeadingLabel.setFont(new Font("Arial", Font.BOLD, 15));
    regmemPanel.add(regmemSubHeadingLabel);

    // Add Member Section
    regmemAddMemberLabel = new JLabel("Add a Regular Member");
    regmemAddMemberLabel.setBounds(50, 80, 200, 20);
    regmemAddMemberLabel.setFont(new Font("Arial", Font.BOLD, 13));
    regmemPanel.add(regmemAddMemberLabel);

    // Member ID
    regmemMemberIdLabel = new JLabel("Member ID");
    regmemMemberIdLabel.setBounds(50, 110, 100, 25);
    regmemPanel.add(regmemMemberIdLabel);

    regmemMemberIdField = new JTextField();
    regmemMemberIdField.setBounds(150, 110, 200, 25);
    regmemPanel.add(regmemMemberIdField);

    // Name
    regmemNameLabel = new JLabel("Name");
    regmemNameLabel.setBounds(400, 110, 100, 25);
    regmemPanel.add(regmemNameLabel);

    regmemNameField = new JTextField();
    regmemNameField.setBounds(480, 110, 200, 25);
    regmemPanel.add(regmemNameField);

    // Location
    regmemLocationLabel = new JLabel("Location");
    regmemLocationLabel.setBounds(50, 150, 100, 25);
    regmemPanel.add(regmemLocationLabel);

    regmemLocationField = new JTextField();
    regmemLocationField.setBounds(150, 150, 200, 25);
    regmemPanel.add(regmemLocationField);

    // Phone
    regmemPhoneLabel = new JLabel("Phone");
    regmemPhoneLabel.setBounds(400, 150, 100, 25);
    regmemPanel.add(regmemPhoneLabel);

    regmemPhoneField = new JTextField();
    regmemPhoneField.setBounds(480, 150, 200, 25);
    regmemPanel.add(regmemPhoneField);

    // Email
    regmemEmailLabel = new JLabel("Email");
    regmemEmailLabel.setBounds(50, 190, 100, 25);
    regmemPanel.add(regmemEmailLabel);

    regmemEmailField = new JTextField();
    regmemEmailField.setBounds(150, 190, 200, 25);
    regmemPanel.add(regmemEmailField);

    // Gender
    regmemGenderLabel = new JLabel("Gender");
    regmemGenderLabel.setBounds(400, 190, 100, 25);
    regmemPanel.add(regmemGenderLabel);

    regmemMaleRadio = new JRadioButton("Male");
    regmemFemaleRadio = new JRadioButton("Female");
    regmemOtherRadio = new JRadioButton("Other");
    regmemMaleRadio.setBounds(480, 190, 60, 25);
    regmemFemaleRadio.setBounds(540, 190, 80, 25);
    regmemOtherRadio.setBounds(620, 190, 70, 25);

    // Grouping gender radio buttons
    regmemGenderGroup = new ButtonGroup();
    regmemGenderGroup.add(regmemMaleRadio);
    regmemGenderGroup.add(regmemFemaleRadio);
    regmemGenderGroup.add(regmemOtherRadio);
    regmemPanel.add(regmemMaleRadio);
    regmemPanel.add(regmemFemaleRadio);
    regmemPanel.add(regmemOtherRadio);

    
    
       // DOB Label
    regmemDobLabel = new JLabel("Date of Birth");
    regmemDobLabel.setBounds(50, 230, 100, 25);
    regmemPanel.add(regmemDobLabel);
    
    // Year, Month, Day Arrays
    String[] years = new String[70];
    for (int i = 0; i < 70; i++) {
        years[i] = String.valueOf(1955 + i);
    }
    String[] months = {"January", "February", "March", "April", "May", "June", 
                      "July", "August", "September", "October", "November", "December"};
    String[] days = new String[31];
    for (int i = 0; i < 31; i++) {
        days[i] = String.valueOf(i + 1);
    }
    
    // DOB ComboBoxes
    regdobYearCombo = new JComboBox<>(years);
    regdobYearCombo.setBounds(150, 230, 60, 25);
    regmemPanel.add(regdobYearCombo);
    
    regdobMonthCombo = new JComboBox<>(months);
    regdobMonthCombo.setBounds(220, 230, 100, 25); // Increased width to accommodate month names
    regmemPanel.add(regdobMonthCombo);
    
    regdobDayCombo = new JComboBox<>(days);
    regdobDayCombo.setBounds(330, 230, 50, 25); // Adjusted position due to wider month combo
    regmemPanel.add(regdobDayCombo);
    
    // Membership Start Date Label
    regmemStartDateLabel = new JLabel("Membership Start Date");
    regmemStartDateLabel.setBounds(400, 230, 150, 25);
    regmemPanel.add(regmemStartDateLabel);
    
    // Start Date ComboBoxes
    regstartYearCombo = new JComboBox<>(years);
    regstartYearCombo.setBounds(580, 230, 60, 25);
    regmemPanel.add(regstartYearCombo);
    
    regstartMonthCombo = new JComboBox<>(months);
    regstartMonthCombo.setBounds(650, 230, 100, 25); // Increased width to accommodate month names
    regmemPanel.add(regstartMonthCombo);
    
    regstartDayCombo = new JComboBox<>(days);
    regstartDayCombo.setBounds(760, 230, 50, 25); // Adjusted position due to wider month combo
    regmemPanel.add(regstartDayCombo);

    
    // Referral Source
    regmemReferralLabel = new JLabel("Referral Source");
    regmemReferralLabel.setBounds(50, 270, 100, 25);
    regmemPanel.add(regmemReferralLabel);

    regmemReferralField = new JTextField();
    regmemReferralField.setBounds(150, 270, 200, 25);
    regmemPanel.add(regmemReferralField);

    // Add Member Button
    regmemAddMemberBtn = new JButton("Add Member");
    regmemAddMemberBtn.setBounds(150, 310, 150, 30);
    regmemPanel.add(regmemAddMemberBtn);

    // Membership Actions Section
    regmemMembershipActionsLabel = new JLabel("Membership Actions");
    regmemMembershipActionsLabel.setBounds(50, 360, 200, 25);
    regmemMembershipActionsLabel.setFont(new Font("Arial", Font.BOLD, 13));
    regmemPanel.add(regmemMembershipActionsLabel);

    regmemMemberIdActionLabel = new JLabel("Member ID");
    regmemMemberIdActionLabel.setBounds(50, 390, 100, 25);
    regmemPanel.add(regmemMemberIdActionLabel);

    regmemMemberActionField = new JTextField();
    regmemMemberActionField.setBounds(50, 415, 150, 25);
    regmemPanel.add(regmemMemberActionField);

    regmemActivateBtn = new JButton("Activate Member");
    regmemActivateBtn.setBounds(50, 450, 150, 25);
    regmemPanel.add(regmemActivateBtn);

    regmemDeactivateBtn = new JButton("Deactivate Member");
    regmemDeactivateBtn.setBounds(50, 485, 150, 25);
    regmemPanel.add(regmemDeactivateBtn);

    regmemRevertBtn = new JButton("Revert Member");
    regmemRevertBtn.setBounds(50, 520, 150, 25);
    regmemPanel.add(regmemRevertBtn);

    // Attendance and Management Section
    regmemAttendanceLabel = new JLabel("Attendance & Management");
    regmemAttendanceLabel.setBounds(550, 360, 200, 25);
    regmemAttendanceLabel.setFont(new Font("Arial", Font.BOLD, 13));
    regmemPanel.add(regmemAttendanceLabel);

    regmemMemberIdMgmtLabel = new JLabel("Member ID");
    regmemMemberIdMgmtLabel.setBounds(550, 390, 100, 25);
    regmemPanel.add(regmemMemberIdMgmtLabel);

    regmemMemberMgmtField = new JTextField();
    regmemMemberMgmtField.setBounds(550, 415, 150, 25);
    regmemPanel.add(regmemMemberMgmtField);

    regmemMarkAttendanceBtn = new JButton("Mark Attendance");
    regmemMarkAttendanceBtn.setBounds(550, 450, 150, 25);
    //regmemMarkAttendanceBtn.setBackground(Color.WHITE);
    regmemPanel.add(regmemMarkAttendanceBtn);

    regmemSelectPlanLabel = new JLabel("Select Plan");
    regmemSelectPlanLabel.setBounds(550, 485, 100, 25);
    regmemPanel.add(regmemSelectPlanLabel);

    regmemPlanCombo = new JComboBox<>(new String[]{"Basic Plan", "Standard Plan", "Deluxe Plan"});
    regmemPlanCombo.setBounds(550, 510, 150, 25);
    regmemPanel.add(regmemPlanCombo);

    regmemUpgradeBtn = new JButton("Upgrade Plan");
    regmemUpgradeBtn.setBounds(550, 545, 150, 25);
    //regmemUpgradeBtn.setBackground(Color.WHITE);
    regmemPanel.add(regmemUpgradeBtn);

    // System Actions Section
    regmemSystemActionsLabel = new JLabel("System Actions");
    regmemSystemActionsLabel.setBounds(380, 590, 150, 25);
    regmemSystemActionsLabel.setFont(new Font("Arial", Font.BOLD, 13));
    regmemPanel.add(regmemSystemActionsLabel);

    regmemDisplayBtn = new JButton("Display Members");
    regmemDisplayBtn.setBounds(180, 625, 150, 30);
    regmemPanel.add(regmemDisplayBtn);

    regmemClearBtn = new JButton("Clear");
    regmemClearBtn.setBounds(340, 625, 100, 30);
    regmemPanel.add(regmemClearBtn);

    regmemSaveBtn = new JButton("Save to File");
    regmemSaveBtn.setBounds(450, 625, 130, 30);
    regmemPanel.add(regmemSaveBtn);

    regmemReadBtn = new JButton("Read from File");
    regmemReadBtn.setBounds(590, 625, 130, 30);
    regmemPanel.add(regmemReadBtn);
    
    // Add Back Button to Regular Member Panel
    regmemBackButton = new JButton("← Main Page");
    regmemBackButton.setBounds(20, 10, 120, 25);
    regmemBackButton.addActionListener(this);
    regmemPanel.add(regmemBackButton);

    regmemAddMemberBtn.addActionListener(this);
    regmemActivateBtn.addActionListener(this);
    regmemDeactivateBtn.addActionListener(this);
    regmemRevertBtn.addActionListener(this);
    regmemMarkAttendanceBtn.addActionListener(this);
    regmemUpgradeBtn.addActionListener(this);
    regmemDisplayBtn.addActionListener(this);
    regmemClearBtn.addActionListener(this);
    regmemSaveBtn.addActionListener(this);
    regmemReadBtn.addActionListener(this);
    
    regmemMaleRadio.addActionListener(this);
    regmemFemaleRadio.addActionListener(this);
    regmemOtherRadio.addActionListener(this);
    regmemPlanCombo.addActionListener(this);

    
    
    
    // Add panel to frame and make GUI visible
    regmemFrame.add(regmemPanel);
    regmemFrame.setVisible(true);
}


/**
 * This method initializes and displays the Premium Member interface of the Gym Membership Management System.
 * 
 * This method sets up a dedicated JFrame and JPanel for premium member-related operations,
 * including:
 * - Adding a new premium member with personal details like ID, name, gender, DOB, etc.
 * - Managing membership actions such as activation, deactivation, reverting, and attendance.
 * - Handling financial actions like discount calculation and due amount payment.
 * - Performing system-level tasks like displaying members, clearing fields, saving to a file,
 *   and reading from a file.
 * 
 * It also includes GUI components like labels, text fields, combo boxes, radio buttons, and buttons,
 * all positioned using absolute layout. Event listeners are added for user interaction.
 */

public void premiummember() {
    // Create JFrame
    premmemframe = new JFrame("GYM MEMBERSHIP MANAGEMENT SYSTEM");
    premmemframe.setBounds(200, 30, 800, 750);
    premmemframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    premmemframe.setResizable(false);

    // Create JPanel
    //panel = new JPanel();
    //panel.setLayout(null);
    //panel.setBackground(Color.WHITE);

    premmempanel = new JPanel();
    premmempanel.setBounds(0, 0, 900, 700);
    premmempanel.setLayout(null);
    premmemcc = new Color(230, 230, 230);
    premmempanel.setBackground(premmemcc);

    // Title label
    premmemtitleLabel = new JLabel("GYM MEMBERSHIP MANAGEMENT SYSTEM");
    premmemtitleLabel.setBounds(200, 10, 400, 30);
    premmemtitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
    premmempanel.add(premmemtitleLabel);

    // Subheading
    premmemmemberTypeLabel = new JLabel("Premium Member");
    premmemmemberTypeLabel.setBounds(320, 40, 200, 25);
    premmemmemberTypeLabel.setFont(new Font("Arial", Font.BOLD, 15));
    premmempanel.add(premmemmemberTypeLabel);

    // Form Section - Add a Premium Member
    JLabel premmemaddMemberLabel = new JLabel("Add a Premium Member");
    premmemaddMemberLabel.setBounds(50, 70, 200, 25);
    premmemaddMemberLabel.setFont(new Font("Arial", Font.BOLD, 13));
    premmempanel.add(premmemaddMemberLabel);

    premmemmemberIdLabel = new JLabel("Member ID");
    premmemmemberIdLabel.setBounds(50, 100, 100, 25);
    premmempanel.add(premmemmemberIdLabel);

    premmemmemberIdField = new JTextField();
    premmemmemberIdField.setBounds(150, 100, 150, 25);
    premmempanel.add(premmemmemberIdField);

    premmemnameLabel = new JLabel("Name");
    premmemnameLabel.setBounds(350, 100, 100, 25);
    premmempanel.add(premmemnameLabel);

    premmemnameField = new JTextField();
    premmemnameField.setBounds(450, 100, 200, 25);
    premmempanel.add(premmemnameField);

    premmemlocationLabel = new JLabel("Location");
    premmemlocationLabel.setBounds(50, 140, 100, 25);
    premmempanel.add(premmemlocationLabel);

    premmemlocationField = new JTextField();
    premmemlocationField.setBounds(150, 140, 150, 25);
    premmempanel.add(premmemlocationField);

    premmemphoneLabel = new JLabel("Phone");
    premmemphoneLabel.setBounds(350, 140, 100, 25);
    premmempanel.add(premmemphoneLabel);

    premmemphoneField = new JTextField();
    premmemphoneField.setBounds(450, 140, 200, 25);
    premmempanel.add(premmemphoneField);

    premmememailLabel = new JLabel("Email");
    premmememailLabel.setBounds(50, 180, 100, 25);
    premmempanel.add(premmememailLabel);

    premmememailField = new JTextField();
    premmememailField.setBounds(150, 180, 150, 25);
    premmempanel.add(premmememailField);

    premmemgenderLabel = new JLabel("Gender");
    premmemgenderLabel.setBounds(350, 180, 100, 25);
    premmempanel.add(premmemgenderLabel);

    premmemmaleRadio = new JRadioButton("Male");
    premmemmaleRadio.setBounds(450, 180, 60, 25);
    premmemfemaleRadio = new JRadioButton("Female");
    premmemfemaleRadio.setBounds(510, 180, 70, 25);
    premmemotherRadio = new JRadioButton("Other");
    premmemotherRadio.setBounds(580, 180, 70, 25);

    premmemgenderGroup = new ButtonGroup();
    premmemgenderGroup.add(premmemmaleRadio);
    premmemgenderGroup.add(premmemfemaleRadio);
    premmemgenderGroup.add(premmemotherRadio);

    premmempanel.add(premmemmaleRadio);
    premmempanel.add(premmemfemaleRadio);
    premmempanel.add(premmemotherRadio);
    
    
    
    // DOB Labels and ComboBoxes
    premmemdobLabel = new JLabel("Date of Birth");
    premmemdobLabel.setBounds(50, 220, 100, 25);
    premmempanel.add(premmemdobLabel);
    
    String[] years = new String[70];
    for (int i = 0; i < 70; i++) {
        years[i] = String.valueOf(1955 + i); // Years from 1955 to 2024
    }
    String[] months = {"January", "February", "March", "April", "May", "June", 
                       "July", "August", "September", "October", "November", "December"};
    String[] days = new String[31];
    for (int i = 0; i < 31; i++) {
        days[i] = String.valueOf(i + 1);
    }
    
    premdobYearCombo = new JComboBox<>(years);
    premdobYearCombo.setBounds(150, 220, 60, 25);
    premmempanel.add(premdobYearCombo);
    
    premdobMonthCombo = new JComboBox<>(months);
    premdobMonthCombo.setBounds(220, 220, 100, 25); // Wider for month names
    premmempanel.add(premdobMonthCombo);
    
    premdobDayCombo = new JComboBox<>(days);
    premdobDayCombo.setBounds(330, 220, 50, 25); // Adjusted position
    premmempanel.add(premdobDayCombo);
    
    premmemstartDateLabel = new JLabel("Membership Start Date");
    premmemstartDateLabel.setBounds(390, 220, 150, 25);
    premmempanel.add(premmemstartDateLabel);
    
    premstartYearCombo = new JComboBox<>(years);
    premstartYearCombo.setBounds(530, 220, 60, 25);
    premmempanel.add(premstartYearCombo);
    
    premstartMonthCombo = new JComboBox<>(months);
    premstartMonthCombo.setBounds(600, 220, 100, 25); // Wider for month names
    premmempanel.add(premstartMonthCombo);
    
    premstartDayCombo = new JComboBox<>(days);
    premstartDayCombo.setBounds(710, 220, 50, 25); // Adjusted position
    premmempanel.add(premstartDayCombo);


    premmemtrainerLabel = new JLabel("Personal Trainer");
    premmemtrainerLabel.setBounds(50, 260, 120, 25);
    premmempanel.add(premmemtrainerLabel);

    premmemtrainerField = new JTextField();
    premmemtrainerField.setBounds(170, 260, 150, 25);
    premmempanel.add(premmemtrainerField);

    premmemaddButton = new JButton("Add Member");
    premmemaddButton.setBounds(100, 300, 150, 30);
    premmempanel.add(premmemaddButton);

    // Membership Actions Section
    premmemmembershipSectionLabel = new JLabel("Membership Actions");
    premmemmembershipSectionLabel.setBounds(50, 350, 150, 25);
    premmemmembershipSectionLabel.setFont(new Font("Arial", Font.BOLD, 13));
    premmempanel.add(premmemmembershipSectionLabel);

    premmemmembershipIdLabel = new JLabel("Member ID");
    premmemmembershipIdLabel.setBounds(50, 380, 100, 25);
    premmempanel.add(premmemmembershipIdLabel);

    premmemmembershipIdField = new JTextField();
    premmemmembershipIdField.setBounds(50, 405, 150, 25);
    premmempanel.add(premmemmembershipIdField);

    premmemactivateButton = new JButton("Activate Member");
    premmemactivateButton.setBounds(50, 435, 150, 25);
    premmempanel.add(premmemactivateButton);

    premmemdeactivateButton = new JButton("Deactivate Member");
    premmemdeactivateButton.setBounds(50, 465, 150, 25);
    premmempanel.add(premmemdeactivateButton);

    premmemrevertButton = new JButton("Revert Member");
    premmemrevertButton.setBounds(50, 495, 150, 25);
    premmempanel.add(premmemrevertButton);

    premmemmarkAttendanceButton = new JButton("Mark Attendance");
    premmemmarkAttendanceButton.setBounds(50, 525, 150, 25);
    premmempanel.add(premmemmarkAttendanceButton);

    // Financial Actions Section
    premmemfinancialSectionLabel = new JLabel("Financial Actions");
    premmemfinancialSectionLabel.setBounds(450, 350, 150, 25);
    premmemfinancialSectionLabel.setFont(new Font("Arial", Font.BOLD, 13));
    premmempanel.add(premmemfinancialSectionLabel);

    premmemfinancialIdLabel = new JLabel("Member ID");
    premmemfinancialIdLabel.setBounds(490, 380, 100, 25);
    premmempanel.add(premmemfinancialIdLabel);

    premmemfinancialIdField = new JTextField();
    premmemfinancialIdField.setBounds(450, 405, 150, 25);
    premmempanel.add(premmemfinancialIdField);

    premmemcalculateDiscountButton = new JButton("Calculate Discount");
    premmemcalculateDiscountButton.setBounds(450, 435, 150, 25);
    premmempanel.add(premmemcalculateDiscountButton);

    premmemfinancialIdLabel2 = new JLabel("Member ID");
    premmemfinancialIdLabel2.setBounds(350, 475, 80, 25);
    premmempanel.add(premmemfinancialIdLabel2);

    premmemfinancialIdField2 = new JTextField();
    premmemfinancialIdField2.setBounds(430, 475, 80, 25);
    premmempanel.add(premmemfinancialIdField2);

    premmemamountLabel = new JLabel("Amount");
    premmemamountLabel.setBounds(520, 475, 60, 25);
    premmempanel.add(premmemamountLabel);

    premmemamountField = new JTextField();
    premmemamountField.setBounds(580, 475, 80, 25);
    premmempanel.add(premmemamountField);

    premmempayAmountButton = new JButton("Pay Due Amount");
    premmempayAmountButton.setBounds(450, 505, 150, 25);
    premmempanel.add(premmempayAmountButton);

    // System Actions
    premmemsystemSectionLabel = new JLabel("System Actions");
    premmemsystemSectionLabel.setBounds(50, 580, 150, 25);
    premmemsystemSectionLabel.setFont(new Font("Arial", Font.BOLD, 13));
    premmempanel.add(premmemsystemSectionLabel);

    premmemdisplayButton = new JButton("Display Members");
    premmemdisplayButton.setBounds(50, 610, 150, 25);
    premmempanel.add(premmemdisplayButton);

    premmemclearButton = new JButton("Clear");
    premmemclearButton.setBounds(210, 610, 100, 25);
    premmempanel.add(premmemclearButton);

    premmemsaveButton = new JButton("Save to File");
    premmemsaveButton.setBounds(320, 610, 120, 25);
    premmempanel.add(premmemsaveButton);
 
    premmemreadButton = new JButton("Read from File");
    premmemreadButton.setBounds(450, 610, 150, 25);
    premmempanel.add(premmemreadButton);
    
    // Add Back Button to Premium Member Panel
    premmemBackButton = new JButton("← Main Page");
    premmemBackButton.setBounds(20, 10, 120, 25);
    premmemBackButton.addActionListener(this);
    premmempanel.add(premmemBackButton);
    
    
    
    premmemaddButton.addActionListener(this);

    premmemactivateButton.addActionListener(this);
    premmemdeactivateButton.addActionListener(this);
    premmemrevertButton.addActionListener(this);
    premmemmarkAttendanceButton.addActionListener(this);
    
    premmemcalculateDiscountButton.addActionListener(this);
    premmempayAmountButton.addActionListener(this);
    
    premmemdisplayButton.addActionListener(this);
    premmemclearButton.addActionListener(this);
    premmemsaveButton.addActionListener(this);
    premmemreadButton.addActionListener(this);

    //premmemmaleRadio = new JRadioButton("Male");
    premmemmaleRadio.addActionListener(this);
    
    //premmemfemaleRadio = new JRadioButton("Female");
    premmemfemaleRadio.addActionListener(this);
    
    //premmemotherRadio = new JRadioButton("Other");
    premmemotherRadio.addActionListener(this);
    
    premmemgenderGroup = new ButtonGroup();
    premmemgenderGroup.add(premmemmaleRadio);       
    premmemgenderGroup.add(premmemfemaleRadio);
    premmemgenderGroup.add(premmemotherRadio);



    // Add panel to frame and set visible
    premmemframe.add(premmempanel);
    premmemframe.setVisible(true);
}

/**
 * Creates the display frame for showing member details
 * (Call this once when first needed)
 */
private void initDisplayFrame() {
    // Create the frame
    displayFrame = new JFrame("Member Details");
    displayFrame.setSize(700, 500);  // Wider to accommodate all details
    displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    displayFrame.setLayout(new BorderLayout());
    
    // Configure the text area
    displayTextArea = new JTextArea();
    displayTextArea.setEditable(false);
    displayTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));  // Better readability
    displayTextArea.setMargin(new Insets(10, 10, 10, 10));  // Add padding
    
    // Add scrolling
    scrollPane = new JScrollPane(displayTextArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    // Add components to frame
    displayFrame.add(scrollPane, BorderLayout.CENTER);
    
    // Add close button at bottom
    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(e -> displayFrame.setVisible(false));  // Hide instead of dispose
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    buttonPanel.add(closeButton);
    displayFrame.add(buttonPanel, BorderLayout.SOUTH);
}


/**
 * The entry point of the Gym Membership Management System application.
 * 
 * This method creates a new instance of the GymGUI class, which launches
 * the graphical user interface for managing gym members, including both 
 * regular and premium members. It serves as the starting point when the 
 * application is run.
 */

public static void main(String[]args)
{
    new GymGUI();
    
}

}