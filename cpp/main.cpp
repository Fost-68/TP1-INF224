#include "main.h"
#include <memory>

typedef std::shared_ptr<multimedia> multiPtr;

/**
 * \file      main.cpp
 * \author    WILME
 * \version   1.0
 * \date      7 Octobre 2018
 * \brief     Source main du projet, point d'entrée du programme
 *
 * \details   Ce fichier source est le point d'entrée du programme et nous
 *            permet d'effectuer des tests au fur et à mesure que nous écrivons
 *            du code.
 */
int main()
{

  multiTable * multi = new multiTable();

  multi->createPhoto("photo1", "multi/photo1.jpeg", 100, 100);
  multi->createVideo("video1", "multi/video1.mp4", 100);
  multi->createPhoto("photo2", "multi/photo2.jpeg", 100, 100);

  multi->play("video1", cout);

  exit(0);
}
