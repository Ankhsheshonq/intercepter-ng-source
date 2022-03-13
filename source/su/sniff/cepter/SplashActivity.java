package su.sniff.cepter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
  Context a;
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(3);
    setContentView(2130968600);
    this.a = (Context)this;
    (new a(this)).start();
  }
  
  class a extends Thread {
    a(SplashActivity this$0) {}
    
    public void run() {
      int i = 0;
      while (true) {
        if (i < 500) {
          try {
            Thread.sleep(100L);
            i += 100;
            continue;
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } finally {
            Exception exception;
          } 
        } else {
          Intent intent = new Intent(this.a.a, ChooseActivity.class);
          this.a.startActivity(intent);
          this.a.finish();
        } 
        this.a.finish();
        return;
      } 
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */