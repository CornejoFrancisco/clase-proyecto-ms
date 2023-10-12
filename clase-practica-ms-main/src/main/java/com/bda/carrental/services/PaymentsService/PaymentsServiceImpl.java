package com.bda.carrental.services.PaymentsService;

import com.bda.carrental.entities.Payments;
import com.bda.carrental.entities.dto.PaymentsDto;
import com.bda.carrental.entities.dto.transformations.PaymentsMapper.PaymentsDtoMapper;
import com.bda.carrental.entities.dto.transformations.PaymentsMapper.PaymentsMapper;
import com.bda.carrental.repositories.PaymentsRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PaymentsServiceImpl implements PaymentsService {
    private final PaymentsRespository paymentsRespository;
    private final PaymentsDtoMapper paymentsDtoMapper;
    private final PaymentsMapper paymentsMapper;

    public PaymentsServiceImpl(PaymentsRespository paymentsRespository,
                               PaymentsDtoMapper paymentsDtoMapper,
                               PaymentsMapper paymentsMapper) {
        this.paymentsRespository = paymentsRespository;
        this.paymentsDtoMapper = paymentsDtoMapper;
        this.paymentsMapper = paymentsMapper;
    }

    @Override
    public void add(PaymentsDto entity) {
        Payments payments = new Payments();
        payments.setPaymentDate(entity.getPaymentDate());
        payments.setId(entity.getId());
        payments.setCarRentalId(entity.getCarRentalId());
        payments.setTotalPaid(entity.getTotalPaid());

    }

    @Override
    public PaymentsDto getById(Long id){
        Optional<Payments> value = paymentsRespository.findById(id);
        return value
                .map(paymentsDtoMapper)
                .orElseThrow();
    }
    @Override
    public List<PaymentsDto> getAll() {
        List<Payments> values = paymentsRespository.findAll();
        return values
                .stream()
                .map(paymentsDtoMapper)
                .toList();
    }

    @Override
    public PaymentsDto delete(Long id) {
        Optional<Payments> optionalPayments = paymentsRespository
                .findById(id);
        optionalPayments.ifPresent(paymentsRespository::delete);
        return optionalPayments
                .map(paymentsDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(PaymentsDto entity){
        Optional<Payments> paymentsObjet = Stream.of(entity).map(paymentsMapper).findFirst();
        paymentsObjet.ifPresent(paymentsRespository::save);
    }
}
