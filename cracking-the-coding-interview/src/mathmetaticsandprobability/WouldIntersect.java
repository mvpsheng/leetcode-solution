package mathmetaticsandprobability;

/**
 * FileName: WouldIntersect
 * author: gxs
 * Date: 2022/1/22  10:04
 */
/* give two lines on a Cartesian plane, determine whether the two lines would intersect */
class Line {
    static double epsilon = 0.0000001;
    public double slope;
    public double yintercept;

    public Line(double s, double y) {
        this.slope = s;
        this.yintercept = y;
    }

    public boolean Intersect(Line line2) {
        return Math.abs(this.slope - line2.slope) > epsilon ||
                Math.abs(this.yintercept - line2.yintercept) < epsilon;
    }
}
public class WouldIntersect {

}
