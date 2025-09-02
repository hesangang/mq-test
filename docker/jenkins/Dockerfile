FROM jenkins/jenkins:lts

USER root

# 安装 Docker CLI
RUN apt-get update && \
    apt-get install -y docker.io && \
    groupadd docker || true && \
    usermod -aG docker jenkins

USER jenkins