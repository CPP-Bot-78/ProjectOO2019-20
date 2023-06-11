public class Owner extends User
{
    private boolean isAdmin;
    public Owner(String name,String email)
    {
      super(name,email);
      isAdmin = true;
    }
}
