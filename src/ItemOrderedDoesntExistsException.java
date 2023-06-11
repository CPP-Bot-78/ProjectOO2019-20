public class ItemOrderedDoesntExistsException extends Exception
{
    public ItemOrderedDoesntExistsException()
    {
      super();
    }
    public void displayMessage(){System.out.println("Το συγκεκριμένο αντικείμενο δεν υπάρχει στην λίστα σας. Παρακαλούμε ξαναπροσπαθήστε.");}
}
