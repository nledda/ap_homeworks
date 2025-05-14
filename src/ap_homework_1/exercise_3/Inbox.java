package exercise_3;

import java.util.ArrayList;

public class Inbox {
    /*
    private Mail[] mails; 
    private final int MAX_MAILS = 100;

    public Inbox() {
        mails = new Mail[MAX_MAILS];
        // mailCount = 0;
    }
    */
    private Mail[] mails;
    private int mailCount;
    private final int MAX_MAILS = 100; // Maximum number of mails inbox can hold
    
    // Constructor
    public Inbox() {
        mails = new Mail[MAX_MAILS];
        mailCount = 0;
    }

    public boolean receiveMail(Mail mail) {
        if (mailCount < MAX_MAILS) {
            mails[mailCount] = mail;
            mailCount++;
            return true;
        } else {
            System.out.println("Inbox is full!");
            return false;
        }
    }


    public int countUnread(){
        int counter = 0;
        for(int i = 0; i<= mails.length; i++){
            if(!mails[i].isRead()) {
                counter++;
            }   
        }

        return counter;
    }


    public void printAllHeaders(){
        for(int i = 0; i<= mails.length; i++){
            printHeader(i);
        }
    }

    public void printHeader(int i){
        String readStatus;

        if(mails[i].isRead()){
            readStatus = "Read";
        }else{
            readStatus = "Read";
        }

        System.out.println(readStatus + " | " + mails[i].getSubject()+ " | " + mails[i].getSender()+ " | " + mails[i].getTimestamp());
    }

    public void openMail(int i){

        if(mails.length >= 0 && mails.length<=i){
            printHeader(i);
            System.out.println(mails[i].getMessage());
        }

    }
    
}
