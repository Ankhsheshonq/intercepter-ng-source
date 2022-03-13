package b.a.j;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class g implements c {
  private byte[] a;
  
  private TreeMap<String, String> b = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
  
  public void a(String paramString1, String paramString2) {
    this.b.put(paramString1, paramString2);
  }
  
  public void a(byte[] paramArrayOfbyte) {
    this.a = paramArrayOfbyte;
  }
  
  public boolean a(String paramString) {
    return this.b.containsKey(paramString);
  }
  
  public String c(String paramString) {
    String str = this.b.get(paramString);
    paramString = str;
    if (str == null)
      paramString = ""; 
    return paramString;
  }
  
  public Iterator<String> c() {
    return Collections.<String>unmodifiableSet(this.b.keySet()).iterator();
  }
  
  public byte[] d() {
    return this.a;
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\j\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */