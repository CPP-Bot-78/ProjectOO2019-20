public class ItemOrdered
{
    private Item item;
    private int quantity;
    public ItemOrdered(Item item,int quantity)
    { 
      this.item=item; 
      this.quantity = quantity;
    }
    public void setQuantity(int quantity)
    {this.quantity=quantity;}
          //getters
    public int getQuantity(){return quantity;}
    public Item getItem(){return item;}
}
