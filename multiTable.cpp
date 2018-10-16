#include "multiTable.h"

class multiTable{

private:
  Dict multiDict;
  Dict goupDict;

public:
  multiTable(){
    return;
  }

  void addMulti(string, multiPtr){
    multiDict[string] = multiPtr;
  }

  void addGroup(string, groupPtr){
    groupDict[string] = groupPtr;
  }

  void search(string, ostream& output){
    auto it = multiDict.find(string);

    if(it == multiDict.end()){
      output << "Multimedia not found";
      return;
    }

    it->printMedia();
  }

  void play(string, ostream& output){
    auto it = multiDict.find(string);

    if(it == multiDict.end()){
      output << "Multimedia not found";
      return;
    }

    it->playMedia();
  }

  void remove(string){

  }
};
