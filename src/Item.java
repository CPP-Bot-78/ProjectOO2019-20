abstract public class Item
{  private String nameItem; 
   private double price;
   private String description;
   private int stock;
   private int id;
   protected String status;/**συμβολίζει το είδος του αντικειμενού(εμφανές στις υποκλάσεις οπότε protected) και βοηθά στην κλάση Eshop,μέθοδο showProductsInCategory() 
                         *ώστε να ξεχωρίζουν μεταξύ τους οι διάφορες κατηγορίες **/
   public Item(String nameItem,double price,String description,int stock,int id)
   {
      this.nameItem=nameItem;
      this.price=price;
      this.description=description;
      this.stock=stock;
      this.id=id;
   }
   abstract public String getDetails();
   public String getBasicInfo()
   {
     return "To " +nameItem+ " με κωδικό " +id+ " βρίσκεται στην τιμή των " +price+ " € σε stock " +stock+ " τεμαχίων. Ακολουθεί περιγραφή:\n" + "'" + description +"' .";
   }
   public String toString()
   {return getBasicInfo()+ getDetails();}
          //setters
   public void setDescription(String description)
   {this.description=description;}
   public void setPrice(double price)
   {this.price=price;}
   public void setStock(int stock)
   {this.stock=stock;}
      
        //getters
   public String getNameItem(){return nameItem;}
   public String getDescription(){return description;}
   public double getPrice(){return price;}
   public int getStock(){return stock;}
   public int getId(){return id;} 
   public String getStatus(){return status;}
}


