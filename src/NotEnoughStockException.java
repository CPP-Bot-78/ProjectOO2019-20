public class NotEnoughStockException extends Exception
{
    public NotEnoughStockException()
    {
      super();
    }
    public void displayMessage(){System.out.println("Δεν υπάρχει αρκετά διαθέσιμο stock.");}
}
