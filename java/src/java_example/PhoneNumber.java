package java_example;

public class PhoneNumber {
	/**
	 * Method to View the normal phone number into proper formated manner
	 * 
	 * @param number
	 *            Take mobile number as string Value
	 * @return Render the provided mobile number into proper format
	 */
	static String phone(String number) {
		String result = "";
		int len = number.length();
		for (int i = 0; i < len; i++) {
			char ch = number.charAt(i);
			if (Character.isDigit(ch)) {
				if (i == 0)
					result = "(" + number.charAt(i);
				else if (i == 2)
					result = result + ") " + number.charAt(i);
				else if (i == 6)
					result = result + "-" + number.charAt(i);
				else if (i >= 10)
					break;
				else
					result = result + number.charAt(i);
			}
		}
		return result;
	}

	static String onlyNumber(String onlyNo) {
		String result = "";
		for (int i = 0; i < onlyNo.length(); i++) {
			char ch = onlyNo.charAt(i);
			if ((ch == '-' && i == 0) || Character.isDigit(ch))
				result += ch;
		}

		return result;

	}

	static String zerocent(String cent) {
		String result = "";
		String rev = "";
		for (int i = cent.length() - 1; i >= 0; i--) {
			rev += cent.charAt(i);
		}
		for (int i = 0; i < rev.length(); i++) {
			char ch = rev.charAt(i);
			if (i == 0 || i % 3 != 0)
				result = ch + result;
			else
				result = ch + "." + result;
		}

		return result + ",00";
	}

	static String zero(String cent) {
		String result = "";
		int flag = 0;
		String number=onlyNumber(cent);
		if(number.length()==0)
			number="0";
		for (int i = number.length() - 1; i >= 0; i--) {
			char ch = number.charAt(i);
			if (flag != 3)
				result = ch + result;
			else {
				result = ch + "." + result;
				flag = 0;
			}
			flag++;
		}
		return result + ",00";
	}

	public static void main(String[] args) {
		System.out.println(phone("0"));
		System.out.println(phone("abcd123456"));
		System.out.println(phone("01234567890123"));
		System.out.println(onlyNumber("-1f232u8a6fg8rr"));
		System.out.println(zero("dgx"));

	}

}
