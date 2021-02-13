import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import javax.swing.*;
class HbOpDelete{
private int rno;

HbOpDelete(int rno)
{
this.rno = rno;


Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;

try{
s = sf.openSession();
System.out.println("Connected");

t = s.beginTransaction();
Console c = System.console();


Student stu = (Student)s.get(Student.class,rno);
if(stu == null)
{
	JOptionPane.showMessageDialog(new JDialog(),"Rno "+rno+" does not exist");
}else{
	
	s.delete(stu);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(),"Record Deleted");
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