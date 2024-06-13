package com.br.ubione.ibot.orchestrator.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.ubione.ibot.orchestrator.service.OrchestratorService;
import com.br.ubione.ibot.orchestrator.vo.ConversaVO;
import com.br.ubione.ibot.orchestrator.vo.JSONTranfereFilaInput;
import com.br.ubione.ibot.orchestrator.vo.TicketResponseVO;
import com.br.ubione.ibot.orchestrator.vo.TicketVO;

@Service
public class OrchestratorServiceImpl implements OrchestratorService{
	
	private final RestTemplate restTemplate;
		
	public OrchestratorServiceImpl() {
		this.restTemplate = new RestTemplate();
	}
	
	@Override
	public TicketVO recuperaTodasAsConversas(String url, String bearerToken) {
		HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(bearerToken);

        // Criar a entidade HTTP com os cabeçalhos
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        // Fazer a solicitação GET
        ResponseEntity<TicketVO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                TicketVO.class);
        
        TicketVO ticketVO = response.getBody();
        
        return ticketVO;
	}

	@Override
	public TicketResponseVO recuperaIdConversaEspecifica(String protocolo, TicketVO ticket) {
		TicketResponseVO ticketResponseVO = new TicketResponseVO();
		for(ConversaVO conversa: ticket.getTickets()) {
			if (conversa.getLastMessage().trim().equals(protocolo)) {
				ticketResponseVO.setCompanyId(conversa.getCompanyId());
				ticketResponseVO.setContactId(conversa.getContactId());
				ticketResponseVO.setQueueId(conversa.getQueueId());
				ticketResponseVO.setStatus("pending");
				ticketResponseVO.setUserId(null);
				ticketResponseVO.setWhatsappId(conversa.getWhatsappId());
			}
		}
		return ticketResponseVO;
	}

	@Override
	public boolean transfereFila(JSONTranfereFilaInput input) {
		try {
			HttpHeaders headers = new HttpHeaders();
	        headers.setBearerAuth(input.getToken());
	        headers.set("Content-Type", "application/json");
	
	        TicketResponseVO data = new TicketResponseVO();
	        data.setCompanyId(input.getCompanyId());
	        data.setContactId(input.getContactId());
	        data.setQueueId(input.getQueueId());
	        data.setStatus(input.getStatus());
	        data.setUserId(input.getUserId());
	        data.setWhatsappId(input.getWhatsappId());
	        
	        
	        // Criar a entidade HTTP com os cabeçalhos
	        HttpEntity<TicketResponseVO> entity = new HttpEntity<>(data,headers);
	        
	        // Fazer a solicitação GET
	        ResponseEntity<String> response = restTemplate.exchange(
	        		input.getUrl(),
	                HttpMethod.POST,
	                entity,
	                String.class);
	        
	        return true;
		}catch (Exception e) {
			return false;
		}
	}

}
