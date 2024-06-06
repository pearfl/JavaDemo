IDEA和SpringBoot简单学习

Config：所有的配置
Controller：请求入口
Service：逻辑层
Mapper：持久层
Domain（PO）：持久对象（可以看成是与数据库中的表映射的 Java 对象，最简单的 PO 就是对应数据库中某个表中的一条记录，多个记录可以用 PO 的集合，PO 中应该不包含任何对数据库的操作）
Dto：数据传输对象（用于远程调用等需要大量传输对象的地方，也可以泛指用于展示层与服务层之间的数据传输对象）

本项目没有，但别的项目中常用的概念

BO：业务对象（主要作用是把业务逻辑封装为一个对象，这个对象可以包括一个或多个其他的对象。比如一份简历，有教育经历、工作经历、社会关系等。可以把教育经历对应一个 PO，工作经历对应一个 PO，社会关系对应一个 PO，然后建立一个对应建立的 BO来处理简历，每个 BO 包含这些 PO，这样就可以针对 BO 去处理业务逻辑）

DAO：数据访问对象（此对象用于访问数据库，通常与 PO 结合使用，DAO 中包含了各种数据库的操作方法，结合 PO 对数据库进行相关操作，处于业务逻辑与数据库资源中间，通过它可以把 POJO 持久化为 PO，用 PO 组装 VO、DTO）

DO：领域对象（从现实世界中抽象的业务实体）

POJO：简单无规则 Java 对象（传统意义上的 Java 对象，就是说在一些表关系映射工具中，能够做到维护数据库表记录的持久化对象完全是一个符合 Java Bean 规范的纯 Java 对象，没有增加别的属性和方法。也可以理解成最基本的 Java Bean，只有属性字段及 setter 和 getter 方法）

VO：值对象（通常用于业务层之间的数据传递，和 PO 一样也是仅仅包含数据而已，是抽象出来的业务对象，PO 只能用在数据层，VO 用在表示层）

## 简单课件
业务->抽象成各个层->对各个层进行研发



写代码？到底是什么



写题

​	题目->两数之和->抛出一个问题，得到一个结果（函数的形式）

​	定义了一个函数，定义了返回类型，定义了输入参数个数和类型

​	解决提出的一个问题



写工程

​	很复杂的业务->抽象成可以通过逻辑进行解释的过程->

​	整个过程就写一个文件

​	原始：你买一个东西->到货

​	实际：退货；换货；组合优惠；优惠券；推送广告；客服；追踪评价

​	第一次拆解：买东西->到货

​			买东西->等待确认接收（线程卡死在这）->到货->是否退货（线程卡死在这）

​						（异步过程）                                             （异步过程）

​	你会发现，程序从一个单个函数->多个函数步骤过程



工程需要解决的问题？

网络通信；数据库；业务流程；



模块拆解能力（决定了你的晋升级别）



SpringBoot+Mybatis



为什么需要组件？

你的业务代码编写时间可能只占5%；

为了更好的把时间投入到业务流程的设计中



maven：包管理工具



**Controller**（对外访问的接口，暴露出去让别人调用）

外部访问->找到对应的访问的函数

不进行任何业务处理，仅仅用来调用别的业务处理方法



**Service**（业务流程）

业务，类似写算法题，你去实习业务过程，返回结果给Controller

为什么返回结果是UserDto？

UserDto就是定义了一个返回的类型



Service中不做数据库操作（为什么不在Service中做？）

不在Servive中做数据库连接->查询数据

用函数去别的地方去取数据



**Mapper**（和数据源的交互过程，取数据）

取数据相关的工作放在Mapper中

如果需要修改数据源的话还有sql操作的话，只在Mapper端做修改即可



mapper文件夹内的UserMapper，内部定义方法（输入和输出类型）

interface（接口），不实现具体内容，但是定义输入输出类型



领导：你写20个接口，你去实现这20个接口的内容

员工：好的，我去实现你定的接口



Mybatis中，UserMapper中的接口（sql取数内容）会由mapper/UserMapper.xml中具体的sql代码来实现



Domain（PO）：从数据源中取回数据的格式



Dto（Service返回给Controller的数据格式）；

PO（Mapper中实现sql代码返回的数据格式）





SpringBoot+Mybatis

Controller->Service（DTO定义返回给Controller的数据格式）->Mapper（定义interface）->Mapper.xml内去实现sql代码（连接数据源获取返回结果，PO定义返回给Mapper的数据格式）

Controller：对外暴露接口

Service：实现具体业务代码

Mapper：取数据



BO：业务对象（主要作用是把业务逻辑封装为一个对象，这个对象可以包括一个或多个其他的对象。比如一份简历，有教育经历、工作经历、社会关系等。可以把教育经历对应一个 PO，工作经历对应一个 PO，社会关系对应一个 PO，然后建立一个对应建立的 BO来处理简历，每个 BO 包含这些 PO，这样就可以针对 BO 去处理业务逻辑）



PO：数据表->returnType数据格式

有的PO来自于MySQL；有的PO来自于Oracle

BO：多个PO的一个组合



DAO：数据访问对象（此对象用于访问数据库，通常与 PO 结合使用，DAO 中包含了各种数据库的操作方法，结合 PO 对数据库进行相关操作，处于业务逻辑与数据库资源中间，通过它可以把 POJO 持久化为 PO，用 PO 组装 VO、DTO）



DAO：对取来的PO做二次加工，持久化对象



DO：领域对象（从现实世界中抽象的业务实体）



POJO：简单无规则 Java 对象（传统意义上的 Java 对象，就是说在一些表关系映射工具中，能够做到维护数据库表记录的持久化对象完全是一个符合 Java Bean 规范的纯 Java 对象，没有增加别的属性和方法。也可以理解成最基本的 Java Bean，只有属性字段及 setter 和 getter 方法）



VO：值对象（通常用于业务层之间的数据传递，和 PO 一样也是仅仅包含数据而已，是抽象出来的业务对象，PO 只能用在数据层，VO 用在表示层）



PO、DAO、DTO、VO



Controller->Service（很多个Service，这些Serivce中互传数据的returnType的定义就是VO）->Mapper



PO：从数据库拿数据

DAO：对PO做加工

Service-Mapper：DAO

VO：Service之间的互相调用

Controller-Serivce之间调用的returnType：DTO
