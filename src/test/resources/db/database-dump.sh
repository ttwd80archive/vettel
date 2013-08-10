#!/bin/bash
db_host=localhost
db_user=vettel
db_password=zu43b2uja9egexen
db_name=vettel
output_path="`dirname \"$0\"`"

mysqldump -d -h $db_host -u $db_user -p${db_password} ${db_name} 2> /dev/null | grep -v "Dump completed on" > ${output_path}/${db_name}-structure.sql
echo Structure dump. Done.
mysqldump -u $db_user -p${db_password} --no-create-db --no-create-info --skip-extended-insert --complete-insert ${db_name}  2> /dev/null | grep -v "Dump completed on" > ${output_path}/${db_name}-data.sql
echo Data dump. Done.
