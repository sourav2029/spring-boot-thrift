#!/usr/bin/env bash


set -e
2>&1
# All validation/manipulation of IDP environment variables must be done in this file and this file alone.

# This function takes 3 parameters
# $1 : [required] Name of the environment variable to check
# $2 : [optional, default false] Whether to exit if the env variable is not set
# $3 : [optional] Custom message for the scenario specified by $2
function checkEnvironmentVariable {
    if [ "${!1}" ];
    then
        echo "Detected $1: ${!1}";
    else
        local error_msg="Environment variable $1 was not set"
        if [ "$2" = true ];
        then
            if [ "$3" ];
            then
                echo "${error_msg}. Exiting... $3";
            else
                echo "${error_msg}. Exiting... ${3}Please rerun the docker run command with -e $1=<Suitable Value>.";
            fi;
            exit -1;
        else
            if [ "$3" ];
            then
                echo "${error_msg}. $3";
            else
                echo "${error_msg}.";
            fi;
        fi;
    fi;
}
# This function takes 2 parameters
# $1 : [required] Name of the environment variable
# $2 : [required] Value to set for environment variable $1 if it is not already set
function setIfNotSet {
    if [ ! "${!1}" ] && [ "$2" ];
    then
        export $1=$2
        echo "Defaulting $1 to ${2}."
    fi;
}

# IDP_ENVIRONMENT is the only mandatory parameter
checkEnvironmentVariable IDP_ENVIRONMENT true

# All other IDP environment variables are also mandatory unless the IDP_ENVIRONMENT is explicitly set to 'non_prod'
if [ "$IDP_ENVIRONMENT" == "non_prod" ];
then
    checkEnvironmentVariable IDP_CLUSTER false
    checkEnvironmentVariable IDP_SERVICE false
    checkEnvironmentVariable IDP_CONTAINER_NAME false
    checkEnvironmentVariable IDP_CONTAINER_IP false "JMX will be broken."
    checkEnvironmentVariable IDP_NODE_INDEX false

    setIfNotSet IDP_CLUSTER corp
    setIfNotSet IDP_SERVICE heartbeat
    setIfNotSet IDP_CONTAINER_NAME dummy
    setIfNotSet IDP_CONTAINER_IP localhost
    setIfNotSet IDP_NODE_INDEX 0
else
    checkEnvironmentVariable IDP_CLUSTER true
    checkEnvironmentVariable IDP_SERVICE true
    checkEnvironmentVariable IDP_CONTAINER_NAME true
    checkEnvironmentVariable IDP_CONTAINER_IP true "JMX will be broken."
    checkEnvironmentVariable IDP_NODE_INDEX true
fi;

# These ports have been hardcoded for now (with handling for the case where they are already set).
# TODO: Enforce strict checking for dynamic ports after completely moving to mesos.
# TODO: As the serving and health check port must be the same for service registry, CAS_PORT2 is redundant. Clean up in the future
export IDP_CONTAINER_PORT_0=${IDP_CONTAINER_PORT_0:=9000}
echo "Done With Validation"
