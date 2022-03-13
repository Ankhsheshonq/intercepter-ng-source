package b.a;

import b.a.g.a;
import b.a.g.b;
import b.a.g.c;
import b.a.g.d;
import b.a.g.e;
import b.a.h.a;
import b.a.h.b;
import b.a.h.d;
import b.a.h.g;
import b.a.i.a;
import b.a.i.d;
import b.a.j.a;
import b.a.j.f;
import b.a.j.h;
import b.a.j.i;
import b.a.k.b;
import b.a.l.b;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class d implements b {
  public static int r = 16384;
  
  public static boolean s = false;
  
  public static final List<a> t;
  
  public SelectionKey a;
  
  public ByteChannel b;
  
  public final BlockingQueue<ByteBuffer> c;
  
  public final BlockingQueue<ByteBuffer> d;
  
  public volatile b.b e;
  
  private volatile boolean f = false;
  
  private b.a g = b.a.a;
  
  private final e h;
  
  private List<a> i;
  
  private a j = null;
  
  private b.b k;
  
  private d.a l = null;
  
  private ByteBuffer m;
  
  private a n = null;
  
  private String o = null;
  
  private Integer p = null;
  
  private Boolean q = null;
  
  static {
    ArrayList<a> arrayList = new ArrayList(4);
    t = arrayList;
    arrayList.add(new c());
    t.add(new b());
    t.add(new e());
    t.add(new d());
  }
  
  public d(e parame, a parama) {
    if (parame != null && (parama != null || this.k != b.b.b)) {
      this.c = new LinkedBlockingQueue<ByteBuffer>();
      this.d = new LinkedBlockingQueue<ByteBuffer>();
      this.h = parame;
      this.k = b.b.a;
      if (parama != null)
        this.j = parama.a(); 
      return;
    } 
    throw new IllegalArgumentException("parameters must not be null");
  }
  
  public d(e parame, List<a> paramList) {
    this(parame, (a)null);
    this.k = b.b.b;
    if (paramList == null || paramList.isEmpty()) {
      this.i = t;
      return;
    } 
    this.i = paramList;
  }
  
  private void a(f paramf) {
    if (s) {
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("open using draft: ");
      stringBuilder.append(this.j.getClass().getSimpleName());
      printStream.println(stringBuilder.toString());
    } 
    this.g = b.a.c;
    try {
      this.h.a(this, paramf);
      return;
    } catch (RuntimeException runtimeException) {
      this.h.a(this, runtimeException);
      return;
    } 
  }
  
  private void a(Collection<d> paramCollection) {
    if (g()) {
      Iterator<d> iterator = paramCollection.iterator();
      while (iterator.hasNext())
        a(iterator.next()); 
      return;
    } 
    g g = new g();
    throw g;
  }
  
  private void a(List<ByteBuffer> paramList) {
    Iterator<ByteBuffer> iterator = paramList.iterator();
    while (iterator.hasNext())
      e(iterator.next()); 
  }
  
  private void b(ByteBuffer paramByteBuffer) {
    if (this.f)
      return; 
    try {
      Iterator<d> iterator = this.j.a(paramByteBuffer).iterator();
      while (true) {
        e e1;
        if (iterator.hasNext()) {
          String str;
          d d1 = iterator.next();
          if (s) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("matched frame: ");
            stringBuilder.append(d1);
            printStream.println(stringBuilder.toString());
          } 
          if (this.f)
            return; 
          d.a a1 = d1.a();
          boolean bool = d1.e();
          if (a1 == d.a.f) {
            int i = 1005;
            str = "";
            if (d1 instanceof a) {
              a a2 = (a)d1;
              i = a2.c();
              str = a2.b();
            } 
            if (this.g == b.a.d) {
              a(i, str, true);
              continue;
            } 
            if (this.j.b() == a.a.c) {
              c(i, str, true);
              continue;
            } 
            b(i, str, false);
            continue;
          } 
          if (str == d.a.d) {
            this.h.a(this, d1);
            continue;
          } 
          if (str == d.a.e) {
            this.h.b(this, d1);
            continue;
          } 
          if (!bool || str == d.a.a) {
            if (str != d.a.a) {
              if (this.l == null) {
                this.l = (d.a)str;
              } else {
                throw new b(1002, "Previous continuous frame sequence not completed.");
              } 
            } else if (bool) {
              if (this.l != null) {
                this.l = null;
              } else {
                throw new b(1002, "Continuous frame sequence was not started.");
              } 
            } else {
              d.a a2 = this.l;
              if (a2 == null)
                throw new b(1002, "Continuous frame sequence was not started."); 
            } 
            try {
              this.h.c(this, d1);
              continue;
            } catch (RuntimeException null) {}
          } else if (this.l == null) {
            d.a a2 = d.a.b;
            if (runtimeException == a2) {
              try {
                this.h.a(this, b.a(d1.d()));
                continue;
              } catch (RuntimeException runtimeException1) {
                e1 = this.h;
              } 
            } else {
              a2 = d.a.c;
              if (runtimeException1 == a2) {
                try {
                  this.h.a(this, e1.d());
                  continue;
                } catch (RuntimeException runtimeException) {}
              } else {
                throw new b(1002, "non control or continious frame expected");
              } 
            } 
          } else {
            throw new b(1002, "Continuous frame sequence not completed.");
          } 
        } else {
          break;
        } 
        e1.a(this, runtimeException);
      } 
      return;
    } catch (b b1) {
      this.h.a(this, (Exception)b1);
      a(b1);
      return;
    } 
  }
  
  private void c(int paramInt, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Lb/a/b$a;
    //   4: astore #4
    //   6: aload #4
    //   8: getstatic b/a/b$a.d : Lb/a/b$a;
    //   11: if_acmpeq -> 199
    //   14: aload #4
    //   16: getstatic b/a/b$a.e : Lb/a/b$a;
    //   19: if_acmpeq -> 199
    //   22: aload #4
    //   24: getstatic b/a/b$a.c : Lb/a/b$a;
    //   27: if_acmpne -> 149
    //   30: iload_1
    //   31: sipush #1006
    //   34: if_icmpne -> 52
    //   37: aload_0
    //   38: getstatic b/a/b$a.d : Lb/a/b$a;
    //   41: putfield g : Lb/a/b$a;
    //   44: aload_0
    //   45: iload_1
    //   46: aload_2
    //   47: iconst_0
    //   48: invokevirtual b : (ILjava/lang/String;Z)V
    //   51: return
    //   52: aload_0
    //   53: getfield j : Lb/a/g/a;
    //   56: invokevirtual b : ()Lb/a/g/a$a;
    //   59: getstatic b/a/g/a$a.a : Lb/a/g/a$a;
    //   62: if_acmpeq -> 139
    //   65: iload_3
    //   66: ifne -> 98
    //   69: aload_0
    //   70: getfield h : Lb/a/e;
    //   73: aload_0
    //   74: iload_1
    //   75: aload_2
    //   76: invokeinterface a : (Lb/a/b;ILjava/lang/String;)V
    //   81: goto -> 98
    //   84: astore #4
    //   86: aload_0
    //   87: getfield h : Lb/a/e;
    //   90: aload_0
    //   91: aload #4
    //   93: invokeinterface a : (Lb/a/b;Ljava/lang/Exception;)V
    //   98: aload_0
    //   99: new b/a/i/b
    //   102: dup
    //   103: iload_1
    //   104: aload_2
    //   105: invokespecial <init> : (ILjava/lang/String;)V
    //   108: invokevirtual a : (Lb/a/i/d;)V
    //   111: goto -> 139
    //   114: astore #4
    //   116: aload_0
    //   117: getfield h : Lb/a/e;
    //   120: aload_0
    //   121: aload #4
    //   123: invokeinterface a : (Lb/a/b;Ljava/lang/Exception;)V
    //   128: aload_0
    //   129: sipush #1006
    //   132: ldc_w 'generated frame is invalid'
    //   135: iconst_0
    //   136: invokevirtual b : (ILjava/lang/String;Z)V
    //   139: aload_0
    //   140: iload_1
    //   141: aload_2
    //   142: iload_3
    //   143: invokevirtual b : (ILjava/lang/String;Z)V
    //   146: goto -> 173
    //   149: iload_1
    //   150: bipush #-3
    //   152: if_icmpne -> 166
    //   155: aload_0
    //   156: bipush #-3
    //   158: aload_2
    //   159: iconst_1
    //   160: invokevirtual b : (ILjava/lang/String;Z)V
    //   163: goto -> 173
    //   166: aload_0
    //   167: iconst_m1
    //   168: aload_2
    //   169: iconst_0
    //   170: invokevirtual b : (ILjava/lang/String;Z)V
    //   173: iload_1
    //   174: sipush #1002
    //   177: if_icmpne -> 187
    //   180: aload_0
    //   181: iload_1
    //   182: aload_2
    //   183: iload_3
    //   184: invokevirtual b : (ILjava/lang/String;Z)V
    //   187: aload_0
    //   188: getstatic b/a/b$a.d : Lb/a/b$a;
    //   191: putfield g : Lb/a/b$a;
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield m : Ljava/nio/ByteBuffer;
    //   199: return
    // Exception table:
    //   from	to	target	type
    //   69	81	84	java/lang/RuntimeException
    //   69	81	114	b/a/h/b
    //   86	98	114	b/a/h/b
    //   98	111	114	b/a/h/b
  }
  
  private boolean c(ByteBuffer paramByteBuffer) {
    ByteBuffer byteBuffer = this.m;
    if (byteBuffer == null) {
      byteBuffer = paramByteBuffer;
    } else {
      if (byteBuffer.remaining() < paramByteBuffer.remaining()) {
        byteBuffer = ByteBuffer.allocate(this.m.capacity() + paramByteBuffer.remaining());
        this.m.flip();
        byteBuffer.put(this.m);
        this.m = byteBuffer;
      } 
      this.m.put(paramByteBuffer);
      this.m.flip();
      byteBuffer = this.m;
    } 
    byteBuffer.mark();
    try {
      if (this.j == null && d(byteBuffer) == a.b.a) {
        e(ByteBuffer.wrap(b.b(this.h.a(this))));
        b(-3, "");
        return false;
      } 
      try {
        if (this.k == b.b.b) {
          a a2 = this.j;
          if (a2 == null) {
            Iterator<a> iterator = this.i.iterator();
            while (true) {
              if (iterator.hasNext()) {
                a a3 = ((a)iterator.next()).a();
                try {
                  a3.a(this.k);
                  byteBuffer.reset();
                  f f1 = a3.b(byteBuffer);
                  if (!(f1 instanceof a)) {
                    b(1002, "wrong http function", false);
                    return false;
                  } 
                  a a4 = (a)f1;
                  a.b b1 = a3.a(a4);
                  a.b b2 = a.b.a;
                  if (b1 == b2)
                    try {
                      i i = this.h.a(this, a3, a4);
                      a(a3.a((f)a3.a(a4, i), this.k));
                      this.j = a3;
                      a((f)a4);
                      return true;
                    } catch (b b3) {
                      b(b3.a(), b3.getMessage(), false);
                      return false;
                    } catch (RuntimeException runtimeException) {
                      this.h.a(this, runtimeException);
                      b(-1, runtimeException.getMessage(), false);
                      return false;
                    }  
                } catch (d d1) {}
                continue;
              } 
              if (this.j == null) {
                b(1002, "no draft matches");
                return false;
              } 
              return false;
            } 
          } 
          f f = this.j.b(byteBuffer);
          if (!(f instanceof a)) {
            b(1002, "wrong http function", false);
            return false;
          } 
          a a1 = (a)f;
          if (this.j.a(a1) == a.b.a) {
            a((f)a1);
            return true;
          } 
          b(1002, "the handshake did finaly not match");
          return false;
        } 
        if (this.k == b.b.a) {
          this.j.a(this.k);
          f f = this.j.b(byteBuffer);
          if (!(f instanceof h)) {
            b(1002, "Wwrong http function", false);
            return false;
          } 
          h h = (h)f;
          a.b b1 = this.j.a(this.n, h);
          a.b b2 = a.b.a;
          if (b1 == b2)
            try {
              this.h.a(this, this.n, h);
              a((f)h);
              return true;
            } catch (b b3) {
              b(b3.a(), b3.getMessage(), false);
              return false;
            } catch (RuntimeException runtimeException) {
              this.h.a(this, runtimeException);
              b(-1, runtimeException.getMessage(), false);
              return false;
            }  
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("draft ");
          stringBuilder.append(this.j);
          stringBuilder.append(" refuses handshake");
          b(1002, stringBuilder.toString());
          return false;
        } 
      } catch (d d1) {
        a((b)d1);
        return false;
      } 
    } catch (a a1) {
      ByteBuffer byteBuffer1 = this.m;
      if (byteBuffer1 == null) {
        byteBuffer.reset();
        int j = a1.a();
        int i = j;
        if (j == 0)
          i = byteBuffer.capacity() + 16; 
        byteBuffer = ByteBuffer.allocate(i);
        this.m = byteBuffer;
        byteBuffer.put(paramByteBuffer);
        return false;
      } 
      byteBuffer1.position(byteBuffer1.limit());
      paramByteBuffer = this.m;
      paramByteBuffer.limit(paramByteBuffer.capacity());
    } 
    return false;
  }
  
  private a.b d(ByteBuffer paramByteBuffer) {
    paramByteBuffer.mark();
    if (paramByteBuffer.limit() > a.c.length)
      return a.b.b; 
    if (paramByteBuffer.limit() >= a.c.length) {
      for (int i = 0; paramByteBuffer.hasRemaining(); i++) {
        if (a.c[i] != paramByteBuffer.get()) {
          paramByteBuffer.reset();
          return a.b.b;
        } 
      } 
      return a.b.a;
    } 
    a a1 = new a(a.c.length);
    throw a1;
  }
  
  private void e(ByteBuffer paramByteBuffer) {
    if (s) {
      String str;
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("write(");
      stringBuilder.append(paramByteBuffer.remaining());
      stringBuilder.append("): {");
      if (paramByteBuffer.remaining() > 1000) {
        str = "too big to display";
      } else {
        str = new String(paramByteBuffer.array());
      } 
      stringBuilder.append(str);
      stringBuilder.append("}");
      printStream.println(stringBuilder.toString());
    } 
    this.c.add(paramByteBuffer);
    this.h.c(this);
  }
  
  public InetSocketAddress a() {
    return this.h.d(this);
  }
  
  public void a(int paramInt) {
    c(paramInt, "", false);
  }
  
  public void a(int paramInt, String paramString) {
    a(paramInt, paramString, false);
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Lb/a/b$a;
    //   6: astore #4
    //   8: getstatic b/a/b$a.e : Lb/a/b$a;
    //   11: astore #5
    //   13: aload #4
    //   15: aload #5
    //   17: if_acmpne -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield a : Ljava/nio/channels/SelectionKey;
    //   27: ifnull -> 37
    //   30: aload_0
    //   31: getfield a : Ljava/nio/channels/SelectionKey;
    //   34: invokevirtual cancel : ()V
    //   37: aload_0
    //   38: getfield b : Ljava/nio/channels/ByteChannel;
    //   41: astore #4
    //   43: aload #4
    //   45: ifnull -> 74
    //   48: aload_0
    //   49: getfield b : Ljava/nio/channels/ByteChannel;
    //   52: invokeinterface close : ()V
    //   57: goto -> 74
    //   60: astore #4
    //   62: aload_0
    //   63: getfield h : Lb/a/e;
    //   66: aload_0
    //   67: aload #4
    //   69: invokeinterface a : (Lb/a/b;Ljava/lang/Exception;)V
    //   74: aload_0
    //   75: getfield h : Lb/a/e;
    //   78: aload_0
    //   79: iload_1
    //   80: aload_2
    //   81: iload_3
    //   82: invokeinterface a : (Lb/a/b;ILjava/lang/String;Z)V
    //   87: goto -> 102
    //   90: astore_2
    //   91: aload_0
    //   92: getfield h : Lb/a/e;
    //   95: aload_0
    //   96: aload_2
    //   97: invokeinterface a : (Lb/a/b;Ljava/lang/Exception;)V
    //   102: aload_0
    //   103: getfield j : Lb/a/g/a;
    //   106: ifnull -> 116
    //   109: aload_0
    //   110: getfield j : Lb/a/g/a;
    //   113: invokevirtual c : ()V
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield n : Lb/a/j/a;
    //   121: aload_0
    //   122: getstatic b/a/b$a.e : Lb/a/b$a;
    //   125: putfield g : Lb/a/b$a;
    //   128: aload_0
    //   129: getfield c : Ljava/util/concurrent/BlockingQueue;
    //   132: invokeinterface clear : ()V
    //   137: aload_0
    //   138: monitorexit
    //   139: return
    //   140: astore_2
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	140	finally
    //   23	37	140	finally
    //   37	43	140	finally
    //   48	57	60	java/io/IOException
    //   48	57	140	finally
    //   62	74	140	finally
    //   74	87	90	java/lang/RuntimeException
    //   74	87	140	finally
    //   91	102	140	finally
    //   102	116	140	finally
    //   116	137	140	finally
  }
  
  protected void a(int paramInt, boolean paramBoolean) {
    a(paramInt, "", paramBoolean);
  }
  
  public void a(b paramb) {
    c(paramb.a(), paramb.getMessage(), false);
  }
  
  public void a(d paramd) {
    if (s) {
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("send frame: ");
      stringBuilder.append(paramd);
      printStream.println(stringBuilder.toString());
    } 
    e(this.j.a(paramd));
  }
  
  public void a(String paramString) {
    if (paramString != null) {
      boolean bool;
      a a1 = this.j;
      if (this.k == b.b.a) {
        bool = true;
      } else {
        bool = false;
      } 
      a(a1.a(paramString, bool));
      return;
    } 
    throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
  }
  
  public void a(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.hasRemaining()) {
      if (this.f)
        return; 
      if (s) {
        String str;
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("process(");
        stringBuilder.append(paramByteBuffer.remaining());
        stringBuilder.append("): {");
        if (paramByteBuffer.remaining() > 1000) {
          str = "too big to display";
        } else {
          str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
        } 
        stringBuilder.append(str);
        stringBuilder.append("}");
        printStream.println(stringBuilder.toString());
      } 
      if (this.g == b.a.c || c(paramByteBuffer)) {
        b(paramByteBuffer);
        return;
      } 
    } 
  }
  
  public InetSocketAddress b() {
    return this.h.b(this);
  }
  
  public void b(int paramInt, String paramString) {
    c(paramInt, paramString, false);
  }
  
  protected void b(int paramInt, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Z
    //   6: istore #4
    //   8: iload #4
    //   10: ifeq -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   21: putfield p : Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield o : Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   34: putfield q : Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield f : Z
    //   42: aload_0
    //   43: getfield h : Lb/a/e;
    //   46: aload_0
    //   47: invokeinterface c : (Lb/a/b;)V
    //   52: aload_0
    //   53: getfield h : Lb/a/e;
    //   56: aload_0
    //   57: iload_1
    //   58: aload_2
    //   59: iload_3
    //   60: invokeinterface b : (Lb/a/b;ILjava/lang/String;Z)V
    //   65: goto -> 80
    //   68: astore_2
    //   69: aload_0
    //   70: getfield h : Lb/a/e;
    //   73: aload_0
    //   74: aload_2
    //   75: invokeinterface a : (Lb/a/b;Ljava/lang/Exception;)V
    //   80: aload_0
    //   81: getfield j : Lb/a/g/a;
    //   84: ifnull -> 94
    //   87: aload_0
    //   88: getfield j : Lb/a/g/a;
    //   91: invokevirtual c : ()V
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield n : Lb/a/j/a;
    //   99: aload_0
    //   100: monitorexit
    //   101: return
    //   102: astore_2
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	102	finally
    //   16	52	102	finally
    //   52	65	68	java/lang/RuntimeException
    //   52	65	102	finally
    //   69	80	102	finally
    //   80	94	102	finally
    //   94	99	102	finally
  }
  
  public void c() {
    if (this.q != null) {
      a(this.p.intValue(), this.o, this.q.booleanValue());
      return;
    } 
    throw new IllegalStateException("this method must be used in conjuction with flushAndClose");
  }
  
  public void d() {
    if (e() == b.a.a) {
      a(-1, true);
      return;
    } 
    if (this.f) {
      a(this.p.intValue(), this.o, this.q.booleanValue());
      return;
    } 
    if (this.j.b() != a.a.a && (this.j.b() != a.a.b || this.k == b.b.b)) {
      a(1006, true);
      return;
    } 
    a(1000, true);
  }
  
  public b.a e() {
    return this.g;
  }
  
  public boolean f() {
    return this.f;
  }
  
  public boolean g() {
    return (this.g == b.a.c);
  }
  
  public int hashCode() {
    return super.hashCode();
  }
  
  public String toString() {
    return super.toString();
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */