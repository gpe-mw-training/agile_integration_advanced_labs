Contains Web and Restful Service Implementations & Interfaces.

Note: Import the artifacts folder as a dependency since it contains the generated code from the Web Service contracts.

Ensure that the Implementation details are not exported from the bundle (in case of OSGi)
and only the interfaces are exported.

May contain several services implemented separately or combined.

~~~

This project contains both a test server which we are labeling a service, and an actual OSGi service which exposes a connection pool to the local AMQ broker.
