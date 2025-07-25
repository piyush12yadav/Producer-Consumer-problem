public class MainClass {
    public static void main(String[] args) {   

    SharedResource sharedResource = new SharedResource(3);

    // creating the Producer Thread
    Thread producThread = new Thread(() ->{
        try{
            for(int i =0; i<=6; i++){
                sharedResource.produce(i);
            }
        }catch(Exception e){
            // handled the exception
            e.printStackTrace();

        }
    },"Producer-1");

    // Creating the Consumer Thread
    Thread consumerThread = new Thread(()->{
        try{
            for(int i=0; i<=6; i++){
                sharedResource.consume();
            }
        }catch(Exception e){
            e.printStackTrace();

            // handled the Exception
        }
    }, "Consumer-1");

    producThread.start();
    consumerThread.start();
    
    }
}
