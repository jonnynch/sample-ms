# Swagger Codegen
```
mvn clean compile
```

# Local start - H2
```
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

# Local start - MySQL
```
docker rm -f mysql-container
docker run --name mysql-container \
-v /home/jonng/mysql-datadir:/var/lib/mysql \
-e MYSQL_DATABASE=testdb \
-e MYSQL_USER=user \
-e MYSQL_PASSWORD=pass \
-e MYSQL_ROOT_PASSWORD=root-pass \
-p 3306:3306 \
-d mysql:latest

apt-get install mysql-client

mysql -uroot -proot-pass testdb  -P3306 -hlocalhost --protocol=tcp
GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION;
exit

mysql -uuser -ppass testdb  -P3306 -hlocalhost --protocol=tcp
SELECT host, user FROM mysql.user; 
exit 

mvn spring-boot:run -Dspring-boot.run.profiles=local,mysql
```

# Local start - PostgreSQL
```
docker rm -f pgsql-container
docker run --name pgsql-container \
-v /home/jonng/pgsql-datadir:/var/lib/postgresql/data \
-e POSTGRES_DB=testdb \
-e POSTGRES_USER=user \
-e POSTGRES_PASSWORD=pass \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-p 5432:5432 \
-d postgres:latest

apt-get install -y postgresql-client

psql -Uuser testdb  -p5432 -hlocalhost
select * from user; 
exit

mvn spring-boot:run -Dspring-boot.run.profiles=local,pgsql
```

# Test
```
HOST=http://localhost:8888
#HOST=https://sample.demo.localdev.me

#insert
curl -XPOST $HOST/api/book   -H 'Content-Type: application/json' -d '{"title":"ABC","author":"Peter"}' -k
curl $HOST/api/book -k

#query
id=`curl $HOST/api/book -k|jq -r '.[0].id'`
curl $HOST/api/book/$id -k 

#update
curl -XPOST $HOST/api/book -H 'Content-Type: application/json' -d '{"id":"'$id'","title":"ABCD","author":"John"}' -k
curl $HOST/api/book -k

#delete
curl -XDELETE $HOST/api/book/$id -k
curl $HOST/api/book -k 
```