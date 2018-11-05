#ifndef MULTITABLE_H
#define MULTITABLE_H

#include <iostream>
#include <string>
#include <memory>
#include <map>

#include "groupe.h"
#include "multimedia.h"
#include "video.h"
#include "photo.h"
#include "film.h"

using namespace std;

typedef shared_ptr<groupe> groupPtr;
typedef shared_ptr<multimedia> multiPtr;


typedef map<string, multiPtr> multiDict;
typedef map<string, groupPtr> groupDict;


/**
 * \file      multiTable.h
 * \author    WILME
 * \date      11 Octobre 2018
 * \brief     Header declarant l'objet multiTable
 *
 * \details  Ce fichier header contient les declarations des attributs et des
 *           fonctions de l'objet multiTable
 */

 /**
 *  \class groupe
 *  \extends list<>
 *  \brief Classe representant une liste de multimedia
 *
 *  La classe groupe nous permet de representer une liste de shared_ptr d'objet derivant de
 *  l'objet de base multimedia. Cette liste utilise le template list pour
 *  faciliter l'acces a certaines fonctions deja implementees dans le template
 */
class multiTable{

private:
  multiDict muDict;
  groupDict grDict;

  void addMulti(string name, multiPtr ptr){
    muDict[name] = ptr;
  }

  void addGroup(string name, groupPtr ptr){
    grDict[name] = ptr;
  }

public:

  multiTable(){
    return;
  }

  void createVideo(string name, string path, int duree){
    addMulti(name, multiPtr(new video(name, path, duree)));
  }

  void createFilm(string name, string path, int duree, int * t, int nc){
    addMulti(name, multiPtr(new film(name, path, duree, t, nc)));
  }

  void createPhoto(string name, string path, int latitude, int longitude){
    addMulti(name, multiPtr(new photo(name, path, latitude, longitude)));
  }

  void createGroup(string name){
    addGroup(name, groupPtr(new groupe(name)));
  }

  bool searchMulti(string name, ostream& output){
    multiDict::iterator it = muDict.find(name);

    if(it == muDict.end()){
      output << "Media '" << name << "' Not Found $";
      return false;
    }

    else{
      muDict[name]->printMedia(output);
      return true;
    }

  }

  bool searchGroup(string name, ostream& output){
    groupDict:: iterator it = grDict.find(name);

    if(it == grDict.end()){
      output << "Group '" << name << "' Not Found $";
      return false;
    }

    else{
      grDict[name]->printGroup(output);
      return true;
    }
  }

  void search(string name, ostream& output){
    if(!(searchMulti(name, output)))
      searchGroup(name, output);
  }

  void play(const string name, ostream& output){
    multiDict::iterator it = muDict.find(name);

    if(it == muDict.end()){
      output << "Media '" << name <<"' Not found $";
    }

    else{
      muDict[name]->playMedia();
      output << "Playing Media " << name << "$";
    }
  }
};



#endif
