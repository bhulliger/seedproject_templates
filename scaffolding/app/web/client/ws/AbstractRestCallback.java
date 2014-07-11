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

import javax.inject.Inject;

import org.fusesource.restygwt.client.FailedStatusCodeException;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.ResponseFormatException;

import com.google.gwt.http.client.Response;
import com.google.web.bindery.event.shared.EventBus;

public abstract class AbstractRestCallback<T> implements MethodCallback<T> {

	@Inject
	private static EventBus eventBus;

	@Override
	public final void onFailure(final Method method, final Throwable caught) {

		if (caught instanceof FailedStatusCodeException) {
			final FailedStatusCodeException exception = (FailedStatusCodeException) caught;
			switch (exception.getStatusCode()) {
				case Response.SC_UNAUTHORIZED:
					// TODO Auto-generated method stub
					break;
				case Response.SC_FORBIDDEN:
					// TODO Auto-generated method stub
					break;
				case Response.SC_NOT_FOUND:
					// TODO Auto-generated method stub
					break;
				case Response.SC_CONFLICT:
					// TODO Auto-generated method stub
					break;
				default:
					onCustomFailure(method, exception);
			}
		} else if (caught instanceof ResponseFormatException) {
			// TODO Auto-generated method stub
		} else {
			// TODO Auto-generated method stub
		}

	}

	public void onCustomFailure(Method method, FailedStatusCodeException caught) {
		// TODO Auto-generated method stub
	}

}