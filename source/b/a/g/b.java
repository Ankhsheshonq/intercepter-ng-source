package b.a.g;

import b.a.h.c;
import b.a.h.d;
import b.a.h.e;
import b.a.h.f;
import b.a.i.d;
import b.a.i.e;
import b.a.j.c;
import b.a.j.f;
import b.a.j.h;
import b.a.j.i;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class b extends a {
  private ByteBuffer d;
  
  private final Random e = new Random();
  
  private byte a(d.a parama) {
    if (parama == d.a.a)
      return 0; 
    if (parama == d.a.b)
      return 1; 
    if (parama == d.a.c)
      return 2; 
    if (parama == d.a.f)
      return 8; 
    if (parama == d.a.d)
      return 9; 
    if (parama == d.a.e)
      return 10; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Don't know how to handle ");
    stringBuilder.append(parama.toString());
    throw new RuntimeException(stringBuilder.toString());
  }
  
  private d.a a(byte paramByte) {
    if (paramByte != 0) {
      if (paramByte != 1) {
        if (paramByte != 2) {
          StringBuilder stringBuilder;
          switch (paramByte) {
            default:
              stringBuilder = new StringBuilder();
              stringBuilder.append("unknow optcode ");
              stringBuilder.append((short)paramByte);
              throw new c(stringBuilder.toString());
            case 10:
              return d.a.e;
            case 9:
              return d.a.d;
            case 8:
              break;
          } 
          return d.a.f;
        } 
        return d.a.c;
      } 
      return d.a.b;
    } 
    return d.a.a;
  }
  
  private String a(String paramString) {
    paramString = paramString.trim();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    paramString = stringBuilder.toString();
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
      return b.a.l.a.a(messageDigest.digest(paramString.getBytes()));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException);
    } 
  }
  
  private byte[] a(long paramLong, int paramInt) {
    byte[] arrayOfByte = new byte[paramInt];
    int i;
    for (i = 0; i < paramInt; i++)
      arrayOfByte[i] = (byte)(int)(paramLong >>> paramInt * 8 - 8 - i * 8); 
    return arrayOfByte;
  }
  
  public static int b(f paramf) {
    String str = paramf.c("Sec-WebSocket-Version");
    if (str.length() > 0)
      try {
        return (new Integer(str.trim())).intValue();
      } catch (NumberFormatException numberFormatException) {
        return -1;
      }  
    return -1;
  }
  
  public a.b a(b.a.j.a parama) {
    int i = b((f)parama);
    return (i == 7 || i == 8) ? (a((f)parama) ? a.b.a : a.b.b) : a.b.b;
  }
  
  public a.b a(b.a.j.a parama, h paramh) {
    if (!parama.a("Sec-WebSocket-Key") || !paramh.a("Sec-WebSocket-Accept"))
      return a.b.b; 
    String str = paramh.c("Sec-WebSocket-Accept");
    return a(parama.c("Sec-WebSocket-Key")).equals(str) ? a.b.a : a.b.b;
  }
  
  public a a() {
    return new b();
  }
  
  public c a(b.a.j.a parama, i parami) {
    parami.a("Upgrade", "websocket");
    parami.a("Connection", parama.c("Connection"));
    parami.d("Switching Protocols");
    String str = parama.c("Sec-WebSocket-Key");
    if (str != null) {
      parami.a("Sec-WebSocket-Accept", a(str));
      return (c)parami;
    } 
    throw new d("missing Sec-WebSocket-Key");
  }
  
  public ByteBuffer a(d paramd) {
    int i;
    boolean bool1;
    byte b1;
    ByteBuffer byteBuffer1 = paramd.d();
    b.a.b.b b3 = this.a;
    b.a.b.b b4 = b.a.b.b.a;
    boolean bool2 = false;
    if (b3 == b4) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (byteBuffer1.remaining() <= 125) {
      i = 1;
    } else if (byteBuffer1.remaining() <= 65535) {
      i = 2;
    } else {
      i = 8;
    } 
    if (i > 1) {
      j = i + 1;
    } else {
      j = i;
    } 
    if (bool1) {
      b1 = 4;
    } else {
      b1 = 0;
    } 
    ByteBuffer byteBuffer2 = ByteBuffer.allocate(j + 1 + b1 + byteBuffer1.remaining());
    byte b2 = a(paramd.a());
    boolean bool = paramd.e();
    int j = -128;
    if (bool) {
      b1 = -128;
    } else {
      b1 = 0;
    } 
    byteBuffer2.put((byte)((byte)b1 | b2));
    byte[] arrayOfByte = a(byteBuffer1.remaining(), i);
    if (i == 1) {
      i = arrayOfByte[0];
      if (!bool1)
        j = 0; 
      byteBuffer2.put((byte)(i | j));
    } else {
      RuntimeException runtimeException;
      if (i == 2) {
        if (!bool1)
          j = 0; 
        i = j | 0x7E;
      } else if (i == 8) {
        if (!bool1)
          j = 0; 
        i = j | 0x7F;
      } else {
        runtimeException = new RuntimeException("Size representation not supported/specified");
        throw runtimeException;
      } 
      byteBuffer2.put((byte)i);
      byteBuffer2.put((byte[])runtimeException);
    } 
    if (bool1) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(4);
      byteBuffer.putInt(this.e.nextInt());
      byteBuffer2.put(byteBuffer.array());
      for (i = bool2; i < byteBuffer1.limit(); i++)
        byteBuffer2.put((byte)(byteBuffer1.get() ^ byteBuffer.get(i % 4))); 
    } else {
      byteBuffer2.put(byteBuffer1);
    } 
    byteBuffer2.flip();
    return byteBuffer2;
  }
  
  public List<d> a(String paramString, boolean paramBoolean) {
    e e = new e();
    try {
      e.a(ByteBuffer.wrap(b.a.l.b.b(paramString)));
      e.b(true);
      e.a(d.a.b);
      e.a(paramBoolean);
      return (List)Collections.singletonList(e);
    } catch (b.a.h.b b1) {
      throw new f(b1);
    } 
  }
  
  public List<d> a(ByteBuffer paramByteBuffer) {
    ByteBuffer byteBuffer;
    LinkedList<d> linkedList = new LinkedList();
    if (this.d != null)
      try {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.d.remaining();
        if (j > i) {
          this.d.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(paramByteBuffer.position() + i);
          return Collections.emptyList();
        } 
        this.d.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        linkedList.add(e((ByteBuffer)this.d.duplicate().position(0)));
        this.d = null;
      } catch (a a1) {
        this.d.limit();
        int i = a1.a();
        a(i);
        byteBuffer = ByteBuffer.allocate(i);
        this.d.rewind();
        byteBuffer.put(this.d);
        this.d = byteBuffer;
        return a(paramByteBuffer);
      }  
    while (paramByteBuffer.hasRemaining()) {
      paramByteBuffer.mark();
      try {
        byteBuffer.add(e(paramByteBuffer));
      } catch (a a1) {
        paramByteBuffer.reset();
        int i = a1.a();
        a(i);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(i);
        this.d = byteBuffer1;
        byteBuffer1.put(paramByteBuffer);
        break;
      } 
    } 
    return (List<d>)byteBuffer;
  }
  
  public a.a b() {
    return a.a.c;
  }
  
  public void c() {
    this.d = null;
  }
  
  public d e(ByteBuffer paramByteBuffer) {
    int j = paramByteBuffer.remaining();
    int i = 2;
    if (j >= 2) {
      boolean bool2;
      byte b1 = paramByteBuffer.get();
      boolean bool1 = false;
      if (b1 >> 8 != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      int k = (byte)((b1 & Byte.MAX_VALUE) >> 4);
      if (k == 0) {
        boolean bool;
        k = paramByteBuffer.get();
        if ((k & 0xFFFFFF80) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        k = (byte)(k & 0x7F);
        d.a a2 = a((byte)(b1 & 0xF));
        if (bool2 || (a2 != d.a.d && a2 != d.a.e && a2 != d.a.f)) {
          if (k < 0 || k > 125)
            if (a2 != d.a.d && a2 != d.a.e && a2 != d.a.f) {
              if (k == 126) {
                if (j >= 4) {
                  byte[] arrayOfByte = new byte[3];
                  arrayOfByte[1] = paramByteBuffer.get();
                  arrayOfByte[2] = paramByteBuffer.get();
                  k = (new BigInteger(arrayOfByte)).intValue();
                  i = 4;
                } else {
                  throw new a(this, 4);
                } 
              } else {
                i = 10;
                if (j >= 10) {
                  byte[] arrayOfByte = new byte[8];
                  k = 0;
                  while (k < 8) {
                    arrayOfByte[k] = paramByteBuffer.get();
                    k = k + 1;
                  } 
                  long l = (new BigInteger(arrayOfByte)).longValue();
                  if (l <= 2147483647L) {
                    k = (int)l;
                  } else {
                    throw new e("Payloadsize is to big...");
                  } 
                } else {
                  throw new a(this, 10);
                } 
              } 
            } else {
              throw new c("more than 125 octets");
            }  
          if (bool) {
            b1 = 4;
          } else {
            b1 = 0;
          } 
          i = i + b1 + k;
          if (j >= i) {
            e e;
            a(k);
            ByteBuffer byteBuffer = ByteBuffer.allocate(k);
            if (bool) {
              byte[] arrayOfByte = new byte[4];
              paramByteBuffer.get(arrayOfByte);
              for (i = bool1; i < k; i++)
                byteBuffer.put((byte)(paramByteBuffer.get() ^ arrayOfByte[i % 4])); 
            } else {
              byteBuffer.put(paramByteBuffer.array(), paramByteBuffer.position(), byteBuffer.limit());
              paramByteBuffer.position(paramByteBuffer.position() + byteBuffer.limit());
            } 
            if (a2 == d.a.f) {
              b.a.i.b b2 = new b.a.i.b();
            } else {
              e = new e();
              e.b(bool2);
              e.a(a2);
            } 
            byteBuffer.flip();
            e.a(byteBuffer);
            return (d)e;
          } 
          throw new a(this, i);
        } 
        throw new c("control frames may no be fragmented");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("bad rsv ");
      stringBuilder.append(k);
      throw new c(stringBuilder.toString());
    } 
    a a1 = new a(this, 2);
    throw a1;
  }
  
  private class a extends Throwable {
    private int a;
    
    public a(b this$0, int param1Int) {
      this.a = param1Int;
    }
    
    public int a() {
      return this.a;
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */