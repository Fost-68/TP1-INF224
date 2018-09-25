#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

#include "multimedia.h"

multimedia::multimedia()
{

}

multimedia::multimedia(string _name, string _path)
{
  name = _name;
  path = _path;
}
