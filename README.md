# android-boot

## 什么是Android Boot？
一个服务化的Android 框架，一些库的集合。解决多模块开发中模块间的耦合问题。真正实现细粒度开发

## 设计图

![](http://onhff7qaf.bkt.clouddn.com/android-boot.001.jpeg)
![](http://onhff7qaf.bkt.clouddn.com/android-boot.002.jpeg)

## 设计说明

### App 容器
### 通信层

#### 通信协议
`scheme://sdk-name/bnsiness.action?queryString`

- scheme: 描述服务类型
- sdk-name: 描述SDK名称
- bnsiness: 描述具体的业务
- action： 描述执行的动作
- queryString： 业务需要的参数


### SDK
