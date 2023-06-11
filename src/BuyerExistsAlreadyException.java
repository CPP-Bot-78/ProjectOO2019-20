public class BuyerExistsAlreadyException extends Exception
{
  BuyerExistsAlreadyException()
  {
      super();
  }
  public void displayMessage(){System.out.println("Ο λογαριασμός χρηστή υπάρχει ήδη.");}
}
