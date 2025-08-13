
/**
 * The following is BankCard class which serves as a parent class, also known as super class or base class.
 * It consists of attributes, constructor which is a special kind of method,
 * getter methods also known as accessor method, setter methods also known as mutator method
 * and also, a method to display the details of the Bank
 * @author (Nitika Rai)
 * @version (5.1.0a)
 */
public class BankCard
{
    //BankCard class has five Attributes
    private int cardID;//A variable name cardID with int data type is created using private
    private int balanceAmount;//A variable name balanceAmount with int data type is created using private
    private String clientName;//A variable name clientName with String data type is created using private
    private String issuerBank;//A variable name issuerBank with String data type is created using private
    private String bankAccount;//A variable name bankAccount with String data type is created using private
  
    
    /*The constructor accepts four parameters: balanceAmount, cardID, bankAccount, issuerBank*/
    public BankCard(int balanceAmount, int cardID, String bankAccount, String issuerBank)
    {
        this.balanceAmount = balanceAmount;//assigning the value of instance variable,balanceAmount to the parameter, balanceAmount
        this.cardID = cardID;//assigning the value of instance variable,cardID to the parameter, cardID
        this.clientName = "";//assigning the value of instance variable,clientName to empty String data type
        this.bankAccount = bankAccount;//assigning the value of instance variable,bankAccount to the parameter, bankAccount
        this.issuerBank = issuerBank;//assigning the value of instance variable,issuerBank to the parameter,issuerBank
    }
    
    /*Creating Accessor method to each attribute*/
    //Accessor method----> instance variable:CardID
    public int getCardID()
    {
        //int cardID;
        return this.cardID;
    }
    
    //Accessor method ----> instance variable:BalanceAmount
    public int getBalanceAmount()
    {
        return this.balanceAmount;
    }
    
    //Accessor method ----> instance variable: BankAccount
    public String getBankAccount()
    {
        return this.bankAccount;
    }
    
    //Accessor method ----> instance variable: IssuerBank
    public String getIssuerBank()
    {
        return this.issuerBank;
    }
    
    //Accessor method ----> instance variable: ClientName
    public String getClientName()
    {
        return this.clientName;
    }

    /*Creating setters method which accepts new parameters*/
    //Setters method: Set a client name
    public void setClientName( String clientName)
    {
        this.clientName = clientName;
    }
    
    //Setters method: Set a balance amount
    public void setBalanceAmount( int balanceAmount)
    {
        this.balanceAmount = balanceAmount;
    }
    
    /*Display method gives the suitable output*/
    public void display()
    {
        System.out.println("Card ID: " + cardID);
        if (clientName.isEmpty())
        {
            System.out.println("Client Name is not assigned. Please enter client name.");
        }
        else
        {
        System.out.println("Client Name: " + this.clientName);
        }
        System.out.println("Issuer Bank: " + this.issuerBank);
        System.out.println("Bank Account: " + this.bankAccount);
        System.out.println("Balance Amount: " + this.balanceAmount);
        
    }
    }

