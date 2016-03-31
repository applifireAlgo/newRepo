




echo $PATH
DB_PATH=/tmp/applifire/db/OL3ADMWP2M31WDU3NHHOQG/E7EDD601-58F8-42A1-9A72-DFD2D2FFCA12
MYSQL=/usr/bin
USER=checkproj
PASSWORD=checkproj
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'