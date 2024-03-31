package ua.kpi.its.lab.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import ua.kpi.its.lab.data.entity.File
import ua.kpi.its.lab.data.entity.MobilePhone

interface MobilePhoneRepository : JpaRepository<MobilePhone, Long> {
    // дополнительные методы, если нужно
}

interface FileRepository : JpaRepository<File, Long> {
    // дополнительные методы, если нужно
}