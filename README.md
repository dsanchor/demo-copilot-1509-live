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

# Deploy to AKS

## Environment variables

```bash
export RESOURCE_GROUP=aks-demo-alb-rg
export CLUSTER_NAME=demo
export NAMESPACE=demo1509
```

## Get AKS credentials

```bash
az aks get-credentials --resource-group $RESOURCE_GROUP --name $CLUSTER_NAME
```

## Create namespace

```bash
kubectl create namespace $NAMESPACE
```

## Deploy the application

```bash
kubectl apply -f k8s/application.yaml -n $NAMESPACE
```

## Get service public IP

```bash
export SVCIP=`kubectl get svc demo-app  -n $NAMESPACE -o jsonpath='{.status.loadBalancer.ingress[0].ip}'`
```

## Test the application

```bash
curl http://$SVCIP/hello
```