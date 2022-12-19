# mushan-cloud

#### 介绍
通用的通用管理系统！前端使用vue3  后端使用springcloud
#### 软件架构
软件架构说明


## 系统模块

~~~
com.mushan     
├── mushan-gateway         // 网关模块 [8080]
├── mushan-common          // 通用模块
│       └── mushan-common-captcha                    // 验证码配置
│       └── rmushan-common-log                          // 日志记录
│       └── mushan-common-redis                        // 缓存服务
│       └── mushan-common-security                     // 权限
│       └── ruoyi-common-utlis                      // 工具
├── mushan-system         // 系统   9001
├── mushan-generate          // 代码生成   7001
├──pom.xml                // 公共依赖
~~~


