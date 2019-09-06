#!/bin/bash

#定数定義
JOB_DIR="/aoyamabatch"
parameter=$1
statusNormal=0
statusError=9
jobparam=""

#ジョブ設定、実行
if [[ ! $# -eq 1 ]];  then
  echo "error:The parameter must be not null!"
  exit $statusError;
  
elif [[ $parameter -eq 1000 ]];  then
  jobname="JobSiireYoteiYoky"
  
elif [[ $parameter -eq 1130 ]];  then
  jobname="JobReceiveOrder"
  jobparam="selectFlag=0"
  
elif [[ $parameter -eq 1230 ]];  then
  jobname="JobReceiveOrder"
  jobparam="selectFlag=2"
  
elif [[ $parameter -eq 1150 ]];  then
  jobname="JobGetStock"
  
elif [[ $parameter -eq 1155 ]];  then
  jobname="JobGetOrderStatus"

elif [[ $parameter -eq 1200 ]]; then  
  jobname="JobSiireYoteiHenji"

elif [[ $parameter -eq 1500 ]]; then  
  jobname="JobShukka"
  
else
  echo "error:The parameter is invalid number!"
  exit $statusError;
fi

  jobxml=$jobname.xml
  
  echo "=== $jobname START `date`==="
  
  java -cp "${JOB_DIR}/lib/*:${JOB_DIR}/jar/*" org.springframework.batch.core.launch.support.CommandLineJobRunner META-INF/jobs/$jobxml $jobname $jobparam

#ジョブ実行状態確認
if [ ! $? -eq 0 ];  then
  echo "=== $jobname ERROR END `date`==="
  exit $statusError;
else
  echo "=== $jobname NORMAL END `date`==="
  exit $statusNormal;
fi

