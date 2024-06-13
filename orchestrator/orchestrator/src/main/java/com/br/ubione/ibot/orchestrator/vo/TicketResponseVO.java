package com.br.ubione.ibot.orchestrator.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseVO {
	private Integer contactId;
	private String status;
	private Integer userId;
	private Integer companyId;
	private Integer queueId;
	private Integer whatsappId;
}
