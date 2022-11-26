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
 # @date 11 october 2022
##

##
 #@description Update the header according to the name and extension given in argument 
##

echo "execute : ""$0";

fileName="$1";
ext=".""$2";
append="$fileName$ext";
fileDirectory=$(find . -path "*$append");

sed -i "s|^\( \* @file\).*$|& $append|g" "$fileDirectory"

date=$(LANG=en_GB date +"%d %B %Y");
sed -i "s|^\( \* @date\).*$|& $date|g" "$fileDirectory"