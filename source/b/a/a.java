package b.a;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

public class a {
  static {
  
  }
  
  public static boolean a(d paramd, ByteChannel paramByteChannel) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Ljava/util/concurrent/BlockingQueue;
    //   4: invokeinterface peek : ()Ljava/lang/Object;
    //   9: checkcast java/nio/ByteBuffer
    //   12: astore #4
    //   14: iconst_0
    //   15: istore_2
    //   16: aload #4
    //   18: astore_3
    //   19: aload #4
    //   21: ifnonnull -> 63
    //   24: aload_1
    //   25: instanceof b/a/f
    //   28: ifeq -> 112
    //   31: aload_1
    //   32: checkcast b/a/f
    //   35: astore #4
    //   37: aload #4
    //   39: astore_3
    //   40: aload #4
    //   42: invokeinterface b : ()Z
    //   47: ifeq -> 114
    //   50: aload #4
    //   52: invokeinterface a : ()V
    //   57: aload #4
    //   59: astore_3
    //   60: goto -> 114
    //   63: aload_1
    //   64: aload_3
    //   65: invokeinterface write : (Ljava/nio/ByteBuffer;)I
    //   70: pop
    //   71: aload_3
    //   72: invokevirtual remaining : ()I
    //   75: ifle -> 80
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: getfield c : Ljava/util/concurrent/BlockingQueue;
    //   84: invokeinterface poll : ()Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: getfield c : Ljava/util/concurrent/BlockingQueue;
    //   94: invokeinterface peek : ()Ljava/lang/Object;
    //   99: checkcast java/nio/ByteBuffer
    //   102: astore #4
    //   104: aload #4
    //   106: astore_3
    //   107: aload #4
    //   109: ifnonnull -> 63
    //   112: aconst_null
    //   113: astore_3
    //   114: aload_0
    //   115: getfield c : Ljava/util/concurrent/BlockingQueue;
    //   118: invokeinterface isEmpty : ()Z
    //   123: ifeq -> 149
    //   126: aload_0
    //   127: invokevirtual f : ()Z
    //   130: ifeq -> 149
    //   133: aload_0
    //   134: monitorenter
    //   135: aload_0
    //   136: invokevirtual c : ()V
    //   139: aload_0
    //   140: monitorexit
    //   141: goto -> 149
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    //   149: aload_3
    //   150: ifnull -> 165
    //   153: aload_1
    //   154: checkcast b/a/f
    //   157: invokeinterface b : ()Z
    //   162: ifne -> 167
    //   165: iconst_1
    //   166: istore_2
    //   167: iload_2
    //   168: ireturn
    // Exception table:
    //   from	to	target	type
    //   135	141	144	finally
    //   145	147	144	finally
  }
  
  public static boolean a(ByteBuffer paramByteBuffer, d paramd, f paramf) {
    paramByteBuffer.clear();
    int i = paramf.a(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == -1) {
      paramd.d();
      return false;
    } 
    return paramf.c();
  }
  
  public static boolean a(ByteBuffer paramByteBuffer, d paramd, ByteChannel paramByteChannel) {
    paramByteBuffer.clear();
    int i = paramByteChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    boolean bool = false;
    if (i == -1) {
      paramd.d();
      return false;
    } 
    if (i != 0)
      bool = true; 
    return bool;
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */