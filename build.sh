#!/bin/bash
docker run --name wadek-mariadb \
-e MYSQL_ROOT_PASSWORD=my-secret-pw -d \
-e MYSQL_DATABASE=USER \
-e MYSQL_USER=wadek \
-e MYSQL_PASSWORD=admin \
-p 3306:3306 \
mariadb

