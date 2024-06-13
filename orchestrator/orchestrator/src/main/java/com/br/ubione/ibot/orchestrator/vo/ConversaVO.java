package com.br.ubione.ibot.orchestrator.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConversaVO {
	 private int id;
	 private String status;
	 private int unreadMessages;
	 private String lastMessage;
	 private boolean isGroup;
	 private Integer userId;
	 private int contactId;
	 private int whatsappId;
	 private int queueId;
	 private boolean chatbot;
	 private Integer queueOptionId;
	 private int companyId;
	 private String uuid;
	 private boolean useIntegration;
	 private Integer integrationId;
	 private String typebotSessionId;
	 private boolean typebotStatus;
	 private Integer promptId;
	 private boolean fromMe;
	 private int amountUsedBotQueues;
	 private String createdAt;
	 private String updatedAt;
}
