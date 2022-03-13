package su.sniff.cepter;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;

public class DiagnosticsActivity extends Activity {
  public boolean a(String paramString1, String paramString2) {
    Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
    DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    dataOutputStream.writeBytes(paramString1);
    dataOutputStream.flush();
    dataOutputStream.writeBytes("exit\n");
    dataOutputStream.flush();
    dataOutputStream.close();
    while (true) {
      paramString1 = bufferedReader.readLine();
      if (paramString1 != null) {
        if (paramString1.indexOf(paramString2) != -1) {
          bufferedReader.close();
          return true;
        } 
        continue;
      } 
      bufferedReader.close();
      return false;
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968581);
    TextView textView = (TextView)findViewById(2130903109);
    textView.setTextSize(2, (b.q + 3));
    textView.append("* Starting self diagnosis...\n\n");
    (new Thread(new a(this, textView))).start();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      finish();
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a implements Runnable {
    a(DiagnosticsActivity this$0, TextView param1TextView) {}
    
    public void run() {
      this.b.runOnUiThread(new a(this));
    }
    
    class a implements Runnable {
      a(DiagnosticsActivity.a this$0) {}
      
      public void run() {
        // Byte code:
        //   0: aload_0
        //   1: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   4: getfield b : Lsu/sniff/cepter/DiagnosticsActivity;
        //   7: ldc 'getenforce\\n'
        //   9: ldc 'Enforcing'
        //   11: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Z
        //   14: istore_2
        //   15: iconst_1
        //   16: istore_1
        //   17: iload_2
        //   18: iconst_1
        //   19: if_icmpne -> 411
        //   22: goto -> 25
        //   25: aload_0
        //   26: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   29: getfield a : Landroid/widget/TextView;
        //   32: astore_3
        //   33: new java/lang/StringBuilder
        //   36: dup
        //   37: invokespecial <init> : ()V
        //   40: astore #4
        //   42: aload #4
        //   44: ldc '* API '
        //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   49: pop
        //   50: aload #4
        //   52: getstatic android/os/Build$VERSION.SDK_INT : I
        //   55: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   58: pop
        //   59: aload #4
        //   61: ldc ' on '
        //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: pop
        //   67: aload #4
        //   69: getstatic android/os/Build.CPU_ABI : Ljava/lang/String;
        //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   75: pop
        //   76: aload #4
        //   78: ldc '\\n\\n'
        //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   83: pop
        //   84: aload_3
        //   85: aload #4
        //   87: invokevirtual toString : ()Ljava/lang/String;
        //   90: invokevirtual append : (Ljava/lang/CharSequence;)V
        //   93: aload_0
        //   94: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   97: getfield a : Landroid/widget/TextView;
        //   100: ldc '* Getting SELinux state\\n'
        //   102: invokevirtual append : (Ljava/lang/CharSequence;)V
        //   105: iload_1
        //   106: ifne -> 130
        //   109: aload_0
        //   110: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   113: getfield a : Landroid/widget/TextView;
        //   116: astore_3
        //   117: ldc '+ GOOD: [Permissive]\\n\\n'
        //   119: astore #4
        //   121: aload_3
        //   122: aload #4
        //   124: invokevirtual append : (Ljava/lang/CharSequence;)V
        //   127: goto -> 145
        //   130: aload_0
        //   131: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   134: getfield a : Landroid/widget/TextView;
        //   137: astore_3
        //   138: ldc '- BAD: [Enforcing]\\n\\n'
        //   140: astore #4
        //   142: goto -> 121
        //   145: invokestatic getRuntime : ()Ljava/lang/Runtime;
        //   148: ldc 'su'
        //   150: aconst_null
        //   151: new java/io/File
        //   154: dup
        //   155: ldc '/data/data/su.sniff.cepter/files'
        //   157: invokespecial <init> : (Ljava/lang/String;)V
        //   160: invokevirtual exec : (Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;
        //   163: astore #4
        //   165: new java/io/DataOutputStream
        //   168: dup
        //   169: aload #4
        //   171: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
        //   174: invokespecial <init> : (Ljava/io/OutputStream;)V
        //   177: astore_3
        //   178: new java/io/BufferedReader
        //   181: dup
        //   182: new java/io/InputStreamReader
        //   185: dup
        //   186: aload #4
        //   188: invokevirtual getInputStream : ()Ljava/io/InputStream;
        //   191: invokespecial <init> : (Ljava/io/InputStream;)V
        //   194: invokespecial <init> : (Ljava/io/Reader;)V
        //   197: astore #4
        //   199: new java/lang/StringBuilder
        //   202: dup
        //   203: invokespecial <init> : ()V
        //   206: astore #5
        //   208: aload #5
        //   210: ldc '/data/data/su.sniff.cepter/files/cepter '
        //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   215: pop
        //   216: aload #5
        //   218: getstatic su/sniff/cepter/b.a : I
        //   221: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   224: pop
        //   225: aload #5
        //   227: ldc ' diag '
        //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   232: pop
        //   233: aload #5
        //   235: getstatic su/sniff/cepter/b.G : Ljava/lang/String;
        //   238: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   241: pop
        //   242: aload #5
        //   244: getstatic su/sniff/cepter/b.I : Ljava/lang/String;
        //   247: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   250: pop
        //   251: aload #5
        //   253: ldc '\\n'
        //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   258: pop
        //   259: aload_3
        //   260: aload #5
        //   262: invokevirtual toString : ()Ljava/lang/String;
        //   265: invokevirtual writeBytes : (Ljava/lang/String;)V
        //   268: aload_3
        //   269: invokevirtual flush : ()V
        //   272: aload_3
        //   273: ldc 'exit\\n'
        //   275: invokevirtual writeBytes : (Ljava/lang/String;)V
        //   278: aload_3
        //   279: invokevirtual flush : ()V
        //   282: aload_3
        //   283: invokevirtual close : ()V
        //   286: aload #4
        //   288: invokevirtual readLine : ()Ljava/lang/String;
        //   291: astore_3
        //   292: aload_3
        //   293: ifnull -> 322
        //   296: aload_0
        //   297: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   300: getfield a : Landroid/widget/TextView;
        //   303: aload_3
        //   304: invokevirtual append : (Ljava/lang/CharSequence;)V
        //   307: aload_0
        //   308: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   311: getfield a : Landroid/widget/TextView;
        //   314: ldc '\\n'
        //   316: invokevirtual append : (Ljava/lang/CharSequence;)V
        //   319: goto -> 286
        //   322: aload #4
        //   324: invokevirtual close : ()V
        //   327: aload_0
        //   328: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   331: getfield b : Lsu/sniff/cepter/DiagnosticsActivity;
        //   334: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
        //   337: aload_0
        //   338: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   341: getfield b : Lsu/sniff/cepter/DiagnosticsActivity;
        //   344: invokevirtual getPackageName : ()Ljava/lang/String;
        //   347: iconst_0
        //   348: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   351: getfield versionName : Ljava/lang/String;
        //   354: astore_3
        //   355: aload_0
        //   356: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
        //   359: getfield a : Landroid/widget/TextView;
        //   362: astore #4
        //   364: new java/lang/StringBuilder
        //   367: dup
        //   368: invokespecial <init> : ()V
        //   371: astore #5
        //   373: aload #5
        //   375: ldc 'Intercepter-NG version '
        //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   380: pop
        //   381: aload #5
        //   383: aload_3
        //   384: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   387: pop
        //   388: aload #4
        //   390: aload #5
        //   392: invokevirtual toString : ()Ljava/lang/String;
        //   395: invokevirtual append : (Ljava/lang/CharSequence;)V
        //   398: return
        //   399: astore_3
        //   400: aload_3
        //   401: invokevirtual printStackTrace : ()V
        //   404: return
        //   405: astore_3
        //   406: aload_3
        //   407: invokevirtual printStackTrace : ()V
        //   410: return
        //   411: iconst_0
        //   412: istore_1
        //   413: goto -> 25
        // Exception table:
        //   from	to	target	type
        //   0	15	405	java/io/IOException
        //   25	105	405	java/io/IOException
        //   109	117	405	java/io/IOException
        //   121	127	405	java/io/IOException
        //   130	138	405	java/io/IOException
        //   145	286	405	java/io/IOException
        //   286	292	405	java/io/IOException
        //   296	319	405	java/io/IOException
        //   322	327	405	java/io/IOException
        //   327	398	399	android/content/pm/PackageManager$NameNotFoundException
        //   327	398	405	java/io/IOException
        //   400	404	405	java/io/IOException
      }
    }
  }
  
  class a implements Runnable {
    a(DiagnosticsActivity this$0) {}
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   4: getfield b : Lsu/sniff/cepter/DiagnosticsActivity;
      //   7: ldc 'getenforce\\n'
      //   9: ldc 'Enforcing'
      //   11: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Z
      //   14: istore_2
      //   15: iconst_1
      //   16: istore_1
      //   17: iload_2
      //   18: iconst_1
      //   19: if_icmpne -> 411
      //   22: goto -> 25
      //   25: aload_0
      //   26: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   29: getfield a : Landroid/widget/TextView;
      //   32: astore_3
      //   33: new java/lang/StringBuilder
      //   36: dup
      //   37: invokespecial <init> : ()V
      //   40: astore #4
      //   42: aload #4
      //   44: ldc '* API '
      //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: pop
      //   50: aload #4
      //   52: getstatic android/os/Build$VERSION.SDK_INT : I
      //   55: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   58: pop
      //   59: aload #4
      //   61: ldc ' on '
      //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: pop
      //   67: aload #4
      //   69: getstatic android/os/Build.CPU_ABI : Ljava/lang/String;
      //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: pop
      //   76: aload #4
      //   78: ldc '\\n\\n'
      //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: pop
      //   84: aload_3
      //   85: aload #4
      //   87: invokevirtual toString : ()Ljava/lang/String;
      //   90: invokevirtual append : (Ljava/lang/CharSequence;)V
      //   93: aload_0
      //   94: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   97: getfield a : Landroid/widget/TextView;
      //   100: ldc '* Getting SELinux state\\n'
      //   102: invokevirtual append : (Ljava/lang/CharSequence;)V
      //   105: iload_1
      //   106: ifne -> 130
      //   109: aload_0
      //   110: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   113: getfield a : Landroid/widget/TextView;
      //   116: astore_3
      //   117: ldc '+ GOOD: [Permissive]\\n\\n'
      //   119: astore #4
      //   121: aload_3
      //   122: aload #4
      //   124: invokevirtual append : (Ljava/lang/CharSequence;)V
      //   127: goto -> 145
      //   130: aload_0
      //   131: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   134: getfield a : Landroid/widget/TextView;
      //   137: astore_3
      //   138: ldc '- BAD: [Enforcing]\\n\\n'
      //   140: astore #4
      //   142: goto -> 121
      //   145: invokestatic getRuntime : ()Ljava/lang/Runtime;
      //   148: ldc 'su'
      //   150: aconst_null
      //   151: new java/io/File
      //   154: dup
      //   155: ldc '/data/data/su.sniff.cepter/files'
      //   157: invokespecial <init> : (Ljava/lang/String;)V
      //   160: invokevirtual exec : (Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;
      //   163: astore #4
      //   165: new java/io/DataOutputStream
      //   168: dup
      //   169: aload #4
      //   171: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
      //   174: invokespecial <init> : (Ljava/io/OutputStream;)V
      //   177: astore_3
      //   178: new java/io/BufferedReader
      //   181: dup
      //   182: new java/io/InputStreamReader
      //   185: dup
      //   186: aload #4
      //   188: invokevirtual getInputStream : ()Ljava/io/InputStream;
      //   191: invokespecial <init> : (Ljava/io/InputStream;)V
      //   194: invokespecial <init> : (Ljava/io/Reader;)V
      //   197: astore #4
      //   199: new java/lang/StringBuilder
      //   202: dup
      //   203: invokespecial <init> : ()V
      //   206: astore #5
      //   208: aload #5
      //   210: ldc '/data/data/su.sniff.cepter/files/cepter '
      //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   215: pop
      //   216: aload #5
      //   218: getstatic su/sniff/cepter/b.a : I
      //   221: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   224: pop
      //   225: aload #5
      //   227: ldc ' diag '
      //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   232: pop
      //   233: aload #5
      //   235: getstatic su/sniff/cepter/b.G : Ljava/lang/String;
      //   238: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   241: pop
      //   242: aload #5
      //   244: getstatic su/sniff/cepter/b.I : Ljava/lang/String;
      //   247: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   250: pop
      //   251: aload #5
      //   253: ldc '\\n'
      //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   258: pop
      //   259: aload_3
      //   260: aload #5
      //   262: invokevirtual toString : ()Ljava/lang/String;
      //   265: invokevirtual writeBytes : (Ljava/lang/String;)V
      //   268: aload_3
      //   269: invokevirtual flush : ()V
      //   272: aload_3
      //   273: ldc 'exit\\n'
      //   275: invokevirtual writeBytes : (Ljava/lang/String;)V
      //   278: aload_3
      //   279: invokevirtual flush : ()V
      //   282: aload_3
      //   283: invokevirtual close : ()V
      //   286: aload #4
      //   288: invokevirtual readLine : ()Ljava/lang/String;
      //   291: astore_3
      //   292: aload_3
      //   293: ifnull -> 322
      //   296: aload_0
      //   297: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   300: getfield a : Landroid/widget/TextView;
      //   303: aload_3
      //   304: invokevirtual append : (Ljava/lang/CharSequence;)V
      //   307: aload_0
      //   308: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   311: getfield a : Landroid/widget/TextView;
      //   314: ldc '\\n'
      //   316: invokevirtual append : (Ljava/lang/CharSequence;)V
      //   319: goto -> 286
      //   322: aload #4
      //   324: invokevirtual close : ()V
      //   327: aload_0
      //   328: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   331: getfield b : Lsu/sniff/cepter/DiagnosticsActivity;
      //   334: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
      //   337: aload_0
      //   338: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   341: getfield b : Lsu/sniff/cepter/DiagnosticsActivity;
      //   344: invokevirtual getPackageName : ()Ljava/lang/String;
      //   347: iconst_0
      //   348: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
      //   351: getfield versionName : Ljava/lang/String;
      //   354: astore_3
      //   355: aload_0
      //   356: getfield a : Lsu/sniff/cepter/DiagnosticsActivity$a;
      //   359: getfield a : Landroid/widget/TextView;
      //   362: astore #4
      //   364: new java/lang/StringBuilder
      //   367: dup
      //   368: invokespecial <init> : ()V
      //   371: astore #5
      //   373: aload #5
      //   375: ldc 'Intercepter-NG version '
      //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   380: pop
      //   381: aload #5
      //   383: aload_3
      //   384: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   387: pop
      //   388: aload #4
      //   390: aload #5
      //   392: invokevirtual toString : ()Ljava/lang/String;
      //   395: invokevirtual append : (Ljava/lang/CharSequence;)V
      //   398: return
      //   399: astore_3
      //   400: aload_3
      //   401: invokevirtual printStackTrace : ()V
      //   404: return
      //   405: astore_3
      //   406: aload_3
      //   407: invokevirtual printStackTrace : ()V
      //   410: return
      //   411: iconst_0
      //   412: istore_1
      //   413: goto -> 25
      // Exception table:
      //   from	to	target	type
      //   0	15	405	java/io/IOException
      //   25	105	405	java/io/IOException
      //   109	117	405	java/io/IOException
      //   121	127	405	java/io/IOException
      //   130	138	405	java/io/IOException
      //   145	286	405	java/io/IOException
      //   286	292	405	java/io/IOException
      //   296	319	405	java/io/IOException
      //   322	327	405	java/io/IOException
      //   327	398	399	android/content/pm/PackageManager$NameNotFoundException
      //   327	398	405	java/io/IOException
      //   400	404	405	java/io/IOException
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\DiagnosticsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */