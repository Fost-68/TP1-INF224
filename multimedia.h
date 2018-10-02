#ifndef MULTIMEDIA_H
#define MULTIMEDIA_H

#include <iostream>
#include <cstring>
#include <string>
using namespace std;

/**
 * \file      multimedia.h
 * \author    WILME
 * \version   1.0
 * \date      2 Octobre 2018
 * \brief     Objet representant un fichier multimdia
 *
 * \details    Cette objet represente un fichier multimedia quelconque enregistre
 *                  quelque part dans le disque
 */
class multimedia
{
protected:

  string name; /*! Le nom du fichier multimedia */
  string path; /*! Le chemin absolue vers le fichier multimedia */

public:
  /**
   * \brief         Constructeur blank pour un multimedia
   * \details       Constructeur mettant tous les attributs de l'objet à 0
   */
    multimedia() : name("0"), path("0") {}

    /**
     * \brief      Constructeur complet pour un multimedia
     * \details    Constructeur affectant les arguments aux attributs du multimedia
     * \param    _name        Le nom du multimedia
     * \param    _path        Le chemin absolue vers le multimedia
     */
    multimedia(string _name, string _path) : name(name), path(path) {}

    /**
    * \brief       Destructeur de multimedia
    */
    virtual ~multimedia() {};


    /**
     * \brief      Getter du nom du fichier multimedia
     * \return     Un \e contenant le nom du fichier multimedia
     */
    const string getObjName() {return name;}

    /**
     * \brief      Getter du chemin absolu vers le multimedia
     * \return     Un \e contenant le chemin absolu vers le multimedia  
     */
    const string getObjPath() {return path;}

    /**
     * \brief       Calcule la distance entre deux points
     * \details    La distance entre les \a point1 et \a point2 est calculée par l'intermédiaire
     *                  des coordonnées des points. (cf #Point)
     * \param    point1         Point 1 pour le calcul de distance.
     * \param    point2         Point 2 pour le calcul de distance.
     * \return    Un \e float représentant la distance calculée.
     */
    void setObjName(string _name) {name = _name;}

    /**
     * \brief       Calcule la distance entre deux points
     * \details    La distance entre les \a point1 et \a point2 est calculée par l'intermédiaire
     *                  des coordonnées des points. (cf #Point)
     * \param    point1         Point 1 pour le calcul de distance.
     * \param    point2         Point 2 pour le calcul de distance.
     * \return    Un \e float représentant la distance calculée.
     */
    void setObjPath(string _path) {path = _path;}

    /**
     * \brief       Calcule la distance entre deux points
     * \details    La distance entre les \a point1 et \a point2 est calculée par l'intermédiaire
     *                  des coordonnées des points. (cf #Point)
     * \param    point1         Point 1 pour le calcul de distance.
     * \param    point2         Point 2 pour le calcul de distance.
     * \return    Un \e float représentant la distance calculée.
     */
    virtual const void printMedia(ostream& output) = 0;

    /**
     * \brief       Calcule la distance entre deux points
     * \details    La distance entre les \a point1 et \a point2 est calculée par l'intermédiaire
     *                  des coordonnées des points. (cf #Point)
     * \param    point1         Point 1 pour le calcul de distance.
     * \param    point2         Point 2 pour le calcul de distance.
     * \return    Un \e float représentant la distance calculée.
     */
    virtual const void playMedia() = 0;
};

#endif
