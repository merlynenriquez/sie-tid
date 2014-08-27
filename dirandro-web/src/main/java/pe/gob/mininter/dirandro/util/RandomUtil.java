package pe.gob.mininter.dirandro.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public abstract class RandomUtil {

	private static String[] secureRndNames = new String[] { System.getProperty("boticelli.securerandom"), "SHA1PRNG", "IBMSecureRandom" };

	private RandomUtil() { }

	/**
	 * Creates a new secure random number generator. The following secure random
	 * algorithm names are tried:
	 */
	private static SecureRandom createSecureRandom() {
		SecureRandom secureRnd = null;
		try {

			for (int i = 0; i < secureRndNames.length; i++) {
				try {
					if (secureRndNames[i] != null) {
						secureRnd = SecureRandom.getInstance(secureRndNames[i]);
						break;
					}
				} catch (NoSuchAlgorithmException nsae) {

				}
			}
			if (secureRnd == null) {
				throw new IllegalStateException("no secure random algorithm found. (tried "+ Arrays.asList(secureRndNames) + ")");
			}
			secureRnd.setSeed(System.currentTimeMillis());
		} catch (Exception e) {
			e.getMessage();
		}

		return secureRnd;
	}

	/**
	 * Generates a secure random word with the given length consisting of uppercase and lowercase letters and numbers.
	 * 
	 * @param len: Amount of random characters to generate
	 * @return random Word containing letters and numbers.
	 */
	public static String createWord(int len) {
		return createWord(len, null);
	}

	/**
	 * Generates a secure random word with the given length.
	 * 
	 * @param len: Amount of random characters to generate
	 * @param alphabet Alphabet to generate from.
	 * @return random Word containing letters and numbers.
	 */
	public static String createWord(int len, char[] alphabet) {
		SecureRandom random = createSecureRandom();

		if (alphabet == null) {
			alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		}

		StringBuffer out = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			out.append(alphabet[random.nextInt(alphabet.length)]);
		}

		return out.toString();
	}
}
