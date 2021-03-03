#!/bin/bash

##
##this is the shell script, it used to run RegExpTool.jar,it need many arguments,so i think use a shell script to run is better.
##If you try to run it directly,you will get many error,because java don't know where the lib and lib path are.
##
echo work dir:
base_dir=$(cd "$(dirname "$0")";pwd)
echo $base_dir
cd $base_dir
java --module-path "javafx-sdk-11.0.2/lib/" --add-modules javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.web,javafx.media -jar RegExpTool.jar
