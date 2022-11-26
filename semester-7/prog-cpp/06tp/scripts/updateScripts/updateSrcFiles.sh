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
 #@description Update the Src file according to the name given in argument 
##

echo "execute : ""$0";

fileName="$1";
config=$(find . -path "*.config");
language=$(sed -n '2p' "$config");
fileDirectory=$(find . -path "*$fileName.$language");

{ 
    echo "#include \"$fileName.h\""; 
} >> "$fileDirectory";