package ua.kpi.its.lab.data.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.File
import ua.kpi.its.lab.data.entity.MobilePhone
import ua.kpi.its.lab.data.repo.FileRepository
import ua.kpi.its.lab.data.repo.MobilePhoneRepository
import ua.kpi.its.lab.data.svc.FileService
import ua.kpi.its.lab.data.svc.MobilePhoneService

@Service
class MobilePhoneServiceImpl(private val repo: MobilePhoneRepository) : MobilePhoneService {
    override fun create(mobilePhone: MobilePhone) = repo.save(mobilePhone)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(mobilePhone: MobilePhone) = repo.save(mobilePhone)
    override fun delete(id: Long) = repo.deleteById(id)
}

@Service
class FileServiceImpl(private val repo: FileRepository) : FileService {
    override fun create(file: File) = repo.save(file)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(file: File) = repo.save(file)
    override fun delete(id: Long) = repo.deleteById(id)
}