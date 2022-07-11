package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; //1
    /*白键：qwerty\zxcv;黑键：12345\asdf;*/

    public static void main(String[] args) {
        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new GuitarString(440.0 * Math.pow(2.0, (i - 24.0) / 12.0));
        }
        while (true) {

            /* 键入的值对应的频率*/
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(String.valueOf(key)); //2 String.valueOf()
                if (index != -1) { // != -1
                    strings[index].pluck();
                } else {
                    continue;
                }
            }
            /*3 计算样本的叠加*/
            double sample = 0;
            for (GuitarString i : strings) {
                sample +=i.sample();
            }

            StdAudio.play(sample);
            /*将每根吉他弦的模拟提前一步*/
            for(GuitarString i : strings) {
                i.tic();
            }
        }
    }

}
