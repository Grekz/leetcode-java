package org.grekz.leetcode.medium;
import java.util.Arrays;

/*
 * 
 Problem Statement
     
 Let's say you have a binary string such as the following:
 011100011
 One way to encrypt this string is to add to each digit the sum of its adjacent digits. For example, the above string would become:
 123210122
 In particular, if P is the original string, and Q is the encrypted string, then Q[i] = P[i-1] + P[i] + P[i+1] for all digit positions i. Characters off the left and right edges of the string are treated as zeroes.
 An encrypted string given to you in this format can be decoded as follows (using 123210122 as an example):
 Assume P[0] = 0.
 Because Q[0] = P[0] + P[1] = 0 + P[1] = 1, we know that P[1] = 1.
 Because Q[1] = P[0] + P[1] + P[2] = 0 + 1 + P[2] = 2, we know that P[2] = 1.
 Because Q[2] = P[1] + P[2] + P[3] = 1 + 1 + P[3] = 3, we know that P[3] = 1.
 Repeating these steps gives us P[4] = 0, P[5] = 0, P[6] = 0, P[7] = 1, and P[8] = 1.
 We check our work by noting that Q[8] = P[7] + P[8] = 1 + 1 = 2. Since this equation works out, we are finished, and we have recovered one possible original string.
 Now we repeat the process, assuming the opposite about P[0]:
 Assume P[0] = 1.
 Because Q[0] = P[0] + P[1] = 1 + P[1] = 0, we know that P[1] = 0.
 Because Q[1] = P[0] + P[1] + P[2] = 1 + 0 + P[2] = 2, we know that P[2] = 1.
 Now note that Q[2] = P[1] + P[2] + P[3] = 0 + 1 + P[3] = 3, which leads us to the conclusion that P[3] = 2. However, this violates the fact that each character in the original string must be '0' or '1'. Therefore, there exists no such original string P where the first digit is '1'.
 Note that this algorithm produces at most two decodings for any given encrypted string. There can never be more than one possible way to decode a string once the first binary digit is set.
 Given a String message, containing the encrypted string, return a String[] with exactly two elements. The first element should contain the decrypted string assuming the first character is '0'; the second element should assume the first character is '1'. If one of the tests fails, return the string "NONE" in its place. For the above example, you should return {"011100011", "NONE"}.
 Definition
     
 Class:
 BinaryCode
 Method:
 decode
 Parameters:
 String
 Returns:
 String[]
 Method signature:
 String[] decode(String message)
 (be sure your method is public)
     

 Constraints
 -
 message will contain between 1 and 50 characters, inclusive.
 -
 Each character in message will be either '0', '1', '2', or '3'.
 Examples
 0)

     
 "123210122"
 Returns: { "011100011",  "NONE" }
 The example from above.
 1)

     
 "11"
 Returns: { "01",  "10" }
 We know that one of the digits must be '1', and the other must be '0'. We return both cases.
 2)

     
 "22111"
 Returns: { "NONE",  "11001" }
 Since the first digit of the encrypted string is '2', the first two digits of the original string must be '1'. Our test fails when we try to assume that P[0] = 0.
 3)

     
 "123210120"
 Returns: { "NONE",  "NONE" }
 This is the same as the first example, but the rightmost digit has been changed to something inconsistent with the rest of the original string. No solutions are possible.
 4)

     
 "3"
 Returns: { "NONE",  "NONE" }

 5)

     
 "12221112222221112221111111112221111"
 Returns: 
 { "01101001101101001101001001001101001",
 "10110010110110010110010010010110010" }

 This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */

public class BinaryCode {
	public static void main(String[] args) {
		int a[] = new int[2];
		String[] tests = new String[] { "123210120", "11", "123210122",
				"12221112222221112221111111112221111", "22111", "3" };
		BinaryCode c = new BinaryCode();
		for (String test : tests) {
			String[] result = c.decode(test);
			System.out.println(test + ":    " + result[0] + " - " + result[1]);
		}
	}

	public String[] decode(String arg) {
		if (arg.length() == 1) {
			if (!isBinary(Integer.parseInt(arg)))
				arg = "NONE";
			return new String[] { arg, arg };
		}
		String a = arg.startsWith("2") ? "NONE" : decodeBy(0, arg);
		String b = decodeBy(1, arg);
		return new String[] { a, b };
	}

	private String decodeBy(int ind, String arg) {
		int[] res = new int[arg.length()];
		int r = Integer.parseInt(arg.charAt(0) + "");
		if (r == 2) {
			res[0] = 1;
			res[1] = 1;
		} else if (r == 1) {
			res[ind ^ 1] = 1;
			res[ind ^ 0] = 0;
		} else {
			res[0] = 0;
			res[1] = 0;
		}
		for (int i = 1; i < arg.length(); i++) {
			r = Integer.parseInt(arg.charAt(i) + "");
			boolean curr = res[i] == 0;
			boolean prev = res[i - 1] == 0;
			switch (r) {
			case 0:
				if (!curr || !prev)
					return "NONE";
				break;
			case 1:
				if (curr && prev)
					res[i + 1] = 1;
					
				break;
			case 2:
				if (prev && curr) {
					return "NONE";
				} else if (curr || prev)
					res[i + 1] = 1;
				break;
			default:
				if (curr || prev)
					return "NONE";
				else
					res[i + 1] = 1;
				break;
			}

		}
		String str = Arrays.toString(res).replace(", ", "");
		return str.substring(1, str.length() - 1);
	}

	private boolean isBinary(int num) {
		return num == 1 || num == 0;
	}

}
