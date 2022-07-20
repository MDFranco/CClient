package tech.mdelgado.cclient.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.mdelgado.cclient.model.Client;
import tech.mdelgado.cclient.repository.CClientRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
@Log4j2
public class CClientServiceImpl implements CClientService {

    @Autowired
    CClientRepository cClientRepository;

    @Override
    public String addClient(Client client) {
        String result = new String();

        try {
            Client clientFind = cClientRepository.findClientByFirstNameAndLastName(client.getFirstName(), client.getLastName());

            log.info("Client Exist : {}", clientFind != null);
            if (clientFind == null) {
                Calendar cal = Calendar.getInstance();
                Random random = new Random();
                cal.add(Calendar.DAY_OF_MONTH, random.nextInt(client.getAge()));
                cal.add(Calendar.MONTH, random.nextInt(client.getAge()));
                cal.add(Calendar.YEAR, random.nextInt((110 - client.getAge())));
                Date dateEnd = new Date(cal.getTimeInMillis());
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                client.setProbableDateDeath(dateFormat.format(dateEnd));
                log.info("Client save : {}", client.toString());
                cClientRepository.save(client);
                result = "Good";
            } else {
                result = "Duplicate";
            }
        } catch (Exception e) {
            log.error("Error addClient", e);
            result = "Bad";
        }
        log.info("Result: {}", result);
        return result;
    }
}
