 public class EmptyCartException extends Exception
{
    public EmptyCartException()
    {
      super();
    }   
    public void displayMessage(){ System.out.println("Oops. Από ότι φαίνεται το καλάθι σας είναι άδειο.");}
    public void displayMessageOwner(){System.out.println("Tο καλάθι του χρήστη είναι άδειο.");}
}

