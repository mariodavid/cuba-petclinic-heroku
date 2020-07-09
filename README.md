# CUBA Petclinic - Only ENV Vars


### Setup

In the docker-compose.yml it provides the env variables:

```
  web:
    build: .
    environment:
      - CUBA_DATASOURCE_JDBCURL=jdbc:postgresql://postgres/dockercompose
      - CUBA_DATASOURCE_USERNAME=postgres
      - CUBA_DATASOURCE_PASSWORD=postgres123

```

### Start the Application via UberJar

```bash
./gw buildUberJar

docker-compose build
docker-compose up
```


### Expected Behavior

the application is able to connect to the DB

### Actual Behavior

In the logs it states:

```
web_1       | 08:09:43.641 INFO  c.h.cuba.core.sys.AppContextLoader      - DbmsType of the main database is set to postgres
web_1       | 08:09:43.690 INFO  c.h.c.c.s.e.DataStoresCheck             - Checking connection to data store Main
web_1       | 08:09:43.847 WARN  c.h.c.c.s.e.EnvironmentChecksRunner     - 
web_1       | ===============================================================================================================================================================================
web_1       | Some environment checks failed on core module:
web_1       | Exception occurred while connecting to data store _MAIN_
web_1       |   org.postgresql.util.PSQLException: Connection to localhost:5432 refused. Check that the hostname and port are correct and that the postmaster is accepting TCP/IP connections.
web_1       | ===============================================================================================================================================================================
```

`localhost:5432` shows that it did not take the values from the ENV variable, but rather from the `app.properties` file.

Note: Spring profiles are not used here at all.