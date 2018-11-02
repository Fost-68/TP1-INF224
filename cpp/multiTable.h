#ifndef MULTITABLE_H
#define MULTITABLE_H

#include <iostream>
#include <string>
#include <memory>

#include "multimedia.h"
#include ""

using namespace std;
typedef std::shared_ptr<multimedia> multiPtr;
typedef std::shared_ptr<groupe> groupPtr;
typedef std::map<string, multiPtr> Dict;


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
  Dict multiDict;
  Dict goupDict;

public:
  void addMulti(string, multiPtr);
  void addGroup(string, groupPtr);

  void search(string);
  void play(string);

  void remove(string);
};

#endif
