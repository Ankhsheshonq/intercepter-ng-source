package b.a.g;

import b.a.h.d;
import b.a.i.d;
import b.a.j.c;
import b.a.j.d;
import b.a.j.e;
import b.a.j.f;
import b.a.j.h;
import b.a.j.i;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class a {
  public static int b = 64;
  
  public static final byte[] c = b.a.l.b.b("<policy-file-request/>\000");
  
  protected b.a.b.b a = null;
  
  public static c a(ByteBuffer paramByteBuffer, b.a.b.b paramb) {
    String str = d(paramByteBuffer);
    if (str != null) {
      String[] arrayOfString = str.split(" ", 3);
      if (arrayOfString.length == 3) {
        d d;
        String[] arrayOfString1;
        if (paramb == b.a.b.b.a) {
          e e = new e();
          e.a(Short.parseShort(arrayOfString[1]));
          e.d(arrayOfString[2]);
        } else {
          d = new d();
          d.b(arrayOfString[1]);
        } 
        while (true) {
          String str1 = d(paramByteBuffer);
          if (str1 != null && str1.length() > 0) {
            arrayOfString1 = str1.split(":", 2);
            if (arrayOfString1.length == 2) {
              d.a(arrayOfString1[0], arrayOfString1[1].replaceFirst("^ +", ""));
              continue;
            } 
            throw new d("not an http header");
          } 
          break;
        } 
        if (arrayOfString1 != null)
          return (c)d; 
        throw new b.a.h.a();
      } 
      throw new d();
    } 
    b.a.h.a a1 = new b.a.h.a(paramByteBuffer.capacity() + 128);
    throw a1;
  }
  
  public static ByteBuffer c(ByteBuffer paramByteBuffer) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    for (byte b1 = 48; paramByteBuffer.hasRemaining(); b1 = b2) {
      byte b2 = paramByteBuffer.get();
      byteBuffer.put(b2);
      if (b1 == 13 && b2 == 10) {
        byteBuffer.limit(byteBuffer.position() - 2);
        byteBuffer.position(0);
        return byteBuffer;
      } 
    } 
    paramByteBuffer.position(paramByteBuffer.position() - byteBuffer.position());
    return null;
  }
  
  public static String d(ByteBuffer paramByteBuffer) {
    paramByteBuffer = c(paramByteBuffer);
    return (paramByteBuffer == null) ? null : b.a.l.b.a(paramByteBuffer.array(), 0, paramByteBuffer.limit());
  }
  
  public int a(int paramInt) {
    if (paramInt >= 0)
      return paramInt; 
    throw new b.a.h.b(1002, "Negative count");
  }
  
  public abstract b a(b.a.j.a parama);
  
  public abstract b a(b.a.j.a parama, h paramh);
  
  public abstract a a();
  
  public abstract c a(b.a.j.a parama, i parami);
  
  public abstract ByteBuffer a(d paramd);
  
  public List<ByteBuffer> a(f paramf, b.a.b.b paramb) {
    return a(paramf, paramb, true);
  }
  
  public List<ByteBuffer> a(f paramf, b.a.b.b paramb, boolean paramBoolean) {
    RuntimeException runtimeException;
    String str;
    int i;
    StringBuilder stringBuilder = new StringBuilder(100);
    if (paramf instanceof b.a.j.a) {
      stringBuilder.append("GET ");
      stringBuilder.append(((b.a.j.a)paramf).a());
      str = " HTTP/1.1";
    } else if (paramf instanceof h) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("HTTP/1.1 101 ");
      stringBuilder1.append(((h)paramf).b());
      str = stringBuilder1.toString();
    } else {
      runtimeException = new RuntimeException("unknow role");
      throw runtimeException;
    } 
    stringBuilder.append(str);
    stringBuilder.append("\r\n");
    Iterator<String> iterator = runtimeException.c();
    while (iterator.hasNext()) {
      String str1 = iterator.next();
      String str2 = runtimeException.c(str1);
      stringBuilder.append(str1);
      stringBuilder.append(": ");
      stringBuilder.append(str2);
      stringBuilder.append("\r\n");
    } 
    stringBuilder.append("\r\n");
    byte[] arrayOfByte = b.a.l.b.a(stringBuilder.toString());
    if (paramBoolean) {
      byte[] arrayOfByte1 = runtimeException.d();
    } else {
      runtimeException = null;
    } 
    if (runtimeException == null) {
      i = 0;
    } else {
      i = runtimeException.length;
    } 
    ByteBuffer byteBuffer = ByteBuffer.allocate(i + arrayOfByte.length);
    byteBuffer.put(arrayOfByte);
    if (runtimeException != null)
      byteBuffer.put((byte[])runtimeException); 
    byteBuffer.flip();
    return Collections.singletonList(byteBuffer);
  }
  
  public abstract List<d> a(String paramString, boolean paramBoolean);
  
  public abstract List<d> a(ByteBuffer paramByteBuffer);
  
  public void a(b.a.b.b paramb) {
    this.a = paramb;
  }
  
  protected boolean a(f paramf) {
    return (paramf.c("Upgrade").equalsIgnoreCase("websocket") && paramf.c("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public abstract a b();
  
  public f b(ByteBuffer paramByteBuffer) {
    return (f)a(paramByteBuffer, this.a);
  }
  
  public abstract void c();
  
  public enum a {
    a, b, c;
    
    static {
      a a1 = new a("TWOWAY", 2);
      c = a1;
      d = new a[] { a, b, a1 };
    }
  }
  
  public enum b {
    a, b;
    
    static {
      b b1 = new b("NOT_MATCHED", 1);
      b = b1;
      c = new b[] { a, b1 };
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */