package @package@;

public class LoginHandler implements ActionHandler<LoginAction, LoginResult> {
	
	private final Provider<HttpServletRequest> requestProvider;

	@Inject
	LoginHandler(final ServletContext servletContext, final Provider<HttpServletRequest> requestProvider) {
		this.requestProvider =  requestProvider;
	}



}