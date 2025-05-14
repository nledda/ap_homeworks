**Is your code an example of dependency injection?**

Yes, because dependency injection is a design pattern where an object receives its dependencies from an external source rather than creating them internally.
In this code:

The ShippingInfo object is created externally and injected into the Profile constructor.
The Profile object (with its injected dependency) is then injected into the Customer constructor.

This constructor-based dependency injection allows for greater flexibility, as the dependencies are created outside the class and passed in, rather than having each class instantiate its own dependencies.

**Does your code break the Law of Demeter? Why and how to fix it?**

Yes, this code breaks the Law of Demeter (principle of least knowledge). The Law of Demeter states that an object should only communicate with its immediate friends and not with "strangers" or objects it can reach through other objects.
In the EComController class, we have:
javacustomer.getProfile().getShippingInfo().getCity()
This chain of method calls violates the Law of Demeter because EComController is reaching through multiple objects to get to the city. It knows too much about the structure of other objects.
A possible fix would be to add a delegate method in the Customer class that hides the implementation details: