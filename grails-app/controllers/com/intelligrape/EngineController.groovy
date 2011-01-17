package com.intelligrape

class EngineController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [engineInstanceList: Engine.list(params), engineInstanceTotal: Engine.count()]
    }

    def create = {
        def engineInstance = new Engine()
        engineInstance.properties = params
        return [engineInstance: engineInstance]
    }

    def save = {
        def engineInstance = new Engine(params)
        if (engineInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'engine.label', default: 'Engine'), engineInstance.id])}"
            redirect(action: "show", id: engineInstance.id)
        }
        else {
            render(view: "create", model: [engineInstance: engineInstance])
        }
    }

    def show = {
        def engineInstance = Engine.get(params.id)
        if (!engineInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'engine.label', default: 'Engine'), params.id])}"
            redirect(action: "list")
        }
        else {
            [engineInstance: engineInstance]
        }
    }

    def edit = {
        def engineInstance = Engine.get(params.id)
        if (!engineInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'engine.label', default: 'Engine'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [engineInstance: engineInstance]
        }
    }

    def update = {
        def engineInstance = Engine.get(params.id)
        if (engineInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (engineInstance.version > version) {
                    
                    engineInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'engine.label', default: 'Engine')] as Object[], "Another user has updated this Engine while you were editing")
                    render(view: "edit", model: [engineInstance: engineInstance])
                    return
                }
            }
            engineInstance.properties = params
            if (!engineInstance.hasErrors() && engineInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'engine.label', default: 'Engine'), engineInstance.id])}"
                redirect(action: "show", id: engineInstance.id)
            }
            else {
                render(view: "edit", model: [engineInstance: engineInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'engine.label', default: 'Engine'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def engineInstance = Engine.get(params.id)
        if (engineInstance) {
            try {
                engineInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'engine.label', default: 'Engine'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'engine.label', default: 'Engine'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'engine.label', default: 'Engine'), params.id])}"
            redirect(action: "list")
        }
    }
}
