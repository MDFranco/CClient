package tech.mdelgado.cclient.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import tech.mdelgado.cclient.model.Client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@SpringBootTest
public class CClientServiceTest {

    @Autowired
    CClientService cClientService;

    @Disabled
    @Test
    public void shouldAddClient_When_theDataIsCorrect() {
        //Arrange
        Client client = new Client("Michael", "Delgado", 15, "19/05/1994", "");

        //Act
        String result = cClientService.addClient(client);

        //Assert
        Assert.doesNotContain(result, "Bad", "Successfully");
//        Assert.doesNotContain(result, "Duplicate", "Successfully");
    }

    @Disabled
    @Test
    public void addDate(){
        Calendar cal = Calendar.getInstance();
        Random random = new Random();
        cal.add(Calendar.DAY_OF_MONTH, random.nextInt(50));
        cal.add(Calendar.YEAR, random.nextInt((110-24)));
        Date newDate = new Date(cal.getTimeInMillis());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormat.format(newDate));
    }
}
