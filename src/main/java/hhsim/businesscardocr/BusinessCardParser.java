package hhsim.businesscardocr;

import java.io.File;
import java.nio.charset.StandardCharsets;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;


public class BusinessCardParser {
	/**
	 * Parses the results of the optical character recognition (OCR) component
	 * in order to extract the name, phone number, and email address from the
	 * processed business card image.
	 * 
	 * @param document
	 * @return ContactInfo object
	 * 
	 */
	public static ContactInfo getContactInfo(String document) {
		System.out.println(document);
		System.out.println("\n==>\n");

		// Instantiate ParseContactInfo
		ParseContactInfo parser = new ParseContactInfo();
		ContactInfo contactInfo = null;

		// Parse through non-emptied document (line by line)
		if (StringUtils.isNotBlank(document)) {
			String[] lines = document.split("\\n");
			String name = "";
			String phone = "";
			String email = "";

			// Get name, phone number and email address from document
			for (String line : lines) {
				if (name.length() <= 0) {
					name = parser.nameFinder(line);
				}
				if (phone.length() <= 0) {
					phone = parser.phoneFinder(line);
				}
				if (email.length() <= 0) {
					email = parser.emailAddressFinder(line);
				}
			}
			contactInfo = new ContactInfo(name, phone, email);
			System.out.println(contactInfo.toString());
		}
		return contactInfo;
	}

	/**
	 * Accept a command line that takes the business card text as input and
	 * outputs the Name, Phone, and Email Address of the owner of the business
	 * card.
	 */
	public static void main(String... args) throws Exception {
		Options opt = new Options();
		opt.addOption("f", "file", true, "File to parse");
		opt.addOption("h", "usage", false, "Usage");
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(opt, args);

		if (cmd.hasOption("f")) {
			// Default StandardCharsets.UTF_8
			getContactInfo(FileUtils.readFileToString(new File(cmd.getOptionValue("f")), StandardCharsets.UTF_8));
		} else {
			// Print out help option
			new HelpFormatter().printHelp("BusinessCardParser", opt);
			System.exit(0);
		}
	}
}