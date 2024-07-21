# Spring MVC

Spring MVC  is best known for designing Dynamic web applications.  

**Steps**  
1. Frist **Request** will be received by the **DispatcherServlet**.
2. **DispatcherServlet** will take the help  of **Handler Mapping** and get to know the **Controller** class name associated with the given **Request**.
3. **Request** transfer to the **Controller**, and then **Controller** will process the **Request** by executing appropriate methods and returns **ModeAndView** object (contains Model data and View name) back to the **DispatcherServlet**.
4. Now **DispatcherServlet** send the model object to the **View Resolver** to get the actual **view page**.
5. Finally **DispatcherServlet** will pass the **Model object** to the **View Page** to display the result/response.
