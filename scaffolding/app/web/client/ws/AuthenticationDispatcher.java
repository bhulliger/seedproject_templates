package @package@;

import java.io.UnsupportedEncodingException;

import org.fusesource.restygwt.client.Dispatcher;
import org.fusesource.restygwt.client.Method;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.googlecode.gwt.crypto.bouncycastle.util.encoders.Base64;

public class AuthenticationDispatcher implements Dispatcher {

	public static final AuthenticationDispatcher INSTANCE = new AuthenticationDispatcher();

	private static final String AUTHORIZATION_HEADER = "Authorization";

	private String username;
	private String password;

	@Override
	public Request send(final Method method, final RequestBuilder builder) throws RequestException {
		String basicAuthHeaderValue;
		try {
			basicAuthHeaderValue = createBasicAuthHeader(username, password);

			builder.setHeader(AUTHORIZATION_HEADER, basicAuthHeaderValue);
			return builder.send();
		} catch (final UnsupportedEncodingException e) {
			throw new RequestException(e);
		}
	}

	public static void setCredentials(final String username, final String password) {
		INSTANCE.username = username;
		INSTANCE.password = password;
	}

	private String createBasicAuthHeader(final String userName, final String password)
			throws UnsupportedEncodingException {
		final String credentials = userName + ":" + password;
		final String encodedCredentials = new String(Base64.encode(credentials.getBytes()), "UTF-8");

		return "Basic " + encodedCredentials;
	}

}
