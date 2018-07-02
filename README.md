# apprentice
功能点：
1、SpringMVC架构 

2、TK-mybatis数据源 
a、引入pom文件 
b、配置spring-db-tk.xml文件 
c、编写UserDao继承Mapper&lt;T> 

3、普通mybatis数据源 
a、引入pom文件 
b、配置spring-db-mybatis.xml文件 
c、编写MybatisBaseMapper继承SqlSessionDaoSupport 
d、编写具体实现类继承MybatisBaseMapper  

4、spring-jpa数据源 
a、引入pom文件 
b、配置spring-db-jpa.xml文件 
c、所有的repository继承JpaRepository 

5、单元测试（模拟HTTP请求，mockMvc模式） 

6、log4j日志 
必须引入slf4j-api和slf4j-simple包  

7、logback.xml日志 
移除log4j需要的jar,添加logback需要的jar 
logback.xml放在resources下
