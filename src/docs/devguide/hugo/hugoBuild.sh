#!/usr/bin/env bash

# Run a hugo build from the comfort of a docker container
#
# ----------------------------------------------------------------------------------------------------------------------
# usage:
#
#   hugoBuild.sh BASE_DIR
#
#     BASE_DIR: maven ${basedir} property, the base dir of this project
#


BASE_DIR=$1

echo ''
echo ''
echo '  + Running hugo build'
echo ''

docker run \
  -v "${BASE_DIR}"/target/devguide/hugo:/src \
  --name hugo \
  -e "HUGO_THEME=hugo-material-docs" \
  -e "HUGO_BASEURL=https://electrumpayments.github.io/airtime-service-interface-docs/" \
  jojomi/hugo:0.29

docker cp hugo:/output/. "${BASE_DIR}"/target/devguide/site

docker stop hugo &> /dev/null
docker rm hugo &> /dev/null


if [ ! -z $CI ]; then
  echo ''
  echo "Setting ownership of Hugo output"
  echo "BASE_DIR: ${BASE_DIR}"
  sudo chown -R $(whoami):$(whoami) ${BASE_DIR}/target/devguide/site
fi
