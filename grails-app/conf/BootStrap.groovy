class BootStrap {

    def bootStrapService
    def init = { servletContext ->

        println "helloooooooooooooooooooo"
          bootStrapService.bootStrap()
    }

    def destroy = {
    }
}
