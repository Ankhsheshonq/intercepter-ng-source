package b.a.k;

import b.a.c;
import b.a.d;
import b.a.j.f;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b extends c implements Runnable {
  public static int n = Runtime.getRuntime().availableProcessors();
  
  private final Collection<b.a.b> a;
  
  private final InetSocketAddress b;
  
  private ServerSocketChannel c;
  
  private Selector d;
  
  private List<b.a.g.a> e;
  
  private Thread f;
  
  private volatile AtomicBoolean g;
  
  private List<b> h;
  
  private List<d> i;
  
  private BlockingQueue<ByteBuffer> j;
  
  private int k;
  
  private AtomicInteger l;
  
  private a m;
  
  public b() {
    this(new InetSocketAddress(80), n, null);
  }
  
  public b(InetSocketAddress paramInetSocketAddress) {
    this(paramInetSocketAddress, n, null);
  }
  
  public b(InetSocketAddress paramInetSocketAddress, int paramInt, List<b.a.g.a> paramList) {
    this(paramInetSocketAddress, paramInt, paramList, new HashSet<b.a.b>());
  }
  
  public b(InetSocketAddress paramInetSocketAddress, int paramInt, List<b.a.g.a> paramList, Collection<b.a.b> paramCollection) {
    int i = 0;
    this.g = new AtomicBoolean(false);
    this.k = 0;
    this.l = new AtomicInteger(0);
    this.m = new a();
    if (paramInetSocketAddress != null && paramInt >= 1 && paramCollection != null) {
      List<b.a.g.a> list = paramList;
      if (paramList == null)
        list = Collections.emptyList(); 
      this.e = list;
      this.b = paramInetSocketAddress;
      this.a = paramCollection;
      this.i = new LinkedList<d>();
      this.h = new ArrayList<b>(paramInt);
      this.j = new LinkedBlockingQueue<ByteBuffer>();
      while (i < paramInt) {
        b b1 = new b(this);
        this.h.add(b1);
        b1.start();
        i++;
      } 
      return;
    } 
    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
    throw illegalArgumentException;
  }
  
  private void a(d paramd) {
    if (paramd.e == null) {
      List<b> list = this.h;
      paramd.e = list.get(this.k % list.size());
      this.k++;
    } 
    paramd.e.a(paramd);
  }
  
  private void a(ByteBuffer paramByteBuffer) {
    if (this.j.size() > this.l.intValue())
      return; 
    this.j.put(paramByteBuffer);
  }
  
  private void a(SelectionKey paramSelectionKey, b.a.b paramb, IOException paramIOException) {
    a(paramb, paramIOException);
    if (paramb != null) {
      paramb.a(1006, paramIOException.getMessage());
      return;
    } 
    if (paramSelectionKey != null) {
      SelectableChannel selectableChannel = paramSelectionKey.channel();
      if (selectableChannel != null && selectableChannel.isOpen()) {
        try {
          selectableChannel.close();
        } catch (IOException iOException) {}
        if (d.s) {
          PrintStream printStream = System.out;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Connection closed because of");
          stringBuilder.append(paramIOException);
          printStream.println(stringBuilder.toString());
        } 
      } 
    } 
  }
  
  private void c(b.a.b paramb, Exception paramException) {
    b(paramb, paramException);
    try {
      c();
      return;
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
    } 
    b((b.a.b)null, interruptedException);
  }
  
  private ByteBuffer d() {
    return this.j.take();
  }
  
  private Socket i(b.a.b paramb) {
    return ((SocketChannel)((d)paramb).a.channel()).socket();
  }
  
  public Collection<b.a.b> a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: iconst_0
    //   5: iconst_1
    //   6: invokevirtual compareAndSet : (ZZ)Z
    //   9: ifne -> 13
    //   12: return
    //   13: aload_0
    //   14: getfield a : Ljava/util/Collection;
    //   17: astore_2
    //   18: aload_2
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield a : Ljava/util/Collection;
    //   24: invokeinterface iterator : ()Ljava/util/Iterator;
    //   29: astore_3
    //   30: aload_3
    //   31: invokeinterface hasNext : ()Z
    //   36: ifeq -> 59
    //   39: aload_3
    //   40: invokeinterface next : ()Ljava/lang/Object;
    //   45: checkcast b/a/b
    //   48: sipush #1001
    //   51: invokeinterface a : (I)V
    //   56: goto -> 30
    //   59: aload_2
    //   60: monitorexit
    //   61: aload_0
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield f : Ljava/lang/Thread;
    //   67: ifnull -> 98
    //   70: invokestatic currentThread : ()Ljava/lang/Thread;
    //   73: pop
    //   74: aload_0
    //   75: getfield f : Ljava/lang/Thread;
    //   78: invokestatic currentThread : ()Ljava/lang/Thread;
    //   81: if_acmpeq -> 98
    //   84: aload_0
    //   85: getfield f : Ljava/lang/Thread;
    //   88: invokevirtual interrupt : ()V
    //   91: aload_0
    //   92: getfield f : Ljava/lang/Thread;
    //   95: invokevirtual join : ()V
    //   98: aload_0
    //   99: getfield h : Ljava/util/List;
    //   102: ifnull -> 139
    //   105: aload_0
    //   106: getfield h : Ljava/util/List;
    //   109: invokeinterface iterator : ()Ljava/util/Iterator;
    //   114: astore_2
    //   115: aload_2
    //   116: invokeinterface hasNext : ()Z
    //   121: ifeq -> 139
    //   124: aload_2
    //   125: invokeinterface next : ()Ljava/lang/Object;
    //   130: checkcast b/a/k/b$b
    //   133: invokevirtual interrupt : ()V
    //   136: goto -> 115
    //   139: aload_0
    //   140: getfield c : Ljava/nio/channels/ServerSocketChannel;
    //   143: ifnull -> 153
    //   146: aload_0
    //   147: getfield c : Ljava/nio/channels/ServerSocketChannel;
    //   150: invokevirtual close : ()V
    //   153: aload_0
    //   154: monitorexit
    //   155: return
    //   156: astore_2
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: astore_3
    //   162: aload_2
    //   163: monitorexit
    //   164: goto -> 169
    //   167: aload_3
    //   168: athrow
    //   169: goto -> 167
    // Exception table:
    //   from	to	target	type
    //   20	30	161	finally
    //   30	56	161	finally
    //   59	61	161	finally
    //   63	98	156	finally
    //   98	115	156	finally
    //   115	136	156	finally
    //   139	153	156	finally
    //   153	155	156	finally
    //   157	159	156	finally
    //   162	164	161	finally
  }
  
  public void a(b.a.b paramb, int paramInt, String paramString) {
    b(paramb, paramInt, paramString);
  }
  
  public final void a(b.a.b paramb, int paramInt, String paramString, boolean paramBoolean) {
    this.d.wakeup();
    try {
      if (h(paramb))
        c(paramb, paramInt, paramString, paramBoolean); 
      return;
    } finally {
      try {
        g((b.a.b)interruptedException);
      } catch (InterruptedException interruptedException1) {
        Thread.currentThread().interrupt();
      } 
    } 
  }
  
  public abstract void a(b.a.b paramb, b.a.j.a parama);
  
  public final void a(b.a.b paramb, f paramf) {
    if (e(paramb))
      a(paramb, (b.a.j.a)paramf); 
  }
  
  public final void a(b.a.b paramb, Exception paramException) {
    b(paramb, paramException);
  }
  
  public final void a(b.a.b paramb, String paramString) {
    b(paramb, paramString);
  }
  
  public final void a(b.a.b paramb, ByteBuffer paramByteBuffer) {
    b(paramb, paramByteBuffer);
  }
  
  protected boolean a(SelectionKey paramSelectionKey) {
    return true;
  }
  
  public InetSocketAddress b(b.a.b paramb) {
    return (InetSocketAddress)i(paramb).getRemoteSocketAddress();
  }
  
  public ByteBuffer b() {
    return ByteBuffer.allocate(d.r);
  }
  
  public void b(b.a.b paramb, int paramInt, String paramString) {}
  
  public void b(b.a.b paramb, int paramInt, String paramString, boolean paramBoolean) {
    d(paramb, paramInt, paramString, paramBoolean);
  }
  
  public abstract void b(b.a.b paramb, Exception paramException);
  
  public abstract void b(b.a.b paramb, String paramString);
  
  public void b(b.a.b paramb, ByteBuffer paramByteBuffer) {}
  
  public void c() {
    a(0);
  }
  
  public final void c(b.a.b paramb) {
    d d = (d)paramb;
    try {
      d.a.interestOps(5);
    } catch (CancelledKeyException cancelledKeyException) {
      d.c.clear();
    } 
    this.d.wakeup();
  }
  
  public abstract void c(b.a.b paramb, int paramInt, String paramString, boolean paramBoolean);
  
  public InetSocketAddress d(b.a.b paramb) {
    return (InetSocketAddress)i(paramb).getLocalSocketAddress();
  }
  
  public void d(b.a.b paramb, int paramInt, String paramString, boolean paramBoolean) {}
  
  protected boolean e(b.a.b paramb) {
    synchronized (this.a) {
      return this.a.add(paramb);
    } 
  }
  
  protected void f(b.a.b paramb) {
    if (this.l.get() >= this.h.size() * 2 + 1)
      return; 
    this.l.incrementAndGet();
    this.j.put(b());
  }
  
  protected void g(b.a.b paramb) {}
  
  protected boolean h(b.a.b paramb) {
    synchronized (this.a) {
      return this.a.remove(paramb);
    } 
  }
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Ljava/lang/Thread;
    //   6: ifnonnull -> 775
    //   9: aload_0
    //   10: invokestatic currentThread : ()Ljava/lang/Thread;
    //   13: putfield f : Ljava/lang/Thread;
    //   16: aload_0
    //   17: getfield g : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   20: invokevirtual get : ()Z
    //   23: ifeq -> 29
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_0
    //   32: getfield f : Ljava/lang/Thread;
    //   35: astore_2
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore_3
    //   44: aload_3
    //   45: ldc_w 'WebsocketSelector'
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_3
    //   53: aload_0
    //   54: getfield f : Ljava/lang/Thread;
    //   57: invokevirtual getId : ()J
    //   60: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: aload_3
    //   66: invokevirtual toString : ()Ljava/lang/String;
    //   69: invokevirtual setName : (Ljava/lang/String;)V
    //   72: invokestatic open : ()Ljava/nio/channels/ServerSocketChannel;
    //   75: astore_2
    //   76: aload_0
    //   77: aload_2
    //   78: putfield c : Ljava/nio/channels/ServerSocketChannel;
    //   81: aload_2
    //   82: iconst_0
    //   83: invokevirtual configureBlocking : (Z)Ljava/nio/channels/SelectableChannel;
    //   86: pop
    //   87: aload_0
    //   88: getfield c : Ljava/nio/channels/ServerSocketChannel;
    //   91: invokevirtual socket : ()Ljava/net/ServerSocket;
    //   94: astore_2
    //   95: aload_2
    //   96: getstatic b/a/d.r : I
    //   99: invokevirtual setReceiveBufferSize : (I)V
    //   102: aload_2
    //   103: aload_0
    //   104: getfield b : Ljava/net/InetSocketAddress;
    //   107: invokevirtual bind : (Ljava/net/SocketAddress;)V
    //   110: invokestatic open : ()Ljava/nio/channels/Selector;
    //   113: astore_2
    //   114: aload_0
    //   115: aload_2
    //   116: putfield d : Ljava/nio/channels/Selector;
    //   119: aload_0
    //   120: getfield c : Ljava/nio/channels/ServerSocketChannel;
    //   123: aload_2
    //   124: aload_0
    //   125: getfield c : Ljava/nio/channels/ServerSocketChannel;
    //   128: invokevirtual validOps : ()I
    //   131: invokevirtual register : (Ljava/nio/channels/Selector;I)Ljava/nio/channels/SelectionKey;
    //   134: pop
    //   135: aload_0
    //   136: getfield f : Ljava/lang/Thread;
    //   139: invokevirtual isInterrupted : ()Z
    //   142: istore_1
    //   143: iload_1
    //   144: ifne -> 766
    //   147: aload_0
    //   148: getfield d : Ljava/nio/channels/Selector;
    //   151: invokevirtual select : ()I
    //   154: pop
    //   155: aload_0
    //   156: getfield d : Ljava/nio/channels/Selector;
    //   159: invokevirtual selectedKeys : ()Ljava/util/Set;
    //   162: invokeinterface iterator : ()Ljava/util/Iterator;
    //   167: astore #6
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_3
    //   172: astore_2
    //   173: aload_2
    //   174: astore #5
    //   176: aload_2
    //   177: astore #4
    //   179: aload #6
    //   181: invokeinterface hasNext : ()Z
    //   186: ifeq -> 594
    //   189: aload_2
    //   190: astore #4
    //   192: aload #6
    //   194: invokeinterface next : ()Ljava/lang/Object;
    //   199: checkcast java/nio/channels/SelectionKey
    //   202: astore #5
    //   204: aload_2
    //   205: astore #4
    //   207: aload #5
    //   209: invokevirtual isValid : ()Z
    //   212: ifne -> 218
    //   215: goto -> 832
    //   218: aload_2
    //   219: astore #4
    //   221: aload #5
    //   223: invokevirtual isAcceptable : ()Z
    //   226: ifeq -> 368
    //   229: aload_2
    //   230: astore #4
    //   232: aload_0
    //   233: aload #5
    //   235: invokevirtual a : (Ljava/nio/channels/SelectionKey;)Z
    //   238: ifne -> 252
    //   241: aload_2
    //   242: astore #4
    //   244: aload #5
    //   246: invokevirtual cancel : ()V
    //   249: goto -> 832
    //   252: aload_2
    //   253: astore #4
    //   255: aload_0
    //   256: getfield c : Ljava/nio/channels/ServerSocketChannel;
    //   259: invokevirtual accept : ()Ljava/nio/channels/SocketChannel;
    //   262: astore_3
    //   263: aload_2
    //   264: astore #4
    //   266: aload_3
    //   267: iconst_0
    //   268: invokevirtual configureBlocking : (Z)Ljava/nio/channels/SelectableChannel;
    //   271: pop
    //   272: aload_2
    //   273: astore #4
    //   275: aload_0
    //   276: getfield m : Lb/a/k/b$a;
    //   279: aload_0
    //   280: aload_0
    //   281: getfield e : Ljava/util/List;
    //   284: aload_3
    //   285: invokevirtual socket : ()Ljava/net/Socket;
    //   288: invokeinterface a : (Lb/a/c;Ljava/util/List;Ljava/net/Socket;)Lb/a/d;
    //   293: astore #7
    //   295: aload_2
    //   296: astore #4
    //   298: aload_3
    //   299: aload_0
    //   300: getfield d : Ljava/nio/channels/Selector;
    //   303: iconst_1
    //   304: aload #7
    //   306: invokevirtual register : (Ljava/nio/channels/Selector;ILjava/lang/Object;)Ljava/nio/channels/SelectionKey;
    //   309: astore #8
    //   311: aload_2
    //   312: astore #4
    //   314: aload #7
    //   316: aload #8
    //   318: putfield a : Ljava/nio/channels/SelectionKey;
    //   321: aload_2
    //   322: astore #4
    //   324: aload_0
    //   325: getfield m : Lb/a/k/b$a;
    //   328: aload_3
    //   329: aload #8
    //   331: invokeinterface a : (Ljava/nio/channels/SocketChannel;Ljava/nio/channels/SelectionKey;)Ljava/nio/channels/ByteChannel;
    //   336: pop
    //   337: aload_2
    //   338: astore #4
    //   340: aload #7
    //   342: aload_3
    //   343: putfield b : Ljava/nio/channels/ByteChannel;
    //   346: aload_2
    //   347: astore #4
    //   349: aload #6
    //   351: invokeinterface remove : ()V
    //   356: aload_2
    //   357: astore #4
    //   359: aload_0
    //   360: aload #7
    //   362: invokevirtual f : (Lb/a/b;)V
    //   365: goto -> 832
    //   368: aload_2
    //   369: astore_3
    //   370: aload_2
    //   371: astore #4
    //   373: aload #5
    //   375: invokevirtual isReadable : ()Z
    //   378: ifeq -> 525
    //   381: aload_2
    //   382: astore #4
    //   384: aload #5
    //   386: invokevirtual attachment : ()Ljava/lang/Object;
    //   389: checkcast b/a/d
    //   392: astore_3
    //   393: aload_3
    //   394: astore_2
    //   395: aload_0
    //   396: invokespecial d : ()Ljava/nio/ByteBuffer;
    //   399: astore #4
    //   401: aload #4
    //   403: aload_3
    //   404: aload_3
    //   405: getfield b : Ljava/nio/channels/ByteChannel;
    //   408: invokestatic a : (Ljava/nio/ByteBuffer;Lb/a/d;Ljava/nio/channels/ByteChannel;)Z
    //   411: ifeq -> 476
    //   414: aload_3
    //   415: getfield d : Ljava/util/concurrent/BlockingQueue;
    //   418: aload #4
    //   420: invokeinterface put : (Ljava/lang/Object;)V
    //   425: aload_0
    //   426: aload_3
    //   427: invokespecial a : (Lb/a/d;)V
    //   430: aload #6
    //   432: invokeinterface remove : ()V
    //   437: aload_3
    //   438: getfield b : Ljava/nio/channels/ByteChannel;
    //   441: instanceof b/a/f
    //   444: ifeq -> 482
    //   447: aload_3
    //   448: getfield b : Ljava/nio/channels/ByteChannel;
    //   451: checkcast b/a/f
    //   454: invokeinterface c : ()Z
    //   459: ifeq -> 482
    //   462: aload_0
    //   463: getfield i : Ljava/util/List;
    //   466: aload_3
    //   467: invokeinterface add : (Ljava/lang/Object;)Z
    //   472: pop
    //   473: goto -> 482
    //   476: aload_0
    //   477: aload #4
    //   479: invokespecial a : (Ljava/nio/ByteBuffer;)V
    //   482: goto -> 525
    //   485: astore #6
    //   487: aload_3
    //   488: astore_2
    //   489: aload_0
    //   490: aload #4
    //   492: invokespecial a : (Ljava/nio/ByteBuffer;)V
    //   495: aload_3
    //   496: astore_2
    //   497: aload #6
    //   499: athrow
    //   500: astore #6
    //   502: aload_3
    //   503: astore_2
    //   504: aload_0
    //   505: aload #4
    //   507: invokespecial a : (Ljava/nio/ByteBuffer;)V
    //   510: aload_3
    //   511: astore_2
    //   512: aload #6
    //   514: athrow
    //   515: astore #4
    //   517: aload_2
    //   518: astore_3
    //   519: aload #4
    //   521: astore_2
    //   522: goto -> 591
    //   525: aload_3
    //   526: astore #4
    //   528: aload_3
    //   529: astore_2
    //   530: aload #5
    //   532: invokevirtual isWritable : ()Z
    //   535: ifeq -> 832
    //   538: aload_3
    //   539: astore #4
    //   541: aload #5
    //   543: invokevirtual attachment : ()Ljava/lang/Object;
    //   546: checkcast b/a/d
    //   549: astore_3
    //   550: aload_3
    //   551: astore_2
    //   552: aload_3
    //   553: aload_3
    //   554: getfield b : Ljava/nio/channels/ByteChannel;
    //   557: invokestatic a : (Lb/a/d;Ljava/nio/channels/ByteChannel;)Z
    //   560: ifeq -> 582
    //   563: aload_3
    //   564: astore_2
    //   565: aload #5
    //   567: invokevirtual isValid : ()Z
    //   570: ifeq -> 582
    //   573: aload_3
    //   574: astore_2
    //   575: aload #5
    //   577: iconst_1
    //   578: invokevirtual interestOps : (I)Ljava/nio/channels/SelectionKey;
    //   581: pop
    //   582: aload_3
    //   583: astore_2
    //   584: goto -> 832
    //   587: astore_2
    //   588: aload #4
    //   590: astore_3
    //   591: goto -> 738
    //   594: aload #5
    //   596: astore #4
    //   598: aload_0
    //   599: getfield i : Ljava/util/List;
    //   602: invokeinterface isEmpty : ()Z
    //   607: ifne -> 135
    //   610: aload #5
    //   612: astore #4
    //   614: aload_0
    //   615: getfield i : Ljava/util/List;
    //   618: iconst_0
    //   619: invokeinterface remove : (I)Ljava/lang/Object;
    //   624: checkcast b/a/d
    //   627: astore_2
    //   628: aload_2
    //   629: getfield b : Ljava/nio/channels/ByteChannel;
    //   632: checkcast b/a/f
    //   635: astore #5
    //   637: aload_0
    //   638: invokespecial d : ()Ljava/nio/ByteBuffer;
    //   641: astore #4
    //   643: aload #4
    //   645: aload_2
    //   646: aload #5
    //   648: invokestatic a : (Ljava/nio/ByteBuffer;Lb/a/d;Lb/a/f;)Z
    //   651: ifeq -> 665
    //   654: aload_0
    //   655: getfield i : Ljava/util/List;
    //   658: aload_2
    //   659: invokeinterface add : (Ljava/lang/Object;)Z
    //   664: pop
    //   665: aload_2
    //   666: getfield d : Ljava/util/concurrent/BlockingQueue;
    //   669: aload #4
    //   671: invokeinterface put : (Ljava/lang/Object;)V
    //   676: aload_0
    //   677: aload_2
    //   678: invokespecial a : (Lb/a/d;)V
    //   681: aload_0
    //   682: aload #4
    //   684: invokespecial a : (Ljava/nio/ByteBuffer;)V
    //   687: aload_2
    //   688: astore #5
    //   690: goto -> 594
    //   693: astore #5
    //   695: aload_0
    //   696: aload #4
    //   698: invokespecial a : (Ljava/nio/ByteBuffer;)V
    //   701: aload #5
    //   703: athrow
    //   704: astore #5
    //   706: aload_2
    //   707: astore #4
    //   709: aload #5
    //   711: astore_2
    //   712: aload_3
    //   713: astore #5
    //   715: aload #4
    //   717: astore_3
    //   718: goto -> 738
    //   721: astore_2
    //   722: aload_3
    //   723: astore #5
    //   725: aload #4
    //   727: astore_3
    //   728: goto -> 738
    //   731: astore_2
    //   732: aconst_null
    //   733: astore #5
    //   735: aload #5
    //   737: astore_3
    //   738: aload #5
    //   740: ifnull -> 748
    //   743: aload #5
    //   745: invokevirtual cancel : ()V
    //   748: aload_0
    //   749: aload #5
    //   751: aload_3
    //   752: aload_2
    //   753: invokespecial a : (Ljava/nio/channels/SelectionKey;Lb/a/b;Ljava/io/IOException;)V
    //   756: goto -> 135
    //   759: astore_2
    //   760: aload_0
    //   761: aconst_null
    //   762: aload_2
    //   763: invokespecial c : (Lb/a/b;Ljava/lang/Exception;)V
    //   766: return
    //   767: astore_2
    //   768: aload_0
    //   769: aconst_null
    //   770: aload_2
    //   771: invokespecial c : (Lb/a/b;Ljava/lang/Exception;)V
    //   774: return
    //   775: new java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial <init> : ()V
    //   782: astore_2
    //   783: aload_2
    //   784: aload_0
    //   785: invokevirtual getClass : ()Ljava/lang/Class;
    //   788: invokevirtual getName : ()Ljava/lang/String;
    //   791: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload_2
    //   796: ldc_w ' can only be started once.'
    //   799: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: new java/lang/IllegalStateException
    //   806: dup
    //   807: aload_2
    //   808: invokevirtual toString : ()Ljava/lang/String;
    //   811: invokespecial <init> : (Ljava/lang/String;)V
    //   814: athrow
    //   815: astore_2
    //   816: aload_0
    //   817: monitorexit
    //   818: goto -> 823
    //   821: aload_2
    //   822: athrow
    //   823: goto -> 821
    //   826: astore_2
    //   827: goto -> 135
    //   830: astore_2
    //   831: return
    //   832: aload #5
    //   834: astore_3
    //   835: goto -> 173
    // Exception table:
    //   from	to	target	type
    //   2	28	815	finally
    //   29	31	815	finally
    //   72	135	767	java/io/IOException
    //   135	143	759	java/lang/RuntimeException
    //   147	169	826	java/nio/channels/CancelledKeyException
    //   147	169	731	java/io/IOException
    //   147	169	830	java/lang/InterruptedException
    //   147	169	759	java/lang/RuntimeException
    //   179	189	826	java/nio/channels/CancelledKeyException
    //   179	189	721	java/io/IOException
    //   179	189	830	java/lang/InterruptedException
    //   179	189	759	java/lang/RuntimeException
    //   192	204	826	java/nio/channels/CancelledKeyException
    //   192	204	721	java/io/IOException
    //   192	204	830	java/lang/InterruptedException
    //   192	204	759	java/lang/RuntimeException
    //   207	215	826	java/nio/channels/CancelledKeyException
    //   207	215	587	java/io/IOException
    //   207	215	830	java/lang/InterruptedException
    //   207	215	759	java/lang/RuntimeException
    //   221	229	826	java/nio/channels/CancelledKeyException
    //   221	229	587	java/io/IOException
    //   221	229	830	java/lang/InterruptedException
    //   221	229	759	java/lang/RuntimeException
    //   232	241	826	java/nio/channels/CancelledKeyException
    //   232	241	587	java/io/IOException
    //   232	241	830	java/lang/InterruptedException
    //   232	241	759	java/lang/RuntimeException
    //   244	249	826	java/nio/channels/CancelledKeyException
    //   244	249	587	java/io/IOException
    //   244	249	830	java/lang/InterruptedException
    //   244	249	759	java/lang/RuntimeException
    //   255	263	826	java/nio/channels/CancelledKeyException
    //   255	263	587	java/io/IOException
    //   255	263	830	java/lang/InterruptedException
    //   255	263	759	java/lang/RuntimeException
    //   266	272	826	java/nio/channels/CancelledKeyException
    //   266	272	587	java/io/IOException
    //   266	272	830	java/lang/InterruptedException
    //   266	272	759	java/lang/RuntimeException
    //   275	295	826	java/nio/channels/CancelledKeyException
    //   275	295	587	java/io/IOException
    //   275	295	830	java/lang/InterruptedException
    //   275	295	759	java/lang/RuntimeException
    //   298	311	826	java/nio/channels/CancelledKeyException
    //   298	311	587	java/io/IOException
    //   298	311	830	java/lang/InterruptedException
    //   298	311	759	java/lang/RuntimeException
    //   314	321	826	java/nio/channels/CancelledKeyException
    //   314	321	587	java/io/IOException
    //   314	321	830	java/lang/InterruptedException
    //   314	321	759	java/lang/RuntimeException
    //   324	337	826	java/nio/channels/CancelledKeyException
    //   324	337	587	java/io/IOException
    //   324	337	830	java/lang/InterruptedException
    //   324	337	759	java/lang/RuntimeException
    //   340	346	826	java/nio/channels/CancelledKeyException
    //   340	346	587	java/io/IOException
    //   340	346	830	java/lang/InterruptedException
    //   340	346	759	java/lang/RuntimeException
    //   349	356	826	java/nio/channels/CancelledKeyException
    //   349	356	587	java/io/IOException
    //   349	356	830	java/lang/InterruptedException
    //   349	356	759	java/lang/RuntimeException
    //   359	365	826	java/nio/channels/CancelledKeyException
    //   359	365	587	java/io/IOException
    //   359	365	830	java/lang/InterruptedException
    //   359	365	759	java/lang/RuntimeException
    //   373	381	826	java/nio/channels/CancelledKeyException
    //   373	381	587	java/io/IOException
    //   373	381	830	java/lang/InterruptedException
    //   373	381	759	java/lang/RuntimeException
    //   384	393	826	java/nio/channels/CancelledKeyException
    //   384	393	587	java/io/IOException
    //   384	393	830	java/lang/InterruptedException
    //   384	393	759	java/lang/RuntimeException
    //   395	401	826	java/nio/channels/CancelledKeyException
    //   395	401	515	java/io/IOException
    //   395	401	830	java/lang/InterruptedException
    //   395	401	759	java/lang/RuntimeException
    //   401	473	500	java/io/IOException
    //   401	473	485	java/lang/RuntimeException
    //   401	473	830	java/lang/InterruptedException
    //   476	482	500	java/io/IOException
    //   476	482	485	java/lang/RuntimeException
    //   476	482	830	java/lang/InterruptedException
    //   489	495	826	java/nio/channels/CancelledKeyException
    //   489	495	515	java/io/IOException
    //   489	495	830	java/lang/InterruptedException
    //   489	495	759	java/lang/RuntimeException
    //   497	500	826	java/nio/channels/CancelledKeyException
    //   497	500	515	java/io/IOException
    //   497	500	830	java/lang/InterruptedException
    //   497	500	759	java/lang/RuntimeException
    //   504	510	826	java/nio/channels/CancelledKeyException
    //   504	510	515	java/io/IOException
    //   504	510	830	java/lang/InterruptedException
    //   504	510	759	java/lang/RuntimeException
    //   512	515	826	java/nio/channels/CancelledKeyException
    //   512	515	515	java/io/IOException
    //   512	515	830	java/lang/InterruptedException
    //   512	515	759	java/lang/RuntimeException
    //   530	538	826	java/nio/channels/CancelledKeyException
    //   530	538	587	java/io/IOException
    //   530	538	830	java/lang/InterruptedException
    //   530	538	759	java/lang/RuntimeException
    //   541	550	826	java/nio/channels/CancelledKeyException
    //   541	550	587	java/io/IOException
    //   541	550	830	java/lang/InterruptedException
    //   541	550	759	java/lang/RuntimeException
    //   552	563	826	java/nio/channels/CancelledKeyException
    //   552	563	515	java/io/IOException
    //   552	563	830	java/lang/InterruptedException
    //   552	563	759	java/lang/RuntimeException
    //   565	573	826	java/nio/channels/CancelledKeyException
    //   565	573	515	java/io/IOException
    //   565	573	830	java/lang/InterruptedException
    //   565	573	759	java/lang/RuntimeException
    //   575	582	826	java/nio/channels/CancelledKeyException
    //   575	582	515	java/io/IOException
    //   575	582	830	java/lang/InterruptedException
    //   575	582	759	java/lang/RuntimeException
    //   598	610	826	java/nio/channels/CancelledKeyException
    //   598	610	721	java/io/IOException
    //   598	610	830	java/lang/InterruptedException
    //   598	610	759	java/lang/RuntimeException
    //   614	628	826	java/nio/channels/CancelledKeyException
    //   614	628	721	java/io/IOException
    //   614	628	830	java/lang/InterruptedException
    //   614	628	759	java/lang/RuntimeException
    //   628	643	826	java/nio/channels/CancelledKeyException
    //   628	643	704	java/io/IOException
    //   628	643	830	java/lang/InterruptedException
    //   628	643	759	java/lang/RuntimeException
    //   643	665	693	finally
    //   665	681	693	finally
    //   681	687	826	java/nio/channels/CancelledKeyException
    //   681	687	704	java/io/IOException
    //   681	687	830	java/lang/InterruptedException
    //   681	687	759	java/lang/RuntimeException
    //   695	704	826	java/nio/channels/CancelledKeyException
    //   695	704	704	java/io/IOException
    //   695	704	830	java/lang/InterruptedException
    //   695	704	759	java/lang/RuntimeException
    //   743	748	759	java/lang/RuntimeException
    //   748	756	759	java/lang/RuntimeException
    //   775	815	815	finally
    //   816	818	815	finally
  }
  
  public static interface a {
    d a(c param1c, List<b.a.g.a> param1List, Socket param1Socket);
    
    ByteChannel a(SocketChannel param1SocketChannel, SelectionKey param1SelectionKey);
  }
  
  public class b extends Thread {
    private BlockingQueue<d> a = new LinkedBlockingQueue<d>();
    
    public b(b this$0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("WebSocketWorker-");
      stringBuilder.append(getId());
      setName(stringBuilder.toString());
      setUncaughtExceptionHandler(new a(this, this$0));
    }
    
    public void a(d param1d) {
      this.a.put(param1d);
    }
    
    public void run() {
      ByteBuffer byteBuffer = null;
      try {
        d d;
        while (true) {
          d d1 = this.a.take();
          try {
            d d2;
            byteBuffer = d1.d.poll();
            try {
              d1.a(byteBuffer);
              b.a(this.b, byteBuffer);
            } finally {
              b.a(this.b, (ByteBuffer)d2);
            } 
          } catch (RuntimeException runtimeException) {
            d = d1;
            break;
          } 
        } 
        b.a(this.b, (b.a.b)d, runtimeException);
        return;
      } catch (InterruptedException interruptedException) {
        return;
      } catch (RuntimeException runtimeException2) {
        InterruptedException interruptedException1 = interruptedException;
        RuntimeException runtimeException1 = runtimeException2;
        b.a(this.b, (b.a.b)interruptedException1, runtimeException1);
        return;
      } 
    }
    
    class a implements Thread.UncaughtExceptionHandler {
      a(b.b this$0, b param2b) {}
      
      public void uncaughtException(Thread param2Thread, Throwable param2Throwable) {
        Thread.getDefaultUncaughtExceptionHandler().uncaughtException(param2Thread, param2Throwable);
      }
    }
  }
  
  class a implements Thread.UncaughtExceptionHandler {
    a(b this$0, b param1b) {}
    
    public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(param1Thread, param1Throwable);
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\k\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */