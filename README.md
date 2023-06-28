# 说明文档

## 安装环境

* jdk1.8
* maven
* mysql5.7
* pulsar
* git
* maven3.5

## 集成jacoco代码覆盖率
> 运行 mvn test 覆盖率报告target/site/jacoco

## sonar

## wsl

 - windows wsl下载地址：https://aka.ms/wslstore
 - wsl1升级wsl2: https://learn.microsoft.com/zh-cn/windows/wsl/install-manual#step-3---enable-virtual-machine-feature
 - 启动异常解决，打开Window 10 的cmd，执行以下命令：
> wsl -d docker-desktop

> echo 262144 >> /proc/sys/vm/max_map_count

- https://www.ngui.cc/el/1232914.html?action=onClick

4. Go to the project folder and run the `set_configuration.sh` script:

    **Please note**: the action must be performed with **root** rights.

    ```
    bash set_configuration.sh
    ```