# init.d

init.d中存放内容
***
这个目录存放的是一些脚本，一般是linux以rpm包安装时设定的一些服务的启动脚本。
系统在安装时装了好多rpm包，这里面就有很多对应的脚本。
执行这些脚本可以用来启动，停止，重启这些服务。

etc/init.d 与/etc/rc.d/init.d联系
***
[root@ucs1 etc]# ls -ld /etc/init.d
lrwxrwxrwx. 1 root root 11 Jan 17  2000 /etc/init.d -> rc.d/init.d
/etc/init.d是/etc/rc.d/init.d的软连接

init.d运行时间段
***
在init进程从/etc/inittab文件读取了运行级别以后，就根据运行级别有选择的运行
init.d目录下的脚本。它是怎么选择的呢？它首先执行/etc/rc.d/rc这个脚本，对应
每一个运行级别，都有一个rcx.d目录，每一个rcx.d目录中都是init.d脚本集中的子
脚本软连接。