package br.com.softsy.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.softsy.conn.Conexao;
import br.com.softsy.model.LoginResponse;

public class LoginDAO {
	
	public LoginResponse autenticacaoAluno(String aluno) {
		LoginResponse retorno = new LoginResponse();
		Connection conn = null;
		CallableStatement callableStatement = null;
		String proc = "{call PSCU_AAUT_DADOS_ALUNO(?)}";
		try {
			conn = Conexao.conectarLyceum();
			callableStatement = conn.prepareCall(proc);
			
			callableStatement.setString(1, aluno);
			
			ResultSet rs = callableStatement.executeQuery();

			while (rs.next()) {
				retorno.setAluno(rs.getString("ALUNO"));
				retorno.setNome(rs.getString("NOME_COMPL"));
				retorno.setAtivo(rs.getString("ATIVO"));
				retorno.setCobrancasVencer(rs.getString("POSSUI_COBRANCAS_A_VENCER"));
				retorno.setCobrancasVencidas(rs.getString("POSSUI_COBRANCAS_VENCIDAS"));
				retorno.setSitAluno(rs.getString("SIT_ALUNO"));
				retorno.setCurso(rs.getString("CURSO"));
				retorno.setDocPendente(rs.getString("POSSUI_DOC_PENDENTE"));
				retorno.setEmail(rs.getString("E_MAIL"));
				retorno.setCelular(rs.getString("CELULAR"));
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				Conexao.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return retorno;
	}

}
