package backend.models.directories

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

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