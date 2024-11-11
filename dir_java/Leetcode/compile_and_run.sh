#! /usr/bin/sh
prob_num=$1

cmd1="javac -d build src/Easy/Problem$prob_num/LeetcodeProblem$prob_num.java"
cmd2="jar cfm bin/LeetcodeProblem$prob_num.jar manifest.txt -C build/ ."
cmd3="java -jar bin/LeetcodeProblem$prob_num.jar"

sed -i -E "s/[0-9]+/$prob_num/g" manifest.txt

$cmd1
$cmd2
$cmd3