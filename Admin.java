class Admin{
private int id1;
private String name;
private String password;

public Admin()
{}

public Admin(int id1,String name,String password)
{
this.id1 = id1;
this.name = name;
this.password = password;

}

public void setId1(int id1)
{

this.id1 = id1;
}
public int getId1(){
return id1;
}
public void setName(String name)
{

this.name = name;
}
public String getName(){
return name;
}
public void setPassword(String password)
{

this.password = password;
}
public String getPassword(){
return password;
}


}