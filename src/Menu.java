import java.util.*;
public class Menu 
{
   private EShop eshop;
   private Owner owner;
   Scanner keyboard = new Scanner(System.in);
   public Menu(EShop eshop,Owner owner)
   {  
      this.eshop = eshop;
      this.owner = owner;
   }
   public void hello() throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException
   {
     System.out.println("Καλώς ορίσατε στο κατάστημά μας!!");
     start();
   }
   
   public void start() throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException
   {  
    System.out.println("Παρακαλούμε εισάγετε το email σας.");    
    keyboard.close();
    Scanner keyboard = new Scanner(System.in);
    try{ 
     String s = keyboard.nextLine();//ζητείται email
      if ( s.equals( owner.getEmail() ) ) 
     {
       ownerHello();//αν είναι ο ιδιοκτήτης μεταφέρεται στο ειδικό καλωσόρισμα του
     }
     //αν βρεθεί στην λίστα μεταφέρεται στο καλωσόρισμα των πελατών 
       for ( int i = 0; i < eshop.buyersList.size(); i++ )
       { 
          if ( s.equals( eshop.buyersList.get(i).getEmail() ) )
         { 
               buyerHello( eshop.buyersList.get(i) ); 
         }
       }
           System.out.print("Από ότι φαίνεται δεν διαθέτετε ενεργό λογαριασμό. ");   
           System.out.println("Θα θέλατε να εγγραφείτε στο κατάστημά μας ?"); 
           System.out.println("Αν θέλετε πατήστε 'yes', αλλιώς 'no' ");
           keyboard.reset();
           String s1 = keyboard.nextLine();
           switch ( s1 )
          {
           case "yes": 
                System.out.println("Παρακαλώ εισάγετε όνομα και email");
                String name = keyboard.nextLine();
                String email = keyboard.nextLine();
      
                Buyer buyer = new Buyer(name,email,eshop);
                eshop.addBuyer(buyer);
                buyerHello(buyer);
                break;
           case "no":
                System.out.print("Λυπόμαστε πολύ αλλά χρειάζεστε λογαριασμό για να συνεχίσετε ");
                System.out.println("τα ψώνια σας στο κατάστημά μας. Καλή συνέχεια!");
                System.exit(0);
                break;
           default: 
                System.out.println("Η επιλογή αυτή δεν είναι διαθέσιμη. Παρακαλούμε ξαναπροσπαθήστε.");
                start();
                break;
          }
       keyboard.reset();
    }catch(InputMismatchException ime){System.out.println("Δώσατε λάθος δεδομένα. Ξαναδοκιμάστε");start();}
   }
   
                                               /** Owner methods **/
    public void ownerHello() throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException
   {
     System.out.println("Καλώς ήρθες "+ owner.getName() + " στο κατάστημα σου " + eshop.getName() + " !!!");
     System.out.println("Email: "+owner.getEmail());
     System.out.println("Iδιοκτήτης καταστήματος!\n");
     ownerMenu();
   }
   public void ownerMenu() throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException
   {
     keyboard.close();
     Scanner  keyboard = new Scanner(System.in);
     System.out.println("❖ Θες να περιηγηθείς στο κατάστημά ?      -> 'katastima' ");
     System.out.println("❖ Θες να ελέγξεις τους πελάτες ?          -> 'pelates'");
     System.out.println("❖ Θες να αποσυνδεθείς από χρήστης ?       -> 'user'");
     System.out.println("❖ Θες να αποχωρήσεις από το κατάστημα ?   -> 'exit'");  
     System.out.print("Παρακαλώ πληκτρολογήσε τον κωδικό ");
     System.out.println("που αναγράφεται δίπλα στην κάθε επιλογή.");
     try
    {
     keyboard.reset();
     String ans = keyboard.nextLine();  
     switch ( ans )
     {
       case "katastima":
             eshop.showCategories();
             ownerBrowseStore();
             break;
       case "pelates":
             checkStatus();
             break;
       case "user":  
             System.out.println("Tα ξαναλέμε σύντομα!\n");
             hello();
             break;
       case "exit":  
             System.out.println("Καλή συνέχεια αφεντικό!");
             System.exit(0);
             break;
       default:
             keyboard.reset();
             System.out.println("Ανεπιτυχής καταχώρηση κωδικού. Ξαναπροσπαθήστε.");
             ownerMenu();//σε περιπτωση που ξαναρχίσει δεν θα χρειαστεί να δούμε τις κατηγορίες λόγω της εξτρα μεθόδου
             break;
     }
    }catch(InputMismatchException ime){System.out.println("Λάθος εισχώρηση. Παρακαλούμε δοκιμάστε ξανά");ownerMenu();}
   }
   public void ownerBrowseStore() throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException 
   {
     keyboard.close(); 
     eshop.showProductsInCategory();
     System.out.print("Θα ήθελες να δεις πληροφορίες για συγκεκριμένο προϊόν (yes) ");
     System.out.println("ή προτιμάς να επιστρέψεις στο αρχικό μενού (menu) ?");
     try{
      Scanner  keyboard = new Scanner(System.in);
       String ans = keyboard.nextLine();  
        switch( ans )
       {
         case "yes":
              System.out.println("Πληκτρολογήστε το id του προϊόντος."); 
              Item item = eshop.showProduct();
              System.out.println("Θέλεις να επεξεργαστείς την ποσότητα ενός προϊόν ?");
              System.out.println("Πάτα 'y' για ναι ή 'n' για όχι");
              keyboard.reset();
              String ans2 = keyboard.nextLine();  
              switch( ans2 )
              {
                case "y": 
                     System.out.println("Πόση ποσότητα θα προστεθεί επιπλέον?");
                     int quantity = keyboard.nextInt();
                      if ( quantity <= 0) 
                      {   
                          System.out.println("Ανεπιτυχής καταχώρηση.");
                          ownerBrowseStore();
                      }
                     eshop.updateItemStock( item , item.getStock() + quantity);
                     ownerBrowseStore();
                     break;
                case "n":
                     ownerBrowseStore();
                     break;
                default:
                     keyboard.reset();
                     System.out.print("Ανεπιτυχής καταχώρηση");
                     ownerBrowseStore() ;
                     break;
              }
              break;     
         case "menu":     
              ownerMenu();
              break;
              
         default:
              keyboard.reset();
              System.out.println("Λανθασμένος κωδικός. Δοκιμάστε πάλι.");
              ownerBrowseStore();
              break;    
       }
       keyboard.reset();
     }catch(InputMismatchException ime)
     {System.out.println("Λανθασμένος κωδικός. Παρακαλούμε δοκιμάστε ξανά"); ownerBrowseStore();}
   }
   public void checkStatus() throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException
   {
     keyboard.close();
     Scanner  keyboard = new Scanner(System.in);
     eshop.checkStatus();
     System.out.println("Eπελέξε κάποιον πελάτη -> δώσε το όνομα του ?");
     System.out.println("Αν θες να επιστρέψεις στο αρχικό μενού πάτα 'menu' .");
     try{
      keyboard.reset();
      String customer = keyboard.next(); //Ζητείται το όνομα του αγοραστή 
      String realCustomer = ""; //αρχικοποιείται ο αγοραστής
      
      if ( customer.equals( "menu" ) ) 
         ownerMenu(); 
       
       for(int k=0; k < eshop.buyersList.size(); k++)
      {
        if( customer.equals( eshop.buyersList.get(k).getName() ) )
       { 
          realCustomer = eshop.buyersList.get(k).getName();
       }
      }
      if ( realCustomer == "")// ελέγχουμε αν όντως βρέθηκε ο αγοραστής
      { // αν ισχύει η ισότητα τότε δεν έχει βρεθεί και η μέθοδος ξεικνά πάλι
        System.out.println("Δεν πελάτης υπάρχει με τέτοιο όνομα. Δοκιμάστε ξανά");
        checkStatus();
      }
      
       for(int j=0; j < eshop.buyersList.size(); j++)
      {
        if( customer.equals( eshop.buyersList.get(j).getName() ) )
       {   
         try{ //αν το καλάθι του αγοραστή είναι κενό εγείρεται εξαίρεση
            if ( eshop.buyersList.size() != 0 ) 
           {
              eshop.buyersList.get(j).shopcart.showCart();   
           }
            else
           {
             EmptyCartException ece = new EmptyCartException();
             throw ece;
           }//ειδικό μήνυμα για τον ιδιοκτήτη
           }catch(EmptyCartException ece){ece.displayMessageOwner();}
        }
       }
           System.out.println("Θες να διαγράψεις τον συγκεκριμένο πελάτη ?");
           System.out.println("Πάτα 'y' αν θες, αλλιώς 'n'");
           Scanner keyboard2 = new Scanner(System.in);
           String answer = keyboard2.nextLine();
            if ( answer.equals("y") ) 
           {
              for(int i=0; i < eshop.buyersList.size(); i++)//ψάχνει τον πελάτη
             {
               if( customer.equals( eshop.buyersList.get(i).getName() ) )
              { 
                 eshop.removeBuyer(eshop.buyersList.get(i)); //τον διαγράφει
                 System.out.println("O χρήστης αφαιρέθηκε με επιτυχία");
              }  
             }
            }
            keyboard2.reset();
            System.out.println("Αν θες να επιστρέψεις στο αρχικο μενού πάτα 'menu', αλλιώς 'pelates'");
            Scanner keyboard1 = new Scanner(System.in);
            String answer2 = keyboard1.nextLine();
            if ( answer2.equals("menu") ) 
               ownerMenu();
            else if( answer2.equals("pelates") )
               checkStatus(); 
            else {System.out.println("Ξαναδοκιμάστε."); checkStatus(); }  
       keyboard.reset(); //αποφυγή προβλημάτων
     }catch(InputMismatchException ime){System.out.println("Λάθος . Ξαναπροσπάθησε "); checkStatus();}
   }
   
                                             /** Buyer methods **/
                                                                   
    public void buyerHello(Buyer buyer) throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException //extra μέθοδος 
   {
     System.out.println("Καλώς ήρθατε κύριε-α "+ buyer.getName() + " στο κατάστημα " + eshop.getName() + " !!!");
     System.out.println("Email: "+ buyer.getEmail());
     System.out.println("Bonus Πόντοι: "+ buyer.getBonus());
     System.out.println("Κατηγορία: "+ buyer.getBuyerCategory());
     System.out.println();
     buyerMenu(buyer);
   }
    public void buyerMenu(Buyer buyer) throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException
   {
     keyboard.close();
     System.out.println("❖ Θα θέλατε να περιηγηθείτε στο κατάστημα μας ?     -> 'katastima'");
     System.out.println("❖ Θέλετε να δείτε το περιχόμενο του καλαθιού σας ?  -> 'kalathi'");
     System.out.println("❖ Επιθυμείτε να ολοκληρώσετε την παραγγελεία σας ?  -> 'pay'");
     System.out.println("❖ Θα θέλατε να αποσυνδεθείτε από χρήστης ?          -> 'user'");
     System.out.println("❖ Θέλετε να αποχωρήσετε από το κατάστημα ?          -> 'exit'");  
     System.out.print("Παρακαλούμε πληκτρολογήστε τον κωδικό ");
     System.out.println("που αναγράφεται δίπλα σε κάθε επιλογή.");
     try{
      Scanner keyboard = new Scanner(System.in);
      String ans = keyboard.nextLine();
       switch( ans ) //οπως φαίνεται γινεται μια "ανακύκλωση του buyer στις μεθόδους"
      {
        case "katastima":
             eshop.showCategories();
             browseStore(buyer);
             break;
        case "kalathi":
             viewCart(buyer);
             break;
        case "pay":
             checkout(buyer);
             break;      
        case "user":  
             System.out.println("Ευχαριστούμε πολύ! Ελπίζουμε να σας ξαναδούμε σύντομα!\n\n");
             hello(); // καλείται η hello(η εναρκτήρια μέθοδος του προγράμματος) που χαιρετά και ταυτοποιεί τον χρήστη(αγοραστής ή ιδιοκτήτης)
             break;
        case "exit":  
             System.out.println("Ευχαριστούμε πολύ! Να έχετε μια υπέροχη μέρα!");
             System.exit(0); //τερματίζεται το πρόγραμμα με κλείσιμο της jvm
             break;
        default:
             System.out.println("Ανεπιτυχής καταχώρηση κωδικού. Ξαναπροσπαθήστε.");
             keyboard.reset();
             buyerMenu(buyer);//σε περιπτωση που ξαναρχίσει δεν θα χρειαστεί να δούμε τις κατηγορίες λόγω της εξτρα μεθόδου
             break;
      }
      keyboard.reset();
    }catch(InputMismatchException ime){System.out.println("Λάθος εισχώρηση. Παρακαλούμε δοκιμάστε ξανά"); buyerMenu(buyer);}
   }
    public void browseStore(Buyer buyer) throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException
   { 
     keyboard.close(); //εξάλειψη σφαλμάτων
     Scanner keyboard = new Scanner(System.in);
     Item item;
     eshop.showProductsInCategory();  
     System.out.print("Θα θέλατε να δείτε πληροφορίες για κάτι συγκεκριμένο (yes) ");
     System.out.println("ή προτιμάτε να επιστρέψετε στο αρχικό μενού (menu) ?");
     try{
      keyboard.reset(); 
      String ans = keyboard.next(); 
        if ( ans.equals( "yes" ) )
       {
              System.out.println("Πληκτρολογήστε το id του προϊόντος."); 
              item = eshop.showProduct();
              System.out.println("Θέλετε να το προσθέσετε στο καλάθι ?");
              System.out.println("Πατήστε 'y' για ναι ή 'n' για όχι");
              keyboard.reset();
              String ans2 = keyboard.next();  
              switch( ans2 )
              {
                case "y": 
                     System.out.println("Πόση ποσότητα θέλετε ?");
                     System.out.println("Διαθέσιμη ποσότητα: " + item.getStock());
                     keyboard.reset();
                     int quantity = keyboard.nextInt();
                     if ( quantity <= 0 )
                     {
                        System.out.println("Δεκτοί αριθμοί > 0. Δυστυχώς θα πρέπει να ξαναπροσπαθήσετε\n");
                        browseStore( buyer ) ;
                     }
                      if (buyer.placeOrder(item,quantity) == true ) 
                     { 
                       keyboard.reset();
                       System.out.println("H παραγγελία σας καταχωρήθηκε με επιτυχία!");
                     }
                     else 
                        System.out.println("H παραγγελία σας δυστυχώς δεν καταχωρήθηκε.");
                     
                     break;
                case "n":
                     browseStore(buyer);
                     break;
                default: 
                     System.out.print("Αυτή δεν είναι σωστή απάντηση. Κοιτάξτε");
                     System.out.println(" καλύτερα τους κωδικούς και ξαναπροσπαθήστε.");
                     keyboard.reset();
                     browseStore(buyer);
                     break;
              }
              keyboard.close();  
              System.out.println("Επιστρέφουμε στο αρχικό menu ή θα θέλατε να δείτε περισσότερα?");
              System.out.println("Πατήστε 'menu' αν θέλετε να γυρίσετε στο αρχικό μενού"); 
              System.out.println("Πατήστε όποιο άλλο γράμμα θέλετε ώστε να γυρίσετε στις διαθέσιμες κατηγορίες");              
              Scanner keyboard1 = new Scanner(System.in);
              String choice = keyboard1.nextLine();
               if ( choice.equals( "menu" ) )
              {
                 System.out.println("Πίσω στο αρχικό μενού"); 
                 keyboard.reset(); 
                 buyerMenu(buyer);  
              }
               else browseStore(buyer);
        }
         else if( ans.equals( "menu" ) )
        {
              System.out.println("Επιστρέφουμε στο μενού");
              keyboard.reset();
              buyerMenu(buyer); 
        }
         else 
        {
          System.out.println("Λανθασμένος κωδικός.\n");
          browseStore(buyer);
        }
        keyboard.reset();
     }catch(InputMismatchException ime)
     {System.out.println("Λανθασμένος κωδικός. Παρακαλούμε δοκιμάστε ξανά"); browseStore(buyer);}
    }
    public void viewCart(Buyer buyer) throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException
   {
       keyboard.close();
       Scanner keyboard = new Scanner(System.in);
      try{ 
       try{   
         buyer.shopcart.showCart(); 
          if (  buyer.shopcart.orderedList.size() == 0 ) 
         {
            EmptyCartException ece = new EmptyCartException();
            throw ece;
         }
       }
        catch(EmptyCartException ece)
       {
         keyboard.reset();
         System.out.println("Θα θέλατε να μεταφερθείτε στην λίστα με τα προϊόντα μας ?");
         System.out.println("Παρακαλώ πατήστε 'y' αλλιώς 'menu' ή κάποιο άλλο γράμμα αν θέλετε να γυρίσετε menu ");
         keyboard.reset();
         String choice = keyboard.nextLine();
         if ( choice.equals( "y" ) )
            browseStore(buyer);
         else 
            buyerMenu(buyer);
       }
       System.out.print("Θα θέλατε να διαγράψετε ένα προϊόν ('delete'), να αλλάξετε ('change') την παραγγελία σας,");
       System.out.println(" να ολοκληρώσετε ('pay') την αγορά σας ή να αδειάσετε ('clear') το καλάθι σας ?");
       System.out.println("Αν θέλετε να γυρίσετε στο αρχικό μενού πατήστε 'menu'");
       System.out.println("Παρακαλούμε εισάγετε τον αντίστοιχο κωδικό");
       
       String order = keyboard.nextLine();
        switch ( order )
        { 
            case "delete":
                String itOrdName = getItemInCart(buyer);
                buyer.shopcart.removeItemOrdered( buyer.shopcart.stringToItemOrdered(itOrdName) ); 
                break;
            case "change":  
                String itOrdName2 = getItemInCart(buyer);
                 try
                {
                  buyer.shopcart.changeItemOrderedQuantity( buyer.shopcart.stringToItemOrdered(itOrdName2),eshop );
                }
                 catch(NullPointerException npe)
                {
                  System.out.println("Προέκυψε σφάλμα");  
                }  
                break;
            case "clear":    
                buyer.shopcart.clearCart();
                break;
            case "pay":
                checkout(buyer);
                break;
            case "menu":  
                buyerMenu(buyer);
                break;
            default:
                System.out.println("Κάπου προέκυψε λάθος. Δοκιμάστε πάλι.");
                keyboard.reset();
                viewCart(buyer);
                break;
        }
       System.out.println("Επιστρέφουμε στο καλάθι σας.."); 
       keyboard.reset();
       viewCart(buyer);
     }catch(InputMismatchException ime)
     { System.out.println("Λανθασμένος κωδικός. Παρακαλούμε δοκιμάστε ξανά"); 
      keyboard.reset(); viewCart(buyer); }
   }
   public void checkout(Buyer buyer) throws BuyerExistsAlreadyException, EmptyCartException, ItemOrderedDoesntExistsException
   { 
      keyboard.close();
      Scanner keyboard = new Scanner(System.in);
      try
      {   
        if ( buyer.shopcart.orderedList.size() == 0 ) //εξετάζεται το μέγεθος του καλαθιού
        {
            EmptyCartException ece = new EmptyCartException();
            throw ece;
        }
      }
       catch(EmptyCartException ece)
      {
          ece.displayMessage(); //καταλληλο μήνυμα για αγοραστή
          System.out.println("Δεν μπορούμε να ολοκληρώσουμε αυτήν την πληρωμή. ");
          System.out.println("Μεταφέρεστε στο μενού του καταστήματός μας. ");
          System.out.println("Αν θέλετε να γεμίσετε το καλάθι σας προτιμήστε την επιλογή 'katastima'\n");
          buyerMenu(buyer);
      }
      buyer.shopcart.checkout(buyer);
      System.out.println("Eπιστρέφουμε στο μενού");
      keyboard.reset();
      buyerMenu(buyer);
   } 
   public String getItemInCart(Buyer buyer) throws ItemOrderedDoesntExistsException
   {  
    keyboard.close();
    Scanner keyboard = new Scanner(System.in);
    String itemordered = ""; //το αντικείμενο που επιστρέφεται   
    System.out.println("Επιλέξτε προϊόν -> με βάση το όνομα:");
    String itOrdName = keyboard.nextLine(); //ζητείται το όνομα του αντικειμένου ItemOrdered
    
    try{
      for ( int i = 0 ; i < buyer.shopcart.orderedList.size() ; i++ )
     { 
        if ( itOrdName.equals( buyer.shopcart.orderedList.get(i).getItem().getNameItem() ) )
       { // συγκρίνεται το όνομα του ItemOrdered με όνομα του Item
           itemordered = itOrdName;// αν βρεθεί η τιμή του δινεται στο επιστρεφόμενο 
       }                            //από την μέθοδο String 
     }
      if ( itemordered.equals("") )//εάν είναι ίσο με "" σημαίνει πως δεν βρέθηκε 
     {
        ItemOrderedDoesntExistsException iodee = new ItemOrderedDoesntExistsException() ; 
        throw  iodee; //εγείρεται εξαίρεση και επανεκινείται η μέθοδος
     }
    
    }catch(ItemOrderedDoesntExistsException iodee){iodee.displayMessage(); getItemInCart(buyer);}
    return itemordered;
   }
 }







