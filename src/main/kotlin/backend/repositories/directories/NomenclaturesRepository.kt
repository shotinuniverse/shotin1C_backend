package backend.repositories.directories

import backend.models.directories.Nomenclatures
import backend.models.reports.NomenclaturesRests
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface NomenclaturesRepository: JpaRepository<Nomenclatures, Long> {

}