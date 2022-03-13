package su.sniff.cepter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class InjectActivity extends Activity {
  public ListView a;
  
  private ArrayAdapter<String> b;
  
  private ArrayList<String> c;
  
  public void OnAdd(View paramView) {
    String str = b.J;
    b b = new b(this);
    (new d((Context)this, str, new String[] { "" }, b)).show();
  }
  
  public void OnClear(View paramView) {
    this.c.clear();
    this.b.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: iconst_3
    //   7: invokevirtual requestWindowFeature : (I)Z
    //   10: pop
    //   11: aload_0
    //   12: ldc 2130968585
    //   14: invokevirtual setContentView : (I)V
    //   17: aload_0
    //   18: invokevirtual getWindow : ()Landroid/view/Window;
    //   21: iconst_3
    //   22: ldc 2130837514
    //   24: invokevirtual setFeatureDrawableResource : (II)V
    //   27: getstatic su/sniff/cepter/b.o : I
    //   30: ifne -> 40
    //   33: iconst_1
    //   34: putstatic su/sniff/cepter/b.o : I
    //   37: goto -> 62
    //   40: getstatic su/sniff/cepter/b.o : I
    //   43: iconst_1
    //   44: if_icmpne -> 33
    //   47: lconst_1
    //   48: invokestatic sleep : (J)V
    //   51: goto -> 40
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual printStackTrace : ()V
    //   59: goto -> 40
    //   62: aload_0
    //   63: new java/util/ArrayList
    //   66: dup
    //   67: invokespecial <init> : ()V
    //   70: putfield c : Ljava/util/ArrayList;
    //   73: aload_0
    //   74: aload_0
    //   75: ldc 2130903082
    //   77: invokevirtual findViewById : (I)Landroid/view/View;
    //   80: checkcast android/widget/ListView
    //   83: putfield a : Landroid/widget/ListView;
    //   86: new android/widget/ArrayAdapter
    //   89: dup
    //   90: aload_0
    //   91: ldc 17367048
    //   93: aload_0
    //   94: getfield c : Ljava/util/ArrayList;
    //   97: invokespecial <init> : (Landroid/content/Context;ILjava/util/List;)V
    //   100: astore_1
    //   101: aload_0
    //   102: aload_1
    //   103: putfield b : Landroid/widget/ArrayAdapter;
    //   106: aload_0
    //   107: getfield a : Landroid/widget/ListView;
    //   110: aload_1
    //   111: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   114: aload_0
    //   115: getfield a : Landroid/widget/ListView;
    //   118: new su/sniff/cepter/InjectActivity$a
    //   121: dup
    //   122: aload_0
    //   123: invokespecial <init> : (Lsu/sniff/cepter/InjectActivity;)V
    //   126: invokevirtual setOnItemLongClickListener : (Landroid/widget/AdapterView$OnItemLongClickListener;)V
    //   129: new android/widget/ArrayAdapter
    //   132: dup
    //   133: aload_0
    //   134: ldc 17367048
    //   136: bipush #17
    //   138: anewarray java/lang/String
    //   141: dup
    //   142: iconst_0
    //   143: ldc '1'
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: ldc '2'
    //   150: aastore
    //   151: dup
    //   152: iconst_2
    //   153: ldc '3'
    //   155: aastore
    //   156: dup
    //   157: iconst_3
    //   158: ldc '4'
    //   160: aastore
    //   161: dup
    //   162: iconst_4
    //   163: ldc '5'
    //   165: aastore
    //   166: dup
    //   167: iconst_5
    //   168: ldc '6'
    //   170: aastore
    //   171: dup
    //   172: bipush #6
    //   174: ldc '7'
    //   176: aastore
    //   177: dup
    //   178: bipush #7
    //   180: ldc '8'
    //   182: aastore
    //   183: dup
    //   184: bipush #8
    //   186: ldc '9'
    //   188: aastore
    //   189: dup
    //   190: bipush #9
    //   192: ldc '10'
    //   194: aastore
    //   195: dup
    //   196: bipush #10
    //   198: ldc '20'
    //   200: aastore
    //   201: dup
    //   202: bipush #11
    //   204: ldc '30'
    //   206: aastore
    //   207: dup
    //   208: bipush #12
    //   210: ldc '40'
    //   212: aastore
    //   213: dup
    //   214: bipush #13
    //   216: ldc '50'
    //   218: aastore
    //   219: dup
    //   220: bipush #14
    //   222: ldc '100'
    //   224: aastore
    //   225: dup
    //   226: bipush #15
    //   228: ldc '500'
    //   230: aastore
    //   231: dup
    //   232: bipush #16
    //   234: ldc '1000'
    //   236: aastore
    //   237: invokespecial <init> : (Landroid/content/Context;I[Ljava/lang/Object;)V
    //   240: astore_1
    //   241: aload_1
    //   242: ldc 17367049
    //   244: invokevirtual setDropDownViewResource : (I)V
    //   247: aload_0
    //   248: ldc 2130903107
    //   250: invokevirtual findViewById : (I)Landroid/view/View;
    //   253: checkcast android/widget/Spinner
    //   256: aload_1
    //   257: invokevirtual setAdapter : (Landroid/widget/SpinnerAdapter;)V
    //   260: new android/widget/ArrayAdapter
    //   263: dup
    //   264: aload_0
    //   265: ldc 17367048
    //   267: bipush #9
    //   269: anewarray java/lang/String
    //   272: dup
    //   273: iconst_0
    //   274: ldc '*select pattern*'
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: ldc '.js'
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: ldc '.jpg'
    //   286: aastore
    //   287: dup
    //   288: iconst_3
    //   289: ldc '.jpeg'
    //   291: aastore
    //   292: dup
    //   293: iconst_4
    //   294: ldc '.png'
    //   296: aastore
    //   297: dup
    //   298: iconst_5
    //   299: ldc '.exe'
    //   301: aastore
    //   302: dup
    //   303: bipush #6
    //   305: ldc '.html'
    //   307: aastore
    //   308: dup
    //   309: bipush #7
    //   311: ldc '.htm'
    //   313: aastore
    //   314: dup
    //   315: bipush #8
    //   317: ldc '.txt'
    //   319: aastore
    //   320: invokespecial <init> : (Landroid/content/Context;I[Ljava/lang/Object;)V
    //   323: astore_2
    //   324: aload_2
    //   325: ldc 17367049
    //   327: invokevirtual setDropDownViewResource : (I)V
    //   330: aload_0
    //   331: ldc 2130903104
    //   333: invokevirtual findViewById : (I)Landroid/view/View;
    //   336: checkcast android/widget/Spinner
    //   339: aload_2
    //   340: invokevirtual setAdapter : (Landroid/widget/SpinnerAdapter;)V
    //   343: new java/io/BufferedReader
    //   346: dup
    //   347: new java/io/FileReader
    //   350: dup
    //   351: new java/io/File
    //   354: dup
    //   355: ldc '/data/data/su.sniff.cepter/files/inj'
    //   357: invokespecial <init> : (Ljava/lang/String;)V
    //   360: invokespecial <init> : (Ljava/io/File;)V
    //   363: invokespecial <init> : (Ljava/io/Reader;)V
    //   366: astore_2
    //   367: aload_2
    //   368: invokevirtual readLine : ()Ljava/lang/String;
    //   371: astore_3
    //   372: aload_3
    //   373: ifnull -> 392
    //   376: aload_0
    //   377: getfield c : Ljava/util/ArrayList;
    //   380: aload_3
    //   381: invokevirtual add : (Ljava/lang/Object;)Z
    //   384: pop
    //   385: aload_1
    //   386: invokevirtual notifyDataSetChanged : ()V
    //   389: goto -> 367
    //   392: aload_2
    //   393: invokevirtual close : ()V
    //   396: goto -> 404
    //   399: astore_1
    //   400: aload_1
    //   401: invokevirtual printStackTrace : ()V
    //   404: iconst_0
    //   405: putstatic su/sniff/cepter/b.o : I
    //   408: return
    //   409: astore_1
    //   410: goto -> 404
    // Exception table:
    //   from	to	target	type
    //   47	51	54	java/lang/InterruptedException
    //   343	367	409	java/io/FileNotFoundException
    //   343	367	399	java/io/IOException
    //   367	372	409	java/io/FileNotFoundException
    //   367	372	399	java/io/IOException
    //   376	389	409	java/io/FileNotFoundException
    //   376	389	399	java/io/IOException
    //   392	396	409	java/io/FileNotFoundException
    //   392	396	399	java/io/IOException
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      paramInt = 0;
      try {
        FileOutputStream fileOutputStream = openFileOutput("inj", 0);
        while (paramInt < this.c.size()) {
          fileOutputStream.write(((String)this.c.get(paramInt)).getBytes());
          fileOutputStream.write("\n".getBytes());
          paramInt++;
        } 
        fileOutputStream.close();
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
  
  class a implements AdapterView.OnItemLongClickListener {
    a(InjectActivity this$0) {}
    
    public boolean onItemLongClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      InjectActivity.a(this.a).remove(param1Int);
      InjectActivity.b(this.a).notifyDataSetChanged();
      return true;
    }
  }
  
  class b implements d.c {
    b(InjectActivity this$0) {}
    
    public void a(File param1File) {
      Spinner spinner2 = (Spinner)this.a.findViewById(2130903104);
      Spinner spinner1 = (Spinner)this.a.findViewById(2130903107);
      String str2 = spinner2.getSelectedItem().toString();
      String str3 = spinner1.getSelectedItem().toString();
      int i = spinner2.getSelectedItemPosition();
      (new String[9])[0] = "";
      (new String[9])[1] = "application/javascript";
      (new String[9])[2] = "image/jpeg";
      (new String[9])[3] = "image/jpeg";
      (new String[9])[4] = "image/png";
      (new String[9])[5] = "application/octet-stream";
      (new String[9])[6] = "text/html";
      (new String[9])[7] = "text/html";
      (new String[9])[8] = "text/plain";
      String str4 = (new String[9])[i];
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str2);
      stringBuilder2.append(";");
      stringBuilder2.append(str4);
      stringBuilder2.append(";");
      stringBuilder2.append(str3);
      stringBuilder2.append(";");
      str2 = stringBuilder2.toString();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append(param1File.getAbsolutePath());
      stringBuilder1.append(";");
      String str1 = stringBuilder1.toString();
      this.a.runOnUiThread(new a(this, str1));
    }
    
    class a implements Runnable {
      a(InjectActivity.b this$0, String param2String) {}
      
      public void run() {
        InjectActivity.a(this.b.a).add(this.a);
        InjectActivity.b(this.b.a).notifyDataSetChanged();
      }
    }
  }
  
  class a implements Runnable {
    a(InjectActivity this$0, String param1String) {}
    
    public void run() {
      InjectActivity.a(this.b.a).add(this.a);
      InjectActivity.b(this.b.a).notifyDataSetChanged();
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\InjectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */