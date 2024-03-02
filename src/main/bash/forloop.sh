#/bin/bash


for X in java scala python
do
  echo $X
  date
done

for (( c=1; c<=5; c++ ))
do
   echo "Welcome ${c}th times"
done


for (( ; ; ))
do
   echo $RANDOM
done
