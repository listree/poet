package com.cook.javastuff;

import java.lang.ref.*;

public class LangRef {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("JavaReferences was recycled");
    }

    public static void main(String[] args) {

        // Ref: https://programs.team/strong-reference-soft-reference-weak-reference-and-virtual-reference.html

        // As long as an object has a strong reference associated with it, the object will never be recycled.
        // Even if the memory is insufficient, the JVM would rather throw OOM than recycle it.
        LangRef strong = new LangRef();
        strong = null;
        System.gc(); // will call finalize

        // When the memory is insufficient, the JVM GC will be triggered. If the memory is still insufficient after GC,
        // the wrapped object of soft reference will be killed, that is, the JVM will recycle the object only when the memory is insufficient.
        // e.g. java -Xmx20M
        SoftReference<byte[]> softReference = new SoftReference<byte[]>(new byte[1024*1024*10]);
        System.out.println(softReference.get()); // not null
        System.gc();
        System.out.println(softReference.get()); // not null
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(softReference.get()); // recycled to be null


        // weak references is that no matter whether the memory is sufficient or not, they will be recycled whenever GC occurs:
        WeakReference<byte[]> weakReference = new WeakReference<byte[]>(new byte[1]);
        System.out.println(weakReference.get()); // \
        System.gc();
        System.out.println(weakReference.get()); // recycled to be nothing

        // What's the use of virtual references? In NIO, virtual reference is used to manage off heap memory
        // https://www.logicbig.com/tutorials/core-java-tutorial/gc/phantom-reference.html
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<byte[]> reference = new PhantomReference<byte[]>(new byte[1], queue);
        System.out.println(reference.get());
    }

}
