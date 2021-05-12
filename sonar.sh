#!/bin/bash
set -x
exec &> log.txt
echo running validation build
mvn sonar:sonar
sleep 5
curl_cmd=`curl -i -X POST -d "login=admin" -d "password=42899975" http://192.168.99.14:9200/api/authentication/login`
c=`echo $curl_cmd |grep 'Set-Cookie:' | awk -F ":" '{print $8}'`
cmd=`curl -b "$c" http://192.168.99.14:9200/api/qualitygates/project_status?projectKey=mydemo`
d=`echo $cmd | awk -F ":" '{print $3}' | awk -F "," '{print $1}'`
echo "=============="$d
if [ $d=="\"ERROR\"" ]; then
    exit 1
elif [ $d=="\"OK\"" ]; then
    exit 0
fi