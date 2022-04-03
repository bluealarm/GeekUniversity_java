# 作业
***
## 作业1
### 作业要求
&ensp;&ensp;&ensp;&ensp;使Java里的动态代理，实现一个简单的AOP

### 实现说明
代码：aopdemo/proxy
方式一：基于静态代理方式
方式二：基于JDK1.3后Java Proxy的InvocationHandler接口实现
方式三：基于CGLIB的MethodInterceptor接口实现
方式四：基于Javassist的MethodHandler接口实现
方式五：基于SpringAOP的@Aspect与自定义注解实现

## 作业2
### 作业要求
&ensp;&ensp;&ensp;&ensp;写代码实现Spring Bean的装配，方式越多越好（XML、Annotation都可以）,提交到Github

### 实现说明
代码：aopdemo/auto,aopdemo/javacode,aopdemo/xml
&ensp;&ensp;&ensp;&ensp;一共三种方式：

- 1.自动注解方式：
- 2.Java代码方式：
- 2.Xml配置方式：

## 作业3
### 作业要求
&ensp;&ensp;&ensp;&ensp;实现一个 Spring XML 自定义配置，配置一组 Bean，例如：Student/Klass/School

### 实现说明
代码：apodemo/school
## 作业4
### 作业要求
&ensp;&ensp;&ensp;&ensp;给前面课程提供的 Student/Klass/School 实现自动配置和 Starter

### 实现说明
代码：schooldemo

## 作业5
### 作业要求
&ensp;&ensp;&ensp;&ensp;研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法：

- 1）使用 JDBC 原生接口，实现数据库的增删改查操作。
- 2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
- 3）配置 Hikari 连接池，改进上述操作。提交代码到 Github。

### 实现说明
代码：databasedemo
  - jdbc：放置原生jdbc操作和事务操作
  - Hikari：放置Hikari简单示例


