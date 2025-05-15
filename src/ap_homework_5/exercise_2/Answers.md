**What generally happens if an exception is thrown but not caught?**

If an exception is thrown but not caught, the following happens:

- The method where the exception occurred terminates abnormally
- The exception propagates up the call stack
- If no method in the call stack catches the exception, the program terminates
- The JVM prints an error message and a stack trace to the console
- The stack trace shows the method call sequence that led to the exception
- Any resources that were not properly closed may remain open (causing potential memory leaks)


**Discuss the advantage of catching specific exceptions rather than just catching a general Exception**

Advantages of catching specific exceptions:

- Better error handling: Different exception types can be handled differently based on their nature
- Code clarity: Makes it clear which specific errors the code is prepared to handle
- Maintainability: Easier to modify specific exception handlers without affecting others
- Preventing unintended catches: Avoids accidentally catching exceptions you didn't intend to handle
- Granular recovery strategies: You can implement different recovery strategies for different exceptions
- Documentation: Specific catches act as documentation about what can go wrong
- Performance: Avoiding unnecessarily broad catch blocks can improve performance


**Explain when a try-with-resources should be used and what its advantages are**

Try-with-resources should be used when working with resources that need to be closed after use, such as:

- File streams
- Database connections
- Network connections
- Any resource that implements the AutoCloseable interface

**Advantages:** 

- **Automatic resource management: Resources are automatically closed when execution leaves the try block** -> größter Vorteil auch vom Übungsleiter hervorgehoben
- Concise code: Eliminates the need for explicit finally blocks
- Improved exception handling: If both the try block throws an exception and the close() method throws an exception, the exception from the try block is preserved and the exception from close() is suppressed
- No resource leaks: Even if an exception occurs, the resources will still be properly closed
- Maintenance: Reduces the risk of forgetting to close resources in complex code paths