#!/bin/bash
##
 # ENSICAEN
 # 6 Boulevard Marechal Juin
 # F-14050 Caen Cedex
 #
 # This file is owned by ENSICAEN students.
 # No portion of this document may be reproduced, copied
 # or revised without written permission of the authors.
##

##
 # @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 # @version 1.1.0
 # @date 5 october 2022
##

##
 #@description allow the user to exec every bash's scripts
##

echo "execute : ""$0";

printf "This is a WorkSpace creator for C/C++ structur,\n    > enter the path to the working folder (do not end with '/'), default directory will be './'\n    /!\ the directory must be further for now /!\\n >> " 
read -r workspace;

if [ -d "$workspace"  ]; then
    echo "  >> Err : Invalid WorkSpace name, already exists [ending Program] <<";
    exit 1;
fi

printf "Enter the language wanted : (C / Cpp)\n    > synthax does not matter\n >> ";
read -r language;

if [ "${language^^}" != "C" ] && [ "${language^^}" != "CPP" ]; then
    echo "  >> Err : Invalid Language name, not C or Cpp : $language [ending Program] <<";
    exit 1;
fi

for script in $(find . -path "*.sh")
do
    chmod u+x "$script"
done

script=$(find . -path "*updateConfig*.sh";)
./"$script" "$workspace" "${language,,}";
if [ $? == 1 ]; then
    exit 1;
fi

script=$(find . -path "*createWorkspace*.sh";)
./"$script" "$workspace";
if [ $? == 1 ]; then
    exit 1;
fi

script=$(find . -path "*createMakefile*.sh";)
./"$script" "$workspace";
if [ $? == 1 ]; then
    exit 1;
fi

script=$(find . -path "*createFiles.sh";)
./"$script" "main";
if [ $? == 1 ]; then
    exit 1;
fi