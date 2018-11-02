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
  groupe * testGroup = new groupe("test_group");
  groupe * testGroup2 = new groupe("test_group2");
  printf("%s\n\n\n", (testGroup->getName()).c_str());

  multiPtr m1 (new photo("photo1", "multi/photo1.jpeg", 100, 100));
  multiPtr m2 (new video("video1", "multi/video1.mp4", 100));
  multiPtr m3 (new photo("photo2", "multi/photo2.jpeg", 100, 100));

  testGroup->push_back(m1);
  testGroup->push_back(m2);
  testGroup->push_back(m3);

  testGroup2->push_back(m1);
  testGroup2->push_back(m3);

  m1.reset();
  m2.reset();
  m3.reset();

  testGroup->printGroup(cout);
  delete(testGroup);

  testGroup2->printGroup(cout);
  delete(testGroup2);

  exit(0);
}
