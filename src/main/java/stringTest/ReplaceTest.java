package stringTest;

public class ReplaceTest {

	public static void main(String [] args){
		String getTemplateUrl = "/v1/notiftmplmgmt/{cid}/template";
		getTemplateUrl = getTemplateUrl.replaceAll("\\{cid\\}", "abak");
//		String output = zip.replaceAll("\\s+",""); 
		System.out.println(getTemplateUrl);
	}
}
