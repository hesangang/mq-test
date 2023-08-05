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


- https://www.ngui.cc/el/1232914.html?action=onClick

4. Go to the project folder and run the `set_configuration.sh` script:

    **Please note**: the action must be performed with **root** rights.

    ```
    bash set_configuration.sh
    ```
   
## ssl

```agsl
 openssl genrsa -out root.key.pem 2048
 openssl req -x509 -new -nodes -key root.key.pem -days 9131 -out root.crt.pem -subj "/C=DE/ST=BW/L=Stuttgart/O=Dummy Authority/CN=Dummy Authority"
 openssl genrsa -out privkey.pem 2048 -key privkey.pem
 openssl req -key privkey.pem -new -sha256 -out sangang.com.csr.pem -subj "/C=DE/ST=BW/L=Stuttgart/O=Dummy Authority/CN=sangang.com"
 openssl x509 -req -in sangang.com.csr.pem -CA root.crt.pem -CAkey root.key.pem -CAcreateserial -out cert.pem -days 9131
 mv privkey.pem /etc/coolwsd/key.pem
 mv cert.pem /etc/coolwsd/cert.pem
 mv root.crt.pem /etc/coolwsd/ca-chain.cert.pem
```