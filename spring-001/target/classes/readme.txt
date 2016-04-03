本例子主要展示了Spring Aop关于用注解@AspectJ的一些常见用法

在用户登录时利用Aop简单的打印一些信息。

spring Aop 定义了五种不同的通知
  Before 前置通知
  After  后置通知
  After-return 
  After-throwing
  Around 环绕通知
  
  使用Around通知的好处是它可以共享一些状态信息，而不必定义多余的参数，尤其是在service中，尽量不要定义
 多余的成员变量，因为大多数service是共享的且是单例的。
 
 