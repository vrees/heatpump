#!/bin/bash

java -cp /home/vrees/.gradle/caches/modules-2/files-2.1/us.ihmc/ihmc-ethercat-master/0.11.2/291293bc98879ccc20761e409750af2e2c1117ad/ihmc-ethercat-master-0.11.2.jar \
     -cp /home/vrees/.gradle/caches/modules-2/files-2.1/us.ihmc/ihmc-ethercat-master/0.11.2/291293bc98879ccc20761e409750af2e2c1117ad/ihmc-native-library-loader-1.1.jar \
  us.ihmc.etherCAT.master.SlaveInfo $@


