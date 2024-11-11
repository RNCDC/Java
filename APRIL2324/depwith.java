package APRIL2324;

public class depwith 
{
	static constructor cons = new constructor();
	static float balance,bal;
	
	public void deposit(float amount) 
	{
        balance += amount;
        //bal = balance + cons.getindep();
        cons.setob(balance);
    }

    public void withdraw(float amount) 
    {
        if (cons.getindep() >= amount) 
        {
        	balance = cons.getindep();
            bal -= amount;
           
            //bal = balance + cons.getindep();
            cons.setob(bal);
        } 
        else 
        {
            System.out.println("Insufficient balance");
            return;
        }
        
    }
    
}
