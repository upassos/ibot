package com.br.ubione.ibot.orchestrator.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketVO {

	private List<ConversaVO> tickets;
	
}
