import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

class HbOpLogin{

private int id;
private String pass;

HbOpLogin(int id)
{
pass="";
System.out.println(pass);
this.id = id;

Configuration cfg = new Configuration();
cfg.configure("hibernate1.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;

try{
s = sf.openSession();
System.out.println("Connected");

t = s.beginTransaction();
Console c = System.console();

Admin adm = (Admin)s.get(Admin.class,id);
if(adm == null)
{
JOptionPane.showMessageDialog(new JDialog(),"Wrong Admin Id");
}else{	
	pass = adm.getPassword();


t.commit();
}

}catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"Sql Exception");
t.rollback();
}
finally{
s.close();
System.out.println("Closed");
}

}

public String get()
{
	
	return pass;
}

}