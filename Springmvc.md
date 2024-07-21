# Spring MVC

Spring MVC  is best known for designing Dynamic web applications.  

**Steps**  
1. Frist **Request** will be received by the **DispatcherServlet**.
2. **DispatcherServlet** will take the help  of **Handler Mapping** and get to know the **Controller** class name associated with the given **Request**.
3. **Request** transfer to the **Controller**, and then **Controller** will process the **Request** by executing appropriate methods and returns **ModeAndView** object (contains Model data and View name) back to the **DispatcherServlet**.
4. Now **DispatcherServlet** send the model object to the **View Resolver** to get the actual **view page**.
5. Finally **DispatcherServlet** will pass the **Model object** to the **View Page** to display the result/response.


# @Controller
* The **@Controller** annotation indicates that a particular class serves the role of a controller.
* Spring does not require you to extend any controller base class or reference the Servlet API.
* The **@Controller** annatation acts as a stereotype for the annotated class, indications its role.
* The dispatcher scans such annotated class for mapped methods and detects **@RequestMapping** annotation.
* You can define annotated controller beans explicitly, using a standard Spring bean definition in the dispatcher's context.
* **```<context:component-scan base-package="com.eage"/>```**
