/**
 * Copyright 2014 Brigitte Hulliger
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package @package@;

public class FieldVerifier {

  public static boolean isValidPassword(final String password) {

    if (password == null) {
      return false;
    }

    return password.matches(PASSWORD_VALIDATION_REGEX);
  }

  /*
   * ( # Start of group (?=.*\d) # must contains one digit from 0-9 (?=.*[a-z]) # must contains one lower case
   * characters (?=.*[A-Z]) # must contains one upper case characters (?=.*[@#$%]) # must contains one special symbols
   * in the list "@#$%" . # match anything with previous condition checking {8,32} # length at least 8 characters and
   * maximum of 32 ) # End of group
   */

  public static boolean isValidUsername(final String name) {

    if (name == null) {
      return false;
    }

    return name.length() > 6;
  }

  private final static String PASSWORD_VALIDATION_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,32})";
}