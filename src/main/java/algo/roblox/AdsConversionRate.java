package algo.roblox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdsConversionRate {
	String getAdsConversionRate(String[] all_user_ips, String[] completed_purchase_user_ids, String[] ad_clicks) {
		
		/*
		 * 
		 * 
		 * [purchase count of ad] of [click count of ad] ad
		 */
		Set<String> cpUserIds = new HashSet<>();
		for(String userId: completed_purchase_user_ids) {
			cpUserIds.add(userId);
		}
		System.out.println("cpUserIds:" + cpUserIds);
		
		Map<String, String> ipUserMap = new HashMap<>();
		for(String userIp: all_user_ips) {
			String[] userIpArray = userIp.split(",");
			ipUserMap.put(userIpArray[1], userIpArray[0]);
		}
		
		System.out.println("ipUserMap:" + ipUserMap);

		
		Map<String, int[]> adInfoMap = new HashMap<>();
		Map<String, Integer> apMap = new HashMap<>();
		Map<String, Integer> acMap = new HashMap<>();
		for(String adClick: ad_clicks) {
			String ip = adClick.split(",")[0];
			String adContent = adClick.split(",")[2];
			String userId = ipUserMap.get(ip);
			if (cpUserIds.contains(userId)) {
				apMap.put(adContent, apMap.getOrDefault(adContent, 0) + 1); 
			} else {
				apMap.put(adContent, 0); 
			}
			acMap.put(adContent, acMap.getOrDefault(adContent, 0) + 1); 
			System.out.println("ip:" + ip + "|ad:" + adContent);
			adInfoMap.put(adContent, new int[] {apMap.get(adContent), acMap.get(adContent)});
		
		}
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, int[]> entry: adInfoMap.entrySet()) {
			sb.append(entry.getValue()[0]).append(" of ").append(entry.getValue()[1]).append(" " + entry.getKey()).append("\n");
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		String[] all_user_ips = new String[] { "2339985511,122.121.0.155", "234111110,122.121.0.1",
				"3123122444,92.130.6.145", "39471289472,92.130.6.234", "8321125440,82.1.106.8",
				"99911063,92.130.6.144" };
		String[] completed_purchase_user_ids = new String[] { "3123122444", "234111110", "8321125440", "99911063" };

		String[] ad_clicks = new String[] { 
				"122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
				"96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
				"122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
				"82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
				"92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
				"92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens" };
		
		AdsConversionRate test = new AdsConversionRate();
		String res =test.getAdsConversionRate(all_user_ips, completed_purchase_user_ids, ad_clicks);
		System.out.println("res:" + res);
		
		
	}

}
