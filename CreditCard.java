
/**
 * The following is CreditCard class which serves as a child class, also known as sub class or derived class.
 * CreditCard inherits the properties of BankCard class.
 * consists of attributes, constructor, accessor method, mutator method which is a special kind of method,
 * a method to cancelling and also, a method to display the details of the credir card.
 * @author (Nitika Rai)
 * @version (5.1.0a)
 */
public class CreditCard extends BankCard
{
     //CreditCard class has six Attributes
    private int cvcNumber;//A variable name cvcNumber with int data type is created using private
    private double creditLimit;//A variable name creditLimit with double data type is created using private
    private double interestRate;//A variable name interestRate with double data type is created using private
    private String expirationDate;//A variable name expirationDate with String data type is created using private
    private int gracePeriod;//A variable name gracePeriod with int data type is created using private
    private boolean isGranted;//A variable name isGranted with boolean data type is created using private
    
    /*The constructor accepts eight parameters: cardID, clientName, issuerBank, bankAccount,balanceAmount,cvcNumber, interestRate, expirationDate */ 
    public CreditCard(int cardID, String clientName,String issuerBank, String bankAccount, int balanceAmount, int cvcNumber, double interestRate, String expirationDate)
    {
        super ( balanceAmount, cardID, bankAccount, issuerBank);//Calls the super constructor of BankCard class that passes four parameters:balanceAmount, cardID, bankAccount, issuerBank
        super.setClientName(clientName);//calls the setters method: setClientName with a parameter: clientName
        this.cvcNumber=cvcNumber;//assigning the value of instance variable,cvcNumber to the parameter, cvcNumber
        this.interestRate=interestRate;//assigning the value of instance variable,interestRate to the parameter, interestRate
        this.expirationDate=expirationDate;//assigning the value of instance variable,expirationDate to the parameter, expirationDate
        this.isGranted=false;//assigning the value of instance variable,isGranted to false boolean
        
    }
    
    /*Creating Accessor method to each attribute*/
    //Acessor Method(Getters Method)
    public int getCvcNumber()
    {
        return this.cvcNumber;
    }
    
    public double getCreditLimit()
    {
        return this.creditLimit;
    }
    
    public double getInterestRate()
    {
        return this.interestRate;
    }
    
    public String getExpirationDate()
    { 
        return this.expirationDate;
    }
    
    public int getGracePeriod()
    {
        return this.gracePeriod;
    }
    
    public boolean getIsGranted()
    {
        return this.isGranted;
    }
    
    /*Creating mutator method for attribute: creditLimt that accepts new parameters for creditLimit and gracePeriod*/
    public void setCreditLimit(double creditLimit, int gracePeriod)
    {
        if (creditLimit<=(2.5*this.getBalanceAmount()))//if the value of creditLimit is less or equal to 2.5 times the value returned by accessor method: getBalanceAmount
        {
            this.creditLimit=creditLimit;//assigning the value of instance variable,creditLimit to the parameter,creditLimit
            this.gracePeriod=gracePeriod;//assigning the value of instance variable,gracePeriod to the parameter,gracePeriod
            this.isGranted=true;//assigning the value of instance variable,isGranted to true boolean type
        }
        else
        {
            System.out.println("Credit cannot be issued");
            System.out.println("Credit is granted of: "+ (2.5*this.getBalanceAmount()));
        }
    }
    
    /* Creating a method cancelCreditCard */ 
    public void cancelCreditCard()
    {
        //attributes cvcNumber, creditlimit and gracePeriod is set to zero while isGranted to false
        this.cvcNumber = 0;
        this.creditLimit = 0;
        this.gracePeriod = 0;
        this.isGranted = false;
    }
    
    /*Display method gives the suitable output*/
    public void display()
    {
        if (this.isGranted == true)//if the instance variable value is true
        {
            super.display();//calls display method of BankCard class
            System.out.println("CVC Number: " + this.cvcNumber);
            System.out.println("Credit Limit: " + this.creditLimit);
            System.out.println("Grace Period: " + this.gracePeriod);
            System.out.println("Interest Rate: " + this.interestRate);
            System.out.println("Expiration Date: " + this.expirationDate);
        }
        else
        {
            super.display();//calls display method of BankCard class
            System.out.println("CVC Number: " + this.cvcNumber);
            System.out.println("Interest Rate: " + this.interestRate);
            System.out.println("Expiration Date: " + this.expirationDate);
        }
    }
}
