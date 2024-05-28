package io.logantect.springbatch.job

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

private val FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")

@Entity
class Pay(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val amount: Long,
    val txName: String,
    val txDateTime: LocalDateTime,
) {
    constructor(
        amount: Long,
        txName: String,
        txDateTime: String,
    ) : this(null, amount, txName, LocalDateTime.parse(txName, FORMATTER))

    override fun toString(): String {
        return "Pay(id=$id, amount=$amount, txName=$txName, txDateTime=$txDateTime)"
    }


}