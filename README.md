# spring-kube-usermicro
#To run Locally (not inside Cluster)
java -jar -Dspring.cloud.kubernetes.config.enabled=false ./target/app.jar
# This is to integrate Kafka

This runs on Nodeport. This is the entry point to k8s Cluster without LB and Ingress.

# Prerequisite
Must Have Local K8s Cluster
Must have Skaffold 



This Repo(usermicro) springboot app is simple application for to see
* Load Application property file using k8s configMap.
* Spring Auto refresh the properties value if changes occurs in ConfigMap
* We need RBAC policy for our springboot app so that it can watch the configMap.




# How to Run

Before deploying the springboot app make sure following yaml files are applied to k8s cluster.

kubectl apply -f rbac.yaml <br>
kubectl apply -f config.yaml

Then run below command

mvn clean install -DskipTests && skaffold run

Check on which nodeport the application is running.

goto
localhost:nodeport/
It should print the ConfigMap value.

{bean.message: This is coming from K8s Cluster.}

Then update the configmap value to
{bean.message: This is coming from K8s Cluster 123 changed.}

then apply the changes
kubectl apply -f config.yaml
then visit 
localhost:nodeport/
it should print the updated value.

Cheers...
Feel free to email me in case any issue
asimarunava@googlemail.com