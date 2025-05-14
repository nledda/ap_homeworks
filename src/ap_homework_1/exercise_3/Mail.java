package exercise_3;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mail {
    private String sender;
    private String subject;
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;

    public Mail(String sender, String subject, String message, LocalDateTime timestamp){
        this.sender = sender;
        this.subject = subject;
        this.message = message;
        this.timestamp = timestamp;
        this.isRead = false;
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isRead() {
        return isRead;
    }
    public void setRead(boolean read) {
        this.isRead = read;
    }

    public void markAsRead() {
        this.isRead = true;
    }

    public void printMail(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = timestamp.format(formatter);
        System.out.println(subject + " from " + sender + " on " + formattedDateTime + ": " + message);
    }
    
}
