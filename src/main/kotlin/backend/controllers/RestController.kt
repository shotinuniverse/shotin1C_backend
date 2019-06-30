package backend.controllers

import backend.models.directories.Nomenclatures
import backend.models.directories.Users
import backend.models.reports.NomenclaturesRests
import backend.repositories.directories.NomenclaturesRepository
import backend.repositories.directories.UsersRepository
import backend.repositories.reports.NomenclaturesRestsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.sql.Date

@RestController
@RequestMapping("/api")
class RestController {
    //region declaration_repositories
    //region directories
    @Autowired
    lateinit var nomenclaturesRepository: NomenclaturesRepository
    @Autowired
    lateinit var usersRepository: UsersRepository
    //endregion

    //region reports
    @Autowired
    lateinit var nomenclaturesRestsRepository: NomenclaturesRestsRepository
    //endregion
    //endregion

    //region api_requests
    //region test
    @RequestMapping(value = ["/test"], method = [RequestMethod.GET])
    fun testConnect(): String{
        return "Test has been successfully!"
    }
    //endregion

    //region directories
    //region users
    @GetMapping(
        path = ["/users"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getAllUsers(): List<Users>{
        return usersRepository.findAll()
    }

    @GetMapping(
        path = ["/userbyid"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun findInformById(@RequestParam roleid: Int): List<Users>{
        return usersRepository.findInformById(roleid)
    }

    @GetMapping(
        path = ["/userbyname"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun findInformByName(@RequestParam name: String): List<Users>{
        return usersRepository.findInformByName(name.toCharArray())
    }
    //endregion

    //region nomenclatures
    @GetMapping(
        path = ["/nomenclatures"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getAllNomenclatures(): List<Nomenclatures>{
        return nomenclaturesRepository.findAll()
    }
    //endregion
    //endregion

    //region reports
    //region report_statement_of_nomenclatures_rests
    @GetMapping(
        path = ["/nomenclaturesrests"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getNomenclaturesRests(): List<NomenclaturesRests>{
        return nomenclaturesRestsRepository.getNomenclaturesRests()
    }
    @GetMapping(
        path = ["/nomenclaturesrestsondate"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getNomenclaturesRestsOnDate(@RequestParam date: String): List<NomenclaturesRests>{
        return nomenclaturesRestsRepository.getNomenclaturesRestsOnDate(date)
    }
    //endregion
    //endregion
    //endregion
}