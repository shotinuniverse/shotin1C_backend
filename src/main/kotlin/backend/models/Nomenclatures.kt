package backend.models

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.persistence.*

@Setter
@Getter
@Entity
@Table(name = "_Reference215")
@ToString
@AllArgsConstructor
data class Nomenclatures(
    @Column(name = "_Code") //code
    val code: String? = null,

    @Column(name = "_Description") //name
    val description: String? = null,

    @Column(name = "_Fld5560") //full name
    val fullName: String? = null,

    @Column(name = "_Fld5561") //article
    val article: String? = null,

    @Column(name = "_Folder") //is folder?
    val isfolder: Boolean? = null
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    val id: Int? = null
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "sha1_id")
//    val id: Int? = null,
//
//    @Column(name = "sha1_password")
//    val password: String? = null,
//
//    @Column(name = "sha1_hash")
//    val hash: String? = null
)