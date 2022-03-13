package a.a.a.a;

import a.a.a.b.a;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

public class a extends a {
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23) {
      b.a(paramActivity, paramArrayOfString, paramInt);
      return;
    } 
    if (paramActivity instanceof b)
      (new Handler(Looper.getMainLooper())).post(new a(paramArrayOfString, paramActivity, paramInt)); 
  }
  
  static final class a implements Runnable {
    a(String[] param1ArrayOfString, Activity param1Activity, int param1Int) {}
    
    public void run() {
      int[] arrayOfInt = new int[this.a.length];
      PackageManager packageManager = this.b.getPackageManager();
      String str = this.b.getPackageName();
      int j = this.a.length;
      for (int i = 0; i < j; i++)
        arrayOfInt[i] = packageManager.checkPermission(this.a[i], str); 
      ((a.b)this.b).a(this.c, this.a, arrayOfInt);
    }
  }
  
  public static interface b {
    void a(int param1Int, String[] param1ArrayOfString, int[] param1ArrayOfint);
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\a\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */