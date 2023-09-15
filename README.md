# Spring Boot Rest API

## Build

```bash
mvn clean install
```

## Run

```bash
mvn spring-boot:run
```

## Test hello operation

```bash
curl http://localhost:8080/hello
```

## Test reverse text operation

```bash
curl http://localhost:8080/reverse?text=Hello
```

## Test the remove vowels operation

```bash
curl http://localhost:8080/disemvowel?text=Hello
```

## Test junit

```bash
mvn test
```

# Containerize

## Build the docker image

```bash
docker build -t demo1509 .
```
## Run the docker image

```bash
docker run -p 8080:8080 demo1509
```
