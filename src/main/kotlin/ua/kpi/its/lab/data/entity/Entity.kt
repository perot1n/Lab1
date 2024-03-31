package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.util.*

@Entity
data class MobilePhone(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val brand: String,
    val manufacturer: String,
    val model: String,
    val memorySize: Int,
    val price: Double,
    val manufacturingDate: Date,
    val dualSim: Boolean,

    @OneToMany(mappedBy = "mobilePhone", cascade = [CascadeType.ALL], orphanRemoval = true)
    val files: MutableList<File> = mutableListOf()
) : Comparable<MobilePhone> {
    override fun compareTo(other: MobilePhone): Int {
        val brandComparison = brand.compareTo(other.brand)
        return if (brandComparison != 0) brandComparison else id.compareTo(other.id)
    }
}

@Entity
data class File(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val extension: String,
    val size: Long,
    val creationDate: Date,
    val isPhoto: Boolean,

    @ManyToOne
    @JoinColumn(name = "mobile_phone_id")
    val mobilePhone: MobilePhone
) : Comparable<File> {
    override fun compareTo(other: File): Int {
        val nameComparison = name.compareTo(other.name)
        return if (nameComparison != 0) nameComparison else id.compareTo(other.id)
    }
}