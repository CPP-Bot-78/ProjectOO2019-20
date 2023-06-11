import java.util.*;
public class EShop 
{    
    Scanner keyboard = new Scanner(System.in);
    
    private String name;
    private Owner owner;
    protected List<Item> itemsList = new ArrayList<>();
    protected List<Buyer> buyersList = new ArrayList<>();
     public EShop(String name)
    {
     this.name=name;
    }
     public void addItem(Item item) throws ItemExistsAlreadyException
    {     
      try{ 
        itemsList.add(item); 
        for(int i=0; i < itemsList.size()-1; i++)
        {// ελέγχει με βάση το id ή το όνομα
         if(item.getId() == itemsList.get(i).getId() || item.getNameItem().equals( itemsList.get(i).getNameItem() ) )
         { 
           ItemExistsAlreadyException ieae = new ItemExistsAlreadyException(); 
           throw ieae;
         }
        }
      } catch(ItemExistsAlreadyException ieae) {ieae.displayMessage(); itemsList.remove(itemsList.size()-1);}  
    }     
     public Item getItemById(int id)
    {  
        Item item1 = null;
       try{ 
       for(int i=0; i < itemsList.size(); i++)
       { 
        if(id == itemsList.get(i).getId())
        {
           item1= itemsList.get(i);
        }
       }
      }catch(NullPointerException npe){System.out.println("Λάθος id");}
       return item1;
    }
     public void removeItem(Item item)
    {
     for(int i=0; i < itemsList.size(); i++)
     {
      if(item.getId() == itemsList.get(i).getId())
      { 
        itemsList.remove(item);  
      }   
     }
    }
     public void addBuyer(Buyer buyer) throws BuyerExistsAlreadyException
    {  
       try{
         buyersList.add(buyer);                                       
         for(int j=0; j < buyersList.size() -1; j++)
         { //-1 για να μην μπερδευτει με τον ευατο του(το ιδιο το αντικειμενο) που ειναι στο τέλος της λίστας
          if( buyer.getName().equals( buyersList.get(j).getName() ) || buyer.getEmail().equals( buyersList.get(j).getEmail() ) ) 
          { 
            BuyerExistsAlreadyException beae = new BuyerExistsAlreadyException(); 
            throw beae;
          }
         }
       } catch(BuyerExistsAlreadyException beae) {beae.displayMessage(); buyersList.remove(buyersList.size()-1); }
        /**αν το αφήναμε το -1 στο for το remove() δεν άφηνε κανένα αντικείμενο στην λιστα
         *στο remove του catch χρησιμοποιυμε -1 γιατι το add προσθετει το αντικειμενο στο τελος */
    }
     public void removeBuyer(Buyer buyer)
    {
     for(int j=0; j < buyersList.size(); j++)
     {
      if( buyer == buyersList.get(j))
      { 
        buyersList.remove(buyer);  
      }   
     }
    }
     public void updateItemStock(Item item, int stock)
    { 
      item.setStock( stock );
      System.out.println( "Το καινούργιο stock είναι: " + item.getStock() );
    }
     public void showCategories()
    {
       System.out.println("Οι κατηγοριές έιναι οι εξής:");
       System.out.println("1.Pen-Στιλό ("+ productNum("pen") +")");
       System.out.println("2.Pencil-Μολύβι ("+ productNum("pencil") +")");
       System.out.println("3.Notebook-Τετράδιο ("+ productNum("notebook") +")");
       System.out.println("4.Paper-Χαρτί ("+ productNum("paper") +")");
    }
     public void showProductsInCategory()
    {   
      keyboard.reset();
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Ποια κατηγορία θα θέλατε να δείτε :");
      System.out.println("Πληκτρολογήστε: ");
      System.out.println("-> 'pen' αν θέλετε να δείτε τα στιλό μας,");
      System.out.println("-> 'pencil' αν θέλετε να δείτε τα μολύβια μας,");
      System.out.println("-> 'notebook' αν θέλετε να δείτε τα τετράδια μας,");
      System.out.println("-> 'paper' αν θέλετε να δείτε τα είδη χαρτιού μας.");
      try{
       keyboard.reset();
       String categ = keyboard.next();
       switch( categ )
       {
         case "pen": 
              chooseProduct("pen");
              break;
         case "pencil": 
              chooseProduct("pencil");
              break;
         case "notebook": 
              chooseProduct("notebook");
              break;
         case "paper": 
              chooseProduct("paper");
              break;
         default:  
              System.out.println("Λάθος κωδικός. Ξαναδοκιμάστε");
              keyboard.reset();
              showProductsInCategory();
              break;
       }
       keyboard.reset();
     }catch(InputMismatchException ime)
     { System.out.println("Λάθος εισχώρηση. Παρακαλούμε δοκιμάστε ξανά"); showProductsInCategory(); }     
    }
     public Item showProduct()
    {
      keyboard.reset(); 
      Scanner keyboard = new Scanner(System.in);
      int product = 0;
      String details = "";
       try{   
        keyboard.reset(); 
        product = keyboard.nextInt();
        try
       {
         details = getItemById(product).toString(); 
       }
        catch(NullPointerException npe)
       {
         System.out.println("Λάθος κωδικός id. Ξαναδοκιμάστε.");
         showProduct();
       }
       System.out.println(details);
       keyboard.reset(); 
       return  getItemById(product);      
      }
       catch(InputMismatchException ime)
      { 
        System.out.println("Λάθος εισχώρηση. Παρακαλούμε δοκιμάστε ξανά");
        System.out.println("Πληκτρολογήστε το id του προϊόντος.");  
        keyboard.reset();
        showProduct(); 
      }
      return  getItemById(product);
    }
     public void checkStatus()
    {
       for(int i=0; i < buyersList.size(); i++)
       { System.out.println("=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=");
         System.out.println( buyersList.get(i).buyerInfo() );
         System.out.println("=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=");
         System.out.println(); 
       } 
    }
    public String getName(){ return name; }
    public Owner getOwner(){ return owner; }
                //extra μεθοδοι για επαναχρησιμοποιηση κωδικα

    public void chooseProduct(String product)
    { 
        int k = 1;
     for(int i = 0; i < itemsList.size(); i++)
      { 
       if(product == itemsList.get(i).getStatus())
       { 
        System.out.println( k + ")" + itemsList.get(i).getNameItem() +"  ID: "+ itemsList.get(i).getId()  ); 
        k++;
       }
      }
      
    }
    public int productNum(String product)
    {
     int productNum = 0;  
       for(int j = 0; j < itemsList.size(); j++)
      {
         if(product == itemsList.get(j).getStatus())
        { 
          productNum++;  
        }  
      }
     return productNum;
    }
}