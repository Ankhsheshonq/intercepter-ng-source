package su.sniff.cepter;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CageActivity extends Activity {
  int a = 0;
  
  public void OnRun(View paramView) {
    if (this.a == 0) {
      this.a = 1;
      TextView textView = (TextView)findViewById(2130903109);
      File file = new File("/data/data/su.sniff.cepter/files/exitc.id");
      if (file.exists())
        file.delete(); 
      ((Button)findViewById(2130903054)).setText("Stop");
      (new Thread(new a(this, textView))).start();
      return;
    } 
    ((Button)findViewById(2130903054)).setText("Run ARP Cage");
    this.a = 0;
    try {
      openFileOutput("exitc.id", 0).close();
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: ldc 2130968578
    //   8: invokevirtual setContentView : (I)V
    //   11: getstatic su/sniff/cepter/b.o : I
    //   14: ifne -> 24
    //   17: iconst_1
    //   18: putstatic su/sniff/cepter/b.o : I
    //   21: goto -> 46
    //   24: getstatic su/sniff/cepter/b.o : I
    //   27: iconst_1
    //   28: if_icmpne -> 17
    //   31: lconst_1
    //   32: invokestatic sleep : (J)V
    //   35: goto -> 24
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual printStackTrace : ()V
    //   43: goto -> 24
    //   46: aload_0
    //   47: ldc 2130903109
    //   49: invokevirtual findViewById : (I)Landroid/view/View;
    //   52: checkcast android/widget/TextView
    //   55: iconst_2
    //   56: getstatic su/sniff/cepter/b.q : I
    //   59: iconst_3
    //   60: iadd
    //   61: i2f
    //   62: invokevirtual setTextSize : (IF)V
    //   65: iconst_0
    //   66: putstatic su/sniff/cepter/b.o : I
    //   69: return
    // Exception table:
    //   from	to	target	type
    //   31	35	38	java/lang/InterruptedException
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      try {
        openFileOutput("exitc.id", 0).close();
      } catch (FileNotFoundException null) {
        iOException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      finish();
      return true;
    } 
    return super.onKeyDown(paramInt, (KeyEvent)iOException);
  }
  
  class a implements Runnable {
    a(CageActivity this$0, TextView param1TextView) {}
    
    public void run() {
      try {
        Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
        DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/su.sniff.cepter/files/cepter ");
        stringBuilder.append(Integer.toString(b.a));
        stringBuilder.append(" cage ");
        stringBuilder.append(b.G);
        stringBuilder.append("\n");
        dataOutputStream.writeBytes(stringBuilder.toString());
        dataOutputStream.flush();
        dataOutputStream.writeBytes("exit\n");
        dataOutputStream.flush();
        dataOutputStream.close();
        while (true) {
          String str = bufferedReader.readLine();
          if (str != null) {
            this.b.runOnUiThread(new a(this, str));
            continue;
          } 
          bufferedReader.close();
          process.waitFor();
          return;
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
        return;
      } 
    }
    
    class a implements Runnable {
      a(CageActivity.a this$0, String param2String) {}
      
      public void run() {
        this.b.a.append(this.a);
        this.b.a.append("\n");
      }
    }
  }
  
  class a implements Runnable {
    a(CageActivity this$0, String param1String) {}
    
    public void run() {
      this.b.a.append(this.a);
      this.b.a.append("\n");
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\CageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */