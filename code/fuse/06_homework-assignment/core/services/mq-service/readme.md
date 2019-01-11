This project simply creates a connection pool to the AMQ broker that comes installed by default with Fuse Standalone. It then exposes that as an OSGi service. You can see it referenced in most of the child project's Camel contexts with the line:

<osgi:reference id="activemq" interface="org.apache.camel.Component"/>

