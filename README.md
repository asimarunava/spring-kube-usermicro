# spring-kube-usermicro

This runs on Nodeport. This is the entry point to k8s Cluster without LB and Ingress.

# Prerequisite
Must Have Local K8s Cluster
Must have Skaffold 


Run this command

mvn clean install -DskipTests && skaffold run

goto
localhost:nodeport/
It should print the ConfigMap value.
