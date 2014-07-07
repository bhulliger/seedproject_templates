/**
 * Copyright 2012 Brigitte Hulliger
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

import @base@.client.i18n.AppMessages;
import @base@.client.i18n.AppConfig;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Footer extends Composite {

	interface Binder extends UiBinder<Widget, Footer> {
	}

	@UiField
	Label version, buildDate; // NOSONAR

	@Inject
	public Footer(Binder binder, AppMessages messages, AppConfig config) {
		version = new Label();
		buildDate = new Label();

		initWidget(binder.createAndBindUi(this));

		version.setText(messages.buildNumber(config.version()));
		buildDate.setText(messages.buildDate(config.buildDate()));
	}
	

}