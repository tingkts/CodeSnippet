### log level

```
    Verbose
    Devug
-----------------------
    <default>
    Info
    Warn
    Error
```

### enable debug log



|              |                                                     |
|--------------|-----------------------------------------------------|
| kernel       | 1). #define DEBUG <br/> 2). modify printk log level |
| uboot        | #define DEBUG                                       |
| native ALOGD | #define LOG_NDEBUG 0                                |


### reference

- [ANDROID中C++层打开ALOGV打印的LOG开关 - 奔跑的蜗牛 - CSDN博客](https://blog.csdn.net/yu741677868yu/article/details/80682182)