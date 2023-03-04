package com.rs.ws.service.impl;

import com.rs.ws.dto.PaymentProcessDto;
import com.rs.ws.dto.wsraspay.CustomerDto;
import com.rs.ws.dto.wsraspay.OrderDto;
import com.rs.ws.dto.wsraspay.PayentDto;
import com.rs.ws.exception.BusinessException;
import com.rs.ws.integration.MailIntegration;
import com.rs.ws.integration.WsRaspayIntegration;
import com.rs.ws.mapper.UserPaymentInfoMapper;
import com.rs.ws.mapper.wsraspay.CreditCardMapper;
import com.rs.ws.mapper.wsraspay.CustomerMapper;
import com.rs.ws.mapper.wsraspay.OrderMapper;
import com.rs.ws.mapper.wsraspay.PaymentMapper;
import com.rs.ws.model.Users;
import com.rs.ws.repository.UserPaymenteInfoRepository;
import com.rs.ws.repository.UserRepository;
import com.rs.ws.service.PaymentInfoService;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class PaymentInfoServiceImpl implements PaymentInfoService {
    private final UserRepository userRepository;
    private final UserPaymenteInfoRepository userPaymenteInfoRepository;
    private final WsRaspayIntegration wsRaspayIntegration;
    private final MailIntegration mailIntegration;
    PaymentInfoServiceImpl(UserRepository userRepository, UserPaymenteInfoRepository userPaymenteInfoRepository,WsRaspayIntegration wsRaspayIntegration,MailIntegration mailIntegration) {
    this.userRepository = userRepository;
    this.userPaymenteInfoRepository = userPaymenteInfoRepository;
    this.wsRaspayIntegration = wsRaspayIntegration;
    this.mailIntegration = mailIntegration;
    }

    @Override
    public Boolean process(PaymentProcessDto dto) {
        var userOpt = userRepository.findById(dto.getUserPaymentInfoDto().getUserId());

        if (userOpt.isPresent()) {
            Users user = userOpt.get();
            if (Objects.nonNull(user.getSubscriptionType())){
                    throw new BusinessException("Pagamento não pode ser efetuado, usuario ja possui assinatura");
            }
            CustomerDto customerDto = wsRaspayIntegration.createCustomer(CustomerMapper.build(user));
            OrderDto orderDto = wsRaspayIntegration.createOrder(OrderMapper.build(customerDto.getId(),dto));
            PayentDto payentDto = PaymentMapper.build(customerDto.getId(),orderDto.getId(), CreditCardMapper.build(dto.getUserPaymentInfoDto(),user.getCpf()));
            Boolean processPayment = wsRaspayIntegration.processPayment(payentDto);
            if (Boolean.TRUE.equals(processPayment)) {
                userPaymenteInfoRepository.save(UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentInfoDto(), user));
                mailIntegration.sendMail("davisarse@gmail.com","Usuário"+ user.getName()+"seja bem","Acesso Liberado");

            }
            return true;
        }
        return false;
    }
}
