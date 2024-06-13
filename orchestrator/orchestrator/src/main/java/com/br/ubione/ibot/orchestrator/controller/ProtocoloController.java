package com.br.ubione.ibot.orchestrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.ubione.ibot.orchestrator.service.OrchestratorService;
import com.br.ubione.ibot.orchestrator.utils.GeraProtocolo;
import com.br.ubione.ibot.orchestrator.vo.JSONInput;
import com.br.ubione.ibot.orchestrator.vo.JSONTranfereFilaInput;
import com.br.ubione.ibot.orchestrator.vo.TicketResponseVO;
import com.br.ubione.ibot.orchestrator.vo.TicketVO;

@RestController
@RequestMapping("/protocolo")
public class ProtocoloController {

	GeraProtocolo geraProtocolo = new GeraProtocolo();
	
	@Autowired
	private OrchestratorService orchestratorService;
	
	@CrossOrigin
	@GetMapping("")
	public String gerarProtocolo(@RequestParam(required = true) String celphone) {
		return geraProtocolo.generateUniqueAlphanumeric(celphone);
	}
	
	@CrossOrigin
	@PostMapping("")
	public TicketVO getListTickets(@RequestBody JSONInput jsonInput) {
		return orchestratorService.recuperaTodasAsConversas(jsonInput.getUrl(), jsonInput.getToken());
	}
	
	@CrossOrigin
	@PostMapping("/ticket/id")
	public TicketResponseVO getTicketId(@RequestBody JSONInput jsonInput) {
		TicketVO ticketVo = orchestratorService.recuperaTodasAsConversas(jsonInput.getUrl(), jsonInput.getToken());
		return orchestratorService.recuperaIdConversaEspecifica(jsonInput.getProtocolo(), ticketVo);
	}
	
	@CrossOrigin
	@PostMapping("/changeQueue")
	public boolean mudaFila(@RequestBody JSONTranfereFilaInput jsonInput) {
		return orchestratorService.transfereFila(jsonInput);
	}
}
