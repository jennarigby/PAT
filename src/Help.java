
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jenna Rigby
 * This class is the backend of the HelpScreen and it used to read the text 
 * files necessary to display help
 */
public class Help {
    private String contact = "";
    private String faqs = "";
    private String rules = "";
    
    /**
     *
     * @return String
     * Reads contact details from text file to be displayed on HelpScreen.
     */
    public String getContact() {
        try {
            File filename = new File("contact.txt");
            Scanner scFile = new Scanner(filename);
            while (scFile.hasNext()) {
                contact += scFile.nextLine() + "\n";
            }
            scFile.close();
            return contact;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. Please check file name or "
                    + "path");
        }
        return "";
    }

    /**
     *
     * @return String
     * Reads FAQs from text file to be displayed on HelpScreen.
     */
    public String getFaqs(){
        try {
            File filename = new File("faqs.txt");
            Scanner scFile = new Scanner(filename);
            while (scFile.hasNext()) {
                faqs += scFile.nextLine() + "\n";
            }
            scFile.close();
            return faqs;
        } //retrieves the FAQs
        catch (FileNotFoundException ex) {
            System.out.println("File not found. Please check file name or "
                    + "path");
        }
       return ""; 
    }

    /**
     *
     * @return
     * Reads rules from text file to be displayed on HelpScreen.
     */
    public String getRules() {
        try {
            File filename = new File("rules.txt");
            Scanner scFile = new Scanner(filename);
            while (scFile.hasNext()) {
                rules += scFile.nextLine() + "\n";
            }
            scFile.close();
            return rules;
        } //retrieves the rules
        catch (FileNotFoundException ex) {
           System.out.println("File not found. Please check file name or "
                    + "path");
        }
        return "";
    }
   
    
    
    
}
