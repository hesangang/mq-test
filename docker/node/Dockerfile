FROM ubuntu:20.04

# 安装OpenJDK
RUN apt-get update && apt-get install -y openjdk-17-jdk

# 设置工作目录
WORKDIR /app

# 安装Maven
RUN apt-get update && apt-get install -y maven

# 安装Node.js和npm
RUN apt-get update && apt-get install -y nodejs npm

# 设置环境变量
ENV NODE_VERSION 12.20.1
ENV NPM_VERSION 6.14.8

# 安装特定版本的Node.js和npm
RUN curl -sL https://deb.nodesource.com/setup_12.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g npm@6.14.8

# 复制项目文件到工作目录
COPY . /app

# 构建应用
RUN mvn package

# 设置容器启动时执行的命令
CMD ["java", "-jar", "/app/target/my-app-1.0-SNAPSHOT.jar"]