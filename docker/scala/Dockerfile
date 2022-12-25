FROM ubuntu:latest

SHELL ["/bin/bash", "-c"]
# Package Manager Update
RUN apt update -y

# Install Requirements
RUN apt-get install -y unzip &&\
    apt-get install -y zip &&\
    apt-get install -y curl &&\
    curl -s "https://get.sdkman.io" | bash

RUN source $HOME/.sdkman/bin/sdkman-init.sh && \
    yes | sdk install java $(sdk list java | grep -o "\b8\.[0-9]*\.[0-9]*\-tem" | head -1) && \
    yes | sdk install sbt && \
    rm -rf $HOME/.sdkman/archives/* && \
    rm -rf $HOME/.sdkman/tmp/*
