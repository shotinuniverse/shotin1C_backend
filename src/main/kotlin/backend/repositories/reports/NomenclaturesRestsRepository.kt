package backend.repositories.reports

import backend.models.reports.NomenclaturesRests
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.scheduling.annotation.Async
import java.sql.Date

interface NomenclaturesRestsRepository: JpaRepository<NomenclaturesRests, Long> {
    @Async
    @Query(
        value = "/* NOMENCLATURES RESTS */\n" +
                "select\n" +
                "\tnomenclature.codenomencl as _code,\n" +
                "\tnomenclature.articul as _article,\n" +
                "\tnomenclature.descrnomencl as _nomenclature,\n" +
                "\tnomenclature.unitnomencl as _unit,\n" +
                "\tspecifications.descrspecif as _specification,\n" +
                "\tSUM(case\n" +
                "\t\twhen restsofnomenclatures._recordkind = 0\n" +
                "\t\t\tthen restsofnomenclatures._fld38245 \n" +
                "\t\telse restsofnomenclatures._fld38245 * (-1)\n" +
                "\tend) as _currentrests\n" +
                "from _accumrg38238 as restsofnomenclatures\n" +
                "\n" +
                "left outer join\n" +
                "\t(\n" +
                "\t\tselect \n" +
                "\t\t\tencode(nomenclature._idrref, 'escape') as idrnomencl,\n" +
                "\t\t\tnomenclature._code as codenomencl,\n" +
                "\t\t\tnomenclature._fld5561 as articul,\n" +
                "\t\t\tnomenclature._description as descrnomencl,\n" +
                "\t\t\tunits.descrunits as unitnomencl\n" +
                "\t\tfrom _reference215 as nomenclature\n" +
                "\t\tleft outer join\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect\n" +
                "\t\t\t\t\tencode(units._idrref, 'escape') as idrunit,\n" +
                "\t\t\t\t\tunits._description as descrunits,\n" +
                "\t\t\t\t\tencode(units._ownerid_rrref, 'escape') as masterunits\n" +
                "\t\t\t\tfrom _reference464 as units\n" +
                "\t\t\t) as units\n" +
                "\t\ton encode(nomenclature._idrref, 'escape') = units.masterunits\n" +
                "\t\twhere nomenclature._folder = true\n" +
                "\t) as nomenclature\n" +
                "on encode(restsofnomenclatures._fld38239rref, 'escape') = nomenclature.idrnomencl\n" +
                "\n" +
                "left outer join \n" +
                "\t(\n" +
                "\t\tselect \n" +
                "\t\t\tencode(specifications._idrref, 'escape') as idrspecif,\n" +
                "\t\t\tspecifications._description as descrspecif\n" +
                "\t\t\n" +
                "\t\tfrom _reference480 as specifications\n" +
                "\t\tleft outer join\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect\n" +
                "\t\t\t\t\tencode(units._idrref, 'escape') as idrunit,\n" +
                "\t\t\t\t\tunits._description as descrunits,\n" +
                "\t\t\t\t\tencode(units._ownerid_rrref, 'escape') as masterunits\n" +
                "\t\t\t\tfrom _reference464 as units\n" +
                "\t\t\t) as units\n" +
                "\t\ton encode(specifications._idrref, 'escape') = units.masterunits\n" +
                "\t) as specifications\n" +
                "on\tencode(restsofnomenclatures._fld38240rref, 'escape') = specifications.idrspecif\n" +
                "\n" +
                "GROUP BY\n" +
                "\tnomenclature.codenomencl,\n" +
                "\tnomenclature.articul,\n" +
                "\tnomenclature.descrnomencl,\n" +
                "\tnomenclature.unitnomencl,\n" +
                "\tspecifications.descrspecif",
        nativeQuery = true
    )
    fun getNomenclaturesRests(): List<NomenclaturesRests>

    @Async
    @Query(
        value = "/* NOMENCLATURES RESTS */\n" +
                "select\n" +
                "\tnomenclature.codenomencl as _code,\n" +
                "\tnomenclature.articul as _articul,\n" +
                "\tnomenclature.descrnomencl as _nomenclature,\n" +
                "\tnomenclature.unitnomencl as _unit,\n" +
                "\tspecifications.descrspecif as _specification,\n" +
                "\tSUM(case\n" +
                "\t\twhen restsofnomenclatures._recordkind = 0\n" +
                "\t\t\tthen restsofnomenclatures._fld38245 \n" +
                "\t\telse restsofnomenclatures._fld38245 * (-1)\n" +
                "\tend) as _currentrests\n" +
                "from _accumrg38238 as restsofnomenclatures\n" +
                "\n" +
                "left outer join\n" +
                "\t(\n" +
                "\t\tselect \n" +
                "\t\t\tencode(nomenclature._idrref, 'escape') as idrnomencl,\n" +
                "\t\t\tnomenclature._code as codenomencl,\n" +
                "\t\t\tnomenclature._fld5561 as articul,\n" +
                "\t\t\tnomenclature._description as descrnomencl,\n" +
                "\t\t\tunits.descrunits as unitnomencl\n" +
                "\t\tfrom _reference215 as nomenclature\n" +
                "\t\tleft outer join\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect\n" +
                "\t\t\t\t\tencode(units._idrref, 'escape') as idrunit,\n" +
                "\t\t\t\t\tunits._description as descrunits,\n" +
                "\t\t\t\t\tencode(units._ownerid_rrref, 'escape') as masterunits\n" +
                "\t\t\t\tfrom _reference464 as units\n" +
                "\t\t\t) as units\n" +
                "\t\ton encode(nomenclature._idrref, 'escape') = units.masterunits\n" +
                "\t\twhere nomenclature._folder = true\n" +
                "\t) as nomenclature\n" +
                "on encode(restsofnomenclatures._fld38239rref, 'escape') = nomenclature.idrnomencl\n" +
                "\n" +
                "left outer join \n" +
                "\t(\n" +
                "\t\tselect \n" +
                "\t\t\tencode(specifications._idrref, 'escape') as idrspecif,\n" +
                "\t\t\tspecifications._description as descrspecif\n" +
                "\t\t\n" +
                "\t\tfrom _reference480 as specifications\n" +
                "\t\tleft outer join\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect\n" +
                "\t\t\t\t\tencode(units._idrref, 'escape') as idrunit,\n" +
                "\t\t\t\t\tunits._description as descrunits,\n" +
                "\t\t\t\t\tencode(units._ownerid_rrref, 'escape') as masterunits\n" +
                "\t\t\t\tfrom _reference464 as units\n" +
                "\t\t\t) as units\n" +
                "\t\ton encode(specifications._idrref, 'escape') = units.masterunits\n" +
                "\t) as specifications\n" +
                "on\tencode(restsofnomenclatures._fld38240rref, 'escape') = specifications.idrspecif\n" +
                "\n" +
                "where restsofnomenclatures._period < :date\n" +
                "\n" +
                "GROUP BY\n" +
                "\tnomenclature.codenomencl,\n" +
                "\tnomenclature.articul,\n" +
                "\tnomenclature.descrnomencl,\n" +
                "\tnomenclature.unitnomencl,\n" +
                "\tspecifications.descrspecif",
        nativeQuery = true
    )
    fun getNomenclaturesRestsOnDate(@Param("date") date: String): List<NomenclaturesRests>
}