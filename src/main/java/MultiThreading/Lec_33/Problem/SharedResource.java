package MultiThreading.Lec_33.Problem;

public class SharedResource {

    int counter;

    public void increment() {
        // not atomic
        // step 1: load "counter" value from memory
        // step 2: increment by 1 i.e. "counter + 1"
        // step 3: assign back i.e. counter = "counter + 1"
        counter = counter + 1;
    }

    public int getCounter() {
        return counter;
    }
}
