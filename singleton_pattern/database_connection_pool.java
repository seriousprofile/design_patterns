public class ConnectionPool {
    private static ConnectionPool instance; 

    private ConnectionPool(){}


  // add the word synchronized to make it thread safe and only let one thread run in a multi threading environment.
    public static synchronized ConnectionPool getInstance(){ //should always be static and should return a ConnectionPool type!
        if(instance == null){
            try { //try this method first
                instance = new ConnectionPool();
            } catch (Exception e){ //..and if it didn't work, throw this error: 
                System.err.println("Failed to create connection pool: " + e.getMessage());
            }
        }
        return instance; 
    }

    public void printConnectionStatus(String msg){
        if(msg == null || msg.isEmpty()){
            System.err.println("The message cannot be empty!");
            return; 
        }
        System.out.println("Status is " + msg);
    }

}

public class Main {
    public static void main(String[] args){
        ConnectionPool conn1 = ConnectionPool.getInstance();
        ConnectionPool conn2 = ConnectionPool.getInstance();

        conn1.printConnectionStatus("Connection 1 worked!");
        conn2.printConnectionStatus("Connection 2 worked!");
    }
}
