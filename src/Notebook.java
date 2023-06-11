public class Notebook extends Item
{
   protected int sections;

   public Notebook(String nameItem,double price,String description,int stock,int id,int sections)
   {
     super(nameItem,price,description,stock, id);
     this.sections=sections;
     status = "notebook";
   }  
   public String getDetails(){return " To συγκεκριμένο τετράδιο είναι "+sections+" θεμάτων.";}
}
