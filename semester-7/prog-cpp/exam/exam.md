# Exam entrainement

## Question cours

1.0. f(a) si a est une référence impossible de savoir la différence.

1.1. Il n'est pas possible d'initialiser une référence à partir d'un objet temporaire, sauf si celle-ci est précisée ``` const ```.

1.2. ```delete``` prend en charge le pointeur ```nullptr```. De plus, surcharge possible de ```delete```.

1.3. Les conteneurs contigue en mémoire sont équipé de ```rezize()``` donc pas de problème de ```segfault```.

1.4. Non - Non - OUI.

1.5. Surtout par passage par valeur dans les fonctions.

1.6. Utilisation du mot clé ```explicit``` pour le constructeur fait l'inversion de ce qui est demandé. Un appel implit au constructeur est fait par default : ```Complex::Complex(double)```.

1.6. Pour rendre l'opération inverse possible, il suffit d'utilsier un cast de type ```static_cast```.

1.7. Surcharge de l'opérateur ```+```. Voici comment il faut faire : 

```cpp

#include <Vector.h>
#include <Point.h>

Point Point::operator+( const Vector & ) const; /* method */

friend Point operator+( const Point&, const Vector & ) const; /* function */

```

## Exercice : Minimum d'une sequence

```cpp
main.cpp
```

```cpp main.cpp
#include <iostream>
#include <min.h>
int main () {
    float tableau [5] = { 100.0 , 4.0 , 3.0 , 5.0 , 30.0 };
    std::vector<float>v( 5 );
    std::copy( tableau, tableau +5, v.begin() );
    std::cout << min( v.begin (), v.end() ) << std::endl;
    std::cout << min( tableau, tableau + 5 ) << std::endl;
}
```

```cpp
min.h
```

```cpp
#include <iterator>

template<typename Iterator>
typename iterator_traits<Iterator>::value_type minIterable( Iterator begin, Iterator end ) {
    if ( begin == end ) {
        throw "Sequence is empty";
    }
    typename iterator_traits<Iterator>::value_type min = *begin;
    for ( ; begin != end; ++begin ) {
        if ( min > *begin ) {
            min = *begin;
        }
    }
    return min;
}
```

## Problème : suite et série

```cpp
main.cpp
```

```cpp
#include "Sequence.h"
#include <iostream>

void display( const Sequence& s, unsigned int n );

int main () {
    ArithmeticSequence as( 1.0, 2.0 );      //u0 = 1.0, r = 2.0
    Series series( &as );
    display( as, 5 );                       //1  3  5  7  9
    display( series, 5 );                   //1  4  9  16  25  
    std::cout << series(4) << std::endl;    //25
}
```

```cpp
Sequence.h
```

```cpp
class Sequence {
    public:
        virtual double operator()( unsigned int n ) = 0 const;
};

class Series : public Sequence {
    private:
        Sequence* _seq;
    public:
        Series ( Sequence* s ) : _seq(s) { };
        double operator()( unsigned int n ) const override {
            double sum = .0;
            for ( int i = 0; i < n;i++ ) {
                sum += (*seq)(i);
            }
            return sum;
        };
        ~Series ();
};

class ArithmeticSequence : public Sequence {
    private:
        const double _u0;
        const double _r;
    public:
        ArithmeticSequence( const double u0, const double r ) : _u0(u0), _r(r) { };
        double operator()( unsigned int n ) const override;
        ~ArithmeticSequence();
};

class GeometricSequence : public Sequence {
    private:
        const double _u0;
        const double _r;
    public:
        GeometricSequence( const double u0, const double r ) : _u0(u0), _r(r) { };
        double operator()( unsigned int n ) const override;
        ~GeometricSequence();
};

```
