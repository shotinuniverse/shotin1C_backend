package backend.models.directories

import com.fasterxml.jackson.annotation.JsonTypeId
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import lombok.ToString
import org.springframework.context.annotation.Bean
import javax.persistence.*

@Setter
@Getter
@Entity
@Table(name = "v8users")
@ToString
@AllArgsConstructor
data class Users(
    @Id

    @Column(name = "name") //name
    val name: String? = null,

    @Column(name = "descr") //real name
    val description: String? = null,

    @Column(name = "changed") //full name
    val dateofchanged: String? = null,

    @Column(name = "rolesid") //id role
    val idrole: Int? = null,

    @Column(name = "show") //is show?
    val isshow: Boolean? = null,

    @Column(name = "eauth") //is auth?
    val isauth: Boolean? = null,

    @Column(name = "admrole") //is administrator rule?
    val isadmin: Boolean? = null
)