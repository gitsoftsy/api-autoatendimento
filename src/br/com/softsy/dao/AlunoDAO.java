package br.com.softsy.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.softsy.conn.Conexao;
import br.com.softsy.model.AlunoObtemCobrancasRequest;
import br.com.softsy.model.AlunoObtemCobrancasResponse;
import br.com.softsy.model.ListaCartoesAlunoRequest;
import br.com.softsy.model.ListaCartoesAlunoResponse;

public class AlunoDAO {
	
	public AlunoObtemCobrancasResponse obtemCobrancas(AlunoObtemCobrancasRequest aluno) {
		AlunoObtemCobrancasResponse retorno = new AlunoObtemCobrancasResponse();
		Connection conn = null;
		CallableStatement callableStatement = null;
		String proc = "{call (?)}";
		try {
			conn = Conexao.conectarLyceum();
			callableStatement = conn.prepareCall(proc);

			callableStatement.setString(1, aluno.getAluno());
			callableStatement.setString(2, aluno.getCpf());
			callableStatement.setBoolean(3, aluno.getaVencer());
			callableStatement.setBoolean(4, aluno.getVencidas());

			ResultSet rs = callableStatement.executeQuery();

			while (rs.next()) {
				retorno.setAluno(rs.getString("ALUNO"));
				retorno.setAno(rs.getLong("ANO"));
				retorno.setCobranca(rs.getLong("COBRANCA"));
				retorno.setDataVencimento(rs.getString("DT_VENCIMENTO"));
				retorno.setDtVencDesconto(rs.getString("DT_DESCONTO"));
				retorno.setMes(rs.getLong("ANO"));
				retorno.setMsg(rs.getString("MENSAGEM"));
				retorno.setPossuiCobrancasVencidas(rs.getBoolean("COBRANCA_VENC"));
				retorno.setResp(rs.getString("RESP"));
				retorno.setTipoCobranca(rs.getString("STATUS_COB"));
				retorno.setValorDesconto(rs.getBigDecimal("VALOR_DESC"));
				retorno.setValorFaturado(rs.getBigDecimal("VALOR_FAT"));
				retorno.setValorPagar(rs.getBigDecimal("VALOR_PGTO"));
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
//			retorno.setMsg("Erro: " + e.getMessage());
		} finally {
			try {
				Conexao.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return retorno;
	}
	
	public List<ListaCartoesAlunoResponse> listaCartoesAluno(ListaCartoesAlunoRequest aluno) {
		List<ListaCartoesAlunoResponse> retorno = new ArrayList<ListaCartoesAlunoResponse>();
		Connection conn = null;
		CallableStatement callableStatement = null;
		String proc = "{call PSCU_AAUT_PAGSUMARE_LISTA_CARTOES_SALVOS (?)}";
		try {
			conn = Conexao.conectarLyceum();
			callableStatement = conn.prepareCall(proc);

			callableStatement.setString(1, aluno.getAluno());

			ResultSet rs = callableStatement.executeQuery();

			while (rs.next()) {
				ListaCartoesAlunoResponse item = new ListaCartoesAlunoResponse();
				item.setAluno(rs.getString("ALUNO"));
				item.setIdCartao(rs.getString("ID"));
				item.setNumCartao(rs.getString("NUM"));
				item.setOrdem(rs.getString("ORDEM"));
				retorno.add(item);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
//			retorno.setMsg("Erro: " + e.getMessage());
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
