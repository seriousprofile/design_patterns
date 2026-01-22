
//base interface for one method 
interface Notification { 
    void send();
}

//concrete classes implementing the interface:
class emailNotification implements Notification{
    @Override 
    public void send(){
        System.out.println("Email has been sent");
    }
}

class SMSNotification implements Notification{
    @Override
    public void send(){
        System.out.println("SMS has been sent");
    }
}

// abstract class for letting concrete classes to create their own method:
abstract class NotificationApp {
    protected abstract Notification createNotification(); //this method states that the child classes can implement this method their own way.

    public void notifyUser(){
        Notification notification = createNotification(); 
        notification.send();
    }
}

//concrete classes:
class EmailApp extends NotificationApp{
    @Override
    protected Notification createNotification(){
        return new emailNotification();
    }
}

class SmsApp extends NotificationApp{
    @Override
    protected Notification createNotification(){
        return new SMSNotification();
    }
}

//main method: 
public class Main {
    public static void main(String[] args){
        NotificationApp emailApp = new EmailApp();
        emailApp.notifyUser();

        NotificationApp SmsApp = new smsApp();
        smsApp.notifyUser();
    }
}
