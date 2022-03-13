package su.sniff.cepter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DNSSpoofing extends Activity {
  public ListView a;
  
  private String b = "";
  
  private CheckBox c;
  
  private ArrayAdapter<String> d;
  
  private ArrayList<String> e;
  
  public void OnAdd(View paramView) {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
    builder.setTitle("Add new record");
    EditText editText = new EditText((Context)this);
    editText.setInputType(1);
    builder.setView((View)editText);
    builder.setPositiveButton("Add", new c(this, editText));
    builder.setNegativeButton("Cancel", new d(this));
    builder.show();
  }
  
  public void OnClear(View paramView) {
    this.e.clear();
    this.d.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: ldc 2130968582
    //   8: invokevirtual setContentView : (I)V
    //   11: aload_0
    //   12: new java/util/ArrayList
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: putfield e : Ljava/util/ArrayList;
    //   22: aload_0
    //   23: aload_0
    //   24: ldc 2130903082
    //   26: invokevirtual findViewById : (I)Landroid/view/View;
    //   29: checkcast android/widget/ListView
    //   32: putfield a : Landroid/widget/ListView;
    //   35: aload_0
    //   36: ldc 2130903058
    //   38: invokevirtual findViewById : (I)Landroid/view/View;
    //   41: checkcast android/widget/CheckBox
    //   44: astore_1
    //   45: aload_0
    //   46: aload_1
    //   47: putfield c : Landroid/widget/CheckBox;
    //   50: getstatic su/sniff/cepter/b.d : I
    //   53: iconst_1
    //   54: if_icmpne -> 65
    //   57: aload_1
    //   58: iconst_1
    //   59: invokevirtual setChecked : (Z)V
    //   62: goto -> 70
    //   65: aload_1
    //   66: iconst_0
    //   67: invokevirtual setChecked : (Z)V
    //   70: aload_0
    //   71: getfield c : Landroid/widget/CheckBox;
    //   74: new su/sniff/cepter/DNSSpoofing$a
    //   77: dup
    //   78: aload_0
    //   79: invokespecial <init> : (Lsu/sniff/cepter/DNSSpoofing;)V
    //   82: invokevirtual setOnCheckedChangeListener : (Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   85: new android/widget/ArrayAdapter
    //   88: dup
    //   89: aload_0
    //   90: ldc 17367048
    //   92: aload_0
    //   93: getfield e : Ljava/util/ArrayList;
    //   96: invokespecial <init> : (Landroid/content/Context;ILjava/util/List;)V
    //   99: astore_1
    //   100: aload_0
    //   101: aload_1
    //   102: putfield d : Landroid/widget/ArrayAdapter;
    //   105: aload_0
    //   106: getfield a : Landroid/widget/ListView;
    //   109: aload_1
    //   110: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   113: getstatic su/sniff/cepter/b.o : I
    //   116: ifne -> 126
    //   119: iconst_1
    //   120: putstatic su/sniff/cepter/b.o : I
    //   123: goto -> 148
    //   126: getstatic su/sniff/cepter/b.o : I
    //   129: iconst_1
    //   130: if_icmpne -> 119
    //   133: lconst_1
    //   134: invokestatic sleep : (J)V
    //   137: goto -> 126
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual printStackTrace : ()V
    //   145: goto -> 126
    //   148: new java/io/BufferedReader
    //   151: dup
    //   152: new java/io/FileReader
    //   155: dup
    //   156: new java/io/File
    //   159: dup
    //   160: ldc '/data/data/su.sniff.cepter/files/dnss'
    //   162: invokespecial <init> : (Ljava/lang/String;)V
    //   165: invokespecial <init> : (Ljava/io/File;)V
    //   168: invokespecial <init> : (Ljava/io/Reader;)V
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual readLine : ()Ljava/lang/String;
    //   176: astore_2
    //   177: aload_2
    //   178: ifnull -> 200
    //   181: aload_0
    //   182: getfield e : Ljava/util/ArrayList;
    //   185: aload_2
    //   186: invokevirtual add : (Ljava/lang/Object;)Z
    //   189: pop
    //   190: aload_0
    //   191: getfield d : Landroid/widget/ArrayAdapter;
    //   194: invokevirtual notifyDataSetChanged : ()V
    //   197: goto -> 172
    //   200: aload_1
    //   201: invokevirtual close : ()V
    //   204: goto -> 212
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual printStackTrace : ()V
    //   212: aload_0
    //   213: getfield a : Landroid/widget/ListView;
    //   216: new su/sniff/cepter/DNSSpoofing$b
    //   219: dup
    //   220: aload_0
    //   221: invokespecial <init> : (Lsu/sniff/cepter/DNSSpoofing;)V
    //   224: invokevirtual setOnItemLongClickListener : (Landroid/widget/AdapterView$OnItemLongClickListener;)V
    //   227: iconst_0
    //   228: putstatic su/sniff/cepter/b.o : I
    //   231: return
    //   232: astore_1
    //   233: goto -> 212
    // Exception table:
    //   from	to	target	type
    //   133	137	140	java/lang/InterruptedException
    //   148	172	232	java/io/FileNotFoundException
    //   148	172	207	java/io/IOException
    //   172	177	232	java/io/FileNotFoundException
    //   172	177	207	java/io/IOException
    //   181	197	232	java/io/FileNotFoundException
    //   181	197	207	java/io/IOException
    //   200	204	232	java/io/FileNotFoundException
    //   200	204	207	java/io/IOException
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      paramInt = 0;
      try {
        FileOutputStream fileOutputStream = openFileOutput("dnss", 0);
        while (paramInt < this.e.size()) {
          fileOutputStream.write(((String)this.e.get(paramInt)).getBytes());
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
  
  class a implements CompoundButton.OnCheckedChangeListener {
    a(DNSSpoofing this$0) {}
    
    public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
      boolean bool;
      if (param1Boolean) {
        bool = true;
      } else {
        bool = false;
      } 
      b.d = bool;
    }
  }
  
  class b implements AdapterView.OnItemLongClickListener {
    b(DNSSpoofing this$0) {}
    
    public boolean onItemLongClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      DNSSpoofing.a(this.a).remove(param1Int);
      DNSSpoofing.b(this.a).notifyDataSetChanged();
      return true;
    }
  }
  
  class c implements DialogInterface.OnClickListener {
    c(DNSSpoofing this$0, EditText param1EditText) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      DNSSpoofing.a(this.b, this.a.getText().toString());
      DNSSpoofing.a(this.b).add(DNSSpoofing.c(this.b));
      DNSSpoofing.b(this.b).notifyDataSetChanged();
    }
  }
  
  class d implements DialogInterface.OnClickListener {
    d(DNSSpoofing this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      param1DialogInterface.cancel();
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\DNSSpoofing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */