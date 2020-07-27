package hhsim.businesscardocr;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.Span;

public class ParseContactInfo {
	// Regex pattern for email address
	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	// Regex pattern for phone number
	private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\d{10}|\\d{11})$");
	// Model pattern for name
	private static Tokenizer tokenizer = null;
	private static NameFinderME finder = null;
	static {
		try {
		    TokenNameFinderModel model = new TokenNameFinderModel(ClassLoader.getSystemResourceAsStream("en-ner-person.bin"));
		    tokenizer = SimpleTokenizer.INSTANCE;
	        finder = new NameFinderME(model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Verify if input string qualifies email address pattern
	 * @param input
	 * @return emailAddress or ""
	 */
	public String emailAddressFinder(String input) {
		// If a match is found, return the input. otherwise return empty string
		return (StringUtils.isNotBlank(input) && EMAIL_PATTERN.matcher(input).matches()) ? input : "";
	}

	/**
	 * Verify if input string qualifies phone number pattern
	 * @param input
	 * @return phone or ""
	 */
	public String phoneFinder(String input) {
		// Remove all non-digit from input string
		String phone = input.replaceAll("[^\\d]", "");
		// Find a match for phone pattern
		boolean matchPhone = PHONE_PATTERN.matcher(phone).matches();
		return (StringUtils.isBlank(input) || !matchPhone || input.toLowerCase().indexOf("f" )!=-1) ? "" : phone;
	}

	/**
	 * Verify if input string qualifies name pattern
	 * @param input
	 * @return name or ""
	 */
 	public String nameFinder(String input) {
 	    // Split the input into tokens       
 		String tokens[] = tokenizer.tokenize(input);
 		// Find the names in the tokens and return Span objects
       	Span[] nameSpans = finder.find(tokens);
        return (nameSpans.length == 0) ? "" : input;
	}
}