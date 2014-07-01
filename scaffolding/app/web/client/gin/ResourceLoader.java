package @package@;

import javax.inject.Inject;

import @base@.client.resources.AppResources;

public class ResourceLoader {

	@Inject
	public ResourceLoader(AppResources resources) {
	
		resources.styles().ensureInjected();

		resources.sprites().ensureInjected();
	}

}
