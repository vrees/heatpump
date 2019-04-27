# heatpump
Application for controlling the Heatpump machine. Written in Java and EtherCAT fieldbus technology 
SOEM: https://openethercatsociety.github.io/ and its 
Java implementaion ihmc-ethercat-master:  https://github.com/ihmcrobotics/ihmc-ethercat-master.




## Setup

#### Prerequirements SOEM and ihmc-ethercat-master 

see https://github.com/ihmcrobotics/ihmc-ethercat-master

### Linux Mint

append the following to /etc/security/limits.conf
```
vrees       soft    cpu     unlimited
vrees       -       rtprio  100
vrees       -       nice    40
vrees       -       memlock unlimited
```
see https://github.com/ihmcrobotics/ihmc-ethercat-master/issues/5

### Avoid to run IntelliJ as root

In order to create raw sockets root access is needed. Therefore the excecutable has to run as root. As an alternative
you can set capabilities to the executable:
```
sudo setcap cap_net_raw,cap_net_admin=eip /home/vrees/dev/tools/clion-2019.1.2/jre64/bin/java
sudo setcap cap_net_raw,cap_net_admin=eip /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java
sudo setcap cap_net_raw,cap_net_admin=eip /home/vrees/dev/git-repos/SOEM/cmake-build-debug/test/linux/slaveinfo/slaveinfo
```
! don't forget to restart

