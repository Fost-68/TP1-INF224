#include "main.h"

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
  groupe * testGroup = new groupe("test_group");
  printf("%s\n\n\n", (testGroup->getName()).c_str());

  testGroup->push_back(new photo("photo1", "multi/photo1.jpeg", 100, 100));
  testGroup->push_back(new video("video1", "multi/video1.mp4", 100));
  testGroup->push_back(new photo("photo2", "multi/photo2.jpeg", 100, 100));

  testGroup->printGroup(cout);

  delete(testGroup);

  exit(0);
}
