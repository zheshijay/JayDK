package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0811cpDomains {
	
	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> cdMap = new HashMap<>();
		
		for(String visit: cpdomains) {
			String[] visitStr = visit.split(" ");
			System.out.println("visitStr:" + Arrays.toString(visitStr));
			
			int count = Integer.parseInt(visitStr[0]);
			String domain = visitStr[1];

			int countOfSubDomains = domain.split("\\.").length;
			int domainCount = 1;
			int index = 0;
			
			String subDomain = "";
			
			while (domainCount <= countOfSubDomains) {
				subDomain = domain.substring(index, domain.length());
				
				System.out.println("subDomain:" + subDomain);
				System.out.println("domainCount:" + domainCount);
				
				cdMap.put(subDomain, cdMap.getOrDefault(subDomain, 0) + count);
				index = domain.indexOf('.', index) + 1;
				domainCount++;
			}
		}
		
		List<String> res = new ArrayList<>();
		
		for (Map.Entry<String, Integer> entry: cdMap.entrySet()) {
			res.add(entry.getValue() + " " + entry.getKey());
		}
		
		return res;
	}

	public static void main(String[] args) {
		LC0811cpDomains test = new LC0811cpDomains();
//		String[] visits = new String[] {"9001 discuss.leetcode.com"};
		String[] visits = new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		
		List<String> res=  test.subdomainVisits(visits);
		System.out.println(res);
		
//		String domain = "discuss.leetcode.com";
//		String[] domains = domain.split("\\.");
//		System.out.println("domains:" + Arrays.toString(domains));
		
	}
	
}


