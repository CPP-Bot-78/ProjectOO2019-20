public class Pen extends Item
{
    protected String color;  //δεν χρειάζονται να είναι private, είναι στοιχεία οπτικά και δεν
    protected double tipSize;//παίζουν σημαντικό ρόλο στην εξέλιξη του προγραμμάτος
    public Pen(String nameItem,double price,String description,int stock,int id,String color,double tipSize)
    {
      super(nameItem,price,description,stock, id);
      this.color=color;
      this.tipSize=tipSize;
      status="pen";
    } 
    public String getDetails(){
     return " Το στιλό έχει χρώμα "+color+" και η μύτη του έχει μέγεθος "+tipSize+" .";}
}
