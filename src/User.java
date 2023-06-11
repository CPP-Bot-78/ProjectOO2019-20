abstract public class User
{ private String name;
  private String email;
  private boolean isAdmin;
  public User(String name,String email)
  {
    this.name=name;
    this.email=email;
  }
            //getters
  public String getName(){return name;}
  public String getEmail(){return email;}
  public boolean getAdmin(){return isAdmin;}
}