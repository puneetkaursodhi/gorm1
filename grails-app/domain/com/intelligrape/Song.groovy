package com.intelligrape

class Song implements  Comparable{
    String title
    static belongsTo = [album:Album]
    Date dateCreated
    Date lastUpdated
    static constraints = {
        title(nullable: false)
    }
    int compareTo(Object o){
        this.title.compareTo(o.title)
    }
    String toString(){
        return title
    }
}
