import java.util.*;
public class ShoppingCart 
{
    protected List <ItemOrdered> orderedList = new ArrayList();
    Scanner keyboard = new Scanner(System.in);
    public ShoppingCart(List<ItemOrdered> orderedList)
    {
      this.orderedList = orderedList;
    }
    public Boolean addItemOrdered(ItemOrdered itord)
    {
         
      try{  
        try{  
         boolean b = orderedList.add(itord); 
          if( b != true )
         {
            OrderFailedException ofe = new OrderFailedException();
            throw ofe;
         }
        }catch(OrderFailedException ofe){ ofe.displayMessage(); return false; }
        itord.getItem().setStock( (itord.getItem().getStock() - itord.getQuantity()) );
        if( itord.getItem().getStock() < 0 )
         {
           NotEnoughStockException nese = new NotEnoughStockException();
           throw nese;
         }        
      }
       catch(NotEnoughStockException nese)
      {
        nese.displayMessage();
        itord.getItem().setStock(itord.getItem().getStock() + itord.getQuantity());
        orderedList.remove(orderedList.size()-1); 
        return false;
      } 
      for(int j=0; j < orderedList.size()-1; j++ )
      {
         if ( itord.getItem().getNameItem().equals( orderedList.get(j).getItem().getNameItem() ) )
        {
          itord.setQuantity(itord.getQuantity() + orderedList.get(j).getQuantity());
        }
      }
      return true;
    }
    public void removeItemOrdered(ItemOrdered itord)
    { 
      for( int i = 0 ; i < orderedList.size() ; i++ )  
      {
        if( itord == orderedList.get(i) )
          orderedList.remove(i);
      }
      itord.getItem().setStock(itord.getItem().getStock() + itord.getQuantity());
      System.out.println("Το αντικείμενο αφαιρέθηκε επιτυχώς από το καλάθι σας.");
    }
    public void changeItemOrderedQuantity(ItemOrdered itord,EShop shop)
    {  
      keyboard.close();
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Διαθέσιμο στοκ: " + itord.getItem().getStock());  
      System.out.println("Παρακαλώ εισάγετε πόσα αντικείμενα θέλετε να παραγγείλετε");
      try{
       int newQuantity = keyboard.nextInt();
       if ( newQuantity <= 0 ){System.out.println("Δεκτοί αριθμοί > 0 "); changeItemOrderedQuantity(itord,shop);}
          
        if ( newQuantity > itord.getItem().getStock() )
       {
         System.out.print("Δεν υπάρχει αρκετή ποσότητα διαθέσιμη από το συγκεκριμένο προϊόν.");
         System.out.println(" Το διαθέσιμο στοκ είναι " + itord.getItem().getStock()+ " . Θα θέλατε να το δεσμεύσετε όλο ?");
         System.out.println("Type y for yes or n for no");
         String ans = keyboard.nextLine();
         if ( ans.equals( "y" ) )
         {
            shop.updateItemStock( itord.getItem(), itord.getItem().getStock());  
         }
          else 
            changeItemOrderedQuantity(itord,shop);
       }
        else 
       { 
         shop.updateItemStock( itord.getItem(),itord.getItem().getStock() - newQuantity  );
         itord.setQuantity(newQuantity);
       }
        System.out.println("H ποσότητα του προϊόντος " + itord.getItem().getNameItem()+ " ενημερώθηκε επιτυχώς!");  
      }
       catch(InputMismatchException ime)
      {
        System.out.println("Λάθος εισχώρηση. Παρακαλούμε δοκιμάστε ξανά");
        changeItemOrderedQuantity(itord,shop); 
      }
    }
    public void showCart() throws EmptyCartException
    { 
      try{  
        if ( orderedList.size() != 0 ) 
       {
         System.out.println("->Tο καλάθι μου:");  
          for(int i = 0; i < orderedList.size(); i++  )
         {   
            int m = i+1;//για να ξεκινησει από το 1 η αριθμημένη λιστα,οπως συνηθιζεται   
            System.out.print(m + ")" + "* Προϊόν: ");
            System.out.println(orderedList.get(i).getItem().getNameItem());
            System.out.print("*Τιμή προϊόντος: ");
            System.out.println(orderedList.get(i).getItem().getPrice());
            System.out.print("*Ποσότητα: ");
            System.out.println(orderedList.get(i).getQuantity());
            System.out.println();
         }
       }
        else 
       {
          EmptyCartException ece = new EmptyCartException();
          throw ece;
       }
      }catch(EmptyCartException ece){ece.displayMessage();}
    }
    public void clearCart()
    {
        orderedList.clear();
    }
    public void checkout(Buyer buyer) throws EmptyCartException// λογω της showCart()
    {  
        showCart();
        System.out.println("Το κόστος είναι: " +  String.format("%.2f",calculateNet(buyer) ) +" € με μεταφορικά αξίας: " + String.format("%.2f", calculateCourierCost( buyer ) ) ); 
                      // με την String.format περιορίζουμε τα δεκαδικά ψηφία σε 2
        double sum = calculateNet( buyer ) + calculateCourierCost( buyer );
        System.out.println("Το συνολικό κόστος ανέρχεται σε: "+ String.format("%.2f",sum ) +" €");
        System.out.println("Θέλετε να προχωρήσετε σε πληρωμή ?");
        System.out.println(" Αν ναι πατήστε 'y' αλλιώς  'n'" );
        try{
          keyboard.close();
          Scanner keyboard = new Scanner(System.in);
          String ans = keyboard.nextLine();
           if ( ans.equals("y") )
          {
            System.out.println("Πόντοι bonus: " + buyer.awardBonus( buyer ));
            System.out.println("Ευχαριστούμε πολύ !!!!");
            buyer.shopcart.clearCart(); //καθαρίζεται το καλαθι 
           }
           else if( ans.equals("n") )
             {System.out.println("Eπιστρέφουμε στο αρχικό μενού");}
          else {System.out.println("Λάθος απάντηση. Παρακαλώ ξαναπροσπαθείστε.");}
        }catch(InputMismatchException ime)
        {System.out.println("Λάθος εισχώρηση. Παρακαλούμε δοκιμάστε ξανά"); checkout (buyer);} 
        keyboard.reset();
    }
    public double calculateNet(Buyer buyer)
    { 
      double price = 0;
       for(int i = 0; i < buyer.shopcart.orderedList.size(); i++  )
       { 
          price += ( orderedList.get(i).getItem().getPrice() * orderedList.get(i).getQuantity()  );  
       }  
      return price;
    }
    public double calculateCourierCost(Buyer buyer)
    { 
       double ccost = 0 ;
       double price = ( 2 * calculateNet( buyer )/ 100 );// εξ’ ορισμού η τιμή των μεταφορικών 
       switch( buyer.getBuyerCategory() )
       {
           case "BRONZE": 
                 if ( price <= 3 ) {ccost = 3 ;} 
                 else  {ccost = price ;}           
                 break;
           case "SILVER":
                 ccost = price ;
                 break;
           case "GOLD":
                 ccost = 0;
                 break;
       }
       return ccost;
    }
    public ItemOrdered stringToItemOrdered(String itemName)
    { 
      ItemOrdered itemordered = null;
      try{
        for(int i=0; i < orderedList.size(); i++ )
       {
          if ( itemName.equals( orderedList.get(i).getItem().getNameItem() ) )
         { 
           itemordered = orderedList.get(i);
           return itemordered;
         }
       } 
      }catch(NullPointerException npe){System.out.println("Δεν υπάρχει προϊόν με αυτό το όνομα.");   }  
      return itemordered;
    }
}
