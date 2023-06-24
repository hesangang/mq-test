#!/bin/bash

set -x

docker exec -u www-data app-server php occ --no-warnings config:system:get trusted_domains >> trusted_domain.tmp

if ! grep -q "nginx" trusted_domain.tmp; then
    TRUSTED_INDEX=$(cat trusted_domain.tmp | wc -l);
    docker exec -u www-data app-server php occ --no-warnings config:system:set trusted_domains $TRUSTED_INDEX --value="nginx"
    docker exec -u www-data app-server php occ --no-warnings config:system:set trusted_domains $TRUSTED_INDEX --value="172.20.10.9"
fi

rm trusted_domain.tmp
