#!/bin/sh
sudo iptables -F

sleep 10s

# Run following as 'opentlc-mgr' 

# Following Env variables should exist:
# CHANGE THESE VALUES TO RIGHT OCP ENV BEFORE RUNNING THE SCRIPT

REGION=0b11
OCP_DOMAIN=openshift.opentlc.com
OCP_SUFFIX=apps.$REGION.$OCP_DOMAIN
OCP_AMP_ADMIN_ID=api0


# Start and End tenants.
# CHANGE DEPENDING ON NO OF TENANTS REQUIRED
START_TENANT=1
END_TENANT=10

OPENSHIFT_MASTER=https://master.$REGION.$OCP_DOMAIN


### IMPORT IMAGE STREAMS

# AMQ

oc replace --force  -f \
https://raw.githubusercontent.com/jboss-container-images/jboss-amq-7-broker-openshift-image/72-1.1.GA/amq-broker-7-image-streams.yaml
oc replace --force -f \
https://raw.githubusercontent.com/jboss-container-images/jboss-amq-7-broker-openshift-image/72-1.1.GA/amq-broker-7-scaledown-controller-image-streams.yaml
oc import-image amq-broker-72-openshift:1.1
oc import-image amq-broker-72-scaledown-controller-openshift:1.0

# Fuse

# Modified template to use registry.access.redhat.com

oc replace --force -f \
fis-image-streams.json

### IMPORT TEMPLATES

# AMQ

for template in amq-broker-72-basic.yaml \
amq-broker-72-ssl.yaml \
amq-broker-72-custom.yaml \
amq-broker-72-persistence.yaml \
amq-broker-72-persistence-ssl.yaml \
amq-broker-72-persistence-clustered.yaml \
amq-broker-72-persistence-clustered-ssl.yaml;
 do
 oc replace --force -f \
https://raw.githubusercontent.com/jboss-container-images/jboss-amq-7-broker-openshift-image/72-1.1.GA/templates/${template}
 done

# Fuse

for template in eap-camel-amq-template.json \
 eap-camel-cdi-template.json \
 eap-camel-cxf-jaxrs-template.json \
 eap-camel-cxf-jaxws-template.json \
 eap-camel-jpa-template.json \
 karaf-camel-amq-template.json \
 karaf-camel-log-template.json \
 karaf-camel-rest-sql-template.json \
 karaf-cxf-rest-template.json \
 spring-boot-camel-amq-template.json \
 spring-boot-camel-config-template.json \
 spring-boot-camel-drools-template.json \
 spring-boot-camel-infinispan-template.json \
 spring-boot-camel-rest-sql-template.json \
 spring-boot-camel-teiid-template.json \
 spring-boot-camel-template.json \
 spring-boot-camel-xa-template.json \
 spring-boot-camel-xml-template.json \
 spring-boot-cxf-jaxrs-template.json \
 spring-boot-cxf-jaxws-template.json ;
 do
 oc create -n openshift -f \
 https://raw.githubusercontent.com/jboss-fuse/application-templates/application-templates-2.1.fuse-720018-redhat-00001/quickstarts/${template}
 done

# Apicurito

oc create -n openshift -f https://raw.githubusercontent.com/jboss-fuse/application-templates/application-templates-2.1.fuse-720018-redhat-00001/fuse-apicurito.yml

### Fuse Online

# Run setup script

	bash install-syndesis --setup

### COMMON PROJECTS & APPLICATIONS

### Create Apicurito Project

oc adm new-project apicurito --admin=opentlc-mgr --description="Apicurito Studio."

oc project apicurito

oc new-app --template=apicurito --param=ROUTE_HOSTNAME=apicurito.$OCP_SUFFIX

sleep 60s;

### Grant Access for 3scale Default account (for discovery)

oc adm policy add-cluster-role-to-user view system:serviceaccount:3scale-mt-$OCP_AMP_ADMIN_ID:default

## LOOP FOR TENANTS

# loops from START_TENANT to END_TENANT to create tenant projects and applications.
# Each user is given admin rights to their corresponding projects.


for i in $(seq $START_TENANT $END_TENANT) ; do

	   
	tenantId=user$i;

	echo "Now starting deployment for user :" $tenantId;

        # Give users view access to the infra projects apicurito & 3scale-mt-api0

	oc adm policy add-role-to-user view $tenantId -n apicurito
	oc adm policy add-role-to-user view $tenantId -n 3scale-mt-api0


	# Create project for Fuse Online


    oc adm new-project $tenantId-fuse-online --admin=$tenantId  --description=$tenantId 

	sleep 5s;

	# Install Syndesis

	oc project $tenantId-fuse-online

	bash install-syndesis --grant $tenantId

	bash install-syndesis --route $tenantId-fuse-online.$OCP_SUFFIX 


done;	
