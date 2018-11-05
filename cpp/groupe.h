#ifndef GROUPE_H
#define GROUPE_H

#include <iostream>
#include <string>
#include <memory>
#include <list>
#include "multimedia.h"
#include "multiTable.h"

using namespace std;
typedef std::shared_ptr<multimedia> multiPtr;


/**
 * \file      groupe.h
 * \author    WILME
 * \date      11 Octobre 2018
 * \brief     Header declarant l'objet groupe
 *
 * \details  Ce fichier header contient les declarations des attributs et des
 *           fonctions de l'objet groupe
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
class groupe : public list<multiPtr>
{

friend class multiTable;

private:
  string name; /*! Le nom du groupe */

  /**
  * \brief         Constructeur blank pour un groupe
  * \details       Constructeur donnant un nom vide au groupe et ne mettant aucun
  *                element dans la liste
  */
  groupe() {name = "";}

  /**
  * \brief         Constructeur semi-complet pour un groupe
  * \details       Constructeur donnant un nom personnalise au groupe, et ne donnant
  *                aucun multimedia a mettre de base dans la liste
  */
  groupe(string _name) {name = _name;}

public:


  /**
  * \brief       Destructeur de groupe
  */
  ~groupe() {}

  /**
   * \brief      Getter du nom du groupe
   * \return     Un \e string contenant le nom du groupe
   */
  string getName(void) const {return name;}

  /**
  *  \brief     Setter du nom du groupe
  *  \param _name Le nouveau nom du groupe
  *
  */
  void setName(string _name) {name = _name;}

  /**
  * \brief       Afficheur de tous les objets du groupe
  *
  * Appeler cette fonction va afficher dans la console les attributs de tous les
  * multimedias du groupe en faisant appel a la fonction \e printMedia()
  */
  void printGroup(ostream& output){
    for(iterator Iter = this->begin(); Iter != this->end(); Iter++){
      (*Iter)->printMedia(output);
    }
  }

};

#endif
