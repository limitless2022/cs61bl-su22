package gh2;

import deque.ArrayDeque;
import deque.Deque;
import deque.LinkedListDeque;


//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate 采样率
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data.储存声音的数据 */
    private Deque<Double> buffer = new ArrayDeque<>();

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int capacity = (int) (SR / frequency);
        for (int i = 0;i < capacity; i++) {
            buffer.addFirst(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise.
     *通过用白噪声替换缓冲器来拨动吉他弦。 */
    public void pluck() {
        double r = Math.random() - 0.5;
        for (int i = 0;i < buffer.size(); i++) {
            buffer.removeFirst();
            buffer.addFirst(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     * 通过执行 Karplus-Strong 算法的一次迭代，将仿真推进一个时间步。
     */
    public void tic() {
        double first = buffer.removeFirst();
        double last = buffer.get(0);
        double newDouble = DECAY * 1.0 * (first + last);
        buffer.addLast(newDouble);

    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
