1. Jede Klasse sollte nur eine Aufgabe haben
2. Das Programm ist erweiterbar, aber es muss nichts geändert werden, sondern man kann einfach etwas hinzufügen. 
3. Livkoz Principle: Jeder PayoutProvider kann ausgetauscht werden -> jede Unterklasse, kann an der Stelle ihrer Superklasse benutzt werden, ohne das die Funktionalität sich ändert.
4. Dependency Inversion Principle: CheckOutService ist nicht von einem Typ abhängig, sondern von dem Interface. Dadurch können verschiedene da eingesetzt werden ohne das eine Abhängigkeit entsteht. -> neue Art wie man Interfaces benutzen kann & alle Methoden vom Interface können genutzt werden. 
5. Interface Segragation Principle würde verletzt werden, wenn man die CreditCard Methoden implementiert.