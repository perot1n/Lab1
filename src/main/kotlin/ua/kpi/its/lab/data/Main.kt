package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.entity.File
import ua.kpi.its.lab.data.entity.MobilePhone
import ua.kpi.its.lab.data.svc.impl.FileServiceImpl
import ua.kpi.its.lab.data.svc.impl.MobilePhoneServiceImpl
import java.util.*

fun main() {
    val context = AnnotationConfigApplicationContext("ua.kpi.its.lab.data")
    val mobilePhoneService = context.getBean(MobilePhoneServiceImpl::class.java)
    val fileService = context.getBean(FileServiceImpl::class.java)

    // Создаем 5 мобильных телефонов и дополнительные файлы
    val mobilePhone1 = MobilePhone(
        brand = "Apple",
        manufacturer = "Apple Inc.",
        model = "iPhone 13 Pro",
        memorySize = 256,
        price = 1099.0,
        manufacturingDate = Date(122, 8, 14),
        dualSim = false
    )
    val mobilePhone2 = MobilePhone(
        brand = "Samsung",
        manufacturer = "Samsung Electronics",
        model = "Galaxy S22 Ultra",
        memorySize = 512,
        price = 1199.0,
        manufacturingDate = Date(122, 2, 25),
        dualSim = true
    )
    val mobilePhone3 = MobilePhone(
        brand = "Google",
        manufacturer = "Google LLC",
        model = "Pixel 7 Pro",
        memorySize = 256,
        price = 899.0,
        manufacturingDate = Date(122, 10, 6),
        dualSim = false
    )
    val mobilePhone4 = MobilePhone(
        brand = "OnePlus",
        manufacturer = "OnePlus",
        model = "OnePlus 10 Pro",
        memorySize = 256,
        price = 899.0,
        manufacturingDate = Date(122, 4, 28),
        dualSim = true
    )
    val mobilePhone5 = MobilePhone(
        brand = "Xiaomi",
        manufacturer = "Xiaomi",
        model = "Xiaomi 12 Pro",
        memorySize = 256,
        price = 799.0,
        manufacturingDate = Date(122, 3, 15),
        dualSim = true
    )
    mobilePhoneService.create(mobilePhone1)
    mobilePhoneService.create(mobilePhone2)
    mobilePhoneService.create(mobilePhone3)
    mobilePhoneService.create(mobilePhone4)
    mobilePhoneService.create(mobilePhone5)

    val file1 = File(
        name = "photo1",
        extension = "jpg",
        size = 1024,
        creationDate = Date(),
        isPhoto = true,
        mobilePhone = mobilePhone1
    )

    val file2 = File(
        name = "document",
        extension = "pdf",
        size = 2048,
        creationDate = Date(),
        isPhoto = false,
        mobilePhone = mobilePhone2
    )

    fileService.create(file1)
    fileService.create(file2)

    println("Retrieved mobile phone: $mobilePhone3")

    // Удаляем мобильный телефон с индексом 4
    mobilePhoneService.delete(4)
}