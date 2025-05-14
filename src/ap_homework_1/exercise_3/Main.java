package exercise_3;

public class Main {
    public static void main(String[] args) {
        Inbox myInbox = new Inbox();
        
        // Create some test emails
        Mail mail1 = new Mail("alice@example.com", "Hello", "Hi there, how are you?", 2025-04-13);
        Mail mail2 = new Mail("bob@example.com", "Meeting", "Don't forget our meeting tomorrow at 10am.", 2025-04-13);
        Mail mail3 = new Mail("charlie@example.com", "Project Update", "I've finished the code review.", 2025-04-13);
        
        // Add emails to inbox
        myInbox.receiveMail(mail1);
        myInbox.receiveMail(mail2);
        myInbox.receiveMail(mail3);
        
        // Display all emails
        myInbox.printAllHeaders();
        
        // Read an email
        myInbox.openMail(2);
        
        // Display inbox again to see read status changed
        System.out.println("\nAfter reading email #2:");
        myInbox.printAllHeaders();
    }
}
