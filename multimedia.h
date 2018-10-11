#ifndef MULTIMEDIA_H
#define MULTIMEDIA_H

#include <iostream>
#include <cstring>
#include <string>
using namespace std;

/**
 * \file      multimedia.h
 * \author    WILME
 * \date      2 Octobre 2018
 * \brief     Header contenant la déclaration et l'implémentation de l'objet
 *            multimedia
 */

 /**
 *
 * \class   multimedia
 * \brief   Classe abstraite représentant un objet multimedia.
 *
 * La classe multimedia permet de representer dans un programme C++ un objet
 * multimedia tel qu'une video ou une photo enregistre quelque part sur le disque
 * dur
 *
 * Nous considérons que le minimum pour représenter un objet multimedia est de
 * connaitre son nom et son chemin absolu ou relatif.
 *
 */
class multimedia
{
protected:

  string name; /*!< Le nom du fichier multimedia */
  string path; /*!< Le chemin absolue vers le fichier multimedia */

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
    multimedia(string _name, string _path) : name(_name), path(_path) {}

    /**
    * \brief       Destructeur de multimedia
    */
    virtual ~multimedia() {};


    /**
     * \brief      Getter du nom du fichier multimedia
     * \return     Un \e string contenant le nom du fichier multimedia
     */
    string getObjName() const {return name;}

    /**
     * \brief      Getter du chemin absolu vers le multimedia
     * \return     Un \e string contenant le chemin absolu vers le multimedia
     */
    string getObjPath() const {return path;}

    /**
    *  \brief     Setter du nom de l'objet multimedia
    *  \param _name Le nouveau nom de l'objet multimedia
    *
    */
    void setObjName(string _name) {name = _name;}

    /**
    *  \brief     Setter du chemin vers l'objet multimedia
    *  \param _path Le nouveau chemin vers l'objet multimedia
    *
    */
    void setObjPath(string _path) {path = _path;}

    /**
     * \brief        Permet d'afficher les informations de l'objet multimedia
     * \param output L'endroit où seront affichées ces informations
     */
    virtual void printMedia(ostream& output) const = 0;

    /**
     * \brief       Lis le media avec le programme par défaut de l'OS
    */
    /**
    *
    *Question pour le prof, comment avoir une description pour une fonction qui
    *sera défini un peu partout
    */
    void playMedia() const {system(("mpv " +getObjPath() +"&").c_str());}
};

#endif
