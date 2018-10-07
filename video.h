#ifndef VIDEO_H
#define VIDEO_H

#include <cstring>
#include <iostream>
#include <string>
using namespace std;

/**
 * \file      video.h
 * \author    WILME
 * \date      2 Octobre 2018
 * \brief     Header declarant et implementant l'objet video
 *
 * \details  Ce fichier header contient les declarations et les implementations
 *           des attributs et des fonction de l'objet video
 */

/**
*  \class video
*  \extends multimedia
*  \brief Classe representant une video quelconque
*
*  La classe video permet de representer une video stocke quelque part dans le
*  disque dur. Elle herite de l'objet multimedia, ce qui permet de la representer
*  par son nom et par son chemin absolu ou relatif.
*
*  En plus de ces deux attributs, une video est egalement represente par sa duree.
*/
class video : public multimedia{

private:
  int duree; /*!< La duree de la video */

public:

  /**
  * \brief \b Constructeur vide de video
  *
  * Constructeur vide d'une video : appelle le constructeur de la classe mère puis
  * met la duree de la video à 0.
  *
  */
  video() : duree(0) {}

  /**
  * \brief \b Constructeur complet d'une video
  *
  * Constructeur complet d'une video permettant de personnaliser tous ses attributs
  * a la creation.
  *
  * \param _name Le nom de l'objet video
  * \param _path Le chemin relatif ou absolu vers la video
  * \parma _duree La duree de la video
  */
  video(string _name, string _path, int _duree) : multimedia(_name, _path), duree(_duree) {}

  /**
  * \brief \b Getter de la duree d'une video
  * \return Un \e int contenant la duree de la video en secondes
  *
  */
  int getLength() const {return duree;}

  /**
  * \brief \b Setter de la duree d'une video
  * \param _duree La nouvelle duree de la video
  *
  */
  void setLength(int _duree) {duree = _duree;}

  //TODO
  /**
  *
  *Question pour le prof, comment avoir une description pour une fonction qui
  *sera défini un peu partout
  */
  virtual const void printMedia(ostream& output){output << "name : " << getObjName() <<'\n'
    <<"path :" << getObjPath() <<'\n'
    << "type : Video\n"
    << "duree :" << getLength() <<'\n'
    << "---------------------------"
    <<endl;}

  /**
  *
  *Question pour le prof, comment avoir une description pour une fonction qui
  *sera défini un peu partout
  */
  const void playMedia() {system(("mpv " +getObjPath() +"&").c_str());}
};

#endif
