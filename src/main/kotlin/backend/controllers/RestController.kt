package backend.controllers

import backend.models.Nomenclatures
import backend.repositories.NomenclaturesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.awt.PageAttributes

@RestController
@RequestMapping("/api")
class RestController {
    @Autowired
    lateinit var nomenclaturesRepository: NomenclaturesRepository

    @RequestMapping(value = ["/test"], method = [RequestMethod.GET])
    fun testConnect(): String{
        return "Test has been successfully!"
    }

    @GetMapping(
        path = ["/nomenclatures"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getAllNomenclatures(): List<Nomenclatures>{
        return nomenclaturesRepository.findAll()
    }

//    @GetMapping(
//        path = ["/passwords"],
//        produces = [MediaType.APPLICATION_JSON_VALUE]
//    )
//    @ResponseBody
//    fun findPasswordByHash(@RequestParam valueHash: String): List<PassAndHashSHA1>{
//        return passAndHashRepositorySHA1.findPasswordByHash(valueHash)
//    }
}