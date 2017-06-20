package stringTest;

public class StrEqualTest {
	public static void main(String [] args){
		String mapper_class = "\nselect sum((ISNULL(msg1, 0) + ISNULL(msg2, 0) + ISNULL(msg3, 0) +\nISNULL(msg4, 0) + ISNULL(msg5, 0) + ISNULL(selmsg1, 0) +\nISNULL(selmsg2, 0) + ISNULL(selmsg3, 0) + ISNULL(selmsg4, 0) +\nISNULL(selmsg5, 0))) from tblRTWO_Cycle d where d.jobid in (select c.jobid from tblRTWO r, tblRTWO_Cycle cwhere r.cid = 'WFCU' and r.appid = {appid} and r.jobno = c.jobno and c.drop_date>= 2010-10-14 and c.drop_date<= 2014-10-14);";
		System.out.println(mapper_class.replaceAll("\n", ""));
		
	}
}
