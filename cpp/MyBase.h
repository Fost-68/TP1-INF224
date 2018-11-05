#include <memory>
#include <string>
#include <iostream>
#include <sstream>
#include <algorithm>

#include "multiTable.h"
#include "tcpserver.h"
#include "cppsocket.h"

using namespace std;
using namespace cppu;

class MyBase {

private:
  multiTable * multi;

public:
  MyBase(multiTable * _multi){
    multi = _multi;
  }

  /* Cette méthode est appelée chaque fois qu'il y a une requête à traiter.
   * Ca doit etre une methode de la classe qui gere les données, afin qu'elle
   * puisse y accéder.
   *
   * Arguments:
   * - 'request' contient la requête
   * - 'response' sert à indiquer la réponse qui sera renvoyée au client
   * - si la fonction renvoie false la connexion est close.
   *
   * Cette fonction peut etre appelée en parallele par plusieurs threads (il y a
   * un thread par client).
   *
   * Pour eviter les problemes de concurrence on peut créer un verrou en creant
   * une variable Lock **dans la pile** qui doit etre en mode WRITE (2e argument = true)
   * si la fonction modifie les donnees.
   */
  bool processRequest(TCPConnection& cnx, const string& request, string& response)
  {
    cerr << "\nRequest: '" << request << "'" << endl;

    // 1) pour decouper la requête:
    // on peut par exemple utiliser stringstream et getline()
    istringstream iss (request);

    string subs;
    string subs2;
    iss >> subs;

    if(!iss){
      response = "ERREUR : Pas d'argument sur la requête";
    } else if (subs == "fetch") {
      fetchMultimedias(response);
    }

    else{
        iss >> subs2;

        if(subs == "play")
          playRequest(subs2, response);

        else if(subs == "print")
          printRequest(subs2, response);

        else
          response = "ERREUR : Requête non reconnue";
    }

    // 2) faire le traitement:
    // - si le traitement modifie les donnees inclure: TCPLock lock(cnx, true);
    // - sinon juste: TCPLock lock(cnx);


    // 3) retourner la reponse au client:
    // - pour l'instant ca retourne juste OK suivi de la requête
    // - pour retourner quelque chose de plus utile on peut appeler la methode print()
    //   des objets ou des groupes en lui passant en argument un stringstream
    // - attention, la requête NE DOIT PAS contenir les caractères \n ou \r car
    //   ils servent à délimiter les messages entre le serveur et le client

    //AVANT d'ENVOYER, NE PAS OUBLIER DE REMPLACER LES \n PAR DES |
    replace(response.begin(), response.end(), '\n', '|');
    cerr << "response: " << response << endl;

    // renvoyer false si on veut clore la connexion avec le client
    return true;
  }

  void playRequest(string name, string& response){
    ostringstream oss;
    multi->play(name, oss);
    response = oss.str();
  }

  void printRequest(string name, string& response){
    ostringstream oss;
    multi->search(name, oss);
    response = oss.str();
  }

  void fetchMultimedias(string& response){
    response = multi->fetchMultimedias();
  }
};
