public class Logger { 
    private static Logger instance; //this is a private static variable which means it cannot be called outside and can only be called within the Logger class. 

    private Logger(){} //constructor prevents it from getting declared outside the class. 

    public static Logger getInstance(){ 
        if(instance == null){
            instance = new Logger(); //creates a new object in case the instance is null.
        }
        return instance; 
    }

    public void log(String message){ //method for printing a message.
        System.out.println(message);

    }
}

//main class: 
public class Main {
    public static void main(String[] args){
        Logger l1 = Logger.getInstance(); // you cannot just do "Logger l1 = new Logger(); because the constructor is private!! use the getInstance() method to access it.
      //this is because the getInstance() method is a part of the class which makes it the only way to create a Logger object. 
        Logger l2 = Logger.getInstance();

        l1.log("ts my first log oat");
        l2.log("ts my second log oat");

        System.out.println(l1 == l2); //this should print true! why? because every getInstance() method points to the same object stored in instance, which makes them the same. 
    }
}
