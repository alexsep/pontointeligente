package com.example.pontointeligente.services

import com.example.pontointeligente.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import java.awt.print.Pageable

interface LancamentoService {
    fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento>
    fun buscarPorId(id: String): Lancamento?
    fun persistir(lancamento: Lancamento): Lancamento
    fun remover(id: String)
}