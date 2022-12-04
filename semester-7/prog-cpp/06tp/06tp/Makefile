SRC_PATH = ./src
OBJ_PATH = ./obj
BIN_PATH = ./bin
INC_PATH = ./include
LIB_PATH = ./lib
EXEC = main

CXX = g++
CXXFLAGS = -Wall -Wextra -pedantic -g
LDFLAGS = 
CPPFLAGS = -I$(INC_PATH) -L$(LIB_PATH)

all : $(BIN_PATH) $(OBJ_PATH) $(BIN_PATH)/$(EXEC)

OBJS =  $(OBJ_PATH)/main.o $(OBJ_PATH)/it.o $(OBJ_PATH)/capacity.o $(OBJ_PATH)/sort.o

$(BIN_PATH)/$(EXEC) : $(OBJS)
	$(CXX) $(CXXFLAGS) $^ -o $@ $(LDFLAGS)


$(OBJ_PATH)/%.o : $(SRC_PATH)/%.cpp
	$(CXX) $(CXXFLAGS) $(CPPFLAGS) $< -o $@ -c 

$(OBJ_PATH) : 
	mkdir $@

$(BIN_PATH) :
	mkdir $@

run : 
	$(BIN_PATH)/$(EXEC)

zip : distclean
	rm -fr ./.vscode ./.git ./.gitignore
	cd ../ && cp -r ./06tp ./Picque_Steimetz
	cd ../Picque_Steimetz && find . -type f > ../Picque_Steimetz/files.txt
	cd ../ && zip -r ./Picque_Steimetz.zip ./Picque_Steimetz
	rm -r ../Picque_Steimetz

clean : 
	rm -fr $(OBJ_PATH)

distclean : clean
	rm -fr $(BIN_PATH)
