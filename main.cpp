//
// main.cpp
// Created on 21/10/2018
//

#include <iostream>
#include <string>
using namespace std;

#include "multimedia.h"

int main(int argc, const char* argv[])
{
    multimedia * m = new multimedia("bonjour", "/media");
    m->printMedia(cout);
    delete m;
    return 0;
}
