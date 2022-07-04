/**
 * A class that represents a measurement in feet and inches. The measurement
 * should be _well-formed_, that is, the number of inches should not be >= 12.
 * 表示以英尺feet和英寸inches为单位的测量值的类。 测量格式应正确，即英寸数不应 >= 12。
 */
public class Measurement { //test

    /**
     * Constructor: initialize this object to be a measurement of 0 feet, 0
     * inches 构造器：初始化object to 测量0英寸
     */
    private int foot;
    private int inch;
    public Measurement() {
        foot = 0;
        inch = 0;

    }

    /**
     * Constructor: takes a number of feet as its single argument, using 0 as
     * the number of inches
     * 构造函数：将英尺数作为它的单个参数，使用 0 作为英寸数
     */
    public Measurement(int feet) {
        foot = feet ;
        inch = 0;

    }

    /**
     * Constructor: takes the number of feet in the measurement and the number
     * of inches as arguments (in that order), and does the appropriate
     * initialization
     * 构造函数：将测量中的英尺数和英寸数作为参数（按此顺序），并进行适当的初始化
     */
    public Measurement(int feet, int inches) {
        int total = feet*12 + inches;
        foot = total/12;
        inch = total%12;
    }

    /**
     * Returns the number of feet in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 1.
     * 返回此测量中的英尺数。 例如，如果测量值为 1 英尺和 6 英寸，则此方法应返回 1。
     */
    public int getFeet() {
        return this.foot;
    }

    /**
     * Returns the number of inches in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 6.
     * 返回此测量中的英寸数。 例如，如果测量值为 1 英尺和 6 英寸，则此方法应返回 6。
     */
    public int getInches() {
        return this.inch; // provided to allow the file to compile
    }

    /**
     * Adds the argument m2 to the current measurement.
     * 将参数 m2 添加到当前测量值。
     * @param m2 - Measurement to add. Should not change.
     * 要添加的测量。 不应该改变。
     * @return a new Measurement containing the sum of this and m2.
     *
     */
    public Measurement plus(Measurement m2) {
           Measurement ans = new Measurement(0);
           int total1 = this.getFeet()*12 + this.getInches();
           int total2 = m2.getFeet()*12 + m2.getInches();

           ans.foot = (total1 + total2) / 12;
           ans.inch = (total1 + total2) % 12;
           return ans;
    }

    /**
     * Subtracts the argument m2 from the current measurement. You may assume
     * that m2 will always be smaller than the current measurement.
     * 从当前测量值中减去参数 m2。 您可以假设 m2 总是小于当前测量值。
     * @param m2 - Measurement to subtract. Should not change.
     * @return a new Measurement containing the difference of this and m2.
     */
    public Measurement minus(Measurement m2) {
        Measurement ans = new Measurement(0);
        int total1 = this.getFeet() * 12 + this.getInches();
        int total2 = m2.getFeet() * 12 + m2.getInches();

        ans.foot = (total1 - total2) / 12;
        ans.inch = (total1 - total2) % 12;
        return ans;
    }

    /**
     * Returns a new Measurement that is the current measurement multiplied by
     * n. For example, if this object represents a measurement of 7 inches,
     * this.multiple(3) should return an object that represents 1 foot,
     * 9 inches (which totals to 21 inches).
     * 返回一个新的测量值，它是当前测量值乘以 n。 例如，如果这个对象代表 7 英寸的测量值，this.multiple(3) 应该返回一个代表 1 英尺，9 英寸（总计 21 英寸）的对象。
     * The current measurement should not change.
     *
     * @return a new Measurement containing this times multipleAmount
     */
    public Measurement multiple(int multipleAmount) {
        Measurement ans = new Measurement(0);
        int total = this.getFeet()*12 + this.getInches();
        total *=multipleAmount;

        ans.foot = total / 12;
        ans.inch = total%12;
        return ans;
    }

    /**
     * Returns the String representation of this object in the form:
     *      f'i"
     * In other words, th number of feet followed by a single quote followed
     * by the number of inches less than 12 followed by a double quote (with no
     * blanks).
     *以以下形式返回此对象的字符串表示形式：
     *       * f'i"
     *       * 换句话说，第 th 英尺后跟一个单引号
     *       * 小于 12 的英寸数后跟双引号（没有
     *       * 空格）。
     * For example, 0 foot 2 inches is formatted as 0'2"
     */
    @Override
    public String toString() {
        Measurement tep = this.multiple(1);
        return tep.foot+"'"+tep.inch+"\""; // provided to allow the file to compile
    }

}