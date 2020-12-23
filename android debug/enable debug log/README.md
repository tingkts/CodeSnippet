### log level

```
    Verbose        2
    Devug          3
------------------------------------------------    
    Info           4    <default log level>
    Warn           5
    Error          6
    Assert, WTF    7
```

### enable debug log



|              |                                                     |
|--------------|-----------------------------------------------------|
| kernel       | 1). #define DEBUG <br/> 2). modify printk log level |
| uboot        | #define DEBUG                                       |
| native ALOGD | #define LOG_NDEBUG 0                                |


### reference

- [ANDROID中C++层打开ALOGV打印的LOG开关 - 奔跑的蜗牛 - CSDN博客](https://blog.csdn.net/yu741677868yu/article/details/80682182)
