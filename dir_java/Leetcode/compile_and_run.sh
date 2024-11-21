#! /usr/bin/sh
difficulty=$1
prob_num=$2

if [ $# -eq 0 ]; then
  echo "No arguments provided."
  exit 1

elif [ $# -eq 1 ]; then
  echo "Difficulty Missing."
  exit 1

else
  echo "Argument(s) provided:" $difficulty $prob_num

fi

cmd1="javac -d build src/${difficulty}/Problem$prob_num/LeetcodeProblem$prob_num.java"
cmd2="jar cfm bin/LeetcodeProblem$prob_num.jar manifest.txt -C build/ ."
cmd3="java -jar bin/LeetcodeProblem$prob_num.jar"

echo "Main-Class: src.${difficulty}.Problem$prob_num.Solution" > manifest.txt


$cmd1
$cmd2
$cmd3