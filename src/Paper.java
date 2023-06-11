public class Paper extends Item
{
   protected int weight;
   protected int pages;
   public Paper(String nameItem,double price,String description,int stock,int id,int weight,int pages)
   {
      super(nameItem,price,description,stock, id);
      this.weight=weight;
      this.pages=pages;
      status="paper";
   }
   public String getDetails(){return " To πακέτο περιέχει "+pages+" σελίδες και ζυγίζει "+weight+" γραμμάρια.";}  
}
