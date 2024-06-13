package com.br.ubione.ibot.orchestrator.service;

import com.br.ubione.ibot.orchestrator.vo.JSONTranfereFilaInput;
import com.br.ubione.ibot.orchestrator.vo.TicketResponseVO;
import com.br.ubione.ibot.orchestrator.vo.TicketVO;

public interface OrchestratorService {

	public TicketVO recuperaTodasAsConversas(String url, String bearerToken);
	
	public TicketResponseVO recuperaIdConversaEspecifica(String protocolo, TicketVO ticket);
	
	public boolean transfereFila(JSONTranfereFilaInput input);
	
}
