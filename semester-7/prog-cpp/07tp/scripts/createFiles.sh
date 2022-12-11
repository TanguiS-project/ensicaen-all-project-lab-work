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
 # @version 1.0.0
 # @date 7 october 2022
##

##
 #@description create file 
##

echo "execute : ""$0";

config=$(find . -path "*.config");
language=$(sed -n '2p' "$config");
workspaceSrc=$(find . -name "src" -type d -print);
workspaceInc=$(find . -name "include" -type d -print);
fileName=$1
if [ "$fileName" == "" ]; then 
    echo "ERRO($fileName) : invalid name, retry and put a name in args : $ createFiles.sh name";
fi

findFileName=$(find . -path "*$fileName.$language*");
header=$(find . -path "*yourHeader*");

if [ -e "$findFileName" ]; then
echo "ERROR($0) : file $fileName already exits, can not overwrite existing. or it does not exist"
echo "  -> Please enter a valide name, or delete the file : $fileName and retry."
exit
fi
if [ "$fileName" == "main" ]; then
echo "$workspaceSrc"/main."$language"
touch "$workspaceSrc"/main."$language"
cat "$header" > "$workspaceSrc"/main."$language"
{
    echo "";
    echo "";
    echo "int main( int argc, char** argv ) {";
    echo "    ";
    echo "    return 1;";
    echo "}";
} >>"$workspaceSrc"/main."$language"
script=$(find . -path "*updateHeader*.sh";)
./"$script" "$fileName" "$language";
else
cat "$header">>"$workspaceSrc"/"$fileName"."$language"
cat "$header">>"$workspaceInc"/"$fileName".h
script=$(find . -path "*updateHeader*.sh";)
./"$script" "$fileName" "$language";
./"$script" "$fileName" h;
script=$(find . -path "*updateIncludeFiles*.sh";)
./"$script" "$fileName";
script=$(find . -path "*updateSrcFiles*.sh";)
./"$script" "$fileName";
fi

script=$(find . -path "*updateMakefile*.sh";)
./"$script" "$fileName";
