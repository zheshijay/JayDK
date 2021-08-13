package algo.roblox;

import java.util.ArrayList;
import java.util.List;

public class Reflow {
	static int maxWidth = 24;
	public List<String> reflow(String[] input, int width) {

		List<String> result = new ArrayList<String>();

		if (input == null || input.length == 0) {
			return result;
		}

		int count = 0;
		int last = 0;
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < input.length; i++) {

			count = count + input[i].length();

			if (count + i - last > width) {

				int wl = count - input[i].length();

				int sl = maxWidth - wl;

				int each = 1;

				int el = 0;

				if (i - last - 1 > 0) {

					each = sl / (i - last - 1);

					el = sl % (i - last - 1);

				}

				StringBuilder sb = new StringBuilder();

				for (int k = last; k < i - 1; k++) {

					sb.append(input[k]);

					int ce = 0;

					while (ce < each) {

						sb.append(" ");

						ce++;

					}

					if (el > 0) {

						sb.append(" ");

						el--;

					}

				}

				sb.append(input[i - 1]);// last input in the line

				// if only one word in this line, need to fill left with space

				while (sb.length() < width) {

					sb.append(" ");

				}

				result.add(sb.toString());

				last = i;

				count = input[i].length();

			}

		}

		int lastLen = 0;

		StringBuilder sb = new StringBuilder();

		for (int i = last; i < input.length - 1; i++) {

			count = count + input[i].length();

			sb.append(input[i] + " ");

		}

		sb.append(input[input.length - 1]);

		int d = 0;

		while (sb.length() < maxWidth) {

			sb.append(" ");

		}

		result.add(sb.toString());

		return result;

	}
	
	public static void main(String[] args) {
		String[] input = new String[] { "The day began as still as the",
		          "night abruptly lighted with",
		          "brilliant flame" };
		
		Reflow test = new Reflow();
		List<String> res =  test.reflow(input, 24);
		System.out.println("res:" + res);
		
		
	}
}
