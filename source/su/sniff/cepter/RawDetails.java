package su.sniff.cepter;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class RawDetails extends Activity {
  ScaleGestureDetector a;
  
  TextView b;
  
  ScrollView c;
  
  int d = 0;
  
  public void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: ldc 2130968592
    //   8: invokevirtual setContentView : (I)V
    //   11: aload_0
    //   12: invokevirtual getIntent : ()Landroid/content/Intent;
    //   15: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   18: ldc 'Key_Int'
    //   20: iconst_0
    //   21: invokevirtual getInt : (Ljava/lang/String;I)I
    //   24: istore_2
    //   25: getstatic su/sniff/cepter/b.o : I
    //   28: ifne -> 38
    //   31: iconst_1
    //   32: putstatic su/sniff/cepter/b.o : I
    //   35: goto -> 60
    //   38: getstatic su/sniff/cepter/b.o : I
    //   41: iconst_1
    //   42: if_icmpne -> 31
    //   45: lconst_1
    //   46: invokestatic sleep : (J)V
    //   49: goto -> 38
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual printStackTrace : ()V
    //   57: goto -> 38
    //   60: aload_0
    //   61: aload_0
    //   62: ldc 2130903091
    //   64: invokevirtual findViewById : (I)Landroid/view/View;
    //   67: checkcast android/widget/ScrollView
    //   70: putfield c : Landroid/widget/ScrollView;
    //   73: aload_0
    //   74: ldc 2130903109
    //   76: invokevirtual findViewById : (I)Landroid/view/View;
    //   79: checkcast android/widget/TextView
    //   82: astore_1
    //   83: aload_0
    //   84: aload_1
    //   85: putfield b : Landroid/widget/TextView;
    //   88: aload_1
    //   89: getstatic android/graphics/Typeface.MONOSPACE : Landroid/graphics/Typeface;
    //   92: invokevirtual setTypeface : (Landroid/graphics/Typeface;)V
    //   95: aload_0
    //   96: getfield b : Landroid/widget/TextView;
    //   99: iconst_2
    //   100: getstatic su/sniff/cepter/b.q : I
    //   103: i2f
    //   104: invokevirtual setTextSize : (IF)V
    //   107: aload_0
    //   108: new android/view/ScaleGestureDetector
    //   111: dup
    //   112: aload_0
    //   113: new su/sniff/cepter/RawDetails$b
    //   116: dup
    //   117: aload_0
    //   118: invokespecial <init> : (Lsu/sniff/cepter/RawDetails;)V
    //   121: invokespecial <init> : (Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V
    //   124: putfield a : Landroid/view/ScaleGestureDetector;
    //   127: aload_0
    //   128: getfield c : Landroid/widget/ScrollView;
    //   131: new su/sniff/cepter/RawDetails$a
    //   134: dup
    //   135: aload_0
    //   136: invokespecial <init> : (Lsu/sniff/cepter/RawDetails;)V
    //   139: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   142: new java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial <init> : ()V
    //   149: astore_1
    //   150: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   153: ldc 'su'
    //   155: aconst_null
    //   156: new java/io/File
    //   159: dup
    //   160: ldc '/data/data/su.sniff.cepter/files'
    //   162: invokespecial <init> : (Ljava/lang/String;)V
    //   165: invokevirtual exec : (Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;
    //   168: astore #4
    //   170: new java/io/DataOutputStream
    //   173: dup
    //   174: aload #4
    //   176: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   179: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   182: astore_3
    //   183: new java/io/BufferedReader
    //   186: dup
    //   187: new java/io/InputStreamReader
    //   190: dup
    //   191: aload #4
    //   193: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   196: invokespecial <init> : (Ljava/io/InputStream;)V
    //   199: invokespecial <init> : (Ljava/io/Reader;)V
    //   202: astore #4
    //   204: new java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial <init> : ()V
    //   211: astore #5
    //   213: aload #5
    //   215: ldc '/data/data/su.sniff.cepter/files/busybox cat /data/data/su.sniff.cepter/files/Raw/'
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload #5
    //   223: iload_2
    //   224: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload #5
    //   230: ldc '.dat\\n'
    //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: aload #5
    //   239: invokevirtual toString : ()Ljava/lang/String;
    //   242: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   245: aload_3
    //   246: invokevirtual flush : ()V
    //   249: aload_3
    //   250: ldc 'exit\\n'
    //   252: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   255: aload_3
    //   256: invokevirtual flush : ()V
    //   259: aload_3
    //   260: invokevirtual close : ()V
    //   263: aload #4
    //   265: invokevirtual readLine : ()Ljava/lang/String;
    //   268: astore_3
    //   269: aload_3
    //   270: ifnull -> 289
    //   273: aload_1
    //   274: aload_3
    //   275: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload_1
    //   280: ldc '\\n'
    //   282: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: goto -> 263
    //   289: aload #4
    //   291: invokevirtual close : ()V
    //   294: goto -> 302
    //   297: astore_3
    //   298: aload_3
    //   299: invokevirtual printStackTrace : ()V
    //   302: aload_0
    //   303: getfield b : Landroid/widget/TextView;
    //   306: aload_1
    //   307: invokevirtual toString : ()Ljava/lang/String;
    //   310: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   313: iconst_0
    //   314: putstatic su/sniff/cepter/b.o : I
    //   317: return
    // Exception table:
    //   from	to	target	type
    //   45	49	52	java/lang/InterruptedException
    //   150	263	297	java/io/IOException
    //   263	269	297	java/io/IOException
    //   273	286	297	java/io/IOException
    //   289	294	297	java/io/IOException
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      finish();
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a implements View.OnTouchListener {
    a(RawDetails this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      this.a.a.onTouchEvent(param1MotionEvent);
      return false;
    }
  }
  
  public class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    public b(RawDetails this$0) {}
    
    public boolean onScale(ScaleGestureDetector param1ScaleGestureDetector) {
      float f = param1ScaleGestureDetector.getScaleFactor();
      if (f < 1.0F) {
        RawDetails rawDetails = this.a;
        int i = rawDetails.d + 1;
        rawDetails.d = i;
        if (i > 10) {
          i = b.q - 1;
          b.q = i;
          rawDetails.b.setTextSize(i);
          this.a.d = 0;
        } 
      } 
      if (f > 1.0F) {
        RawDetails rawDetails = this.a;
        int i = rawDetails.d + 1;
        rawDetails.d = i;
        if (i > 10) {
          i = b.q + 1;
          b.q = i;
          rawDetails.b.setTextSize(i);
          this.a.d = 0;
        } 
      } 
      return true;
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\RawDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */