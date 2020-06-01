
### Android XTS

| XTS  | description |
| ------------- | ------------- |
| [CTS](https://source.android.com/compatibility/cts)  | Compatibility Test Suite  |
| [CTS Verifier](https://source.android.com/compatibility/cts/verifier)  | Compatibility Test Suite (manual)    |
| [CTS Instant](https://source.android.com/compatibility/cts/cts-instant)  | CTS for Instant Apps  |
| [GTS](https://www.google.com/search?rlz=1C1GCEU_zh-TWTW892TW892&sxsrf=ALeKk02eBIbx6LyVNKMNiPSiHHSNrzDiHw%3A1590399842164&ei=YpPLXuvNCaO9mAWRnJ7IAg&q=android+GTS&oq=android+GTS&gs_lcp=CgZwc3ktYWIQAzIECCMQJzICCAAyAggAMgIIADIFCAAQywEyBQgAEMsBMgIIADIECAAQHjIECAAQHjIECAAQHlDBlQFYgZgBYJqcAWgAcAB4AIABNogBjgGSAQEzmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwjrhpKN3c7pAhWjHqYKHRGOBykQ4dUDCAw&uact=5)  | GMS Test Suite  |
| [VTS](https://source.android.com/compatibility/vts)  | HIDL Service Test Suite  |
| [STS](https://www.google.com/search?rlz=1C1GCEU_zh-TWTW892TW892&sxsrf=ALeKk02iUxZOZzeBJpKAZq8b1S3L_v_3Ng%3A1590400008373&ei=CJTLXpq2FuTRmAWvnI7ADQ&q=android+STS&oq=android+STS&gs_lcp=CgZwc3ktYWIQAzIECCMQJzICCAAyAggAMgYIABAHEB4yBggAEAcQHjIICAAQBxAKEB4yBwgAEAoQywEyBQgAEMsBMgcIABAKEMsBMggIABAHEAoQHjoECAAQRzoECAAQQzoECAAQCjoICAAQBxAFEB46BwgjELACECc6BAgAEA1QpEVY401gw1BoAHACeACAATmIAY4DkgEBOJgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwia2rLc3c7pAhXkKKYKHS-OA9gQ4dUDCAw&uact=5)  | Security Test Suite for security patch |

- CTS :

    - `run cts -m CtsMediaStressTestCases -t android.mediastress.cts.MediaRecorderStressTest#testStressRecordVideoAndPlayback`

    - cts retry :

        `l r` : to check the retry session

        `run retry --retry session` : to execute retry session

- STS :

    - `run sts-engbuild -m StsHostTestCases -t android.security.sts.Poc16_12#testPocCVE_2014_9910 --disable-reboot`

    - `run sts-engbuild-no-spl-lock -m StsHostTestCases -t android.security.sts.Poc16_12#testPocCVE_2014_9910 --disable-reboot`

### reference

- [AndroidTV CTS/VTS/GTS/STS - 台部落](https://www.twblogs.net/a/5d085150bd9eee1e5c8111d9)


### utility : java-decompiler

- [java-decompiler/jd-gui: A standalone Java Decompiler GUI](https://github.com/java-decompiler/jd-gui)

- [skylot/jadx: Dex to Java decompiler](https://github.com/skylot/jadx)

- [Java Decompiler - Atanas Neshkov Ltd Software development and IT solutions](http://www.neshkov.com/)
