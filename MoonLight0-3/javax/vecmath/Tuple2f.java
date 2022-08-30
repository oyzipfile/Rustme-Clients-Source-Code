/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.VecMathUtil
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple2d;
import javax.vecmath.VecMathUtil;

public abstract class Tuple2f
implements Serializable,
Cloneable {
    static final long serialVersionUID = 9011180388985266884L;
    public float x;
    public float y;

    public Tuple2f(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public Tuple2f(float[] arrf) {
        this.x = arrf[0];
        this.y = arrf[1];
    }

    public Tuple2f(Tuple2f tuple2f) {
        this.x = tuple2f.x;
        this.y = tuple2f.y;
    }

    public Tuple2f(Tuple2d tuple2d) {
        this.x = (float)tuple2d.x;
        this.y = (float)tuple2d.y;
    }

    public Tuple2f() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public final void set(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public final void set(float[] arrf) {
        this.x = arrf[0];
        this.y = arrf[1];
    }

    public final void set(Tuple2f tuple2f) {
        this.x = tuple2f.x;
        this.y = tuple2f.y;
    }

    public final void set(Tuple2d tuple2d) {
        this.x = (float)tuple2d.x;
        this.y = (float)tuple2d.y;
    }

    public final void get(float[] arrf) {
        arrf[0] = this.x;
        arrf[1] = this.y;
    }

    public final void add(Tuple2f tuple2f, Tuple2f tuple2f2) {
        this.x = tuple2f.x + tuple2f2.x;
        this.y = tuple2f.y + tuple2f2.y;
    }

    public final void add(Tuple2f tuple2f) {
        this.x += tuple2f.x;
        this.y += tuple2f.y;
    }

    public final void sub(Tuple2f tuple2f, Tuple2f tuple2f2) {
        this.x = tuple2f.x - tuple2f2.x;
        this.y = tuple2f.y - tuple2f2.y;
    }

    public final void sub(Tuple2f tuple2f) {
        this.x -= tuple2f.x;
        this.y -= tuple2f.y;
    }

    public final void negate(Tuple2f tuple2f) {
        this.x = -tuple2f.x;
        this.y = -tuple2f.y;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public final void scale(float f, Tuple2f tuple2f) {
        this.x = f * tuple2f.x;
        this.y = f * tuple2f.y;
    }

    public final void scale(float f) {
        this.x *= f;
        this.y *= f;
    }

    public final void scaleAdd(float f, Tuple2f tuple2f, Tuple2f tuple2f2) {
        this.x = f * tuple2f.x + tuple2f2.x;
        this.y = f * tuple2f.y + tuple2f2.y;
    }

    public final void scaleAdd(float f, Tuple2f tuple2f) {
        this.x = f * this.x + tuple2f.x;
        this.y = f * this.y + tuple2f.y;
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + (long)VecMathUtil.floatToIntBits((float)this.x);
        l = 31L * l + (long)VecMathUtil.floatToIntBits((float)this.y);
        return (int)(l ^ l >> 32);
    }

    public boolean equals(Tuple2f tuple2f) {
        try {
            return this.x == tuple2f.x && this.y == tuple2f.y;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Tuple2f tuple2f = (Tuple2f)object;
            return this.x == tuple2f.x && this.y == tuple2f.y;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple2f tuple2f, float f) {
        float f2 = this.x - tuple2f.x;
        if (Float.isNaN(f2)) {
            return false;
        }
        float f3 = f2 < 0.0f ? -f2 : f2;
        if (f3 > f) {
            return false;
        }
        f2 = this.y - tuple2f.y;
        if (Float.isNaN(f2)) {
            return false;
        }
        float f4 = f2 < 0.0f ? -f2 : f2;
        return !(f4 > f);
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public final void clamp(float f, float f2, Tuple2f tuple2f) {
        this.x = tuple2f.x > f2 ? f2 : (tuple2f.x < f ? f : tuple2f.x);
        this.y = tuple2f.y > f2 ? f2 : (tuple2f.y < f ? f : tuple2f.y);
    }

    public final void clampMin(float f, Tuple2f tuple2f) {
        this.x = tuple2f.x < f ? f : tuple2f.x;
        this.y = tuple2f.y < f ? f : tuple2f.y;
    }

    public final void clampMax(float f, Tuple2f tuple2f) {
        this.x = tuple2f.x > f ? f : tuple2f.x;
        this.y = tuple2f.y > f ? f : tuple2f.y;
    }

    public final void absolute(Tuple2f tuple2f) {
        this.x = Math.abs(tuple2f.x);
        this.y = Math.abs(tuple2f.y);
    }

    public final void clamp(float f, float f2) {
        if (this.x > f2) {
            this.x = f2;
        } else if (this.x < f) {
            this.x = f;
        }
        if (this.y > f2) {
            this.y = f2;
        } else if (this.y < f) {
            this.y = f;
        }
    }

    public final void clampMin(float f) {
        if (this.x < f) {
            this.x = f;
        }
        if (this.y < f) {
            this.y = f;
        }
    }

    public final void clampMax(float f) {
        if (this.x > f) {
            this.x = f;
        }
        if (this.y > f) {
            this.y = f;
        }
    }

    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
    }

    public final void interpolate(Tuple2f tuple2f, Tuple2f tuple2f2, float f) {
        this.x = (1.0f - f) * tuple2f.x + f * tuple2f2.x;
        this.y = (1.0f - f) * tuple2f.y + f * tuple2f2.y;
    }

    public final void interpolate(Tuple2f tuple2f, float f) {
        this.x = (1.0f - f) * this.x + f * tuple2f.x;
        this.y = (1.0f - f) * this.y + f * tuple2f.y;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    public final float getX() {
        return this.x;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final float getY() {
        return this.y;
    }

    public final void setY(float f) {
        this.y = f;
    }
}

