package com.rs.ws.service.impl;

import com.rs.ws.dto.SubscriptionTypeDto;
import com.rs.ws.exception.BadRequest;
import com.rs.ws.exception.NotFoundException;
import com.rs.ws.mapper.SubscriptionTypeMapper;
import com.rs.ws.model.SubscriptionType;
import com.rs.ws.repository.SubscriptionTypeRepository;
import com.rs.ws.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubcriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;
    SubcriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository){
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }
    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
      return getSubscriptionType(id);
    }


    @Override
    public SubscriptionType create(SubscriptionTypeDto subscriptionTypeDto) {
        senDifNull(subscriptionTypeDto);
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(subscriptionTypeDto));
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto subscriptionTypeDto) {
        senDifNull(subscriptionTypeDto);
        getSubscriptionType(id);
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(subscriptionTypeDto));
    }



    @Override
    public void delete(Long id) {
        getSubscriptionType(id);
        subscriptionTypeRepository.deleteById(id);
    }
    private static void senDifNull(SubscriptionTypeDto subscriptionTypeDto) {
        if (!Objects.isNull(subscriptionTypeDto.getId())){
            throw  new BadRequest("Não é necessario id no corpo da requisição");
        }
    }
    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = subscriptionTypeRepository.findById(id);
        if (optionalSubscriptionType.isPresent()) {
            return optionalSubscriptionType.get();
        }
        throw new NotFoundException("Subscription_type não encontrado");
    }
}
