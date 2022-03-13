package su.sniff.cepter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class ChooseActivity extends Activity {
  private Context a;
  
  String b;
  
  int c = 0;
  
  int d = 0;
  
  public static Integer a(String paramString) {
    if (paramString == null)
      return null; 
    int j = 0;
    StringTokenizer stringTokenizer = new StringTokenizer(paramString, ".");
    for (int i = 3; i >= 0; i--)
      j |= Integer.parseInt(stringTokenizer.nextToken()) << i * 8; 
    return new Integer(j);
  }
  
  public String a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt & 0xFF);
    stringBuilder.append(".");
    paramInt >>>= 8;
    stringBuilder.append(paramInt & 0xFF);
    stringBuilder.append(".");
    paramInt >>>= 8;
    stringBuilder.append(paramInt & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >>> 8 & 0xFF);
    return stringBuilder.toString();
  }
  
  public void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: ldc 2130968600
    //   8: invokevirtual setContentView : (I)V
    //   11: aload_0
    //   12: aload_0
    //   13: putfield a : Landroid/content/Context;
    //   16: iconst_1
    //   17: putstatic su/sniff/cepter/b.b : I
    //   20: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   23: ldc 'su'
    //   25: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   28: astore_1
    //   29: new java/io/DataOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   37: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   40: astore #5
    //   42: new java/io/File
    //   45: dup
    //   46: ldc '/data/data/su.sniff.cepter/files/force'
    //   48: invokespecial <init> : (Ljava/lang/String;)V
    //   51: astore #4
    //   53: aload #4
    //   55: invokevirtual exists : ()Z
    //   58: ifeq -> 67
    //   61: aload #4
    //   63: invokevirtual delete : ()Z
    //   66: pop
    //   67: new java/io/File
    //   70: dup
    //   71: ldc '/data/data/su.sniff.cepter/files/ck'
    //   73: invokespecial <init> : (Ljava/lang/String;)V
    //   76: astore #4
    //   78: aload #4
    //   80: invokevirtual exists : ()Z
    //   83: ifeq -> 92
    //   86: aload #4
    //   88: invokevirtual delete : ()Z
    //   91: pop
    //   92: getstatic android/os/Build$VERSION.SDK_INT : I
    //   95: bipush #21
    //   97: if_icmpge -> 114
    //   100: aload_0
    //   101: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   104: ldc 2131165185
    //   106: invokevirtual openRawResource : (I)Ljava/io/InputStream;
    //   109: astore #4
    //   111: goto -> 148
    //   114: aload_0
    //   115: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   118: ldc 2131165188
    //   120: invokevirtual openRawResource : (I)Ljava/io/InputStream;
    //   123: astore #4
    //   125: getstatic android/os/Build.CPU_ABI : Ljava/lang/String;
    //   128: ldc 'arm64'
    //   130: invokevirtual indexOf : (Ljava/lang/String;)I
    //   133: iconst_m1
    //   134: if_icmpeq -> 148
    //   137: aload_0
    //   138: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   141: ldc 2131165187
    //   143: invokevirtual openRawResource : (I)Ljava/io/InputStream;
    //   146: astore #4
    //   148: getstatic android/os/Build.CPU_ABI : Ljava/lang/String;
    //   151: ldc 'x86'
    //   153: invokevirtual indexOf : (Ljava/lang/String;)I
    //   156: iconst_m1
    //   157: if_icmpeq -> 171
    //   160: aload_0
    //   161: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   164: ldc 2131165186
    //   166: invokevirtual openRawResource : (I)Ljava/io/InputStream;
    //   169: astore #4
    //   171: new java/io/File
    //   174: dup
    //   175: ldc '/data/data/su.sniff.cepter/files/cepter'
    //   177: invokespecial <init> : (Ljava/lang/String;)V
    //   180: astore #7
    //   182: bipush #64
    //   184: newarray byte
    //   186: astore #6
    //   188: aload #7
    //   190: invokevirtual exists : ()Z
    //   193: ifeq -> 202
    //   196: aload #7
    //   198: invokevirtual delete : ()Z
    //   201: pop
    //   202: aload_0
    //   203: ldc 'cepter'
    //   205: iconst_0
    //   206: invokevirtual openFileOutput : (Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   209: astore #7
    //   211: aload #4
    //   213: aload #6
    //   215: invokevirtual read : ([B)I
    //   218: iconst_m1
    //   219: if_icmple -> 232
    //   222: aload #7
    //   224: aload #6
    //   226: invokevirtual write : ([B)V
    //   229: goto -> 211
    //   232: aload #7
    //   234: invokevirtual flush : ()V
    //   237: aload #7
    //   239: invokevirtual close : ()V
    //   242: aload_0
    //   243: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   246: ldc 2131165184
    //   248: invokevirtual openRawResource : (I)Ljava/io/InputStream;
    //   251: astore #4
    //   253: new java/io/File
    //   256: dup
    //   257: ldc '/data/data/su.sniff.cepter/files/busybox'
    //   259: invokespecial <init> : (Ljava/lang/String;)V
    //   262: astore #7
    //   264: aload #7
    //   266: invokevirtual exists : ()Z
    //   269: ifeq -> 278
    //   272: aload #7
    //   274: invokevirtual delete : ()Z
    //   277: pop
    //   278: new java/io/File
    //   281: dup
    //   282: ldc '/data/data/su.sniff.cepter/files/savepath'
    //   284: invokespecial <init> : (Ljava/lang/String;)V
    //   287: astore #7
    //   289: aload #7
    //   291: invokevirtual exists : ()Z
    //   294: ifeq -> 303
    //   297: aload #7
    //   299: invokevirtual delete : ()Z
    //   302: pop
    //   303: new java/io/File
    //   306: dup
    //   307: ldc '/data/data/su.sniff.cepter/files/hsts.on'
    //   309: invokespecial <init> : (Ljava/lang/String;)V
    //   312: astore #7
    //   314: aload #7
    //   316: invokevirtual exists : ()Z
    //   319: ifeq -> 328
    //   322: aload #7
    //   324: invokevirtual delete : ()Z
    //   327: pop
    //   328: aload_0
    //   329: ldc 'busybox'
    //   331: iconst_0
    //   332: invokevirtual openFileOutput : (Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   335: astore #7
    //   337: aload #4
    //   339: aload #6
    //   341: invokevirtual read : ([B)I
    //   344: iconst_m1
    //   345: if_icmple -> 358
    //   348: aload #7
    //   350: aload #6
    //   352: invokevirtual write : ([B)V
    //   355: goto -> 337
    //   358: aload #7
    //   360: invokevirtual flush : ()V
    //   363: aload #7
    //   365: invokevirtual close : ()V
    //   368: aload #5
    //   370: ldc 'chmod 777 /data/data/su.sniff.cepter/files/cepter\\n'
    //   372: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   375: aload #5
    //   377: invokevirtual flush : ()V
    //   380: aload #5
    //   382: ldc 'chmod 777 /data/data/su.sniff.cepter/files/busybox\\n'
    //   384: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   387: aload #5
    //   389: invokevirtual flush : ()V
    //   392: aload #5
    //   394: ldc 'killall cepter\\n'
    //   396: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   399: aload #5
    //   401: invokevirtual flush : ()V
    //   404: aload #5
    //   406: ldc 'setenforce 0\\n'
    //   408: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   411: aload #5
    //   413: invokevirtual flush : ()V
    //   416: aload #5
    //   418: invokevirtual close : ()V
    //   421: aload_1
    //   422: invokevirtual waitFor : ()I
    //   425: pop
    //   426: goto -> 477
    //   429: astore #4
    //   431: goto -> 448
    //   434: astore #4
    //   436: goto -> 460
    //   439: astore #4
    //   441: goto -> 472
    //   444: astore #4
    //   446: aconst_null
    //   447: astore_1
    //   448: aload #4
    //   450: invokevirtual printStackTrace : ()V
    //   453: goto -> 477
    //   456: astore #4
    //   458: aconst_null
    //   459: astore_1
    //   460: aload #4
    //   462: invokevirtual printStackTrace : ()V
    //   465: goto -> 477
    //   468: astore #4
    //   470: aconst_null
    //   471: astore_1
    //   472: aload #4
    //   474: invokevirtual printStackTrace : ()V
    //   477: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   480: ldc 'chmod'
    //   482: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   485: astore #4
    //   487: new java/io/DataOutputStream
    //   490: dup
    //   491: aload #4
    //   493: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   496: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   499: invokevirtual close : ()V
    //   502: aload #4
    //   504: invokevirtual waitFor : ()I
    //   507: pop
    //   508: goto -> 564
    //   511: astore #4
    //   513: aload #4
    //   515: invokevirtual printStackTrace : ()V
    //   518: goto -> 564
    //   521: astore #4
    //   523: aload_0
    //   524: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   527: ldc 'CHMOD NOT FOUND! YOU NEED BUSYBOX!'
    //   529: iconst_1
    //   530: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   533: invokevirtual show : ()V
    //   536: aload #4
    //   538: invokevirtual printStackTrace : ()V
    //   541: goto -> 564
    //   544: astore #4
    //   546: aload_0
    //   547: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   550: ldc 'CHMOD NOT FOUND! YOU NEED BUSYBOX!'
    //   552: iconst_1
    //   553: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   556: invokevirtual show : ()V
    //   559: aload #4
    //   561: invokevirtual printStackTrace : ()V
    //   564: aload_0
    //   565: invokevirtual getFilesDir : ()Ljava/io/File;
    //   568: invokevirtual toString : ()Ljava/lang/String;
    //   571: ldc '/data./su'
    //   573: invokevirtual indexOf : (Ljava/lang/String;)I
    //   576: ifne -> 592
    //   579: aload_0
    //   580: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   583: ldc 'INSTALL INTERCEPTER TO INTERNAL MEMORY!'
    //   585: iconst_1
    //   586: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   589: invokevirtual show : ()V
    //   592: aload_0
    //   593: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   596: ldc 'wifi'
    //   598: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   601: checkcast android/net/wifi/WifiManager
    //   604: astore #4
    //   606: aload #4
    //   608: invokevirtual getConnectionInfo : ()Landroid/net/wifi/WifiInfo;
    //   611: pop
    //   612: aload_0
    //   613: aload #4
    //   615: invokevirtual getDhcpInfo : ()Landroid/net/DhcpInfo;
    //   618: getfield ipAddress : I
    //   621: invokevirtual a : (I)Ljava/lang/String;
    //   624: putstatic su/sniff/cepter/b.F : Ljava/lang/String;
    //   627: aload_0
    //   628: ldc_w 'connectivity'
    //   631: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   634: checkcast android/net/ConnectivityManager
    //   637: iconst_1
    //   638: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   641: invokevirtual isConnected : ()Z
    //   644: ifne -> 661
    //   647: aload_0
    //   648: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   651: ldc_w 'NO ACTIVE CONNECTION! TURN ON WIFI!'
    //   654: iconst_1
    //   655: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   658: invokevirtual show : ()V
    //   661: aload_1
    //   662: ifnull -> 1186
    //   665: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   668: ldc 'su'
    //   670: aconst_null
    //   671: new java/io/File
    //   674: dup
    //   675: ldc_w '/data/data/su.sniff.cepter/files'
    //   678: invokespecial <init> : (Ljava/lang/String;)V
    //   681: invokevirtual exec : (Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;
    //   684: astore_1
    //   685: new java/io/DataOutputStream
    //   688: dup
    //   689: aload_1
    //   690: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   693: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   696: astore #5
    //   698: new java/io/BufferedReader
    //   701: dup
    //   702: new java/io/InputStreamReader
    //   705: dup
    //   706: aload_1
    //   707: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   710: invokespecial <init> : (Ljava/io/InputStream;)V
    //   713: invokespecial <init> : (Ljava/io/Reader;)V
    //   716: astore #4
    //   718: aload #5
    //   720: ldc_w '/data/data/su.sniff.cepter/files/cepter list\\n'
    //   723: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   726: aload #5
    //   728: invokevirtual flush : ()V
    //   731: aload #5
    //   733: ldc_w 'exit\\n'
    //   736: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   739: aload #5
    //   741: invokevirtual flush : ()V
    //   744: aload #5
    //   746: invokevirtual close : ()V
    //   749: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   752: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   755: putstatic su/sniff/cepter/b.J : Ljava/lang/String;
    //   758: iconst_0
    //   759: istore_2
    //   760: aload #4
    //   762: invokevirtual readLine : ()Ljava/lang/String;
    //   765: astore #5
    //   767: aload_0
    //   768: aload #5
    //   770: putfield b : Ljava/lang/String;
    //   773: aload #5
    //   775: ifnull -> 1133
    //   778: aload #5
    //   780: getstatic su/sniff/cepter/b.F : Ljava/lang/String;
    //   783: invokevirtual indexOf : (Ljava/lang/String;)I
    //   786: istore_3
    //   787: iload_3
    //   788: iconst_m1
    //   789: if_icmpne -> 823
    //   792: iload_2
    //   793: istore_3
    //   794: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   797: ldc_w 'vmos'
    //   800: invokevirtual indexOf : (Ljava/lang/String;)I
    //   803: iconst_m1
    //   804: if_icmpeq -> 1118
    //   807: iload_2
    //   808: istore_3
    //   809: aload_0
    //   810: getfield b : Ljava/lang/String;
    //   813: ldc_w 'wlan0'
    //   816: invokevirtual indexOf : (Ljava/lang/String;)I
    //   819: iconst_m1
    //   820: if_icmpeq -> 1118
    //   823: aload_0
    //   824: getfield c : I
    //   827: iconst_1
    //   828: iadd
    //   829: putstatic su/sniff/cepter/b.a : I
    //   832: aload_0
    //   833: getfield b : Ljava/lang/String;
    //   836: ldc_w ' / '
    //   839: invokevirtual indexOf : (Ljava/lang/String;)I
    //   842: istore_2
    //   843: aload_0
    //   844: iload_2
    //   845: putfield d : I
    //   848: iload_2
    //   849: iconst_3
    //   850: iadd
    //   851: istore_2
    //   852: aload_0
    //   853: iload_2
    //   854: putfield d : I
    //   857: aload_0
    //   858: getfield b : Ljava/lang/String;
    //   861: iload_2
    //   862: aload_0
    //   863: getfield b : Ljava/lang/String;
    //   866: invokevirtual length : ()I
    //   869: invokevirtual substring : (II)Ljava/lang/String;
    //   872: putstatic su/sniff/cepter/b.H : Ljava/lang/String;
    //   875: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   878: ldc_w 'vmos'
    //   881: invokevirtual indexOf : (Ljava/lang/String;)I
    //   884: iconst_m1
    //   885: if_icmpeq -> 918
    //   888: aload_0
    //   889: getfield b : Ljava/lang/String;
    //   892: ldc_w 'IP'
    //   895: invokevirtual indexOf : (Ljava/lang/String;)I
    //   898: istore_2
    //   899: aload_0
    //   900: getfield b : Ljava/lang/String;
    //   903: iload_2
    //   904: iconst_4
    //   905: iadd
    //   906: aload_0
    //   907: getfield d : I
    //   910: iconst_3
    //   911: isub
    //   912: invokevirtual substring : (II)Ljava/lang/String;
    //   915: putstatic su/sniff/cepter/b.F : Ljava/lang/String;
    //   918: getstatic su/sniff/cepter/b.H : Ljava/lang/String;
    //   921: invokestatic a : (Ljava/lang/String;)Ljava/lang/Integer;
    //   924: invokevirtual intValue : ()I
    //   927: invokestatic bitCount : (I)I
    //   930: istore_2
    //   931: iload_2
    //   932: bipush #24
    //   934: if_icmpne -> 1054
    //   937: new java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial <init> : ()V
    //   944: astore #5
    //   946: aload #5
    //   948: getstatic su/sniff/cepter/b.F : Ljava/lang/String;
    //   951: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload #5
    //   957: ldc_w '/'
    //   960: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload #5
    //   966: iload_2
    //   967: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: new su/sniff/cepter/c
    //   974: dup
    //   975: aload #5
    //   977: invokevirtual toString : ()Ljava/lang/String;
    //   980: invokespecial <init> : (Ljava/lang/String;)V
    //   983: astore #5
    //   985: aload #5
    //   987: aload #5
    //   989: invokevirtual a : ()Ljava/lang/Integer;
    //   992: invokevirtual a : (Ljava/lang/Integer;)Ljava/util/List;
    //   995: astore #6
    //   997: invokestatic newCachedThreadPool : ()Ljava/util/concurrent/ExecutorService;
    //   1000: astore #5
    //   1002: aload #6
    //   1004: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1009: astore #6
    //   1011: aload #6
    //   1013: invokeinterface hasNext : ()Z
    //   1018: ifeq -> 1054
    //   1021: aload #5
    //   1023: new su/sniff/cepter/ChooseActivity$a
    //   1026: dup
    //   1027: aload_0
    //   1028: aload #6
    //   1030: invokeinterface next : ()Ljava/lang/Object;
    //   1035: checkcast java/lang/String
    //   1038: invokespecial <init> : (Lsu/sniff/cepter/ChooseActivity;Ljava/lang/String;)V
    //   1041: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   1046: pop
    //   1047: lconst_1
    //   1048: invokestatic sleep : (J)V
    //   1051: goto -> 1011
    //   1054: new android/content/Intent
    //   1057: dup
    //   1058: aload_0
    //   1059: getfield a : Landroid/content/Context;
    //   1062: ldc_w su/sniff/cepter/ScanActivity
    //   1065: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   1068: astore #5
    //   1070: aload #5
    //   1072: ldc_w 'Key_Int'
    //   1075: aload_0
    //   1076: getfield c : I
    //   1079: invokevirtual putExtra : (Ljava/lang/String;I)Landroid/content/Intent;
    //   1082: pop
    //   1083: aload #5
    //   1085: ldc_w 'Key_String'
    //   1088: aload_0
    //   1089: getfield b : Ljava/lang/String;
    //   1092: iconst_0
    //   1093: aload_0
    //   1094: getfield d : I
    //   1097: iconst_3
    //   1098: isub
    //   1099: invokevirtual substring : (II)Ljava/lang/String;
    //   1102: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1105: pop
    //   1106: aload_0
    //   1107: aload #5
    //   1109: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   1112: aload_0
    //   1113: invokevirtual finish : ()V
    //   1116: iconst_1
    //   1117: istore_3
    //   1118: aload_0
    //   1119: aload_0
    //   1120: getfield c : I
    //   1123: iconst_1
    //   1124: iadd
    //   1125: putfield c : I
    //   1128: iload_3
    //   1129: istore_2
    //   1130: goto -> 760
    //   1133: aload #4
    //   1135: invokevirtual close : ()V
    //   1138: iload_2
    //   1139: ifne -> 1156
    //   1142: aload_0
    //   1143: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   1146: ldc_w 'Network interface not found! Root or Android problems!'
    //   1149: iconst_1
    //   1150: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1153: invokevirtual show : ()V
    //   1156: aload_1
    //   1157: invokevirtual waitFor : ()I
    //   1160: pop
    //   1161: return
    //   1162: astore_1
    //   1163: aload_0
    //   1164: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   1167: ldc_w 'Broken pipe! Reinstall supersu and busybox!'
    //   1170: iconst_1
    //   1171: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1174: invokevirtual show : ()V
    //   1177: new java/lang/RuntimeException
    //   1180: dup
    //   1181: aload_1
    //   1182: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   1185: athrow
    //   1186: aload_0
    //   1187: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   1190: ldc_w 'SU not found! You need root!'
    //   1193: iconst_1
    //   1194: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1197: invokevirtual show : ()V
    //   1200: return
    // Exception table:
    //   from	to	target	type
    //   20	29	468	java/io/FileNotFoundException
    //   20	29	456	java/io/IOException
    //   20	29	444	java/lang/InterruptedException
    //   29	67	439	java/io/FileNotFoundException
    //   29	67	434	java/io/IOException
    //   29	67	429	java/lang/InterruptedException
    //   67	92	439	java/io/FileNotFoundException
    //   67	92	434	java/io/IOException
    //   67	92	429	java/lang/InterruptedException
    //   92	111	439	java/io/FileNotFoundException
    //   92	111	434	java/io/IOException
    //   92	111	429	java/lang/InterruptedException
    //   114	125	439	java/io/FileNotFoundException
    //   114	125	434	java/io/IOException
    //   114	125	429	java/lang/InterruptedException
    //   125	148	439	java/io/FileNotFoundException
    //   125	148	434	java/io/IOException
    //   125	148	429	java/lang/InterruptedException
    //   148	171	439	java/io/FileNotFoundException
    //   148	171	434	java/io/IOException
    //   148	171	429	java/lang/InterruptedException
    //   171	202	439	java/io/FileNotFoundException
    //   171	202	434	java/io/IOException
    //   171	202	429	java/lang/InterruptedException
    //   202	211	439	java/io/FileNotFoundException
    //   202	211	434	java/io/IOException
    //   202	211	429	java/lang/InterruptedException
    //   211	229	439	java/io/FileNotFoundException
    //   211	229	434	java/io/IOException
    //   211	229	429	java/lang/InterruptedException
    //   232	278	439	java/io/FileNotFoundException
    //   232	278	434	java/io/IOException
    //   232	278	429	java/lang/InterruptedException
    //   278	303	439	java/io/FileNotFoundException
    //   278	303	434	java/io/IOException
    //   278	303	429	java/lang/InterruptedException
    //   303	328	439	java/io/FileNotFoundException
    //   303	328	434	java/io/IOException
    //   303	328	429	java/lang/InterruptedException
    //   328	337	439	java/io/FileNotFoundException
    //   328	337	434	java/io/IOException
    //   328	337	429	java/lang/InterruptedException
    //   337	355	439	java/io/FileNotFoundException
    //   337	355	434	java/io/IOException
    //   337	355	429	java/lang/InterruptedException
    //   358	426	439	java/io/FileNotFoundException
    //   358	426	434	java/io/IOException
    //   358	426	429	java/lang/InterruptedException
    //   477	508	544	java/io/FileNotFoundException
    //   477	508	521	java/io/IOException
    //   477	508	511	java/lang/InterruptedException
    //   665	758	1162	java/lang/Exception
    //   760	773	1162	java/lang/Exception
    //   778	787	1162	java/lang/Exception
    //   794	807	1162	java/lang/Exception
    //   809	823	1162	java/lang/Exception
    //   823	848	1162	java/lang/Exception
    //   852	918	1162	java/lang/Exception
    //   918	931	1162	java/lang/Exception
    //   937	1011	1162	java/lang/Exception
    //   1011	1051	1162	java/lang/Exception
    //   1054	1116	1162	java/lang/Exception
    //   1118	1128	1162	java/lang/Exception
    //   1133	1138	1162	java/lang/Exception
    //   1142	1156	1162	java/lang/Exception
    //   1156	1161	1162	java/lang/Exception
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4)
      try {
        openFileOutput("exitr.id", 0).close();
        openFileOutput("exits.id", 0).close();
        Thread.sleep(100L);
        DataOutputStream dataOutputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
        dataOutputStream.writeBytes("killall cepter\n");
        dataOutputStream.flush();
        dataOutputStream.writeBytes("killall cepter\n");
        dataOutputStream.flush();
        dataOutputStream.writeBytes("killall cepter\n");
        dataOutputStream.flush();
        dataOutputStream.close();
        File file = new File("/data/data/su.sniff.cepter/files/inj");
        if (file.exists())
          file.delete(); 
        System.exit(0);
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      }  
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a implements Runnable {
    a(ChooseActivity this$0, String param1String) {}
    
    public void run() {
      try {
        InetAddress.getByName(this.a).isReachable(1);
        return;
      } catch (UnknownHostException unknownHostException) {
        unknownHostException.printStackTrace();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\ChooseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */