# Dockerized nvm development environment
#
# This Dockerfile is for building nvm development environment only,
# not for any distribution/production usage.
#
# Please note that it'll use about 1.2 GB disk space and about 15 minutes to
# build this image, it depends on your hardware.
#https://github.com/nvm-sh/nvm

FROM ubuntu:22.04
LABEL maintainer="Peter Dave Hello <hsu@peterdavehello.org>"
LABEL name="nvm-dev-env"
LABEL version="latest"

# Set the SHELL to bash with pipefail option
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

# Prevent dialog during apt install
ENV DEBIAN_FRONTEND noninteractive

# ShellCheck version
ENV SHELLCHECK_VERSION=0.7.0

# Pick a Ubuntu apt mirror site for better speed
# ref: https://launchpad.net/ubuntu/+archivemirrors
ENV UBUNTU_APT_SITE ubuntu.cs.utah.edu

# Replace origin apt package site with the mirror site
RUN sed -E -i "s/([a-z]+.)?archive.ubuntu.com/$UBUNTU_APT_SITE/g" /etc/apt/sources.list
RUN sed -i "s/security.ubuntu.com/$UBUNTU_APT_SITE/g" /etc/apt/sources.list

# Install apt packages
RUN apt update         && \
    apt upgrade -y -o Dpkg::Options::="--force-confdef" -o Dpkg::Options::="--force-confold"  && \
    apt install -y -o Dpkg::Options::="--force-confdef" -o Dpkg::Options::="--force-confold"     \
        coreutils             \
        util-linux            \
        bsdutils              \
        file                  \
        openssl               \
        libssl-dev            \
        locales               \
        ca-certificates       \
        ssh                   \
        wget                  \
        patch                 \
        sudo                  \
        htop                  \
        dstat                 \
        vim                   \
        tmux                  \
        curl                  \
        git                   \
        jq                    \
        zsh                   \
        ksh                   \
        gcc                   \
        g++                   \
        xz-utils              \
        build-essential       \
        openjdk-17-jdk        \
        maven                 \
        bash-completion       && \
    apt-get clean

RUN wget https://github.com/koalaman/shellcheck/releases/download/v$SHELLCHECK_VERSION/shellcheck-v$SHELLCHECK_VERSION.linux.x86_64.tar.xz -O- | \
    tar xJvf - shellcheck-v$SHELLCHECK_VERSION/shellcheck          && \
    mv shellcheck-v$SHELLCHECK_VERSION/shellcheck /bin             && \
    rmdir shellcheck-v$SHELLCHECK_VERSION
RUN shellcheck -V

# Set locale
RUN locale-gen en_US.UTF-8

# Print tool versions
RUN bash --version | head -n 1
RUN zsh --version
RUN ksh --version || true
RUN dpkg -s dash | grep ^Version | awk '{print $2}'
RUN git --version
RUN curl --version
RUN wget --version

# Add user "nvm" as non-root user
RUN useradd -ms /bin/bash nvm

# Copy and set permission for nvm directory
COPY . /home/nvm/.nvm/
RUN chown nvm:nvm -R "/home/nvm/.nvm"

# Set sudoer for "nvm"
RUN echo 'nvm ALL=(ALL) NOPASSWD: ALL' >> /etc/sudoers

# Switch to user "nvm" from now
USER nvm

# nvm
RUN echo 'export NVM_DIR="$HOME/.nvm"'                                       >> "$HOME/.bashrc"
RUN echo '[ -s "$NVM_DIR/nvm.sh" ] && . "$NVM_DIR/nvm.sh"  # This loads nvm' >> "$HOME/.bashrc"
RUN echo '[ -s "$NVM_DIR/bash_completion" ] && . "$NVM_DIR/bash_completion" # This loads nvm bash_completion' >> "$HOME/.bashrc"

# 设置环境变量
ENV NODE_VERSION 10.15.3
ENV YARN_VERSION 1.7.0
# nodejs and tools
RUN bash -c 'source $HOME/.nvm/nvm.sh   && \
    nvm install $NODE_VERSION           && \
    npm install -g yarn@$YARN_VERSION   && \
    npm install -g doctoc urchin eclint dockerfile_lint && \
    npm install --prefix "$HOME/.nvm/"'

# 设置JAVA_HOME环境变量
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

# Set WORKDIR to nvm directory
WORKDIR /app

ENTRYPOINT ["/bin/bash"]
