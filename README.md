# android-boot

## 什么是Android Boot？
一个服务化的Android SOA 框架，一些库的集合。解决多模块开发中模块间的耦合问题。真正实现细粒度开发。

- 统一标准的开发体验
    + 每个模块只需要关系自己提供的服务
    + 避免复杂的接口关系
- 统一标准的发布管理
    + 容器化
    + 开箱即用的设计思路

## 设计图

![](http://onhff7qaf.bkt.clouddn.com/android-boot.001.jpeg)
![](http://onhff7qaf.bkt.clouddn.com/android-boot.002.jpeg)

## 设计说明

### App 容器
用以初始化通信层，并装载SDK

### 通信层
用以完成SDK间的通信

#### 通信协议
`scheme://sdk-name/bnsiness.action?queryString`

- scheme: 描述服务类型
- sdk-name: 描述SDK名称
- bnsiness: 描述具体的业务
- action： 描述执行的动作
- queryString： 业务需要的参数

### SDK
有基础库和业务单元组成，用以实现具体的服务。

### TODO LIST
- [x] 工程初始化
- [x] 注解工程实现
- [ ] smoke tower 功能实现
- [ ] 容器实现
- [ ] 插件实现
