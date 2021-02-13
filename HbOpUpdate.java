import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import javax.swing.*;
class HbOpUpdate{
private int rno,sub1,sub2,sub3;
private String name;
HbOpUpdate(int rno,String name,int sub1,int sub2,int sub3)
{
this.rno = rno;
this.name = name;
this.sub1 = sub1;
this.sub2 = sub2;
this.sub3 = sub3;

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
	
	stu.setName(name);
	stu.setSub1(sub1);
	stu.setSub2(sub2);
	stu.setSub3(sub3);
	s.save(stu);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(),"Record Updated");
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