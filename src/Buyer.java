import java.util.*;
public class Buyer extends User
{
    private boolean isAdmin;
    private int bonus = 0;
    private String buyerCategory = "BRONZE";
    protected EShop eshop;    
    protected List <ItemOrdered> list;
    protected ShoppingCart shopcart;
    Scanner keyboard = new Scanner(System.in);
    public Buyer(String name, String email, EShop eshop)
    {
     super(name,email);  
     this.list = new ArrayList();//κάθε αγοραστής έχει την δικιά του λίστα
     this.shopcart = new ShoppingCart(list); //η λίστα δίνεται ως όρισμα στο προσωπικό καλάθι
     this.eshop = eshop;                    // του χρήστη
     this.isAdmin= false;
    }
    public int awardBonus(Buyer buyer)
    { 
      bonus += (int)( 10 * shopcart.calculateNet( buyer ) )/100; //typecast σε int
      setBuyerCategory();
      return bonus;
    }
    public void setBuyerCategory()
    {
     if( bonus > 100 && bonus < 200 )
     {
       buyerCategory = "SILVER";
       System.out.print("Μπράβο! Είστε στην κατηγορία Silver ! ");
       System.out.println("Έχετε 50% έκπτωση στα μεταφορικά σας !!");
     }
      else if( bonus > 200 )
     {
       buyerCategory = "GOLD";
       System.out.print("Συγχαρητήρια! Eίστε στην κατηγορία Gold !! ");
       System.out.println("Έχετε τα μεταφορικά σας δώρο !!!");
     }
    }
    public boolean placeOrder(Item item,int quantity)
    { 
     boolean bool = false;
     try{   
       if ( quantity > 0 ) 
      {
       ItemOrdered itord = new ItemOrdered(item, quantity);
       bool = shopcart.addItemOrdered(itord);
      }
      else 
      {
        OrderFailedException ofe = new OrderFailedException(); 
        throw  ofe;
      }
        if ( bool == true ) { return true;}
         else {return false;}
     }catch(OrderFailedException ofe){ofe.displayMessage(); return false;}
    }
    public String buyerInfo() //εξτρα μεθοδος
    {
        System.out.println("Πελάτης: " + getName());
        System.out.println("Email: " +  getEmail() );
        System.out.println("Bonus πόντοι: " + getBonus());
        System.out.println("Κατηγορία πελάτη: "+ getBuyerCategory());
        return "\n";
    }
                     //getters
    public int getBonus(){return bonus;}
    public String getBuyerCategory(){return buyerCategory;}
}
                          