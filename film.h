#ifndef FILM_H
#define FILM_H

#include <cstring>
#include <iostream>
#include <string>
using namespace std;

/**
 * \file      film.h
 * \author    WILME
 * \date      7 Octobre 2018
 * \brief     Header declarant et implementant l'objet film
 *
 * \details  Ce fichier header contient les declarations et les implementations
 *           des attributs et des fonction de l'objet film
 */

/**
*  \class film
*  \extends video
*  \brief Classe representant un film
*
*  La classe film permet de representer une video stocke quelque part dans le
*  disque dur. Elle herite de l'objet video, ce qui permet de la representer
*  par son nom, son chemin absolu et relatif et par sa duree
*
*  En plus de ces trois attributs, une video est egalement representee par son
*  nombre de chapitres et par la durée de chacun de ses chapitres
*/
class film : public video{
private:
  int * tab_durees; /*!< Le tableau des différentes durées. */
  int n_chapters; /*!< Le nombre de chapitre du film */

  /**
  *
  * \brief \b Setter du nombre de chapitre dans le film
  * \param _n_chapters Le nouveau nombre de chapitres dans le film
  *
  */
  void setChapters(int _n_chapters) {n_chapters = _n_chapters;}

  /**
  * \brief \b Setter du tableau des durées de chaque chapitre
  *
  * Afin de respecter le principe d'encapsulation des données, nous ne pouvons
  * pas nous permettre de stocker directement le tableau qui est donné en argument,
  * il nous faut faire une copie profonde de ce tableau afin qu'il ne puisse pas
  * être modifié de l'extérieur.
  *
  * Le pointeur ainsi affecté à l'attribut sera donc un autre pointeur vers le
  * tableau constant de l'objet film
  *
  * \param _tab_durees le nouveau tableau des durees
  */
  void setLength(int * _tab_durees){
    if(tab_durees != NULL){
      free(tab_durees);
      tab_durees = NULL;
    }

    tab_durees = (int*)malloc(sizeof(int) * n_chapters);
    if(tab_durees = NULL){
      exit(-1);
    }

    for(int i = 0; i < n_chapters; i++){
      tab_durees[i] = _tab_durees[i];
    }
  }


public:

  /**
  * \brief \b Constructeur vide d'un film
  *
  * Constructeur vide d'un film : appelle le constructeur de la classe mère puis
  * met tous les attributs vers une valeur nulle (pointeur vers NULL et 0 pour
  * l'entier.
  *
  */
  film() : tab_durees(NULL), n_chapters(0) {}


  /**
  * \brief \b Constructeur complet d'une video
  *
  * Constructeur complet d'une video permettant de personnaliser tous ses attributs
  * a la creation
  *
  * \param _name Le nom de l'objet video
  * \param _path Le chemin relatif ou absolu vers la video
  * \param _duree La duree de la video
  * \param _t Pointeur vers le tableau des durees des chapitres
  * \param _nc Le nombre de chapitre
  */
  film(string _name, string _path, int _duree, int * _t, int _nc){
    video(_name,_path,_duree);
    setChapters(_t, _nc);
  }

  ~film(){
    free(tab_durees);
    tab_duree = NULL;
  }

  /**
  * \brief \b Getter du pointeur vers le tableau de la durée des chapitres
  * \return Un \e const \e int \e * pointant vers le 1er élément du tableau
  */
  const int * getLength() const {return tab_durees;}

  /**
  * \brief \b Getter du nombre de chapitre dans le film
  * \return Un \e int comprenant le nombre de chapitres dans le film
  *
  */
  int getChapters() const {return n_chapters;}


  /**
  * \brief Setters du tableau des durées et du nombre de chapitres
  *
  * Pour la cohérence, nous ne mettons pas en place un setter par attribut, mais
  * un setter pour deux attributs pour faciliter la recopie de l'argument _tab_durees
  *
  * \param _tab_durees Le nouveau tableau des durees des chapitres
  * \param _nb_chapter Le nouveau nombre de chapitre dans le film
  */
  void setChapters(int * _tab_durees, int _nb_chapter){
      setChapters(_nb_chapter);
      setLength(_tab_durees);
  }

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
