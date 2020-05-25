

### API
  - Native code :

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;use `property_get` and `property_set` APIs to read / set Property, need to include `cutils/properties.h` and link `libcutils`.

  - Java code :
    - SDK API : java.lang.System.get/setSystemProperty(), can't access native system property.
    - System API (@hide) : android.os.SystemProperties.get/set()


  - shell script:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;android provides getprop and setprop command line tools to get and update properties. It depends on libcutils.


### Limitation



- android.os.SystemProperty.set() doesn't allow app domain to set system property, android.os.SystemProperty.get() is ok.
  - app domain means the codes which are executed within app process, includes java codes, native codes, shell script codes.
```sepolicy
  app_neverallows.te ：
      neverallow { all_untrusted_apps -mediaprovider } property_type:property_service set;
```

```sepolicy log

  05-19 14:41:56.770 4173 4173 W AndroidTestSuit: type=1400 audit(0.0:13901): avc: denied { write } for name="property_service" dev="tmpfs" ino=11729 scontext=u:r:untrusted_app:s0:c89,c256,c512,c768 tcontext=u:object_r:property_socket:s0 tclass=sock_file permissive=0

  05-22 13:30:42.088 0 0 E selinux : avc: denied { set } for property=msi.cts.media.running pid=21117 uid=10111 gid=10111 scontext=u:r:untrusted_app:s0:c111,c256,c512,c768 tcontext=u:object_r:default_prop:s0 tclass=property_service permissive=1
```

### Reference

- [[Java][Android][Process] ProcessBuilder與Runtime區別 - IT閱讀](https://www.itread01.com/content/1548295215.html)
- [adb - How to define and use a system property in Android Instrumentation test? - Stack Overflow](https://stackoverflow.com/questions/3750109/how-to-define-and-use-a-system-property-in-android-instrumentation-test/11623309)
- [大丈夫日記: [Coding] Android Property System](http://ryan0210.blogspot.com/2013/12/codingandroid-android-property-system.html)
