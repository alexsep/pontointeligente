package com.example.pontointeligente.services

import com.example.pontointeligente.documents.Empresa
import com.example.pontointeligente.repositories.EmpresaRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureDataMongo
class EmpresaServiceTest {

    @Autowired
    val empresaService: EmpresaService? = null

    @MockBean
    private val empresaRepository: EmpresaRepository? = null

    private val CNPJ = "51463645000100"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(empresaRepository?.findByCnpj(CNPJ)).willReturn(empresa())
        BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun buscarEmpresaPorCnpjTest(){
        val empresa: Empresa? = empresaService?.buscarPorCnpj(CNPJ)
        Assertions.assertNotNull(empresa)
    }

    @Test
    fun persistirEmpresaTest(){
        val empresa: Empresa? = empresaService?.persistir(empresa())
        Assertions.assertNotNull(empresa)
    }

    private fun empresa(): Empresa = Empresa("Razão Social", CNPJ, "1")

}