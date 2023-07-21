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
import br.com.softsy.model.DisciplinaMatriculaAlunoResponse;
import br.com.softsy.model.GeraProtocoloFinanceiroResponse;
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
		} finally {
			try {
				Conexao.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return retorno;
	}
	
	public String deletaCartao(ListaCartoesAlunoRequest aluno) {
		Connection conn = null;
		CallableStatement callableStatement = null;
 		String retorno = new String();
		
		String proc = "{call PSCU_AAUT_DELETA_CARTOES_SALVOS (?,?)}";
		try {
			conn = Conexao.conectarLyceum();
			callableStatement = conn.prepareCall(proc);

			callableStatement.setString(1, aluno.getAluno());
			callableStatement.setString(1, aluno.getCartao());

			callableStatement.executeQuery();
			
			retorno = "Sucesso";

		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		} finally {
			try {
				Conexao.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}
	
	public String definirCartaoPrincial(ListaCartoesAlunoRequest aluno) {
		Connection conn = null;
		CallableStatement callableStatement = null;
 		String retorno = new String();
		
		String proc = "{call PSCU_AAUT_DEFENIR_CARTAO_PRINCIPAL (?,?)}";
		try {
			conn = Conexao.conectarLyceum();
			callableStatement = conn.prepareCall(proc);

			callableStatement.setString(1, aluno.getAluno());
			callableStatement.setString(1, aluno.getCartao());

			callableStatement.executeQuery();

			retorno = "Sucesso";
					
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		} finally {
			try {
				Conexao.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}
	
	public GeraProtocoloFinanceiroResponse geraProtocoloAtendiemento(ListaCartoesAlunoRequest aluno) {
		Connection conn = null;
		CallableStatement callableStatement = null;
		GeraProtocoloFinanceiroResponse retorno = new GeraProtocoloFinanceiroResponse();
		
		String proc = "{call PSCU_AAUT_GERA_PROTOCOLO_ATENDIMENTO (?)}";
		
		try {
			conn = Conexao.conectarLyceum();
			callableStatement = conn.prepareCall(proc);

			callableStatement.setString(1, aluno.getAluno());

			ResultSet rs = callableStatement.executeQuery();

			while (rs.next()) {
				retorno.setIdProtocolo(rs.getLong("ID_PROTOCOLO"));
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

	public String definirMeioPagto(ListaCartoesAlunoRequest aluno) {
		Connection conn = null;
		CallableStatement callableStatement = null;
 		String retorno = new String();
		
		String proc = "{call PSCU_AAUT_DEFINIR_PLANO_PAGAMENTO (?,?)}";
		try {
			conn = Conexao.conectarLyceum();
			callableStatement = conn.prepareCall(proc);

			callableStatement.setString(1, aluno.getAluno());
			callableStatement.setString(1, aluno.getTipo());

			callableStatement.executeQuery();

			retorno = "Sucesso";
					
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		} finally {
			try {
				Conexao.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	public String abrSolValoresIndevidos(ListaCartoesAlunoRequest aluno) {
		Connection conn = null;
		CallableStatement callableStatement = null;
 		String retorno = new String();
		
		String proc = "{call PSCU_AAUT_COBRANCA_VALOR_INDEVIDO (?,?)}";
		try {
			conn = Conexao.conectarLyceum();
			callableStatement = conn.prepareCall(proc);

			callableStatement.setString(1, aluno.getAluno());
			callableStatement.setLong(1, aluno.getCobranca());
			callableStatement.setString(1, aluno.getObs());

			callableStatement.executeQuery();

			retorno = "Sucesso";
					
		} catch (Exception e) {
			e.printStackTrace();
			retorno = null;
		} finally {
			try {
				Conexao.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}
	
	public List<DisciplinaMatriculaAlunoResponse> listaMatrAluno(ListaCartoesAlunoRequest aluno) {
		List<DisciplinaMatriculaAlunoResponse> retorno = new ArrayList<DisciplinaMatriculaAlunoResponse>();
		Connection conn = null;
		CallableStatement callableStatement = null;
		String proc = "{call PSCU_AAUT_DISCIPLINA_MATRICULADA_ALUNO (?)}";
		try {
			conn = Conexao.conectarLyceum();
			callableStatement = conn.prepareCall(proc);

			callableStatement.setString(1, aluno.getAluno());

			ResultSet rs = callableStatement.executeQuery();

			while (rs.next()) {
				DisciplinaMatriculaAlunoResponse item = new DisciplinaMatriculaAlunoResponse();
				item.setAluno(rs.getString("ALUNO"));
				item.setTurma(rs.getString("TURMA"));
				item.setDisciplina(rs.getString("DISCIPLINA"));
				item.setNomeDisciplina(rs.getString("NOME_DISCIPLINA"));
				item.setDataMatricula(rs.getDate("DT_MATRICULA"));
				retorno.add(item);
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
