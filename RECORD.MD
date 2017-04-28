一、目录结构
 ├ sparrow	                       总目录
 │ └ sparrow-web	               目前框架WEB端主目录
 │   ├cm.sheetanchor             基础框架JAVA代码目录
 │   │ ├common                  公共模块目录
 │   │ │ ├ beanvalidator       实体类bean验证相关实体类
 │   │ │ ├ config              日志相关工具类
 │   │ │ ├ hibernate           hibernate相关工具类
 │   │ │ ├ interceptor         拦截器相关工具类
 │   │ │ ├ listener            监听相关工具类
 │   │ │ ├ mapper              映射转换工具类
 │   │ │ ├ page                分页相关工具类
 │   │ │ ├ persistence         持久层工具类
 │   │ │ ├ security            安全相关工具类
 │   │ │ ├ service             服务相关工具类
 │   │ │ ├ servlet             servlet相关工具类
 │   │ │ ├ utils               各种小工具类
 │   │ │ └ web                 模型控制器层相关工具类
 │   │ └sparrow                 业务功能模块目录
 │   │     ├ act                activiti工作流模块
 │   │     ├ cms                CMS模块
 │   │     ├ oa                 OA模块
 │   │     └ sys                  系统基础模块
 │   ├resources                    资源目录
 │   │  ├cache                    缓存相关配置文件
 │   │  ├log4j.properties         日志配置文件
 │   │  ├sparrow.properties       系统基础配置文件
 │   │  ├spring-context.xml       数据库相关配置文件
 │   │  ├spring-context-shiro.xml Shiro配置文件
 │   │  └spring-mvc.xml           Spring基础配置文件
 │   └webapp                    页面资源目录
 │       ├static                静态资源/第三方插件目录
 │       └WEB-INF
 │          ├tags               tag标签目录（tag文件作用一般是一段小代码，类似include文件的作用）
 │          ├tlds               jstl标签目录（tld文件作用比较复杂，可以实现很多高级的作用）
 │          ├views              页面资源
 │          ├ckfinder.xml       CK编辑器配置文件
 │          └web.xml
 │
 │
 │
------------------------------------------------------------------------------------------------------------------------
 二、开发规范
 1、类注释：必须包含类功能描述，作者，时间
 2、方法注释：除非常容易理解的方法如get、form、save、delete等方法外的方法必须加注释来说明用途，传递参数。
 3、按照以上命名结构进行文件分配存放。
 4、视图文件名要加模块或功能前缀，例如actTaskTodoList.jsp，代表：工作流任务待办列表,不要写成list.jsp或todoList.jsp或taskTodoList.jsp。