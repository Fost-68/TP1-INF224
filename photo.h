#ifndef PHOTO_H
#define PHOTO_H

#include <cstring>
#include <iostream>
#include <string>
using namespace std;

class photo : public multimedia{
private:
  int latitude;
  int longitude;

public:
  /**
  *Constructeurs
  */
  
  photo() : latitude(0), longitude(0) {}
  photo(string n, string p, int la, int lo) : multimedia(n,p), latitude(la), longitude(lo) {}

  /**
  *Getters et Setteurs de Latitude
  */
  const int getLatitude() {return latitude;}
  void setLatitude(int _latitude) {latitude = _latitude;}

  /**
  *Getters et Settes de Longitude
  */
  const int getLongitude() {return longitude;}
  void setLongitude(int _longitude) {longitude = _longitude;}

  const void printMedia(ostream& output){output << "name : " << getObjName() <<'\n'
    <<"path :" << getObjPath() <<'\n'
    << "type : Video\n"
    << "latitude :" << getLatitude() <<'\n'
    << "longitude :" << getLongitude() <<'\n'
    << "---------------------------"
    <<endl;
  }

  const void playMedia() {system(("mpv" +getObjPath() +"&").c_str());}
};

#endif
