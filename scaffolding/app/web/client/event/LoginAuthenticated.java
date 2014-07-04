package @package@;

import @base@.shared.model.CurrentUser;

import com.gwtplatform.dispatch.annotation.GenEvent;

@GenEvent
public class LoginAuthenticated {

	CurrentUser currentUser;

}