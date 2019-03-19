package by.epam.java.horse_racing.util;

/**
 * The type Xss attack security.
 */
public class XSSAttackSecurity {
    private static class XSSAttackSecurityHolder {
        private static final XSSAttackSecurity INSTANCE = new XSSAttackSecurity();
    }

    private static final String PARAM_GRATER = ">";
    private static final String PARAM_LESS = "<";
    private static final String PARAM_GRATER_REPLACEMENT = "&gt;";
    private static final String PARAM_LESS_REPLACEMENT = "&lt;";

    private XSSAttackSecurity() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static XSSAttackSecurity getInstance() {
        return XSSAttackSecurityHolder.INSTANCE;
    }

    /**
     * Secure string from XSS atack by replacing the brackets.
     *
     * @param str the str
     * @return the string
     */
    public String secure(String str) {
        return str == null ? null : str.replaceAll(PARAM_GRATER , PARAM_GRATER_REPLACEMENT).replaceAll(PARAM_LESS , PARAM_LESS_REPLACEMENT);
    }
}
