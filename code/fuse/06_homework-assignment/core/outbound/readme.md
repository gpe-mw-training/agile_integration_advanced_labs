Contains the core business logic of the application and top-level concerns of the application only.

Should be free of resource and component code tied with different technology stacks. 

Use code Annotations and maven+spring dependency injection to tie in or bind processors, services, components, resources.  

~~~

This code simply takes the message off of the outbound queue from AMQ and sends the message to the integration-test-server. It then returns just the response code.
