public class ModCounter {

    private int myCount;
    private int myN;
    public ModCounter(int n) {
        myCount = 0;
        myN = n;
    }

    public void increment() {
        if (myCount < myN) {
            myCount++;
        } else {
            myCount = 0;

        }
    }

    public void reset() {
        myCount = 0;
    }

    public int value() {
        return myCount;
    }

}
