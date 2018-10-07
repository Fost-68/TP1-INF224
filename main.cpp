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
int main(int argc, const char* argv[])
{
  int tab_size = 3;
  multimedia ** multi_tab = (multimedia**)malloc(tab_size*sizeof(multimedia*));

  multi_tab[0] = new photo("photo1", "multi/photo1.jpeg", 100, 100);
  multi_tab[1] = new video("video1", "multi/video1.mp4", 100);
  multi_tab[2] = new photo("photo2", "multi/photo2.jpeg", 100, 100);

  for(int i = 0; i < tab_size; i++){
    multi_tab[i]->printMedia(cout);
    multi_tab[i]->playMedia();
    delete(multi_tab[i]);
  }

  free(multi_tab);
  multi_tab = NULL;

  exit(0);
}
