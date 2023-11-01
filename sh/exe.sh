#!/bin/bash
echo "###################################################"
echo "############### Create Docker image ###############"
echo "###################################################"
mvn clean install -f ../pom.xml && docker build ../ -t mauriziorizzo89/rest-ms:1.0.1
echo "###################################################"
echo "############### Delete old deploy ###############"
echo "###################################################"
kubectl delete -f /Users/mauriziorizzo/Documents/github/rest-ms/k8s/deployment-rest-ms.yaml
echo "###################################################"
echo "############### Delete image from registry ###############"
echo "###################################################"
minikube image rm docker.io/mauriziorizzo89/rest-ms:1.0.1 -p mr-cluster
echo "###################################################"
echo "############### load image to the registry ###############"
echo "###################################################"
minikube image load mauriziorizzo89/rest-ms:1.0.1 -p mr-cluster
echo "###################################################"
echo "############### Create config map ###############"
echo "###################################################"
kubectl create cm rest-ms-cm -n cellar --from-file=/Users/mauriziorizzo/Documents/github/rest-ms/config/application-mysql.yaml --from-file=/Users/mauriziorizzo/Documents/github/rest-ms/config/application.yaml  --dry-run=client -oyaml > /Users/mauriziorizzo/Documents/github/rest-ms/k8s/cm.yaml
kubectl apply -f /Users/mauriziorizzo/Documents/github/rest-ms/k8s/deployment-rest-ms.yaml
echo "###################################################"
echo "############### Create deployment ###############"
echo "###################################################"
kubectl apply -f /Users/mauriziorizzo/Documents/github/rest-ms/k8s/cm.yaml
