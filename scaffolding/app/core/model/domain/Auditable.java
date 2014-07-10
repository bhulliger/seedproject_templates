package @package@;

import java.util.Date;

public interface Auditable {

	Date getCreationDate();

	Date getModificationDate();

	String getCreationUser();

	String getModificationUser();

}