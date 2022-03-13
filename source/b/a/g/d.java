package b.a.g;

import b.a.h.b;
import b.a.h.f;
import b.a.i.e;
import b.a.j.a;
import b.a.j.c;
import b.a.j.f;
import b.a.j.h;
import b.a.j.i;
import b.a.l.b;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class d extends a {
  protected boolean d = false;
  
  private boolean e = false;
  
  protected List<b.a.i.d> f = new LinkedList<b.a.i.d>();
  
  protected ByteBuffer g;
  
  public d() {
    new Random();
  }
  
  public a.b a(a parama) {
    return (parama.a("Origin") && a((f)parama)) ? a.b.a : a.b.b;
  }
  
  public a.b a(a parama, h paramh) {
    return (parama.c("WebSocket-Origin").equals(paramh.c("Origin")) && a((f)paramh)) ? a.b.a : a.b.b;
  }
  
  public a a() {
    return new d();
  }
  
  public c a(a parama, i parami) {
    parami.d("Web Socket Protocol Handshake");
    parami.a("Upgrade", "WebSocket");
    parami.a("Connection", parama.c("Connection"));
    parami.a("WebSocket-Origin", parama.c("Origin"));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ws://");
    stringBuilder.append(parama.c("Host"));
    stringBuilder.append(parama.a());
    parami.a("WebSocket-Location", stringBuilder.toString());
    return (c)parami;
  }
  
  public ByteBuffer a(b.a.i.d paramd) {
    if (paramd.a() == b.a.i.d.a.b) {
      ByteBuffer byteBuffer1 = paramd.d();
      ByteBuffer byteBuffer2 = ByteBuffer.allocate(byteBuffer1.remaining() + 2);
      byteBuffer2.put((byte)0);
      byteBuffer1.mark();
      byteBuffer2.put(byteBuffer1);
      byteBuffer1.reset();
      byteBuffer2.put((byte)-1);
      byteBuffer2.flip();
      return byteBuffer2;
    } 
    throw new RuntimeException("only text frames supported");
  }
  
  public List<b.a.i.d> a(String paramString, boolean paramBoolean) {
    e e = new e();
    try {
      e.a(ByteBuffer.wrap(b.b(paramString)));
      e.b(true);
      e.a(b.a.i.d.a.b);
      e.a(paramBoolean);
      return (List)Collections.singletonList(e);
    } catch (b b) {
      throw new f(b);
    } 
  }
  
  public List<b.a.i.d> a(ByteBuffer paramByteBuffer) {
    List<b.a.i.d> list = f(paramByteBuffer);
    if (list != null)
      return list; 
    throw new b(1002);
  }
  
  public a.a b() {
    return a.a.a;
  }
  
  public void c() {
    this.d = false;
    this.g = null;
  }
  
  public ByteBuffer d() {
    return ByteBuffer.allocate(a.b);
  }
  
  public ByteBuffer e(ByteBuffer paramByteBuffer) {
    paramByteBuffer.flip();
    ByteBuffer byteBuffer = ByteBuffer.allocate(paramByteBuffer.capacity() * 2);
    byteBuffer.put(paramByteBuffer);
    return byteBuffer;
  }
  
  protected List<b.a.i.d> f(ByteBuffer paramByteBuffer) {
    while (paramByteBuffer.hasRemaining()) {
      byte b = paramByteBuffer.get();
      if (b == 0) {
        if (this.d)
          return null; 
        this.d = true;
        continue;
      } 
      if (b == -1) {
        if (!this.d)
          return null; 
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer != null) {
          b.a.i.d.a a1;
          byteBuffer.flip();
          e e = new e();
          e.a(this.g);
          e.b(true);
          if (this.e) {
            a1 = b.a.i.d.a.a;
          } else {
            a1 = b.a.i.d.a.b;
          } 
          e.a(a1);
          this.f.add(e);
          this.g = null;
          paramByteBuffer.mark();
        } 
        this.d = false;
        this.e = false;
        continue;
      } 
      if (this.d) {
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
          byteBuffer = d();
        } else if (!byteBuffer.hasRemaining()) {
          byteBuffer = e(this.g);
        } else {
          continue;
        } 
        this.g = byteBuffer;
        continue;
      } 
      return null;
      this.g.put(SYNTHETIC_LOCAL_VARIABLE_2);
    } 
    if (this.d) {
      b.a.i.d.a a1;
      e e = new e();
      this.g.flip();
      e.a(this.g);
      e.b(false);
      if (this.e) {
        a1 = b.a.i.d.a.a;
      } else {
        a1 = b.a.i.d.a.b;
      } 
      e.a(a1);
      this.e = true;
      this.f.add(e);
    } 
    List<b.a.i.d> list = this.f;
    this.f = new LinkedList<b.a.i.d>();
    this.g = null;
    return list;
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */