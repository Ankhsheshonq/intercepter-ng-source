package b.a.h;

public class b extends Exception {
  private int a;
  
  public b(int paramInt) {
    this.a = paramInt;
  }
  
  public b(int paramInt, String paramString) {
    super(paramString);
    this.a = paramInt;
  }
  
  public b(int paramInt, Throwable paramThrowable) {
    super(paramThrowable);
    this.a = paramInt;
  }
  
  public int a() {
    return this.a;
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */