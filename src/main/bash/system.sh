#/bin/bash

echo $0
echo $1
echo $2

echo "System uptime....."
uptime

echo
echo "Memory Utilization......"
#free -m
top -l 1 -s 0 | grep PhysMem
vm_stat

echo
echo "Disk Utilization......"
df -h

echo
echo "Network Utilization......"
ifconfig

# 2 command subsituations
FREE_DISK=`df -h`
echo $FREE_DISK

FREE_DISK=$(df -h | awk '{print $4i}')
echo $FREE_DISK
