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
 # @date 12 october 2022
##

##
 #@description Update the config file to allow the other programs to properly works
##

workspace="$(pwd)""/"$1;
language=$2;

#if [ ! -d "$workspace"  ]; then
#    echo "  >> Err : Invalid WorkSpace name, does not exist or empty argument : $workspace [ending Program] <<";
#    exit 1;
#fi

#if [ "$language" == "" ]; then
#    echo "  >> Err : Invalid Language name, not C or Cpp or empty argument : $language [ending Program] <<";
#    exit 1;
#fi

{
   echo "$workspace";
   echo "$language";
} > "$(find . -path "*.config*")";