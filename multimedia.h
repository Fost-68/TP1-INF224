#ifndef MULTIMEDIA_H
#define MULTIMEDIA_H

#include <iostream>
#include <cstring>
#include <string>
using namespace std;


class multimedia
{
protected:
  string name;
  string path;

public:
    multimedia() : name("0"), path("0") {}
    multimedia(string _name, string _path) : name(name), path(path) {}

    virtual ~multimedia() {};

    const string getObjName() {return name;}
    const string getObjPath() {return path;}

    void setObjName(string _name) {name = _name;}
    void setObjPath(string _path) {path = _path;}

    virtual const void printMedia(ostream& output) = 0;
    virtual const void playMedia() = 0;
};

#endif
