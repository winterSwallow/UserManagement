# UserManagement
a crm system for userManagement

一、项目架构
===

SpringBoot + JPA + Thymeleaf

二、实体类设计
===

User.java

三、实体类增删改查
===

UserService.java

四、API设计
===

【GET请求】 /users :返回用于展现用户列表的list.html页面;  
【GET请求】 /users/search :返回用户展现查询用户结果的list.html页面;  
【GET请求】 /users/form :返回用于新增或者修改用户的form.html页面;  
【POST请求】 /users :新增或修改用户，成功后重定向到list.html页面;  
【GET请求】 /users/delete/{id} :根据id删除相应的用户数据，成功后重定向到list.html页面;  
【GET请求】 /users/modify/{id} :根据id获取相应的用户数据，并返回form.html页面用来执行修改  

五、后台控制器实现
===

UserController.java

六、前端页面
===

footer.html
header.html
form.html
list.html

七、参考链接
===

https://blog.csdn.net/silencespeaks/article/details/86238283
