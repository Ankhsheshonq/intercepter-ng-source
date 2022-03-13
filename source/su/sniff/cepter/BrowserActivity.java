package su.sniff.cepter;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BrowserActivity extends Activity {
  WebView a;
  
  public void OnBack(View paramView) {
    if (this.a.canGoBack())
      this.a.goBack(); 
  }
  
  public void OnSaveCookie(View paramView) {
    CharSequence charSequence;
    if (Build.VERSION.SDK_INT < 11) {
      charSequence = ((ClipboardManager)getSystemService("clipboard")).getText();
    } else {
      charSequence = ((ClipboardManager)getSystemService("clipboard")).getPrimaryClip().getItemAt(0).getText();
    } 
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    b b = new b(this, charSequence);
    (new e((Context)this, str, new String[] { ".txt" }, b)).show();
  }
  
  public void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: ldc 2130968577
    //   8: invokevirtual setContentView : (I)V
    //   11: aload_0
    //   12: ldc 2130903115
    //   14: invokevirtual findViewById : (I)Landroid/view/View;
    //   17: checkcast android/webkit/WebView
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: putfield a : Landroid/webkit/WebView;
    //   26: aload_1
    //   27: invokevirtual getContext : ()Landroid/content/Context;
    //   30: invokestatic createInstance : (Landroid/content/Context;)Landroid/webkit/CookieSyncManager;
    //   33: astore #4
    //   35: invokestatic getInstance : ()Landroid/webkit/CookieManager;
    //   38: astore #5
    //   40: aload #5
    //   42: iconst_1
    //   43: invokevirtual setAcceptCookie : (Z)V
    //   46: aload #5
    //   48: invokevirtual removeAllCookie : ()V
    //   51: ldc2_w 1000
    //   54: invokestatic sleep : (J)V
    //   57: aload_0
    //   58: invokevirtual getIntent : ()Landroid/content/Intent;
    //   61: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   64: ldc 'Key_Int'
    //   66: iconst_0
    //   67: invokevirtual getInt : (Ljava/lang/String;I)I
    //   70: istore_2
    //   71: getstatic su/sniff/cepter/b.e : Ljava/util/ArrayList;
    //   74: iload_2
    //   75: invokevirtual get : (I)Ljava/lang/Object;
    //   78: checkcast java/lang/String
    //   81: ldc ' :'
    //   83: invokevirtual indexOf : (Ljava/lang/String;)I
    //   86: istore_3
    //   87: getstatic su/sniff/cepter/b.e : Ljava/util/ArrayList;
    //   90: iload_2
    //   91: invokevirtual get : (I)Ljava/lang/Object;
    //   94: checkcast java/lang/String
    //   97: iconst_0
    //   98: iload_3
    //   99: invokevirtual substring : (II)Ljava/lang/String;
    //   102: astore_1
    //   103: getstatic su/sniff/cepter/b.o : I
    //   106: ifne -> 116
    //   109: iconst_1
    //   110: putstatic su/sniff/cepter/b.o : I
    //   113: goto -> 140
    //   116: getstatic su/sniff/cepter/b.o : I
    //   119: iconst_1
    //   120: if_icmpne -> 109
    //   123: lconst_1
    //   124: invokestatic sleep : (J)V
    //   127: goto -> 116
    //   130: astore #6
    //   132: aload #6
    //   134: invokevirtual printStackTrace : ()V
    //   137: goto -> 116
    //   140: getstatic su/sniff/cepter/b.f : Ljava/util/ArrayList;
    //   143: iload_2
    //   144: invokevirtual get : (I)Ljava/lang/Object;
    //   147: checkcast java/lang/String
    //   150: astore #6
    //   152: new java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial <init> : ()V
    //   159: astore #7
    //   161: aload #7
    //   163: aload #6
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload #7
    //   171: ldc ';'
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #7
    //   179: invokevirtual toString : ()Ljava/lang/String;
    //   182: astore #6
    //   184: iconst_0
    //   185: istore_2
    //   186: aload #6
    //   188: ldc ';'
    //   190: iload_2
    //   191: invokevirtual indexOf : (Ljava/lang/String;I)I
    //   194: istore_3
    //   195: iload_3
    //   196: iconst_m1
    //   197: if_icmpne -> 381
    //   200: aload #4
    //   202: invokevirtual sync : ()V
    //   205: aload #5
    //   207: aload_1
    //   208: invokevirtual getCookie : (Ljava/lang/String;)Ljava/lang/String;
    //   211: pop
    //   212: aload_0
    //   213: getfield a : Landroid/webkit/WebView;
    //   216: invokevirtual getSettings : ()Landroid/webkit/WebSettings;
    //   219: iconst_1
    //   220: invokevirtual setUseWideViewPort : (Z)V
    //   223: aload_0
    //   224: getfield a : Landroid/webkit/WebView;
    //   227: invokevirtual getSettings : ()Landroid/webkit/WebSettings;
    //   230: iconst_1
    //   231: invokevirtual setJavaScriptEnabled : (Z)V
    //   234: aload_0
    //   235: getfield a : Landroid/webkit/WebView;
    //   238: new android/webkit/WebViewClient
    //   241: dup
    //   242: invokespecial <init> : ()V
    //   245: invokevirtual setWebViewClient : (Landroid/webkit/WebViewClient;)V
    //   248: aload_0
    //   249: getfield a : Landroid/webkit/WebView;
    //   252: invokevirtual getSettings : ()Landroid/webkit/WebSettings;
    //   255: iconst_1
    //   256: invokevirtual setBuiltInZoomControls : (Z)V
    //   259: aload_0
    //   260: getfield a : Landroid/webkit/WebView;
    //   263: invokevirtual getSettings : ()Landroid/webkit/WebSettings;
    //   266: ldc 'Mozilla/5.0 (Windows NT 6.1; WOW64) Chrome/23.0.1271.64 Safari/537.11'
    //   268: invokevirtual setUserAgentString : (Ljava/lang/String;)V
    //   271: aload_0
    //   272: getfield a : Landroid/webkit/WebView;
    //   275: astore #4
    //   277: new java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial <init> : ()V
    //   284: astore #5
    //   286: aload #5
    //   288: ldc 'http://'
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload #5
    //   296: aload_1
    //   297: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload #4
    //   303: aload #5
    //   305: invokevirtual toString : ()Ljava/lang/String;
    //   308: invokevirtual loadUrl : (Ljava/lang/String;)V
    //   311: aload_0
    //   312: ldc 2130903070
    //   314: invokevirtual findViewById : (I)Landroid/view/View;
    //   317: checkcast android/widget/EditText
    //   320: astore #4
    //   322: new java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial <init> : ()V
    //   329: astore #5
    //   331: aload #5
    //   333: ldc 'http://'
    //   335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload #5
    //   341: aload_1
    //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload #4
    //   348: aload #5
    //   350: invokevirtual toString : ()Ljava/lang/String;
    //   353: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   356: aload_0
    //   357: ldc 2130903070
    //   359: invokevirtual findViewById : (I)Landroid/view/View;
    //   362: checkcast android/widget/EditText
    //   365: new su/sniff/cepter/BrowserActivity$a
    //   368: dup
    //   369: aload_0
    //   370: invokespecial <init> : (Lsu/sniff/cepter/BrowserActivity;)V
    //   373: invokevirtual addTextChangedListener : (Landroid/text/TextWatcher;)V
    //   376: iconst_0
    //   377: putstatic su/sniff/cepter/b.o : I
    //   380: return
    //   381: iload_3
    //   382: iconst_1
    //   383: iadd
    //   384: istore_3
    //   385: aload #5
    //   387: aload_1
    //   388: aload #6
    //   390: iload_2
    //   391: iload_3
    //   392: invokevirtual substring : (II)Ljava/lang/String;
    //   395: invokevirtual setCookie : (Ljava/lang/String;Ljava/lang/String;)V
    //   398: iload_3
    //   399: istore_2
    //   400: goto -> 186
    // Exception table:
    //   from	to	target	type
    //   123	127	130	java/lang/InterruptedException
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      finish();
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a implements TextWatcher {
    a(BrowserActivity this$0) {}
    
    public void afterTextChanged(Editable param1Editable) {
      EditText editText = (EditText)this.a.findViewById(2130903070);
      this.a.a.loadUrl(editText.getText().toString());
    }
    
    public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
  }
  
  class b implements e.d {
    b(BrowserActivity this$0, CharSequence param1CharSequence) {}
    
    public void a(File param1File) {
      try {
        FileWriter fileWriter = new FileWriter(param1File);
        fileWriter.append(this.a);
        fileWriter.flush();
        fileWriter.close();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\BrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */