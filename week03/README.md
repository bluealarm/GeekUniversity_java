第3周作业
作业内容
Week03 作业题目（周四）：

基础代码可以 fork： https://github.com/kimmking/JavaCourseCodes

02nio/nio02 文件夹下

实现以后，代码提交到 Github。

1.（必做）整合你上次作业的 httpclient/okhttp；

2.（选做）使用 netty 实现后端 http 访问（代替上一步骤）

Week03 作业题目（周六）：

1.（必做）实现过滤器。 2.（选做）实现路由。

作业提交规范：

作业不要打包 ；
同学们写在 md 文件里，而不要发 Word, Excel , PDF 等 ；
代码类作业需提交完整 Java 代码，不能是片段；
作业按课时分目录，仅上传作业相关，笔记分开记录；
画图类作业提交可直接打开的图片或 md，手画的图手机拍照上传后太大，难以查看，推荐画图（推荐 PPT、Keynote）；
提交记录最好要标明明确的含义（比如第几题作业）。
操作步骤
下载老师的项目: https://github.com/kimmking/JavaCourseCodes
解压, 拷贝其中 02nio 路径下的 nio02 目录到第三周的作业目录下。
Idea或者Eclipse打开这个Maven项目。
增加自己的包名, 以做标识。
将第二周的作业代码整合进来: homework02 中的代码和pom.xml依赖。
将 nio01 中的 HttpServer03 代码整合进来作为后端服务，改名为 BackendServer, 监听 8088 端口。
找到Netty官网: https://netty.io/wiki/user-guide-for-4.x.html
参照官方示例, 编写自己的过滤器 ProxyBizFilter, 并加入到 HttpInboundInitializer 的初始化方法中。
修改 HttpOutboundHandler 类，使用自己写的 第二周的作业代码；