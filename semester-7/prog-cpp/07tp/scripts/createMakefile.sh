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
 #@description create makefile
##

echo "execute : ""$0";

config=$(find . -path "*.config");
workspace=$(sed -n '1p' "$config");
language=$(sed -n '2p' "$config");
directory=$(find . -path "*makefileTemplate.$language.txt")

cat "$directory">"$workspace"/Makefile