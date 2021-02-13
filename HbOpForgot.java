import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import javax.swing.*;
class HbOpForgot{
private int id1;
private String pass;
HbOpForgot(int id1,String pass)
{
this.id1 = id1;
this.pass = pass;


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


Admin stu = (Admin)s.get(Admin.class,id1);
if(stu == null)
{
	JOptionPane.showMessageDialog(new JDialog(),"id "+id1+" does not exist");
}else{
	
	String name = stu.getName();
	stu.setName(name);
	stu.setPassword(pass);
	s.save(stu);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(),"Password Updated");
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

}