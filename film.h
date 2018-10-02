#ifndef FILM_H
#define FILM_H

#include <cstring>
#include <iostream>
#include <string>
using namespace std;

class film : public video{
private:
  int * tab_durees;
  int n_chapters;

public:

  film() : tab_durees() {}
  film(string n, string p, int d, int * t, int nc) : video(n,p,d), tab_durees(t), n_chapters(nc) {}

  const int * getLength() const {return tab_durees;}
  void setLength(int *  _tab_durees) {tab_durees = _tab_durees;}

  const int getChapters() {return n_chapters;}
  void setChapters(int _n_chapters) {n_chapters = _n_chapters;}

  const void printMedia(ostream& output){output << "name : " << getObjName() <<'\n'
    <<"path :" << getObjPath() <<'\n'
    << "type : Film\n"
    << "duree :" << getLength() <<'\n'
    << "---------------------------";

    for(int i = 0; i < getChapters(); i++){
      output << "Chapter " << (i+1) <<"Length : "
      << getLength()[i] <<"\n";
    }
    output << endl;}
};

#endif
