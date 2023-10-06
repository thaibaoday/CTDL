package Lab1;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static void main(String[] args) {
		System.out.println("Task 2");
		int n = 3;
		char c1 = 'B';

		System.out.println(encrypt(c1, n));

		String text2 = "Hello, Everyone!";
		System.out.println(encryptText(text2, n));

		char c3 = 'O';
		System.out.println(decrypt(c3, n));

		String text4 = "Fkloo!";
		System.out.println(decryptText(text4, n));
	}

//	Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array.
	public static char encrypt(char c, int n) {
		if (c >= 'A' && c <= 'Z') {
			return (char) ((c - 'A' + n) % 26 + 'A');
		} else if (c >= 'a' && c <= 'z') {
			return (char) ((c - 'a' + n) % 26 + 'a');
		} else {
			return c;
		}
	}
// Encrypt a text using the above function for encrypting a charater.

	public static String encryptText(String text, int n) {
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = encrypt(chars[i], n);
		}
		return new String(chars);
	}

//Decrypt a character according to the given shif steps.
// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET array.
	public static char decrypt(char c, int n) {
		if (c >= 'A' && c <= 'Z') {
			return (char) ((c - 'A' - n + 26) % 26 + 'A');
		} else if (c >= 'a' && c <= 'z') {
			return (char) ((c - 'a' - n + 26) % 26 + 'a');
		} else {
			return c;
		}
	}
//Decrypt a encrypted text using the above function for decrypting a charater.

	public static String decryptText(String text, int n) {
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = decrypt(chars[i], n);
		}
		return new String(chars);

	}
}
