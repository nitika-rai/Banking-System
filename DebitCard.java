
/**
 * The following is DebitCard class which serves as a child class, also known as sub class or derived class.
 * DebitCard inherits the properties of BankCard class.
 * consists of attributes, constructor, accessor method, mutator method which is a special kind of method,
 * a method to withdraw and also, a method to display the details of the debit card.
 * @author (Nitika Rai)
 * @version (5.1.0a)
 */
public class DebitCard extends BankCard
{
    //DebitCard class has four Attributes
    private int pinNumber;//A variable name pinNumber with int data type is created using private
    private int withdrawalAmount;//A variable name withdrawalAmount with int data type is created using private
    private String dateOfWithdrawal;//A variable name datteOfWithdrawal with String data type is created using private
    private boolean hasWithdrawn;//A variable name hasWithdrawn with boolean data type is created using private
    
    /*The constructor accepts six parameters: balanceAmount, cardID, bankAccount,issuerBank, clientName, pinNumber*/
    public DebitCard(int balanceAmount, int cardID, String bankAccount, String issuerBank, String clientName, int pinNumber)
    {
        super(balanceAmount, cardID, bankAccount, issuerBank);//Calls the super constructor of BankCard class that passes four parameters: balanceAmount, cardID, bankAccount, issuerBank
        super.setClientName(clientName);//calls the setters method: setClientName with a parameter: clientName
        this.pinNumber=pinNumber;//assigning the value of instance variable,pinNumber to the parameter, pinNumber
        this.hasWithdrawn=false;//assigning the value of instance variable,hasWithdrawn to false boolean
    }
    
    /*Creating Accessor method to each attribute*/
    //Accessor method ----> instance variable:pinNumber
    public int getPinNumber()
    {
        return this.pinNumber;
    }
    
    //Accessor method ----> instance variable:withdrawalAmount
    public int getWithdrawalAmount()
    {
        return this.withdrawalAmount;
    }
    
    //Accessor method ----> String variable:dateOfWithdrawal
    public String getDateOfWithdrawal()
    {
        return this.dateOfWithdrawal;
    }
    
    //Accessor method ----> boolean variable: hasWithdrawn
    public boolean getHasWithdrawn()
    {
        return this.hasWithdrawn;
    }
    
    /*Creating mutator method for attribute: withdrawalAmount*/
    //Mutator method ----> withdrawal amount
    public void setWithdrawalAmount( int withdrawalAmount)
    {
        this.withdrawalAmount = withdrawalAmount;//assigning the value of instance variable,withdrawalAmount to the parameter: withdrawalAmount
   
    }
    
    /* Creating a method withdraw() which accepts four parameters: withdrawalAmount, dateOfwithdrawal, pinNumber */
    public void withdraw(int withdrawalAmount, String dateOfWithdrawal, int pinNumber)
    {
        if(pinNumber == this.pinNumber)//if parameter,pinNumber equals the value of instance variable: pinNumber
        {
            if(withdrawalAmount <= this.getBalanceAmount())//if parameter,balanceAmount is less or eual to the value of accessor method, getBalanceAmount()
            {
                super.setBalanceAmount(this.getBalanceAmount()-withdrawalAmount);//calls the setters method and pass the vlue of difference between the accessor method, getBalanceAmount and withdrawalAmount as parameter
                this.hasWithdrawn=true;//assigning value of instance variable to true boolean
                this.dateOfWithdrawal = dateOfWithdrawal;//assigning the value of instance variable,dateOfWithdrawal to the parameter, dateOfWithdrawal
                this.withdrawalAmount = withdrawalAmount;//assigning the value of instance variable,withdrawalAmount to the parameter, withdrawalAmount
                System.out.println("Transaction Successfull!");
                System.out.println(withdrawalAmount+" has been detucted from your bank account.");
                System.out.println("Your new balance is:"+this.getBalanceAmount());
                
            }
            else
            {
                System.out.println("No sufficient Balance Amount!!!");
                System.out.println("Your Balance amount is: "+this.getBalanceAmount());
                
            }
        }
        else
        {
            System.out.println("Invalid PIN number");
            
        }
    }
    
    /*Display method gives the suitable output*/
    public void display()
    {
        super.display();//calling the display method of BankCard class
        if(this.hasWithdrawn == true)//if the value of instance variable is true boolean
        {
            System.out.println("PIN number : "+this.pinNumber);
            System.out.println("Withdrawal Amount : "+this.withdrawalAmount);
            System.out.println("Date of Withdrawal : "+this.dateOfWithdrawal);
        }
        else
        {
            System.out.println("Balance Amount : "+this.getBalanceAmount());
        }
    }
}

