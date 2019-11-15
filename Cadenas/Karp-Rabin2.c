#include <stdio.h>
#include <string.h>


#define tam 256


void buscar (char patron[], char texto[], int q)
{
  int M = strlen (patron);
  int N = strlen (texto);
  int i, j;
  int p = 0;
  int t = 0;
  int h = 1;

  for (i = 0; i < M - 1; i++)
    h = (h * tam) % q;

  //printf("Valor de hash: %d \n", h);

  //Encuentra los valores de p y t, que son del patron y el texto respectivamente
  for (i = 0; i < M; i++)
    {

      p = (tam * p + patron[i]) % q;
      t = (tam * t + texto[i]) % q;

      printf ("Valor p: %d \n", p);
      printf ("Valor t: %d \n", t);

    }

//Recorre la cadena en busca del texto por medio de comparaciones
  for (i = 0; i <= N - M;)
    {

      //Revisa si los valores hash de p y t son iguales
      if (p == t)
{

 //Recorre el patron
 for (j = 0; j < M; j++)
   {
     //Compara posiciones
     if (texto[i + j] != patron[j])
break;
   }
 //Si son iguales los caracteres desde j = 0 hasta la longitud del patron
 //se imprime un mensaje avisando la posicion en la que empieza el patron
 //en la cadena
 if (j == M)
   printf ("Patron encontrado en la posicion: %d \n", i);
   
   i = i+M;
}

      // Se vuelve a calcular el valor hash de t para comparar el siguiente
      //conjunto de caracteres, esto si i sigue siendo menor a N - M.
      if (i < N - M)
{
 t = (tam * (t - texto[i] * h) + texto[i + M]) % q;
 

 if (t < 0)
   t = (t + q);
       
        //printf("Valor t: %d \n", t);

}
    }
    i++;
}

int main ()
{
  char texto[] = "aabcaaabmaaas";
  char patron[] = "aa";
  int q = 29;
  buscar (patron, texto, q);
  return 0;
}