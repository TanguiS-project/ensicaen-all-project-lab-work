/*
 * ENSICAEN
 * 6 Boulevard Marechal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students.
 * No portion of this document may be reproduced, copied
 * or revised without written permission of the authors.
 */

/**
 * @file Set.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 08 November 2022
 */

#ifndef __SET_HH__
#define __SET_HH__

#include <ostream>

template <typename T>
class Set {
private:
    class Node {
        /* data */
        const T _value;
        Node * _next;
    public:
        Node( const T value, Node * next = nullptr );
        ~Node();
        T getValue() const;
        Node * getNext() const;
        void setNext(Node * next);
        static Set<T>::Node* removeFrom( Node* list, const T x ) {
            if ( list == nullptr ) {
                return list;
            }
            if ( list->getValue() == x ) {
                Node* tmp = list->getNext();
                list->setNext( nullptr );
                delete list;
                return tmp;
            }
            if ( list->getNext()->getValue() == x ) {
                Node* tmp = list->getNext();
                list->setNext( tmp->getNext() );
                tmp->setNext( nullptr );
                delete tmp;
                return list;
            }
            return removeFrom( list->getNext(), x );
        }
    };
    /* data */
    Node* _linkedList;
public:
    Set();
    Set( T& value );
    void clear();
    ~Set();
    bool isEmpty() const;
    std::ostream & flush( std::ostream& out ) const;
    bool contains( const T& value ) const;
    bool isSubsetOf( const Set<T>& other ) const;
    void insert( const T& value  );
    void remove( const T x );
    void insertInto( Set<T>& other ) const;
    void removeFrom(Set<T>& other ) const;
    Set( const Set<T>& other );
    Set& operator=( const Set<T>& other );

};

template <typename T>
Set<T>::Node::Node( const T value, Node * next ) : _value(value), _next(next) {  }

template <typename T>
Set<T>::Node::~Node() { delete _next; }

template <typename T>
T Set<T>::Node::getValue() const { return _value; }

template <typename T>
typename Set<T>::Node* Set<T>::Node::getNext() const { return _next; }

template <typename T>
void Set<T>::Node::setNext( Node* next ) {
    // @TODO    
    _next = next;
}






template <typename T>
Set<T>::Set() : _linkedList(nullptr) {  }

template <typename T>
Set<T>::Set( T& value ) {
    _linkedList = new Set<T>::Node( value );
}

template <typename T>
void Set<T>::clear() { delete _linkedList; }

template <typename T>
Set<T>::~Set() { delete _linkedList; }


template <typename T>
bool Set<T>::isEmpty() const { return _linkedList == nullptr; }

template <typename T>
std::ostream & Set<T>::flush( std::ostream& out ) const {
    if ( isEmpty() ) {
        out << "[]";
        return out;
    }
    Node* tmp = _linkedList;
    do {
        out << "[" << tmp->getValue() << "], ";
        tmp = tmp->getNext();
    } while ( tmp != nullptr );
    return out;
}

template <typename T>
bool Set<T>::contains( const T& value ) const {
    if ( isEmpty() ) {
        return false;
    }
    Node* tmp = _linkedList;
    do {
        if ( tmp->getValue() == value ) {
            return true;
        }
        tmp = tmp->getNext();
    } while ( tmp != nullptr );
    return false;
}

template <typename T>
bool Set<T>::isSubsetOf( const Set<T>& other ) const {
    if ( isEmpty() && other.isEmpty() ) {
        return false;
    }
    if ( isEmpty() && !other.isEmpty() ) {
        return false;
    }
    if ( other.isEmpty() ) {
        return false;
    }
    Node* tmp = _linkedList;
    while ( tmp != nullptr && other.contains(tmp->getValue()) ) {
        tmp = tmp->getNext();
    }
    return tmp == nullptr;
}

template <typename T>
void Set<T>::insert( const T& value  ) {
    if ( isEmpty() ) {
        _linkedList = new Node( value );
        return;
    }
    if ( contains( value ) ) {
        return;
    }
    _linkedList = new Node(value, _linkedList);

}

template <typename T>
void Set<T>::remove( const T x ) {
    _linkedList = _linkedList->removeFrom( _linkedList, x );
}

template <typename T>
void Set<T>::insertInto( Set<T>& other ) const {
    if ( isEmpty() ) {
        return;
    }
    if ( other.isEmpty() ) {
        //recopy
    }
    Node* tmp = _linkedList;
    do {
        other.insert(tmp->getValue());
        tmp = tmp->getNext();
    } while ( tmp != nullptr );
}

template <typename T>
void Set<T>::removeFrom(Set<T>& other ) const {
    if ( isEmpty() ) {
        return;
    }
    if ( other.isEmpty() ) {
        return;
    }
    Node* tmp = _linkedList;
    do {
        other.remove(tmp->getValue());
        tmp = tmp->getNext();
    } while ( tmp != nullptr );
}

template <typename T>
Set<T>::Set (const Set<T>& other) {
    Node* tmp = other._linkedList;
    _linkedList = new Node( tmp->getValue() );
    do {
        tmp = tmp->getNext();
        insert( tmp->getValue() );
    } while ( tmp != nullptr );
}


template <typename T>
Set<T>& Set<T>::operator=( const Set<T>& other ) {
    delete _linkedList;
    Node* tmp = other._linkedList;
    do {
        insert( tmp->getValue() );;
        tmp = tmp->getNext();
    } while ( tmp != nullptr );
    return *this;
}






template <typename T>
std::ostream & operator<<(std::ostream& out, const Set<T>& s) {
    s.flush( out );
    return out;
}

#endif /* __SET_HH__ */
