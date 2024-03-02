#!/bin/bash

read -p "Enter your skill:" SKILL

if [ "$SKILL" == "java" ];
then
  echo "Awesome Skill: $SKILL"
else
  echo "Crappy Skill: $SKILL"
fi
