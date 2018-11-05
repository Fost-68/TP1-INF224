#include <iostream>
#include <string>
#include <memory>

#include "multiTable.h"
#include "tcpserver.h"
#include "MyBase.h"

using namespace std;
using namespace cppu;

const int PORT = 3331;

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

  shared_ptr<TCPServer> server(new TCPServer());
  shared_ptr<MyBase> base(new MyBase(multi));
  server->setCallback(*base, &MyBase::processRequest);

  cout << "Starting Server on port " << PORT << endl;
  int status = server->run(PORT);

  if (status < 0) {
    cerr << "Could not start Server on port " << PORT << endl;
    return 1;
  }

  return 0;

  exit(0);
}
