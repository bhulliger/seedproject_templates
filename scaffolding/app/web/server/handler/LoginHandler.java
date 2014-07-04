/**
 * (C) Copyright 2010, 2011 upTick Pty Ltd
 *
 * Licensed under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation. You may obtain a copy of the
 * License at: http://www.gnu.org/copyleft/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package @package@;

import @base@.shared.action.LoginAction;
import @base@.shared.action.LoginResult;
import @base@.client.util.Security;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import @core@.model.dao.UserDao;
import @core@.model.domain.User;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

// don't forget to update bindHandler() in ServerModule

public class LoginHandler implements ActionHandler<LoginAction, LoginResult> {

  private final Provider<HttpServletRequest> requestProvider;
  // private final ServletContext servletContext;

  @Inject
  LoginHandler(final ServletContext servletContext,
      final Provider<HttpServletRequest> requestProvider) {
    this.requestProvider = requestProvider;
    // this.servletContext = servletContext;
  }

  @Override
  public LoginResult execute(final LoginAction action,
      final ExecutionContext context) throws ActionException {

    LoginResult result = null;
    UserDao userDao = new UserDao();

    // Log.debug("LoginHandler - login: " + action.getLogin() + ", password: " + action.getPassword());

    try {
      User user = userDao.getByUsername(action.getUsername());

      if (user != null && isValidLogin(action, user)) {

        HttpSession session = requestProvider.get().getSession();
        session.setAttribute("login.authenticated", action.getUsername());

        result = new LoginResult(session.getId());
      }
      else {
        // GWTP only includes the exception type and it's message?
        // Looks like it needs only a small change on the DispatchServiceImpl class, 
        // on the execute() method:
        // Instead of calling logger.warning(message), use logger.log(level, message, throwable). 
        throw new LoginException("Invalid User name or Password.");
      }
    }
    catch (Exception e) {
      throw new ActionException(e);
    }

    return result;
  }

  private Boolean isValidLogin(LoginAction action, User user) {
    String hash = Security.sha256(user.getSalt() + action.getPassword());

    return hash.equals(user.getPassword());
  }

  @Override
  public Class<LoginAction> getActionType() {
    return LoginAction.class;
  }

  @Override
  public void undo(LoginAction action, LoginResult result,
      ExecutionContext context) throws ActionException {
  }
}

