This is an integration test server that we use to do local smoke testing, it is not part of production code it is merely used as a convenience since developer laptops are not allowed to access outside services like NextGate.

This is only meant to be deployed to a local running Fabric, please do not put this in production and do not add it as a dependency to other test projects. If you need NextGate services in your unit test, use one of the stubs already provided or simply re-implement the interface for your specific needs.

~~~

For this project we deploy this locally to test our service end-to-end. The outbound project calls this project and will not work without this up. It is automatically built and deployed as part of the customer demo project.

We have only implemented the first method in the src/main/java/com/company/app/test/PersonEJBImpl.java file. Currently is just logs information to verify it received data and then returns a match code based on if the first name is "First" or not. This is common practice to hard code the response based on a known sent value for a test server, rather than setting up an actual database backend to search as part of the service. If we had implemented an add and remove and search function ourselves as part of the test server we could just use a hashmap to store the data for the life of the server and populate it with the test calls. However, since we only have match, we hard coded the values.

If you're clever you'll also notice that a few of the imports are not actually used and are instead embedded locally. This will be updated in the future, but it's enough to know for now that you SHOULD import artifacts.
