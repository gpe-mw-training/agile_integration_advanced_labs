Contains the core business logic of the application and top-level concerns of the application only.

Should be free of resource and component code tied with different technology stacks. 

Use code Annotations and maven+spring dependency injection to tie in or bind processors, services, components, resources.  

~~~

This project starts a REST server at http://127.0.0.1:9098 and exposes our service at /cxf/demos/ with the only method being 'match'. The REST service processes the message by sending it to our first Camel route. The first route reads a header and directs the message based on the header, here it only sends it to the 'match' route because it is all we have implemented. It would be trival to add more methods though.

The 'match' route marshalls the data and puts it in a queue. For the sake of the demo the route is set to operate synchronously, so we set the pattern to InOut. In other words we want Camel to set up a return transport and request a response for us. This simple pattern can be set at the beginng of the route with the InOut component, or by setting the pattern=InOut on the 'to' componenet (see the xlate route for this example).

If you would like to see how the route could function synchronously, just comment out the last line and uncomment the final section in src/main/resources/META-INF/spring/camelContext.xml. It sends the message off and immediately responds to the caller. If you run the SoapUI tests you should just see done in the Comment section instead of a Match or No Match response. This is because it immediately responds before the data is finished being processed. This allows us to process data faster and to continue to receive data when backend services are down. If you want to verify that the data made it to the backend, for this demo at least, you'll have to check the logs in the Fuse container.

The main logic for the REST service can be found in the src/main/java/com/redhat/usecase/service/impl/DEIMServiceImpl.java file. We receive the message, build a response, send the message to the Camel route and then set the response based on the code returned to us. Finally we send the response back to the caller. If you're feeling brave, you can modify this to send back differnt messages or codes.
