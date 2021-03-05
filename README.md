# RegExpTool Linux Unix

## Describe
Regular expression testing tool, the use of Java development, convenient multi-platform offline use.Regular expression implementation engines are currently supported in Java, Python, and C#, and the current version is in beta.Using JavaFX 11 components development, follow the BSD protocol, you can obtain and modify this program for free, completely open source.

## How to build it. (Maven or gradle is not used,it's slow and complex.)
### 1.You need to add JavaFX lib manually.
#### (1) Get JAVAFX
You can get the open javafx at [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/)
or Chiese site at [https://openjfx.cn/dl/](https://openjfx.cn/dl/).
You need to download the corresponding JAVAFX version for your computerr,such as JavaFX Windows SDK ,JavaFX Linux SDK,JavaFX Mac OS X SDK.
#### (2) Unzip the package and add the lib folder to the PATH or IDE path.
IDEA：File -> Project Structure -> Libraries -> + -> "find javafx-sdk-xx.x.x\lib and add."
### 2.Add running variables.
#### (1) copy JAVAFX absolute path
#### (2) Add IDEA VM option. Run -> Edit Configurations -> add build and run options(near the jre version select place). important!
--module-path "javafx path(you need replace it.)" --add-modules javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.web,javafx.media -Dfile.encoding=UTF-8
### 3.Run RegExpTool.main
### 4.Use shell to run jar. regexptool.sh
Befor use the run the script ,you should change the JAVAFX path in the shell script.
You can use the regexptool.sh to run this application. 
```console
linux@usename:~$ chmod 777 regexptool.sh
linux@usename:~$ ./regexptool.sh
```

## How to run.
It use console to run script and get Python3 and C# results.you should install python3 and dotnet framwork to get full function.
### (1) Change the JAVAFX absolute path of "regexptool.sh". 
You can get the open javafx at [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/)
### (2) Run "regexptool.sh" in console
Don't copy the command to shell directly,you need change to program root befor it.
## The address of the full package
It need JAVAFX/lib and additional Java parameters  to run.
[RegExpTool For Linux .zip file.](https://codeload.github.com/sketchdee/RegExpTool-Linux/zip/main)
