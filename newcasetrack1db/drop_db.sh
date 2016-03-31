




echo $PATH
DB_PATH=/tmp/applifire/db/O3GINAXWKMBKYJNM2DBPG/CAF9C064-623C-42CC-AA2B-1D0F47C01836
MYSQL=/usr/bin
USER=algo
PASSWORD=algo
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'