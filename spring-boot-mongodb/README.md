### 暂时还未做密码登录

Springboot-mongodb-docker

如果电脑上装了docker环境，直接运行启动 没有镜像的话会自动给你装 如果有镜像就会启动镜像

   docker-compose up -d
运行完成会在项目根目录生成一个mongodb的文件夹

访问线面链接你能看到mongodb的可视化界面

//mongodb可视化界面
127.0.0.1：8081

//添加user
127.0.0.1:8080/save?userName=苏雨&sex=男&age=22

//查询所有的user不分页
127.0.0.1:8080/getall

//分页 第一页传0
127.0.0.1:8080/getall?pageNo=0&pageSize=2

//通过userid获取user信息
127.0.0.1:8080/getone?id=

//查询所有性别为男的user
127.0.0.1:8080/getbysex?sex=男

//通过userid删除user
127.0.0.1:8080/delete?id=

//通过userid修改用户信息 暂时传这两个的话别的值会变为null
127.0.0.1:8080/update?id=填上你的userid&userName=良良