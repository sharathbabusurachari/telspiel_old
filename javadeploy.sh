#!/bin/bash

status=`ps -ef | grep telspiel | grep jar | awk '{print $2}'`

if [ -z "$status" ];
        then
        echo "Application is NOT running & we're starting now";
        java -jar /var/lib/jenkins/workspace/01_Java_CICD/target/telspiel-0.0.1-SNAPSHOT.jar &
        if [[ "$?" == 0 ]]; then echo "Application has been started successfully"; exit 0; else echo "Application deployment failed"; exit 1; fi

else
        echo "Application is already running & hence killing previous pid :";
        kill -9 $status;
        if [[ "$?" == 0 ]]; then echo "Previous instance of the Application has been stopped successfully";
                else echo "Failed to stop previous instance of the Application"; exit 1;
        fi
        java -jar /var/lib/jenkins/workspace/01_Java_CICD/target/telspiel-0.0.1-SNAPSHOT.jar &
        if [[ "$?" == 0 ]]; then echo "Application has been deployed successfully"; exit 0; else echo "Application deployment failed"; exit 1; fi
fi
