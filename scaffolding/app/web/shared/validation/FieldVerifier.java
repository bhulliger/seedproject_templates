package @package@;

public class FieldVerifier {

  public static boolean isValidUserName(String name) {

    if (name == null) {
      return false;
    }

    return name.length() > 6;
  }

  /*

  (                         # Start of group
      (?=.*\d)              #   must contains one digit from 0-9
      (?=.*[a-z])           #   must contains one lower case characters
      (?=.*[A-Z])           #   must contains one upper case characters
      (?=.*[@#$%])          #   must contains one special symbols in the list "@#$%"
                  .         #     match anything with previous condition checking
                    {8,32}  #        length at least 8 characters and maximum of 32
    )                       # End of group

  */

  private final static String PASSWORD_VALIDATION_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,32})";

  public static boolean isValidPassword(String password) {

    if (password == null) {
      return false;
    }

    return password.matches(PASSWORD_VALIDATION_REGEX);
  }
}