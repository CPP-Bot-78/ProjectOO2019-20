import java.util.*;
public class Pencil extends Item
{
    protected double tipSize;
    protected String type; //HB,H,B
    Scanner keyb = new Scanner(System.in);
    public Pencil(String nameItem,double price,String description,int stock,int id,double tipSize,String type)
    {    
      super(nameItem,price,description,stock, id);
      this.tipSize=tipSize;
      try{
        this.type=type;
        if( this.type.equals("H") == false && this.type.equals("HB") == false && this.type.equals("B") == false)
       {
          UknownTypeException ute = new UknownTypeException(); 
          throw ute;
       }
      }
       catch( UknownTypeException ute)
      {
         String new_type;
         do
         {
            ute.displayMessage();
            System.out.println("Oι διαθέσιμοι τύποι είναι: 'H', 'B', 'HB'.");
            System.out.println("Παρακαλούμε επιλέξτε κάποιον απο αυτούς");
            new_type = keyb.nextLine();
          if (  this.type.equals("H") == true || this.type.equals("HB") == true || this.type.equals("B") == true)
              this.type = new_type;
         }
          while (new_type.equals("H") == false && new_type.equals("HB") == false && new_type.equals("B") == false);
      }
      status="pencil";
    }
    public String getDetails(){return " Το συγκεκριμένο μολύβι έχει μύτη μεγέθους "+tipSize+" και είναι τύπου "+type+" .";}
}
