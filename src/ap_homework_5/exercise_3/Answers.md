**b) Which variant makes more sense for the calculator case?**

Variant 2 (letting the caller handle the exception) makes more sense in this case for several reasons:

It's better to handle the code closer to the error source. 
If you handle it in the method this simplifies the code of the caller. 

On the other hand it would be possible to handle it differently in different contexts. Then it would be more useful
to let the caller handle the exception and handle it based on the context.

**c) An example where the other variant (handling exceptions within the method) makes more sense:**


An example where handling exceptions internally (Variant 1) would make more sense is a utility method in a library that needs to be robust and shouldn't interrupt program flow for common/expected error conditions.
For instance, a parsing method that converts string values to numbers might internally handle format exceptions:
javapublic static int parseIntSafely(String str, int defaultValue) {
try {
return Integer.parseInt(str);
} catch (NumberFormatException e) {
return defaultValue;
}
}
This makes sense because:

The method clearly communicates through its name that it's a "safe" operation.
It provides a default value parameter, making it explicit that error handling is happening.
The exception is an expected part of normal operation, not an exceptional condition.
The caller might be working with many strings and doesn't want to wrap each parse in a try-catch.
Parsing failures are common and expected when dealing with user input

In summary, internal exception handling makes sense when:

- The exception is part of normal operation
- The recovery strategy is clear and limited
- The method's contract includes handling errors
- The error handling is a core part of the functionality the method provides

Im Logger sollte man niemals Fehler hochreichen, weil der Programmfluss nicht unterbrochen werden sollte. 
Das sollte dann lieber intern gehandelt werden. 

Financial Calculation -> da will man den Fehler dann unbedingt weiterreichen, damit der Caller dann entscheiden muss
wie die Calculation behandelt werden muss, um die Nachvollziehbarkeit zu erhöhen. 

UncheckedExceptions sind meistens Programmierfehler, CheckedExceptions sind eher Eingabefehler
-> ArrayOutOfBounds; NullPointerException

CheckedException müssen gewrofen werden und gehandelt werden
RunTime nicht, man versucht aber über DefenseProgramming die zu vermeiden
> aber man kann keine Errors werfen
> 