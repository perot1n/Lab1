package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.File
import ua.kpi.its.lab.data.entity.MobilePhone

interface MobilePhoneService {
    fun create(mobilePhone: MobilePhone): MobilePhone
    fun retrieve(id: Long): MobilePhone?
    fun update(mobilePhone: MobilePhone): MobilePhone
    fun delete(id: Long)
}

interface FileService {
    fun create(file: File): File
    fun retrieve(id: Long): File?
    fun update(file: File): File
    fun delete(id: Long)
}