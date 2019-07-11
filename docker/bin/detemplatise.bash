#!/bin/bash
set -e
2>&1

MUSTACHE_UTIL=/opt/inmobi/commons/mustache-util/render-template

if [ "$IDP_ENVIRONMENT" ];
then
    echo "Detected environment: $IDP_ENVIRONMENT";
else
    echo "Environment variable IDP_ENVIRONMENT was not set. Exiting; Please rerun the docker run command with -e IDP_ENVIRONMENT=<Suitable Value>.";
    exit -1;
fi;

if [ "$IDP_CLUSTER" ];
then
    echo "Detected colo: $IDP_CLUSTER";
else
    echo "Environment variable IDP_CLUSTER was not set. Exiting; Please rerun the docker run command with -e IDP_CLUSTER=<Suitable Value>.";
    exit -1;
fi;

YAML_DATA_SECTION=$IDP_ENVIRONMENT.$IDP_CLUSTER
echo "Generating configs using yaml data section: ${YAML_DATA_SECTION}"

# Turning on globstar. This will enable no directory and recursive directory matching for **
shopt -s globstar

# For more info regarding config generation, refer to https://github.corp.inmobi.com/platform-pe/mustache-util
for FILE in ${TEMPLATE_DIR}/**/*.mustache
do
    # Generating the output file name by removing '.build/templates/' from the file name
    TEMP=${FILE/"$TEMPLATE_DIR"}
    OUTPUT_FILE="$CONF_DIR"${TEMP/'.mustache'}

    rm -f $OUTPUT_FILE

    echo "Output file"
    echo $OUTPUT_FILE

    # Creating output directories
    mkdir -p `dirname $OUTPUT_FILE`
    DATA_FILE=${DATA_DIR}/settings.yaml

    # Merging the templates
    echo "Merging template: $FILE";
    echo "Yaml File:" $DATA_FILE;
    $MUSTACHE_UTIL --template $FILE --data $DATA_FILE --yaml_data_section $YAML_DATA_SECTION --output $OUTPUT_FILE --addenvvars=True

    # Merging templates with environment variables again so as to enable 2-step replacements
    $MUSTACHE_UTIL --template $OUTPUT_FILE --output $OUTPUT_FILE --addenvvars=True
done