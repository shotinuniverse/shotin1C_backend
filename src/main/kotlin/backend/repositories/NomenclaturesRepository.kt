package backend.repositories

import backend.models.Nomenclatures
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface NomenclaturesRepository: JpaRepository<Nomenclatures, Long> {
//    @Modifying
//    @Query(
//        value = "SELECT sha.sha1_password FROM passwordsandhashessha1 AS sha WHERE sha.sha1_hash = :valueHash",
//        nativeQuery = true
//    )
//    fun findPasswordByHash(@Param("valueHash") valueHash: String): List<PassAndHashSHA1>

}