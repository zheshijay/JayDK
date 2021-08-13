package algo.roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseOverLap {
	class OverLap{
		String[] pair;
		List<String> courses;

		OverLap(String[] pair, List<String> courses){
			this.courses = courses;
			this.pair = pair;
		}
		
		@Override
		public String toString(){
			return Arrays.toString(pair) + Arrays.toString(courses.toArray());
		}
	}

	List<OverLap> getOverlaps(List<String[]> studentCourses){
		List<OverLap> res = new ArrayList<>();
		
		// convert to map
		Map<String, Set<String>> scMap = new HashMap<>();
		for(String[] sc: studentCourses) {
			Set<String> curStuCourses = scMap.get(sc[0]) == null? new HashSet<>():scMap.get(sc[0]);
			curStuCourses.add(sc[1]);
			scMap.put(sc[0], curStuCourses);
		}
		
		List<String> userIds = scMap.keySet().stream().collect(Collectors.toList());
		for (int i=0; i< userIds.size(); i++) {
			for (int j=i+1; j< userIds.size(); j++) {
				Set<String> scI = scMap.get(userIds.get(i));
				Set<String> scJ = scMap.get(userIds.get(j));
				
				List<String> courses = scI.stream().filter(v->scJ.contains(v)).collect(Collectors.toList());
				res.add(new OverLap(new String[] {userIds.get(i), userIds.get(j)}, courses));
				
			}
		}

		return res;
	}
	




	public static void main(String[] args) {
		CourseOverLap test = new CourseOverLap();
		
		List<String[]> studentCourses = new ArrayList<>();
		studentCourses.add(new String[] {"58", "Software Design"});
		studentCourses.add(new String[] {"58", "Linear Algebra"});
		studentCourses.add(new String[] {"94", "Art History"});
		studentCourses.add(new String[] {"94", "Operating Systems"});
		studentCourses.add(new String[] {"17", "Software Design"});
		studentCourses.add(new String[] {"58", "Mechanics"});
		studentCourses.add(new String[] {"58", "Economics"});
		studentCourses.add(new String[] {"17", "Linear Algebra"});
		studentCourses.add(new String[] {"17", "Political Science"});
		studentCourses.add(new String[] {"94", "Economics"});
		studentCourses.add(new String[] {"25", "Economics"});
		

	
		System.out.println("res:" + test.getOverlaps(studentCourses));

	}
}
