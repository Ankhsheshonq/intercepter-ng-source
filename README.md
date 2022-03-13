# intercepter-ng-source
 Intercepter-NG is a multifunctional network toolkit for various types of IT specialists. The main purpose is to recover *interesting* data from the network stream and perform different kinds of MiTM attacks. 

 + Sniffing passwords\hashes of the types:
   ICQ\IRC\AIM\FTP\IMAP\POP3\SMTP\LDAP\BNC\SOCKS\HTTP\WWW\NNTP\CVS\MRA\VNC\MYSQL\ORACLE\NTLM
 + Sniffing chat messages of ICQ\AIM\JABBER\YAHOO\MSN\IRC\MRA
 + Reconstructing files from: 
   HTTP\FTP\IMAP\POP3\SMTP\SMB
 + Network discovering and automated ARP Poisoning
 + Capturing packets and post-capture (offline) analyzing
 + RAW Mode

Works on NT\Linux\BSD\MacOSX\IOS\Android.

Optimized for screen size 80x30 or higher.

Installation:
1. get r00t\jailbreak
2. install libpcap
 Android: botbrew->libpcap, ncurses
 IOS: Cydia->libpcap
3. install terminal
 Android: Android Terminal Emulator, Terminal IDE + Hackers Keyboard
 IOS: iSSH
4. chmod +x intercepter
5. run ./intercepter without args for GUI mode or ./intercepter -h for console mode
 

### Android known issues ###

1. You may get Bad mode for the chmod command, in that case change "+x" to "777" - chmod 777 intercepter.
2. You may get Permission Denined if you run intercepter from SD card. Copy it to the internal memory.
3. Copy intercepter to /botbrew/bin in case it doesn't run.

### Encodings ###
If you need to change the encoding for the output text (when you see wrong characters in sniffed messages)
just run intercepter like that: #LC_ALL=ru_RU.koi8-r ./intercepter

To do this trick on IOS you have to download native MAC locales (http://sniff.su/mac_locale.tar.gz) and extract them
to /usr/share/locale. It is also might be needed to play with iSSH encodings and the locale values.
For russian language set iSSH encoding to UTF-8 and the LC_ALL to ru_RU.KOI8-R.

Android locales not tested yet.

### Windows build ###

ARP Poison disabled on Windows, because Console Edition doesn't have own routing ability.


### Builds Info ###

Linux build:
compiled on OpenSuse 11.2 (i386).

FreeBSD build:
compiled on Freebsd 7.4 (i386).

MacOSX build:
compiled on MacOS X Lion 10.7.4.

IOS build:
compiled on Ipad 2 (4.3.3). Tested with Iphone 3GS (3.1.2), Iphone 4 (5.1.1), Ipad 3 (5.1.1).
use iSSH as terminal program. Set KOI8-U encoding and Courier font to enable pseudo graphic.

Android build:
compiled on Huawei MediaPad (MSÌ8260 Snapdragon ARMv7) Android 3.2 (tested on 4.0.3 also).
use Android Terminal Emulator.
Also tested on: Alcatel OT-990 (2.3).

ps: Big thanks to nimmox for testing and building android version.
