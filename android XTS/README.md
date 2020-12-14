
### Android XTS

<br/>

| XTS  | description |
| ------------- | ------------- |
| [CTS](https://source.android.com/compatibility/cts)  | Compatibility Test Suite  |
| [CTS Verifier](https://source.android.com/compatibility/cts/verifier)  | Compatibility Test Suite (manual)    |
| [CTS Instant](https://source.android.com/compatibility/cts/cts-instant)  | CTS for Instant Apps  |
| [GTS](https://www.google.com/search?rlz=1C1GCEU_zh-TWTW892TW892&sxsrf=ALeKk02eBIbx6LyVNKMNiPSiHHSNrzDiHw%3A1590399842164&ei=YpPLXuvNCaO9mAWRnJ7IAg&q=android+GTS&oq=android+GTS&gs_lcp=CgZwc3ktYWIQAzIECCMQJzICCAAyAggAMgIIADIFCAAQywEyBQgAEMsBMgIIADIECAAQHjIECAAQHjIECAAQHlDBlQFYgZgBYJqcAWgAcAB4AIABNogBjgGSAQEzmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjrhpKN3c7pAhWjHqYKHRGOBykQ4dUDCAw&uact=5)  | GMS Test Suite  |
| [VTS](https://source.android.com/compatibility/vts)  | HIDL Service Test Suite  |
| [STS](https://www.google.com/search?rlz=1C1GCEU_zh-TWTW892TW892&sxsrf=ALeKk02iUxZOZzeBJpKAZq8b1S3L_v_3Ng%3A1590400008373&ei=CJTLXpq2FuTRmAWvnI7ADQ&q=android+STS&oq=android+STS&gs_lcp=CgZwc3ktYWIQAzIECCMQJzICCAAyAggAMgYIABAHEB4yBggAEAcQHjIICAAQBxAKEB4yBwgAEAoQywEyBQgAEMsBMgcIABAKEMsBMggIABAHEAoQHjoECAAQRzoECAAQQzoECAAQCjoICAAQBxAFEB46BwgjELACECc6BAgAEA1QpEVY401gw1BoAHACeACAATmIAY4DkgEBOJgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwia2rLc3c7pAhXkKKYKHS-OA9gQ4dUDCAw&uact=5)  | Security Test Suite for security patch |

<br/>

- CTS :

    ```
       // run the test module
       run cts -m CtsMediaStressTestCases

       // run the test case
       run cts -m CtsMediaStressTestCases -t android.mediastress.cts.MediaRecorderStressTest
       run cts -m CtsMediaStressTestCases -t android.mediastress.cts.MediaRecorderStressTest#testStressRecordVideoAndPlayback

       // run the test plan
       run cts-camera
    ```

    - cts retry :

        `l r` : to check the retry session

        `run retry --retry session` : to execute retry session

<br/>

- GTS :

  host pre-setting:
  - Put [gts-harman-public.json](./gts-harman-public.json) to your local path ，type APE_API_KEY=export ‘your local path/gts-harman-public.json’
  - ensure aapy, adb installed.
  - ensure JDK version > 1.8

  device pre-setting:
  - WiFi ON, link to IPV6 network
  - Bluetooth ON
  - Display → Sleep → 30 minutes
  - Location ON
  - Sound is adjusted to the minimum
  - Security → Screen lock → None
  - Security → Unknown sources ON
  - Developer options → Stay awake ON
  - Developer options → USB debugging ON
  - Launch Google Chrome，tap to accept

<br/>

- VTS :

     For Android version of the first approved build is lower than 8.x, if its MR builds upgrade to 8.x or higher, VTS and CTS-ON-GSI are optional(no need to run) ; <br>
     For Android 8.x and higher new device, VTS and CTS-ON-GSI are mandatory, and all MRs need run them too.


<br/>

- STS :

    ```
       run sts-engbuild -m StsHostTestCases -t android.security.sts.Poc16_12#testPocCVE_2014_9910 --disable-reboot

       run sts-engbuild-no-spl-lock -m StsHostTestCases -t android.security.sts.Poc16_12#testPocCVE_2014_9910 --disable-reboot
    ```




<br>

### Reference

- [AndroidTV CTS/VTS/GTS/STS - 台部落](https://www.twblogs.net/a/5d085150bd9eee1e5c8111d9)


<br>

### Utility : Java-Decompiler

- [java-decompiler/jd-gui: A standalone Java Decompiler GUI](https://github.com/java-decompiler/jd-gui)

- [skylot/jadx: Dex to Java decompiler](https://github.com/skylot/jadx) &ensp;&nbsp;- __*pretty good*__

- [Java Decompiler - Atanas Neshkov Ltd Software development and IT solutions](http://www.neshkov.com/) &ensp;&nbsp;- __*with charged license*__

> Not all APKs can be read after anti-group translation. If it is protected by ProGuard, the source code has been confused and almost unreadable, such as GMS App!



<br>


### Trick: how to skip cts in android native code

  - set flag through system properties: [0001-resolve-issue-video-in-black-screen.patch](./0001-resolve-issue-video-in-black-screen.patch)


<br>

### Tip: Camera XTS

  - CTS
    - run cts-camera
    - CtsCameraApi25TestCases
    - CtsMediaTestCases

  - CTS-I
    - CtsCameraTestCases
    - CtsMediaTestCases

  - CTS-V (manually testing)
    - camera category
    - camera sub-items in BYOD Managed Provisioning category

  - GTS
    - GtsCameraTestCases
    - GtsAssistantHostTestCases
    

<br>

### Note: 

 - GTS and STS tool/source code are not open published, are limited by OEM/vendor private licensed.
