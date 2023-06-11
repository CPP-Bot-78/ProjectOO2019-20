public class OrderFailedException extends Exception
{
    public OrderFailedException()
    {
      super();
    }
    public void displayMessage(){System.out.println("Κάτι πήγε στραβά. Η παραγγελία δεν κατοχυρώθηκε");}
}
