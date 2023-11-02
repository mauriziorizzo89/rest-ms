# Build docker image

``mvn clean install && docker build . -t mauriziorizzo89/rest-ms:1.0.1``

# Start minukube cluster 

``minikube start --driver=docker --nodes 3 -p mr-cluster``

``minikube start -p mr-cluster``

``minikube image load mauriziorizzo89/rest-ms:1.0.1 -p mr-cluster``

# Show image on minikube

``minikube image ls -p mr-cluster | grep rest-ms``

# H2 in memory DB

``URL: http://localhost:8080/h2-console/``

``us: sa``
``pw: password``

# MySQL with HELM

``https://dev.mysql.com/doc/mysql-operator/en/mysql-operator-introduction.html``

``https://dev.mysql.com/doc/mysql-operator/en/mysql-operator-installation-helm.html``

``helm repo add mysql-operator https://mysql.github.io/mysql-operator/``

``helm repo update``

``helm install my-mysql-operator mysql-operator/mysql-operator --namespace mysql-operator --create-namespace``


##  Deploy using Helm

https://dev.mysql.com/doc/mysql-operator/en/mysql-operator-innodbcluster-simple-helm.html

``helm show values mysql-operator/mysql-innodbcluster``

``helm install mycluster mysql-operator/mysql-innodbcluster --set tls.useSelfSigned=true --values credentials.yaml``

Alternatively set options using command-line parameters:

``helm install mycluster mysql-operator/mysql-innodbcluster --set credentials.root.user='root' --set credentials.root.password='sakila' --set credentials.root.host='%' --set serverInstances=3 --set routerInstances=1 --set tls.useSelfSigned=true``

``helm get values mycluster``

The manifest for this simple installation looks similar to this:

``helm get manifest mycluster``