// ############################################################################
// Global Configuration Variables
// ############################################################################
templates {
	path = "C:/work/sandbox/seedproject_templates/"
}	

// ############################################################################
// Operating System & Server
// ############################################################################
os {
	type = "unix" // unix / win
}

server {	
	context = "web"	// TODO change to real context
	ip = ""
}

sonar {
	host {
		url = "http://sonar:9000"
	}
	jdbc {
		url = "" // TODO
		driverClassName = "" // TODO
		username = "" // TODO
		password = "" // TODO
	}
	projectName = "" // TODO
	projectKey = "" // TODO
	exclusions = "" // TODO
	jacoco {	
		excludes = ""; // TODO
	}
}

// ############################################################################
// Artifacts
// ############################################################################
artifactRepository {
	url = "" // TODO
	username = "" // TODO
	password = "" // TODO
	name = "" // TODO
	publicRepo = "" // TODO
}

// ############################################################################
// Environments
// ############################################################################
environments {

	// ########################################################################
	// Development
	// ########################################################################
	dev {
		env = "dev"
		server {
			url = "http://localhost:8080/" + server.context
			dierctory = "/path/to/jboss/home" // TODO
		}
		os {
			type = "win"
		}
		db {
			driver = "org.hsqldb.jdbcDriver"
			type = "hsqldb"
			url = "jdbc:hsqldb:file:c:/tmp/seedproject/hsqldb/db;shutdown=true" // TODO
			user = "sa"
			password = ""
			jndiName = "java:/seedprojectDB" // TODO
			jndiNameAdmin = "java:/seedprojectDBAdmin" // TODO
			poolName = "seedprojectPool" // TODO
		}
	}

	// ########################################################################
	// Integration
	// ########################################################################
	integration {
		// TODO
	}

	// ########################################################################
	// Test
	// ########################################################################
	test {
		// TODO
	}

	// ########################################################################
	// Production
	// ########################################################################
	prod {
		// TODO
	}

}