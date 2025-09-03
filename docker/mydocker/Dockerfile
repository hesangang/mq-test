# 基于 Maven + JDK8
FROM maven:3.8.6-openjdk-8

# 安装 Docker CLI
RUN apt-get update && \
    apt-get install -y docker.io && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# 默认工作目录
WORKDIR /app
