package su.sniff.cepter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PortScan extends Activity {
  Context a;
  
  String b;
  
  String c;
  
  String d;
  
  String e;
  
  int f;
  
  public ListView g;
  
  ArrayAdapter<String> h;
  
  ArrayList<String> i;
  
  int j;
  
  ScaleGestureDetector k;
  
  int l = 0;
  
  int m = 0;
  
  public void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: ldc 2130968591
    //   8: invokevirtual setContentView : (I)V
    //   11: aload_0
    //   12: invokevirtual getIntent : ()Landroid/content/Intent;
    //   15: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   18: ldc 'Key_Int'
    //   20: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: invokevirtual getIntent : ()Landroid/content/Intent;
    //   28: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   31: ldc 'Key_String'
    //   33: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_2
    //   37: getstatic su/sniff/cepter/b.o : I
    //   40: ifne -> 50
    //   43: iconst_1
    //   44: putstatic su/sniff/cepter/b.o : I
    //   47: goto -> 72
    //   50: getstatic su/sniff/cepter/b.o : I
    //   53: iconst_1
    //   54: if_icmpne -> 43
    //   57: lconst_1
    //   58: invokestatic sleep : (J)V
    //   61: goto -> 50
    //   64: astore_3
    //   65: aload_3
    //   66: invokevirtual printStackTrace : ()V
    //   69: goto -> 50
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield l : I
    //   77: aload_0
    //   78: aload_0
    //   79: putfield a : Landroid/content/Context;
    //   82: aload_0
    //   83: new android/view/ScaleGestureDetector
    //   86: dup
    //   87: aload_0
    //   88: new su/sniff/cepter/PortScan$e
    //   91: dup
    //   92: aload_0
    //   93: invokespecial <init> : (Lsu/sniff/cepter/PortScan;)V
    //   96: invokespecial <init> : (Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V
    //   99: putfield k : Landroid/view/ScaleGestureDetector;
    //   102: aload_0
    //   103: ldc 2130903090
    //   105: invokevirtual findViewById : (I)Landroid/view/View;
    //   108: checkcast android/widget/ProgressBar
    //   111: astore_3
    //   112: aload_0
    //   113: aload_0
    //   114: ldc 2130903082
    //   116: invokevirtual findViewById : (I)Landroid/view/View;
    //   119: checkcast android/widget/ListView
    //   122: putfield g : Landroid/widget/ListView;
    //   125: aload_0
    //   126: new java/util/ArrayList
    //   129: dup
    //   130: invokespecial <init> : ()V
    //   133: putfield i : Ljava/util/ArrayList;
    //   136: new su/sniff/cepter/PortScan$d
    //   139: dup
    //   140: aload_0
    //   141: aload_0
    //   142: ldc 2130968588
    //   144: ldc 2130903081
    //   146: aload_0
    //   147: getfield i : Ljava/util/ArrayList;
    //   150: invokespecial <init> : (Lsu/sniff/cepter/PortScan;Landroid/content/Context;IILjava/util/List;)V
    //   153: astore #4
    //   155: aload_0
    //   156: getfield g : Landroid/widget/ListView;
    //   159: aload #4
    //   161: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   164: aload_0
    //   165: aload #4
    //   167: putfield h : Landroid/widget/ArrayAdapter;
    //   170: aload_0
    //   171: getfield g : Landroid/widget/ListView;
    //   174: new su/sniff/cepter/PortScan$a
    //   177: dup
    //   178: aload_0
    //   179: aload_1
    //   180: invokespecial <init> : (Lsu/sniff/cepter/PortScan;Ljava/lang/String;)V
    //   183: invokevirtual setOnItemLongClickListener : (Landroid/widget/AdapterView$OnItemLongClickListener;)V
    //   186: aload_0
    //   187: getfield g : Landroid/widget/ListView;
    //   190: new su/sniff/cepter/PortScan$b
    //   193: dup
    //   194: aload_0
    //   195: invokespecial <init> : (Lsu/sniff/cepter/PortScan;)V
    //   198: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   201: new java/lang/Thread
    //   204: dup
    //   205: new su/sniff/cepter/PortScan$c
    //   208: dup
    //   209: aload_0
    //   210: aload_1
    //   211: aload_2
    //   212: aload_3
    //   213: invokespecial <init> : (Lsu/sniff/cepter/PortScan;Ljava/lang/String;Ljava/lang/String;Landroid/widget/ProgressBar;)V
    //   216: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   219: invokevirtual start : ()V
    //   222: iconst_0
    //   223: putstatic su/sniff/cepter/b.o : I
    //   226: return
    // Exception table:
    //   from	to	target	type
    //   57	61	64	java/lang/InterruptedException
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      finish();
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a implements AdapterView.OnItemLongClickListener {
    a(PortScan this$0, String param1String) {}
    
    public boolean onItemLongClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      AlertDialog.Builder builder = new AlertDialog.Builder(this.b.a);
      String str = param1AdapterView.getItemAtPosition(param1Int).toString();
      str = str.substring(1, str.indexOf(" "));
      builder.setTitle("Open in Browser?");
      builder.setPositiveButton("Yes", new a(this, str));
      builder.setNegativeButton("No", new b(this));
      builder.create().show();
      return true;
    }
    
    class a implements DialogInterface.OnClickListener {
      a(PortScan.a this$0, String param2String) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://");
        stringBuilder.append(this.b.a);
        stringBuilder.append(":");
        stringBuilder.append(this.a);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
        this.b.b.startActivity(intent);
        param2DialogInterface.dismiss();
      }
    }
    
    class b implements DialogInterface.OnClickListener {
      b(PortScan.a this$0) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        param2DialogInterface.dismiss();
      }
    }
  }
  
  class a implements DialogInterface.OnClickListener {
    a(PortScan this$0, String param1String) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("http://");
      stringBuilder.append(this.b.a);
      stringBuilder.append(":");
      stringBuilder.append(this.a);
      Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
      this.b.b.startActivity(intent);
      param1DialogInterface.dismiss();
    }
  }
  
  class b implements DialogInterface.OnClickListener {
    b(PortScan this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      param1DialogInterface.dismiss();
    }
  }
  
  class b implements View.OnTouchListener {
    b(PortScan this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      this.a.k.onTouchEvent(param1MotionEvent);
      return false;
    }
  }
  
  class c implements Runnable {
    c(PortScan this$0, String param1String1, String param1String2, ProgressBar param1ProgressBar) {}
    
    public void run() {
      try {
        TextView textView = (TextView)this.d.findViewById(2130903114);
        textView.setTextSize(2, (b.q + 2));
        Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
        DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/su.sniff.cepter/files/cepter ");
        stringBuilder.append(Integer.toString(b.a));
        stringBuilder.append(" -ps ");
        stringBuilder.append(this.a);
        stringBuilder.append(" ");
        stringBuilder.append(this.b);
        stringBuilder.append("\n");
        dataOutputStream.writeBytes(stringBuilder.toString());
        dataOutputStream.flush();
        dataOutputStream.writeBytes("exit\n");
        dataOutputStream.flush();
        dataOutputStream.close();
        new InputStreamReader(process.getInputStream());
        this.d.j = 0;
        this.d.b = null;
        this.d.c = null;
        this.d.d = null;
        String str = bufferedReader.readLine().replace("RNRN", "\n");
        this.d.runOnUiThread(new a(this, textView, str));
        int i = 0;
        while (true) {
          String str1 = bufferedReader.readLine();
          if (str1 != null) {
            str1 = str1.replace("RNRN", "\n");
            int j = i;
            if (str1.indexOf("##CURP##:") != -1) {
              this.d.runOnUiThread(new b(this, ++i));
              j = i;
              if (i == this.d.f) {
                this.c.setProgress(0);
                this.c.setMax(5000);
                (new Thread(new c(this))).start();
                j = i;
              } 
            } 
            this.d.runOnUiThread(new d(this, str1));
            i = j;
            continue;
          } 
          bufferedReader.close();
          process.waitFor();
          this.d.runOnUiThread(new e(this));
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
      a(PortScan.c this$0, TextView param2TextView, String param2String) {}
      
      public void run() {
        this.a.setText(this.b);
      }
    }
    
    class b implements Runnable {
      b(PortScan.c this$0, int param2Int) {}
      
      public void run() {
        this.b.c.setProgress(this.a);
      }
    }
    
    class c implements Runnable {
      c(PortScan.c this$0) {}
      
      public void run() {
        int i = 0;
        while (true) {
          PortScan.c c1 = this.a;
          if (c1.d.l == 0) {
            int j = i;
            if (i >= 5000)
              j = 0; 
            try {
              Thread.sleep(10L);
            } catch (InterruptedException interruptedException) {
              interruptedException.printStackTrace();
            } 
            i = j + 10;
            this.a.d.runOnUiThread(new a(this, i));
            continue;
          } 
          ((PortScan.c)interruptedException).c.setProgress(5000);
          return;
        } 
      }
      
      class a implements Runnable {
        a(PortScan.c.c this$0, int param3Int) {}
        
        public void run() {
          this.b.a.c.setProgress(this.a);
        }
      }
    }
    
    class a implements Runnable {
      a(PortScan.c this$0, int param2Int) {}
      
      public void run() {
        this.b.a.c.setProgress(this.a);
      }
    }
    
    class d implements Runnable {
      d(PortScan.c this$0, String param2String) {}
      
      public void run() {
        int k = this.a.indexOf("##FP##:");
        int i = 0;
        int j = 0;
        if (k != -1) {
          k = this.a.length();
          int m = this.a.indexOf("##FP##:") + 8;
          i = j;
          if (this.b.d.b != null)
            i = 1; 
          this.b.d.b = this.a.substring(m, k - m + 8);
          if (!i) {
            ((ClipboardManager)this.b.d.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Fingerprint", this.b.d.b));
            Toast.makeText(this.b.d.getBaseContext(), "Fingerprint is copied to clipboard", 1).show();
            return;
          } 
        } else {
          if (this.a.indexOf("##FPO##:") != -1) {
            i = this.a.length();
            j = this.a.indexOf("##FPO##:") + 9;
            this.b.d.c = this.a.substring(j, i - j + 9);
            return;
          } 
          if (this.a.indexOf("##UPT##:") != -1) {
            i = this.a.length();
            j = this.a.indexOf("##UPT##:") + 9;
            this.b.d.e = this.a.substring(j, i - j + 9);
            return;
          } 
          if (this.a.indexOf("##TP##:") != -1) {
            i = this.a.length();
            j = this.a.indexOf("##TP##:") + 8;
            this.b.d.f = Integer.parseInt(this.a.substring(j, i - j + 8));
            this.b.c.setProgress(0);
            PortScan.c c1 = this.b;
            c1.c.setMax(c1.d.f);
            return;
          } 
          if (this.a.indexOf("##CURP##:") != -1)
            return; 
          if (this.a.indexOf("##TOP##:") != -1) {
            i = this.a.length();
            j = this.a.indexOf("##TOP##:") + 9;
            TextView textView = (TextView)this.b.d.findViewById(2130903110);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Open ports: ");
            stringBuilder.append(this.a.substring(j, i - j + 9));
            textView.setText(stringBuilder.toString());
            return;
          } 
          if (this.a.indexOf("##OS##:") != -1) {
            i = this.a.length();
            j = this.a.indexOf("##OS##:") + 8;
            this.b.d.d = this.a.substring(j, i - j + 8);
            return;
          } 
          if (this.a.indexOf("#/") != -1) {
            j = this.a.length();
            k = this.a.indexOf("/#:");
            String str1 = this.a.substring(2, k);
            String str2 = this.a.substring(k + 4, j);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str1);
            stringBuilder.append(" ");
            stringBuilder.append(str2);
            stringBuilder.toString();
            if (this.b.d.g.getCount() > 0) {
              j = this.b.d.g.getCount();
              while (i < j) {
                String str = this.b.d.g.getAdapter().getItem(i).toString();
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(str1);
                stringBuilder1.append(" ");
                if (str.indexOf(stringBuilder1.toString()) != -1) {
                  str = this.b.d.g.getAdapter().getItem(i).toString();
                  stringBuilder1 = new StringBuilder();
                  stringBuilder1.append(str);
                  stringBuilder1.append("\n");
                  stringBuilder1.append(str2);
                  str = stringBuilder1.toString().replace("\n\n\n", "\n\n");
                  this.b.d.i.set(i, str);
                  this.b.d.h.notifyDataSetChanged();
                  this.b.d.g.getChildAt(i);
                } 
                i++;
              } 
            } 
          } else {
            ArrayList<String> arrayList = this.b.d.i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("\n");
            arrayList.add(stringBuilder.toString());
            this.b.d.h.notifyDataSetChanged();
          } 
        } 
      }
    }
    
    class e implements Runnable {
      e(PortScan.c this$0) {}
      
      public void run() {
        if (this.a.d.d != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("OS by TTL\\WS: \n");
          stringBuilder.append(this.a.d.d);
          stringBuilder.append("\n\n");
          str2 = stringBuilder.toString();
        } else {
          str2 = "";
        } 
        String str1 = str2;
        if (this.a.d.c != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str2);
          stringBuilder.append("OS by Fingerprint: \n");
          stringBuilder.append(this.a.d.c);
          stringBuilder.append("\n\n");
          str1 = stringBuilder.toString();
        } 
        String str2 = str1;
        if (this.a.d.b != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str1);
          stringBuilder.append("TCP Fingerprint: \n");
          stringBuilder.append(this.a.d.b);
          str2 = stringBuilder.toString();
        } 
        str1 = str2;
        if (this.a.d.e != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str2);
          stringBuilder.append("\n\nUptime by TS: \n");
          stringBuilder.append(this.a.d.e);
          str1 = stringBuilder.toString();
        } 
        TextView textView = (TextView)this.a.d.findViewById(2130903114);
        if (str1.length() > 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("\n\n");
          stringBuilder.append(str1);
          textView.append(stringBuilder.toString());
        } 
        textView.append("\n\nX-Scan completed");
        this.a.d.l = 1;
      }
    }
  }
  
  class a implements Runnable {
    a(PortScan this$0, TextView param1TextView, String param1String) {}
    
    public void run() {
      this.a.setText(this.b);
    }
  }
  
  class b implements Runnable {
    b(PortScan this$0, int param1Int) {}
    
    public void run() {
      this.b.c.setProgress(this.a);
    }
  }
  
  class c implements Runnable {
    c(PortScan this$0) {}
    
    public void run() {
      int i = 0;
      while (true) {
        PortScan.c c1 = this.a;
        if (c1.d.l == 0) {
          int j = i;
          if (i >= 5000)
            j = 0; 
          try {
            Thread.sleep(10L);
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          i = j + 10;
          this.a.d.runOnUiThread(new a(this, i));
          continue;
        } 
        ((PortScan.c)interruptedException).c.setProgress(5000);
        return;
      } 
    }
    
    class a implements Runnable {
      a(PortScan.c.c this$0, int param3Int) {}
      
      public void run() {
        this.b.a.c.setProgress(this.a);
      }
    }
  }
  
  class a implements Runnable {
    a(PortScan this$0, int param1Int) {}
    
    public void run() {
      this.b.a.c.setProgress(this.a);
    }
  }
  
  class d implements Runnable {
    d(PortScan this$0, String param1String) {}
    
    public void run() {
      int k = this.a.indexOf("##FP##:");
      int i = 0;
      int j = 0;
      if (k != -1) {
        k = this.a.length();
        int m = this.a.indexOf("##FP##:") + 8;
        i = j;
        if (this.b.d.b != null)
          i = 1; 
        this.b.d.b = this.a.substring(m, k - m + 8);
        if (!i) {
          ((ClipboardManager)this.b.d.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Fingerprint", this.b.d.b));
          Toast.makeText(this.b.d.getBaseContext(), "Fingerprint is copied to clipboard", 1).show();
          return;
        } 
      } else {
        if (this.a.indexOf("##FPO##:") != -1) {
          i = this.a.length();
          j = this.a.indexOf("##FPO##:") + 9;
          this.b.d.c = this.a.substring(j, i - j + 9);
          return;
        } 
        if (this.a.indexOf("##UPT##:") != -1) {
          i = this.a.length();
          j = this.a.indexOf("##UPT##:") + 9;
          this.b.d.e = this.a.substring(j, i - j + 9);
          return;
        } 
        if (this.a.indexOf("##TP##:") != -1) {
          i = this.a.length();
          j = this.a.indexOf("##TP##:") + 8;
          this.b.d.f = Integer.parseInt(this.a.substring(j, i - j + 8));
          this.b.c.setProgress(0);
          PortScan.c c1 = this.b;
          c1.c.setMax(c1.d.f);
          return;
        } 
        if (this.a.indexOf("##CURP##:") != -1)
          return; 
        if (this.a.indexOf("##TOP##:") != -1) {
          i = this.a.length();
          j = this.a.indexOf("##TOP##:") + 9;
          TextView textView = (TextView)this.b.d.findViewById(2130903110);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Open ports: ");
          stringBuilder.append(this.a.substring(j, i - j + 9));
          textView.setText(stringBuilder.toString());
          return;
        } 
        if (this.a.indexOf("##OS##:") != -1) {
          i = this.a.length();
          j = this.a.indexOf("##OS##:") + 8;
          this.b.d.d = this.a.substring(j, i - j + 8);
          return;
        } 
        if (this.a.indexOf("#/") != -1) {
          j = this.a.length();
          k = this.a.indexOf("/#:");
          String str1 = this.a.substring(2, k);
          String str2 = this.a.substring(k + 4, j);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str1);
          stringBuilder.append(" ");
          stringBuilder.append(str2);
          stringBuilder.toString();
          if (this.b.d.g.getCount() > 0) {
            j = this.b.d.g.getCount();
            while (i < j) {
              String str = this.b.d.g.getAdapter().getItem(i).toString();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(str1);
              stringBuilder1.append(" ");
              if (str.indexOf(stringBuilder1.toString()) != -1) {
                str = this.b.d.g.getAdapter().getItem(i).toString();
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append(str);
                stringBuilder1.append("\n");
                stringBuilder1.append(str2);
                str = stringBuilder1.toString().replace("\n\n\n", "\n\n");
                this.b.d.i.set(i, str);
                this.b.d.h.notifyDataSetChanged();
                this.b.d.g.getChildAt(i);
              } 
              i++;
            } 
          } 
        } else {
          ArrayList<String> arrayList = this.b.d.i;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.a);
          stringBuilder.append("\n");
          arrayList.add(stringBuilder.toString());
          this.b.d.h.notifyDataSetChanged();
        } 
      } 
    }
  }
  
  class e implements Runnable {
    e(PortScan this$0) {}
    
    public void run() {
      if (this.a.d.d != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OS by TTL\\WS: \n");
        stringBuilder.append(this.a.d.d);
        stringBuilder.append("\n\n");
        str2 = stringBuilder.toString();
      } else {
        str2 = "";
      } 
      String str1 = str2;
      if (this.a.d.c != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("OS by Fingerprint: \n");
        stringBuilder.append(this.a.d.c);
        stringBuilder.append("\n\n");
        str1 = stringBuilder.toString();
      } 
      String str2 = str1;
      if (this.a.d.b != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append("TCP Fingerprint: \n");
        stringBuilder.append(this.a.d.b);
        str2 = stringBuilder.toString();
      } 
      str1 = str2;
      if (this.a.d.e != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n\nUptime by TS: \n");
        stringBuilder.append(this.a.d.e);
        str1 = stringBuilder.toString();
      } 
      TextView textView = (TextView)this.a.d.findViewById(2130903114);
      if (str1.length() > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\n");
        stringBuilder.append(str1);
        textView.append(stringBuilder.toString());
      } 
      textView.append("\n\nX-Scan completed");
      this.a.d.l = 1;
    }
  }
  
  private class d<T> extends ArrayAdapter<T> {
    public d(PortScan this$0, Context param1Context, int param1Int1, int param1Int2, List<T> param1List) {
      super(param1Context, param1Int1, param1Int2, param1List);
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      View view = super.getView(param1Int, param1View, param1ViewGroup);
      TextView textView = (TextView)view.findViewById(2130903081);
      textView.setTextSize(2, (b.q + 2));
      ((TextView)this.a.findViewById(2130903114)).setTextSize(2, (b.q + 2));
      String str2 = textView.getText().toString();
      param1Int = str2.indexOf("\n\n");
      String str1 = "";
      if (param1Int != -1) {
        str1 = str2.substring(0, param1Int);
        str2 = str2.substring(param1Int, str2.length());
      } else {
        str2 = "";
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(str2);
      SpannableString spannableString = new SpannableString(stringBuilder.toString());
      spannableString.setSpan(new StyleSpan(1), 0, str1.length(), 33);
      spannableString.setSpan(new AbsoluteSizeSpan(b.q + 5, true), 0, str1.length(), 33);
      spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#5AB6B6")), 0, str1.length(), 33);
      textView.setText((CharSequence)spannableString);
      return view;
    }
  }
  
  public class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    public e(PortScan this$0) {}
    
    public boolean onScale(ScaleGestureDetector param1ScaleGestureDetector) {
      float f = param1ScaleGestureDetector.getScaleFactor();
      if (f < 1.0F) {
        PortScan portScan = this.a;
        int i = portScan.m + 1;
        portScan.m = i;
        if (i > 10) {
          b.q--;
          portScan.g.invalidateViews();
          this.a.m = 0;
        } 
      } 
      if (f > 1.0F) {
        PortScan portScan = this.a;
        int i = portScan.m + 1;
        portScan.m = i;
        if (i > 10) {
          b.q++;
          portScan.g.invalidateViews();
          this.a.m = 0;
        } 
      } 
      return true;
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\PortScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */