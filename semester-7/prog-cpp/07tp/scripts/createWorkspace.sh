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
 # @date 17 september 2022
##

echo "execute : ""$0";

config=$(find . -path "*.config");
workspace=$(sed -n '1p' "$config");
src=$workspace"/src"
include=$workspace"/include"

if [ ! -d "$workspace" ]; then
echo "Creating workspace folder";
mkdir "$workspace"
fi

if [ ! -d "$src" ]; then
echo "Creating src folder";
mkdir "$src";
fi
if [ ! -d "$include" ]; then
echo "Creating include folder";
mkdir "$include";
fi