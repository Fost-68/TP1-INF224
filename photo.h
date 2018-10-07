#ifndef PHOTO_H
#define PHOTO_H

#include <cstring>
#include <iostream>
#include <string>
using namespace std;

/**
 * \file      photo.h
 * \author    WILME
 * \date      7 Octobre 2018
 * \brief     Header declarant et implementant l'objet photo
 *
 * \details  Ce fichier header contient les declarations et les implementations
 *           des attributs et des fonction de l'objet photo
 */

/**
*  \class photo
*  \extends multimedia
*  \brief Classe representant une photographie
*
*  La classe film permet de representer une video stocke quelque part dans le
*  disque dur. Elle herite de l'objet video, ce qui permet de la representer
*  par son nom et son chemin absolu/relatif.
*
*  En plus de ces deux attributs, une image est décrite par une latitude et une
*  longitude.
*/
class photo : public multimedia{
private:
  int latitude; /*!< La latitude de l'image */
  int longitude; /*!< La longitude de l'image */

public:

  /**
  * \brief \b Constructeur vide de video
  *
  * Constructeur vide d'une video : appelle le constructeur vide de la classe mère puis
  * met la lontitude et la longitude de la photo à 0.
  *
  */
  photo() : latitude(0), longitude(0) {}

  /**
  * \brief \b Constructeur complet d'une photo
  *
  * Constructeur complet d'une photo permettant de personnaliser tous ses attributs
  * a la creation.
  *
  * \param _name Le nom de l'objet photo
  * \param _path Le chemin relatif ou absolu vers la photo
  * \param _la   La lattude de l'image
  * \param _lo   La longitude de l'image
  */
  photo(string _name, string _path, int _la, int _lo) : multimedia(_name, _path), latitude(_la), longitude(_lo) {}

  /**
  * \brief \b Getter de la latitude d'une photo
  * \return Un \e int contenant la latitude d'une photo
  */
  int getLatitude() const {return latitude;}

  /**
  * \brief \b Setter de la latitude d'une photo
  * \param _latitude La nouvelle latitude de la photo
  */
  void setLatitude(int _latitude) {latitude = _latitude;}

  /**
  * \brief \b Getter de la longitude d'une photo
  * \return Un \e int contenant la longitude d'une photo
  */
  int getLongitude() const {return longitude;}

  /**
  * \brief \b Setter de la longitude d'une photo
  * \param _longitude La nouvelle longitude de la photo
  */
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
