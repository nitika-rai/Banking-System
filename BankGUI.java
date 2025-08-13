/**
 * The following code is of the class BankGUI which creates GUI of Debit Card Class and Credit Card Class 
 * using the respective classes and the parent class as well.
 * This class consists of different attributes, constructor, createGUI method, 
 * also alot of instance variables/objects and a main method at the very last.
 *
 * @author (Nitika Rai)
 * @version (5.1.0a)
 */

//Importing all the required packages to write program
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//creating class implementing ActionListener
public class BankGUI implements ActionListener
{
    ArrayList <BankCard> Arr_List = new ArrayList <BankCard>();

    private JFrame mainFrame,debitCardFrame, creditCardFrame;//Declaring JFrames
    private JPanel mainPanel,debitCardPanel, creditCardPanel ;//Declaring JPanels
    private JButton debitCardButton, creditCardButton, addDebitCardButton, debitGoBackButton, debitWithdrawButton, debitDisplayButton, debitClearButton, addCreditCardButton, cancelCreditCardButton,  creditGoBackButton,creditSetCreditLimitButton, creditDisplayButton, creditClearButton;//Declaring JButtons
    private JLabel debitCardLabel, debitCardIdLabel, debitIssuerBankLabel, debitBalanceAmountLabel, debitClientNameLabel, debitBankAccountLabel, debitPinNumberLabel, debitWithdrawalAmountLabel, debitDateOfWithdrawalLabel, creditCardLabel, creditCardIdLabel, creditIssuerBankLabel, creditBalanceAmountLabel, creditClientNameLabel, creditBankAccountLabel, creditCvcNumberLabel, creditInterestRateLabel, creditExpirationDateLabel, creditLimitLabel, creditGracePeriodLabel; //Declaring JLabel
    private JTextField textDebitCardId, textDebitIssuerBank, textDebitBalanceAmount, textDebitClientName, textDebitBankAccount, textDebitPinNumber, textDebitWithdrawalAmount, textCreditCardId, textCreditIssuerBank, textCreditBalanceAmount, textCreditClientName, textCreditBankAccount, textCreditCvcNumber, textCreditInterestRate, textCreditLimit, textCreditGracePeriod;
    private JComboBox debitDayComboBox, debitMonthComboBox, debitYearComboBox, creditDayComboBox, creditMonthComboBox, creditYearComboBox;//Declaring JComboBox
    private Color colorButton;//Declaring Color

   /*Calling the method actionPermed with parameter ActionEvent*/ 
    public void actionPerformed(ActionEvent e)
    {
        //calling the method getSource from ActionEevent e and comparing
        if (e.getSource() == debitCardButton)
        {
            mainFrame.dispose();//disposing mainFrame and making debitCardFrame visible
            debitCardFrame.setVisible(true);
        }
        else if(e.getSource() == creditCardButton)
        {
            mainFrame.dispose();//disposing mainFrame to open creditCardFrame
            creditCardFrame.setVisible(true);
        }

        else if(e.getSource() == addDebitCardButton)
        {   //looking if their is any empty field 
            if (textDebitCardId.getText().equals("") || textDebitBalanceAmount.getText().equals("") || textDebitBankAccount.getText().equals("") || 
            textDebitIssuerBank.getText().equals("") || textDebitClientName.getText().equals("") || textDebitPinNumber.getText().equals(""))
            {
                JOptionPane.showMessageDialog(debitCardFrame, "Fill up all the required details.", "EMPTY!!!",
                    JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                /*Trying to keep image in the pannel if image get corrupted catch the label and display it on the panel*/
                try{
                    int debitBalanceAmount = Integer.parseInt(textDebitBalanceAmount.getText());
                    int debitCardId = Integer.parseInt(textDebitCardId.getText());
                    String debitBankAccount = textDebitBankAccount.getText();
                    String debitIssuerBank = textDebitIssuerBank.getText();
                    String debitClientName = textDebitClientName.getText();
                    int debitPinNumber = Integer.parseInt(textDebitPinNumber.getText());
                    boolean debitCardExist = false;
                    //checking if card id already exist or not
                    for(BankCard BankCardObject : Arr_List)
                    {
                        if(BankCardObject.getCardID() == debitCardId && BankCardObject instanceof DebitCard)
                        {
                            debitCardExist = true;
                            break;
                        }
                        else 
                        {
                            debitCardExist = false;
                        }
                    }
                    if(debitCardExist == false)
                    {
                        DebitCard debitCardObject = new DebitCard(debitBalanceAmount, debitCardId,debitBankAccount,debitIssuerBank,debitClientName,debitPinNumber);
                        Arr_List.add(debitCardObject);
                        JOptionPane.showMessageDialog(debitCardFrame,
                            "Added Debit Card Sucessfully.\nCard ID: "+debitCardId+"\nIssuer Bank: "+debitIssuerBank+"\nBalance Amount: "+debitBalanceAmount+"\nClient Name: "+debitClientName+"\nBank Account: "+debitBankAccount+"\nPIN Number: "+debitPinNumber,
                            "ADD DEBIT CARD",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(debitCardFrame,"This Card ID: "+debitCardId+" already exists in Debit Card.","Duplicate Card ID Detected!!!",JOptionPane.WARNING_MESSAGE);
                    }
                    //catching if string or any other data type is entered in the place of integer.
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(debitCardFrame,
                        "Please give number value in Balance Amount, Card ID and Pin Number.",
                        "ALERT",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        else if (e.getSource() == debitWithdrawButton)
        {
            if (textDebitCardId.getText().equals("") || textDebitPinNumber.getText().equals("") || textDebitWithdrawalAmount.getText().equals(""))
            {//Looking if any field is remained empty
                JOptionPane.showMessageDialog(debitCardFrame, "Fill up all the required details.", "EMPTY!!!",
                    JOptionPane.WARNING_MESSAGE);
            }
            else
            {/*Trying to keep image in the pannel if image get corrupted catch the label and display it on the panel*/
                try{
                    int debitCardId = Integer.parseInt(textDebitCardId.getText());
                    int debitPinNumber = Integer.parseInt(textDebitPinNumber.getText());
                    int debitWithdrawalAmount = Integer.parseInt(textDebitWithdrawalAmount.getText());
                    String debitDay = debitDayComboBox.getSelectedItem().toString();
                    String debitMonth = debitMonthComboBox.getSelectedItem().toString();
                    String debitYear = debitYearComboBox.getSelectedItem().toString();
                    String debitDateOfWithdrawal = debitDay + " " + debitMonth + " " + debitYear;
                    boolean debitCardExist = false;
                    BankCard BankCardObject1 = null;
                    for(BankCard BankCardObject : Arr_List)
                    {//checking if card id already exist or not
                        if(BankCardObject.getCardID() == debitCardId && BankCardObject instanceof DebitCard)
                        {
                            debitCardExist = true;
                            BankCardObject1 = BankCardObject;
                            break;
                        }
                        else 
                        {
                            debitCardExist = false;
                        }
                    }
                    if(debitCardExist == true)
                    {
                        DebitCard debitCardObject = (DebitCard) BankCardObject1;
                        if(debitCardObject.getPinNumber() == debitPinNumber)
                        {   
                            if(debitWithdrawalAmount <= debitCardObject.getBalanceAmount() && debitWithdrawalAmount > 0)
                            {//making sure 0 doesn't withdraw
                                debitCardObject.withdraw(debitWithdrawalAmount,debitDateOfWithdrawal,debitPinNumber);
                                JOptionPane.showMessageDialog(debitCardFrame,
                                    "Transaction Successfull!"+"\nCard ID: " +debitCardId+"\n"+debitWithdrawalAmount+" has been detucted from your bank account."+"Your new balance is:"+debitCardObject.getBalanceAmount()+"\nDate of Withdrawal: "+debitDateOfWithdrawal+"\nPIN Number: "+debitPinNumber,
                                    "WITHDRAW SUCCESS",JOptionPane.INFORMATION_MESSAGE);

                            }
                            else
                            {
                                JOptionPane.showMessageDialog(debitCardFrame,"Insufficient Balance!!!!"+"\nYour current balance is: "+debitCardObject.getBalanceAmount(),"WITHDRAW FAILED",JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(debitCardFrame,"This "+debitCardId + " Card ID does not exist", "INVALID CARD ID",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(debitCardFrame,
                        "Please give number value in Card ID, Pin Number, Withdrawal Amount.",
                        "ALERT",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        else if (e.getSource() == debitDisplayButton)
        {
            if (textDebitCardId.getText().equals(""))
            {
                JOptionPane.showMessageDialog(debitCardFrame, "Enter Card ID to view details", "EMPTY!!!",
                    JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                try{
                    int debitCardId = Integer.parseInt(textDebitCardId.getText());
                    boolean debitCardExist = false;
                    BankCard BankCardObject1 = null;
                    for(BankCard BankCardObject : Arr_List)
                    {
                        if(BankCardObject.getCardID() == debitCardId && BankCardObject instanceof DebitCard)
                        {
                            debitCardExist = true;
                            BankCardObject1 = BankCardObject;
                            break;
                        }
                        else 
                        {
                            debitCardExist = false;
                        }
                    }
                    if(debitCardExist == true)
                    {
                        DebitCard debitCardObject = (DebitCard) BankCardObject1;
                        String textDisplay = "Details of Debit Card: \nCardID: "+debitCardObject.getCardID()+"\nClient Name: "+debitCardObject.getClientName()+"\nIssuer Bank: "+debitCardObject.getIssuerBank()+"\nBank Account: "+debitCardObject.getBankAccount()+"\nIssuer Bank: "+debitCardObject.getIssuerBank()+"\nBalance Amount: "+debitCardObject.getBalanceAmount();

                        if(debitCardObject.getHasWithdrawn() == true)
                        {
                            textDisplay = textDisplay + "\nPIN Number: "+debitCardObject.getPinNumber()+ "\nWithdrawal Amount: " +debitCardObject.getWithdrawalAmount()+"\nDate of Withdrawal: " +debitCardObject.getDateOfWithdrawal();
                        }
                        else
                        {
                            textDisplay = textDisplay + "\nBalance Amount: " +debitCardObject.getBalanceAmount();
                        }
                        debitCardObject.display();//calling display method
                        JOptionPane.showMessageDialog(debitCardFrame, textDisplay,"DETAILS!",JOptionPane.WARNING_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(debitCardFrame,"This Card ID: "+debitCardId+" does not exists in Debit Card.","NO CARD ID!!!",JOptionPane.WARNING_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(debitCardFrame,
                        "Please give number value in Card ID.",
                        "ALERT",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        else if (e.getSource() == debitClearButton)
        {
            textDebitCardId.setText("");
            textDebitIssuerBank.setText("");
            textDebitBalanceAmount.setText("");
            textDebitClientName.setText("");
            textDebitBankAccount.setText("");
            textDebitPinNumber.setText("");
            textDebitWithdrawalAmount.setText("");
            JOptionPane.showMessageDialog(debitCardFrame,"Debit Card cleared!!!!","CLEAR",JOptionPane.INFORMATION_MESSAGE);
        }

        else if (e.getSource() == debitGoBackButton)
        {
            debitCardFrame.dispose();
            mainFrame.setVisible(true);
        }

        else if(e.getSource() == addCreditCardButton)
        {
            if (textCreditCardId.getText().equals("") || textCreditBalanceAmount.getText().equals("") || textCreditBankAccount.getText().equals("") || 
            textCreditIssuerBank.getText().equals("") || textCreditClientName.getText().equals("") || textCreditCvcNumber.getText().equals("") || textCreditInterestRate.getText().equals(""))
            {
                JOptionPane.showMessageDialog(debitCardFrame, "Fill up all the required details.", "EMPTY!!!",
                    JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                try{
                    int creditCardId = Integer.parseInt(textCreditCardId.getText());
                    String creditClientName = textCreditClientName.getText();
                    String creditIssuerBank = textCreditIssuerBank.getText();
                    String creditBankAccount = textCreditBankAccount.getText();
                    int creditBalanceAmount = Integer.parseInt(textCreditBalanceAmount.getText());
                    int creditCvcNumber = Integer.parseInt(textCreditCvcNumber.getText());
                    double creditInterestRate = Double.parseDouble(textCreditInterestRate.getText());
                    String creditDay = creditDayComboBox.getSelectedItem().toString();
                    String creditMonth = creditMonthComboBox.getSelectedItem().toString();
                    String creditYear = creditYearComboBox.getSelectedItem().toString();
                    String creditExpirationDate = creditDay + " " + creditMonth + " " + creditYear;
                    boolean creditCardExist = false;

                    for(BankCard BankCardObject : Arr_List)
                    {
                        if(BankCardObject.getCardID() == creditCardId && BankCardObject instanceof CreditCard)
                        {
                            creditCardExist = true;
                            break;
                        }
                        else 
                        {
                            creditCardExist = false;
                        }
                    }
                    if(creditCardExist == false)
                    {
                        CreditCard creditCardObject = new CreditCard(creditCardId, creditClientName,creditIssuerBank,creditBankAccount,creditBalanceAmount,creditCvcNumber, creditInterestRate,creditExpirationDate);
                        Arr_List.add(creditCardObject);
                        JOptionPane.showMessageDialog(debitCardFrame,
                            "Added Credit Card Sucessfully.\nCard ID: "+creditCardId+"\nIssuer Bank: "+creditIssuerBank+"\nBalance Amount: "+creditBalanceAmount+"\nClient Name: "+creditClientName+"\nBank Account: "+creditBankAccount+"\nCVC Number: "+creditCvcNumber+"\nInterest Rate: "+creditInterestRate+"\nExpiration Date: "+creditExpirationDate,
                            "ADD CREDIT CARD",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(creditCardFrame,"This Card ID: "+creditCardId+" already exists in Credit Card.","Duplicate Card ID Detected!!!",JOptionPane.WARNING_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(creditCardFrame,
                        "Please give number value in Balance Amount, Card ID and Pin Number.",
                        "ALERT",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        else if (e.getSource() == creditDisplayButton)
        {
            if (textCreditCardId.getText().equals(""))
            {
                JOptionPane.showMessageDialog(creditCardFrame, "Enter Card ID to view details", "EMPTY!!!",
                    JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                try{
                    int creditCardId = Integer.parseInt(textCreditCardId.getText());
                    boolean creditCardExist = false;
                    BankCard BankCardObject1 = null;
                    for(BankCard BankCardObject : Arr_List)
                    {
                        if(BankCardObject.getCardID() == creditCardId && BankCardObject instanceof CreditCard)
                        {
                            creditCardExist = true;
                            BankCardObject1 = BankCardObject;
                            break;
                        }
                        else 
                        {
                            creditCardExist = false;
                        }
                    }
                    if(creditCardExist == true)
                    {
                        CreditCard creditCardObject = (CreditCard) BankCardObject1;
                        String textDisplay = "Details of Credit Card: \nCardID: "+creditCardObject.getCardID()+"\nClient Name: "+creditCardObject.getClientName()+"\nIssuer Bank: "+creditCardObject.getIssuerBank()+"\nBank Account: "+creditCardObject.getBankAccount()+"\nIssuer Bank: "+creditCardObject.getIssuerBank()+"\nBalance Amount: "+creditCardObject.getBalanceAmount();

                        if(creditCardObject.getIsGranted() == true)
                        {
                            textDisplay = textDisplay + "\nCVC Number: "+creditCardObject.getCvcNumber()+ "\nInterest Rate: " +creditCardObject.getInterestRate()+"\nExpiration Date: " +creditCardObject.getExpirationDate()+"\nCredit Limit: "+creditCardObject.getCreditLimit()+"\nGrace Period: "+creditCardObject.getGracePeriod();
                        }
                        else
                        {
                            textDisplay = textDisplay + "\nCVC Number: " +creditCardObject.getCvcNumber()+ "\nInterest Rate: " +creditCardObject.getInterestRate() + "\nExpiration Date: " +creditCardObject.getExpirationDate();
                        }
                        creditCardObject.display();
                        JOptionPane.showMessageDialog(creditCardFrame, textDisplay,"DETAILS!",JOptionPane.WARNING_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(creditCardFrame,"This Card ID: "+creditCardId+" does not exists in Credit Card.","NO CARD ID!!!",JOptionPane.WARNING_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(creditCardFrame,
                        "Please give number value in Card ID.",
                        "ALERT",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        else if (e.getSource() == creditClearButton)//emptying JTextFiled
        {
            textCreditCardId.setText("");
            textCreditIssuerBank.setText("");
            textCreditBalanceAmount.setText("");
            textCreditClientName.setText("");
            textCreditBankAccount.setText("");
            textCreditCvcNumber.setText("");
            textCreditInterestRate.setText("");
            textCreditLimit.setText("");
            textCreditGracePeriod.setText("");
            JOptionPane.showMessageDialog(creditCardFrame,"Credit Card cleared!!!!","CLEAR",JOptionPane.INFORMATION_MESSAGE);
        }

        else if(e.getSource() == creditSetCreditLimitButton)
        {
            {
                if (textCreditCardId.getText().equals("") || textCreditBalanceAmount.getText().equals("") || textCreditLimit.getText().equals("") || textCreditGracePeriod.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(debitCardFrame, "Fill up all the required details.", "EMPTY!!!",
                        JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    try{
                        int creditCardId = Integer.parseInt(textCreditCardId.getText());
                        int creditBalanceAmount = Integer.parseInt(textCreditBalanceAmount.getText());
                        int creditLimit = Integer.parseInt(textCreditLimit.getText());
                        int creditGracePeriod = Integer.parseInt(textCreditGracePeriod.getText());
                        boolean creditCardExist = false;
                        BankCard BankCardObject1 = null;
                        for(BankCard BankCardObject : Arr_List)
                        {
                            if(BankCardObject.getCardID() ==  creditCardId && BankCardObject instanceof CreditCard)
                            {
                                creditCardExist = true;
                                BankCardObject1 = BankCardObject;
                                break;
                            }
                            else 
                            {
                                creditCardExist = false;
                            }
                        }
                        if(creditCardExist == true)
                        {
                            CreditCard CreditCardObject = (CreditCard) BankCardObject1;
                            if(creditLimit <= (2.5 * CreditCardObject.getBalanceAmount()))
                            {
                                if(CreditCardObject.getIsGranted() == false)
                                {
                                    CreditCardObject.setCreditLimit(creditLimit, creditGracePeriod);
                                    JOptionPane.showMessageDialog(debitCardFrame,
                                        "Credit Limit is Set Sucessfully!!!"+"\nCard ID: " +creditCardId+"\nCredit Limit: "+creditLimit+"\nGrace Period: "+creditGracePeriod,
                                        "SET CREDIT LIMIT",JOptionPane.INFORMATION_MESSAGE);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(creditCardFrame,"Credit cannot be issued!"+"\nCredit is granted of: "+(2.5 * creditBalanceAmount),"CREDIT LIMIT FAILED",JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(creditCardFrame,
                            "Please give number value in Card ID",
                            "ALERT",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        else if(e.getSource() == cancelCreditCardButton)
        {

            {
                if (textCreditCardId.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(debitCardFrame, "Fill up Card ID.", "EMPTY!!!",
                        JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    try{
                        int creditCardId = Integer.parseInt(textCreditCardId.getText());
                        boolean creditCardExist = false;
                        BankCard BankCardObject1 = null;
                        for(BankCard BankCardObject : Arr_List)
                        {
                            if(BankCardObject.getCardID() ==  creditCardId && BankCardObject instanceof CreditCard)
                            {
                                creditCardExist = true;
                                BankCardObject1 = BankCardObject;
                                break;
                            }
                            else 
                            {
                                creditCardExist = false;
                            }
                        }
                        if(creditCardExist == true)
                        {
                            CreditCard CreditCardObject = (CreditCard) BankCardObject1;
                            if(CreditCardObject.getCardID() == creditCardId)
                            {
                                if(CreditCardObject.getIsGranted() == true)
                                {
                                    CreditCardObject.cancelCreditCard();
                                    JOptionPane.showMessageDialog(creditCardFrame,
                                        "Credit Card Cancelled!!!",
                                        "CANCEL CREDIT CARD SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(creditCardFrame, "Credit Card Already Cancelled!", "CANCEL CREDIT CARD FAILED",JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(creditCardFrame,
                            "Please give number value in Card ID",
                            "ALERT",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        else if (e.getSource() == creditGoBackButton)
        {
            creditCardFrame.dispose();
            mainFrame.setVisible(true);
        }

    }/*Calling mainMenu*/ 
    public void mainMenu()
    {
        mainFrame = new JFrame(); //creating JFrame
        mainFrame.setTitle("Bank of Nitika");// setting title
        mainFrame.setBounds(250,130, 850, 600); // setting bounds
        mainFrame.setLayout(null);// settingLayout to null
        mainFrame.setResizable(false);//setting resizable to flse

        mainPanel = new JPanel();//creating JPanel
        mainPanel.setBounds(0,0, 850, 600);
        mainPanel.setBackground(Color.BLACK);// setting background color
        mainPanel.setLayout(null);

        debitCardButton = new JButton();//creating JButton
        debitCardButton.setText("DEBIT CARD");
        debitCardButton.setBounds(250,100,330,175);
        debitCardButton.setFont(new Font("Arial",Font.BOLD,40));//setting fonts
        debitCardButton.addActionListener(this);
        mainPanel.add(debitCardButton);//adding button in Panel
        debitCardButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);//creating color class
        debitCardButton.setBackground(colorButton);
        debitCardButton.setBorderPainted(false);

        creditCardButton = new JButton();
        creditCardButton.setText("CREDIT CARD");
        creditCardButton.setBounds(250,300,330,175);
        creditCardButton.setFont(new Font("Arial",Font.BOLD,40));
        creditCardButton.addActionListener(this);
        mainPanel.add(creditCardButton);
        creditCardButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        creditCardButton.setBackground(colorButton);
        creditCardButton.setBorderPainted(false);

        mainFrame.add(mainPanel);// adding mainPanel in mainFrame
        mainFrame.setVisible(true);
    }
    /*Calling DebitCardGUI for the GUI of Debit Card Class */
    public void DebitCardGUI()
    {

       //JFrame
        debitCardFrame = new JFrame(); 
        debitCardFrame.setTitle("Bank of Nitika");
        debitCardFrame.setBounds(250,130, 850, 600); 
        debitCardFrame.setLayout(null);
        debitCardFrame.setResizable(false);
        
        //JPanel
        debitCardPanel = new JPanel();
        debitCardPanel.setBounds(0,0, 850, 600);
        debitCardPanel.setBackground(Color.PINK);
        debitCardPanel.setLayout(null);
        
        //JLabel
        debitCardLabel = new JLabel("Debit Card");
        debitCardLabel.setBounds(350,40,240,30);
        debitCardLabel.setFont(new Font("Arial", Font.BOLD, 25));
        debitCardPanel.add(debitCardLabel);

        debitCardIdLabel = new JLabel("Card Id");
        debitCardIdLabel.setBounds(50,90,100,30);
        debitCardIdLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        debitCardPanel.add(debitCardIdLabel);

        //JTextField
        textDebitCardId = new JTextField();
        textDebitCardId.setBounds(150,90, 120,30);
        debitCardPanel.add(textDebitCardId);

        debitIssuerBankLabel = new JLabel("Issuer Bank");
        debitIssuerBankLabel.setBounds(500,90,100,30);
        debitIssuerBankLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        debitCardPanel.add(debitIssuerBankLabel);

        textDebitIssuerBank = new JTextField();
        textDebitIssuerBank.setBounds(600,90, 120,30);
        debitCardPanel.add(textDebitIssuerBank);

        debitBalanceAmountLabel = new JLabel("Balance Amount");
        debitBalanceAmountLabel.setBounds(50,150,130,30);
        debitBalanceAmountLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        debitCardPanel.add(debitBalanceAmountLabel);

        textDebitBalanceAmount = new JTextField();
        textDebitBalanceAmount.setBounds(170,150, 120,30);
        debitCardPanel.add(textDebitBalanceAmount);

        debitClientNameLabel = new JLabel("Client Name");
        debitClientNameLabel.setBounds(500,150,100,30);
        debitClientNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        debitCardPanel.add(debitClientNameLabel);

        textDebitClientName = new JTextField();
        textDebitClientName.setBounds(600,150, 120,30);
        debitCardPanel.add(textDebitClientName);

        debitBankAccountLabel = new JLabel("Bank Account");
        debitBankAccountLabel.setBounds(50,210,100,30);
        debitBankAccountLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        debitCardPanel.add(debitBankAccountLabel);

        textDebitBankAccount = new JTextField();
        textDebitBankAccount.setBounds(150,210, 120,30);
        debitCardPanel.add(textDebitBankAccount);

        debitPinNumberLabel = new JLabel("Pin Number");
        debitPinNumberLabel.setBounds(500,210,100,30);
        debitPinNumberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        debitCardPanel.add(debitPinNumberLabel);

        textDebitPinNumber = new JTextField();
        textDebitPinNumber.setBounds(600,210, 120,30);
        debitCardPanel.add(textDebitPinNumber);

        debitWithdrawalAmountLabel = new JLabel("Withdrawal Amount");
        debitWithdrawalAmountLabel.setBounds(50,330,150,30);
        debitWithdrawalAmountLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        debitCardPanel.add(debitWithdrawalAmountLabel);

        textDebitWithdrawalAmount = new JTextField();
        textDebitWithdrawalAmount.setBounds(180,330, 120,30);
        debitCardPanel.add(textDebitWithdrawalAmount);

        debitDateOfWithdrawalLabel = new JLabel("Date of Withdrawal");
        debitDateOfWithdrawalLabel.setBounds(50,390,180,30);
        debitDateOfWithdrawalLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        debitCardPanel.add(debitDateOfWithdrawalLabel);

        //JComboBox
        Integer[] day = new Integer[31];
        for (int i = 0; i < 31; i++)
        {
            day[i] = i + 1;
        }

        debitDayComboBox = new JComboBox <Integer> (day);
        debitDayComboBox.setBounds(200,390,80,30);
        debitCardPanel.add(debitDayComboBox);

        String[] month = new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        debitMonthComboBox = new JComboBox(month);
        debitMonthComboBox.setBounds(300,390,100,30);
        debitCardPanel.add(debitMonthComboBox);

        Integer[] year = new Integer[100];
        int start = 2023;
        for (int j = 0; j < 100; j++)
        {
            year[j] = start;
            start--;
        }

        debitYearComboBox = new JComboBox<Integer> (year);
        debitYearComboBox.setBounds(420,390,100,30);
        debitCardPanel.add(debitYearComboBox);

        //JButton
        addDebitCardButton = new JButton("Add Debit Card");
        addDebitCardButton.setBounds(330, 260, 150, 30);
        debitCardPanel.add(addDebitCardButton);
        addDebitCardButton.addActionListener(this);
        addDebitCardButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        addDebitCardButton.setBackground(colorButton);
        addDebitCardButton.setBorderPainted(false);

        debitGoBackButton = new JButton("Go Back");
        debitGoBackButton.setBounds(500, 300, 100, 30);
        debitCardPanel.add(debitGoBackButton);
        debitGoBackButton.addActionListener(this);
        debitGoBackButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        debitGoBackButton.setBackground(colorButton);
        debitGoBackButton.setBorderPainted(false);

        debitWithdrawButton = new JButton("Withdraw");
        debitWithdrawButton.setBounds(300, 460, 130, 30);
        debitCardPanel.add(debitWithdrawButton);
        debitWithdrawButton.addActionListener(this);
        debitWithdrawButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        debitWithdrawButton.setBackground(colorButton);
        debitWithdrawButton.setBorderPainted(false);

        debitDisplayButton = new JButton("Display");
        debitDisplayButton.setBounds(450, 460, 100, 30);
        debitCardPanel.add(debitDisplayButton);
        debitDisplayButton.addActionListener(this);
        debitDisplayButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        debitDisplayButton.setBackground(colorButton);
        debitDisplayButton.setBorderPainted(false);

        debitClearButton = new JButton("Clear");
        debitClearButton.setBounds(600, 460, 100, 30);
        debitCardPanel.add(debitClearButton);
        debitClearButton.addActionListener(this);
        debitClearButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        debitClearButton.setBackground(colorButton);
        debitClearButton.setBorderPainted(false);

        //adding
        debitCardFrame.add(debitCardPanel);
        debitCardFrame.setVisible(false);
    }
    /*Calling method CreditCardGUI for the GUI of Credit Card class*/
    public void CreditCardGUI()
    {

        //JFrame
        creditCardFrame = new JFrame(); 
        creditCardFrame.setTitle("Bank of Nitika");
        creditCardFrame.setBounds(250,130, 850, 600); 
        creditCardFrame.setLayout(null);
        creditCardFrame.setResizable(false);

        //JPanel
        creditCardPanel = new JPanel();
        creditCardPanel.setBounds(0,0, 850, 600);
        creditCardPanel.setBackground(Color.PINK);
        creditCardPanel.setLayout(null);

        //JLabel
        creditCardLabel = new JLabel("Credit Card");
        creditCardLabel.setBounds(350,40,240,30);
        creditCardLabel.setFont(new Font("Arial", Font.BOLD, 25));
        creditCardPanel.add(creditCardLabel);

        creditCardIdLabel = new JLabel("Card Id");
        creditCardIdLabel.setBounds(50,90,100,30);
        creditCardIdLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditCardIdLabel);

        //JTextField
        textCreditCardId = new JTextField();
        textCreditCardId.setBounds(150,90, 120,30);
        creditCardPanel.add(textCreditCardId);

        creditIssuerBankLabel = new JLabel("Issuer Bank");
        creditIssuerBankLabel.setBounds(500,90,100,30);
        creditIssuerBankLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditIssuerBankLabel);

        textCreditIssuerBank = new JTextField();
        textCreditIssuerBank.setBounds(600,90, 120,30);
        creditCardPanel.add(textCreditIssuerBank);

        creditBalanceAmountLabel = new JLabel("Balance Amount");
        creditBalanceAmountLabel.setBounds(50,150,130,30);
        creditBalanceAmountLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditBalanceAmountLabel);

        textCreditBalanceAmount = new JTextField();
        textCreditBalanceAmount.setBounds(170,150, 120,30);
        creditCardPanel.add(textCreditBalanceAmount);

        creditClientNameLabel = new JLabel("Client Name");
        creditClientNameLabel.setBounds(500,150,100,30);
        creditClientNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditClientNameLabel);

        textCreditClientName = new JTextField();
        textCreditClientName.setBounds(600,150, 120,30);
        creditCardPanel.add(textCreditClientName);

        creditBankAccountLabel = new JLabel("Bank Account");
        creditBankAccountLabel.setBounds(50,210,100,30);
        creditBankAccountLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditBankAccountLabel);

        textCreditBankAccount = new JTextField();
        textCreditBankAccount.setBounds(150,210, 120,30);
        creditCardPanel.add(textCreditBankAccount);

        creditCvcNumberLabel = new JLabel("CVC Number");
        creditCvcNumberLabel.setBounds(500,210,100,30);
        creditCvcNumberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditCvcNumberLabel);

        textCreditCvcNumber = new JTextField();
        textCreditCvcNumber.setBounds(600,210, 120,30);
        creditCardPanel.add(textCreditCvcNumber);

        creditInterestRateLabel = new JLabel("Interest Rate");
        creditInterestRateLabel.setBounds(50,330,120,30);
        creditInterestRateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditInterestRateLabel);

        textCreditInterestRate = new JTextField();
        textCreditInterestRate.setBounds(180,330, 120,30);
        creditCardPanel.add(textCreditInterestRate);

        creditExpirationDateLabel = new JLabel("Expiration Date");
        creditExpirationDateLabel.setBounds(50,390,120,30);
        creditExpirationDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditExpirationDateLabel);

        creditLimitLabel = new JLabel("Credit Limit");
        creditLimitLabel.setBounds(50,450,120,30);
        creditLimitLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditLimitLabel);

        textCreditLimit = new JTextField();
        textCreditLimit.setBounds(180,450, 120,30);
        creditCardPanel.add(textCreditLimit);

        creditGracePeriodLabel = new JLabel("Grace Period");
        creditGracePeriodLabel.setBounds(50,510,120,30);
        creditGracePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditCardPanel.add(creditGracePeriodLabel);

        textCreditGracePeriod = new JTextField();
        textCreditGracePeriod.setBounds(180,510, 120,30);
        creditCardPanel.add(textCreditGracePeriod);

        //JComboBox
        Integer[] day = new Integer[31];
        for (int i = 0; i < 31; i++)
        {
            day[i] = i + 1;
        }

        creditDayComboBox = new JComboBox <Integer> (day);
        creditDayComboBox.setBounds(200,390,80,30);
        creditCardPanel.add(creditDayComboBox);

        String[] month = new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        creditMonthComboBox = new JComboBox(month);
        creditMonthComboBox.setBounds(300,390,100,30);
        creditCardPanel.add(creditMonthComboBox);

        Integer[] year = new Integer[100];
        int start = 2023;
        for (int j = 0; j < 100; j++)
        {
            year[j] = start;
            start--;
        }

        creditYearComboBox = new JComboBox<Integer> (year);
        creditYearComboBox.setBounds(420,390,100,30);
        creditCardPanel.add(creditYearComboBox);

        //JButton
        addCreditCardButton = new JButton("Add Credit Card");
        addCreditCardButton.setBounds(330, 260, 150, 30);
        creditCardPanel.add(addCreditCardButton);
        addCreditCardButton.addActionListener(this);
        addCreditCardButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        addCreditCardButton.setBackground(colorButton);
        addCreditCardButton.setBorderPainted(false);

        cancelCreditCardButton = new JButton("Cancel Credit Card");
        cancelCreditCardButton.setBounds(550, 260, 180, 30);
        creditCardPanel.add(cancelCreditCardButton);
        cancelCreditCardButton.addActionListener(this);
        cancelCreditCardButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        cancelCreditCardButton.setBackground(colorButton);
        cancelCreditCardButton.setBorderPainted(false);

        creditGoBackButton = new JButton("Go Back");
        creditGoBackButton.setBounds(550,390, 100, 30);
        creditCardPanel.add(creditGoBackButton);
        creditGoBackButton.addActionListener(this);
        creditGoBackButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        creditGoBackButton.setBackground(colorButton);
        creditGoBackButton.setBorderPainted(false);

        creditSetCreditLimitButton = new JButton("Set Credit Limit");
        creditSetCreditLimitButton.setBounds(380, 450, 150, 30);
        creditCardPanel.add(creditSetCreditLimitButton);
        creditSetCreditLimitButton.addActionListener(this);
        creditSetCreditLimitButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        creditSetCreditLimitButton.setBackground(colorButton);
        creditSetCreditLimitButton.setBorderPainted(false);

        creditDisplayButton = new JButton("Display");
        creditDisplayButton.setBounds(590, 480, 100, 30);
        creditCardPanel.add(creditDisplayButton);
        creditDisplayButton.addActionListener(this);
        creditDisplayButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        creditDisplayButton.setBackground(colorButton);
        creditDisplayButton.setBorderPainted(false);

        creditClearButton = new JButton("Clear");
        creditClearButton.setBounds(480, 520, 100, 30);
        creditCardPanel.add(creditClearButton);
        creditClearButton.addActionListener(this);
        creditClearButton.setOpaque(true);
        colorButton = new Color(247, 12, 114);
        creditClearButton.setBackground(colorButton);
        creditClearButton.setBorderPainted(false);

        //adding
        creditCardFrame.add(creditCardPanel);
        creditCardFrame.setVisible(false);
    }

    /*Calling main method*/
    public static void main(String[] args)
    {
        BankGUI bankGUI = new BankGUI();
        bankGUI.mainMenu();
        bankGUI.DebitCardGUI();
        bankGUI.CreditCardGUI();

    }
}