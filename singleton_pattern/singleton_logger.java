public class Logger {
    //ANOTHER NOTE: to just simplify this entire thing, most devs use : private static final Logger INSTANCE = new Logger();
    // i only coded the harder way to get a better understanding of how thread safe implementations work :)
    private static volatile Logger instance;  //volatile checks the latest value to avoid starting when only half the object is built (thread safe)

    
    // why we dont just say "public static synchronized Logger getInstsance() is because it will lock the entire class up. why not just lock the risky part?"
    public static Logger getInstance(){
        if(instance == null){
            synchronized(Logger.class){ //KEY DIFFERENCE: Logger.class refers to locking the ENTIRE class. "this" refers to only one object of a class.
                if(instance == null){ //double check again. because if thread A and B are null -> A enters synchronized -> creates Logger
                    // B waits -> B enters synchronized -> creates Logger because it didn't check if the other thread has already created 
                    // the instance or not. 
                    instance = new Logger();
                }
            }
        }
        return instance; 
    }

    public void log(String msg){
        System.out.println(msg);    
    }
}

public class Main {
    public static void main(String[] args){
        Logger l1 = Logger.getInstance();
    }
}
