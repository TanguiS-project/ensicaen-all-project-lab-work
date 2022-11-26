SRC_PATH = ./src
OBJ_PATH = ./obj
BIN_PATH = ./bin
INC_PATH = ./include
LIB_PATH = ./lib
EXEC = main

CXX = g++
CXXFLAGS = -Wall -Wextra -pedantic -std=c++11 -g
LDFLAGS = 
CPPFLAGS = -I$(INC_PATH) -L$(LIB_PATH)

all : $(BIN_PATH) $(OBJ_PATH) $(BIN_PATH)/$(EXEC)

OBJS =  $(OBJ_PATH)/main.o $(OBJ_PATH)/Board.o $(OBJ_PATH)/Thrower.o $(OBJ_PATH)/Obstacle.o $(OBJ_PATH)/Nail.o $(OBJ_PATH)/Counter.o

$(BIN_PATH)/$(EXEC) : $(OBJS)
	$(CXX) $(CXXFLAGS) $^ -o $@ $(LDFLAGS)


$(OBJ_PATH)/%.o : $(SRC_PATH)/%.cpp
	$(CXX) $(CXXFLAGS) $(CPPFLAGS) $< -o $@ -c 

$(OBJ_PATH) : 
	mkdir $@

$(BIN_PATH) :
	mkdir $@

run: all
	$(BIN_PATH)/$(EXEC)

valgrind: all
	valgrind --leak-check=full $(BIN_PATH)/$(EXEC)

zip : distclean
	rm -fr ./.vscode ./.git ./.gitignore
	cd ../ && cp -r ./04tp ./Picque_Steimetz
	cd ../Picque_Steimetz && find . -type f > ../Picque_Steimetz/files.txt
	cd ../ && zip -r ./Picque_Steimetz.zip ./Picque_Steimetz
	rm -r ../Picque_Steimetz

clean : 
	rm -fr $(OBJ_PATH)

distclean : clean
	rm -fr $(BIN_PATH)