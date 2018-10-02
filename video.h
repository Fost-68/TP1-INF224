#ifndef VIDEO_H
#define VIDEO_H

#include <cstring>
#include <iostream>
#include <string>
using namespace std;

class video : public multimedia{
private:
  int duree;

public:
  video() : duree(0) {}
  video(string n, string p, int d) : multimedia(n,p), duree(d) {}

  const int getLength() {return duree;}
  void setLength(int _duree) {duree = _duree;}

  virtual const void printMedia(ostream& output){output << "name : " << getObjName() <<'\n'
    <<"path :" << getObjPath() <<'\n'
    << "type : Video\n"
    << "duree :" << getLength() <<'\n'
    << "---------------------------"
    <<endl;}

  const void playMedia() {system(("mpv" +getObjPath() +"&").c_str());}
};

#endif
