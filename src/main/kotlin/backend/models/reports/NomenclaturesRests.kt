package backend.models.reports

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
@ToString
@AllArgsConstructor
data class NomenclaturesRests(
    @Id

    @Column(name = "_code") //code
    val code: String? = null,

    @Column(name = "_article") //name
    val article: String? = null,

    @Column(name = "_nomenclature") //name
    val description: String? = null,

    @Column(name = "_unit") //full name
    val unit: String? = null,

    @Column(name = "_specification") //article
    val specification: String? = null,

    @Column(name = "_currentrests") //is folder?
    val rest: Int? = null

)