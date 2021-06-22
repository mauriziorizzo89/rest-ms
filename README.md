# Build docker image

``mvn clean install && docker build . -t mauriziorizzo89/rest-ms:1.0.0``

# Start minukube cluster 

``minikube start --driver=docker --nodes 3 -p mr-cluster``

``minikube start -p mr-cluster``

``minikube image load mauriziorizzo89/rest-ms:1.0.0 -p mr-cluster``

# Show image on minikube

``minikube image ls -p mr-cluster | grep rest-ms``

# H2 in memory DB

``URL: http://localhost:8080/h2-console/``

``us: sa``
``pw: password``

