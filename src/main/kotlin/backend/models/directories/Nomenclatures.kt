package backend.models.directories

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.persistence.*

@Setter
@Getter
@Entity
@Table(name = "_reference215")
@ToString
@AllArgsConstructor
data class Nomenclatures(
    @Id

    @Column(name = "_code") //code
    val code: String? = null,

    @Column(name = "_description") //name
    val description: String? = null,

    @Column(name = "_fld5560") //full name
    val fullName: String? = null,

    @Column(name = "_fld5561") //article
    val article: String? = null,

    @Column(name = "_folder") //is folder?
    val isnotfolder: Boolean? = null

)