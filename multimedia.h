#ifndef MULTIMEDIA_H
#define MULTIMEDIA_H

#include <string>
using namespace std;


class multimedia
{
private:
  string name;
  string path;

public:
    multimedia();
    multimedia(string _name, string _path);

    ~multimedia() {};

    const string getObjName() {return name;}
    void setObjName(string _name) {name = _name;}

    const string getObjPath() {return path;}
    void setObjPath(string _path) {path = _path;}

    const void printMedia(ostream& output) { output << "name: " << name << '\n' << "path: " << path <<endl;}
};

#endif // MULTIMEDIA_H
