#!/bin/sh
#

# NOTE: requires JAVA_HOME and AXIS2_HOME to be set

JARPATH="$AXIS2_HOME/lib/*.jar"
AXIS2CP=""
for FILE in $JARPATH; do 
  AXIS2CP=$AXIS2CP:$FILE
done

java -cp "$AXIS2CP:dist/hws.aar" \
  -Dservice.url=http://localhost:8080/axis2/services/HelloWorldService \
  -Dorg.apache.commons.logging.Log=org.apache.commons.logging.impl.NoOpLog \
  -Ddebug.messages=true \
  se.umu.cs.edu.soa.hws.Client $1 $2 $3 $4 $5 $6 $7 $8 $9
