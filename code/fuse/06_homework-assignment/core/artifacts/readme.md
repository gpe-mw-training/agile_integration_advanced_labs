Contains artifacts such as Customer provided WSDL’s, XSD’s and versioned interfaces to applications etc.

The artifacts should be built separately and WSDL’s should be brought in as a jar dependency to facilitate loose coupling.

Note how we use the Maven dependency plugin in Customer-App/core/services/pom.xml to unpack the artifacts jar to build a service using the WSDL in this jar. 