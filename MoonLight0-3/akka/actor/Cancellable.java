/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  scala.reflect.ScalaSignature
 */
package akka.actor;

import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001]1q!\u0001\u0002\u0011\u0002G\u0005qAA\u0006DC:\u001cW\r\u001c7bE2,'BA\u0002\u0005\u0003\u0015\t7\r^8s\u0015\u0005)\u0011\u0001B1lW\u0006\u001c\u0001a\u0005\u0002\u0001\u0011A\u0011\u0011\u0002D\u0007\u0002\u0015)\t1\"A\u0003tG\u0006d\u0017-\u0003\u0002\u000e\u0015\t1\u0011I\\=SK\u001aDQa\u0004\u0001\u0007\u0002A\taaY1oG\u0016dG#A\t\u0011\u0005%\u0011\u0012BA\n\u000b\u0005\u001d\u0011un\u001c7fC:DQ!\u0006\u0001\u0007\u0002Y\t1\"[:DC:\u001cW\r\u001c7fIV\t\u0011\u0003")
public interface Cancellable {
    public boolean cancel();

    public boolean isCancelled();
}

