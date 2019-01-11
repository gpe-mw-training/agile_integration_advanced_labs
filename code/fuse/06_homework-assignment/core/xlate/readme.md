Contains the core business logic of the application and top-level concerns of the application only.

Should be free of resource and component code tied with different technology stacks. 

Use code Annotations and maven+spring dependency injection to tie in or bind processors, services, components, resources.  

~~~

This project takes the person request from the broker and converts it to our Java Person object. We print it so we know we have everything. Then we convert it to the NextGate format we need. Finally we send the message that is ready for dilvery back to the broker so the outbound route can send it.

The logic for the transformer is all in src/main/java/com/redhat/customer/translate/TransformToExecuteMatch.java

Notice we set a few things ourselves, and others we pull out of the object. You could add more fields here if you wanted to. The Person file in the src/test/data directory is an example complete Person object will all of the fields. The SimplePerson file is just what we are using for this demo. It is what the converted rest fields should look like for the Match test.
