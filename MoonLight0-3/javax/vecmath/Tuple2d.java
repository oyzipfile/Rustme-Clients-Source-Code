/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.VecMathUtil
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple2f;
import javax.vecmath.VecMathUtil;

public abstract class Tuple2d
implements Serializable,
Cloneable {
    static final long serialVersionUID = 6205762482756093838L;
    public double x;
    public double y;

    public Tuple2d(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public Tuple2d(double[] arrd) {
        this.x = arrd[0];
        this.y = arrd[1];
    }

    public Tuple2d(Tuple2d tuple2d) {
        this.x = tuple2d.x;
        this.y = tuple2d.y;
    }

    public Tuple2d(Tuple2f tuple2f) {
        this.x = tuple2f.x;
        this.y = tuple2f.y;
    }

    public Tuple2d() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public final void set(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public final void set(double[] arrd) {
        this.x = arrd[0];
        this.y = arrd[1];
    }

    public final void set(Tuple2d tuple2d) {
        this.x = tuple2d.x;
        this.y = tuple2d.y;
    }

    public final void set(Tuple2f tuple2f) {
        this.x = tuple2f.x;
        this.y = tuple2f.y;
    }

    public final void get(double[] arrd) {
        arrd[0] = this.x;
        arrd[1] = this.y;
    }

    public final void add(Tuple2d tuple2d, Tuple2d tuple2d2) {
        this.x = tuple2d.x + tuple2d2.x;
        this.y = tuple2d.y + tuple2d2.y;
    }

    public final void add(Tuple2d tuple2d) {
        this.x += tuple2d.x;
        this.y += tuple2d.y;
    }

    public final void sub(Tuple2d tuple2d, Tuple2d tuple2d2) {
        this.x = tuple2d.x - tuple2d2.x;
        this.y = tuple2d.y - tuple2d2.y;
    }

    public final void sub(Tuple2d tuple2d) {
        this.x -= tuple2d.x;
        this.y -= tuple2d.y;
    }

    public final void negate(Tuple2d tuple2d) {
        this.x = -tuple2d.x;
        this.y = -tuple2d.y;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public final void scale(double d, Tuple2d tuple2d) {
        this.x = d * tuple2d.x;
        this.y = d * tuple2d.y;
    }

    public final void scale(double d) {
        this.x *= d;
        this.y *= d;
    }

    public final void scaleAdd(double d, Tuple2d tuple2d, Tuple2d tuple2d2) {
        this.x = d * tuple2d.x + tuple2d2.x;
        this.y = d * tuple2d.y + tuple2d2.y;
    }

    public final void scaleAdd(double d, Tuple2d tuple2d) {
        this.x = d * this.x + tuple2d.x;
        this.y = d * this.y + tuple2d.y;
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + VecMathUtil.doubleToLongBits((double)this.x);
        l = 31L * l + VecMathUtil.doubleToLongBits((double)this.y);
        return (int)(l ^ l >> 32);
    }

    public boolean equals(Tuple2d tuple2d) {
        try {
            return this.x == tuple2d.x && this.y == tuple2d.y;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Tuple2d tuple2d = (Tuple2d)object;
            return this.x == tuple2d.x && this.y == tuple2d.y;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple2d tuple2d, double d) {
        double d2 = this.x - tuple2d.x;
        if (Double.isNaN(d2)) {
            return false;
        }
        double d3 = d2 < 0.0 ? -d2 : d2;
        if (d3 > d) {
            return false;
        }
        d2 = this.y - tuple2d.y;
        if (Double.isNaN(d2)) {
            return false;
        }
        double d4 = d2 < 0.0 ? -d2 : d2;
        return !(d4 > d);
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public final void clamp(double d, double d2, Tuple2d tuple2d) {
        this.x = tuple2d.x > d2 ? d2 : (tuple2d.x < d ? d : tuple2d.x);
        this.y = tuple2d.y > d2 ? d2 : (tuple2d.y < d ? d : tuple2d.y);
    }

    public final void clampMin(double d, Tuple2d tuple2d) {
        this.x = tuple2d.x < d ? d : tuple2d.x;
        this.y = tuple2d.y < d ? d : tuple2d.y;
    }

    public final void clampMax(double d, Tuple2d tuple2d) {
        this.x = tuple2d.x > d ? d : tuple2d.x;
        this.y = tuple2d.y > d ? d : tuple2d.y;
    }

    public final void absolute(Tuple2d tuple2d) {
        this.x = Math.abs(tuple2d.x);
        this.y = Math.abs(tuple2d.y);
    }

    public final void clamp(double d, double d2) {
        if (this.x > d2) {
            this.x = d2;
        } else if (this.x < d) {
            this.x = d;
        }
        if (this.y > d2) {
            this.y = d2;
        } else if (this.y < d) {
            this.y = d;
        }
    }

    public final void clampMin(double d) {
        if (this.x < d) {
            this.x = d;
        }
        if (this.y < d) {
            this.y = d;
        }
    }

    public final void clampMax(double d) {
        if (this.x > d) {
            this.x = d;
        }
        if (this.y > d) {
            this.y = d;
        }
    }

    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
    }

    public final void interpolate(Tuple2d tuple2d, Tuple2d tuple2d2, double d) {
        this.x = (1.0 - d) * tuple2d.x + d * tuple2d2.x;
        this.y = (1.0 - d) * tuple2d.y + d * tuple2d2.y;
    }

    public final void interpolate(Tuple2d tuple2d, double d) {
        this.x = (1.0 - d) * this.x + d * tuple2d.x;
        this.y = (1.0 - d) * this.y + d * tuple2d.y;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    public final double getX() {
        return this.x;
    }

    public final void setX(double d) {
        this.x = d;
    }

    public final double getY() {
        return this.y;
    }

    public final void setY(double d) {
        this.y = d;
    }
}

