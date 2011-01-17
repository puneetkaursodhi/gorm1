package domain_tests

import com.intelligrape.Song
import com.intelligrape.Album
import com.intelligrape.UtilController
import org.codehaus.groovy.grails.commons.GrailsApplication

class BootStrapService {

    static transactional = true

    def serviceMethod() {

    }

    void  bootStrap() {

            try {
                Album album = new Album(title: "Tara Ram Pam")
                println "inside bootstap method"
                Song song = new Song(title: "Hey sohna")
                album.addToSongs(song)
                album.save(flush: true)

                album = new Album(title: "Tees Maar Khan")
                song = new Song(title: "Sheela ki jawani")
                println song.title
                album.addToSongs(song)
                album.save(flush: true)

                 album = new Album(title: "Jal")
                song=new Song(title: "Aadat")
                println song.title
                album=album.addToSongs(song)
                album.addToSongs (new Song(title: 'Teri yaad'))
                album.save(flush:true)

            }
            catch (Throwable ex)
            {
                ex.printStackTrace()
            }


    }


}
