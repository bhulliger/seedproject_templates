#!/bin/bash

# *****************************************************************************
# * Installationscript														  *
# *****************************************************************************

BinPath=@serverDirectory@/bin
ServerIpAddress=@serverIp@

echo "********** Uninstall App **********"
set +e
$BinPath/jboss-cli.sh --connect --controller=$ServerIpAddress:9999 command="undeploy @serverContext@.war"
set -e

echo "********** Delete DB Data **********"
if ["@environment@" != "prod"]; then
	cd tools/flyway
	./flyway.sh -driver @dbDriver@ -user=@dbUser@ -password=@dbPassword@ -url=@dbUrl@ clean
	cd -
fi

echo "********** Install App **********"
$BinPath/jboss-cli.sh --connect --controller=$ServerIpAddress:9999 command="deploy --force war/@serverContext@.war"


