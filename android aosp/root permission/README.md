#### Obtain root permision :

- standalone SDK app or called market app : through [su](https://github.com/ChainsDD/su-binary) and [superuser.apk](https://github.com/ChainsDD/Superuser).

    - [android 利用superuser编写使用root权限的app_移动开发_大海蓝天的专栏-CSDN博客](https://blog.csdn.net/dahailantian1/article/details/78584574?utm_source=blogxgwz0)
      - [ChainsDD/su-binary](https://github.com/ChainsDD/su-binary)
      - [ChainsDD/Superuser](https://github.com/ChainsDD/Superuser)

    - [Android应用向su申请root权限，以及Superuser进行授权管理的原理浅析_移动开发_koozxcv的博客-CSDN博客](https://blog.csdn.net/koozxcv/article/details/51125046)


- platform app :
  - init actionable property or init service
      - [Android 应用通过init.rc启动service去执行具有root权限sh脚本 - wf_fln的博客 - CSDN博客](https://blog.csdn.net/wf_fln/article/details/77417807)
      - [android中执行shell脚本或者需要root权限代码的方法 - 冷雨的专栏 - CSDN博客](https://blog.csdn.net/jiangbei_lengyu/article/details/9094657)
      - [android应用如何在有需要时申请root权限？在程序中要调用哪些语句来实现？ - 大海蓝天的专栏 - CSDN博客](https://blog.csdn.net/dahailantian1/article/details/78584485)


  - through IPC binder call into system process. e.g. vold etc.


<br>

&nbsp;&nbsp;&nbsp;[Android系统system用户权限和root权限的获取 - koozxcv的博客 - CSDN博客](https://blog.csdn.net/koozxcv/article/details/50846027)


<br>

#### Reference

- [SUID, GUID, Sticky Bit](https://juejin.im/post/5d0ad3855188252a5b1d2b93)

   SUID: caller can obtain callee's owner permision if callee set suid bit.