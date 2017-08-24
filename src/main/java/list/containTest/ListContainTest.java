package list.containTest;

import java.util.ArrayList;
import java.util.List;

public class ListContainTest {
   public static void main(String[] args){
//	   641 [http-bio-8087-exec-5] INFO  c.i.financial.dao.UserProfileDAO - ---> currentEmail:          rohit.dube@infoimageinc.com
//	   19:02:06.641 [http-bio-8087-exec-5] INFO  c.i.financial.dao.UserProfileDAO - ---> currentEmail: zhe.shi@infoimageinc.com
//	   19:02:06.641 [http-bio-8087-exec-5] INFO  c.i.financial.dao.UserProfileDAO - ---> currentEmail: alok.verma@infoimageinc.com
//	   19:02:06.641 [http-bio-8087-exec-5] INFO  c.i.financial.dao.UserProfileDAO - ---> currentEmail: Zhe.Shi@infoimageinc.com
//	   19:02:06.641 [http-bio-8087-exec-5] INFO  c.i.financial.dao.UserProfileDAO - ---> currentEmail: Zhe.Shi@infoimageinc.com
//	   19:02:06.641 [http-bio-8087-exec-5] INFO  c.i.financial.dao.UserProfileDAO - ---> currentEmail: Zhe.Shi@infoimageinc.com
//	   19:02:06.641 [http-bio-8087-exec-5] INFO  c.i.financial.dao.UserProfileDAO - ---> newEmailValue rohit.dube@infoimageinc.com
//	   19:02:06.641 [http-bio-8087-exec-5] INFO  c.i.financial.dao.UserProfileDAO - ---> newEmailValue Zhe.Shi@infoimageinc.com
	   
	   List<String> currentEmailValues = new ArrayList();
	   List<String> newEmailValues = new ArrayList();
	   
	   
	   currentEmailValues.add("rohit.dube@infoimageinc.com");
	   currentEmailValues.add("alok.verma@infoimageinc.com");
	   currentEmailValues.add("Zhe.Shi@infoimageinc.com");
	   currentEmailValues.add("zhe.shi@infoimageinc.com");
	   
	   newEmailValues.add("rohit.dube@infoimageinc.com");
	   
	   System.out.println(currentEmailValues.contains("zhe.shi@infoimageinc.com"));

	   
	   
	   
	   
	   
   }
}
