SRC_PATH = ./src
OBJ_PATH = ./obj
BIN_PATH = ./bin
INC_PATH = ./include
LIB_PATH = ./lib
EXEC_IT = iterator
EXEC_CAPACITY_SIZE = capacitysize
EXEC_SORT = sortpq
EXEC_TAB_ASSOC = tab_associatif
EXEC_ALGORITHME = algorithme
EXEC_BONUS = bonus

CXX = g++
CXXFLAGS = -Wall -Wextra -pedantic
LDFLAGS = 
CPPFLAGS = -I$(INC_PATH) -L$(LIB_PATH)

all : $(BIN_PATH) $(OBJ_PATH) $(BIN_PATH)/$(EXEC_IT) $(BIN_PATH)/$(EXEC_CAPACITY_SIZE) $(BIN_PATH)/$(EXEC_SORT)\
	  $(BIN_PATH)/$(EXEC_TAB_ASSOC) $(BIN_PATH)/$(EXEC_ALGORITHME) $(BIN_PATH)/$(EXEC_BONUS)

OBJS_IT = $(OBJ_PATH)/main_it.o $(OBJ_PATH)/it.o
OBJS_CAPACITY_SIZE = $(OBJ_PATH)/main_capacity_size.o $(OBJ_PATH)/capacity.o $(OBJ_PATH)/it.o
OBJS_SORT = $(OBJ_PATH)/main_sort.o $(OBJ_PATH)/sort.o $(OBJ_PATH)/it.o
OBJS_TAB_ASSOC = $(OBJ_PATH)/main_tab_associatif.o $(OBJ_PATH)/it.o
OBJS_ALGORITHME = $(OBJ_PATH)/main_algorithme.o $(OBJ_PATH)/it.o
OBJS_BONUS = $(OBJ_PATH)/main_bonus.o $(OBJ_PATH)/it.o

$(BIN_PATH)/$(EXEC_IT) : $(OBJS_IT)
	$(CXX) $(CXXFLAGS) $^ -o $@ $(LDFLAGS)

$(BIN_PATH)/$(EXEC_CAPACITY_SIZE) : $(OBJS_CAPACITY_SIZE)
	$(CXX) $(CXXFLAGS) $^ -o $@ $(LDFLAGS)

$(BIN_PATH)/$(EXEC_SORT) : $(OBJS_SORT)
	$(CXX) $(CXXFLAGS) $^ -o $@ $(LDFLAGS)

$(BIN_PATH)/$(EXEC_TAB_ASSOC) : $(OBJS_TAB_ASSOC)
	$(CXX) $(CXXFLAGS) $^ -o $@ $(LDFLAGS)

$(BIN_PATH)/$(EXEC_ALGORITHME) : $(OBJS_ALGORITHME)
	$(CXX) $(CXXFLAGS) $^ -o $@ $(LDFLAGS)

$(BIN_PATH)/$(EXEC_BONUS) : $(OBJS_BONUS)
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
