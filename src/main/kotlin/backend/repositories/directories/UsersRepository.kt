package backend.repositories.directories

import backend.models.directories.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository: JpaRepository<Users, Long> {
    @Modifying
    @Query(
        value = "SELECT * FROM v8users WHERE rolesid = :roleid",
        nativeQuery = true
    )
    fun findInformById(@Param("roleid") roleid: Int): List<Users>

    @Modifying
    @Query(
        value = "SELECT * FROM v8users WHERE name = :name",
        nativeQuery = true
    )
    fun findInformByName(@Param("name") name: CharArray): List<Users>

}