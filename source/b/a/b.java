package b.a;

import b.a.i.d;
import java.net.InetSocketAddress;

public interface b {
  InetSocketAddress a();
  
  void a(int paramInt);
  
  void a(int paramInt, String paramString);
  
  void a(d paramd);
  
  void a(String paramString);
  
  InetSocketAddress b();
  
  public enum a {
    a, b, c, d, e;
    
    static {
      a a1 = new a("CLOSED", 4);
      e = a1;
      f = new a[] { a, b, c, d, a1 };
    }
  }
  
  public enum b {
    a, b;
    
    static {
      b b1 = new b("SERVER", 1);
      b = b1;
      c = new b[] { a, b1 };
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */